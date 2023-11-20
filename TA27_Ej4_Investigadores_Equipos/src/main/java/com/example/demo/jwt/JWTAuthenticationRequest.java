package com.example.demo.jwt;

import lombok.Data;

/**
 * @author Jose Marin
 */

@Data
public class JWTAuthenticationRequest {
    private String userName;
    private String password;
	
    
    public JWTAuthenticationRequest() {
    	
    }
    
    
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}