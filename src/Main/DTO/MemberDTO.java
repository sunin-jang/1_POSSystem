package Main.DTO;

public class MemberDTO {
	public static String MemberId;
	private String MemberPw;
	private String MemberName;
	private String MemberPhoneNumber;
	
	public MemberDTO() {
		
	}

	public MemberDTO(String memberId, String memberPw, String memberName, String memberPhoneNumber) {
		MemberId = memberId;
		MemberPw = memberPw;
		MemberName = memberName;
		MemberPhoneNumber = memberPhoneNumber;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getMemberPw() {
		return MemberPw;
	}

	public void setMemberPw(String memberPw) {
		MemberPw = memberPw;
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
