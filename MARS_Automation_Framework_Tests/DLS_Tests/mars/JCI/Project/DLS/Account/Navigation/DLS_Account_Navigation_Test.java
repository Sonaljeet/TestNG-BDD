package mars.JCI.Project.DLS.Account.Navigation;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DLS.Account.Navigation.DLS_Programming_Groups_Page_Action;
import mars.JCI.Project.DLS.Account.Navigation.DLS_Toolbar_Navigation_Page_Action;
import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Account_Navigation_Test extends BaseClass {

	@Parameters({ "Search", "correctpassword" })
	@Test(priority = 1, description = "This Test Case is for Navigating Through Programming Groups Tabs Of User Account")
	public void programmingGroupsNavigation(String searchuser, String correctpassword) throws IOException {

		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(correctpassword);
			DLS_Programming_Groups_Page_Action programmingPA = new DLS_Programming_Groups_Page_Action(desktopDriver,
					logger);
			if (programmingPA.openSearchAccount(searchuser) > 0) {
				System.out.println("in test if");
				programmingPA.clickProgrammingGroupsTabs(searchuser);
			}
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}

	}

	@Parameters({ "Search", "correctpassword" })
	@Test(priority = 2, description = "This Test Case is for Navigating Through Toolbar Tabs Of User Account")
	public void toolbarNavigation(String searchuser, String correctpassword) throws IOException {

		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(correctpassword);
			DLS_Toolbar_Navigation_Page_Action toolbarPA = new DLS_Toolbar_Navigation_Page_Action(desktopDriver,
					logger);
			if (toolbarPA.openSearchAccount(searchuser)>0) {
				System.out.println("in test if");
				toolbarPA.clickToolbarTabs(searchuser);
			}
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
}
