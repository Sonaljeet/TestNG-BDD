package mars.JCI.Project.DLS.Search;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Search_Test extends BaseClass {
	@Parameters({ "search", "password" })
	@Test(description = "Searches User Account Successfully")
	public void testSearchAccount(String Search, String password) throws IOException {
		try {
			DLS_Search_Page_Action searchPA = new DLS_Search_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			searchPA.correctAccountSearch(Search);
			getFinalReport(desktopDriver, logger, methodName, true);

			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}

	}
}
