package com.opensource.admin.qa;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class TC003_Admin_AddNewUser {

	@BeforeTest
	public void beforeTest() {
		
	}

	@Test
	public void TC003_Admin_AddNewUser1() {

		String passwordOrange = "admin1234*_";
		int random = (int) (Math.random() * 100);
		String randomName = "Automation" + random;

		// Step 1
		Reporter.log("Open Browser \"OrangeHRM\" web page");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step2
		Reporter.log("Enter Username and Password");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 3
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='OrangeHRM']")));

		// Step 4
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Step 5
		Reporter.log("Click Add");
		driver.findElement(By.xpath("//input[@name='btnAdd']")).click();

		// Step 6
		Reporter.log("Enter valid Employee Name");
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("John Smith");
		driver.findElement(By.xpath("//li[@class='ac_even ac_over']")).click();

		// Step 7 
		Reporter.log("Enter valid username");
		driver.findElement(By.id("systemUser_userName")).sendKeys(randomName);

		// Step 8 
		Reporter.log("Enter new password and confirm");
		driver.findElement(By.id("systemUser_password")).sendKeys(passwordOrange);
		Reporter.log("Enter new password and confirm");
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(passwordOrange);

		// Step 9 
		Reporter.log("Click Save");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
//		Reporter.log("Search username in field \"Username\"");
//		driver.findElement(By.xpath("//input[@id=\"searchSystemUser_userName\"]")).sendKeys("Admin");

		/*
		 * Step 10 Reporter.log("Search username in field \"Username\"");
		 * 
		 * Step 11 Reporter.log("Click Search");
		 * 
		 * Step 12 Reporter.log("Verify username exist in table");
		 * 
		 * Step 13 Reporter.log("Log out");
		 * 
		 * Step 14 Reporter.log("Close Browser");
		 */

	}

	@AfterTest
	public void afterTest() {
	}

}
