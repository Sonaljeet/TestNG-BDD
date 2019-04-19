/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;

public class BCM_Setup_Home_Page_Test extends BaseClass{

	private static WebDriver driver=null;
	private static ExtentTest logger = null;
	private static String browserName="";
	private static String testDescription=null;
	private static BCM_Setup_Home_Page_Action homePageAction=null;
	private static BCM_Login_Page_Action loginPageAction = null;
	
	private static void initialize(){
		driver=BaseClass.driver;
		logger=BaseClass.logger;
		browserName=BaseClass.browserName;
		loginPageAction=new BCM_Login_Page_Action(driver, logger);
		homePageAction=new BCM_Setup_Home_Page_Action(driver, logger);
	}
	//@Test(description= "Setup Link clicked")
	public void verifySetupLinkIsClicked(Method method){
		initialize();
		boolean testStatus=false;
		loginPageAction.successfulLogin("metasyssysagent", "Aug@2016");
		boolean linkClickStatus = homePageAction.setupLinkClick();
		if (linkClickStatus) {
			testStatus=true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
	
	@Test(description = "Verify only Setup link appear after first login")
	public void verifyOnlySetupLinkAppearAfterFirstLogin(Method method){
		initialize();
		boolean linkDisplayStatus=false;
		boolean testStatus=false;
		linkDisplayStatus=homePageAction.verifyOnlySetupLinkDisplayedAfterFirstLogin("bcmsysagent", "Aug@2016");
		
		if (linkDisplayStatus) {
			testStatus=true;
		}else{
			testStatus=false;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		
	}
	
	//@Test(description = "Verify All links(like Contact info, etc) are displayed when on Setup link click")
	public void verifySetupLinkClickDisplaysAllLinks(Method method){
		initialize();
		boolean allLinksDisplayStatus=false;
		boolean testStatus=false;
		
		allLinksDisplayStatus=homePageAction.verifyAllSetupModulesAreDisplayedOnSetupLinkClick("bcmsysagent", "Aug@2016");
		
		if (allLinksDisplayStatus) {
			testStatus=true;
		}else{
			testStatus=false;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Verfiy all Sidebar links dislpay for admin user")
	public void verifySideBarLinksShowForAdminUser(Method method){
		initialize();
		boolean allLinksDisplayStatus=false;
		boolean testStatus=false;
		
		allLinksDisplayStatus=homePageAction.verfiyAllLinksDisplayedOnSetupPageForAdminUser("bcmsysagent", "Aug@2016");
	
		if (allLinksDisplayStatus) {
			testStatus=true;
		}else{
			testStatus=false;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
