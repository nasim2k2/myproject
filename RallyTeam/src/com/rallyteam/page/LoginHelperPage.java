package com.rallyteam.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.library.Utils.DriverHelper;
import com.rallyteam.Locator.LocatorReader;

public class LoginHelperPage extends DriverHelper{
	private LocatorReader locatorReader;
	
	public LoginHelperPage(WebDriver driver) {
		super(driver);
		locatorReader = new LocatorReader("rallyteamLocator.xml");
	}
	
	// Login into Application
		public void loginIntoApplication(String username, String password)
				throws InterruptedException {
			String UsrName= locatorReader.getLocator("LoginPage.WorkEmail");
			sendKeys(UsrName,username);
			String Pass= locatorReader.getLocator("LoginPage.Password");
			sendKeys(Pass,password);
			
			String SignInBtn=locatorReader.getLocator("LoginPage.SigninBtn");
			clickOn(SignInBtn);
			Thread.sleep(5000);
			verifyLoginSuccessfully();
		}
		
   //Verify Success message...
	public void verifyLoginSuccessfully() throws InterruptedException{
		String loc= locatorReader.getLocator("NavigationBar.ProfileIcon");
		WaitForElementPresent(loc, 50);
		Assert.assertTrue(isElementPresent(loc));		
		}
		
	}
