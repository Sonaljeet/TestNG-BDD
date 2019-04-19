/**
 * 
 */
package mars.JCI.Project.BCMET.Admin;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCMET.Constants.BCMETTextConstants;
import mars.JCI.Project.BCMET.Constants.GlobalTestConstants;
import mars.JCI.Project.BCMET.Engineering.BCMET_Engineering_ActiveProjectList_Page_Action;
import mars.JCI.Project.BCMET.Login.BCMET_Login_Page_Action;


/**
 * @author cpandeak
 *
 */
public class BCMET_Engineering_AddUser_Page_Test extends BaseClass{

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static BCMET_Login_Page_Action loginPageAction = null;
	private static BCMET_Engineering_ActiveProjectList_Page_Action activeProPageAction = null;
	private static BCMET_Admin_Page_Action adminPageAction = null;
	private static BCMET_Admin_AddUser_Page_Action addUserPageAction = null;
	
	private static void initialize() {
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		loginPageAction = new BCMET_Login_Page_Action(driver, logger);
		addUserPageAction = new BCMET_Admin_AddUser_Page_Action(driver, logger);
		activeProPageAction = new BCMET_Engineering_ActiveProjectList_Page_Action(driver, logger);
		adminPageAction = new BCMET_Admin_Page_Action(driver, logger);
	}
	
	//@Test(description="BCMET_Add User - Verify Admin user can be added successfully on Add User Page", priority=1)
	public void verifyAdminUserAddSuccessful(Method method) {
		initialize();
		boolean testStatus = false;
		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		try {
			if (loginStatus) {
				activeProPageAction.clickOnAdminLink();
				adminPageAction.clickOnAddUserLink();
				testStatus = addUserPageAction.verifyNewAdminUserCanBeCreatedSuccessfully();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	//@Test(description="BCMET_Add User - Verify Customer user can be added successfully on Add User Page", priority=1)
	public void verifyCustomerUserAddSuccessful(Method method) {
		initialize();
		boolean testStatus = false;
		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		try {
			if (loginStatus) {
				activeProPageAction.clickOnAdminLink();
				adminPageAction.clickOnAddUserLink();
				testStatus = addUserPageAction.verifyNewCustomerCanBeAddedSuccessfully();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	//@Test(description="BCMET_Add User - Verify Technician user can be added successfully on Add User Page", priority = 1)
	public void verifyTechnicianUserAddSuccessful(Method method) {
		initialize();
		boolean testStatus = false;
		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		try {
			if (loginStatus) {
				activeProPageAction.clickOnAdminLink();
				adminPageAction.clickOnAddUserLink();
				testStatus = addUserPageAction.verifyNewTechnicianCanBeAddedSuccessfully();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

	@Test(description="BCMET_Add User - Verify existing user can be deleted successfully on Add User Page", priority = 2)
	public void verifyUserDeletedSuccessful(Method method){
		initialize();
		boolean testStatus = false;
		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		try {
				if (loginStatus) {
					activeProPageAction.clickOnAdminLink();
					adminPageAction.clickOnAddUserLink();
					testStatus = addUserPageAction.verifyExistingCustomerCanBeDeleted();
					BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
				}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

	//@Test(description="BCMET_Add User - Verify error message for blank fields on Add User Page", priority =3)
	public void verifyBlankMessageErroMessages(Method method){
		boolean testStatus = false;
		initialize();

		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		
		try {
			if (loginStatus) {
				activeProPageAction.clickOnAdminLink();
				adminPageAction.clickOnAddUserLink();
				testStatus = addUserPageAction.verifyErrorMsgForBlankFields();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
}
