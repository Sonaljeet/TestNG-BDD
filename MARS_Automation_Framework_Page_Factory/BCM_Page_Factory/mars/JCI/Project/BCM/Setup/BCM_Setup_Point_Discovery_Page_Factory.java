/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCM_Setup_Point_Discovery_Page_Factory {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	public BCM_Setup_Point_Discovery_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_btnDiscoverConnectedEquipments_input")
	private WebElement discoverEquipmentsButton;

	public WebElement get_discoverEquipmentsButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, discoverEquipmentsButton, logger)) {
			element = discoverEquipmentsButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_btnExportToExcel_input")
	private WebElement exportDiscoveredPointsButton;

	public WebElement get_exportDiscoveredPointsButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, exportDiscoveredPointsButton, logger)) {
			element = exportDiscoveredPointsButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_btnImportuserConfiguration_input")
	private WebElement importDiscoveredPointsButton;

	public WebElement get_importDiscoveredPointsButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, importDiscoveredPointsButton, logger)) {
			element = importDiscoveredPointsButton;
		}
		return element;
	}

	@FindBy(css = "input[value=Browse]")
	private WebElement browseExcelButton;

	public WebElement get_browseExcelButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, browseExcelButton, logger)) {
			element = browseExcelButton;
		}
		return element;
	}

	@FindBy(id = "ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_RadWindowFileUpload_C_RadBtnSubmit_input")
	private WebElement submitUpdatedPointsButton;

	public WebElement get_submitUpdatedPointsButton() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, submitUpdatedPointsButton, logger)) {
			element = submitUpdatedPointsButton;
		}
		return element;
	}

	@FindBy(id = "ContentPlaceHolder1_ContentPlaceHolder2_lblMessage")
	private WebElement saveUpdateErrorInfoMsg;

	public WebElement get_saveUpdateErrorInfoMsg() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, saveUpdateErrorInfoMsg, logger)) {
			element = saveUpdateErrorInfoMsg;
		}
		return element;
	}

	@FindBy(css = "#ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder2_rtvOds > ul > li > ul > li.rtLI.rtLast > ul")
	private WebElement pointDiscoveryTableGrid;

	public WebElement get_pointDiscoveryTableGrid() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, pointDiscoveryTableGrid, logger)) {
			element = pointDiscoveryTableGrid;
		}
		return element;
	}
}































