package Main.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDAO {
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
	
	public boolean PcOn(int pcnum) {
		getConnection();
		boolean pc = false;
		try {
			String sql = "update pc set pc_onoff=? where pc_num=?";
			psmt = conn.prepareStatement(sql);
			psmt.setBoolean(1, true);
			psmt.setInt(2, pcnum);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return pc;
	} // Pc켜기

	public boolean PcOff(int pcnum) {
		getConnection();
		boolean pc = false;
		try {
			String sql = "update pc set pc_onoff=? where pc_num=?";
			psmt = conn.prepareStatement(sql);
			psmt.setBoolean(1, false);
			psmt.setInt(2, pcnum);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return pc;
	} // Pc끄기

	public void PayUpdate(int Price, int addPrice, String Card, int pcnum) {
		getConnection();
		try {
			String sql = "update seat set usage_charges=?, card_num=? where pc_num=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Price + addPrice);
			psmt.setString(2, Card);
			psmt.setInt(3, pcnum);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	} // 금액충전
	
	public int quantity_update(int quantity, Object sale, String prdname) {
		getConnection();
		int row=0;
		try {
			String sql = "update product set product_quantity=?-? where product_name=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, quantity);
			psmt.setObject(2, sale);
			psmt.setString(3, prdname);
			row=psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	} // 재고관리
	
	public int quantity_update2(int quantity, String prdname) {
		getConnection();
		int row=0;
		try {
			String sql = "update product set product_quantity=?+1 where product_name=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, quantity);
			psmt.setString(2, prdname);
			row=psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	} // 재고관리(구매취소)
	
	public int chargeamount(int totalcharge, int totalprice, String memberid) {
		getConnection();
		int row=0;
		try {
			String sql = "update payment set charge_amount=?-? where member_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, totalcharge);
			psmt.setInt(2, totalprice);
			psmt.setString(3, memberid);
			row=psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return row;
	} // 음식주문후 차감금액
}
