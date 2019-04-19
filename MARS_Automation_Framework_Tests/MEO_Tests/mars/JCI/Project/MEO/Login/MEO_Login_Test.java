package mars.JCI.Project.MEO.Login;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Action;
import mars.JCI.Project.MUI.Login.MUI_Login_Page_Action;

public class MEO_Login_Test extends BaseClass{
	/**
	 * Test successful login.
	 *
	 * @param correctusername the correctusername
	 * @param correctpassword the correctpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="Performs a successful login and checks whether the Home page is opened")
	public void testSuccessfulLogin(String correctusername, String correctpassword) throws IOException{
    	try {
			MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
			MUI_Home_Page_Action homePA = loginPA.correctLogin(correctusername, correctpassword);
			
			getFinalReport(driver, logger, methodName ,	homePA.isUserMenuPresent());
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
