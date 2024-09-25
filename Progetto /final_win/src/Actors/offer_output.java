package Actors;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class offer_output {
	private SimpleIntegerProperty idoffer;
	private SimpleIntegerProperty wine;
	private SimpleStringProperty start;
	private SimpleStringProperty end;
	private SimpleIntegerProperty discount;
	
	public offer_output(final int id_off, final int id_win, final String start_d, final String end_d, final int disc) {
		this.idoffer = new SimpleIntegerProperty(id_off);
		this.wine = new SimpleIntegerProperty(id_win);
		this.start = new SimpleStringProperty(start_d);
		this.end = new SimpleStringProperty(end_d);
		this.discount = new SimpleIntegerProperty(disc);
	}
	
	public int getIdoffer() {
		return idoffer.get();
	}
	
	public void setIdoffer(final int i) {
		this.idoffer.set(i);
	}
	
	public int getWine() {
		return wine.get();
	}
	
	public void setWine(final int n) {
		this.wine.set(n);
	}
	
	public String getStart() {
		return start.get();
	}
	
	public void setStart(final String s) {
		this.start.set(s);
	}
	
	public String getEnd() {
		return end.get();
	}
	
	public void setCode(final String s) {
		this.end.set(s);
	}
	
	public int getDiscount() {
		return discount.get();
	}
	
	public void setEmail(final int s) {
		this.discount.set(s);
	}
}