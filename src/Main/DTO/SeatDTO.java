package Main.DTO;

import java.sql.Timestamp;
import java.util.Date;

public class SeatDTO{
	private int PcNumber;
	private String MemberId;
	private Date StartTime;
	private Date StopTime;
	private Date RemainingTime;
	
//	yen > private Date RemainingTime;
	// 잔여시간 저장할 변수 , get , set 만들기 
	public SeatDTO() {
		
	}
	
	public SeatDTO(int pcNumber, String memberId, Date startTime, Date stopTime, Date remainingTime) {
		PcNumber = pcNumber;
		MemberId = memberId;
		StartTime = startTime;
		StopTime = stopTime;
		RemainingTime = remainingTime;
	}

	public int getPcNumber() {
		return PcNumber;
	}

	public void setPcNumber(int pcNumber) {
		PcNumber = pcNumber;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	
	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getStopTime() {
		return StopTime;
	}

	public void setStopTime(Date stopTime) {
		StopTime = stopTime;
	}

	public Date getRemainingTime() {
		return RemainingTime;
	}

	public void setRemainingTime(Date remainingTime) {
		RemainingTime = remainingTime;
	}
	
}
