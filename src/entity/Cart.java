package entity;

public class Cart {

	private LineItem[] item;
	private Customer customer;
	private int capacity;
	private int itemCount;
	private double total;

	public Cart(){
		capacity = 5;
		item = new LineItem[capacity];
		itemCount = 0;
		setTotal(0.0);
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LineItem[] getItem() {
		return item;
	}
	public void setItem(LineItem[] item) {
		this.item = item;
	}
	
	public void addToCart(String itemName, double price, int quantity)
    { 

        LineItem temp = new LineItem();
        setTotal(getTotal() + (price * quantity));
        item[itemCount] = temp;
        itemCount += 1;
        if(itemCount==capacity)
        {
            increaseSize();
        }
    }
	
	private void increaseSize()
    {
        LineItem[] temp = new LineItem[capacity+3];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = item[i];
        }
        item = temp; 
        temp = null;
        capacity = item.length;
    }

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}



}
