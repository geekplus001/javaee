package bean;

public class user {
	private String name;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "user [name=" + name + ", sex=" + sex + "]";
	}
	public user(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
