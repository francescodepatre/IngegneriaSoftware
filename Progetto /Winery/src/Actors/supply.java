package Actors;

import java.io.Serializable;

public class supply implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idsupply;
	private int idwine;
	private int idsupplier;
	private int quantity;
	private Double price;
	private String datesupply;
	
	public supply(final int id, final int w, final int s, final int q, final Double p,final String d) {
		this.idsupply=id;
		this.idwine=w;
		this.idsupplier=s;
		this.quantity = q;
		this.price = p;
		this.datesupply = d;
	}
	
	public int getid() {
		return this.idsupply;
	}
	
	public int getwine() {
		return this.idwine;
	}
	
	public int getquantity() {
		return this.quantity;
	}
	
	public int getsupplier() {
		return this.idsupplier;
	}
	
	public Double getprice() {
		return this.price;
	}
	
	public String getdate() {
		return this.datesupply;
	}
}
