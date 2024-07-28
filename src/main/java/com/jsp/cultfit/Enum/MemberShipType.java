package com.jsp.cultfit.Enum;

public enum MemberShipType {
	ONEMONTH (500.00), 
	TWOMONTH (700.00), 
	THREEMONTH (800.00), 
	FIVEMONTHE(900.00), 
	ONEYEAR(1300.00);
	private double price;
	
public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
     private MemberShipType(double price) {
	 this.price=price;
 }
}

