package Actors;

public class Order {
	private int idOrder;
	private float price;
	private Customer customer;
	private int quantity;
	
	public Order(final int id, final float p, final Customer cus, final int q) {
		this.idOrder = id;
		this.price = p;
		this.customer = cus;
		this.quantity = q;
	}
	
	public int get_id() {
		return this.idOrder;
	}
	
	public float get_price() {
		return this.price;
	}
	
	public Customer get_customer() {
		return this.customer;
	}
	
	public int get_pack() {
		return this.quantity;
	}
}
