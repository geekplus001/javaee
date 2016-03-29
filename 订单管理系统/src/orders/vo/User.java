package orders.vo;

import java.sql.Date;

public class User {
	private Integer userid;
	private String username;
	private String password;
	private Date createdate;
	private Date lastmodifydate;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getLastmodifydate() {
		return lastmodifydate;
	}
	public void setLastmodifydate(Date lastmodifydate) {
		this.lastmodifydate = lastmodifydate;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", createdate="
				+ createdate + ", lastmodifydate=" + lastmodifydate + "]";
	}
	public User(Integer userid, String username, String password, Date createdate, Date lastmodifydate) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.createdate = createdate;
		this.lastmodifydate = lastmodifydate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
