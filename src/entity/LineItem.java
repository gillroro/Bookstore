package entity;

public abstract class LineItem {
	
	private String bookTitle;
	private int quantity;
	private double amount;
	private Book book;
	
	public LineItem clone(){
		LineItem clonedItem = null;
		try{
			clonedItem = (LineItem) super.clone();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return clonedItem;
		
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	

}
