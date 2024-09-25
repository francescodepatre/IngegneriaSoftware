package Actors;

import java.io.Serializable;

public class Wine implements Serializable{
	private static final long serialVersionUID = 1L;
	private int wine_id; 
	private String wine_name;	
	private int wine_year;
	private float wine_price;
	private int wine_quantity;
	
	
	public Wine(int id, String name, int year, float price, int q) {	
		this.wine_id = id;
		this.wine_name = name;
		this.wine_year = year;
		this.wine_price = price;
		this.wine_quantity = q;
	}
	
	public int getwine_id() {
		return this.wine_id;
	}
	
	public String get_name() { 
		return this.wine_name;
	}
	
	public int get_year() { 
		return this.wine_year;
	}
	
	public float get_price() {
		return this.wine_price;
	}
	
	public int get_quantity() {
		return this.wine_quantity;
	}
	
}
