package main;

public class Order {
	private int idOrder;
	private float price;
	private Customer customer;
	private Pack pack;
	
	public Order(final int id, final float p, final Customer cus, final Pack pac) {
		this.idOrder = id;
		this.price = p;
		this.customer = cus;
		this.pack = pac;
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
	
	public Pack get_pack() {
		return this.pack;
	}
}
