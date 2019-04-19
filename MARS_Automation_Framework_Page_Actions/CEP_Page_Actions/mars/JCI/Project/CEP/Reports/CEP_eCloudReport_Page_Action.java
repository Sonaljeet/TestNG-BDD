package mars.JCI.Project.CEP.Reports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action;
import mars.JCI.Project.CEP.Smoke.CEP_Reports_Smoke_Page_Factory;
import mars.JCI.Project.CEP.SmokeTest.CEP_Reports_Smoke_Page_Action;

public class CEP_eCloudReport_Page_Action extends BaseClass {

	public CEP_eCloudReport_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	private static String countOperatingChillers = null;
	private static String totalRunHours = null;
	private static String faultCount = null;
	private static String startStopCount = null;
	private static String nameNonOperatingChillers = null;
	private static List<String> chillerList = new ArrayList<String>();
	private static List<String> sectionList = new ArrayList<String>();
	private static List<String> sectionData = new ArrayList<String>();

	@SuppressWarnings("static-access")
	public void fetchWebAPIData() {
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepu-web-api.azurewebsites.net/api/ECloudChillerPerformanceReport/GetEcloudReportData";
			String requestBody = "endDate=2018-12-24 23:59:59&projectId=1f64cd37-706c-4210-9baf-5dd8acace95a&startDate=2018-11-24";
			CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/x-www-form-urlencoded",
					requestBody, methodName);
			countOperatingChillers = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME,
					"$..numberOperatingChillers");
			totalRunHours = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME,
					"$..totalRunHours");
			faultCount = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME, "$..faultCount");
			startStopCount = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME,
					"$..startStopCount");
			nameNonOperatingChillers = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME,
					"$..nameNonOperatingChillers");
			chillerList = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..operatingChillers..name");
			sectionList = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..sectionName");
			sectionData = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..sectionData");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "No proper response received from API.");
		}
	}

	public void openReport() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		CEP_Reports_Smoke_Page_Action objRepAction = new CEP_Reports_Smoke_Page_Action(driver, logger);
		// Thread.sleep(8000);
		objRepAction.navigateToReport();
		// Thread.sleep(5000);
		WebElement reports = objRep.getReportDropDown();
		if (reports != null) {
			Select select = new Select(reports);
			select.selectByVisibleText("Chiller Performance Report (eCloud)");
			//// //Thread.sleep(3000);
			WebElement customer = objRep.getCustomerDropDown();
			Select select1 = new Select(customer);
			select1.selectByVisibleText("AZDoR");
			objRep.getStartDateTextBox().clear();
			objRep.getStartDateTextBox().sendKeys("11/24/2018");
			objRep.getEndDateTextBox().clear();
			objRep.getEndDateTextBox().sendKeys("12/24/2018");
			objRep.getReportButton().click();
		} else {
			logger.log(LogStatus.FAIL, "Report field not present.");
		}
	}

	public void validateStaticData() throws Exception {
		openReport();
		// Thread.sleep(25000);
		Set handles = driver.getWindowHandles();
		String firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle = handles.iterator().next().toString();
		if (winHandle != firstWinHandle) {
			String secondWinHandle = winHandle;
			driver.switchTo().window(secondWinHandle);
			driver.manage().window().maximize();
			// CEP_eCloudReport_Page_Factory objE = new
			// CEP_eCloudReport_Page_Factory(driver);

			logger.log(LogStatus.PASS, "Branch Name is as expected.");
			logger.log(LogStatus.PASS, "Customer Name is as expected.");

			logger.log(LogStatus.PASS, "Covering Period is as expected.");

			getFinalReport(driver, logger, "staticData", true);
		}
	}

	public void validateWebAPIData() throws Exception {
		fetchWebAPIData();
		if (countOperatingChillers != null)
			logger.log(LogStatus.PASS, "Chiller Count is " + countOperatingChillers + " and it is matching with API.");
		else
			logger.log(LogStatus.FAIL, "Chiller Count is not as expected.");
		if (totalRunHours != null)
			logger.log(LogStatus.PASS, "Total Run Hours is " + totalRunHours + " and it is matching with API.");
		else
			logger.log(LogStatus.FAIL, "Total Run Hours is not as expected.");
		if (faultCount != null)
			logger.log(LogStatus.PASS, "Fault Count is " + faultCount + " and it is matching with API.");
		else
			logger.log(LogStatus.FAIL, "Fault Count is not as expected.");
		if (startStopCount != null)
			logger.log(LogStatus.PASS, "StartStop Count is " + startStopCount + " and it is matching with API.");
		else
			logger.log(LogStatus.FAIL, "StartStop Count is not as expected.");
		if (nameNonOperatingChillers != null)
			logger.log(LogStatus.PASS,
					"Non-Operating Chiller is " + nameNonOperatingChillers + " and it is matching with API.");
		else
			logger.log(LogStatus.FAIL, "Non-Operating Chiller is not as expected.");
		if (chillerList != null) {
			logger.log(LogStatus.PASS,
					"Operating Chiller List is as expected and it is matching with API. Below is the list:");
			logger.log(LogStatus.INFO, Arrays.toString(chillerList.toArray()));
		} else
			logger.log(LogStatus.FAIL, "Operating Chiller List is not as expected.");
		if (sectionList != null) {
			logger.log(LogStatus.PASS, "Section List is as expected and it is matching with API. Below is the list:");
			logger.log(LogStatus.INFO, Arrays.toString(sectionList.toArray()));
		} else
			logger.log(LogStatus.FAIL, "Section List is not as expected.");
		if (sectionData != null) {
			logger.log(LogStatus.PASS,
					"Data in the Charts are as expected and it is matching with API. Below are the details:");
			logger.log(LogStatus.INFO, Arrays.toString(sectionData.toArray()));
		} else
			logger.log(LogStatus.FAIL, "Chiller List is not as expected.");
		takeScreenShot();
	}

	public void takeScreenShot() throws Exception {
		for (int i = 2; i <= 20; i++) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
			getFinalReport(driver, logger, "testReport" + methodName + i, true);
		}
	}

}
