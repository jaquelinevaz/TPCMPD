package src.main.java.pt.isel.mpd14.sqlfw;

public class Product {

	private int ProductID; 
	private String ProductName; 
	private double UnitPrice;
	private int UnitsInStock;
	
	public Product(int ProductID,String ProductName,double UnitPrice,int UnitsInStock){
		this.ProductID=ProductID;
		this.ProductName=ProductName;
		this.UnitPrice=UnitPrice;
		this.UnitsInStock=UnitsInStock;
		
	}
	
	
	public int getProductID() {
		return ProductID;
	}
	public String getProductName() {
		return ProductName;
	}
	public double getUnitPrice() {
		return UnitPrice;
	}
	public int getUnitsInStock() {
		return UnitsInStock;
	}	
	
	
	
}
