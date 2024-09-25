package main;

public class Pack {
	private int Id;
	private int Quantity;
	private Wine wine;
	
	public Pack(final int id, final int q, final Wine w) {
		this.Id = id;
		this.Quantity = q;
		this.wine = w;
	}
	
	public int get_id() {
		return this.Id;
	}
	
	public int get_quantity() {
		return this.Quantity;
	}
	
	public Wine get_wine() {
		return this.wine;
	}
	
}

