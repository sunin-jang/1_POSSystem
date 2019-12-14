package Main.DTO;

import java.util.Date;

public class ProductDTO {
	private String ProductNumber;
	public static String ProductName;
	private int ProductPrice;
	private int ProductQuantity;
	private int ProductReQuantity;
	public static int Productprice=0;
	public static int ProductTotalPrice=0;

	public ProductDTO() {
		
	}
	public ProductDTO(String productNumber, String productName, int productPrice, int productQuantity,
			int productReQuantity) {
		ProductNumber = productNumber;
		ProductName = productName;
		ProductPrice = productPrice;
		ProductQuantity = productQuantity;
		ProductReQuantity = productReQuantity;
	}

	public int productTotalPrice(int productprice) {
		ProductTotalPrice += productprice;
		return ProductTotalPrice;
	}
	
	public String getProductNumber() {
		return ProductNumber;
	}

	public void setProductNumber(String productNumber) {
		ProductNumber = productNumber;
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

	public int getProductReQuantity() {
		return ProductReQuantity;
	}

	public void setProductReQuantity(int productReQuantity) {
		ProductReQuantity = productReQuantity;
	}

}
