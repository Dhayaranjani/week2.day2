package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathClassRoomActivity {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		//implicit wait should be used before finding Elements 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Identify the WebElement
		WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		
		//1. Identify the first lead id in Leads Table - LeafTaps application 
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		//2. Flying machine checkbox - Myntra application
	    //- Hover on Men --> Select Jeans
		
		driver.get("https://www.myntra.com/men-jeans");
		//driver.findElement(By.xpath("//label[text()='Flying Machine']/input")).click();
		driver.findElement(By.xpath("//label[text()='Flying Machine']/input[@value='Flying Machine']")).click();
		
		//driver.findElement(By.xpath("input[@value='Flying Machine']/following-sibling::div"));
		//driver.findElement(By.xpath("//div[@class='common-checkboxIndicator']/preceding-sibling::input[@value='Flying Machine']"));

		/*3. Subject field in New Case --> Salesforce application
	    //- https://login.salesforce.com
	    //- ramkumar.ramaiah@testleaf.com
	    - Password@123*/
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		WebElement salesUserName = driver.findElement(By.xpath("//input[@id='username']"));
		salesUserName.sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();

		//Highlight Subject field in New Case 
		driver.findElement(By.xpath("//span[text()='Subject']/parent::label/following-sibling::input"));
		
	}								

}
