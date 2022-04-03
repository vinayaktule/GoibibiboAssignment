package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandling {
	public static WebDriver driver;

	By table = By.id("customer");
	By col = By.xpath("//table[@id='customers']//th");
	By row = By.xpath("//table[@id='customers']//tr");
	By data = By.xpath("//table[@id='customers']//td");
	By checkBox = By.xpath("//table[@id='customers']//td[1]/input");
	By company = By.xpath("//table[@id='customers']//td[2]");
	By contact = By.xpath("//table[@id='customers']//td[3]");
	By country = By.xpath("//table[@id='customers']//td[4]");
	By action = By.xpath("//table[@id='customers']//td[5]");

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		driver = null;
	}

	@Test
	public void printWebTableData() throws InterruptedException {
		// get header data
		//System.out.println(returnWebElementsText(getHeaderWebElements()));

		// get table data
		//System.out.println(returnWebElementsText(getTableData()));

		// click checkbox for matched company
		clickOnCheckBox("Java");

	}

	public void clickOnCheckBox(String company) throws InterruptedException {

		for (int i = 0; i < getCompanyWebElements().size(); i++) {
			
			String text = getCompanyWebElements().get(i).getText();
			System.out.println("Company :\t"+text);
			if (company.equalsIgnoreCase(text)) {
			 	WebElement ele=getCheckBoxWebElements().get(i);
			 	System.out.println(ele.isEnabled());
			 	ele.click();
				System.out.println("Clicked on checkbox of "+text+" company");
				Thread.sleep(5000);
				break;
			}
		}
	}

	public List<WebElement> getCheckBoxWebElements() {
		return driver.findElements(checkBox);
	}
	
	public List<WebElement> getCompanyWebElements() {
		return driver.findElements(company);
	}

	public List<WebElement> getCountryWebElements() {
		return driver.findElements(country);
	}

	public List<WebElement> getHeaderWebElements() {
		return driver.findElements(col);
	}

	public List<WebElement> getTableData() {
		return driver.findElements(data);
	}

	public List<String> returnWebElementsText(List<WebElement> elements) {
		List<String> elementTextList = new ArrayList<String>();

		for (int i = 0; i < elements.size(); i++) {
			String text = elements.get(i).getText();
			elementTextList.add(text);
		}

		return elementTextList;
	}

}
