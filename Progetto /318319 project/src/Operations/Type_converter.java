package Operations;

public class Type_converter {
	
	
	public String int_to_string(final int n) {
		
		switch(n) {
		case 1:
			return "Admin";
		case 2:
			return "Seller";
		case 3: 
			return "Customer";
		default:
				return "Error";
				
		}
		
	}
	
	public int string_to_int(final String s) {
		switch(s) {
		case "Admin":
			return 1;
		case "Seller":
			return 2;
		case "Customer":
			return 3;
		default:
			return 0;
		}
	}
}
