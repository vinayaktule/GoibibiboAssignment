package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameHandling {
static WebDriver driver=null;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
	}	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();
		driver=null;
	}
	
	@Test
	public void iframeMethod() {
		//clicking on iframe
		driver.findElement(By.xpath("//a[normalize-space()='Iframe with in an Iframe']")).click();
		//finding and switching on outer iframe
		WebElement outerIFrame=driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		driver.switchTo().frame(outerIFrame);
		
		//finding and switching on inner iframe		
		WebElement innerIFrame=driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		driver.switchTo().frame(innerIFrame);
		//finding and entering data for input iframe
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("IFRAME");

	}


}
