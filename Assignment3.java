package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
/*===================
1. Load url "https://acme-test.uipath.com/login"
2. Enter email as "kumar.testleaf@gmail.com"
3. Enter Password as "leaf@12"
4. Click login button
5. Get the title of the page and print
6. Click on Log Out
7. Close the browser (use -driver.close())
======================*/
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();

		//2. Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");

		//3. Enter Password as "leaf@12"
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		
		//4. Click login button
		driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();

		//5. Get the title of the page and print
		String title = driver.getTitle();
		System.out.println("Title of the page: " + title);
		
		//6. Click on Log Out
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		//7. Close the browser (use -driver.close())
		//driver.close();
	}

}
