package mars.JCI.Project.DLS.Delete;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Delete_Test extends BaseClass {

	@Parameters({ "filename", "password" })
	@Test(description = "Deleting User Account Permanently")
	public void testDeleteAccount(String filename, String password) throws IOException {
		try {
			DLS_Delete_Page_Action deletePA = new DLS_Delete_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
		    deletePA.deleteAccount(filename);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
