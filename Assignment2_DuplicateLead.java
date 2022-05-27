package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_DuplicateLead {
	/*http://leaftaps.com/opentaps/control/main
	 
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	*/
	public static void main(String[] args) throws InterruptedException {
		//1. Launch the browser 
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		//driver.manage().window().maximize();
		//2.Enter the username/3. password
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//4. Click on Login Button using Class Locator 
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//5. Click on CRM/SFA Link		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//6. Click Leads link		
		driver.findElement(By.linkText("Leads")).click();
		
		//7. Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//8. Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		//9. Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("dhayaranjani@gmail.com");

		//10. Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(5000);
		
		//11. Capture name of First Resulting lead
		String FirstLeadId = driver.findElement(By.xpath("(//button[@class='x-btn-text x-tbar-page-first']/preceding::div[@class='x-grid3-scroller']//a)[1]")).getText();				
		System.out.println("leadId is :" + FirstLeadId);
		
		//12. Click First Resulting lead
		driver.findElement(By.xpath("(//button[@class='x-btn-text x-tbar-page-first']/preceding::div[@class='x-grid3-scroller']//a)[1]")).click();
		
		//13. Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		
		//14. Verify title of the page
		String title = driver.getTitle();
		System.out.println("Title of the page: " + title);
		
		if(driver.getTitle().contains("Duplicate Lead")){
			System.out.println("The title of the page is verified");
		}else {
			System.out.println("The title is null");
		} 

		//15. Click Create Lead 
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Create Lead']")).click();		
		
		Thread.sleep(5000);
		//16	Confirm the duplicated lead name is same as captured name
		//16. Close the browser
		driver.close();
		
		
	}

}
