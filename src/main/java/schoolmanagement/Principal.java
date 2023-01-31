package schoolmanagement;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Principal {
	@Id
	private String name;
	private int age;
	private String email;
	private long mobilenum;
	private String pwd;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(long mobilenum) {
		this.mobilenum = mobilenum;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
