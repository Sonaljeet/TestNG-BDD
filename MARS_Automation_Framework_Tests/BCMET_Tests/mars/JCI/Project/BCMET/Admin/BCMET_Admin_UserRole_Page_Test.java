/**
 * 
 */
package mars.JCI.Project.BCMET.Admin;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCMET.Constants.GlobalTestConstants;
import mars.JCI.Project.BCMET.Engineering.BCMET_Engineering_ActiveProjectList_Page_Action;
import mars.JCI.Project.BCMET.Login.BCMET_Login_Page_Action;

/**
 * @author cpandeak
 *
 */
public class BCMET_Admin_UserRole_Page_Test extends BaseClass {

	private WebDriver driver = null;
	private ExtentTest logger = null;

	private BCMET_Login_Page_Action loginPageAction = null;
	private BCMET_Admin_Page_Action adminPageAction = null;
	private static BCMET_Engineering_ActiveProjectList_Page_Action activeProPageAction = null;
	private BCMET_Admin_UserRole_Page_Action userRolePageAction = null;

	private void initializeTest() {
		this.driver = BaseClass.driver;
		this.logger = BaseClass.logger;
		loginPageAction = new BCMET_Login_Page_Action(driver, logger);
		activeProPageAction = new BCMET_Engineering_ActiveProjectList_Page_Action(driver, logger);
		adminPageAction = new BCMET_Admin_Page_Action(driver, logger);
		userRolePageAction = new BCMET_Admin_UserRole_Page_Action(driver, logger);
	}

	@Test(description = "BCMET_UserRole_Verify new User role can be created", priority = 1)
	public void verifyNewUserRoleCanBeCreated(Method method) {
		initializeTest();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername,
					GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProPageAction.clickOnAdminLink();
				adminPageAction.clickOnUserRoleLink();
				testStatus = userRolePageAction.verifyNewUserRoleCreation("test", "test");
			}
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

	@Test(description = "BCMET_UserRole_Verify existing user role can be deleted", priority = 2)
	public void verifyExistingUserRoleCanBeDeleted(Method method) {
		initializeTest();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername,
					GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProPageAction.clickOnAdminLink();
				adminPageAction.clickOnUserRoleLink();
				testStatus = userRolePageAction.verifyUserRoleDelete("test");
			}
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "BCMET_UserRole_Verify newly created role is visible in Add User Tab", priority = 1)
	public void verifyNewlyCreatedRoleVisibleInAddUserTab(Method method) {
		initializeTest();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername,
					GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProPageAction.clickOnAdminLink();
				adminPageAction.clickOnUserRoleLink();
				testStatus = userRolePageAction.verifyNewRoleVisileInAddUserTab("newUser");
			}
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
}
