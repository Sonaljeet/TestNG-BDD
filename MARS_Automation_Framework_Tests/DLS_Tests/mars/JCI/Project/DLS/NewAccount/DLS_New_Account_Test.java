package mars.JCI.Project.DLS.NewAccount;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_New_Account_Test extends BaseClass {
	@Parameters({ "useraccountname", "userphonenumber", "password","comment" })
	@Test(priority = 1, description = "Creates a New User Account Successfully")
	public void testSuccessfullNewAccount(String useraccountname, String userphonenumber, String password,String comment)
			throws IOException {
		try {
			DLS_New_Account_Page_Action newAccountPA = new DLS_New_Account_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			newAccountPA.correctUserAccount(useraccountname, userphonenumber,comment);
			getFinalReport(desktopDriver, logger, methodName, true);
			desktopDriver.marsSleep(3000);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

	@Parameters({ "userphonenumber", "password" })
	@Test(priority = 2, description = "Unable to Create a New User Account Without Entering Username")
	public void testNewAccountWithoutUsername(String userphonenumber, String password) throws IOException {
		try {
			DLS_New_Account_Page_Action newAccountPA = new DLS_New_Account_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			newAccountPA.withoutUsernameAccount(userphonenumber);
			getFinalReport(desktopDriver, logger, methodName, true);

			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

	@Parameters({ "useraccountname", "password" })
	@Test(priority = 3, description = "Unable to Create a New User Account Without Entering Phonenumber")
	public void testNewAccountWithoutPhonenumber(String useraccountname, String password) throws IOException {
		try {
			DLS_New_Account_Page_Action newAccountPA = new DLS_New_Account_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			newAccountPA.withoutPhonenumberUserAccount(useraccountname);
			getFinalReport(desktopDriver, logger, methodName, true);

			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
