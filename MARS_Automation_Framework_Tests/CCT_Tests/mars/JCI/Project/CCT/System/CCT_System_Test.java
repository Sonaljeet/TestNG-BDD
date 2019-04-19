package mars.JCI.Project.CCT.System;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

public class CCT_System_Test extends BaseClass{
	@Test(description = "This Test case is used to check time to add System Selection ")
	public void testSystem() throws IOException {
		try {
			CCT_System_Page_Action systemPA=new CCT_System_Page_Action(desktopDriver, logger,BaseURL);
			systemPA.cctSystem();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
	

}
