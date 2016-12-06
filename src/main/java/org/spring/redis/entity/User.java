package org.spring.redis.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1879197482104259255L;
	@Id
	@GeneratedValue
	String id;
	String username;
	String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	
	
}
