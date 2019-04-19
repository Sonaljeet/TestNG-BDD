package mars.JCI.Project.CCT.Input.Module;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CCT.Input.Module.CCT_Module_Page_Action;

public class CCT_Module_Test extends BaseClass {
	
	@Test(description = "This Test case used to check time taken to  Add Start Stop Sequencing (AHU Mixed Mode) in Input ")
	public void testSuccessfulHomePage() throws IOException {
		try {
			CCT_Module_Page_Action modulePA=new CCT_Module_Page_Action(desktopDriver, logger,BaseURL);
			modulePA.cctModule();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
