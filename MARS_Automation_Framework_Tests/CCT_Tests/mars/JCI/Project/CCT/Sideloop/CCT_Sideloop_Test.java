package mars.JCI.Project.CCT.Sideloop;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

public class CCT_Sideloop_Test extends BaseClass {

	@Test(description = "This Test case used to check time taken to  Add Sideloop Points ")
	public void testSuccessfulSideloopPage() throws IOException {
		try {
			CCT_Sideloop_Page_Action sideloopPA = new CCT_Sideloop_Page_Action(desktopDriver, logger, BaseURL);
			sideloopPA.cctSideloop();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
}
