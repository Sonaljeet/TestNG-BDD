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

import commonFunctions.WebElementCommon;
import commonFunctions.WebLink;
import commonFunctions.WebPage;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;

public class BCM_Setup_Home_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	private static BCM_Setup_Home_Page_Factory homePageFactory = null;
	private static BCM_Setup_ContractInformation_Page_Factory contractInfoPage=null;
	private static BCM_Login_Page_Action loginPageAction = null;
	
	private static final By IMAGELOADER = By.id("loader");

	public BCM_Setup_Home_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPageAction = new BCM_Login_Page_Action(driver, logger);
		homePageFactory = new BCM_Setup_Home_Page_Factory(driver, logger);
	}

//==========WebElement related metods--START
	private static boolean clickOnSetupLink(){
		WebElement element=homePageFactory.get_setUpPage_SetupLink();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Setup Link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Setup Link");
			elementStatus=false;
		}
		return elementStatus;
	}
	
	private static boolean clickOnHomeLink(){
		WebElement element = homePageFactory.get_setUpPage_HomeLink();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Home Link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the home link");
			elementStatus=false;
		}
		return elementStatus;
	}
	
	private static boolean clickOnFavoriteLink(){
		WebElement element = homePageFactory.get_setUpPage_FavoriteLink();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Favorite link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the favorite link");
			elementStatus=false;
		}
		return elementStatus;
	}
	
	private static boolean clickOnLibraryLink(){
		WebElement element = homePageFactory.get_setUpPage_LibraryLink();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Library link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Library link");
			elementStatus=false;
		}
		return elementStatus;
	}
	
	private static boolean clickOnContactsLink(){
		WebElement element = homePageFactory.get_setUpPage_ContactsLink();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			logger.log(LogStatus.PASS, "Contacts link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Contacts link");
			elementStatus=false;
		}
		return elementStatus;
	}
	
	private static boolean clickOnOutsideAirLink(){
		WebElement element = homePageFactory.get_setUpPage_OutsideAirLink();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			logger.log(LogStatus.PASS, "Outside Air link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Outside Air link");
			elementStatus=false;
		}
		return elementStatus;
	}
	
	private static boolean clickOnContractInfoLink(){
		WebElement element=homePageFactory.get_setUpHome_ContractInfoLink();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			logger.log(LogStatus.PASS, "Contract Information link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the Contract Information link on Setup page");
		}
		return elementStatus;
	}
	
	private static boolean clickOnPointDiscoveryLink(){
		WebElement element=homePageFactory.get_setUpPage_PointDiscoveryLink();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			logger.log(LogStatus.PASS, "Point discovery link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the Point discovery link on Setup page");
		}
		return elementStatus;
	}
	
	private static boolean clickOnBuildingsLink(){
		WebElement element=homePageFactory.get_setUpPage_BuildingsLink();
		boolean elementStatus=false;
		if (element !=null) {
			WebLink.SendClickToLink(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Buildings link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the Buildings link on Setup page");
		}
		return elementStatus;
	}
	
	private static boolean clickOnSystemsyLink(){
		WebElement element=homePageFactory.get_setUpPage_SystemsLink();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			logger.log(LogStatus.PASS, "Systems link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the Systems link on Setup page");
		}
		return elementStatus;
	}
	
	private static boolean clickOnCustomSummaryLink(){
		WebElement element=homePageFactory.get_setUpPage_CustomSummaryLink();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			logger.log(LogStatus.PASS, "Custom Summary link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the Custom Summary link on Setup page");
		}
		return elementStatus;
	}
	
	private static boolean clickOnEnergyMeterLink(){
		WebElement element=homePageFactory.get_setUpPage_EnergyMeterLink();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			logger.log(LogStatus.PASS, "Energy Meter link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the Energy Meter link on Setup page");
		}
		return elementStatus;
	}
	
	private static boolean clickOnUserRoleLink(){
		WebElement element=homePageFactory.get_setUpPage_UserRoleLink();
		boolean elementStatus=false;
		if (element !=null) {
			element.click();
			logger.log(LogStatus.PASS, "User Role link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the User Role link on Setup page");
		}
		return elementStatus;
	}
	
	private static boolean clickOnAddUSerLink(){
		WebElement element=homePageFactory.get_setUpPage_AddUserLink();
		
		boolean elementStatus=false;
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebLink.SendClickToLink(driver, element);
			logger.log(LogStatus.PASS, "Add User link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to find the Add User link on Setup page");
		}
		return elementStatus;
	}
	
	
	
//==========WebElement related metods--END

