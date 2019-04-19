package mars.JCI.Project.MUI.Login;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Action;

/**
 * The Class MUI_Login_Legal_Test.
 */
public class MUI_Login_Legal_Test extends BaseClass {
	
	/**
	 * Test MUI login legal cancel.
	 *
	 * @param newuser the newuser
	 * @param newuserpassword the newuserpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Test Cases for Login with new user and clicking on cancel button on Legal page
	@Parameters({"newuser","newuserpassword"})
    @Test(priority=0, description="Performs a login for new user and checks legal page is cancelled")
	public void testMUILoginLegalCancel(String newuser, String newuserpassword) throws IOException{
    	try {
			MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
			loginPA.correctLogin(newuser, newuserpassword);
			MUI_Terms_And_Conditions_Page_Action legalCancelPA = new MUI_Terms_And_Conditions_Page_Action(driver, logger);
			loginPA = legalCancelPA.checkMUILoginLegalCancel();
			getFinalReport(driver, logger, methodName ,	loginPA.verifyLoginCopyrightText());
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	/**
	 * Test MUI login legal accept.
	 *
	 * @param newuser the newuser
	 * @param newuserpassword the newuserpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Test Cases for Login with new user and clicking on cancel button on Legal page
	@Parameters({"newuser","newuserpassword"})
    @Test(priority=1, description="Performs a login for new user and checks legal page is Accept")
	public void testMUILoginLegalAccept(String newuser, String newuserpassword) throws IOException{
    	try {
			MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
			loginPA.correctLogin(newuser, newuserpassword);
			MUI_Terms_And_Conditions_Page_Action legalAcceptPA = new MUI_Terms_And_Conditions_Page_Action(driver, logger);
			MUI_Home_Page_Action homePA = legalAcceptPA.checkMUILoginLegalAccept();
			getFinalReport(driver, logger, methodName , homePA.isUserMenuPresent());
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName , false);
		}
	}

}
