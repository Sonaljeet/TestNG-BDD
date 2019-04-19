package mars.JCI.Project.BCMET.Engineering;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCMET.Constants.GlobalTestConstants;
import mars.JCI.Project.BCMET.Login.BCMET_Login_Page_Action;

public class BCMET_Engineering_ActiveProjectList_Page_Test extends BaseClass{

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	//Class objects declaration
	private static BCMET_Login_Page_Action loginPageAction = null;
	private static BCMET_Engineering_ActiveProjectList_Page_Action activeProjectListAction= null;

	/**
	 * This method is responsible for initializing the action classes 
	 * with suitable instances of WebDriver and ExtentTest.
	 * This method need to be called in start of each TestNG test method, else system will throw a {@link NullPointerException}
	 */
	private static void initialize() {
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		loginPageAction = new BCMET_Login_Page_Action(driver, logger);
		activeProjectListAction= new BCMET_Engineering_ActiveProjectList_Page_Action(driver, logger);
	}
	
	@Test(description = "ActiveProject- Verify existing project can be searched", priority=1)
	public void verifySearchProjectFunctionalityForExistingProject(Method method) {
		boolean testStatus = false;
		initialize();
		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		try {
			if (loginStatus) {
				testStatus = activeProjectListAction.verifySearchProjectFunctionality("Test1");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e.getMessage());
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "ActiveProject- Verify message if searched project doesn't exist in the list", priority=1)
	public void verifySearchProjectFunctionalityNonExistingProject(Method method) {
		boolean testStatus = false;
		initialize();
		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		try {
			if (loginStatus) {
				testStatus = activeProjectListAction.verifySearchForNotExistingProject("abcd238293");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, e.getMessage());
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description= "ActiveProject- Verify existing project can be deleted successfully", priority=2)
	public void verifyExitingProjectDelete(Method method) {
		boolean testStatus = false;
		initialize();
		boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
		try {
			if (loginStatus) {
				testStatus = activeProjectListAction.verifyDeleteExistingProjectFunctionality("test1");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, e.getMessage().substring(0, 50));
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="ActiveProject-Verify error message for blank project delete", priority=1)
	public void verifyBlankProDelete(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				testStatus= activeProjectListAction.verifyErrorMessageForBlankProjectDelete("deleteProject_123");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			
			logger.log(LogStatus.ERROR, e.getMessage().substring(0, 50));
			BaseClass.getFinalReport(driver, logger, method.getName(), false);			
		}
	}
	
	@Test(description="ActiveProject-Verify create new project page launches successfully", priority=2)
	public void verifyCreateProjectPageLaunch(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				testStatus= activeProjectListAction.verifyCreateNewProjectFunctionality();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			
			logger.log(LogStatus.ERROR, e.getMessage().substring(0, 50));
			BaseClass.getFinalReport(driver, logger, method.getName(), false);			
		}
	}
	
	@Test(description = "Verify archived project can be activated", priority = 3)
	public void verifyArchiveToActiveProject(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				testStatus = activeProjectListAction.verifyArchivedProjectCanBeActivated();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "Verify active project can be archived", priority=2)
	public void verifyActiveToArchiveProject(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				testStatus= activeProjectListAction.verifyActiveProjectCanBeArchived();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
}





























