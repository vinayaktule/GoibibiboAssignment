package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author vinayaktule
 *
 */
public class WindowHandling {
	static WebDriver driver=null;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}	
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		driver=null;
	}
	
	/// Method will switch to specific URL
	@Test
	public void windowsHandling() {
		String mainWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		
		Set<String> handles=driver.getWindowHandles();
		List<String> handlesList= new ArrayList<String>(handles);
		if(switchToRightWindow("Twitter", handlesList)) {
			System.out.println("Current URL is "+driver.getCurrentUrl());
			System.out.println("Title is "+driver.getTitle());
		}
		
		//returnToMainWindow(mainWindow);
		closeAllWindows(handlesList, mainWindow);
	}
	
	
	/**
	 * closes all windows except main window
	 * @param handlesList
	 * @param mainWindow
	 */
	private void closeAllWindows(List<String> handlesList, String mainWindow) {
		for(String e: handlesList) {
			if(!e.equals(mainWindow)) {
				driver.switchTo().window(e).close();;
			}
		}
		
	}

	/**
	 * return to main window
	 * @param mainWindow
	 */
	public static void returnToMainWindow(String mainWindow) {
		driver.switchTo().window(mainWindow);
		System.out.println("returned on main window : Title is "+driver.getTitle());
	}
	
	/**
	 * Method used to switch to right window based on window id/title
	 * @param string
	 * @param handlesList
	 * @return
	 */
	private boolean switchToRightWindow(String string, List<String> handlesList) {
		for(String e: handlesList) {
			String title=driver.switchTo().window(e).getTitle();
			if(title.contains(string)) {
				System.out.println("Found the window...");
				return true;
			}
		}
		return false;
	}
}
