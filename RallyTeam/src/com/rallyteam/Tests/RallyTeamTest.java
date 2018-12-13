package com.rallyteam.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.library.Utils.DriverHelper;
import com.library.Utils.DriverTestCase;
import com.library.Utils.ExecutionLog;
import com.library.Utils.PropertyReader;
import com.rallyteam.Data.ReadDataFromExcelSheet;
import com.rallyteam.page.HomeHelperPage;
import com.rallyteam.page.LoginHelperPage;
import com.rallyteam.page.ProjectsHelperPage;
import com.rallyteam.page.RegistrationHelperPage;



public class RallyTeamTest extends DriverTestCase {
	
	
		private RegistrationHelperPage registration;
		private LoginHelperPage login;
		private HomeHelperPage homepage;
		private ProjectsHelperPage projectpage;
		
		PropertyReader propertyReader=new PropertyReader();
		String username=propertyReader.readApplicationFile("Username","//src//com//rallyteam//Config//application.properties");	
		String password=propertyReader.readApplicationFile("Password","//src//com//rallyteam//Config//application.properties");		
		String projectpath=new PropertyReader().getPath();
		ReadDataFromExcelSheet sheet = new ReadDataFromExcelSheet(projectpath+"\\Src\\com\\rallyteam\\Data\\TestData.xlsx");
	//	String dateStr= DriverHelper.getSystemTimeSeconds();
		String dateStr= DriverHelper.getSystemTime();
		
	    @BeforeMethod
	    public void SetUp() throws Exception
	    {
	        
	    	setup("//src//com//rallyteam//Config//application.properties");
			registration       = new RegistrationHelperPage(getWebDriver());			
			login              = new LoginHelperPage(getWebDriver());
			homepage           = new HomeHelperPage(getWebDriver());
			projectpage        =new  ProjectsHelperPage(getWebDriver());
			ExecutionLog.LogAddClass(this.getClass().getName()+" >> "+new Exception().getStackTrace()[0].getMethodName());
			
	    }
	    
		@Test
		public void testRegistrationProcess() throws Exception{			
         try{
        	
        	 System.out.println("\n*****Start Execution testRegistrationProcess*****\n");
        	 
			//Click 'create an account' Link
			registration.clickNeedAnAccountLink();
			ExecutionLog.Log("Clicked Sign Up button");
		
			//Verify that the user is at Registration page
			registration.verifyCreateAccountPage();
			ExecutionLog.Log("Verified Registration user is at sign up page");
	    
			//Enter Data into 'First Name' field
			registration.enterFirstName(sheet.getCellData("TestData", "FirstName", 2)+dateStr);
			ExecutionLog.Log("Entered "+ sheet.getCellData("TestData", "FirstName", 2)+dateStr +" into First name field ");

			//Enter Data into 'Last Name' field
			registration.enterLastName(sheet.getCellData("TestData", "LastName", 2)+dateStr);
			ExecutionLog.Log("Entered "+ sheet.getCellData("TestData", "LastName", 2)+dateStr +" into Last name field ");
		
			//Enter Data into 'Work Email' field
		    registration.enterWorkEmail(sheet.getCellData("TestData", "FirstName", 2) + dateStr+"@gmail.com"); 
		    ExecutionLog.Log("Entered "+ sheet.getCellData("TestData", "FirstName", 2)+dateStr+"@gmail.com" +" into Last name field ");
		    	
			//Enter Data into 'Password' field
			registration.enterPassword(sheet.getCellData("TestData", "Password", 2));
			ExecutionLog.Log("Entered "+ sheet.getCellData("TestData", "Password", 2)+" into Password field ");
			
			//Enter Data into 'Confirm Password' field
			registration.enterConfirmPassword(sheet.getCellData("TestData", "ConfirmPassword", 2));
			ExecutionLog.Log("Entered "+ sheet.getCellData("TestData", "ConfirmPassword", 2)+" into Confirm Password field ");
			
			//Click on 'Get started' button
		    registration.clickGetStartedButton();
		    ExecutionLog.Log("User click on the 'Get Started' Button");
	        Thread.sleep(5000);
		    // Verify the success message		    
		    registration.verifySuccessMessage();
		    ExecutionLog.Log("verify the success message of registration");
						
         }	catch(Error e) 
 		   {
 			captureScreenshot("testRegistrationProcess");	
 			ExecutionLog.LogErrorMessage(e);
 			throw e;
 		    } 
 		   catch(Exception e) 
 		    {
 			captureScreenshot("testRegistrationProcess");
 			ExecutionLog.LogExceptionMessage(e);
 			throw e;
 		    }	
		
		}

