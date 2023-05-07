package assignment1;

public class Item {

	private double price;
	
	public Item() {
		this.setPrice(2.56);
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static void demo() {
		// This is our user or customer
		double myCash = 20.0;
		
		//Step 1 - Customer enters the shop & gets a cart
		Cart myCart = new Cart(myCash);
		
		// Step 2 - Adding items to cart
		Item apple = new Item();
		
		// Step 3 - Checkout
		myCart.Checkout(myCart, apple);
		
		System.out.print("\n\n"+myCart);
	}	
}