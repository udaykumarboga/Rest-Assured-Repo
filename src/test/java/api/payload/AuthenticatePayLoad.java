package api.payload;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import api.utilities.DataProviders;

import java.io.IOException;

// POJO:- plain or pale old java object
//JSON: java script object notation

public class AuthenticatePayLoad {
	
	String password ;
	String username;
	
//	String password = "admin";
//	String username = "admin"; 
	
	public String getPassword() throws IOException {
		password=DataProviders.getMapTestData().get("password");
		return password;
	}
	
	public void setPassword(String password) throws IOException {
		this.password = password;
	}
	
	public String getUsername() throws IOException {
		username=DataProviders.getMapTestData().get("username");
		return username;
	}
	
	public void setUsername(String username) throws IOException {
		this.username = username;
	}
		
}
