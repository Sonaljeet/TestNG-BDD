package mars.JCI.Project.DLS.Main.Navigation;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;
import mars.JCI.Project.DLS.Main.Navigation.DLS_Main_Navigation_Page_Action;

public class DLS_Main_Navigation_Test extends BaseClass {

	@Parameters({ "correctpassword" })
	@Test(priority = 1, description = "This Test Case is for Navigating Through DLS Main Window Tabs")
	public void mainWindowTabNavigation(String correctpassword) throws IOException {

		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(correctpassword);
			DLS_Main_Navigation_Page_Action mainPA = new DLS_Main_Navigation_Page_Action(desktopDriver, logger);
			mainPA.clickMainWindowTabs();
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}

	}

}
