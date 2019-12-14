package Main;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Main.DAO.SelectDAO;
import Main.DAO.UpdateDAO;
import Main.DTO.PcDTO;
import Main.DTO.SeatDTO;

public class Time_Test implements WindowListener{

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat fomDateFormat = new SimpleDateFormat("HH:mm"); // simple포멧은 원하는 형태로 출력해줌 > 문자열

	static SeatDTO sDTO = null;
	static SelectDAO selectDao = null;

	private Date start_time = null; // 로그인 시간
	private Date stop_time = null; // 로그아웃 시간
	private Date date_re_time = null; // 잔여시간
	private long long_re_time = 0;
	private int hour;
	private int min;
	private int second;
	private int totalMoney;

	public Time_Test(SelectDAO dao, SeatDTO vo) {
		selectDao = dao;
		sDTO = vo;
//      basic();

		start_time = sDTO.getStartTime();
		stop_time = sDTO.getStopTime();
		date_re_time = sDTO.getRemainingTime();

	}

	public Date timeCalculate() { // 남은 잔여시간 계산하기 / 종료버튼 누를경우 할거다

		long_re_time = stop_time.getTime() - start_time.getTime();
		// 방금 누른 종료시작 - 오늘 로그인시간 = 사용시간

		long_re_time = date_re_time.getTime() - long_re_time;
		// 전의 잔여시간 - 오늘 사용시간

		if (long_re_time < 0) {
			System.out.println("시간 소진");
			return null;
		}

		long_re_time /= 1000;
		long hour = long_re_time / 3600;
		long min = (long_re_time % 3600) / 60;

		String todate = hour + ":" + min;

		try {
			date_re_time = fomDateFormat.parse(todate);
			sDTO.setRemainingTime(date_re_time); // 디비에 저장
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date_re_time;
	}

	public Date getStart_time() {
		return start_time;
	}

	public Date getStop_time() {
		return stop_time;
	}

	public Date getDate_re_time() {
		return date_re_time;
	}

	// 시간 당 천원 계산하는 것 넣기

	public int changeMoney(int amountTime) {

		amountTime *= 1000;

		totalMoney = date_re_time.getHours() + amountTime;

		int change = 0;
		// 수정중

		return change;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int pcnum = PcDTO.PcNumber;
		UpdateDAO udao = new UpdateDAO();
		boolean pc = udao.PcOff(pcnum);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		int pcnum = PcDTO.PcNumber;
		UpdateDAO udao = new UpdateDAO();
		boolean pc = udao.PcOff(pcnum);
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}