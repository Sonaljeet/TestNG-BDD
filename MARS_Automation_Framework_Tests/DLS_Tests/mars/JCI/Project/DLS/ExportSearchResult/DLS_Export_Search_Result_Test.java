package mars.JCI.Project.DLS.ExportSearchResult;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Export_Search_Result_Test extends BaseClass {

	@Parameters({ "search", "password" })
	@Test(description = " Exported Successfully User Search Result")
	public void testSuccessfullExportSearch(String search, String password) throws IOException {
		try {
			DLS_Export_Search_Result_Page_Action exportSearchPA= new DLS_Export_Search_Result_Page_Action(desktopDriver,
					logger);
			DLS_Login_Page_Action loginPA= new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			exportSearchPA.exportSearchResult(search);
			desktopDriver.marsSleep(1000);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
