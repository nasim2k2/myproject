package com.rallyteam.page;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.library.Utils.DriverHelper;
import com.library.Utils.ExecutionLog;
import com.library.Utils.PropertyReader;
import com.rallyteam.Locator.LocatorReader;

public class RegistrationHelperPage extends DriverHelper{

	private LocatorReader locatorReader;
	private PropertyReader propertyReader;	
	Screen screen = new Screen();
	
	public RegistrationHelperPage(WebDriver driver) {
		super(driver);	
		locatorReader = new LocatorReader("rallyteamLocator.xml");
		 propertyReader=new PropertyReader();
	}
	

	
	//click 'Sign Up' button..
	public void clickNeedAnAccountLink() throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.SignUpLink");
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));
		ExecutionLog.Log("Verified Sign Up Now button is displayed");
		clickOn(loc);
	
	}
	
	//Verify that Registration - Review Checklist page is displayed when user clicks on Sign Up Now button
	public void verifyCreateAccountPage() throws InterruptedException{
		Thread.sleep(4000);
		String loc= locatorReader.getLocator("Registration.Registrationpageheader");
		Assert.assertTrue(isElementPresent(loc));
		
	}
	
	//Verify that Sign Up Now button is displayed.	
	public void verifyNeedAnAccountLink() throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.SignUpLink");
		Assert.assertTrue(isElementPresent(loc));
		
	}
	
	//Enter data into 'First Name' field..
	public void enterFirstName(String data) throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.FirstName");
		sendKeys(loc,data);
			
	}
	
	//Enter data into 'Last Name' field..
	public void enterLastName(String FirstName ) throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.LastName");
		sendKeys(loc,FirstName);
			
	}
	
	//Enter data into 'work email' field..
	public void enterWorkEmail(String WorkEmail ) throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.WorkEmail");
		sendKeys(loc,WorkEmail);
			
	}
	
	//Enter data into 'Password' field..
	public void enterPassword(String password ) throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.CreatePassword");
		sendKeys(loc,password);
			
	}
	
	//Enter data into 'Confirm Password' field..
	public void enterConfirmPassword(String Confpassword ) throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.ConfirmPassword");
		sendKeys(loc,Confpassword);
			
	}
	
	//Click on 'Get Started' Button
	public void clickGetStartedButton() throws InterruptedException{
		String loc= locatorReader.getLocator("Registration.GetStartedBtn");
		clickOn(loc);
	
	}
	
	
    //Verify Success message...
	public void verifySuccessMessage() throws InterruptedException{
			String loc= locatorReader.getLocator("Registration.confirmationmessage");
			Assert.assertTrue(isElementPresent(loc));
			
		}
		
		//Enter data into 'User Name' field..
		public void enterDataIntoUserName(String data ) throws InterruptedException{
			String loc= locatorReader.getLocator("Registration.UserNameField");
			sendKeys(loc,data);
				
		}
		
		//Click the 'Next' button..
		public void clickLoginNextButton() throws InterruptedException{
			String loc= locatorReader.getLocator("Registration.LoginNextButton");
			clickOn(loc);
		
		}
		
}
