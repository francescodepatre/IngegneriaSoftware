package Actors;

public class pre_buy {
	private Wine wine;
	private int quantity;
	
	public pre_buy(final Wine w, final int q) {
		this.wine = w;
		this.quantity = q;
	}
	
	public Wine getWine() {
		return this.wine;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}
