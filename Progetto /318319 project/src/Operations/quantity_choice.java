package Operations;

public class quantity_choice {

	public int get_choice(String ch) {
		int q = 1;
		switch(ch) {
		case "Single pack":
			q = 1;
			break;
		case "Double pack":
			q = 2;
			break;
		case "Pack of 3":
			q = 3;
			break;
		case "Pack of 4":
			q = 4;
			break;
		case "Pack of 5":
			q = 5;
			break;
		case "6-case":
			q = 6;
			break;
		case "12-case":
			q = 12;
			break;
		default: 
			q = 1;
		}
		return q;
	}
}
