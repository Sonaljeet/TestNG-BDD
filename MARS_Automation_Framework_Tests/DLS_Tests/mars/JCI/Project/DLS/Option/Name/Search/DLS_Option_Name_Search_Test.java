package mars.JCI.Project.DLS.Option.Name.Search;

import java.io.IOException;

import org.testng.annotations.*;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Option_Name_Search_Test extends BaseClass {

	@Parameters({ "Search", "correctpassword", "optionname" })
	@Test(description = "This Test Case is for Option Name Search on User Account Window")
	public void optionNameSearch(String searchuser, String correctpassword, String optionname) throws IOException {

		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(correctpassword);
			DLS_Option_Name_Search_Page_Action optionNameSearchPA = new DLS_Option_Name_Search_Page_Action(
					desktopDriver, logger);
			optionNameSearchPA.openSearchAccount(searchuser);
			optionNameSearchPA.selectOptionName(optionname);
			getFinalReport(desktopDriver, logger, methodName, true);

			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
