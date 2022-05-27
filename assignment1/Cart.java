package assignment1;

public class Cart {
	private double myCash;
	private double myTotal;
	private double myChange;
	
	public Cart(double myCash) {
		this.myCash = myCash;
		this.myChange = myCash;
	}
	public double getMyCash() {
		return myCash;
	}
	public void setMyCash(double myCash) {
		this.myCash = myCash;
	}
	public double getMyTotal() {
		return myTotal;
	}
	public void setMyTotal(double myTotal) {
		this.myTotal = myTotal;
	}
	public double getMyChange() {
		return myChange;
	}
	public void setMyChange(double myChange) {
		this.myChange = myChange;
	}
	
	public void sillyCheckout(double cash, double price, double total, double change) {
		String cartStatus = "Below is the current status of your cart\n"+"Cash: "+cash+"\n"+"Total: "+(total+price)+"\n"+"Change: "+(change-price);
		System.out.print(cartStatus);
	}
	
	public double Checkout(Cart myCart, Item myItem) {
		this.sillyCheckout(myCart.getMyCash(), myItem.getPrice(), myCart.getMyTotal(), myCart.getMyChange());
		
		// Updating cart
		this.setMyChange(myCart.getMyChange()-myItem.getPrice());
		this.setMyTotal(myCart.getMyTotal()+myItem.getPrice());
		
		return this.getMyChange();
	}
	
	@Override
	public String toString() {
		return "Below is the current status of your cart\n"+"Cash: "+this.getMyCash()+"\n"+"Total: "+this.getMyTotal()+"\n"+"Change: "+this.getMyChange();
		
	}
}