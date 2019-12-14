package Main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;

import Main.DTO.MemberDTO;
import Main.DTO.OrderDTO;
import Main.DTO.PaymentDTO;
import Main.DTO.PcDTO;
import Main.DTO.ProductDTO;
import Main.DTO.SeatDTO;

public class InsertDAO {

	Calendar cal = new GregorianCalendar();
	Date date = new Date(cal.getTimeInMillis());
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";
	String Memberid;

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

	public int insert_member(MemberDTO m) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into member values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, m.getMemberId());
			psmt.setString(2, m.getMemberPw());
			psmt.setString(3, m.getMemberName());
			psmt.setString(4, m.getMemberPhoneNumber());
			row = psmt.executeUpdate();
			System.out.println("반영된 row 수 : " + row);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int insert_pc(PcDTO p) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into pc values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, p.getPcNumber());
			psmt.setBoolean(2, false);
			row = psmt.executeUpdate();
			System.out.println("반영된 row 수 : " + row);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int insert_seat(SeatDTO s) {
		getConnection();

		int row = 0;

		try {
			String sql = "insert into seat values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, s.getPcNumber());
			psmt.setDate(2, (java.sql.Date) s.getStartTime());
			psmt.setDate(3, (java.sql.Date) s.getStopTime());
			psmt.setDate(4, (java.sql.Date) s.getRemainingTime());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int insert_payment(PaymentDTO pay) {
		getConnection();
		int row = 0;
		String memid = MemberDTO.MemberId;
		try {
			String sql = "insert into payment values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pay.getCardNumber());
			psmt.setString(2, memid);
			psmt.setInt(3, pay.getChargeAmount());

			row = psmt.executeUpdate();
			System.out.println("반영된 row 수 : " + row);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int insert_product(ProductDTO p) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into product values(?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p.getProductNumber()); // 20190722001
			psmt.setString(2, p.getProductName());
			psmt.setInt(3, p.getProductPrice());
			psmt.setInt(4, p.getProductQuantity());
			psmt.setInt(5, p.getProductReQuantity());

			row = psmt.executeUpdate();
			System.out.println("반영된 row 수 : " + row);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

	public int insert_order(OrderDTO o) {
		getConnection();
		int row = 0;
		try {
			String sql = "insert into pc_order values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, o.getPcNumber());
			psmt.setString(2, o.getMemberId());
			psmt.setString(3, o.getProductName());
			psmt.setString(4, o.getCardNumber());
			psmt.setDate(5, (java.sql.Date) o.getOrderTime());
			psmt.setInt(6, o.getOrderQuantity());

			row = psmt.executeUpdate();
			System.out.println("반영된 row 수 : " + row);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	}

}
