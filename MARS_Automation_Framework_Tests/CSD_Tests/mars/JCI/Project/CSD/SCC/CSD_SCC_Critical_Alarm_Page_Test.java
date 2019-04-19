package mars.JCI.Project.CSD.SCC;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.CPO5.CSD_Home_Page_Action;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.SCC.CSD_SCC_Critical_Alarm_Page_Action;

public class CSD_SCC_Critical_Alarm_Page_Test extends BaseClass{
	
	
	@SuppressWarnings("static-access")
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application SCC Critical Alarm Tab Validations")
	public void testCriticalAlarmFunctionalityTest( String correctusername, String correctpassword) 
			throws IOException{   //  Method method
    	try {
    		
    		CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
    		CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin(correctusername, correctpassword);//"cdeyso@jci.com", "Jci@1113" 
    		CSD_SCC_Critical_Alarm_Page_Action csd_scc_criticalAlarm_pa = new CSD_SCC_Critical_Alarm_Page_Action(driver, logger);
    		csd_scc_criticalAlarm_pa.clickOnCriticalAlarmTabLink();
    		csd_scc_criticalAlarm_pa.selectCustomerNameFromDDL();
    		csd_scc_criticalAlarm_pa.selectFacilityNameFromDDL();
    		csd_scc_criticalAlarm_pa.selectAssetNameFromDDL();
    		csd_scc_criticalAlarm_pa.getAssetDetailsDataFromGUI();
    		csd_scc_criticalAlarm_pa.selectAlarmTypeFromDDL();
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	

}
