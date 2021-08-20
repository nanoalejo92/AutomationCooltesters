package com.opensource.admin.qa;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_SearchrandomEmployee {

	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void TC001_SearchranmdomEmployeetest() {
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
		Reporter.log("Validate table rows");
		WebElement table = driver.findElement(By.xpath("//table[@id='resultTable']"));
		List <WebElement> rows = table.findElements(By.tagName("tr"));
		//System.out.println(rows.size());
		int randUserrow = ((int) (Math.random() * (rows.size() - 0)) + 0);
		//System.out.println(randUserrow);
		String xpathText = driver.findElement(By.xpath("//tbody/tr[" + randUserrow + "]/td[2]")).getText();
		driver.findElement(By.xpath("//input[@id=\"searchSystemUser_userName\"]")).sendKeys(xpathText);
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		String actualvalue = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(actualvalue, xpathText);
		System.out.println(xpathText);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//Step 6
		Reporter.log("Close Browser");
		driver.close();

	}

	@AfterTest
	public void afterTest() {
		
	}

}
