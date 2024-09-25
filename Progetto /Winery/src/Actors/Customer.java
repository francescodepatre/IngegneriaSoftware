package Actors;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname;
	private String code;
	private String email;
	private String phone;
	private String address;
	private String username;
	private String password;
	
	public Customer(final int id_c, final String name_c, final String surname_c, final String code_c, final String email_c, final String phone_c, final String address_c, final String username_c, final String password_c) {
		this.id = id_c;
		this.name = name_c;
		this.surname = surname_c;
		this.code = code_c;
		this.email = email_c;
		this.phone = phone_c;
		this.address = address_c;
		this.username = username_c;
		this.password = password_c;
	}
	
	//Useful functions about customer informations for place orders and perform other operations.
	public int get_id() {
		return this.id;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public String get_surname() {
		return this.surname;
	}
	
	public String get_address() {
		return this.address;
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
	
	public String get_username() {
		return this.username;
	}
	
	public String get_password() {
		return this.password;
	}
	
	//Useful functions for change customer's data and correct errors.
	
	public void change_password(final String n_password) {
		this.password = n_password;
	}
	
	public void set_address(final String n_addr) {
		this.address = n_addr;
	}
	
	public void set_email(final String n_email) {
		this.email = n_email;
	}
	
	public void set_phone(final String n_phone) {
		this.phone = n_phone;
	}
}
