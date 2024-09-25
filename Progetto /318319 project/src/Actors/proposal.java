package Actors;

import java.io.Serializable;

public class proposal implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idproposal;
	private int idwine;
	private int idcustomer;
	private int quantity;
	private String dateproposal;
	private Double totalproposal;
	private String datecompilation;
	private int sellersign;
	private int idseller;
	
	public proposal() {
		
	}
	
	public proposal(final int id_p, final int id_w, final int id_c, final int q, final String dateproposal, final Double total, final String datecomp, final int sell_sign, final int sell_id) {
		this.idproposal = id_p;
		this.idwine = id_w;
		this.idcustomer = id_c;
		this.quantity = q;
		this.dateproposal = dateproposal;
		this.totalproposal = total;
		this.datecompilation = datecomp;
		this.sellersign = sell_sign;
		this.idseller = sell_id;
	}
	
	public int getId() {
		return idproposal;
	}
	
	public void setId(final int i) {
		this.idproposal = i;
	}
	
	public int getIdWine() {
		return idwine;
	}
	
	public void setIdWine(final int i) {
		this.idwine = i;
	}
	
	public int getIdCustomer() {
		return idcustomer;
	}
	
	public void setIdCustomer(final int i) {
		this.idcustomer = i;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(final int i) {
		this.quantity = i;
	}
	
	public String getDate() {
		return dateproposal;
	}
	
	public void setDate(final String d) {
		this.dateproposal = d;
	}
	
	public Double getTotal() {
		return totalproposal;
	}
	
	public void setTotal(final Double t) {
		this.totalproposal = t;
	}
	
	public String getDateCompilation() {
		return datecompilation;
	}
	
	public void setDateCompilation(final String dc) {
		this.datecompilation = dc;
	}
	
	public int getSellerSign() {
		return sellersign;
	}
	
	public void setSellerSign(final int ss) {
		this.sellersign = ss;
	}
	
	public int getSellerId() {
		return idseller;
	}
	
	public void setSellerID(final int si) {
		this.idseller = si;
	}
}
