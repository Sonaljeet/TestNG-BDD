package mars.JCI.Project.MUI.SpaceNavigation;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.JCI.Project.MUI.Home.*;
import mars.JCI.Project.MUI.Login.MUI_Login_Page_Action;
import mars.Component.Functions.*;

public class MUI_SpaceNavigation_Test extends BaseClass {
	@SuppressWarnings("unused")
	@Parameters({"correctusername", "correctpassword" })
	@Test(description = "Performs a Navigation till Given Space")
	public void testSpaceNavigation(String correctusername, String correctpassword)  {
		try {
			MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
			MUI_Home_Page_Action homePA = loginPA.correctLogin(correctusername, correctpassword);
			MUI_SpaceNavigation_Page_Action spaceNavigationPA = new MUI_SpaceNavigation_Page_Action(driver, logger);
			spaceNavigationPA.navigateToSpace(
					"Johnson Controls$North America (BACnet)$"
					+ "Wisconsin$Milwaukee$507 E Michigan Street Campus$"
					+ "Building 1$Floor 1$Office Area$Cubes");
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
