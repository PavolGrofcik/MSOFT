package model;


public class Grant {
	
	private int id;
	private String name;
	private boolean valid;
	
	
	
	public Grant(int Id, String Name, boolean Valid) {
		this.id = Id;
		this.name = Name;
		this.valid = Valid;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	

}
