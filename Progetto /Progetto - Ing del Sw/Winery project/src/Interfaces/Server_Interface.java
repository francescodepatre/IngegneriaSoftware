package Interfaces;

public class Server_Interface {
	
	public void interface_selector(final String t,final int uid) {
		switch(t) {
		case "Seller":
			new Seller_Interface().select_op(uid);
		case "Customer":
			new Customer_Interface().select_op(uid);
		case "Admin":
			new Admin_Interface().select_op(uid);
		}
	}
}
