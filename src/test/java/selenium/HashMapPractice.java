package selenium;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HashMapPractice {
	
	@Test
	public void hashMap() {
		/*
		 * e.g Amazon E-Commerce application
		 * Role based application data extraction
		 * Admin
		 * End user
		 * Store Manager
		 * Shopkeeper
		 * Distributor
		 * Customer care user
		 */
		
		//https://classic.crmpro.com/index.html
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/index.html");
		
		//System.out.println(getCredentialsMap());
		//System.out.println(getCredentialsMap().get("admin"));
		driver.findElement(By.name("username")).sendKeys(getUsername("customer"));
		driver.findElement(By.name("password")).sendKeys(getPassword("customer"));
		driver.findElement(By.cssSelector(".btn.btn-small")).click();

		driver.quit();
	}
	
	public static HashMap<String, String> getCredentialsMap() {
		HashMap<String, String> userMap=new HashMap();
		userMap.put("customer","VT:VTest@123");
		userMap.put("admin","admin:Admin@123");
		userMap.put("manager","manager:Test@123");
		userMap.put("distributor","distributor:Test@123");
		userMap.put("customercare","customercare:Test@123");
		return userMap;
	}
	
	public String getUsername(String user) {
		String username=getCredentialsMap().get(user);
		return username.split(":")[0];
	}
	
	public String getPassword(String user) {
		return (getCredentialsMap().get(user)).split(":")[1];
		//return password.split(":")[1];
	}
	
	

}
