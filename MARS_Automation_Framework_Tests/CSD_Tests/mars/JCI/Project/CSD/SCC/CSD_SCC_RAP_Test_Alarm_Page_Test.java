package mars.JCI.Project.CSD.SCC;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.CPO5.CSD_Home_Page_Action;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;

public class CSD_SCC_RAP_Test_Alarm_Page_Test extends BaseClass {
	
	
	@SuppressWarnings("static-access")
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application SCC RAP Test Alarm Tab Validations")
	public void testRAPTestAlarmFunctionalityTest( String correctusername, String correctpassword) 
			throws IOException{   //  Method method
    	try {
    		
    		CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
    		CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin(correctusername, correctpassword);//"cdeyso@jci.com", "Jci@1113" 
    		CSD_SCC_RAP_Test_Alarm_Page_Action csd_scc_rapTestAlarm_pa = new CSD_SCC_RAP_Test_Alarm_Page_Action(driver, logger);
    		csd_scc_rapTestAlarm_pa.clickOnRAPTestAlarmTabLink();
    		csd_scc_rapTestAlarm_pa.selectDesiredCustomerFromDropDown();
    		csd_scc_rapTestAlarm_pa.selectFacilityNameForSetup();
    		csd_scc_rapTestAlarm_pa.selectAssetNameForSetup();
    		csd_scc_rapTestAlarm_pa.validateOwnerDeviceForSelectedAsset();
    		csd_scc_rapTestAlarm_pa.validateAssetDetailsFromDB();
    		
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	

}
