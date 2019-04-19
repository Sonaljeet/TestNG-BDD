/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import commonFunctions.WebElementCommon;
import commonFunctions.WebPage;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCM.Login.BCM_ChangePassword_Page_Action;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;

public class BCM_Setup_UserRole_Page_Test extends BaseClass{

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static BCM_Login_Page_Action loginPageAction = null;
	private static BCM_ChangePassword_Page_Action changePwdAction = null;
	private static BCM_Setup_Home_Page_Action setupHomePageAction = null;
	private static BCM_Setup_UserRole_Page_Actions userRoleAction = null;
	
	private static String BCMusername = "bcmsysagent";
	private static String BCMpassword = "Aug@2016";
	
	
	public void initialize(){
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		loginPageAction = new BCM_Login_Page_Action(driver, logger);
		changePwdAction = new BCM_ChangePassword_Page_Action(driver, logger);
		setupHomePageAction = new BCM_Setup_Home_Page_Action(driver, logger);
		userRoleAction = new BCM_Setup_UserRole_Page_Actions(driver, logger);
	}
	
	@Test(description="User Role - Verify new Admin user cannot access non-assigned modules")
	public void verifyRightsOfNewAdminUsers(Method method){
		loginPageAction.successfulLogin(BCMusername, BCMpassword);
		setupHomePageAction.setupLinkClick();
		setupHomePageAction.UserRoleLinkClick();
		userRoleAction.verifyAccessRightsForNewAdminUser();
	}
	
	@Test(description = "User Role - Verify all Admin users cannot access non-assigned modules")
	public void verifyRightsOfExistingAdminUsers(Method method){
		loginPageAction.successfulLogin(BCMusername, BCMpassword);
		setupHomePageAction.setupLinkClick();
		setupHomePageAction.UserRoleLinkClick();
		userRoleAction.verifyAccessRightsForAllAdminUser();
	}
}
