package mars.JCI.Project.MEO.Login;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

public class MEO_Login_Page_Test extends BaseClass{


	/**
	 * Test successful login.
	 *
	 * @param correctusername the correctusername
	 * @param correctpassword the correctpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="Performs a successful login and checks whether the Home page is displayed for logged in user")
	public void testSuccessfulLogin(String correctusername, String correctpassword) throws IOException{
    	boolean userLoggedIn=false;
		try {
    		MEO_Login_Page_Action loginPA = new MEO_Login_Page_Action(driver, logger);
    		userLoggedIn=loginPA.correctLogin(correctusername, correctpassword);
			//MUI_Home_Page_Action homePA = loginPA.correctLogin(correctusername, correctpassword);
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

}
