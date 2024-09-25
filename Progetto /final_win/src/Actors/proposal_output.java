package Actors;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class proposal_output{

	private SimpleIntegerProperty idproposal;
	private SimpleIntegerProperty idwine;
	private SimpleIntegerProperty idcustomer;
	private SimpleIntegerProperty quantity;
	private SimpleStringProperty dateproposal;
	private SimpleDoubleProperty totalproposal;
	private SimpleStringProperty datecompilation;
	private SimpleIntegerProperty sellersign;
	private SimpleIntegerProperty idseller;
	
	
	
	public proposal_output(final int id_p, final int id_w, final int id_c, final int q, final String dateproposal, final Double total, final String datecomp, final int sell_sign, final int sell_id) {
		this.idproposal = new SimpleIntegerProperty(id_p);
		this.idwine = new SimpleIntegerProperty(id_w);
		this.idcustomer = new SimpleIntegerProperty(id_c);
		this.quantity = new SimpleIntegerProperty(q);
		this.dateproposal = new SimpleStringProperty(dateproposal);
		this.totalproposal = new SimpleDoubleProperty(total);
		this.datecompilation = new SimpleStringProperty(datecomp);
		this.sellersign = new SimpleIntegerProperty(sell_sign);
		this.idseller = new SimpleIntegerProperty(sell_id);
	}
	
	public int getIdproposal() {
		return idproposal.get();
	}
	
	public void setIdproposal(final int i) {
		this.idproposal.set(i);
	}
	
	public int getIdwine() {
		return idwine.get();
	}
	
	public void setIdwine(final int i) {
		this.idwine.set(i);
	}
	
	public int getIdcustomer() {
		return idcustomer.get();
	}
	
	public void setIdcustomer(final int i) {
		this.idcustomer.set(i);
	}
	
	public int getQuantity() {
		return quantity.get();
	}
	
	public void setQuantity(final int i) {
		this.quantity.set(i);
	}
	
	public String getDateproposal() {
		return dateproposal.get();
	}
	
	public void setDateproposal(final String d) {
		this.dateproposal.set(d);
	}
	
	public Double getTotalproposal() {
		return totalproposal.get();
	}
	
	public void setTotalproposal(final Double t) {
		this.totalproposal.set(t);
	}
	
	public String getDatecompilation() {
		return datecompilation.get();
	}
	
	public void getDatecompilation(final String dc) {
		this.datecompilation.set(dc);
	}
	
	public int getSellersign() {
		return sellersign.get();
	}
	
	public void setSellersign(final int ss) {
		this.sellersign.set(ss);
	}
	
	public int getIdseller() {
		return idseller.get();
	}
	
	public void getIdseller(final int si) {
		this.idseller.set(si);
	}
}
