package mars.JCI.Project.DES.Login;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.Component.Functions.BaseClass;

public class DES_Login_Page_Test extends BaseClass {
	
	/**
	 * Test successful login.
	 *
	 * @param correctusername
	 *            the correctusername
	 * @param correctpassword
	 *            the correctpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// Test Cases for Login Functionality
	@Test(description = "Performs a successful login and checks whether the	 Home page is opened")
	public void testSuccessfulLogin() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			loginPA.DES_CorrectLogin();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	/**
	 * Test unsuccessful login.
	 *
	 * @param incorrectusername
	 *            the incorrectusername
	 * @param incorrectpassword
	 *            the incorrectpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 */

	@Test(description = "checks the	resulting error message (fails)")
	public void testUnsuccessfulLogin() throws IOException, InterruptedException {
		DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
		DES_Login_Error_Page_Action eop = loginPA.DES_incorrectLogin();
		getFinalReport(driver, logger, methodName, eop.compareErrorText("Invalid username and password."));
	}

	/*	*//**
			 * Test unsuccessful login.
			 *
			 * @param correctusername
			 *            the correctusername
			 * @param incorrectpassword
			 *            the incorrectpassword
			 * @throws IOException
			 *             Signals that an I/O exception has occurred.
			 * @throws InterruptedException
			 */
	@Test(description = "login with wrong password and checks the resulting error message (fails)")
	public void testUnsuccessfulLoginWrongPassword() throws IOException, InterruptedException {
		DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
		DES_Login_Error_Page_Action eop = loginPA.DES_incorrectLogin();
		getFinalReport(driver, logger, methodName, eop.compareErrorText("Invalid username and password."));
	}

	/**
	 * Test successful login.
	 *
	 * @param correctusername
	 *            the correctusername
	 * @param correctpassword
	 *            the correctpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */

	// Test Cases for Login Functionality
	@Test(description = "Performs a successful login and checks get Logged out from Home Page")
	public void testSuccessfulLoginAndLogOut() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			DES_Home_Page_Action.clickOnLogOut();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
