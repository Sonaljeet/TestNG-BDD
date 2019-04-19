package mars.JCI.Project.CSD.HomePage.RightTreeMenu;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.HomePage.RightTreeMenu.CSD_HOMEPAGE_RightTreeMenu_Page_Action;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;

public class CSD_HOMEPAGE_RightTreeMenu_Page_Test extends BaseClass{

	@SuppressWarnings("static-access")
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application HomePage -- Right menu Tree Validations")
	public void testRightTreeMenuEntries(String correctusername, String correctpassword,Method method) { 
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername, correctpassword);
			CSD_HOMEPAGE_RightTreeMenu_Page_Action csd_HomePage_RightTreeMenu_Action = new CSD_HOMEPAGE_RightTreeMenu_Page_Action(driver, logger);
			csd_HomePage_RightTreeMenu_Action.clickOnRightTreeIcon();
			csd_HomePage_RightTreeMenu_Action.readTheDisplayedCustomerNames();
			csd_HomePage_RightTreeMenu_Action.validateSingleEntryCustomerDetails();
			csd_HomePage_RightTreeMenu_Action.validateProjectDetailsTree("souvik");
			
			
			
			getFinalReport(driver, logger, methodName ,	true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
