package mars.JCI.Project.BCMET.Engineering;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCMET.Login.BCMET_Login_Page_Action;

public class BCMET_Engineering_EnggInfo_Page_Test extends BaseClass {

	private WebDriver driver = null;
	private ExtentTest logger = null;

	private static BCMET_Login_Page_Action loginPageAction = null;
	private static BCMET_Engineering_ActiveProjectList_Page_Action activeProjectListAction= null;
	private static BCMET_Engineering_CreateNewProjectPage_Action createNewProjectAction = null;
	private static BCMET_Engineering_EnggInfo_Page_Action enggInfoAction = null;
	
	
	private void initialize() {
		this.driver = BaseClass.driver;
		this.logger = BaseClass.logger;
		
		loginPageAction = new BCMET_Login_Page_Action(driver, logger);
		activeProjectListAction = new BCMET_Engineering_ActiveProjectList_Page_Action(driver, logger);
		createNewProjectAction = new BCMET_Engineering_CreateNewProjectPage_Action(driver, logger);
		enggInfoAction = new BCMET_Engineering_EnggInfo_Page_Action(driver, logger);
	}
	
	@Parameters({"username", "password"})
	@Test(description="All test")
	public void t1(String username, String password, Method method){
		initialize();
		boolean testStatus = true;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(username, password);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				
				String statusAndProjectName = createNewProjectAction.createDummyTestDataForProject();
				String[] statAndName = statusAndProjectName.split(":");
				//System.out.println(new Boolean(statAndName[0]));
				System.out.println(statAndName[0]);
				System.out.println(statAndName[1]);
				if (new Boolean(statAndName[0])) {
					System.out.println(1);
					createNewProjectAction.clickOnBackToProjectListLink();
					boolean searchProject = activeProjectListAction.verifySearchProjectFunctionality(statAndName[1]);
					if (searchProject) {
						System.out.println(2);
						activeProjectListAction.clickOnSearchedProjectInProjectList(statAndName[1]);
						createNewProjectAction.clickOnEquipmentInfoLink();
						
						enggInfoAction.selectAddEquipmentTypeFromDD("AHU");
						
						BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
					}
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "<label>TC failed. Errro details</br></label>"+e.getMessage());
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
}

















