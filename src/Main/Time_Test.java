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
	SimpleDateFormat fomDateFormat = new SimpleDateFormat("HH:mm"); // simple������ ���ϴ� ���·� ������� > ���ڿ�

	static SeatDTO sDTO = null;
	static SelectDAO selectDao = null;

	private Date start_time = null; // �α��� �ð�
	private Date stop_time = null; // �α׾ƿ� �ð�
	private Date date_re_time = null; // �ܿ��ð�
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

	public Date timeCalculate() { // ���� �ܿ��ð� ����ϱ� / �����ư ������� �ҰŴ�

		long_re_time = stop_time.getTime() - start_time.getTime();
		// ��� ���� ������� - ���� �α��νð� = ���ð�

		long_re_time = date_re_time.getTime() - long_re_time;
		// ���� �ܿ��ð� - ���� ���ð�

		if (long_re_time < 0) {
			System.out.println("�ð� ����");
			return null;
		}

		long_re_time /= 1000;
		long hour = long_re_time / 3600;
		long min = (long_re_time % 3600) / 60;

		String todate = hour + ":" + min;

		try {
			date_re_time = fomDateFormat.parse(todate);
			sDTO.setRemainingTime(date_re_time); // ��� ����
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

	// �ð� �� õ�� ����ϴ� �� �ֱ�

	public int changeMoney(int amountTime) {

		amountTime *= 1000;

		totalMoney = date_re_time.getHours() + amountTime;

		int change = 0;
		// ������

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