package Actors;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class wine_output {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty year;
	private SimpleDoubleProperty price;
	private SimpleIntegerProperty quantity;
	
	public wine_output(final int i, final String n, final int y, final float f, final int q) {
		this.id = new SimpleIntegerProperty(i);
		this.name = new SimpleStringProperty(n);
		this.year = new SimpleIntegerProperty(y);
		this.price = new SimpleDoubleProperty(f);
		this.quantity = new SimpleIntegerProperty(q);
	}
	
	public int getId() {
		return id.get();
	}
	
	public void setId(final int i) {
		this.id.set(i);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(final String n) {
		this.name.set(n);
	}
	
	public int getYear() {
		return year.get();
	}
	
	public void setYear(final int y) {
		this.year.set(y);
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
	
	public String toString() {
		return "id: " + id.get() + " - name: " + name.get() + " - year:" + year.get() + " - price: " + price.get() + " - quantity: " + quantity.get();
	}
	
}
