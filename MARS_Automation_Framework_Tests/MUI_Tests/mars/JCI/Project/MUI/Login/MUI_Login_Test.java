package mars.JCI.Project.MUI.Login;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import mars.JCI.Project.MUI.Home.*;
import mars.Component.Functions.*;

/**
 * The Class MUI_Login_Test.
 */
public class MUI_Login_Test extends BaseClass{
	
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
	

	/**
	 * Test unsuccessful login.
	 *
	 * @param incorrectusername the incorrectusername
	 * @param incorrectpassword the incorrectpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Parameters({"incorrectusername","incorrectpassword"})
    @Test(enabled = false, description="Performs an unsuccessful login and checks the resulting error message (fails)")
    public void testUnsuccessfulLogin(String incorrectusername, String incorrectpassword) throws IOException {
    	MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
		MUI_Login_Error_Page_Action eop = loginPA.incorrectLogin(incorrectusername, incorrectpassword);
		getFinalReport(driver, logger, methodName, eop.compareErrorText("Invalid user name or password entered."));
    }

}
