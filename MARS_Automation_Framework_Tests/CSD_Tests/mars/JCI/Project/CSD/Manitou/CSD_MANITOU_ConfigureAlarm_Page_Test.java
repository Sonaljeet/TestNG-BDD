/**
 * 
 */
package mars.JCI.Project.CSD.Manitou;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.Manitou.CSD_MANITOU_ConfigureAlarm_Page_Action;

/**
 * @author cdeyso
 *
 */
public class CSD_MANITOU_ConfigureAlarm_Page_Test extends BaseClass{

	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application Configure Manitou Alarm Page Test")
	public void validateRTAManitouConfiguration(String correctusername, String correctpassword, Method method) throws IOException{   //  String correctusername, String correctpassword Method method
    	try {
    		
    		CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername,correctpassword);
			CSD_MANITOU_ConfigureAlarm_Page_Action csd_manitou_page_action = new CSD_MANITOU_ConfigureAlarm_Page_Action(driver, logger);
			csd_manitou_page_action.getToRapAlarmTestPage();
			csd_manitou_page_action.selectCustomerFromDDL();
			csd_manitou_page_action.selectFacilityFromDDL();
			csd_manitou_page_action.selectAssetFromDDL();
			csd_manitou_page_action.validateReflectedAssetDetails();
			csd_manitou_page_action.validateAlarmTypeandAlarmValue();
			/*csd_manitou_page_action.selectAlarmTypeFromDDL();
			csd_manitou_page_action.selectAlarmTypeValueFromDDL();*/
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
