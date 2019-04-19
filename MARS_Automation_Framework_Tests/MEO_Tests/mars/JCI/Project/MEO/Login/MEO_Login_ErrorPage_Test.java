/**
 * 
 */
package mars.JCI.Project.MEO.Login;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
/**
 * @author jkadhak
 *
 */
public class MEO_Login_ErrorPage_Test extends BaseClass{

	/**
	 * Test unsuccessful login.
	 *
	 * @param correctusername the incorrectusername
	 * @param correctpassword the incorrectpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Test Cases for Login Functionality
	@Parameters({"incorrectusername","incorrectpassword"})
    @Test(description="Performs a Unsuccessful login and checks for error message")
	public void testUnSuccessfulLogin(String incorrectusername, String incorrectpassword) throws IOException{
    	boolean userLoggedIn=false;
		try {
    		MEO_Login_Page_Action loginPA = new MEO_Login_Page_Action(driver, logger);
    		userLoggedIn=loginPA.wrongUser_login(incorrectusername, incorrectpassword);
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

}
