package mars.JCI.Project.CEP.Reports;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.ListUtils;
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

public class CEP_SCCHealthSummary_Page_Action extends BaseClass {

	public CEP_SCCHealthSummary_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	private List<String> description = null;
	private List<String> lifeTime = null;
	private List<String> categoryName = null;
	private List<String> alertAlarmCount = null;
	private List<String> lstShcChartDetails = null;
	private List<String> lstHealthChartDetails =null;

	@SuppressWarnings("static-access")
	public void fetchWebAPIData() {
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepu-web-api.azurewebsites.net/api/ShcReport/GetShcChillerDetails";
			String requestBody = "AssetId=d0bff572-25b0-46e6-826a-01f984aa556e&CurrentWeekDate=2019-01-25T08:58:01-05:00&CustomerId=49ae1426-0275-499a-8e4d-29e28f5307c1&LastWeekDate=2019-01-18T08:58:01-05:00&PointCategory=Health Check,Evaporator,Condenser,Oil Sump,Compressor,Motor Detail,Operations,Onboard Diagnostics,System,Physical Readings&ProjectId=98ed2243-12b3-49d7-8917-6fbf5c3dee71&ShowCurrentWeekDate=2019-01-25 03:58:01&UserId=admin@jci.com";
			CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/x-www-form-urlencoded",
					requestBody, methodName);
			description = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..description");
			lifeTime = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..lifetime");
			categoryName = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..CategoryName");
			alertAlarmCount = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..lstAlertAlarmDetails");
			lstShcChartDetails = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..lstShcChartDetails");
			lstHealthChartDetails = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..lstHealthChartDetails");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "No proper response received from API.");
		}

	}
	
	public void validateSCCHealthSummaryData() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		CEP_Reports_Smoke_Page_Action objRepAction = new CEP_Reports_Smoke_Page_Action(driver, logger);
		CEP_SCCHealthSummary_Page_Factory objSCC = new CEP_SCCHealthSummary_Page_Factory(driver);
		//Thread.sleep(6000);
		objRepAction.navigateToReport();
		//Thread.sleep(5000);
		WebElement reports = objRep.getReportDropDown();
		if (reports != null) {
			Select select = new Select(reports);
			select.selectByVisibleText("SCC Chiller Health Report(Singapore)");
			//Thread.sleep(3000);
			WebElement customer = objRep.getCustomerDropDown();
			Select select1 = new Select(customer);
			select1.selectByVisibleText("LUCKY PLAZA");
			WebElement reportButton = objRep.getReportButton();
			reportButton.click();
			objRep.getECloudConfirmYesButton().click();
			objRep.getECloudConfirmYesButton().click();
			objRep.getECloudConfirmGenerateReportButton().click();
			//Thread.sleep(25000);
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = handles.iterator().next().toString();
			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				if((objSCC.getCustomer()!=null)&&(objSCC.getEquipmentName()!=null)&&(objSCC.getEquipmentSerialNum()!=null)&&(objSCC.getChillerModelNum()!=null)){
					logger.log(LogStatus.PASS, "Customer Name in the PDF is as expected. Value is:"+objSCC.getCustomer().getText());
					logger.log(LogStatus.PASS, "Equipment Name in the PDF is as expected. Value is:"+objSCC.getEquipmentName().getText());
					logger.log(LogStatus.PASS, "Equipment Serial # in the PDF is as expected. Value is:"+objSCC.getEquipmentSerialNum().getText());
					logger.log(LogStatus.PASS, "Chiller Model # in the PDF is as expected. Value is:"+objSCC.getChillerModelNum().getText());
					getFinalReport(driver, logger, methodName+"1", true);
				}
				else{
					logger.log(LogStatus.FAIL, "Data in the first page of PDF is not correct.");
					getFinalReport(driver, logger, methodName+"1", false);
				}
				List<WebElement> headers = objSCC.getAllHeaders();
				List<String> sHeaders = new ArrayList<String>();
				Actions action = new Actions(driver);
				action.moveToElement(headers.get(1)).click().build().perform();
				if(alertAlarmCount!=null){
					logger.log(LogStatus.PASS, "AlertAlarmCount data is as expected.");
					logger.log(LogStatus.INFO, "Below details are present in PDF and in API:");
					logger.log(LogStatus.INFO, Arrays.toString(alertAlarmCount.toArray()));
					getFinalReport(driver, logger, methodName+"2", true);
				}
				else{
					logger.log(LogStatus.FAIL, "AlertAlarmCount data is not as expected.");
					getFinalReport(driver, logger, methodName+"2", false);
				}
				action.moveToElement(headers.get(20)).click().build().perform();
				for(int i=0;i<headers.size();i++)
					sHeaders.add(headers.get(i).getText());
				if(sHeaders.containsAll(categoryName)){
					logger.log(LogStatus.PASS, "Categories data are as expected. Values are matching with API.");
					logger.log(LogStatus.INFO, "Following data present in PDF and API:"+Arrays.toString(sHeaders.toArray()));
					getFinalReport(driver, logger, methodName+"3", true);
				}
				else{
					logger.log(LogStatus.FAIL, "Categories data are as expected. Values are matching with API.");
					logger.log(LogStatus.INFO, "Following data present in PDF and API:"+Arrays.toString(sHeaders.toArray()));
					getFinalReport(driver, logger, methodName+"3", false);
				}
				action.moveToElement(headers.get(31)).click().build().perform();
				if((lstHealthChartDetails!=null)&&(lstShcChartDetails!=null)){
					logger.log(LogStatus.PASS, "Chart Details are as expected.");
					logger.log(LogStatus.INFO, "Below details are present in PDF and API:");
					logger.log(LogStatus.INFO, Arrays.toString(lstHealthChartDetails.toArray()));
					logger.log(LogStatus.INFO, Arrays.toString(lstShcChartDetails.toArray()));
					getFinalReport(driver, logger, methodName+"4", true);
				}
				else{
					logger.log(LogStatus.FAIL, "Chart Details is not as expected.");
					getFinalReport(driver, logger, methodName+"4", false);
				}
			}
		}else {
			logger.log(LogStatus.FAIL, "Report field not present.");
		}
	}
}
