package dip;

public class User {
	private int id;
	private String data;
	private int ora;
	
	
	public User(int id, String data, int ora) {
		this.id = id;
		this.data = data;
		this.ora = ora;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getOra() {
		return ora;
	}
	public void setOra(int ora) {
		this.ora = ora;
	}
	
	@Override
	public String toString() {
		return "User [id= " +id+ " , data= "+ data+" , ora= "+ora+ "]";
	}
}
