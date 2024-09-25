package Actors;

public class Supplier {
	private int idSupplier;
	private String SupplierName;
	private String SupplierAddress;
	private String SupplierPhone;
	private String username;
	private String password;
	private String type;
	
	public Supplier(final int id, final String n, final String a, final String p) {
		this.idSupplier = id;
		this.SupplierName = n;
		this.SupplierAddress = a;
		this.SupplierPhone = p;
	}
	
	public void supp_profile(final int id, final String n, final String a, final String p, final String username, final String pass, final String t) {
		this.idSupplier = id;
		this.SupplierName = n;
		this.SupplierAddress = a;
		this.SupplierPhone = p;
		this.username = username;
		this.password = pass;
		this.type = t;
	}
	
	public int get_id() {
		return this.idSupplier;
	}
	
	public String get_name() {
		return this.SupplierName;
	}
	
	public String get_address() {
		return this.SupplierAddress;
	}
	
	public String get_phone() {
		return this.SupplierPhone;
	}
	
	public String get_username() {
		return this.username;
	}
	
	public String get_password() {
		return this.password;
	}
	
	public String get_type() {
		return this.type;
	}
}
