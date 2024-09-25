package Actors;

import java.io.Serializable;
import java.util.ArrayList;

public class request_operation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private final String operationname;
	private final ArrayList<Object> datalist;
	
	public request_operation(final String on, final ArrayList<Object> dl) {
		this.operationname = on;
		this.datalist = dl;
	}
	
	public String getOperation() {
		return this.operationname;
	}
	
	public ArrayList<Object> getDataList(){
		return this.datalist;
	}
	
	public Object getData(final int index) {
		return this.datalist.get(index);
	}
}
