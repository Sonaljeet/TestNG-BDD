/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebLink;
import commonFunctions.WebPage;
import commonFunctions.WebTable;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;
import mars.JCI.Projects.BCM.TextConstants.TextConstants;

public class BCM_Setup_UserRole_Page_Actions {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static String BCMusername = "bcmsysagent";
	private static String BCMpassword = "Aug@2016";

	private static BCM_Login_Page_Action loginPageAction = null;
	private static BCM_Setup_Home_Page_Action setupHomeAction = null;
	private static BCM_Setup_UserRole_Page_Factory userRoleFactory = null;

	private static final By IMAGELOADER = By.id("loader");

	public BCM_Setup_UserRole_Page_Actions(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;

		loginPageAction = new BCM_Login_Page_Action(driver, logger);
		setupHomeAction = new BCM_Setup_Home_Page_Action(driver, logger);
		userRoleFactory = new BCM_Setup_UserRole_Page_Factory(driver, logger);
	}

	// WebMethods START
	public boolean verifyAccessRightsForNewAdminUser() {
		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		clickAdminImageLink();
		
		WebLink.SendClickToLink(driver, getCBViewContractInfo());
		WebLink.SendClickToLink(driver, getCBViewBuildings());
		WebLink.SendClickToLink(driver, getCBViewSystems());
		WebButton.Button_Click(driver, userRoleFactory.get_SaveYesButton());
		
		String saveMessage = WebElementCommon.getElementText(driver, userRoleFactory.get_SaveUpdateMessageInfo(), logger);
		if (saveMessage.trim().contentEquals(TextConstants.UserRole_AddUpdateSuccessMessage)) {
			testStatus = true;
		}
		return testStatus;
	}

	public boolean verifyAccessRightsForAllAdminUser() {
		boolean testStatus = false;
		return testStatus;
	}

	// WebMethods START

	// WebElement getters -- START
	public boolean getImageLoader() {
		WebElement element = null;
		boolean elementStatus = false;
		element = userRoleFactory.get_ImageLoader();
		if (element != null) {
			elementStatus = true;
		}
		return elementStatus;
	}

	private boolean clickAdminImageLink() {
		WebElement element = null;
		boolean elementStatus = false;
		element = userRoleFactory.get_adminImageLink();
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			elementStatus = true;
			logger.log(LogStatus.PASS, "Admin link found successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Admin link");
		}
		return elementStatus;
	}

	private boolean clickCustomerImageLink() {
		WebElement element = null;
		boolean elementStatus = false;
		element = userRoleFactory.get_CustomerImageLink();
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			elementStatus = true;
			logger.log(LogStatus.PASS, "Customer link found successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer link");
		}
		return elementStatus;
	}

	private boolean clickTechnicianImageLink() {
		WebElement element = null;
		boolean elementStatus = false;
		element = userRoleFactory.get_TechnicianImageLink();
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			elementStatus = true;
			logger.log(LogStatus.PASS, "Technician link found successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Technician link");
		}
		return elementStatus;
	}

	private List<WebElement> getRolesDataTable() {
		WebElement element = null;
		List<WebElement> tableRows = null;
		element = userRoleFactory.get_UserRolesDataTable();
		tableRows = WebTable.getTableRowWebElements(element);
		return tableRows;
	}

	// CheckBox getters- There are only 3 checkboxes because only 3 will be used
	// for testing User Roles. need to write getters for more checkboxes in case
	// it is required.
	private WebElement getCBViewContractInfo() {
		WebElement element = null;
		element = userRoleFactory.get_chkViewContractInfo();
		if (element != null) {
			logger.log(LogStatus.PASS, "View ContractInfo Checkbox found successfully");
		} else
			logger.log(LogStatus.FAIL, "Failed to find View ContractInfo checkbox");
		return element;
	}

	private WebElement getCBViewBuildings() {
		WebElement element = null;
		element = userRoleFactory.get_chkViewBuildings();
		if (element != null) {
			logger.log(LogStatus.PASS, "Buildings view Checkbox found successfully");
		} else
			logger.log(LogStatus.FAIL, "Failed to find view Buildings checkbox");
		return element;
	}

	private WebElement getCBViewSystems() {
		WebElement element = null;
		element = userRoleFactory.get_chkViewSystems();
		if (element != null) {
			logger.log(LogStatus.PASS, "View Systems Checkbox found successfully");
		} else
			logger.log(LogStatus.FAIL, "Failed to find View Systems checkbox");
		return element;
	}
	// WebElement getters -- END

}
