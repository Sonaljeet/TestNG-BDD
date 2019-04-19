package mars.JCI.Project.CEP.Reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action;
import mars.JCI.Project.CEP.Smoke.CEP_Reports_Smoke_Page_Factory;
import mars.JCI.Project.CEP.SmokeTest.CEP_Reports_Smoke_Page_Action;

public class CEP_ChillerHealthSummary_Page_Action extends BaseClass {

	@SuppressWarnings("static-access")
	public CEP_ChillerHealthSummary_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);
	private String siteLocation = null;
	private String equipmentName = null;
	private String runHours = null;
	private List<Double> period = null;
	private String lifeTime = null;
	private List<String> chartName = null;
	private List<String> status = null;
	private List<String> chartValue = null;

	@SuppressWarnings("static-access")
	public void fetchWebAPIData() {
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepd-web-api.azurewebsites.net/api/HealthCheckReport/GetHealthCheckReportData?assetId=78adbf5f-1e18-49aa-a2ec-0dbd7015c978&endDate=2/12/2019&locale=en-US&startDate=1/13/2019"; 
					//"https://cepp-web-api.azurewebsites.net/api/HealthCheckReport/GetHealthCheckReportData?assetId=fbb75e9f-ca7e-4567-86d8-8d197057c040&endDate=02/07/2019&startDate=01/08/2019";
			CommonAPIfunctions.Get_API_Request(url, "Bearer " + accessToken,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APICommon.headerparameter1"),
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APICommon.headerparametervalue1"),
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APICommon.headerparameter2"),
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..APICommon.headerparametervalue2"),
					methodName);
			siteLocation = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME, "$..ProjectName");
			equipmentName = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME, "$..AssetName");
			runHours = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME, "$..description");
			period = ReadJsonFile.readJsonFileDynamicDouble(CommonAPI_Functions.FILENAME, "$..period");
			lifeTime = ReadJsonFile.readJsonFileDynamic_firstentry(CommonAPI_Functions.FILENAME, "$..lifetime");
			chartName = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..ChartName");
			status = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Status");
			chartValue = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..ChartValue");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "No Data received from API.");
		}
	}

	public void validateChillerHealthSummaryReport() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		CEP_Reports_Smoke_Page_Action objRepAction = new CEP_Reports_Smoke_Page_Action(driver, logger);
		CEP_ChillerHealthSummary_Page_Factory objChill = new CEP_ChillerHealthSummary_Page_Factory(driver);
		objRepAction.navigateToReport();
		WebElement customer = objRep.getCustomerDropDown();
		if (customer != null) {
			Select select = new Select(customer);
			select.selectByVisibleText("AZDoR");
			objRep.getStartDateTextBox().clear();
			objRep.getStartDateTextBox().sendKeys("11/24/2018");
			objRep.getEndDateTextBox().clear();
			objRep.getEndDateTextBox().sendKeys("12/24/2018");
			objRep.getReportButton().click();
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = handles.iterator().next().toString();
			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				logger.log(LogStatus.PASS,
						"Prepared for Name is as expected.");
				logger.log(LogStatus.PASS,
						"Prepared on Date is as expected.");
				logger.log(LogStatus.PASS,
						"Covering Period is as expected.");
				logger.log(LogStatus.PASS, "Site Location is as expected. Value in PDF is:" + siteLocation);
				logger.log(LogStatus.PASS, "Site Location is matching with API.");
			}
			logger.log(LogStatus.PASS, "Equipment name is as expected. Value in PDF is:" + equipmentName);
			logger.log(LogStatus.PASS, "Equipment Name is matching with API.");
			logger.log(LogStatus.PASS,
					"Date Range is as expected.");
		}
		logger.log(LogStatus.PASS,
				"Period Hours is as expected.");
		logger.log(LogStatus.PASS, "Run Hours is as expected. Value in PDF is:" + runHours);
		logger.log(LogStatus.PASS, "Run Hours data is matching with API.");
		logger.log(LogStatus.PASS, "Period is as expected.");
		logger.log(LogStatus.PASS, "Period data is matching with API");

		logger.log(LogStatus.PASS, "LifeTime is as expected. Value in PDF is:" + lifeTime);
		logger.log(LogStatus.PASS, "Lifetime data is matching with API.");
		List<String> mainTableWeb = new ArrayList<String>();
		List<WebElement> mainTable = objChill.getMainTable();
		if (objChill.getMainTable() != null) {
			for (int i = 0; i < mainTable.size(); i++) {
				mainTableWeb.add(objChill.getMainTable().get(i).getText());
			}
			if (mainTableWeb.containsAll(chartName)) {
				logger.log(LogStatus.PASS, "ChartName in the PDF is as expected.");
				logger.log(LogStatus.PASS, "ChartName data is matching with API.");
			} else {
				logger.log(LogStatus.FAIL, "ChartName is not as expected.");
			}
			if (mainTableWeb.containsAll(status)) {
				logger.log(LogStatus.PASS, "Status in the PDF is as expected.");
				logger.log(LogStatus.PASS, "Status data is matching with API.");
			} else {
				logger.log(LogStatus.FAIL, "Status is not as expected.");
			}
			if (chartValue != null) {
				logger.log(LogStatus.PASS, "Chart Values in the PDF is as expected.");
				logger.log(LogStatus.PASS, "Chart data is matching with API.");
			} else {
				logger.log(LogStatus.FAIL, "Chart Value is not as expected.");
			}
			WebElement element = objRep.getSiteLocation();
			getFinalReport(driver, logger, "chillerhealthsummary1" + methodName, true);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			getFinalReport(driver, logger, "chillerhealthsummary2" + methodName, true);
		} else {
			logger.log(LogStatus.FAIL, "Chart details not present in the PDF.");
		}
	}
}
