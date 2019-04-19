package mars.JCI.Project.CSD.Localization.HomePage;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.CPO5.CSD_Home_Page_Action;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.Localization.HomePage.CSD_LOCAL_Impersonate_Page_Action;

public class CSD_LOCAL_Impersonate_Page_Test extends BaseClass {

	
	@SuppressWarnings({ "static-access", "unused" })
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application Localization Functionality -- Home Page!")
	public void testLocalizationFeatureHomePage( String correctusername, String correctpassword) 
			throws IOException{ 
		
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
    		CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin(correctusername, correctpassword);//"cdeyso@jci.com", "Jci@1113" 
    		CSD_LOCAL_Impersonate_Page_Action csd_local_homePage = new CSD_LOCAL_Impersonate_Page_Action(driver, logger);
    		csd_local_homePage.clickOnBranchUserLink();
    		csd_local_homePage.searchUserToImpersonate("vikas jadhav");
    		csd_local_homePage.clickOnUserToImpersonate();
    		csd_local_homePage.checkImpersonateHomePageLoaded();
    		csd_local_homePage.validateLeftTreeOptions();
			
			
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			getFinalReport(driver, logger, methodName ,	false);
		}
		
	}
}
