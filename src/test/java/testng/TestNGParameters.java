package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {
	
	@Parameters({"url", "username", "password"})
	@Test
	public void methodsParameters(String urlValue, String usernameValue, String passwordValue) {
		System.out.println("urlValue :\t"+urlValue);
		System.out.println("usernameValue :\t"+usernameValue);
		System.out.println("passwordValue :\t"+passwordValue);
	}

}