		@Test
		public void testCreateAProjectAndAddAnUserIntoProject() throws Exception{			
         try{
        	
        	System.out.println("\n*****Start Execution testCreateAProjectAndAddAnUserIntoProject*****\n");
        	
        	//Login Into the application 
			login.loginIntoApplication(username, password);
			ExecutionLog.Log("Login Into the application");
			
			//Click on the side navigation link 'Project' 
			Thread.sleep(5000);
			homepage.clickOnSideNavigation("Projects");
			ExecutionLog.Log("Click on the side navigation link 'Project'");
			
			// Click on the Add Project button at projects page
			Thread.sleep(500);
			projectpage.clickOnAddProjectButton();
			ExecutionLog.Log("Click on the Add Project button at projects page");
			
			//Verify the add project form dialog
			projectpage.assertAddProjectDialog();
			ExecutionLog.Log("Verify the add project form dialog");
			
			//Enter the name of Projects
			String ProjectName=sheet.getCellData("AddProject", "ProjectName", 2)+dateStr;
			projectpage.enterNewPojectName(ProjectName);
			ExecutionLog.Log("Entered "+ sheet.getCellData("AddProject", "ProjectName", 2)+dateStr +" into Project name field ");
			
			//Enter text into description field at add project form 
			projectpage.enterNewPojectDescription(sheet.getCellData("AddProject", "ProjectDescription", 2));
			ExecutionLog.Log("Entered "+ sheet.getCellData("AddProject", "ProjectDescription", 2) +" into Project description field ");
			
			//Click on the create button at add project form
			projectpage.clickOnCreateButton();
			ExecutionLog.Log("Click on the create button at add project form");
			
			//select project type as 'Just for me' option
			projectpage.selectProjectType("Just for Me");
			ExecutionLog.Log("select project type as 'Just for me' option");
			
			// Click on the add new member button into the project
			Thread.sleep(5000);
			projectpage.clickOnAddMemberButton();
			ExecutionLog.Log(" Click on the add new member button into the project");
			
			// Enter text into member field
			projectpage.enterMemberName("globo");
			ExecutionLog.Log("Enter text into member field");
			Thread.sleep(5000);
			
			//select user from suggestion 			
			projectpage.selectUserfromsuggestion("360.73@gmail.com");
			ExecutionLog.Log("select user from suggestion");
			Thread.sleep(500);
			
			//click plus icon at add member page
			projectpage.clickOnthePlusIcon();
			ExecutionLog.Log("click plus icon at add member page");
			
			//Verify the member is added on add member page
			Thread.sleep(500);
			projectpage.assertAddedMember("globo lewis");
			ExecutionLog.Log("Verify the member is added on add member page");
			
			//Click 'Done' button at Add member page
			projectpage.clickOnDoneButton();
			ExecutionLog.Log("Click 'Done' button at Add member page");
			
            // user navigate to 'Projects' page by clicking on side nav
			Thread.sleep(5000);
			homepage.clickOnSideNavigation("Projects");
			ExecutionLog.Log("user navigate to 'Projects' page by clicking on side nav");
			
			// Select option form  project menu as 'My Project'
			Thread.sleep(500);
			projectpage.selectOptionFromProjectMenu("My Projects");
			ExecutionLog.Log("Select option form  project menu as 'My Project'");
			
			//Click on newly created project
			Thread.sleep(5000);
			projectpage.clickOnProjectTitle(ProjectName);
			ExecutionLog.Log("Click on newly created project");
			
			//Click on newly created project
			Thread.sleep(5000);
			projectpage.assertAddedMember("globo lewis");
			ExecutionLog.Log("Verify the member is added in project at project detail page");
			
         }	catch(Error e) 
 		   {
 			captureScreenshot("testCreateAProjectAndAddAnUserIntoProject");	
 			ExecutionLog.LogErrorMessage(e);
 			throw e;
 		    } 
 		   catch(Exception e) 
 		    {
 			captureScreenshot("testCreateAProjectAndAddAnUserIntoProject");
 			ExecutionLog.LogExceptionMessage(e);
 			throw e;
 		    }	
		
		}
		
