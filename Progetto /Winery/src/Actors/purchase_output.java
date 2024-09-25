package Actors;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class purchase_output {
	
	private SimpleIntegerProperty idorder;
	private SimpleIntegerProperty idwine;
	private SimpleIntegerProperty quantity; 
	private SimpleDoubleProperty totalprice; 
	private SimpleStringProperty dateorder;
	private SimpleIntegerProperty idcustomer;
	private SimpleStringProperty method;
	
	public purchase_output(final int id_order,final int id_wine,final int quant,final Double total, final String dat, final int id_customer, final String meth) {
		this.idorder = new SimpleIntegerProperty(id_order);
		this.idwine = new SimpleIntegerProperty(id_wine);
		this.quantity = new SimpleIntegerProperty(quant);
		this.totalprice = new SimpleDoubleProperty(total);
		this.dateorder = new SimpleStringProperty(dat);
		this.idcustomer = new SimpleIntegerProperty(id_customer);
		this.method = new SimpleStringProperty(meth);
	}
	
	public int getIdorder() {
		return idorder.get();
	}
	
	public void setIdorder(final int a) {
		idorder.set(a);
	}
	
	public int getIdwine() {
		return idwine.get();
	}
	
	public void setIdwine(final int a) {
		idwine.set(a);
	}
	
	public int getQuantity() {
		return quantity.get();
	}
	
	public void setQuantity(final int a) {
		quantity.set(a);
	}
	
	public Double getTotalprice() {
		return totalprice.get();
	}
	
	public void setTotalprice(final Double p) {
		totalprice.set(p);
	}
	
	public String getDateorder() {
		return dateorder.get();
	}
	
	public void setDateorder(final String d) {
		dateorder.set(d);
	}
	
	public int getIdcustomer() {
		return idcustomer.get();
	}
	
	public void setIdcustomer(final int i) {
		idcustomer.set(i);
	}
	
	public String getMethod() {
		return method.get();
	}
	
	public void setMethod(final String m) {
		method.set(m);
	}
	
}
