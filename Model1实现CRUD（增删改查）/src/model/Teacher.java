package model;
/*
 * 数据模型
 */
public class Teacher {
	private int tid;
	private String name;
	private String description;
	private int age;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "teacher [tid=" + tid + ", name=" + name + ", description=" + description + ", age=" + age + "]";
	}
	public Teacher(int tid, String name, String description, int age) {
		super();
		this.tid = tid;
		this.name = name;
		this.description = description;
		this.age = age;
	}
	public Teacher(String name, String description, int age) {
		super();
		this.name = name;
		this.description = description;
		this.age = age;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
