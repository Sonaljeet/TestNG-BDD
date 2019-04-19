package mars.JCI.Project.CCT.Network.Input;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CCT.Network.Input.CCT_Network_Input_Page_Action;

public class CCT_Network_Input_Test extends BaseClass{

	@Test(description = "This Test case used to check  time taken to add Network Input ")
	public void testAddNetworkPoints() throws IOException {
		try {
			CCT_Network_Input_Page_Action networkPA=new CCT_Network_Input_Page_Action(desktopDriver, logger,BaseURL);
			networkPA.cctNetworkPoints();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

}
