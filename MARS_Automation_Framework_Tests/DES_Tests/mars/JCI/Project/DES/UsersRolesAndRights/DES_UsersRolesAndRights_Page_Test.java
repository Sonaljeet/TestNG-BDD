package mars.JCI.Project.DES.UsersRolesAndRights;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.UsersRole.DES_UsersRole_Page_Action;
import mars.JCI.Project.DES.UsersRolesRights.DES_UsersRolesRights_Page_Action;

public class DES_UsersRolesAndRights_Page_Test extends BaseClass {
	// Test Cases for navigation to Users Roles & Rights tab
	@Test(priority = 1, description = "Performs a checks whether user able to	navigate to Users-Roles & Rights Page")
	public void testNavigationToRolesAndRightstab() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRolesRights_Page_Action rolerPA = new DES_UsersRolesRights_Page_Action(driver, logger);
			rolerPA.navigateToRoleAndRightTab();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test case for selection of newly created role on roles 7 rights tab
	@Test(priority = 2, description = "Test case for selection of newly created role on roles & Rights tab")
	public void testSelectRoleAdded() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRolesRights_Page_Action rolerPA = new DES_UsersRolesRights_Page_Action(driver, logger);
			//loginPA.DES_CorrectLogin();
			rolerPA.assignAllRightsToRoles();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);

		}

	}
}
