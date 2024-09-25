package Actors;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class supply_output {
	private SimpleIntegerProperty idsupply;
	private SimpleIntegerProperty idwine;
	private SimpleIntegerProperty idsupplier;
	private SimpleIntegerProperty quantity;
	private SimpleDoubleProperty price;
	private SimpleStringProperty datesupply;
	
	public supply_output(final int id, final int wine, final int supp, final int q, final Double p, final String dat) {
		this.idsupply = new SimpleIntegerProperty(id);
		this.idwine = new SimpleIntegerProperty(wine);
		this.idsupplier = new SimpleIntegerProperty(supp);
		this.quantity = new SimpleIntegerProperty(q);
		this.price = new SimpleDoubleProperty(p);
		this.datesupply = new SimpleStringProperty(dat);
	}
	
	public int getIdsupply() {
		return idsupply.get();
	}
	
	public void setIdsupply(final int i) {
		this.idsupply.set(i);
	}
	
	public int getIdwine() {
		return idwine.get();
	}
	
	public void setIdwine(final int n) {
		this.idwine.set(n);
	}
	
	public int getIdsupplier() {
		return idsupplier.get();
	}
	
	public void setIdsupplier(final int y) {
		this.idsupplier.set(y);
	}
	
	public Double getPrice() {
		return price.get();
	}
	
	public void setPrice(final Double p) {
		this.price.set(p);
	}
	
	public int getQuantity() {
		return quantity.get();
	}
	
	public void setQuantity(final int q) {
		this.quantity.set(q);
	}
	
	public String getDatesupply() {
		return datesupply.get();
	}
	
	public void setDatesupply(final String d) {
		this.datesupply.set(d);
	}
}
