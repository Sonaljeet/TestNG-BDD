/**
 * 
 */
package mars.JCI.Project.CSD.HomePage.Dashboard;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.HomePage.Dashboard.CSD_HomePage_Dashboard_Page_Action;

/**
 * @author cdeyso
 *
 */
@SuppressWarnings("unused")
public class CSD_HomePage_Dashboard_Page_Test extends BaseClass {

	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application HomePage Dashboard Check")
	public void testSuccessfulLogin(String correctusername, String correctpassword,Method method) {   
    	try {
    		
    		CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername, correctpassword);
    		CSD_HomePage_Dashboard_Page_Action csd_HomePage_DB_Action = new CSD_HomePage_Dashboard_Page_Action(driver, logger);
    		//csd_HomePage_DB_Action.clickOnGreenChillerStatus();
    		//csd_HomePage_DB_Action.clickOnRedChillerStatus();
			csd_HomePage_DB_Action.validateAllValidCustNamesAreDisplayed();
			csd_HomePage_DB_Action.validateAllValidFacilityNamesAreDisplayed();
			csd_HomePage_DB_Action.validateAllValidAssetNamesAreDisplayed();
			csd_HomePage_DB_Action.validateAssetStatusOnToolTip();
			csd_HomePage_DB_Action.validateChillerInfoPointNamesAndVal();
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
