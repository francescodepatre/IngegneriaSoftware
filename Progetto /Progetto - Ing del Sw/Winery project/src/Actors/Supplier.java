package Actors;

public class Supplier {
	private final int idSupplier;
	private final String SupplierName;
	private final String SupplierAddress;
	private final String SupplierPhone;
	
	public Supplier(final int id, final String n, final String a, final String p) {
		this.idSupplier = id;
		this.SupplierName = n;
		this.SupplierAddress = a;
		this.SupplierPhone = p;
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
}
