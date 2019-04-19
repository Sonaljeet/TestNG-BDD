package mars.JCI.Project.CCT.Output.Point;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CCT.Output.Point.CCT_Output_Page_Action;

public class CCT_Output_Test extends BaseClass {
	
	
	@Test(description = "This Test case used to check time taken to  Add 5 Analog and 5 Binary Output Points ")
	public void testSuccessfulOutputPage() throws IOException {
		try {
			CCT_Output_Page_Action outputPA=new CCT_Output_Page_Action(desktopDriver, logger,BaseURL);
			outputPA.cctOutputPoints();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
