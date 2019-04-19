/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebButton;
import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCM.Constants.TextConstants;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;

public class BCM_Setup_ContractInformation_Page_Test extends BaseClass {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	private static BCM_Setup_ContractInformation_Page_Action conInfoAction = null;
	private static BCM_Login_Page_Action loginPage = null;
	private static BCM_Setup_Home_Page_Action setupHomeAction = null;
	private static String userName = "bcmsysagent";
	private static String password = "Aug@2016";
	
	
	private static void initialize() {
		driver = BaseClass.driver;
		logger = BaseClass.logger;

		loginPage = new BCM_Login_Page_Action(driver, logger);
		setupHomeAction = new BCM_Setup_Home_Page_Action(driver, logger);
		conInfoAction = new BCM_Setup_ContractInformation_Page_Action(driver, logger);

	}

	@Test(description = "Contract Info - Verify Error Message for Blank Customer Name")
	public void verifyMessageForBlankCUstomerName(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();
		errMsg = conInfoAction.verifyErrorMessageForBlankCustomerName("", "abc@abc.com",
				TextConstants.CONTRACTINFORMATION_CUSTOMERNAME);
		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify Error message for blank Email address field")
	public void verifyMessageForBlankEmailAddress(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();
		errMsg = conInfoAction.verifyErrorMessageForBlankContractEmailAddress("Anil Pandey", "",
				TextConstants.CONTRACTINFORMATION_BLANKEMAILADDRESS);

		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify error message for Invalid Email format")
	public void verifyMessageForInvalidEmailFormat(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();
		errMsg = conInfoAction.verifyErrorMessageForInvalidContractEmailAddress("Anil Pandey", "test",
				TextConstants.CONTRACTINFORMATION_INVALIDEMAILFORMAT);

		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify message when customer record is saved successfully")
	public void verifyCustomerRecordSaveMessage(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();

		errMsg = conInfoAction.verifySaveSuccessfulMessage("BCM Customer", "bcmcustomer@jci.com",
				TextConstants.CONTRACTINFORMATION_SAVESUCCESSFUL, TextConstants.CONTRACTINFORMATION_UPDATESUCCESSFUL);

		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify Message for blank Contact Person")
	public void verifyMessageForBlankContactPerson(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();
		errMsg = conInfoAction.verifyErrorMessageForBlankContactPerson("BMS Technician", "", "716381231", "bms@bms.com",
				TextConstants.CONTRACTINFORMATION_BLANKCONTACTPERSON);
		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify Message for blank Contact Number")
	public void verifyMessageForBlankContactNumber(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();

		errMsg = conInfoAction.verifyErrorMessageForBlankContactNumber("BMS Technician", "Contact Person", "",
				"bms@bms.com", TextConstants.CONTRACTINFORMATION_CONTACTNUMBER);
		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify Message for blank Emergency Email Address")
	public void verifyMessageForBlankEmergencyEmailAddress(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();
		errMsg = conInfoAction.verifyErrorMessageForBlankEmergencyEmailAddress("BMS Technician", "BMS Tecnician",
				"1783617831", "", TextConstants.CONTRACTINFORMATION_BLANKEMERGENCYEMAILADDRESS);
		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify Message for Invalid Emergency Email Address")
	public void verifyMessageForInvalidEmergencyEmailAddress(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();

		errMsg = conInfoAction.verifyErrorMessageForInvalidEmergencyEmailFormat("BMS Technician", "BMS", "3719231792",
				"abc", TextConstants.CONTRACTINFORMATION_INVALIDEMERGENCYEMAILADDRESS);
		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify Emergency Contact Info added is shown on UI")
	public void verifyTableDateInLowerGridAddedSuccessfully(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;
		int rowCount = 0;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();

		rowCount = conInfoAction.verifyEmergencyRecordAddedIsShownInLowerDataGrid("BMS Technician", "BMS", "3719231792",
				"abcxyz@abc.com", TextConstants.CONTRACTINFORMATION_EMERGENCYADDMESSAGE);
		if (rowCount == 1) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}

	@Test(description = "Contract Info - Verify that data added in emergency contact info can be retrieved successfully")
	public void verifyEmergencyInfoAddedCanBeRetrieved(Method method) {
		initialize();
		boolean testStatus = false;
		boolean errMsg = false;
		int rowCount = 0;

		loginPage.successfulLogin(userName, password);
		setupHomeAction.setupLinkClick();
		errMsg = conInfoAction.verifyEmergencyInfoAddedCanBeRetrieved("BMS Technician", "BMS", "3719231792",
				"abcxyz1@abc.com", TextConstants.CONTRACTINFORMATION_EMERGENCYADDMESSAGE);
		if (errMsg) {
			testStatus = true;
		}
		BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
	}
}
