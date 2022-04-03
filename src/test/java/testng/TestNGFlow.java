package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGFlow {
	
	/*
	 * setup
	 * startBrowser
	 * login
	 * setMethodConfig
	 * verifyTitle
	 * tearMethodConfig
	 * verifyURL
	 * setMethodConfig
	 * tearMethodConfig
	 * logout
	 * closeBrowser
	 * teardown
	 */
	
	@BeforeSuite
	public void setup() {
		System.out.println("@BeforeSuite: Creating database config for application");
	}
	
	@BeforeTest
	public void startBrowser() {
		System.out.println("@BeforeTest: Starting browser with configuration");
	}
	
	@BeforeClass
	public void login() {
		System.out.println("@BeforeClass: Application login");
	}
	
	@BeforeMethod
	public void setMethodConfig() {
		System.out.println("@BeforeMethod: Run before each method");
	}
	
	@Test
	public void verifyTitle() {
		System.out.println("@Test: verifyTitle");
	}
	
	@Test
	public void verifyURL() {
		System.out.println("@Test: verifyURL");
	}
	
	@AfterMethod
	public void tearMethodConfig() {
		System.out.println("@AfterMethod: Run after each method");
	}
	
	@AfterClass
	public void logout() {
		System.out.println("@AfterClass: Logout");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("@AfterTest: Closing browser");
	}
	@AfterSuite
	public void teardown() {
		System.out.println("@AfterSuite: Clear test environment & creating Test Reports");
	}

}
