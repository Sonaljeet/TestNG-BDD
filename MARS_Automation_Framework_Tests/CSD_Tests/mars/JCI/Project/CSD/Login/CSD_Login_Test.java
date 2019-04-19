/**
 * 
 */
package mars.JCI.Project.CSD.Login;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.CPO5.CSD_Home_Page_Action;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;

/**
 * @author cdeyso
 *
 */
public class CSD_Login_Test extends BaseClass {
	
	
	/**
	 * Test successful login.
	 *
	 * @param correctusername the correctusername
	 * @param correctpassword the correctpassword
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("static-access")
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application Login Test")
	public void testSuccessfulLogin( String correctusername, String correctpassword) throws IOException{   //  Method method
    	try {
    		
    		CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin(correctusername, correctpassword);//"cdeyso@jci.com", "Jci@1113" 
			//csd_login_page_action.handlePopUpAlertIfPresent();
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

}