		@Test
		public void testPostingAMessageInTheDiscussionFeed() throws Exception{			
         try{
        	
        	System.out.println("\n*****Start Execution testPostingAMessageInTheDiscussionFeed*****\n");
        	
        	//Login Into the application 
			login.loginIntoApplication(username, password);
			ExecutionLog.Log("Login Into the application");
			Thread.sleep(5000);
			
			//Click on the side navigation link 'Project' 
			homepage.clickOnSideNavigation("Projects");
			ExecutionLog.Log("Click on the side navigation link 'Project'");
			Thread.sleep(500);

			// Select option form  project menu as 'My Project'
			String ProjectName=sheet.getCellData("AddProject", "ProjectName", 2);
			projectpage.selectOptionFromProjectMenu("My Projects");
			ExecutionLog.Log("Select option form  project menu as 'My Project'");
			Thread.sleep(5000);
			
			//Click on newly created project
			projectpage.clickOnProjectTitle(ProjectName);
			ExecutionLog.Log("Click on newly created project");
			Thread.sleep(5000);
			
			//Navigated to to Discussion tab
			projectpage.clickProjectsNavTab("Discussions");
			ExecutionLog.Log("Navigated to to Discussion tab");	
			
			//Click on discussion message text fields
			projectpage.clickOnDiscussionMsgTextField();
			ExecutionLog.Log("Click on discussion message text fields");
			Thread.sleep(500);
			
			// Enter text into discussion message field
			projectpage.enterTextIntoDisscussionMessageField("@globo");
			ExecutionLog.Log("Enter text into discussion message field");
			Thread.sleep(5000);
			
			//select user from suggestion list
			projectpage.selectUserFromSuggestionForDiscussion("test360.73@gmail.com");
			ExecutionLog.Log("Select user from suggestion list");
			Thread.sleep(5000);
			
			// Enter message into discussion field
			String message= "Hello Lewis : " +dateStr;
			projectpage.enterTextIntoDisscussionMessageField(message);
			ExecutionLog.Log("Enter message into discussion field");
			
			//Click on post button
			projectpage.clickOnPostButton();
			ExecutionLog.Log("Click on post button");
			Thread.sleep(5000);
			
			//verify that last sent message and user name
			projectpage.assertLastSentMessage(message, "@globolewis");
			ExecutionLog.Log("verify that last sent message and user name");
			
         }	catch(Error e) 
 		   {
 			captureScreenshot("testPostingAMessageInTheDiscussionFeed");	
 			ExecutionLog.LogErrorMessage(e);
 			throw e;
 		    } 
 		   catch(Exception e) 
 		    {
 			captureScreenshot("testPostingAMessageInTheDiscussionFeed");
 			ExecutionLog.LogExceptionMessage(e);
 			throw e;
 		    }	
		
		}
		
  /*@AfterMethod
   public void CloseBrowser() throws Exception
     {
		getWebDriver().quit();
	 }*/
		   
	
}

