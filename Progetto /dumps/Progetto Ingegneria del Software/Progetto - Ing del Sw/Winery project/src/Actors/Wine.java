package Actors;

public class Wine {
	private int wine_id; 
	private String wine_name;	
	private int wine_year;
	private float wine_price;
	
	public Wine(final int id, final String name, final int year, final float price) {	
		this.wine_id = id;
		this.wine_name = name;
		this.wine_year = year;
		this.wine_price = price;
	}
	
	public int get_id() {	//return the wine's ID.
		return this.wine_id;
	}
	
	public String get_name() { //return the wine's name.
		return this.wine_name;
	}
	
	public int get_year() { //return the wine's year.
		return this.wine_year;
	}
	
	public float get_price() {
		return this.wine_price;
	}
	
	//Useful functions for correcting typos.
	public void set_name(final String n_name) {
		this.wine_name = n_name;
	}
	
	public void set_year(final int n_year) {
		this.wine_year = n_year;
	}
	
	public void set_price(final float n_price) {
		this.wine_price = n_price;
	}
}
