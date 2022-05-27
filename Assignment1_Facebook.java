package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
/*Assignment:1 FaceBook:
//================================
// Step 1: Download and set the path 
// Step 2: Launch the chromebrowser
// Step 3: Load the URL https://en-gb.facebook.com/
// Step 4: Maximise the window
// Step 5: Add implicit wait
// Step 6: Click on Create New Account button
// Step 7: Enter the first name
// Step 8: Enter the last name
// Step 9: Enter the mobile number
// Step 10: Enterthe password
// Step 11: Handle all the three drop downs
// Step 12: Select the radio button "Female" 
( A normal click will do for this step) */
public class Assignment1_Facebook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Identify the WebElement
		driver.findElement(By.xpath("//a[text() = 'Create New Account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Dhayaranjani");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Subbiah");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("6473321976");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Mypassword123$");
		
		WebElement selBirthday = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select ddBdate = new Select(selBirthday);
		ddBdate.selectByValue("21");

		WebElement selBirthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		Select ddBMonth = new Select(selBirthMonth);
		ddBMonth.selectByValue("8");
		
		WebElement selBirthYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select ddBYear = new Select(selBirthYear);
		ddBYear.selectByValue("1975");	
		
		driver.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
	}

}
