package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private double total;
	private List<LineItem> items = new ArrayList<LineItem>();

	public void pay(PaymentStrategy payment){
		double totalCost = getTotal();
		payment.pay(totalCost);
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public List<LineItem> getItems() {
		return items;
	}


	public void setItems(List<LineItem> items) {
		this.items = items;
	}

}
