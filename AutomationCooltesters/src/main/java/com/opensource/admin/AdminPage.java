package com.opensource.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.opensource.base.Base;

public class AdminPage extends Base {

	public AdminPage(WebDriver driver) {
		super(driver);
	}

	// Objects
	By imgHeaderOrange = By.xpath("//img[@alt='OrangeHRM']");
	By lnkAdmin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txtSearchUsername = By.xpath("//input[@id=\"searchSystemUser_userName\"]");
	By btnSearch = By.xpath("//input[@id='searchBtn']");
	By tblUsername = By.xpath("//tbody/tr[1]/td[2]");
	By tblresultTable = By.xpath("//table[@id='resultTable']");
	By tbltableCriteria = By.tagName("tr");
	By tblrandomUser = By.xpath("//tbody/tr[" + randUserrow + "]/td[2]");

	public void validateLogged() {
		reporter("Validate Logged successfully");
		waitForElementPresent(imgHeaderOrange);

	}

	public void clickAdmin() {
		reporter("Click admin module");
		click(lnkAdmin);
		implicitlyWait();

	}

	public void searchUser(String username) {
		reporter("Searching...." + username);
		type(txtSearchUsername, username);
		click(btnSearch);
		implicitlyWait();
	}

	public void validateUsernameTable(String username) {
		reporter("Validate this value:" + username + "in Admin user table");
		assertEquals(getText(tblUsername), username);
		softAssertion(getText(tblUsername), username);

	}

	/*
	 * Verify user exit in table after click search
	 * 
	 * @param (wrapper)
	 */

	public void verifyUserExistsTableAfterClickSearch(String username) {
		clickAdmin();
		searchUser(username);
		validateUsernameTable(username);
	}

	public void selectRandomUser(String xpathText) {

		WebElement table = findElement(tblresultTable);
		List<WebElement> rows = findElements(tbltableCriteria);
		int randUserrow = ((int) (Math.random() * (rows.size() - 0)) + 0);
		findElement(tblrandomUser).getText();
		type(txtSearchUsername, xpathText);
		click(btnSearch);
		findElement(tblUsername).getText();
		Assert.assertEquals(tblUsername, tblrandomUser);

	}

}
