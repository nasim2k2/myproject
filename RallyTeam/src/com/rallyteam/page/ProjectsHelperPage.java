package com.rallyteam.page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.library.Utils.DriverHelper;
import com.rallyteam.Locator.LocatorReader;

public class ProjectsHelperPage  extends DriverHelper{
	
      private LocatorReader locatorReader;
	
   public ProjectsHelperPage(WebDriver driver) {
		super(driver);
		locatorReader = new LocatorReader("rallyteamLocator.xml");
	   }
	
	//Click on 'Add project' button
	public void clickOnAddProjectButton() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.AddProjectBtn");
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));
		clickOn(loc);
					
	   }
	
	//Click on 'Suggested project' button
	public void clickOnSuggestedProjectButton() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.SuggestedProjectBtn");
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));
		clickOn(loc);
						
		}
	
	//Assert the add project dialog
	public void assertAddProjectDialog() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.AddProjectDlg");
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));
							
		}
	
	//Enter project name
	public void enterNewPojectName(String ProjectName) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.NameField");
		WaitForElementPresent(loc, 30);
		sendKeys(loc, ProjectName);
						
		}
	
	//Enter project Description
	public void enterNewPojectDescription(String ProjectDesc) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.DescriptionField");
		WaitForElementPresent(loc, 30);
		sendKeys(loc, ProjectDesc);
							
		}
		
	//Click on 'Suggested project' button
	 public void clickOnCreateButton() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.CreateBtn");
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));
		clickOn(loc);
							
		}
	 
	//Click on 'Suggested project' button
	 public void selectProjectType(String PrjctType) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.ProjectType");
		loc=loc.replace("@variable", PrjctType);
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));
		clickOn(loc);					
	   }
	 
	//Click on 'Add member' button
	 public void clickOnAddMemberButton() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.AddMemberButton");
		scrollIntoView(loc);
		WaitForElementPresent(loc, 30);
		clickOn(loc);					
		}
	 
	//Enter project Description
	 public void enterMemberName(String memberName) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.MemberName");
		WaitForElementPresent(loc, 30);
		sendKeys(loc, memberName);		
		}
	 

	public void selectUserfromsuggestion(String SuggItem) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.Suggitem");
		loc=loc.replace("@variable", SuggItem);
		Thread.sleep(5000);
		WaitForElementPresent(loc, 50);
		clickOn(loc);
		}
	
	public void clickOnthePlusIcon() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.PlusIcon");
		WaitForElementPresent(loc, 50);
		clickOn(loc);
		}

	public void assertAddedMember(String AddedMember) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.addedmember");
		loc=loc.replace("@variable", AddedMember);
		scrollIntoView(loc);
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));
						
		}

	public void clickOnDoneButton() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.DoneBtn");
		WaitForElementPresent(loc, 30);
		clickOn(loc);					
		}
	
	public void assertConfirmationMessage() throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.confirmationmessage");
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc));					
		} 
	
	public void selectOptionFromProjectMenu(String dropdwnoptn) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.AllProjectDrpdwnLink");
		WaitForElementPresent(loc, 30);
		clickOn(loc);
		String DrpdwnOptn= locatorReader.getLocator("Projects.DroDownMenu");
		DrpdwnOptn=DrpdwnOptn.replace("@variable", dropdwnoptn);
		WaitForElementPresent(loc, 30);
		clickOn(DrpdwnOptn);
		} 
	
	public void clickOnProjectTitle(String Projectname) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.ProjectTitle");
		loc=loc.replace("@variable", Projectname);
		WaitForElementPresent(loc, 30);
		clickOn(loc);					
		}
	
	
	public void clickProjectsNavTab(String TabName) throws InterruptedException{
		String loc= locatorReader.getLocator("Projects.NavTab");
		loc=loc.replace("@variable", TabName);
		WaitForElementPresent(loc, 30);
		clickOn(loc);					
		}
	
	//Enter project Description
	public void enterTextIntoDisscussionMessageField(String DisscText) throws InterruptedException{
		String loc= locatorReader.getLocator("Disscussion.MsgTxtFld");
		WaitForElementPresent(loc, 30);
		enterValueIntoTextField(loc, DisscText);		
		}
	

	public void clickOnDiscussionMsgTextField() throws InterruptedException{
		String loc= locatorReader.getLocator("Disscussion.MsgTxtFld");
		WaitForElementPresent(loc, 30);
		clickOn(loc);					
		}
	
	public void selectUserFromSuggestionForDiscussion(String SuggUser) throws InterruptedException{
		String loc= locatorReader.getLocator("Disscussion.SuggstionList");
		loc=loc.replace("@variable", SuggUser);
		Thread.sleep(5000);
		WaitForElementPresent(loc, 50);
		clickOn(loc);
		}
	
	public void clickOnPostButton() throws InterruptedException{
		String loc= locatorReader.getLocator("Disscussion.PostBtn");
		WaitForElementPresent(loc, 30);
		clickOn(loc);					
		}
	
	public void assertLastSentMessage(String Message, String Username) throws InterruptedException{
		String loc= locatorReader.getLocator("Disscussion.MessageSent");
		String loc1=loc.replace("@message", Message);
		loc1=loc1.replace("@username", Username);
		WaitForElementPresent(loc, 30);
		Assert.assertTrue(isElementPresent(loc1));					
		}
}
