package actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import entity.Book;
import entity.Cart;
import entity.LineItem;

public class AddToCartAction extends ActionSupport
{

	
	private static final long serialVersionUID = 1L;

	boolean checkMe;
	private LineItem item;
	private Cart cart;
	private List<LineItem> items = new ArrayList<LineItem>();

	public boolean isCheckMe() {
		return checkMe;
	}

	public void setCheckMe(boolean checkMe) {
		this.checkMe = checkMe;
	}
	
	public String execute(){
		if(checkMe){
//			Book book = new Book();
//			book.setTitle("Test");
//			book.setAuthor("Test");
//			book.setPrice(5.99);
//			book.setCategory("Fictional");
//			item = new LineItem();
//			item.setBook(book);
//			cart = new Cart();
//			items.add(item);
//			cart.setItems(items);
			return SUCCESS;
		}
		else{
			return "failure";
		}
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public LineItem getItem() {
		return item;
	}

	public void setItem(LineItem item) {
		this.item = item;
	}
	
}
