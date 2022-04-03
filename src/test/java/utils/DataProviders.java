package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	
	
	@Test(dataProvider = "logindata")
	public void login(String username, String password, String status) {
		System.out.println("Username : "+username);
		System.out.println("password : "+password);
		System.out.println("status : "+status);
	}
	
	@DataProvider(name="logindata")
	public String[][] getData(){
		String[][]logindata= {
				{"admin@store.com","admin","valid"},
				{"admin1@store.com","admin1","invalid"},
				{"admin2@store.com","admin2","invalid"},
				{"admin3@store.com","admin3","invalid"},
				
		};
		return logindata;	
	}

}
