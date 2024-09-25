package Actors;

public class Admin {
	private int idAdmin;
	private String name;
	private String surname;
	private String code;
	private String email;
	private String phone;
	private String address;
	private String username;
	private String password;

	public Admin(final int id_admin, final String n, final String s, final String c, final String e, final String p, final String a, final String usr, final String psw) {
		this.idAdmin = id_admin;
		this.name = n;
		this.surname = s;
		this.code = c;
		this.email = e;
		this.phone = p;
		this.address = a;
		this.username = usr;
		this.password = psw;
	}
	
	public int get_id() {
		return this.idAdmin;
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
	
	
	public void set_name(final String n_name) {
		this.name = n_name;
	}
	
	public void set_surname(final String n_surname) {
		this.surname = n_surname;
	}
	
	public void set_code(final String n_code) {
		this.code = n_code;
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
