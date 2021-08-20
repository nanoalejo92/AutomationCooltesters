package com.opensource.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Base {

	private WebDriver driver;

	/*
	 * Constructor
	 * 
	 * @author johan.robelto
	 * 
	 * @param
	 * 
	 * @return
	 * 
	 * @throws
	 */

	public Base(WebDriver driver) {
		this.driver = driver;
	}
	/*
	 * Reporter
	 * 
	 * @author johan.robelto
	 */

	public void reporter(String log) {
		Reporter.log(log);
	}

	/*
	 * Set web driver
	 */
	public WebDriver chromeDriver() {
		System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_NAME);
		driver = new ChromeDriver();
		return driver;
	}

	/*
	 * implicitly wait
	 */
	public void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public void implicitlyWait() {
		try {
			driver.manage().timeouts().implicitlyWait(GlobalVariables.GENERAL_IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * explicit wait - Wait for element present (sync)
	 */

	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.GENERAL_TIMEOUT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

	/*
	 * explicit wait - Wait for element present (sync) (overloading)
	 */

	public void waitForElementPresent(By locator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Launch browser
	 */

	public void launchBrowser() {
		reporter(GlobalVariables.LAUNCH_MESSAGE + GlobalVariables.QA_URL);
		driver.get(GlobalVariables.QA_URL);
		driver.manage().window().maximize();
		implicitlyWait();
	}

	/*
	 * type
	 * 
	 */

	public void type(By locator, String inputText) {
		try {
			driver.findElement(locator).sendKeys(inputText);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}

	/*
	 * click
	 */
	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/*
	 * isDisplayed
	 */

	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * get text
	 */

	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Assertion (String)
	 */

	public void assertEquals(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);

		} catch (AssertionError e) {
			Assert.fail(e.getMessage() + "Actual value" + actualValue + "does not match with Expected Value"
					+ expectedValue);

		}

	}

	/*
	 * Closer Browser
	 */

	public void closeBrowser() {
		driver.close();
	}

	/*
	 * SoftAssertion method
	 */

	public SoftAssert softAssertion(String actualValue, String expectedValue) {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualValue, expectedValue);
			return soft;
		} catch (AssertionError e) {
			Assert.fail(e.getMessage() + "Actual value" + actualValue + "does not match with Expected Value"
					+ expectedValue);
			return null;
		}
	}
	
	/*
	 * Sleep
	 */

	public void threadSleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 */
	
	public WebElement findElement (By locator) {
		return driver.findElement(locator);
	}
	
	/*
	 * 
	 */
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);	
	}

}