// =========Test case methods--START ============
	
	public boolean homeLinkClick(){
		boolean linkClickStatus=clickOnHomeLink();
		return linkClickStatus;
	}
	
	public boolean homeFavoriteClick(){
		boolean linkClickStatus=clickOnFavoriteLink();
		return linkClickStatus;
	}
	
	public boolean homeLibraryClick(){
		boolean linkClickStatus=clickOnLibraryLink();
		return linkClickStatus;
	}
	
	public boolean homeContactsClick(){
		boolean linkClickStatus=clickOnHomeLink();
		return linkClickStatus;
	}
	
	public boolean homeOutsideAirClick(){
		boolean linkClickStatus=clickOnOutsideAirLink();
		return linkClickStatus;
	}
	
	public boolean setupLinkClick(){
		boolean linkClickStatus = clickOnSetupLink();
		return linkClickStatus;
	}
	
	public boolean ContractInfoLinkClick(){
		boolean linkClickStatus = clickOnContractInfoLink();
		return linkClickStatus;
	}
	public boolean PointDiscoveryLinkClick(){
		boolean linkClickStatus = clickOnPointDiscoveryLink();
		return linkClickStatus;
	}
	public boolean BuildingsLinkClick(){
		boolean linkClickStatus = clickOnBuildingsLink();
		return linkClickStatus;
	}
	public boolean SystemsLinkClick(){
		boolean linkClickStatus = clickOnSystemsyLink();
		return linkClickStatus;
	}
	public boolean CustomSummaryLinkClick(){
		boolean linkClickStatus = clickOnCustomSummaryLink();
		return linkClickStatus;
	}
	public boolean EnergyMeterLinkClick(){
		boolean linkClickStatus = clickOnEnergyMeterLink();
		return linkClickStatus;
	}
	public boolean UserRoleLinkClick(){
		boolean linkClickStatus = clickOnUserRoleLink();
		return linkClickStatus;
	}
	public boolean AddUserLinkClick(){
		boolean linkClickStatus = clickOnAddUSerLink();
		return linkClickStatus;
	}
	
	public boolean verifyOnlySetupLinkDisplayedAfterFirstLogin(String username, String password) {
		boolean errInfo = false;
		boolean testStatus = false;
		List<WebElement> allLinks = null;
		errInfo = loginPageAction.successfulLogin(username, password);
		String cssSelector = "*[automation_id]";
		if (errInfo) {
			allLinks = WebLink.getAllLinksByCSSSelector(driver, cssSelector);
			if (allLinks.size() == 1) {

				logger.log(LogStatus.PASS, "Only Setup Link present after successful first login");
				testStatus = true;
			} else {
				testStatus = false;
				logger.log(LogStatus.FAIL, "All links are displayed after successful first login");
			}
		}

		return testStatus;
	}
	
	public boolean verfiyAllLinksDisplayedOnSetupPageForAdminUser(String username, String password){
		boolean errInfo = false;
		boolean testStatus = false;
		List<WebElement> allLinks = null;
		errInfo = loginPageAction.successfulLogin(username, password);
		String cssSelector = "*[automation_id]";
		if (errInfo) {
			allLinks = WebLink.getAllLinksByCSSSelector(driver, cssSelector);
			if (allLinks.size() == 6) {

				logger.log(LogStatus.PASS, "Only Setup Link present after successful first login");
				testStatus = true;
			} else {
				testStatus = false;
				logger.log(LogStatus.FAIL, "All links are displayed after successful first login");
			}
		}
		return testStatus;
	}
	
	public boolean verifyAllSetupModulesAreDisplayedOnSetupLinkClick(String username, String password){
		boolean loginStatus=false;
		boolean contractInfoLinkStatus=true;
		boolean testStatus=false;
		String cssSelector = "*[automation_id]";
		loginStatus=loginPageAction.successfulLogin(username, password);
		clickOnSetupLink();
		contractInfoLinkStatus=clickOnContractInfoLink();
		
		if (loginStatus) {
			if (contractInfoLinkStatus) {
				testStatus=true;
				logger.log(LogStatus.PASS, "All modules are displayed on Setup page");
			}else{
				testStatus=false;
				logger.log(LogStatus.FAIL, "Failed to find all the modules on the home page");
			}
		}else{
			testStatus=false;
			logger.log(LogStatus.ERROR, "Unable to login. Please check the credentials provided");
		}
		return testStatus;
	}

	public boolean logout() {
		boolean testStatus=false;
		
		WebElement logoutDropDown = homePageFactory.get_setUpPage_LogOutDropDown();
		logoutDropDown.click();
		WebElementCommon.staticWait(5000);
		WebElement loginLink = homePageFactory.get_setUpPage_LogOutLink();
		if (loginLink != null) {
			WebLink.SendClickToLink(driver, loginLink);
			WebPage.waitForPageLoad(driver);
			WebPage.waitForJSandJQueryToLoad(driver);
			String pageTitle = driver.getTitle().trim();
			if (pageTitle.contains("Log In")) {
				testStatus=true;
			}
		}
		return testStatus;
	}
	
// =========Test case methods--END ============
}





































