package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathCreateLeadClassActivity {

	public static void main(String[] args) 
	{
			//setup chromedriver 
			WebDriverManager.chromedriver().setup();
			//Create object for the driver
			ChromeDriver driver = new ChromeDriver();
			//Launch the URL
			driver.get("http://leaftaps.com/opentaps/control/main");
			//Maximize the window
			driver.manage().window().maximize();
			
			//Identify the WebElement
			WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
			eleUserName.sendKeys("DemoSalesManager");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
			driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
			driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
			driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Dhayaranjani");
			driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Subbiah");
			driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Dhaya");
			driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("xPath - Information Technology(IT)");
			driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("xPath - This is the TestLeaf test data for the description.");
			driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("dhayaranjani@gmail.com");
			
			WebElement selState = driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
			Select dropdownState = new Select(selState);
			dropdownState.selectByVisibleText("New York");
			WebElement eleSource = driver.findElement(By.xpath("//select[@id='createLeadForm_dataSourceId']"));
			Select dropdownSource = new Select(eleSource); 	
			dropdownSource.selectByValue("LEAD_CONFERENCE");
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();
			
			
	}
}
