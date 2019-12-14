package Main.DTO;

public class MemberManagementDTO { // 회원관리
	private String MemberId;
	private String MemberName;
	private String MemberPhoneNumber;
	
	public MemberManagementDTO(String memberId, String memberName, String memberPhoneNumber) {
		MemberId = memberId;
		MemberName = memberName;
		MemberPhoneNumber = memberPhoneNumber;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getMemberName() {
		return MemberName;
	}

	public void setMemberName(String memberName) {
		MemberName = memberName;
	}

	public String getMemberPhoneNumber() {
		return MemberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		MemberPhoneNumber = memberPhoneNumber;
	}
	
}
