package mars.JCI.Project.CCT.Home;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CCT.Home.CCT_Home_Page_Action;


import java.io.IOException;

import org.testng.annotations.Test;


public class CCT_Home_Test extends BaseClass {
	
	
	@Test(description = "This Test case used to check Opening time for CCT Home Page")
	public void testSuccessfulHomePage() throws IOException {
		try {
			CCT_Home_Page_Action homePA=new CCT_Home_Page_Action(desktopDriver, logger,BaseURL);
			homePA.verifyHomePageTitle();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
	
	
	

}
