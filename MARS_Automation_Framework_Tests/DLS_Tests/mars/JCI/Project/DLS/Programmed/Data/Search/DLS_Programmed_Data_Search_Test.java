package mars.JCI.Project.DLS.Programmed.Data.Search;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Programmed_Data_Search_Test extends BaseClass {

	@Parameters({ "Search", "correctpassword", "programmeddataname" })
	@Test(description = "This Test Case is for Programmed Data Search On User Account Window")
	public void optionNameSearch(String searchuser, String correctpassword, String programmeddataname)
			throws IOException {

		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(correctpassword);
			DLS_Programmed_Data_Search_Page_Action optionNameSearchPA = new DLS_Programmed_Data_Search_Page_Action(
					desktopDriver, logger);
			optionNameSearchPA.openSearchAccount(searchuser);
			optionNameSearchPA.selectProgrammedData(programmeddataname);
			getFinalReport(desktopDriver, logger, methodName, true);

			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
