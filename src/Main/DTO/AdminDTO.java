package Main.DTO;

public class AdminDTO {
	private String AdminId;
	private String AdminPw;
	private String AdminName;
	private String MemberId;
	
	public AdminDTO(String adminId, String adminPw, String adminName, String memberId) {
		AdminId = adminId;
		AdminPw = adminPw;
		AdminName = adminName;
		MemberId = memberId;
	}

	public String getAdminId() {
		return AdminId;
	}

	public void setAdminId(String adminId) {
		AdminId = adminId;
	}

	public String getAdminPw() {
		return AdminPw;
	}

	public void setAdminPw(String adminPw) {
		AdminPw = adminPw;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}
	
}
