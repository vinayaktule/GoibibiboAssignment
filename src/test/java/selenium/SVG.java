package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVG {
	
	@Test
	public void googleCoronaGraph() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?q=corona+graph&rlz=1C5CHFA_enIN974IN974&oq=corona+graph&aqs=chrome..69i57j0i402l2j0i512l7.5382j0j7&sourceid=chrome&ie=UTF-8");
		WebElement element= driver.findElement(By.xpath("(//*[local-name()='svg' and @class='uch-psvg'])[2]"));
		Actions action=new Actions(driver);
		int yOffset=((element.getSize().getHeight())/2)-element.getSize().getHeight();
		int xOffset=((element.getSize().getWidth())/2)-element.getSize().getWidth();
		for(int i=0;i<500;i++) {
			action.moveToElement(element, xOffset+i, yOffset).perform();
			Thread.sleep(50);
			String value1=driver.findElement(By.xpath("//table[@class='swWWne']/tbody")).getText();
			System.out.println(value1);
			i+=5;
		}
		
		
		driver.quit();
	}

}
