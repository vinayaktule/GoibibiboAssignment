package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	static WebDriver driver=null;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}	
	
	@Test
	public void testScreenshot() throws WebDriverException, IOException {
		takeScreenshot("googlescreenshot");
		
	}
	
	public static void takeScreenshot(String fileName) throws WebDriverException, IOException {
		//1. Takes screenshot and store it as a file format	
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//2. copy file to desired location using copy file method
		FileUtils.copyFile(file, new File("./screenshots/"+fileName+"_"+timestamp()+".jpg"));
	}
	
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		driver=null;
	}

}
