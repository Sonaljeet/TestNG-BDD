package mars.JCI.Project.DES.UsersRole;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.VPPGroup.DES_VPPGroup_Page_Action;

public class DES_UsersRole_Page_Test extends BaseClass {
	// Test Cases for navigation to Users Role tab
	@Test (priority=1, description="Performs a checks whether user able to	navigate to Users-Role Page")
	public void testNavigationToUserstab() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRole_Page_Action rolePA = new DES_UsersRole_Page_Action(driver, logger);
			rolePA.navigateToUsersRolePage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for addition of new Role to system
	@Test(priority = 1, description = "Performs a checks whether user able to Add a Role to Users-Role Page")
	public void testAddRole() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRole_Page_Action rolePA = new DES_UsersRole_Page_Action(driver, logger);
			rolePA.addRole();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for update of new Role to system
	@Test(priority = 1, description = "Performs a checks whether user able to Update a Role to Users-Role Page")
	public void testUpdateRole() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRole_Page_Action rolePA = new DES_UsersRole_Page_Action(driver, logger);
			rolePA.UpdateRole();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for delete of new Role to system
	 @Test(priority = 1, description = "Performs a checks whether user able to delete a Role to Users-Role Page")
	public void testDeleteRole() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRole_Page_Action rolePA = new DES_UsersRole_Page_Action(driver, logger);
			rolePA.deleteRole();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for checks whether Role added is present on Roles & Rights tab
	@Test(priority = 1, description = "Performs a checks whether Role added is present on Roles & Rights tab")
	public void testRoleAvailabilityOnMultiplePages() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRole_Page_Action rolePA = new DES_UsersRole_Page_Action(driver, logger);
			rolePA.verifyRoleAvailabilityOnMultiplePages();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for checks clear button functionality
  @Test(priority = 1, description = "Performs a checks for clear button functionality ")
	public void testClearButton() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_UsersRole_Page_Action rolePA = new DES_UsersRole_Page_Action(driver, logger);
			rolePA.verifyClearButton();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
