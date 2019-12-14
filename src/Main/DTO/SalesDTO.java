package Main.DTO;

import java.util.Date;

public class SalesDTO { // ∏≈√‚
	
	private Date OrderTime;
	private int PcNumber;
	private String ProductName;
	private int ProductQuantity;
	
	public SalesDTO(Date orderTime, int pcNumber, String productName, int productQuantity) {
		OrderTime = orderTime;
		PcNumber = pcNumber;
		ProductName = productName;
		ProductQuantity = productQuantity;
	}

	public Date getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(Date orderTime) {
		OrderTime = orderTime;
	}

	public int getPcNumber() {
		return PcNumber;
	}

	public void setPcNumber(int pcNumber) {
		PcNumber = pcNumber;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

}
