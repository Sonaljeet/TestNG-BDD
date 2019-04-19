/**
 * 
 */
package mars.JCI.Project.VERASYS.Login;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Error_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Action;

/**
 * @author jkadhak
 *
 */
public class VERASYS_Login_Page_Test extends BaseClass {
	/**
	 * Test successful login.
	 *
	 * @param correctusername the correctusername
	 * @param correctpassword the correctpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Test Cases for Login Functionality
	@Parameters({"adminUsername","adminPassword"})
    @Test(groups={"SmokeTest"},description="Performs a successful login and checks whether the customer set up screen is displayed for Admin user")
	public void testSuccessfulLogin(String adminUsername, String adminPassword) throws IOException{
    	boolean userLoggedIn=false;
		try {
    		VERASYS_Login_Page_Action loginPA=new VERASYS_Login_Page_Action(driver,logger);
    		userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
    		loginPA.successfullLogout() ;
    		userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
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
	 */
	@Parameters({ "incorrectusername", "incorrectpassword" })
	@Test(description="Performs an unsuccessful login and checks the resulting error message (fails)")
	public void testUnsuccessfulLogin(String incorrectusername, String incorrectpassword) throws IOException {
		try
		{
			boolean userLoggedIn=false;
		VERASYS_Login_Page_Action loginPA=new VERASYS_Login_Page_Action(driver,logger);
		userLoggedIn=loginPA.incorrectLogin(incorrectusername, incorrectpassword);
		getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	/**
	 * Test unsuccessful login.
	 *
	 * @param incorrectusername
	 *            the incorrectusername
	 * @param correctpassword
	 *            the correctpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Parameters({ "incorrectusername", "adminPassword" })
	@Test(description = "Performs an unsuccessful login with wrong username and checks the resulting error message (fails)")
	public void testUnsuccessfulLoginWrongUsername(String incorrectusername, String adminPassword)
			throws IOException {
		boolean userLoggedIn=false;
		try{
		VERASYS_Login_Page_Action loginPA=new VERASYS_Login_Page_Action(driver,logger);
		userLoggedIn=loginPA.incorrectLogin(incorrectusername, adminPassword);
		
		getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	/**
	 * Test unsuccessful login.
	 *
	 * @param correctusername
	 *            the correctusername
	 * @param incorrectpassword
	 *            the incorrectpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Parameters({ "adminUsername", "incorrectpassword" })
	@Test(description = "Performs an unsuccessful login with wrong password and checks the resulting error message (fails)")
	public void testUnsuccessfulLoginWrongPassword(String adminUsername, String incorrectpassword)
			throws IOException {
		boolean userLoggedIn=false;
		try{
		VERASYS_Login_Page_Action loginPA=new VERASYS_Login_Page_Action(driver,logger);
		userLoggedIn=loginPA.incorrectLogin(adminUsername, incorrectpassword);
		
		getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
