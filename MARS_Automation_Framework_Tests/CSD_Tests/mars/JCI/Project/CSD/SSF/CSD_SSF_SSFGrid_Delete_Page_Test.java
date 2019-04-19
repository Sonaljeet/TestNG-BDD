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
public class CSD_SSF_SSFGrid_Delete_Page_Test extends BaseClass {
	

	@SuppressWarnings("static-access")
	@Parameters({"correctusername", "correctpassword" })
	@Test(priority=0,description = "Running the SSF Test Module for CSD 3.0 New Functionality Feature. Performs DELETE Action on the SSF Form created by the Branch USER")
	public void validateSSFGridFunctionalityBranchUser_DeleteForm(String correctusername, String correctpassword){
		
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername, correctpassword);//CSD_Home_Page_Action homePA = 
			CSD_SSF_SSFGrid_Page_Action ssfGridPageAction = new CSD_SSF_SSFGrid_Page_Action(driver, logger);
			ssfGridPageAction.clickOnSiteSetupLink();
			ssfGridPageAction.clickOnSSFLink();
			ssfGridPageAction.checkValidBranchesDisplayed("souvik");
			ssfGridPageAction.searchExistingSSFBranch("Automation_TestBranch","delete");
			//ssfGridPageAction.validateExistingSSFBranchResult();
			//ssfGridPageAction.deleteExistingSSFBranchResult();
			
			//Thread.sleep(100000);
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}


}
