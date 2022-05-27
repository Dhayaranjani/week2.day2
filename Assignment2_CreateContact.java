package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2_CreateContact {
	/*//Pseudo Code
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
	 * 2. Enter UserName and Password Using Id Locator
	 * 3. Click on Login Button using Class Locator
	 * 4. Click on CRM/SFA Link
	 * 5. Click on contacts Button
	 * 6. Click on Create Contact
	 * 7. Enter FirstName Field Using id Locator
	 * 8. Enter LastName Field Using id Locator
	 * 9. Enter FirstName(Local) Field Using id Locator
	 * 10. Enter LastName(Local) Field Using id Locator
	 * 11. Enter Department Field Using any Locator of Your Choice
	 * 12. Enter Description Field Using any Locator of your choice 
	 * 13. Enter your email in the E-mail address Field using the locator of your choice
	 * 14. Select State/Province as NewYork Using Visible Text
	 * 15. Click on Create Contact
	 * 16. Click on edit button 
	 * 17. Clear the Description Field using .clear
	 * 18. Fill ImportantNote Field with Any text
	 * 19. Click on update button using Xpath locator
	 * 20. Get the Title of Resulting Page.*/
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator 
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on Contacts button		
		driver.findElement(By.linkText("Contacts")).click();
		
		//6. Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//7.Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Dhayaranjani");
		
		//8. Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Subbiah");
		
		//9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Dhaya");
		
		//10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Ranjani");

		//11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Information Technology");
		
		//12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("This is the TestLeaf test data for the Contact : - description.");
		
		//13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("dhayaranjani@gmail.com");
		
		//14. Select State/Province as NewYork Using Visible Text
		//1. Identify the dropdrown element (Select tag)
		WebElement selState = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		//2. Create an object for Select class and link with the dropdown element
		Select dropdownState = new Select(selState);
		//b) Choose the option based on visible text
		dropdownState.selectByVisibleText("New York");
		
		//15. Click on Create Contact Button
		driver.findElement(By.className("smallSubmit")).click();
		
		//16. Click on Edit Button
		driver.findElement(By.linkText("Edit")).click();

		//17. Clear the Description Field using .clear()
		driver.findElement(By.id("updateContactForm_description")).clear();
	
		//18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is the TestLeaf testdata for the Contact page - Important Note.");
		
		//19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@class='smallSubmit' and @value='Update']")).click();
		
		//20. Get the Title of Resulting Page. 
		String resTitle = driver.getTitle();
		System.out.println("Title of the Resulting page: " + resTitle);
	}

}
