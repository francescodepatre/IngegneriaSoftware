package Actors;

import java.io.Serializable;

public class Offer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idoffer;
	private int codwine;
	private String startingdate;
	private String endingdate;
	private int discount;
	

	public Offer(final int ido, final int codwi, final String start, final String end, final int dis) {
		this.idoffer = ido;
		this.codwine = codwi;
		this.startingdate = start;
		this.endingdate = end;
		this.discount = dis;
	}
	
	public int getid() {
		return this.idoffer;
	}
	
	public int getwine() {
		return this.codwine;
	}
	
	public String getstartingdate() {
		return this.startingdate;
	}
	
	public String getendingdate() {
		return this.endingdate;
	}
	
	public int getdiscount() {
		return this.discount;
	}
	
	public String toString() {
		return "id: " + this.idoffer + "\nwine: " + this.codwine + " \ndate start:" + this.startingdate + "\ndate end: " + this.endingdate + "\n % of discount: " + this.discount;
	}
}
