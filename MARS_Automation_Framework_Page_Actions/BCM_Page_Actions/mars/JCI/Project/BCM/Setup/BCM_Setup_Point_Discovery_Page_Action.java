/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Action;
import mars.JCI.Projects.BCM.TextConstants.TextConstants;

public class BCM_Setup_Point_Discovery_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static final By IMAGELOADER = By.id("loader");
	
	private static BCM_Setup_Point_Discovery_Page_Factory pointDiscoveryFactory = null;
	private static BCM_Login_Page_Action loginPageAction = null;
	private static BCM_Setup_Home_Page_Action setupHomePageAction = null;
	
	public BCM_Setup_Point_Discovery_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		pointDiscoveryFactory = new BCM_Setup_Point_Discovery_Page_Factory(driver, logger);
	}
	
	//Test Methods Start
	public boolean verifyDiscoveredPointsCanBeExportedSuccessfully(String loginUsername, String loginPassword){
		loginPageAction.successfulLogin(loginUsername, loginPassword);
		setupHomePageAction.setupLinkClick();
		setupHomePageAction.PointDiscoveryLinkClick();
		clickOnDiscoverEquipmentsButton();
		return true;
	}
	//Test Methods End
	
	
	//WebElement getters Start
	public void clickOnDiscoverEquipmentsButton(){
		WebElement element = null;
		element = pointDiscoveryFactory.get_discoverEquipmentsButton();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Discover Equipments button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Discover Equipments button");
		}
	}
	
	public void clickOnexportDiscoveredPointsButton(){
		WebElement element = null;
		element = pointDiscoveryFactory.get_exportDiscoveredPointsButton();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Export Discovered Equipments button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Export Discover Equipments button");
		}
	}
	
	public void clickOnimportDiscoveredPointsButton(){
		WebElement element = null;
		element = pointDiscoveryFactory.get_importDiscoveredPointsButton();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Import Discover Equipments button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Import Discover Equipments button");
		}
	}
	
	public void clickOnbrowseExcelButton(){
		WebElement element = null;
		element = pointDiscoveryFactory.get_browseExcelButton();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Browse Excel button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Browse Excel button");
		}
	}
	
	public void clickOnsubmitUpdatedPointsButton(){
		WebElement element = null;
		element = pointDiscoveryFactory.get_submitUpdatedPointsButton();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Submit UpdatedPoints Button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Submit UpdatedPoints Button");
		}
	}
	
	public String getsaveUpdateErrorInfoMsg(){
		WebElement element = null;
		String infoMessage = null;
		element = pointDiscoveryFactory.get_saveUpdateErrorInfoMsg();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			infoMessage = element.getText();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Text found successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Info message");
		}
		
		return infoMessage;
	}
	
	public WebElement getDiscoveredPointsGrid(){
		WebElement element = null;
		element = pointDiscoveryFactory.get_pointDiscoveryTableGrid();
		if (element !=null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Discover Equipments button clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Discover Equipments button");
		}
		return element;
	}
	//WebElement getters End
}
















