package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String username;
	private String password;
	
	public User(){
		super();
	}
	
	public User(int id, String username, String password) {
		super();
		this.userId = id;
		this.username = username;
		this.password = password;
	}
	
	public int getId() {
		return userId;
	}
	
	public void setId(int id) {
		this.userId = id;
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

	

	@Override
	public String toString() {
		return "String [userId=" + userId + ", username=" + username + "]";
	}
	
	
	
}
