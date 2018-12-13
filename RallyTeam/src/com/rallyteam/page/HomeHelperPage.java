package com.rallyteam.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.library.Utils.DriverHelper;
import com.rallyteam.Locator.LocatorReader;

public class HomeHelperPage extends DriverHelper{
private LocatorReader locatorReader;
	
	public HomeHelperPage(WebDriver driver) {
		super(driver);
		locatorReader = new LocatorReader("rallyteamLocator.xml");
	}
	
	//Click on 'side navigation'
	public void clickOnSideNavigation(String NavName) throws InterruptedException{
	   String loc= locatorReader.getLocator("NavigationBar.SideNav");
	   loc=loc.replace("@variable", NavName);
	   Assert.assertTrue(isElementPresent(loc));
	   clickOn(loc);
				
	}
}
