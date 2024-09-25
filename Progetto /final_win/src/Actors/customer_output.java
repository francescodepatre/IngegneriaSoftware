package Actors;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class customer_output {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty surname;
	private SimpleStringProperty code;
	private SimpleStringProperty email;
	private SimpleStringProperty phone;
	private SimpleStringProperty address;
	
	public customer_output(final int id_c, final String name_c, final String surname_c, final String code_c, final String email_c, final String phone_c, final String address_c) {
		this.id = new SimpleIntegerProperty(id_c);
		this.name = new SimpleStringProperty(name_c);
		this.surname = new SimpleStringProperty(surname_c);
		this.code = new SimpleStringProperty(code_c);
		this.email = new SimpleStringProperty(email_c);
		this.phone = new SimpleStringProperty(phone_c);
		this.address = new SimpleStringProperty(address_c);
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
	
	public String getSurname() {
		return surname.get();
	}
	
	public void setSurname(final String s) {
		this.surname.set(s);
	}
	
	public String getCode() {
		return code.get();
	}
	
	public void setCode(final String s) {
		this.code.set(s);
	}
	
	public String getEmail() {
		return email.get();
	}
	
	public void setEmail(final String s) {
		this.email.set(s);
	}
	
	public String getPhone() {
		return phone.get();
	}
	
	public void setPhone(final String s) {
		this.phone.set(s);
	}
	
	public String getAddress() {
		return address.get();
	}
	
	public void setAddress(final String s) {
		this.address.set(s);
	}
	
	public String toString() {
		return "id: " + id.get() + " - name: " + name.get() + " - surname:" + surname.get() + " - code: " + code.get() + " - email: " + email.get()+ " - phone: " + phone.get() + " - address: " + address.get();
	}
}
