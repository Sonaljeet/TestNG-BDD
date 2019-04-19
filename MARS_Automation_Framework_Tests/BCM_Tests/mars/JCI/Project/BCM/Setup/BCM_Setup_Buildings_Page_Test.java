/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCM.Constants.GlobalVariables;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;

public class BCM_Setup_Buildings_Page_Test extends BaseClass {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	private static BCM_Setup_Home_Page_Action setupAction = null;
	private static BCM_Login_Page_Action loginAction = null;
	private static BCM_Setup_Buildings_Page_Action buildingAction = null;

	private static void initialize() {
		driver = BaseClass.driver;
		logger = BaseClass.logger;

		loginAction = new BCM_Login_Page_Action(driver, logger);
		setupAction = new BCM_Setup_Home_Page_Action(driver, logger);
		buildingAction = new BCM_Setup_Buildings_Page_Action(driver, logger);
	}

	@Test(description = "Verify error messages for blank field in project details", priority=1)
	public void verifyBlankMessagesForProjectDetails(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyErrorMessageForBlankProjectDetailsField();
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

 	@Test(description = "Verify new project detail can be added successfully", priority=1)
 	public void verifyNewProjectDetailCanBeAddedSuccessfully(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyProjectDetailsCanBeAddedSuccessfully("New Project", "DD/MM/YYYY", "10");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
 	}

	@Test(description = "Verify existing project details can be updated sucessfully", priority=2)
	public void verifyExistingProjectDetailCanBeUpdatedSuccessfully(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyProjectDetailsCanBeUpdatedSuccessfully("Update Project", "DD/MM/YYYY", "5");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "Verify error message for more than 50 buildings", priority=2)
	public void verifyErrorMessageForMoreThan50Buildings(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyErrorMessageForMoreThan50Buildings("FiftyBuildings", "MM/DD/YYYY", "51");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "Verify error message for more than 120 floors", priority=2)
	public void verifyErrorMessageForMoreThan120Floors(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyErrorMessageForMoreThan120Floors("Floors121", "MM/DD/YYYY", "5", "121", "F");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "Verify existing building can be deleted successfully", priority=2)
	public void verifyExistingBuildingCanBeDeletedSuccessfully(Method method) {
		boolean testStatus = false;

		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyExistingBuildingCanBeDeleted("DeleteBuilding", "MM/DD/YYYY", "10");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "Verify building name can be edited successfully", priority=2)
	public void verifyBuildingNameCanBeEdited(Method method) {
		boolean testStatus = false;
		
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyExistingBuildingNameCanBeEdited("DeleteBuilding", "MM/DD/YYYY", "10");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "Verify new floor can be added successfully for a building", priority=2)
	public void verifyNewFloorAddSuccess(Method method){
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyNewFloorCanBeAddedSuccessfully("AddFloor", "MM/DD/YYYY", "5", "4", "F");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description = "Verify existing floor name can be edited successfully", priority=3)
	public void verifyExistingFloorCanBeEditedSuccessfully(Method method) {
			boolean testStatus = false;
			try {
				initialize();
				loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
				setupAction.setupLinkClick();
				setupAction.BuildingsLinkClick();
				testStatus = buildingAction.verifyExistingFloorNameCanBeEdited("EditFloor", "MM/DD/YYYY", "5");
				BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			} catch (Exception e) {
				BaseClass.getFinalReport(driver, logger, method.getName(), false);
			}
	}
	
	@Test(description = "Verify existing floor can be deleted successfully", priority=3)
	public void verifyExistingFloorCanBeDeletedSuccessfully(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyExistingFloorCanBeDeleted("DeleteFloor", "MM/DD/YYYY", "6");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}

	}
	
	@Test(description = "Verify Existing section can be Edited successfully", priority=3)
	public void verifyExistingSectionCanBeEditedSuccessfully(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyExistingSectionNameCanBeEdited("UpdateSection", "MM/DD/YYYY", "6");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}

	}
	
	@Test(description = "Verify existing section can be deleted successfully", priority=3)
	public void verifyExistingSectionCanBeDeletedSuccessfully(Method method) {
		boolean testStatus = false;
		try {
			initialize();
			loginAction.successfulLogin(GlobalVariables.BcmUserName, GlobalVariables.BcmPassword);
			setupAction.setupLinkClick();
			setupAction.BuildingsLinkClick();
			testStatus = buildingAction.verifyExistingSectionCanBeDeleted("DeleteSection", "MM/DD/YYYY", "6");
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
		} catch (Exception e) {
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
}
