package mars.JCI.Project.DES.User;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;

public class DES_User_Page_Test extends BaseClass {

	// Test Cases for addition of new user in system with Admin
	// @Test(priority = 1, description = "Performs a checks whether user able to Add a Role to Users-Role Page, Assign Rights to Role & Create user with same Role")
	public void testAddAdminRole() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_User_Page_Action userPA = new DES_User_Page_Action(driver, logger);
			userPA.createUser();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for addition of new user in system with Admin
	@Test(priority = 1, description = "Performs a checks whether user able to Add a Role to Users")
	public void testAddUser() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_User_Page_Action userPA = new DES_User_Page_Action(driver, logger);
			userPA.createSuperAdminUser();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	// Test Cases for addition of new user in system with Admin
//		@Test(priority = 3, description = "Performs a checks whether user able to update Users Details ")
		public void testUpdateUser() throws IOException {
			try {
				DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
				DES_User_Page_Action userPA = new DES_User_Page_Action(driver, logger);
				userPA.updateUser();
				getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
				getFinalReport(driver, logger, methodName, false);
			}
		}

		
		// Test Cases for addition of new user in system with Admin
//		@Test(priority = 4, description = "Performs a checks whether user able to Delete Users ")
		public void testDeleteUser() throws IOException {
			try {
				DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
				DES_User_Page_Action userPA = new DES_User_Page_Action(driver, logger);
				userPA.deleteUser();
				getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
				getFinalReport(driver, logger, methodName, false);
			}
		}	
}
