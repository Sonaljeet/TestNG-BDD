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
import commonFunctions.WebCheckBox;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import commonFunctions.WebLink;
import commonFunctions.WebPage;
import commonFunctions.WebTable;
import mars.JCI.Project.BCM.Login.BCM_ChangePassword_Page_Action;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;
import mars.JCI.Projects.BCM.TextConstants.TextConstants;

public class BCM_Setup_AddUser_Page_Action {
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static BCM_Setup_AddUser_Page_Factory addUseFactory = null;
	private static BCM_Setup_Home_Page_Action setupHomePageAction = null;
	private static BCM_Login_Page_Action loginPageAction = null;
	private static BCM_ChangePassword_Page_Action changePasswordAction = null;
	private static BCM_Home_Page_Action homePageAction = null;
	private static String BCMusername = "bcmsysagent";
	private static String BCMpassword = "Aug@2016";
	private static final By IMAGELOADER = By.id("loader");
	
	By rows = By.tagName("tr");
	By columns = By.tagName("td");
	
	public BCM_Setup_AddUser_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		addUseFactory = new BCM_Setup_AddUser_Page_Factory(driver, logger);
		setupHomePageAction = new BCM_Setup_Home_Page_Action(driver, logger);
		loginPageAction = new BCM_Login_Page_Action(driver, logger);
		homePageAction = new BCM_Home_Page_Action(driver, logger);
	}

	//WebMethods Start	
	

	/**
	 * Verify new admin user can be created successfully.
	 *
	 * @param name the name
	 * @param userId the user id
	 * @param Password the password
	 * @param confirmPassword the confirm password
	 * @param contactNumber the contact number
	 * @param emailAddress the email address
	 * @return true, if successful
	 */
	public boolean verifyNewAdminUserCanBeCreatedSuccessfully(String name, String userId, String Password,
			String confirmPassword, String contactNumber, String emailAddress) {

		boolean testStatus = false;
		String errInfo = null;
		
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		clickAdminImageLink();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(1000);
		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterContactNumber(contactNumber);
		enterEmailAddress(emailAddress);
		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebPage.waitForPageLoad(driver);
		errInfo = getAddUpdateDeleteErrorMsg();
		if (errInfo.contains(TextConstants.USERADDSUCCESSFUL)) {
			testStatus = true;
		}
		return testStatus;
	}
		
	public boolean verifyNewCustomerUserCanBeCreatedSuccessfully(String name, String userId, String Password,
			String confirmPassword, String contactNumber, String emailAddress) {
		boolean testStatus = false;
		String errInfo = null;

		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		clickCustomerImageLink();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(2000);
		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterContactNumber(contactNumber);
		enterEmailAddress(emailAddress);
		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		errInfo = getAddUpdateDeleteErrorMsg();
		
		if (errInfo.contains(TextConstants.USERADDSUCCESSFUL)) {
			testStatus=true;
		}
		return testStatus;
	}

	public boolean verifyNewTechnicianUserCanBeCreatedSuccessfully(String name, String userId, String Password,
			String confirmPassword, String contactNumber, String emailAddress) {
		boolean testStatus = false;
		String errInfo = null;
		
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		clickTechnicianImagelink();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebElementCommon.staticWait(2000);
		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterContactNumber(contactNumber);
		enterEmailAddress(emailAddress);
		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		errInfo = getAddUpdateDeleteErrorMsg();
		
		if (errInfo.contains(TextConstants.USERADDSUCCESSFUL)) {
			testStatus=true;
		}
		return testStatus;
	}

	public boolean verifyErrorMessageForBlankFields() {
		boolean testStatus = false;

		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		if (	getNameErrorMsg().contains(TextConstants.BLANKNAME)
				&& getUserIdErrorMsg().contains(TextConstants.BLANKUSERID)
				&& getPasswordErrorMsg().contains(TextConstants.BLANKPASSWORD)
				&& getConfirmPasswordErrorMsg().contains(TextConstants.BLANKCONFIRMPASSWORD)
				&& getEmailErrorMsg().contains(TextConstants.BLANKEMAILADDRESS)) {
			
			testStatus=true;
		}
		
		return testStatus;
	}

	public boolean verifyExistingUserCanBeDeletedSuccessfully() {
		WebElement element = null;
		boolean testStatus = false;
		element = getGridTable();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		List<WebElement> gridRowElements = element.findElements(rows);

		WebLink.SendClickToLink(driver, gridRowElements.get(gridRowElements.size() - 1));
		clickDeleteButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		WebPage.waitForPageLoad(driver);
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		clickDeleteYesButton();
		WebPage.waitForPageLoad(driver);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		
		String errInfo = getAddUpdateDeleteErrorMsg();
		if (errInfo.contains(TextConstants.USERDELETESUCCESSFUL.trim())) {
			testStatus = true;
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForAHU(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchAHUText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"AHU");
		WebPage.scrollToElement(driver, searchAHUText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewAHU();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getAHULink().getAttribute("class").trim();
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForVAV(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchVAVText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"Variable Air volume");
		WebPage.scrollToElement(driver, searchVAVText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewVAV();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();
		System.out.println("message : "+userAddMessage);
		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);
			
			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String VAVattributeValue = homePageAction.getVAVLink().getAttribute("class").trim();
			System.out.println("Attribute value : "+VAVattributeValue);
			if (VAVattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForPAU(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchPAUText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"PAU");
		WebPage.scrollToElement(driver, searchPAUText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewPAU();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getPAULink().getAttribute("class");
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForFCU(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchAHUText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"FAN COIL UNIT");
		WebPage.scrollToElement(driver, searchAHUText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewFCU();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getFCULink().getAttribute("class");
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForAcPlant(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchACPLANTText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"AC PLANT");
		WebPage.scrollToElement(driver, searchACPLANTText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewAcPlant();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getACPlantLink().getAttribute("class");
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForBoiler(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchAHUText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"BOILER");
		WebPage.scrollToElement(driver, searchAHUText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewBoiler();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getBoilerLink().getAttribute("class");
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForExhaustFan(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchAHUText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"EXHAUST FAN");
		WebPage.scrollToElement(driver, searchAHUText);
		WebElementCommon.staticWait(3000);
		WebElement viewExhaustFan = getCBViewExhaustFan();
		viewExhaustFan.click();
		System.out.println("viewExhaustFan status : " +viewExhaustFan.getAttribute("checked"));
		WebElementCommon.staticWait(4000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getExhaustFanLink().getAttribute("class");
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForSumpPump(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchSumpPumpText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"SUMP PUMP");
		WebPage.scrollToElement(driver, searchSumpPumpText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewSumpPump();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getSumpPumpLink().getAttribute("class");
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
	public boolean verifyUserAccessRightsForMiscellaneous(String name, String userId, String Password, String confirmPassword,
			String contactNumber, String emailAddress) {

		boolean testStatus = false;
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);

		WebElement searchMiscellaneousText = WebTable.SeacrhAndReturnTableElementByName(addUseFactory.get_UserRolesTable(),
				"MISCELLANEOUS");
		WebPage.scrollToElement(driver, searchMiscellaneousText);
		WebElementCommon.staticWait(3000);
		WebElement viewAHU = getCBViewMiscellaneous();
		viewAHU.click();
		WebElementCommon.staticWait(2000);
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);


		enterName(name);
		enterUserId(userId);
		enterPassword(Password);
		enterConfirmPassword(confirmPassword);
		enterEmailAddress(emailAddress);

		clickAddButton();
		WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		String userAddMessage = getAddUpdateDeleteErrorMsg();

		if (userAddMessage.contains(TextConstants.USERADDSUCCESSFUL)) {

			setupHomePageAction.logout();
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);

			loginPageAction.clickOnChangePasswordLink();

			WebElementCommon.staticWait(5000);
			WebPage.waitForPageLoad(driver);

			changePasswordAction = new BCM_ChangePassword_Page_Action(driver, logger);
			changePasswordAction.enterUserName(userId);
			changePasswordAction.enterOldPassword(confirmPassword);
			changePasswordAction.enterNewPassword(BCMpassword);
			changePasswordAction.enterConfirmPassword(BCMpassword);
			changePasswordAction.clickOnBtnChangePassword();

			WebElementCommon.staticWait(3000);
			loginPageAction.successfulLogin(userId, BCMpassword);
			setupHomePageAction.homeLinkClick();
			WebPage.waitForPageLoad(driver);

			homePageAction.clickBuildingLink();
			WebElementCommon.staticWait(3000);
			String AHUattributeValue = homePageAction.getMiscellaneousLink().getAttribute("class");
			if (AHUattributeValue.contains("aspNetDisabled animatedimage greyOutDisplay")) {
				testStatus = true;
			}
		}
		return testStatus;
	}
	
/*	public void scrllToElementinView(){
	
		WebElement element = addUseFactory.get_UserRolesTable();
		List<WebElement> rowsElement = WebTable.getTableRowWebElements(element);
		System.out.println("==============================");
		WebElement searchedElement = WebTable.SeacrhAndReturnTableElementByName(element, "AHU");
		if (searchedElement !=null) {
			WebPage.scrollToElement(driver, searchedElement);
			WebElementCommon.staticWait(10000);
			searchedElement.click();
			WebElementCommon.staticWait(10000);
			System.out.println("Element is not null");
		}else{System.out.println("Element is null");}	
	}*/
	//WebMethods End

//Get WEBELEMENTS from factory--Start
	
	public WebElement getGridTable(){
		WebElement element= null;
		boolean elementStatus=false;
		element = addUseFactory.get_gridTable();
		return element;
	}
	
	private boolean clickAdminImageLink(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_adminImageLink()  ;
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked on Admin image link");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Admin Image link");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean clickCustomerImageLink(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_customerImageLink()  ;
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked on Customer Image link");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Customer Image link");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean clickTechnicianImagelink(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_technicianImageLink()  ;
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked on Technician Image link");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Technician Image link");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean enterName(String username){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_nameField()  ;
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, username);
			logger.log(LogStatus.PASS, "Successfully entered \""+username +"\" in Name Field");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Name Field");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean enterUserId(String userid){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_userIdField();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, userid);
			logger.log(LogStatus.PASS, "Successfully entered \""+userid +"\" in User Id Field");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find USer Id field");
			elementStatus = false;
		}
		return elementStatus;
	}

	private boolean enterPassword(String password1){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_passwordField()  ;
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, password1);
			logger.log(LogStatus.PASS, "Successfully entered \""+password1 +"\" in Password Field");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Password field");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean enterConfirmPassword(String confirmPassword){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_confirmPasswordField()  ;
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, confirmPassword);
			logger.log(LogStatus.PASS, "Successfully entered \""+confirmPassword +"\" in Confirm Password Field");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Confirm Password Field");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean enterContactNumber(String contactNumber){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_contactNumberField()  ;
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, contactNumber);
			logger.log(LogStatus.PASS, "Successfully entered \""+contactNumber +"\" in Contact Number Field");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Contact Number Field");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean enterEmailAddress(String emailAddress){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_emailAddressField()  ;
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, emailAddress);
			logger.log(LogStatus.PASS, "Successfully entered \""+emailAddress +"\" in Email Address Field");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Email Address Field");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean clickAddButton(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_addBUtton()  ;
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked on Add button");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Add Button");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean clickClearButton(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_clearButton()  ;
		if (element != null) {
			WebLink.SendClickToLink(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked on Clear Button");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Clear Button");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private boolean clickDeleteButton(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_deleteButton()  ;
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked on Delete Button");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Delete Button");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean clickDeleteYesButton(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_deleteYesButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked Yes Button");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Yes Button");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean clickOnDeleteNoButton(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_deleteNoButton()  ;
		if (element != null) {
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Successfully clicked on No Button");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find No Button");
			elementStatus = false;
		}
		return elementStatus;
	}
	//Grid data getters

	
	//Error messages getters	
	private String getNameErrorMsg(){
		WebElement element = null;
		String errInfo = null;
		element = addUseFactory.get_errorMessageName();
		
		if (element != null) {
			errInfo = WebElementCommon.getElementText(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully found error message \""+ errInfo +"\"");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message for Name field");
		}
		return errInfo.trim();
	}
	
	private String getUserIdErrorMsg(){
		WebElement element = null;
		String errInfo=null;
		element = addUseFactory.get_errorMessageUserId()  ;
		
		if (element != null) {
			errInfo = WebElementCommon.getElementText(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully found error message \""+ errInfo +"\"");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message for User ID field");
		}
		return errInfo.trim();
	} 
	
	private String getPasswordErrorMsg(){
		WebElement element = null;
		boolean elementStatus = false;
		String errInfo=null;
		
		element = addUseFactory.get_errorMessagePassword()  ;
		if (element != null) {
			errInfo = WebElementCommon.getElementText(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully found error message \""+ errInfo);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message for Password field" +"\"");
		}
		return errInfo.trim();
	}
	
	private String getConfirmPasswordErrorMsg(){
		WebElement element = null;
		String errInfo=null;
		
		element = addUseFactory.get_errorMessageConfirmPassword();
		if (element != null) {
			errInfo = WebElementCommon.getElementText(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully found error message \""+ errInfo +"\"");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message for Password field");
		}
		return errInfo.trim();
	}
	
	private String getEmailErrorMsg(){
		WebElement element = null;
		String errInfo = null;
		
		element = addUseFactory.get_errorMessageEmail();
		if (element != null) {
			errInfo = WebElementCommon.getElementText(driver, element, logger);
			logger.log(LogStatus.PASS, "Successfully found error message \""+ errInfo+"\"");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Error message for Email field");
		}
		return errInfo.trim();
	}
	
	private String getAddUpdateDeleteErrorMsg(){
		WebElement element = null;
		String errInfo = null;
		element = addUseFactory.get_infoAddUpdateDelete()  ;
		if (element != null) {
			errInfo = WebElementCommon.getElementText(driver, element, logger);
			errInfo=errInfo.trim();
			logger.log(LogStatus.PASS, "Successfully found message \""+ errInfo +"\"");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find message for Email field");
		}
		return errInfo.trim();
	}
//CheckBoxes getters	
	private boolean getCBViewBCM(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewBCM()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View BCM Checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find BCM View checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private boolean getCBEditBCM(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditBCM()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit BCM Checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find BCM Edit checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBViewSetup(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewSetup()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Setup Checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find view Setup checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditSetup(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditSetup()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Setup Checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Setup edit checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBViewContractInfo(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewContractInfo()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Contract Information checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View contract information checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditContractInfo(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditContractInfo()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Contract Information checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit contract information checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private boolean getCBViewPointDiscovery(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewPointDiscovery()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked view Point discovery checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Point discovery checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditPointDiscovery(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditPointDiscovery()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Point discovery checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Point discovery checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	
	private boolean getCBViewBuildings(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewBuildings();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Buildings checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Buildings checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditBuildings(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditBuildings();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Buildings checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Buildings checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBViewSystems(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewSystems()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Systems checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Systems checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private boolean getCBEditSystems(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditSystems()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Systems checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Systems checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBViewCustomSummary(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewCustomSummary();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Custom Summary checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Custom Summary checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditCustomSummary(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditCustomSummary();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Custom Summary checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Custom Summary checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBViewEnergyMeter(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewEnergyMeter()  ;
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked view Energy Meter checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Energy Meter checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditEnergyMeter(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditEnergyMeter();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Energy Meter checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Energy Meter checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBViewUserRole(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewUserRole();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View User Role checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View User Role checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditUserRole(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditUserRole();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit User Role checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit User Role checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private boolean getCBViewAddUser(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewAddUser();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Add user checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Add user checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditAddUser(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditAddUser();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Add user checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Add user checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBViewFloorPlan(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewFloorPlan();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Floor plan checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Floor plan checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private boolean getCBEditFloorPlan(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewFloorPlan();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Floor plan checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Floor plan checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private WebElement getCBViewAHU(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewAHU();
		if (element != null) {	
			logger.log(LogStatus.PASS, "Successfully Checked View AHU checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View AHU checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditAHU(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditAHU();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit AHU checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit AHU checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewVAV(){
		WebElement element = null;		
		element = addUseFactory.get_chkViewVAV();
		if (element != null) {
			logger.log(LogStatus.PASS, "Successfully found View VAV checkbox");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View VAV checkbox");
		}
		return element;
	}
	
	private boolean getCBEditVAV(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditVAV();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit VAV checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit VAV checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewAcPlant(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewACplant();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View AC Plant checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View AC Plant checkbox");
			elementStatus = false;
		}
		return element;
	} 
	
	private boolean getCBEditAcPlant(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditACplant();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit AC Plant checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit AC Plant checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private WebElement getCBViewBoiler(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewBoiler();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View Boiler checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Boiler checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditBoiler(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditBoiler();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Boiler checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Boiler checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewAlarm(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewAlarm();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View Alarm checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Alarm checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditAlarm(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditAlarm();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Alarm checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Alarm checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private WebElement getCBViewTrend(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewTrend();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View Trend checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Trend checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditTrend(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditTrend();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Trend checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Trend checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewSchedule(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewSchedule();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully Checked View Schedule checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Schedule checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditSchedule(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditSchedule();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Schedule checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Schedule checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewEnergy(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewEnergy();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View Energy checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Energy checkbox");
			elementStatus = false;
		}
		return element;
	} 
	
	private boolean getCBEditEnergy(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditEnergy();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Energy checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Energy checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewFCU(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewFCU();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View FCU checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View FCU checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditFCU(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditFCU();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit FCU checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit FCU checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewExhaustFan(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewExhaustFan();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View Exhaust Fan checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Exhaust Fan checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditExhaustFan(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditExhaustFan();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Exhaust Fan checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Exhaust Fan checkbox");
			elementStatus = false;
		}
		return elementStatus;
	} 
	
	private WebElement getCBViewSumpPump(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewSumpPump();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully Checked View SumpPump checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View SumpPump checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private boolean getCBEditSumpPump(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditSumpPump();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Sump Pump checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Sump Pump checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}
	
	private WebElement getCBViewPAU(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewPAU();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully found View PAU checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View PAU checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private WebElement getCBEditPAU(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditPAU();
		if (element != null) {
			
			logger.log(LogStatus.PASS, "Successfully Checked Edit PAU checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit PAU checkbox");
			elementStatus = false;
		}
		return element;
	}
	
	private WebElement getCBViewMiscellaneous(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkViewMiscellaneous();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked View Miscellaneous checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find View Miscellaneous checkbox");
			elementStatus = false;
		}
		return element;
	} 
	
	private boolean getCBEditMiscellaneous(){
		WebElement element = null;
		boolean elementStatus = false;
		
		element = addUseFactory.get_chkEditMiscellaneous();
		if (element != null) {
			WebCheckBox.Select_The_Checkbox(element, logger);
			logger.log(LogStatus.PASS, "Successfully Checked Edit Miscellaneous checkbox");
			elementStatus = true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Edit Miscellaneous checkbox");
			elementStatus = false;
		}
		return elementStatus;
	}

//Get WEBELEMENTS from factory--End
	
//==========================================================


}
