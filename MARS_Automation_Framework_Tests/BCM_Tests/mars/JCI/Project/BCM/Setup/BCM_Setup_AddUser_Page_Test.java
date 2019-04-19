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
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;


public class BCM_Setup_AddUser_Page_Test extends BaseClass{

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static BCM_Login_Page_Action loginPageAction = null;
	private static BCM_Setup_Home_Page_Action setupHomeAction = null;
	private static BCM_Setup_AddUser_Page_Action addUserActionPage = null;
	
	private static String username = "bcmsysagent";
	private static String password = "Aug@2016";
	
	
	private static void initialize() {
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		loginPageAction = new BCM_Login_Page_Action(driver, logger);
		setupHomeAction = new BCM_Setup_Home_Page_Action(driver, logger);
		addUserActionPage = new BCM_Setup_AddUser_Page_Action(driver, logger);
	}
	
	@Test(description="Add User - Verfiy Admin user can be added successfully on Add User Page")
	public void verifyAdminUserAddSuccessful(Method method) {
		String name = "admin1";
		String userId = "admin1";
		String userPassword = "Password@1";
		String emailAddress = "admin1@jci.com";
		String contactNumber = "8931973239";
		try {
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();

			boolean testStatus = addUserActionPage.verifyNewAdminUserCanBeCreatedSuccessfully(name, userId,
					userPassword, userPassword, contactNumber, emailAddress);

			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="Add User - Verify Customer user can be added successfully on Add User Page")
	public void verifyCustomerUserAddSuccessful(Method method) {
		String name = "Customer1";
		String userId = "Customer1";
		String userPassword = "Password@1";
		String emailAddress = "Customer1@jci.com";
		String contactNumber = "89319739";
		try {
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();

			boolean testStatus = addUserActionPage.verifyNewCustomerUserCanBeCreatedSuccessfully(name, userId,
					userPassword, userPassword, contactNumber, emailAddress);

			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="Add User - Verify Technician user can be added successfully on Add User Page")
	public void verifyTechnicianUserAddSuccessful(Method method) {
		String name = "Technician1";
		String userId = "Technician1";
		String userPassword = "Password@1";
		String emailAddress = "Technician1@jci.com";
		String contactNumber = "89313129";
		try {
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();

			boolean testStatus = addUserActionPage.verifyNewTechnicianUserCanBeCreatedSuccessfully(name, userId,
					userPassword, userPassword, contactNumber, emailAddress);

			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

	@Test(description="Add User - Verify existing user can be deleted successfully on Add User Page")
	public void verifyUserDeletedSuccessful(Method method){
		boolean testStatus = false;
		try {
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			
			testStatus=addUserActionPage.verifyExistingUserCanBeDeletedSuccessfully();
			
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="Add User - Verify error message for blank fields on Add User Page")
	public void verifyBlankMessageErroMessages(Method method){
		boolean testStatus = false;
		try {
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			
			testStatus= addUserActionPage.verifyErrorMessageForBlankFields();
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit AHU modules without access on Add User Page")
	public void verifyUserAccessRightsAHU(Method method){
		boolean testStatus=false;
		
		try {
			String name = "ahu1";
			String userId = "ahu1";
			String userPassword = "Password@1";
			String emailAddress = "ahu1@jci.com";
			String contactNumber = "232323";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForAHU(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}

	@Test(description="Add User - Verify that user cannot View/Edit VAV modules without access on Add User Page")
	public void verifyUserAccessRightsVAV(Method method){
		boolean testStatus=false;
		
		try {
			String name = "vav1";
			String userId = "vav1";
			String userPassword = "Password@1";
			String emailAddress = "vav1@jci.com";
			String contactNumber = "23234343";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForVAV(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit PAU modules without access on Add User Page")
	public void verifyUserAccessRightsPAU(Method method){
		boolean testStatus=false;
		
		try {
			String name = "pau1";
			String userId = "pau1";
			String userPassword = "Password@1";
			String emailAddress = "pau1@jci.com";
			String contactNumber = "8939739";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForPAU(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit FCU modules without access on Add User Page")
	public void verifyUserAccessRightsFCU(Method method){
		boolean testStatus=false;
		
		try {
			String name = "fcu1";
			String userId = "fcu1";
			String userPassword = "Password@1";
			String emailAddress = "FCU@jci.com";
			String contactNumber = "89319139";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForFCU(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit AC_PLANT modules without access on Add User Page")
	public void verifyUserAccessRightsAcPlant(Method method){
		boolean testStatus=false;
		
		try {
			String name = "acplant";
			String userId = "acplant";
			String userPassword = "Password@1";
			String emailAddress = "acplant@jci.com";
			String contactNumber = "897879739";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForAcPlant(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit Boiler modules without access on Add User Page")
	public void verifyUserAccessRightsBoiler(Method method){
		boolean testStatus=false;
		
		try {
			String name = "Boiler";
			String userId = "Boiler";
			String userPassword = "Password@1";
			String emailAddress = "Boiler@jci.com";
			String contactNumber = "893197393";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForBoiler(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit EXHAUST_FAN modules without access on Add User Page")
	public void verifyUserAccessRightsExhaustFan(Method method){
		boolean testStatus=false;
		
		try {
			String name = "EXHAUSTFAN";
			String userId = "EXHAUSTFAN";
			String userPassword = "Password@1";
			String emailAddress = "EXHAUST_FAN@jci.com";
			String contactNumber = "893197393";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForExhaustFan(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit SumpPump modules without access on Add User Page")
	public void verifyUserAccessRightsSumpPump(Method method){
		boolean testStatus=false;
		
		try {
			String name = "SumpPump";
			String userId = "SumpPump";
			String userPassword = "Password@1";
			String emailAddress = "SumpPump@jci.com";
			String contactNumber = "89317739";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForSumpPump(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="Add User - Verify that user cannot View/Edit Miscellaneous modules without access on Add User Page")
	public void verifyUserAccessRightsMiscellaneous(Method method){
		boolean testStatus=false;
		
		try {
			String name = "miscell1";
			String userId = "miscell1";
			String userPassword = "Password@1";
			String emailAddress = "miscell1@jci.com";
			String contactNumber = "89319999";
			initialize();
			loginPageAction.successfulLogin(username, password);
			setupHomeAction.setupLinkClick();
			setupHomeAction.AddUserLinkClick();
			testStatus = addUserActionPage.verifyUserAccessRightsForMiscellaneous(name, userId, userPassword, userPassword, contactNumber, emailAddress);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}	
/*	
	@Test(description="uweriwewiewei")
	public void scrollToChecBoxes(Method method){
		initialize();
		loginPageAction.successfulLogin(username, password);
		setupHomeAction.setupLinkClick();
		setupHomeAction.AddUserLinkClick();
		addUserActionPage.scrllToElementinView();
	}*/
	
	

	
	
}	












































