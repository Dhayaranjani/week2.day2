package week2.day2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_EditLead {

	public static void main(String[] args) throws InterruptedException {
		//1. Launch the browser 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		//driver.manage().window().maximize();
		
		//2.Enter the username /password
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4. Click on Login Button using Class Locator 
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5. Click on CRM/SFA Link		
		//driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//6. Click Leads link		
		driver.findElement(By.linkText("Leads")).click();
		
		//7. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//8. Enter first name
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[@name='firstName']")).sendKeys("Dhayaranjani");
		
		//9. Click Find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//10 Click on first resulting lead
		driver.findElement(By.xpath("(//button[@class='x-btn-text x-tbar-page-first']/preceding::div[@class='x-grid3-scroller']//a)[1]")).click();				
		
		//11 Verify title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page: " + title);
		
		if(driver.getTitle().contains("View Lead")){
			System.out.println("The title of the page is verified");
		}else {
			System.out.println("The title is null");
		} 
		
		boolean isTitleEnabled = driver.findElement(By.xpath("//title[text()='View Lead | opentaps CRM']")).isEnabled();
		System.out.println(isTitleEnabled);
		
		//12. Click edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		//Thread.sleep(5000);
		
		//13. Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Test Leaf Technologies - Edit changes");
		
		//14. Click Update
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();		
		
		//15. Confirm the changed name appears
		//Thread.sleep(5000);
		
		//16. Close the browser
		//driver.close();		
	}	

}
