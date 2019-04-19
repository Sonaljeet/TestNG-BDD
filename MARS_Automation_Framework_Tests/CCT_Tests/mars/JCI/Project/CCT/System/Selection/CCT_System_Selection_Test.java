package mars.JCI.Project.CCT.System.Selection;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CCT.System.Selection.CCT_System_Selection_Page_Action;

public class CCT_System_Selection_Test extends BaseClass {

	@Test(description = "This Test case used to check time taken to  Add 5 Analog and 5 Binary Input Points ")
	public void testSuccessfulSystemSelectionPage() throws IOException {
		try {
			CCT_System_Selection_Page_Action systemselectionPA=new CCT_System_Selection_Page_Action(desktopDriver, logger,BaseURL);
			systemselectionPA.cctSytemSelection();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
