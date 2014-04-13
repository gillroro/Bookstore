package entity;

import java.util.Hashtable;

public class Order {
	private Hashtable<LineItem, String> map  = new Hashtable<LineItem, String>();
	
	private Cart cart;
	private double amount;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
//	public LineItem createBasic(){
//		return (LineItem) map.get(cart.getItems()).clone();
//	}
	
	

}
