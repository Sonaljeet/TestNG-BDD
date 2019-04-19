package mars.JCI.Project.DES.UserSiteMapping;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.User.DES_User_Page_Action;

public class DES_UserSiteMapping_Page_Test extends BaseClass {
//	@Test(priority = 1, description = "Performs a checks whether user able to Navigate to User Site Mapping Page")
	public void testNavigateToUserSiteMappingTab() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UserSiteMapping_Page_Action userSM = new DES_UserSiteMapping_Page_Action(driver, logger);
			userSM.navigateToUserSiteMappingTab();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "Assign sites to User from User Site Mapping Page")
	public void testAssignSiteToUser() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UserSiteMapping_Page_Action userSM = new DES_UserSiteMapping_Page_Action(driver, logger);
			userSM.createAndAssignSitesToUser();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

//	@Test(priority = 1, description = "Post Creation of Role and Assigning Site Verify if the newly created User is able to Login ")
	public void testLoginWithNewlyCreateduser() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UserSiteMapping_Page_Action userSM = new DES_UserSiteMapping_Page_Action(driver, logger);
			userSM.validateUserIsAbletoLogin();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
