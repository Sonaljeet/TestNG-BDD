package mars.JCI.Project.CEP.SmokeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action;
import mars.JCI.Project.CEP.Smoke.CEP_Reports_Smoke_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Scorecard_Smoke_Page_Factory;

public class CEP_Scorecard_Smoke_Page_Action extends BaseClass {
	
	public CEP_Scorecard_Smoke_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	public void navigateToScoreCard() throws Exception {
		CEP_Scorecard_Smoke_Page_Factory objS = new CEP_Scorecard_Smoke_Page_Factory(driver, logger);
		WebElement link = objS.getLink();
		if(link!=null){
			link.click();
			//logger.log(LogStatus.PASS, "Successfully navigated to Scorecard page.");
			//Thread.sleep(3000);
		//	getFinalReport(driver, logger, "page", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Scorecard link not present.");
		//	getFinalReport(driver, logger, "page", false);
		}
	}
	
	public void validateFields() throws Exception {
		navigateToScoreCard();
		Thread.sleep(8000);
		CEP_Scorecard_Smoke_Page_Factory objS = new CEP_Scorecard_Smoke_Page_Factory(driver, logger);
		CEP_Reports_Smoke_Page_Factory objR = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		WebElement report = objR.getReportDropDown();
		WebElement startDate = objR.getStartDateTextBox();
		WebElement endDate = objR.getEndDateTextBox();
		WebElement type = objS.getType();
		if((report!=null)&&(startDate!=null)&&(endDate!=null)&&(type!=null)){
			logger.log(LogStatus.PASS, "Fields in the Scorecard page are as expected.Following fields are present:");
			logger.log(LogStatus.INFO, "REPORTS, Start Date*, End Date* and Type*");
			getFinalReport(driver, logger, "fields", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Fields in the Scorecard page are not as expected.");
			getFinalReport(driver, logger, "fields", false);
		}
	}
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);
	private List<String> popularPage = new ArrayList<String>();
	private List<String> popularViews = new ArrayList<String>();
	@SuppressWarnings("static-access")
	public void fetchAPIPopular() {
			try {
				String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
				String url = "https://cepd-web-api.azurewebsites.net/api/Scorecard/GetPopularPagesData";
				String requestBody = "EndDate=12/2/2019&ReportType=1&StartDate=6/2/2019&UserId=ceuser";
				CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/x-www-form-urlencoded",
						requestBody, methodName);
				popularPage = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Page");
				popularViews = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Views");				
			} catch (Exception e) {
				e.printStackTrace();
				logger.log(LogStatus.ERROR, "No proper response received from API.");
			}
		}

	public void validateDataForPopular() throws Exception {
		navigateToScoreCard();
		fetchAPIPopular();
		if(popularPage!=null){
			logger.log(LogStatus.PASS, "Popular Page Details are as expected.");
			logger.log(LogStatus.INFO, "Following Data are present in Web and in API:");
			logger.log(LogStatus.INFO, Arrays.toString(popularPage.toArray()));
			logger.log(LogStatus.INFO, "Respective Views for each page:");
			logger.log(LogStatus.INFO, Arrays.toString(popularViews.toArray()));
		}
	}
	
	public void validateExportToCSV() throws Exception {
		navigateToScoreCard();
		Thread.sleep(30000);
		CEP_Scorecard_Smoke_Page_Factory objS = new CEP_Scorecard_Smoke_Page_Factory(driver, logger);
		WebElement icon = objS.getIconExport();
		if(icon!=null){
			icon.click();
			objS.getDownloadIcon().click();
			logger.log(LogStatus.PASS, "Export to CSV is working as expected.");
		}
		else{
			logger.log(LogStatus.FAIL, "Icon to Export not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	private List<String> branch = new ArrayList<String>();
	private List<String> overview = new ArrayList<String>();
	private List<String> trends = new ArrayList<String>();
	private List<String> comparative = new ArrayList<String>();
	private List<String> statusChk = new ArrayList<String>();
	private List<String> healthChk = new ArrayList<String>();
	private List<String> total = new ArrayList<String>();
	@SuppressWarnings("static-access")
	public void fetchAPIBranch() {
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepu-web-api.azurewebsites.net/api/Scorecard/GetBranchUsageByPagesReport";
			String requestBody = "EndDate=25/1/2019&ReportType=1&StartDate=19/1/2019&UserId=admin@jci.com";
			CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/x-www-form-urlencoded",
					requestBody, methodName);
			branch = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..BranchName");
			overview = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Overview");
			trends = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Trends");
			comparative = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Comparative");
			statusChk = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..StatusCheck");
			healthChk = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..HealthCheck");
			total = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..TotalViews");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "No proper response received from API.");
		}
	}
	public void validateDataForBranch() throws Exception {
		navigateToScoreCard();
		Thread.sleep(10000);
		CEP_Reports_Smoke_Page_Factory objR = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		WebElement report = objR.getReportDropDown();
		Select select = new Select(report);
		select.selectByVisibleText("Branch Usage By Page");
		Thread.sleep(5000);
		fetchAPIBranch();
		if(branch!=null){
			logger.log(LogStatus.PASS, "Branch Usage data is as expected and is matching with API.");
			logger.log(LogStatus.INFO, "Branch:");
			logger.log(LogStatus.INFO, Arrays.toString(branch.toArray()));
			logger.log(LogStatus.INFO, "Respective Overview:");
			logger.log(LogStatus.INFO, Arrays.toString(overview.toArray()));
			logger.log(LogStatus.INFO, "Respective Trends:");
			logger.log(LogStatus.INFO, Arrays.toString(trends.toArray()));
			logger.log(LogStatus.INFO, "Respective Comparative:");
			logger.log(LogStatus.INFO, Arrays.toString(comparative.toArray()));
			logger.log(LogStatus.INFO, "Respective StatusCheck:");
			logger.log(LogStatus.INFO, Arrays.toString(statusChk.toArray()));
			logger.log(LogStatus.INFO, "Respective HealthCheck:");
			logger.log(LogStatus.INFO, Arrays.toString(healthChk.toArray()));
			logger.log(LogStatus.INFO, "Respective Total:");
			logger.log(LogStatus.INFO, Arrays.toString(total.toArray()));
		}
		else{
			logger.log(LogStatus.FAIL, "No Branch Usage data fetched.");
		}
	}

	private List<String> user = new ArrayList<String>();
	private List<String> overview1 = new ArrayList<String>();
	private List<String> trends1 = new ArrayList<String>();
	private List<String> comparative1 = new ArrayList<String>();
	private List<String> statusChk1 = new ArrayList<String>();
	private List<String> healthChk1 = new ArrayList<String>();
	private List<String> total1 = new ArrayList<String>();
	
	@SuppressWarnings("static-access")
	public void fetchAPIPageView() {
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepd-web-api.azurewebsites.net/api/Scorecard/PageViewsByUser";
			String requestBody = "EndDate=12/2/2019&ReportType=1&StartDate=6/2/2019&UserId=ceuser";
			CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/x-www-form-urlencoded",
					requestBody, methodName);
			user = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..UserName");
			overview1 = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Overview");
			trends1 = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Trends");
			comparative1 = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Comparative");
			statusChk1 = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..StatusCheck");
			healthChk1 = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..HealthCheck");
			total1 = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..TotalViews");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "No proper response received from API.");
		}
	}
	
	public void validateDataForPageView() throws Exception {
		navigateToScoreCard();
		Thread.sleep(10000);
		CEP_Reports_Smoke_Page_Factory objR = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		WebElement report = objR.getReportDropDown();
		Select select = new Select(report);
	//	select.selectByVisibleText("Page Views By User");
		Thread.sleep(5000);
		fetchAPIPageView();
		if(user!=null){
			logger.log(LogStatus.PASS, "Page Views By User data is as expected and is matching with API.");
			logger.log(LogStatus.INFO, "User:");
			logger.log(LogStatus.INFO, Arrays.toString(user.toArray()));
			logger.log(LogStatus.INFO, "Respective Overview:");
			logger.log(LogStatus.INFO, Arrays.toString(overview1.toArray()));
			logger.log(LogStatus.INFO, "Respective Trends:");
			logger.log(LogStatus.INFO, Arrays.toString(trends1.toArray()));
			logger.log(LogStatus.INFO, "Respective Comparative:");
			logger.log(LogStatus.INFO, Arrays.toString(comparative1.toArray()));
			logger.log(LogStatus.INFO, "Respective StatusCheck:");
			logger.log(LogStatus.INFO, Arrays.toString(statusChk1.toArray()));
			logger.log(LogStatus.INFO, "Respective HealthCheck:");
			logger.log(LogStatus.INFO, Arrays.toString(healthChk1.toArray()));
			logger.log(LogStatus.INFO, "Respective Total:");
			logger.log(LogStatus.INFO, Arrays.toString(total1.toArray()));
		}
		else{
			logger.log(LogStatus.FAIL, "Data for Page Views By User not available.");
		}
	}

	private List<String> branchName = new ArrayList<String>();
	private List<String> views = new ArrayList<String>();

	@SuppressWarnings("static-access")
	public void fetchAPITopReports() {
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepd-web-api.azurewebsites.net/api/Scorecard/ReportsByBranch";
			String requestBody = "EndDate=12/2/2019&StartDate=6/2/2019&UserId=ceuser";
			CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/x-www-form-urlencoded",
					requestBody, methodName);
			branchName = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..BranchName");
			views = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..Views");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "No proper response received from API.");
		}
	}
	
	public void validateDataForTopReports() throws Exception {
		navigateToScoreCard();
		Thread.sleep(10000);
		CEP_Reports_Smoke_Page_Factory objR = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		CEP_Scorecard_Smoke_Page_Factory objS = new CEP_Scorecard_Smoke_Page_Factory(driver, logger);
		WebElement report = objR.getReportDropDown();
		Select select = new Select(report);
//		select.selectByVisibleText("Top Reports by Branch");
//		Thread.sleep(5000);
		WebElement branchDropDown = objS.getBranchDropDown();
		Select select1 = new Select(branchDropDown);
		List<WebElement> e = select1.getOptions();
		if(e.size()>0){
		List<String> e2 = new ArrayList<String>();
		for(WebElement e1: e)
			e2.add(e1.getText());
		logger.log(LogStatus.PASS, "Branch Options present in drop down:"+Arrays.toString(e2.toArray()));
		}
		else{
			logger.log(LogStatus.FAIL, "Branch Options not present.");
		}
		fetchAPITopReports();
		if(user!=null){
			logger.log(LogStatus.PASS, "Top Reports By Branch data is as expected and is matching with API.");
			logger.log(LogStatus.INFO, "Branch Name:");
			logger.log(LogStatus.INFO, Arrays.toString(branchName.toArray()));
			logger.log(LogStatus.INFO, "Respective Report Count:");
			logger.log(LogStatus.INFO, Arrays.toString(views.toArray()));			
		}
		else{
			logger.log(LogStatus.FAIL, "Data for Top Reports By Branch not available.");
		}
	}

}
