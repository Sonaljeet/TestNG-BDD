package mars.JCI.Project.DLS.AdvanceSearch;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

import mars.JCI.Project.DLS.Login.DLS_Login_Page_Action;

public class DLS_Advance_Search_Test extends BaseClass {
	@Parameters({ "search", "password"})
	@Test(priority=3,description = "Search User Account using Advance Search By Account Name")
	public void testAdvanceSearchByAccountName(String Search, String password) throws IOException {
		try {
			DLS_Advance_Search_Page_Action advanceSearchPA = new DLS_Advance_Search_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			advanceSearchPA.searchOnAdvanceSearch(Search);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
	
	@Parameters({ "correctusername","password"})
	@Test(priority=2,description = "Search User Account using Advance Search Created By Username")
	public void testAdvanceSearchByCreatedUserName(String correctusername, String password) throws IOException {
		try {
			DLS_Advance_Search_Page_Action advanceSearchPA = new DLS_Advance_Search_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			advanceSearchPA.searchByCreatedUsernameOnAdvanceSearch(correctusername);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

	
	
	@Parameters({ "comment","password"})
	@Test(priority=1,description = "Search User Account using Advance Search Comments")
	public void testAdvanceSearchByComment(String comment, String password) throws IOException {
		try {
			DLS_Advance_Search_Page_Action advanceSearchPA = new DLS_Advance_Search_Page_Action(desktopDriver, logger);
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.commonCorrectLogin(password);
			advanceSearchPA.searchByCommentsOnAdvanceSearch(comment);
			getFinalReport(desktopDriver, logger, methodName, true);
			loginPA.openDLSWindowClose();
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
