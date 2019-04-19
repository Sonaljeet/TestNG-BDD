package mars.JCI.Project.BCMET.Engineering;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCMET.Constants.GlobalTestConstants;
import mars.JCI.Project.BCMET.Login.BCMET_Login_Page_Action;

public class BCMET_Engineering_CreateNewProjectPage_Test extends BaseClass{

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	//Class objects declaration
	private static BCMET_Login_Page_Action loginPageAction = null;
	private static BCMET_Engineering_ActiveProjectList_Page_Action activeProjectListAction= null;
	private static BCMET_Engineering_CreateNewProjectPage_Action createNewProjectAction = null;

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
		createNewProjectAction = new BCMET_Engineering_CreateNewProjectPage_Action(driver, logger);
	}
	
	
	@Test(description = "BCMET_CreateNewPro_Verify error message for blank mandatory fields")
	public void verifyErrMsgForBlankMandatoryFields(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus = createNewProjectAction.verifyMandatoryFieldsErrorMessage();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "BCMET_CreateNewPro_Verify new building can be added successfully")
	public void verifyNewBuildingAdd(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus = createNewProjectAction.verifyNewBuildingAddSuccess();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_CreateNewPro_Verify existing building name can be changed successfully")
	public void verifyBuildingNameChange(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus = createNewProjectAction.verifyExistingBuildingNameChange("Renamed Bl1");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

	@Test(description="BCMET_CreateNewPro_Verify existing empty building can be deleted on facility details page")
	public void verifyBuildingDelete(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyDeleteExistingBuilding();
					BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_CreateNewPro_Verify more than 50 buildings cannot be added in facility details")
	public void verifyMoreThan50BuildingsNotAdded(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyErrorMsgForMoreThan50Building();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description= "BCMET_CreateNewPro_Verify New levels can be added for a particular building")
	public void verifyNewLevelAdd(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyNewLevelAddToBuilding("Level 1");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

	@Test(description="BCMET_CreateNewPro_Verify existing level name can be edited on facility details page")
	public void verifyExistingLevelNameChange(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyExistingLevelNameChange("New Level");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="BCMET_CreateNewPro_Verify existing level can be deleted on facility details page")
	public void verifyExistingLevelDelete(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyErrMsgForExistingLevelDelete();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_CreateNewPro_Verify more that 120 Levels cannot be added for a building")
	public void verifyErrMsgForMoreThan120LevelsAdd(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyErrMsgForMoreThan120Levels(121);
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
		
	}
	
	@Test(description="BCMET_CreateNewPro_Verify new zone can be added for a particular level")
	public void verifyNewZoneAdd(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyNewZoneAddToLevel("Zone");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_CreateNewPro_Verify existing zone can be deleted for a particular level")
	public void verifyZoneDelete(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyExistingZoneDelete();
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_CreateNewPro_Verify existing zone name can be edited for a particular level")
	public void verifyZoneNameChange(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyExistingZoneNameChange("Rename Zone");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_CreateNewPro_Verify more than 16 zones cannot be added for a particular level")
	public void verifyErrMsgForMoreThan16ZoneAdd(Method method) {
		initialize();
		boolean testStatus = false;
		try {
			boolean loginStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			if (loginStatus) {
				activeProjectListAction.clickOnCreateNewProjectButton();
				testStatus= createNewProjectAction.verifyErrMsgForMoreThan16Zones(19);
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			}
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
}








































