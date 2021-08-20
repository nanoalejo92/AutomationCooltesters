package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.opensource.admin.AdminPage;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;
import com.opensource.main.LoginPage;

public class TC001_Admin_SearchEmployee_POM {
	
	WebDriver driver;
	Base base;
	LoginPage login;
	AdminPage admin;
	String username, password, username2;
 
  @BeforeTest
  public void beforeTest() {
	  
	  // Set up driver
	  base = new Base(driver);
	  driver = base.chromeDriver();
	  login = new LoginPage(driver);
	  admin = new AdminPage(driver);
	  
	  //Test Data
	  this.username = "Admin";
	  this.password = "admin123";		
	  this.username2 = "Admon";
  }
  
  @Test
  public void TC001_Admin_SearchEmployee_POM_Script() {
	  
	  // Step 1
	  base.launchBrowser();
	  
	  // Step 2
	  login.loginOrange(username, password);
	  
	  // Step 3
	  admin.validateLogged();
	  
	  // Step 4 -7 
	  admin.verifyUserExistsTableAfterClickSearch(username2);
	  
	  // Step 8 - 9
	  
	  login.logoutOrange();
	  	  
  }

  @AfterTest
  public void afterTest() {
  }

}
