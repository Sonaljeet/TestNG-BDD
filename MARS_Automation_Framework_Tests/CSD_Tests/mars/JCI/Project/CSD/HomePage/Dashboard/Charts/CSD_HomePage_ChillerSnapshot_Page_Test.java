package mars.JCI.Project.CSD.HomePage.Dashboard.Charts;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.HomePage.Dashboard.Charts.CSD_HomePage_ChillerSnapshot_Page_Action;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;

public class CSD_HomePage_ChillerSnapshot_Page_Test extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application Overview Tab Chiller SnapShot Check")
	public void testChartsGraphPoints(String correctusername, String correctpassword,Method method) {   
    	try {
    		
    		CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername, correctpassword);
			CSD_HomePage_ChillerSnapshot_Page_Action csd_ChillerSnapshot_DB_Action = new CSD_HomePage_ChillerSnapshot_Page_Action(driver, logger);
			csd_ChillerSnapshot_DB_Action.clickOnOverviewTab();
			csd_ChillerSnapshot_DB_Action.clickOnGraphPoints();
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

}
