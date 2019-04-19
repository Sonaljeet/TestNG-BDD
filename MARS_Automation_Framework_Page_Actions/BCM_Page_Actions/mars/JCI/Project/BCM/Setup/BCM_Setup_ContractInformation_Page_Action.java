/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.Document;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebPage;

public class BCM_Setup_ContractInformation_Page_Action {

	private static final String EMPTY_STRING = "";
	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	private static BCM_Setup_ContractInformation_Page_Factory contractInfoPageFactory = null;
	private static final By IMAGELOADER = By.id("loader");
	public BCM_Setup_ContractInformation_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;

		contractInfoPageFactory = new BCM_Setup_ContractInformation_Page_Factory(driver, logger);
	}

	// WebElement methods -- START

	private static boolean enterCustomerName(String customerName) {
		WebElement element = null;
		boolean elementFound = false;
		element = contractInfoPageFactory.get_setUpContractInfo_CustomerName();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, customerName);
			logger.log(LogStatus.PASS, customerName + " entered in Customer Name field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Customer Name field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterCustomerInfoContactNumber(String contactNumber) {
		WebElement element = null;
		boolean elementFound = false;
		element = contractInfoPageFactory.get_setUpContractInfo_ContactNumber();

		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, contactNumber);
			logger.log(LogStatus.PASS, contactNumber + " entered in Contact Number field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Contact Number field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean selectCountry(String countryName) {
		WebElement element = null;
		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_CountryDropDown();
		if (element != null) {
			commonFunctions.WebDropDown.SelectElementByValue(element, countryName);
			logger.log(LogStatus.FAIL, countryName + " selected in the Country Drop down");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Country Drop down");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterState(String stateName) {
		WebElement element = null;
		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_State();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, stateName);
			logger.log(LogStatus.FAIL, stateName + " entered in the State field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the State field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterAddress1(String address1) {
		WebElement element = null;

		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_Address1();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, address1);
			logger.log(LogStatus.FAIL, address1 + " entered in the Address1 field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Address1 field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterAddress2(String address2) {
		WebElement element = null;

		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_Address2();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, address2);
			logger.log(LogStatus.FAIL, address2 + " entered in the Address2 field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Address2 field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterCity(String cityName) {
		WebElement element = null;

		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_City();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, cityName);
			logger.log(LogStatus.FAIL, cityName + " entered in the City Name field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the City Name field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterPinCode(String pinCode) {
		WebElement element = null;

		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_City();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, pinCode);
			logger.log(LogStatus.FAIL, pinCode + " entered in the pin Code field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the pin Code field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterEmailAddress(String emailAddress) {
		WebElement element = null;
		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_Email();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, emailAddress);
			logger.log(LogStatus.PASS, emailAddress + " entered in the email Address field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the email Address field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean clickOnSaveButton() {
		WebElement element = null;
		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpContractInfo_SaveButton();
		if (element != null) {
			commonFunctions.WebElementCommon.staticWait(3000);
			commonFunctions.WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Save button clicked successfully");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Save button");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean selectGroupName(String groupName) {
		WebElement element = null;
		WebElement element1, element2 = null;
		boolean elementFound = false;
		String dropDownText = null;
		String script = null;

		commonFunctions.WebElementCommon.staticWait(5000);
		element = contractInfoPageFactory.get_setUpEmergencyContact_GroupName();

		if (element != null) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			element.click();

			commonFunctions.WebElementCommon.staticWait(1000);
			Actions action1 = new Actions(driver);
			switch (groupName) {
			case "Please Select":
				element1 = contractInfoPageFactory.gpValPlzSelect();

				action1.moveToElement(element1).perform();
				element1.click();

				script = "return document.getElementById('ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_ClientState').getAttribute('value');";

				dropDownText = ((JavascriptExecutor) driver).executeScript(script).toString();
				System.out.println(dropDownText);
				break;
			case "Security & Fire":
				element1 = contractInfoPageFactory.gpValSecAndFire();

				action1.moveToElement(element1).perform();
				element1.click();

				script = "return document.getElementById('ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_ClientState').getAttribute('value');";

				dropDownText = ((JavascriptExecutor) driver).executeScript(script).toString();
				System.out.println(dropDownText);
				break;
			case "BMS Technician":
				element1 = contractInfoPageFactory.gpValBMSTech();

				action1.moveToElement(element1).perform();
				element1.click();

				script = "return document.getElementById('ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_ClientState').getAttribute('value');";

				dropDownText = ((JavascriptExecutor) driver).executeScript(script).toString();
				System.out.println(dropDownText);
				break;
			case "Emergency Contact":
				element1 = contractInfoPageFactory.gpValEmerCont();

				action1.moveToElement(element1).perform();
				element1.click();

				script = "return document.getElementById('ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_ClientState').getAttribute('value');";

				dropDownText = ((JavascriptExecutor) driver).executeScript(script).toString();
				System.out.println(dropDownText);
				break;
			case "Building Owner":
				element1 = contractInfoPageFactory.gpValBuilOwn();

				action1.moveToElement(element1).perform();
				element1.click();

				script = "return document.getElementById('ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_ddGroupName_ClientState').getAttribute('value');";

				dropDownText = ((JavascriptExecutor) driver).executeScript(script).toString();
				System.out.println(dropDownText);
				break;

			default:
				dropDownText = "Fail";
				break;
			}

			if (dropDownText.contains(groupName)) {
				logger.log(LogStatus.PASS, groupName + " selected in the Group Name Drop down");
				elementFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to set the drop down to desired value of - " + groupName);
				elementFound = false;
			}
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Group Name Drop down");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterContactPerson(String contactPerson) {
		WebElement element = null;
		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpEmergencyContact_ContactPerson();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, contactPerson);
			logger.log(LogStatus.PASS, contactPerson + " entered in the Contact Person field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Contact Person field");
			elementFound = false;
		}
		return elementFound;

	}

	private static boolean enterEmergencyContactNumber(String contactNumber) {
		WebElement element = null;
		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpEmergencyContact_ContactNumber();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, contactNumber);
			logger.log(LogStatus.PASS, contactNumber + " entered in the Contact Number field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Contact Number field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean enterEmergencyEmailAddress(String emergencyEmailAddress) {
		WebElement element = null;
		boolean elementFound = false;

		element = contractInfoPageFactory.get_setUpEmergencyContact_EmailAddress();
		if (element != null) {
			element.clear();
			commonFunctions.WebInputTextBox.SendInputTextBox(driver, element, emergencyEmailAddress);
			logger.log(LogStatus.PASS, emergencyEmailAddress + " entered in the Emergency Email Address field");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Emergency Email Address field");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean clickOnAddButton() {
		WebElement element = null;
		boolean elementFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_AddButton();
		if (element != null) {
			commonFunctions.WebElementCommon.staticWait(5000);
			commonFunctions.WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Add button clicked successfully");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find Add button");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean clickOnClearButton() {
		WebElement element = null;
		boolean elementFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_ClearButton();
		if (element != null) {
			commonFunctions.WebElementCommon.staticWait(5000);
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Add button clicked successfully");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find Add button");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean clickOnNextButton() {
		WebElement element = null;
		boolean elementFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_NextButon();
		if (element != null) {
			commonFunctions.WebElementCommon.staticWait(5000);
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Add button clicked successfully");
			elementFound = true;
		} else {
			logger.log(LogStatus.FAIL, "Failed to find Add button");
			elementFound = false;
		}
		return elementFound;
	}

	private static boolean getCustomerNameErrorMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		// element = contractInfoPageFactory.getPageBody();
		element = contractInfoPageFactory.get_setUpContractInfo_CustomerNameErrorMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;
	}

	private static boolean getBlankEmailErroMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		// element = contractInfoPageFactory.getPageBody();
		element = contractInfoPageFactory.get_setUpContractInfo_EmailAddressErrorMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;
	}

	private static boolean getInvalidEmailErrorMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		// element = contractInfoPageFactory.getPageBody();
		element = contractInfoPageFactory.get_setUpContractInfo_EmailAddressErrorMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static boolean getGroupNameBlankErrorMEssage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;

		element = contractInfoPageFactory.get_setUpEmergencyContact_SelectGroupErrorMsg();
		if (element != null) {
			System.out.println("Webelement is not null");
			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static boolean getBlankEmergencyContactPersonErrorMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_ContactPersonErrorMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static boolean getBlankEmergencyContactNumberErrorMesage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_ContactNumberErrorMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static boolean getBlankEmergencyEmailAddressErrorMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_EmailAddressErrorMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static boolean getInvalidEmergencyEmailAddressErrorMesage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_InvalidEmailErrorMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorInfo + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static boolean getEmergencyInfoAddInfoMEssage(String errorMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		element = contractInfoPageFactory.get_setUpEmergencyContact_InfoSaveMessage();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorMessage + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static boolean getCustomerDetailsSaveInfoMessage(String errorSaveMessage, String errorUpdateMessage) {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		element = contractInfoPageFactory.get_setUpContractInfo_CustomerInfoSaveMsg();
		if (element != null) {

			errorInfo = WebElementCommon.getElementText(driver, element, logger);
			if (errorInfo.toLowerCase().contains(errorSaveMessage.toLowerCase())
					|| errorInfo.toLowerCase().contains(errorUpdateMessage.toLowerCase())) {

				logger.log(LogStatus.PASS, "HTML",
						"Successfully found error message which is </br>\"" + errorInfo + "\"");
				textFound = true;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				textFound = false;
			}
		}
		return textFound;

	}

	private static int getgridTableRowsCount() {
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		List<WebElement> dataRows = null;
		
		By dataGridRows=new By.ByXPath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadGrid1_ctl00\"]/tbody/tr");
		By dataGridColumns= new By.ByXPath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadGrid1_ctl00__0\"]/td");
		
		element = contractInfoPageFactory.get_gridTable();
		if (element != null) {
			dataRows = element.findElements(dataGridRows);
			System.out.println(dataRows.size());
			List<WebElement> columnData = dataRows.get(0).findElements(dataGridColumns);
			System.out.println(columnData.size());
		}
		return dataRows.size();
	}
	
	private static List<WebElement> getGridRowColumnValues(){
		WebElement element = null;
		String errorInfo = null;
		boolean textFound = false;
		List<WebElement> dataRows = null;
		List<WebElement> columnData = null;
		
		By dataGridRows=new By.ByXPath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadGrid1_ctl00\"]/tbody/tr");
		By dataGridColumns= new By.ByXPath("//*[@id=\"ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadGrid1_ctl00__0\"]/td");
		
		element = contractInfoPageFactory.get_gridRows();
		if (element != null) {
			dataRows = element.findElements(dataGridRows);
			columnData=dataRows.get(0).findElements(dataGridColumns);
		}
		return columnData;
	}
	// WebElement methods -- END

	// Test case methods-- START
	public boolean verifyErrorMessageForBlankCustomerName(String customerName, String emailAddress,
			String errorMessage) {
		boolean errInfo = false;

		enterCustomerName(customerName);
		enterEmailAddress(emailAddress);
		clickOnSaveButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getCustomerNameErrorMessage(errorMessage);
		return errInfo;
	}

	public boolean verifyErrorMessageForBlankContractEmailAddress(String customerName, String emailAddress,
			String errorMessage) {
		boolean textStatus = false;

		enterCustomerName(customerName);
		enterEmailAddress(emailAddress);
		clickOnSaveButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		textStatus = getBlankEmailErroMessage(errorMessage);
		return textStatus;
	}

	public boolean verifyErrorMessageForInvalidContractEmailAddress(String customerName, String emailAddress,
			String errorMessage) {
		boolean textStatus = false;

		enterCustomerName(customerName);
		enterEmailAddress(emailAddress);
		clickOnSaveButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		textStatus = getInvalidEmailErrorMessage(errorMessage);
		return textStatus;
	}

	public boolean verifySaveSuccessfulMessage(String customerName, String emailAddress, String errorSaveMessage,
			String errorUpdateMessage) {
		boolean errInfo = false;

		enterCustomerName(customerName);
		enterEmailAddress(emailAddress);
		clickOnSaveButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getCustomerDetailsSaveInfoMessage(errorSaveMessage, errorUpdateMessage);
		return errInfo;

	}

	public boolean verifyMessageForBlankGroupName(String groupName, String contactPerson, String contactNumber,
			String emergencyEmailAddress, String errorMessage) {
		boolean errInfo = false;
		
		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(3000);
		errInfo = getGroupNameBlankErrorMEssage(errorMessage);

		return errInfo;

	}

	public boolean verifyErrorMessageForBlankContactPerson(String groupName, String contactPerson, String contactNumber,
			String emergencyEmailAddress, String errorMessage) {
		boolean errInfo = false;

		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getBlankEmergencyContactPersonErrorMessage(errorMessage);

		return errInfo;

	}

	public boolean verifyErrorMessageForBlankContactNumber(String groupName, String contactPerson, String contactNumber,
			String emergencyEmailAddress, String errorMessage) {
		boolean errInfo = false;

		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getBlankEmergencyContactNumberErrorMesage(errorMessage);

		return errInfo;

	}

	public boolean verifyErrorMessageForBlankEmergencyEmailAddress(String groupName, String contactPerson,
			String contactNumber, String emergencyEmailAddress, String errorMessage) {
		boolean errInfo = false;

		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getBlankEmergencyEmailAddressErrorMessage(errorMessage);

		return errInfo;

	}

	public boolean verifyErrorMessageForInvalidEmergencyEmailFormat(String groupName, String contactPerson,
			String contactNumber, String emergencyEmailAddress, String errorMessage) {
		boolean errInfo = false;

		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getInvalidEmergencyEmailAddressErrorMesage(errorMessage);

		return errInfo;

	}

	public boolean verifySuccessFullAddEmergencyContactInfo(String groupName, String contactPerson,
			String contactNumber, String emergencyEmailAddress, String errorMessage) {
		boolean errInfo = false;

		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getEmergencyInfoAddInfoMEssage(errorMessage);

		return errInfo;

	}

	// TODO
	public boolean verifyEmergencyInfoAddedCanBeRetrieved(String groupName, String contactPerson,
			String contactNumber, String emergencyEmailAddress, String errorMessage) {
		
		boolean testStatus= false;
		List<WebElement> columnElements = null;
		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebPage.waitForJSandJQueryToLoad(driver);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		columnElements = getGridRowColumnValues();

		if ( !columnElements.isEmpty()) {
			
			System.out.println(columnElements.get(1).getText() + "\n" + columnElements.get(2).getText() + "\n" + columnElements.get(3).getText() + "\n" + columnElements.get(4).getText() + "\n");
	
			if (groupName.contains(columnElements.get(1).getText()) &&
				contactPerson.contains(columnElements.get(2).getText()) &&
				contactNumber.contains(columnElements.get(3).getText()) &&
				emergencyEmailAddress.contains(columnElements.get(4).getText())) {
				testStatus = true;
			}
		}
		return testStatus;
	}

	// TODO
	public int verifyEmergencyRecordAddedIsShownInLowerDataGrid(String groupName, String contactPerson,
			String contactNumber, String emergencyEmailAddress, String errorMessage ) {
		int finalCount = 0;
		
		int rowInitialRowCount = getgridTableRowsCount();
		selectGroupName(groupName);
		enterContactPerson(contactPerson);
		enterEmergencyContactNumber(contactNumber);
		enterEmergencyEmailAddress(emergencyEmailAddress);
		clickOnAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebPage.waitForJSandJQueryToLoad(driver);
		if (getEmergencyInfoAddInfoMEssage(errorMessage)) {
			int rowFinalRowCount = getgridTableRowsCount();
			finalCount = rowFinalRowCount - rowInitialRowCount;
		}
		return finalCount;
	}

	// TODO
	public void verifyExistingEmergencyRecordCanBeDeletedSuccessfully() {

	}

	public boolean verifyContractInfoCanBeUpdatedSuccessfully(String customerName, String errorMessage) {
		boolean errInfo = false;
		enterCustomerName(customerName);
		clickOnSaveButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getEmergencyInfoAddInfoMEssage(errorMessage);

		return errInfo;
	}
	// Test case methods-- END
}
