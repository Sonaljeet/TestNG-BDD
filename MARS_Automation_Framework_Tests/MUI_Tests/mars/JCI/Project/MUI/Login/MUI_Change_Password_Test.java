package mars.JCI.Project.MUI.Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.Component.Functions.LocalDriverFactory;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Action;

public class MUI_Change_Password_Test extends BaseClass{
	
	/**
	 * Test change password functionality for user by canceling terms and conditions.
	 *
	 * @param correctusername the correctusername
	 * @param correctpassword the correctpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Parameters({"changepassworduser","changepassworduseroldpassword"})
    @Test(description="Performs a cancel change password for the user")
	public void testChangePasswordCancel(String changepassworduser, String changepassworduseroldpassword) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    	try {
			MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
			loginPA.correctLogin(changepassworduser, changepassworduseroldpassword);
			MUI_Change_Password_Page_Action changePassPA = new MUI_Change_Password_Page_Action(driver, logger);
			loginPA = changePassPA.checkMUIChangePassCancel();
			getFinalReport(driver, logger, methodName ,loginPA.verifyLoginCopyrightText());
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,false);
		}
	}

	/**
	 * Test change password functionality for user by accepting terms and conditions.
	 *
	 * @param correctusername the correctusername
	 * @param correctpassword the correctpassword
	 * @param correctpassword the newpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Parameters({"changepassworduser","changepassworduseroldpassword","changepasswordusernewpassword"})
    @Test(description="Performs a change password for the user")
	public void testChangePasswordUpdate(String changepassworduser, String changepassworduseroldpassword, String changepasswordusernewpassword) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
    	try {
			MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
			loginPA.correctLogin(changepassworduser, changepassworduseroldpassword);
			MUI_Change_Password_Page_Action changePassPA = new MUI_Change_Password_Page_Action(driver, logger);
			MUI_Home_Page_Action homePA = new MUI_Home_Page_Action(driver, logger);
			homePA = changePassPA.checkMUIChangePassSubmit(changepassworduseroldpassword, changepasswordusernewpassword);
			getFinalReport(driver, logger, methodName ,homePA.isUserMenuPresent());
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,false);
		}
	}

}
