package Main.DTO;

import java.util.Date;

public class OrderDTO {
	private int PcNumber;
	private String MemberId;
	private String ProductName;
	private String CardNumber;
	private Date OrderTime;
	private int OrderQuantity;
	
	public OrderDTO() {
		
	}
	public OrderDTO(int pcNumber, String memberId, String productName, String cardNumber, Date orderTime,
			int orderQuantity) {
		PcNumber = pcNumber;
		MemberId = memberId;
		ProductName = productName;
		CardNumber = cardNumber;
		OrderTime = orderTime;
		OrderQuantity = orderQuantity;
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

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public Date getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(Date orderTime) {
		OrderTime = orderTime;
	}

	public int getOrderQuantity() {
		return OrderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		OrderQuantity = orderQuantity;
	}
	
}
