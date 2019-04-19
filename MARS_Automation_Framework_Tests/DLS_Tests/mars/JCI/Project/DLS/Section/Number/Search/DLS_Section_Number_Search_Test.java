package mars.JCI.Project.DLS.Section.Number.Search;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Section_Number_Search_Test extends BaseClass {

	@Parameters({ "Search", "correctpassword", "sectionnumber" })
	@Test(description = "This Test case is for Section Number Search On User Account Window")
	public void sectionNumberSearch(String searchuser, String correctpassword, String sectionnumber)
			throws IOException {

		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(correctpassword);
			DLS_Section_Number_Search_Page_Action sectionNumberPA = new DLS_Section_Number_Search_Page_Action(
					desktopDriver, logger);
			sectionNumberPA.openSearchAccount(searchuser);
			sectionNumberPA.selectSectionNumber(sectionnumber);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
}
