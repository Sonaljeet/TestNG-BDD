package mars.JCI.Project.DLS.Login;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.Component.Functions.BaseClass;

/**
 * The Class DLS_Login_Test.
 */
public class DLS_Login_Test extends BaseClass {

	/**
	 * Test successful login.
	 *
	 * @param correctpassword
	 *            the correctpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Parameters({ "correctpassword" })
	@Test(description = "This Test Case is for Performs a Successful Login and Checks whether the DLS Home Page is Opened")
	public void testSuccessfullLogin(String correctpassword) throws IOException {
		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			loginPA.correctLogin(correctpassword);
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}

	/**
	 * Test Unsuccessful login.
	 *
	 * @param correctpassword
	 *            the inCorrectpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Parameters({ "incorrectpassword" })
	@Test(description = "This Test Case is for Performs a Unsuccessful Login and checks whether the DLS Error Page is Opened")
	public void testUnSuccessfullLogin(String incorrectpassword) throws IOException {
		try {
			DLS_Login_Page_Action loginPA = new DLS_Login_Page_Action(desktopDriver, logger, BaseURL);
			DLS_Login_Error_Page_Action errorPA = loginPA.inCorrectLogin(incorrectpassword);
			getFinalReport(desktopDriver, logger, methodName, errorPA.verifyHomePageTitle());
		} catch (Exception e) {
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}
}
