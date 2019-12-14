package Main.DAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Main.DTO.MemberDTO;
import Main.DTO.SeatDTO;

public class SelectDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";
	
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String idconfirm(String id) {
		getConnection();
		String mem_id = null;

		String sql = "select member_id from member where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				mem_id = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return mem_id;
	}

//	public boolean PcOnoff(int pcnum) {
//		getConnection();
//		boolean pc = false;
//		
//		String sql ="select pc_onoff from pc where pc_num=?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, pcnum);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				pc = rs.getBoolean(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return pc;
//	} // pc_onoff 가져오기

	public int Pcselect(int pc) {
		getConnection();
		int pcselect = 0;

		String sql = "select pc_num from pc where pc_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pc);
			rs = psmt.executeQuery();
			if (rs.next()) {
				pcselect = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return pcselect;
	} // pc_num 가져오기
	
	public String select(String id, String pw) {
		getConnection();
		String name = null;

		String sql = "select member_name from member where member_id=? and member_pw=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}

	public MemberDTO MemberSelect(String name) {
		getConnection();
		MemberDTO m = new MemberDTO();

		String sql = "select member_id, member_name, member_phonenum from member where member_name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			if (rs.next()) {
				m.setMemberId(rs.getString(1));
				m.setMemberName(rs.getString(3));
				m.setMemberPhoneNumber(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return m;
	}

	public Vector MemberList() {
		Vector data = new Vector();

		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(3);
				String phone = rs.getString(4);

				Vector row = new Vector();
				row.add(id);
				row.add(name);
				row.add(phone);

				data.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return data;
	}

//	public String pwconfirm(String pw) {
//		getConnection();
//		String password = null;
//		
//		String sql = "select member_pw from member where pw=?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, pw);
//			rs = psmt.executeQuery();
//			if(rs.next()) {
//				password = rs.getString(1);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		
//		return password;
//}
	public Date selectstarttime(String id) {
		getConnection();
		Date starttime = null;

		String sql = "select starttime from seat where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				starttime = rs.getDate(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return starttime;
	} // 시작시간 가져옴
	
	public Date selectstoptime(String id) {
		getConnection();
		Date stoptime = null;

		String sql = "select stoptime from seat where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				stoptime = rs.getDate(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return stoptime;
	} // 종료시간 가져옴
	
	public Date selectremainingtime(String id) {
		getConnection();
		Date remainingtime = null;

		String sql = "select remainingtime from seat where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				remainingtime = rs.getDate(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return remainingtime;
	} // 잔여시간 가져옴
	
	public String selectmemberid(String id) {
		getConnection();
		String memberid = null;

		String sql = "select member_id from member where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				memberid = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberid;
	}
	
	public SeatDTO selectmemberid_sDTO(String id) {
		getConnection();
		SeatDTO s = new SeatDTO();

		String sql = "select * from seat where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				s.setPcNumber(rs.getInt(1));
				s.setMemberId(rs.getString(2));
				s.setStartTime(rs.getDate(3));
				s.setStopTime(rs.getDate(4));
				s.setRemainingTime(rs.getDate(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return s;
	}
	
	public boolean seatselect(int pcnum) {
		getConnection();
		boolean usepc = false;
		String sql = "select pc_onoff from pc where pc_num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pcnum);
			rs = psmt.executeQuery();
			if (rs.next()) {
				usepc = rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return usepc;
	} // 선택한좌석
	
	public int select_quantity(String productname) {
		getConnection();
		int product_q = 0;
		String sql = "select product_quantity from product where product_name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productname);
			rs = psmt.executeQuery();
			if (rs.next()) {
				product_q = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return product_q;
	} // 상품갯수가져오기
	
	public int select_price(String productname) {
		getConnection();
		int product_p = 0;
		String sql = "select product_price from product where product_name=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, productname);
			rs = psmt.executeQuery();
			if (rs.next()) {
				product_p = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return product_p;
	} // 상품가격가져오기
	
	public int order_product() {
		getConnection();
		int product_p = 0;
		String sql = "select * from product where product_name='새우탕'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				product_p = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return product_p;
	}
	
	public int select_total(String memberid) {
		getConnection();
		int ca = 0;
		String sql = "select sum(charge_amount) from payment where member_id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberid);
			rs = psmt.executeQuery();
			if (rs.next()) {
				ca = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ca;
	} // 충전가격 가져오기
}
