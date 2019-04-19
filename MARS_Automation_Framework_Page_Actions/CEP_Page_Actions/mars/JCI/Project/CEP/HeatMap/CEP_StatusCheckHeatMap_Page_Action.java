package mars.JCI.Project.CEP.HeatMap;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.Component.Functions.ExtentReportManager;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Factory;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;

public class CEP_StatusCheckHeatMap_Page_Action extends BaseClass {
	@SuppressWarnings("static-access")
	public CEP_StatusCheckHeatMap_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void validateDefaultValue() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		//Thread.sleep(5000);
		WebElement element = objHealthCheck.getChillerStatusDropDown();
		if (element != null) {
			Select select = new Select(element);
			String defaultValue = select.getFirstSelectedOption().getText();
			if (defaultValue.equalsIgnoreCase("Status Check")) {
				logger.log(LogStatus.PASS, "Default Value is Status Check.");
			} else {
				logger.log(LogStatus.PASS, "Default Value is Status Check.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Status Check drop down box is not present.");
		}
	}

	public void validateColorBifurcation() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		WebElement redColor = objStatusCheck.getStatusCheckRed();
		WebElement orangeColor = objStatusCheck.getStatusCheckOrange();
		WebElement yellowColor = objStatusCheck.getStatusCheckYellow();
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		if ((greenColor != null) || (redColor != null) || (orangeColor != null) || (yellowColor != null)
				|| (greyColor != null)) {
			logger.log(LogStatus.PASS, "Drop down field functionality is as expected.");
		} else {
			logger.log(LogStatus.FAIL, "Drop down field functionality is not as expected.");
		}
	}

	public void validateBifurcationFunction() throws Exception {
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<WebElement> chillerCount = objStatusCheck.getChillerCount();
		List<Integer> chillerCountDB=new ArrayList<Integer>();
		List<Integer> chillerCountUI=new ArrayList<Integer>();
		for(int i=0;i<chillerCount.size();i++){
			chillerCountUI.add(Integer.parseInt(chillerCount.get(i).getText()));
		}
//		int greenCountUI = Integer.parseInt(chillerCountUI.get(0).getText());
//		int yellowCountUI = Integer.parseInt(chillerCountUI.get(1).getText());
//		int orangeCountUI = Integer.parseInt(chillerCountUI.get(2).getText());
//		int greyCountUI = Integer.parseInt(chillerCountUI.get(3).getText());
//		int redCountUI = Integer.parseInt(chillerCountUI.get(4).getText());
		int greenCountDB = CEP_HeatMap_DataBase_Action.statusCheckTotalGreenCount();
		int yellowCountDB = CEP_HeatMap_DataBase_Action.statusCheckTotalYellowCount();
		int orangeCountDB = CEP_HeatMap_DataBase_Action.statusCheckTotalOrangeCount();
		int greyCountDB = CEP_HeatMap_DataBase_Action.statusCheckTotalGreyCount();
		int redCountDB = CEP_HeatMap_DataBase_Action.statusCheckTotalRedCount();
		chillerCountDB.add(greenCountDB);
		chillerCountDB.add(yellowCountDB);
		chillerCountDB.add(orangeCountDB);
		chillerCountDB.add(greyCountDB);
		chillerCountDB.add(redCountDB);
		if(chillerCountDB.containsAll(chillerCountUI)) {
			logger.log(LogStatus.PASS, "Bifurcation is as expected and based on Chiller Count.");
			logger.log(LogStatus.PASS, "Count of chillers matching for all color widget.");
			logger.log(LogStatus.INFO, "Count of Chiller in Green Color Widget in UI:" + greenCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Green Color Widget in DB:" + greenCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Yellow Color Widget in UI:" + yellowCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Yellow Color Widget in DB:" + yellowCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Orange Color Widget in UI:" + orangeCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Orange Color Widget in DB:" + orangeCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Grey Color Widget in UI:" + greyCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Grey Color Widget in DB:" + greyCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Red Color Widget in UI:" + redCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Red Color Widget in DB:" + redCountDB);
		} else {
			logger.log(LogStatus.FAIL, "Bifurcation is not as expected.");
			logger.log(LogStatus.FAIL, "Count of chillers not matching with DB.");
			logger.log(LogStatus.INFO, "Please refer snapshot for count in UI.");
			logger.log(LogStatus.INFO, "Count of Chiller in Green Color Widget in DB:" + greenCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Yellow Color Widget in DB:" + yellowCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Orange Color Widget in DB:" + orangeCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Grey Color Widget in DB:" + greyCountDB);
			logger.log(LogStatus.INFO, "Count of Chiller in Red Color Widget in DB:" + redCountDB);
			getFinalReport(driver, logger, "testCountComparisonColorWidget", false);
		}

	}

	public void validateColorsForJCI() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		WebElement redColor = objStatusCheck.getStatusCheckRed();
		WebElement orangeColor = objStatusCheck.getStatusCheckOrange();
		WebElement yellowColor = objStatusCheck.getStatusCheckYellow();
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		if ((greenColor != null) || (redColor != null) || (orangeColor != null) || (yellowColor != null)
				|| (greyColor != null)) {
			logger.log(LogStatus.PASS, "Heat Map Bifurcation is based on 5 colors.");
		} else {
			logger.log(LogStatus.FAIL, "Heat Map Bifurcation is not as expected.");
		}

	}
	
	public void validateDashboardChangeAfterColorClick() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheck_Page_Action objAction = new CEP_StatusCheck_Page_Action(driver,logger);
		driver.navigate().refresh();
		Thread.sleep(10000);
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		try {
			if (greenColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(greenColor).click().build().perform();
				objAction.waitForSpinnerToBeGone();
				//Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Details updated after clicking on Green Color Widget and are as expected.");
				getFinalReport(driver, logger, "testSmokeGreenColor", true);
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Green Color Widget not present in UI.");
		}
		WebElement yellowColor = objStatusCheck.getStatusCheckYellow();
		try {
			if (yellowColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(yellowColor).click().build().perform();
				objAction.waitForSpinnerToBeGone();
				//Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Details updated after clicking on Yellow Color Widget and are as expected.");
				getFinalReport(driver, logger, "testSmokeYellowColor", true);
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Yellow Color Widget not present in UI.");
		}
		WebElement orangeColor = objStatusCheck.getStatusCheckOrange();
		try {
			if (orangeColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(orangeColor).click().build().perform();
				objAction.waitForSpinnerToBeGone();
				//Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Details updated after clicking on Orange Color Widget and are as expected.");
				getFinalReport(driver, logger, "testSmokeOrangeColor", true);
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Orange Color Widget not present in UI.");
		}
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		try {
			if (greyColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(greyColor).click().build().perform();
				objAction.waitForSpinnerToBeGone();
				//Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Details updated after clicking on Grey Color Widget and are as expected.");
				getFinalReport(driver, logger, "testSmokeGreyColor", true);
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Grey Color Widget not present in UI.");
		}
	}

	public void validateRedColorWidgetDetails() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForRedChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		List<String> chillerName = new ArrayList<String>();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
			projectName.add(rs.getString("ProjectName"));
			chillerName.add(rs.getString("AssetName"));
		}
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			objHealthCheck.getSearchTextBox().sendKeys(customer.getText());
			objHealthCheck.getCustomerInSearchResult(customer.getText()).click();
		}
		WebElement project = objStatusCheck.getProjectInSearchResult(projectName.get(0));
		WebElement chiller = objStatusCheck.getAssetInSearchResult(chillerName.get(0));
		if ((customer.isDisplayed()) && (project.isDisplayed()) && (chiller.isDisplayed())) {
			logger.log(LogStatus.PASS,
					"Status info in CustomerListByStatus widget is as expected for Default Color Widget.");
		} else {
			logger.log(LogStatus.FAIL,
					"Status info in CustomerListByStatus widget is not as expected for Default Color Widget.");
			getFinalReport(driver, logger, "testRedColorWidget", false);
		}
		List<String> chillerList = CEP_HeatMap_DataBase_Action.getChillerList(customerName.get(0));
		for (int iCount = 0; iCount < chillerList.size(); iCount++) {
			List<WebElement> assetNameInChillerInformation = objStatusCheck
					.getAssetListInChillerInformation(chillerList.get(iCount));
			if (assetNameInChillerInformation.size() > 0) {
				logger.log(LogStatus.PASS,
						"Status info in ChillerInformation widget is as expected for Default Color Widget.");
				List<WebElement> assetNameInStatusHealthCheck = objStatusCheck
						.getAssetListInStatusHealthCheck(chillerList.get(iCount));
				if (assetNameInStatusHealthCheck.size() > 0) {
					logger.log(LogStatus.PASS,
							"Status info in StatusHealthCheck widget is as expected for Default Color Widget.");
					getFinalReport(driver, logger, "testRedColorWidget", true);
					break;
				} else if (assetNameInStatusHealthCheck.size() == 0) {
					assetNameInStatusHealthCheck = objStatusCheck
							.getAssetListInStatusHealthCheck(chillerList.get(iCount + 1));
				} else {
					logger.log(LogStatus.FAIL,
							"Status info in StatusHealthCheck widget is not as expected for Default Color Widget.");
					getFinalReport(driver, logger, "testRedColorWidget", false);
				}
				break;
			} else if (assetNameInChillerInformation.size() == 0) {
				assetNameInChillerInformation = objStatusCheck
						.getAssetListInChillerInformation(chillerList.get(iCount + 1));
			} else {
				logger.log(LogStatus.FAIL,
						"Status info in ChillerInformation widget is not as expected for Default Color Widget.");
				getFinalReport(driver, logger, "testRedColorWidget", false);
			}
			assetNameInChillerInformation.clear();
		}
	}

	public void validateGreenColorWidgetDetails() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		driver.navigate().refresh();
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		try {
			if (greenColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(greenColor).click().build().perform();
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Green Color Widget not present in UI.");
		}
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForGreenChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		List<String> chillerName = new ArrayList<String>();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
			projectName.add(rs.getString("ProjectName"));
			chillerName.add(rs.getString("AssetName"));
		}
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			objHealthCheck.getSearchTextBox().sendKeys(customer.getText());
			objHealthCheck.getCustomerInSearchResult(customer.getText()).click();
		}
		WebElement project = objStatusCheck.getProjectInSearchResult(projectName.get(0));
		WebElement chiller = objStatusCheck.getAssetInSearchResult(chillerName.get(0));
		if ((customer.isDisplayed()) && (project.isDisplayed()) && (chiller.isDisplayed())) {
			logger.log(LogStatus.PASS,
					"Status info in CustomerListByStatus widget is as expected for Green Color Widget.");
		} else {
			logger.log(LogStatus.FAIL,
					"Status info in CustomerListByStatus widget is not as expected for Green Color Widget.");
			getFinalReport(driver, logger, "testGreenColorWidget", false);
		}
		List<String> chillerList = CEP_HeatMap_DataBase_Action.getChillerList(customerName.get(0));
		for (int iCount = 0; iCount < chillerList.size(); iCount++) {
			List<WebElement> assetNameInChillerInformation = objStatusCheck
					.getAssetListInChillerInformation(chillerList.get(iCount));
			if (assetNameInChillerInformation.size() > 0) {
				logger.log(LogStatus.PASS,
						"Status info in ChillerInformation widget is as expected for Green Color Widget.");
				List<WebElement> assetNameInStatusHealthCheck = objStatusCheck
						.getAssetListInStatusHealthCheck(chillerList.get(iCount));
				if (assetNameInStatusHealthCheck.size() > 0) {
					logger.log(LogStatus.PASS,
							"Status info in StatusHealthCheck widget is as expected for Green Color Widget.");
					getFinalReport(driver, logger, "testGreenColorWidget", true);
					break;
				} else if (assetNameInStatusHealthCheck.size() == 0) {
					assetNameInStatusHealthCheck = objStatusCheck
							.getAssetListInStatusHealthCheck(chillerList.get(iCount + 1));
				} else {
					logger.log(LogStatus.FAIL,
							"Status info in StatusHealthCheck widget is not as expected for Green Color Widget.");
					getFinalReport(driver, logger, "testGreenColorWidget", false);
				}

				break;
			} else if (assetNameInChillerInformation.size() == 0) {
				assetNameInChillerInformation = objStatusCheck
						.getAssetListInChillerInformation(chillerList.get(iCount + 1));
			} else {
				logger.log(LogStatus.FAIL,
						"Status info in ChillerInformation widget is not as expected for Green Color Widget.");
				getFinalReport(driver, logger, "testGreenColorWidget", false);
			}
		}
	}

	public void validateYellowColorWidgetDetails() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		driver.navigate().refresh();
		WebElement yellowColor = objStatusCheck.getStatusCheckYellow();
		try {
			if (yellowColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(yellowColor).click().build().perform();
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Yellow Color Widget not present in UI.");
		}
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForYellowChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		List<String> chillerName = new ArrayList<String>();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
			projectName.add(rs.getString("ProjectName"));
			chillerName.add(rs.getString("AssetName"));
		}
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			objHealthCheck.getSearchTextBox().sendKeys(customer.getText());
			objHealthCheck.getCustomerInSearchResult(customer.getText()).click();
		}
		WebElement project = objStatusCheck.getProjectInSearchResult(projectName.get(0));
		WebElement chiller = objStatusCheck.getAssetInSearchResult(chillerName.get(0));
		if ((customer.isDisplayed()) && (project.isDisplayed()) && (chiller.isDisplayed())) {
			logger.log(LogStatus.PASS,
					"Status info in CustomerListByStatus widget is as expected for Yellow Color Widget.");
		} else {
			logger.log(LogStatus.FAIL,
					"Status info in CustomerListByStatus widget is not as expected for Yellow Color Widget.");
			getFinalReport(driver, logger, "testYellowColorWidget", false);
		}
		List<String> chillerList = CEP_HeatMap_DataBase_Action.getChillerList(customerName.get(0));
		for (int iCount = 0; iCount < chillerList.size(); iCount++) {
			List<WebElement> assetNameInChillerInformation = objStatusCheck
					.getAssetListInChillerInformation(chillerList.get(iCount));
			if (assetNameInChillerInformation.size() > 0) {
				logger.log(LogStatus.PASS,
						"Status info in ChillerInformation widget is as expected for Yellow Color Widget.");
				List<WebElement> assetNameInStatusHealthCheck = objStatusCheck
						.getAssetListInStatusHealthCheck(chillerList.get(iCount));
				if (assetNameInStatusHealthCheck.size() > 0) {
					logger.log(LogStatus.PASS,
							"Status info in StatusHealthCheck widget is as expected for Yellow Color Widget.");
					getFinalReport(driver, logger, "testYellowColorWidget", true);
					break;
				} else if (assetNameInStatusHealthCheck.size() == 0) {
					assetNameInStatusHealthCheck = objStatusCheck
							.getAssetListInStatusHealthCheck(chillerList.get(iCount + 1));
				} else {
					logger.log(LogStatus.FAIL,
							"Status info in StatusHealthCheck widget is not as expected for Yellow Color Widget.");
					getFinalReport(driver, logger, "testYellowColorWidget", false);
				}
				break;
			} else if (assetNameInChillerInformation.size() == 0) {
				assetNameInChillerInformation = objStatusCheck
						.getAssetListInChillerInformation(chillerList.get(iCount + 1));
			} else {
				logger.log(LogStatus.FAIL,
						"Status info in ChillerInformation widget is not as expected for Yellow Color Widget.");
				getFinalReport(driver, logger, "testYellowColorWidget", false);
			}
		}
	}

	public void validateOrangeColorWidgetDetails() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		driver.navigate().refresh();
		WebElement orangeColor = objStatusCheck.getStatusCheckOrange();
		try {
			if (orangeColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(orangeColor).click().build().perform();
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Orange Color Widget not present in UI.");
		}
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForOrangeChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> projectName = new ArrayList<String>();
		List<String> chillerName = new ArrayList<String>();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
			projectName.add(rs.getString("ProjectName"));
			chillerName.add(rs.getString("AssetName"));
		}
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			objHealthCheck.getSearchTextBox().sendKeys(customer.getText());
			objHealthCheck.getCustomerInSearchResult(customer.getText()).click();
		}
		WebElement project = objStatusCheck.getProjectInSearchResult(projectName.get(0));
		WebElement chiller = objStatusCheck.getAssetInSearchResult(chillerName.get(0));
		if ((customer.isDisplayed()) && (project.isDisplayed()) && (chiller.isDisplayed())) {
			logger.log(LogStatus.PASS,
					"Status info in CustomerListByStatus widget is as expected for Orange Color Widget.");
		} else {
			logger.log(LogStatus.FAIL,
					"Status info in CustomerListByStatus widget is not as expected for Orange Color Widget.");
			getFinalReport(driver, logger, "testOrangeColorWidget", false);
		}
		List<String> chillerList = CEP_HeatMap_DataBase_Action.getChillerList(customerName.get(0));
		for (int iCount = 0; iCount < chillerList.size(); iCount++) {
			List<WebElement> assetNameInChillerInformation = objStatusCheck
					.getAssetListInChillerInformation(chillerList.get(iCount));
			if (assetNameInChillerInformation.size() > 0) {
				logger.log(LogStatus.PASS,
						"Status info in ChillerInformation widget is as expected for Orange Color Widget.");
				List<WebElement> assetNameInStatusHealthCheck = objStatusCheck
						.getAssetListInStatusHealthCheck(chillerList.get(iCount));
				if (assetNameInStatusHealthCheck.size() > 0) {
					logger.log(LogStatus.PASS,
							"Status info in StatusHealthCheck widget is as expected for Orange Color Widget.");
					getFinalReport(driver, logger, "testOrangeColorWidget", true);
					break;
				} else if (assetNameInStatusHealthCheck.size() == 0) {
					assetNameInStatusHealthCheck = objStatusCheck
							.getAssetListInStatusHealthCheck(chillerList.get(iCount + 1));
				} else {
					logger.log(LogStatus.FAIL,
							"Status info in StatusHealthCheck widget is not as expected for Orange Color Widget.");
					getFinalReport(driver, logger, "testOrangeColorWidget", false);
				}
				break;
			} else if (assetNameInChillerInformation.size() == 0) {
				assetNameInChillerInformation = objStatusCheck
						.getAssetListInChillerInformation(chillerList.get(iCount + 1));
			} else {
				logger.log(LogStatus.FAIL,
						"Status info in ChillerInformation widget is not as expected for Orange Color Widget.");
				getFinalReport(driver, logger, "testOrangeColorWidget", false);
			}
		}
	}

	public void validateGreyColorWidgetDetails() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		driver.navigate().refresh();
		logger.log(LogStatus.PASS, "Status changed to default after refresing the page.");
		getFinalReport(driver, logger, "testPageRefresh", true);
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		try {
			if (greyColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(greyColor).click().build().perform();
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Grey Color Widget not present in UI.");
		}
		if (objStatusCheck.getCustomerGrey() != null) {
			logger.log(LogStatus.PASS,
					"Status info in CustomerListByStatus widget is as expected for Grey Color Widget.");
			logger.log(LogStatus.PASS,
					"Status info in ChillerInformation widget is as expected for Grey Color Widget.");
			logger.log(LogStatus.PASS, "Status info in StatusHealth widget is as expected for Grey Color Widget.");
			getFinalReport(driver, logger, "testGreyColorWidget", true);
		} else {
			logger.log(LogStatus.FAIL, "Status info in widgets is not as expected for Grey Color.");
			getFinalReport(driver, logger, "testGreyColorWidget", false);
		}
	}

	public void validateColorWidgetGeography() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> geographies = CEP_LeftPanel_DataBase_Action.geographyListDB();
		for (int iCount = 0; iCount < geographies.size(); iCount++) {
			int countGreenDB = CEP_HeatMap_DataBase_Action.greenCountForGeographyStatusCheck(geographies.get(iCount));
			int countYellowDB = CEP_HeatMap_DataBase_Action.yellowCountForGeographyStatusCheck(geographies.get(iCount));
			int countOrangeDB = CEP_HeatMap_DataBase_Action.orangeCountForGeographyStatusCheck(geographies.get(iCount));
			int countGreyDB = CEP_HeatMap_DataBase_Action.greyCountForGeographyStatusCheck(geographies.get(iCount));
			int countRedDB = CEP_HeatMap_DataBase_Action.redCountForGeographyStatusCheck(geographies.get(iCount));
			String customer = CEP_HeatMap_DataBase_Action.getFirstCustomerName("GeographyName",
					geographies.get(iCount));
			WebElement search = objLeftPanel.getSearchBox();
			search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(geographies.get(iCount), "1");
			// WebElement
			// elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(4000);
				List<WebElement> colorsUI = objStatusCheck.getChillerCount();
				ArrayList<Integer> colorsListUI = new ArrayList<Integer>();
				for (int i = 0; i < 5; i++) {
					try {
						colorsListUI.add(Integer.parseInt(colorsUI.get(i).getText()));
					} catch (Exception e) {
						colorsListUI.add(0);
					}
				}
				Collections.sort(colorsListUI);
				ArrayList<Integer> colorsListDB = new ArrayList<Integer>();
				colorsListDB.add(countGreenDB);
				colorsListDB.add(countYellowDB);
				colorsListDB.add(countOrangeDB);
				colorsListDB.add(countGreyDB);
				colorsListDB.add(countRedDB);
				Collections.sort(colorsListDB);
				if (colorsUI.size() > 0) {
					if (colorsListUI.equals(colorsListDB)) {
						logger.log(LogStatus.PASS,
								"Color widget changed after clicking on '" + geographies.get(iCount) + "'");
						logger.log(LogStatus.PASS, "Count of Chillers in color widget matching with DB for '"
								+ geographies.get(iCount) + "'.");
						logger.log(LogStatus.INFO, "Count of chillers in UI:");
						for (int i = 0; i < colorsListUI.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListUI.get(i)));
						}
						logger.log(LogStatus.INFO, "Count of chillers in DB:");
						for (int i = 0; i < colorsListDB.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListDB.get(i)));
						}
						getFinalReport(driver, logger, "test" + geographies.get(iCount) + "ColorWidget", true);
					} else {
						logger.log(LogStatus.FAIL, "Count of Chillers for " + geographies.get(iCount)
								+ " color widget not matching with DB.");
						logger.log(LogStatus.INFO, "Count of chillers in UI:");
						for (int i = 0; i < colorsListUI.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListUI.get(i)));
						}
						logger.log(LogStatus.INFO, "Count of chillers in DB:");
						for (int i = 0; i < colorsListDB.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListDB.get(i)));
						}
						getFinalReport(driver, logger, "test" + geographies.get(iCount) + "ColorWidget", false);
					}
				} else {
					logger.log(LogStatus.FAIL, "Color widget not present for '" + geographies.get(iCount) + "'");
				}

			} else {
				logger.log(LogStatus.FAIL, "Geography" + geographies.get(iCount) + "not present.");
			}
			search.clear();
		}

	}

	public void validateColorWidgetCountry() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> countries = CEP_LeftPanel_DataBase_Action.countryListDB();
		for (int iCount = 0; iCount < countries.size(); iCount++) {
			int countGreenDB = CEP_HeatMap_DataBase_Action.greenCountForCountryStatusCheck(countries.get(iCount));
			int countYellowDB = CEP_HeatMap_DataBase_Action.yellowCountForCountryStatusCheck(countries.get(iCount));
			int countOrangeDB = CEP_HeatMap_DataBase_Action.orangeCountForCountryStatusCheck(countries.get(iCount));
			int countGreyDB = CEP_HeatMap_DataBase_Action.greyCountForCountryStatusCheck(countries.get(iCount));
			int countRedDB = CEP_HeatMap_DataBase_Action.redCountForCountryStatusCheck(countries.get(iCount));
			String customer = CEP_HeatMap_DataBase_Action.getFirstCustomerName("CountryName", countries.get(iCount));
			WebElement search = objLeftPanel.getSearchBox();
			search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(countries.get(iCount), "1");
			// WebElement
			// elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(4000);
				List<WebElement> colorsUI = objStatusCheck.getChillerCount();
				ArrayList<Integer> colorsListUI = new ArrayList<Integer>();
				for (int i = 0; i < 5; i++) {
					try {
						colorsListUI.add(Integer.parseInt(colorsUI.get(i).getText()));
					} catch (Exception e) {
						colorsListUI.add(0);
					}
				}
				Collections.sort(colorsListUI);
				ArrayList<Integer> colorsListDB = new ArrayList<Integer>();
				colorsListDB.add(countGreenDB);
				colorsListDB.add(countYellowDB);
				colorsListDB.add(countOrangeDB);
				colorsListDB.add(countGreyDB);
				colorsListDB.add(countRedDB);
				Collections.sort(colorsListDB);
				if (colorsUI.size() > 0) {
					if (colorsListUI.equals(colorsListDB)) {
						logger.log(LogStatus.PASS,
								"Color widget changed after clicking on '" + countries.get(iCount) + "'");
						logger.log(LogStatus.PASS, "Count of Chillers in color widget matching with DB for '"
								+ countries.get(iCount) + "'.");
						logger.log(LogStatus.INFO, "Count of chillers in UI:");
						for (int i = 0; i < colorsListUI.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListUI.get(i)));
						}
						logger.log(LogStatus.INFO, "Count of chillers in DB:");
						for (int i = 0; i < colorsListDB.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListDB.get(i)));
						}
						getFinalReport(driver, logger, "test" + countries.get(iCount) + "ColorWidget", true);
					} else {
						logger.log(LogStatus.FAIL, "Count of Chillers for " + countries.get(iCount)
								+ " color widget not matching with DB.");
						logger.log(LogStatus.INFO, "Count of chillers in UI:");
						for (int i = 0; i < colorsListUI.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListUI.get(i)));
						}
						logger.log(LogStatus.INFO, "Count of chillers in DB:");
						for (int i = 0; i < colorsListDB.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListDB.get(i)));
						}
						getFinalReport(driver, logger, "test" + countries.get(iCount) + "ColorWidget", false);
					}
				} else {
					logger.log(LogStatus.FAIL, "Color widget not present for '" + countries.get(iCount) + "'");
				}

			} else {
				logger.log(LogStatus.FAIL, "Country" + countries.get(iCount) + "not present.");
			}
			search.clear();
		}

	}

	public void validateColorWidgetBranch() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		List<String> branches = CEP_LeftPanel_DataBase_Action.branchListDB();
		for (int iCount = 0; iCount < branches.size(); iCount++) {
			int countGreenDB = CEP_HeatMap_DataBase_Action.greenCountForBranchStatusCheck(branches.get(iCount));
			int countYellowDB = CEP_HeatMap_DataBase_Action.yellowCountForBranchStatusCheck(branches.get(iCount));
			int countOrangeDB = CEP_HeatMap_DataBase_Action.orangeCountForBranchStatusCheck(branches.get(iCount));
			int countGreyDB = CEP_HeatMap_DataBase_Action.greyCountForBranchStatusCheck(branches.get(iCount));
			int countRedDB = CEP_HeatMap_DataBase_Action.redCountForBranchStatusCheck(branches.get(iCount));
			String customer = CEP_HeatMap_DataBase_Action.getFirstCustomerName("BranchName", branches.get(iCount));
			WebElement search = objLeftPanel.getSearchBox();
			search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(4000);
			WebElement element = objLeftPanel.getLeftPanelElement(branches.get(iCount), "1");
			// WebElement
			// elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(8000);
				List<WebElement> colorsUI = objStatusCheck.getChillerCount();
				ArrayList<Integer> colorsListUI = new ArrayList<Integer>();
				for (int i = 0; i < 5; i++) {
					try {
						colorsListUI.add(Integer.parseInt(colorsUI.get(i).getText()));
					} catch (Exception e) {
						colorsListUI.add(0);
					}
				}
				Collections.sort(colorsListUI);
				ArrayList<Integer> colorsListDB = new ArrayList<Integer>();
				colorsListDB.add(countGreenDB);
				colorsListDB.add(countYellowDB);
				colorsListDB.add(countOrangeDB);
				colorsListDB.add(countGreyDB);
				colorsListDB.add(countRedDB);
				Collections.sort(colorsListDB);
				if (colorsUI.size() > 0) {
					if (colorsListUI.equals(colorsListDB)) {
						logger.log(LogStatus.PASS,
								"Color widget changed after clicking on '" + branches.get(iCount) + "'");
						logger.log(LogStatus.PASS, "Count of Chillers in color widget matching with DB for '"
								+ branches.get(iCount) + "'.");
						logger.log(LogStatus.INFO, "Count of chillers in UI:");
						for (int i = 0; i < colorsListUI.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListUI.get(i)));
						}
						logger.log(LogStatus.INFO, "Count of chillers in DB:");
						for (int i = 0; i < colorsListDB.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListDB.get(i)));
						}
						getFinalReport(driver, logger, "test" + branches.get(iCount) + "ColorWidget", true);
					} else {
						logger.log(LogStatus.FAIL, "Count of Chillers for " + branches.get(iCount)
								+ " color widget not matching with DB.");
						logger.log(LogStatus.INFO, "Count of chillers in UI:");
						for (int i = 0; i < colorsListUI.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListUI.get(i)));
						}
						logger.log(LogStatus.INFO, "Count of chillers in DB:");
						for (int i = 0; i < colorsListDB.size(); i++) {
							logger.log(LogStatus.INFO, String.valueOf(colorsListDB.get(i)));
						}
						getFinalReport(driver, logger, "test" + branches.get(iCount) + "ColorWidget", false);
					}
				} else {
					logger.log(LogStatus.FAIL, "Color widget not present for '" + branches.get(iCount) + "'");
				}

			} else {
				logger.log(LogStatus.FAIL, "Branch" + branches.get(iCount) + "not present.");
			}
			search.clear();
		}

	}
}
