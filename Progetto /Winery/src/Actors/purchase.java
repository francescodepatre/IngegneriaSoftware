package Actors;

import java.io.Serializable;

public class purchase implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idorder;
	private int idwine;
	private int quantity; 
	private Double totalprice; 
	private String dateorder;
	private int idcustomer;
	private String method;
	
	public purchase(final int id_order,final int id_wine,final int quant,final Double total, final String dat, final int id_customer, final String meth) {
		this.idorder = id_order;
		this.idwine = id_wine;
		this.quantity = quant;
		this.totalprice = total;
		this.dateorder = dat;
		this.idcustomer = id_customer;
		this.method = meth;
	}
	
	public int getid() {
		return this.idorder;
	}
	
	public int getwine() {
		return this.idwine;
	}
	
	public int getquantity() {
		return this.quantity;
	}
	
	public Double gettotal() {
		return this.totalprice;
	}
	
	public String getdate() {
		return this.dateorder;
	}
	
	public int getcustomer() {
		return this.idcustomer;
	}
	
	public String getmethod() {
		return this.method;
	}

}
