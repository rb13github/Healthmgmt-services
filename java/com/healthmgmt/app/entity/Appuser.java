package com.healthmgmt.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;



/**
 * @author RITESHBHONDWE
 *
 */
@Entity
@Table(name="appuser")
public class Appuser {
	@Id
	@Column(name="username")
    private String username;
    private String email;
    private String role;
    private String password;
    
    public Appuser()
    {
    	
    }
    public Appuser(String userName, String email, String role,String password) {
        super();
        this.username = userName;
        this.email = email;
        this.role = role;
        this.password=password;
        
    }
   
    public String getUserName() {
        return username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}