package Main.DTO;

public class PaymentDTO {
	public static String CardNumber;
	public static String MemberId;
	public static int ChargeAmount;
	public static String CardName;
	
	public PaymentDTO() {
		
	}
	public PaymentDTO(String memberId) {
		MemberId = memberId;
	}
	public PaymentDTO(String cardNumber, String memberId, int chargeAmount) {
		CardNumber = cardNumber;
		MemberId = memberId;
		ChargeAmount = chargeAmount;
	}

	public String getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(String cardNumber) {
		CardNumber = cardNumber;
	}

	public String getMemberId() {
		return MemberId;
	}

	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public int getChargeAmount() {
		return ChargeAmount;
	}

	public void setChargeAmount(int chargeAmount) {
		ChargeAmount = chargeAmount;
	}
	
	
}
