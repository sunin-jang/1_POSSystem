package Main.DTO;

public class PcDTO{
	public static int PcNumber;
	private boolean PcConfirm;
	private String MemberId;
	
	public PcDTO(int pcNumber, boolean pcConfirm, String memberId) {
		PcNumber = pcNumber;
		PcConfirm = pcConfirm;
		MemberId = memberId;
	}
	public int getPcNumber() {
		return PcNumber;
	}
	public void setPcNumber(int pcNumber) {
		PcNumber = pcNumber;
	}
	public boolean isPcConfirm() {
		return PcConfirm;
	}
	public void setPcConfirm(boolean pcConfirm) {
		PcConfirm = pcConfirm;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
}