/**
 * 
 */
package mars.JCI.Project.CSD.SSF;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_L2UserActivities_Reject_Page_Test extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername", "correctpassword" })
	@Test(priority=0,description = "Running the SSF Test Module for CSD 3.0 New Functionality Feature. Performs Activities of L2 User -- Rejection of SSF Form!")
	public void validateL2UserRole_RejectForm(String correctusername, String correctpassword){
		
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername, correctpassword);//CSD_Home_Page_Action homePA = 
			CSD_SSF_Impersonate_Page_Action ssfImpersonatePA = new CSD_SSF_Impersonate_Page_Action(driver, logger);
			CSD_SSF_SSFGrid_Page_Action ssfGridPageAction = new CSD_SSF_SSFGrid_Page_Action(driver, logger);
			ssfImpersonatePA.clickOnBranchUserLink();
			ssfImpersonatePA.searchUserToImpersonate("Vikas Jadhav");
			ssfImpersonatePA.clickOnUserToImpersonate();
			ssfImpersonatePA.checkImpersonateHomePageLoaded();
			ssfGridPageAction.clickOnSiteSetupLink();
			ssfGridPageAction.clickOnSSFLink();
			ssfGridPageAction.checkValidBranchesDisplayed("vikas");
			ssfGridPageAction.searchExistingSSFBranch("Automation_TestBranch");
			ssfImpersonatePA.checkForEditableSSFFormsUnderSearchResults_L2(false);
						
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	

}
