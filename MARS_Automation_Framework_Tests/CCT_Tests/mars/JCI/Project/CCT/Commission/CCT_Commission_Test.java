package mars.JCI.Project.CCT.Commission;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;


public class CCT_Commission_Test extends BaseClass {
	
	
	@Test(description = "This Test case used to check Opening time for Adding Sensor to System")
	public void testSuccessfulCommission() throws IOException {
		try {
			CCT_Commission_Page_Action commissionPA=new CCT_Commission_Page_Action(desktopDriver, logger,BaseURL);
			commissionPA.cctCommission();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
}


