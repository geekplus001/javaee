package entity;
/*
 * 数据模型
 * 
 */
public class Friend {
	private int id;
	private String name;
	private String sex;
	private String signature;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", sex=" + sex + ", signature=" + signature + "]";
	}
	public Friend(int id, String name, String sex, String signature) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.signature = signature;
	}
	
	
	public Friend(String name, String sex, String signature) {
		super();
		this.name = name;
		this.sex = sex;
		this.signature = signature;
	}
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
