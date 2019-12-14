package Main.DTO;

public class OrderManagementDTO { // 주문관리
	public static String ProductName;
	public static int ProductPrice;
	public static int ProductQuantity;
	
	public OrderManagementDTO(String productName, int productPrice, int productQuantity) {
		ProductName = productName;
		ProductPrice = productPrice;
		ProductQuantity = productQuantity;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}

	public int getProductQuantity() {
		return ProductQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}

}
