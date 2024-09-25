package Actors;

public class Seller {
	private int idSeller;
	private String name;
	private String surname;
	private String code;
	private String email;
	private String phone;
	private String address;
	private String username;
	private String password;
	
	public Seller(final int id, final String n, final String s, final String c, final String e, final String p, final String a, final String username_s, final String password_s) {
		this.idSeller = id;
		this.name = n;
		this.surname = s;
		this.code = c;
		this.email = e;
		this.phone = p;
		this.address = a;
		this.username = username_s;
		this.password = password_s;
	}
	
	public int get_id() {
		return this.idSeller;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public String get_surname() {
		return this.surname;
	}
	
	public String get_code() {
		return this.code;
	}
	
	public String get_email() {
		return this.email;
	}
	
	public String get_phone() {
		return this.phone;
	}
	
	public String get_address() {
		return this.address;
	}
	
	public String get_username() {
		return this.username;
	}
	
	public String get_password() {
		return this.password;
	}
	
	public void change_password(final String n_password) {
		this.password = n_password;
	}
	
	public void set_email(final String n_email) {
		this.email = n_email;
	}
	
	public void set_address(final String n_address) {
		this.address = n_address;
	}
	
	public void set_phone(final String n_phone) {
		this.phone = n_phone;
	}
	
}
