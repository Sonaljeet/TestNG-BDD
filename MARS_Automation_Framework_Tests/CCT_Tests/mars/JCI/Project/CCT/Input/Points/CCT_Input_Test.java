package mars.JCI.Project.CCT.Input.Points;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

import mars.JCI.Project.CCT.Input.Points.CCT_Input_Page_Action;

public class CCT_Input_Test extends BaseClass{
	
	@Test(description = "This Test case used to check time taken to  Add 5 Analog and 5 Binary Input Points ")
	public void testSuccessfulInputPage() throws IOException {
		try {
			CCT_Input_Page_Action inputPA=new CCT_Input_Page_Action(desktopDriver, logger,BaseURL);
			inputPA.cctInputPoints();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
