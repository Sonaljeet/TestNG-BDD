package mars.JCI.Project.CEP.SmokeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action;
import mars.JCI.Project.CEP.Smoke.CEP_Repository_Smoke_Page_Factory;

public class CEP_Repository_Smoke_Page_Action extends BaseClass {

	public CEP_Repository_Smoke_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void navigateToRepository() throws Exception {
		CEP_Repository_Smoke_Page_Factory objR = new CEP_Repository_Smoke_Page_Factory(driver, logger);
		WebElement link = objR.getLink();
		if (link != null) {
			link.click();
			logger.log(LogStatus.PASS, "Successfully navigated to Repository page.");
			Thread.sleep(3000);
			getFinalReport(driver, logger, "page", true);
		} else {
			logger.log(LogStatus.FAIL, "Repository link not present.");
			getFinalReport(driver, logger, "page", false);
		}
	}

	public void validateFields() throws Exception {
		navigateToRepository();
		Thread.sleep(8000);
		CEP_Repository_Smoke_Page_Factory objR = new CEP_Repository_Smoke_Page_Factory(driver, logger);
		WebElement branch = objR.getBranch();
		WebElement year = objR.getYear();
		WebElement customer = objR.getCustomer();
		WebElement facility = objR.getFacility();
		WebElement month = objR.getMonth();
		WebElement report = objR.getReport();
		if ((report != null) && (month != null) && (facility != null) && (customer != null) && (year != null)
				&& (branch != null)) {
			logger.log(LogStatus.PASS, "Fields in the Repository page are as expected.Following fields are present:");
			logger.log(LogStatus.INFO, "Branch, Year*, Customer*, Facility*, Month* and Report*");
			getFinalReport(driver, logger, "fields", true);
		} else {
			logger.log(LogStatus.FAIL, "Fields in the Repository page are not as expected.");
			getFinalReport(driver, logger, "fields", false);
		}
	}

	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);
	private List<String> name = new ArrayList<String>();
	private List<String> blobPath = new ArrayList<String>();

	@SuppressWarnings("static-access")
	public void fetchAPIReposit() {
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepu-web-api.azurewebsites.net/api/Repository/GetRepositoryTreeData";
			String requestBody = "{\"branchIds\":[{\"branchId\":\"14cad993-3637-4bb7-b5b6-1b5c353b4e0a\"}],\"year\":\"2018\"}";
			CommonAPIfunctions.POST_API_Request(url, "Bearer " + accessToken, "application/json", requestBody,
					methodName);
			name = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..name");
			blobPath = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..blobPath");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "No proper response received from API.");
		}
	}
	
	public void validatePDF() throws Exception {
		navigateToRepository();
		Thread.sleep(8000);
		CEP_Repository_Smoke_Page_Factory objR = new CEP_Repository_Smoke_Page_Factory(driver, logger);
		WebElement branch = objR.getBranch();
		if (branch != null) {
			branch.click();
			Thread.sleep(5000);
		//	WebElement search = objR.getSearch();
			Thread.sleep(5000);
		//	search.sendKeys("Abu Dhabi Service");
		//	WebElement label = objR.getBrName();
		//	label.click();
			WebElement pdf = objR.getPDF();
			if(pdf!=null){
				Actions action = new Actions(driver);
				action.moveToElement(pdf).click().build().perform();
				logger.log(LogStatus.PASS, "PDF opened successfully.");
			}else{
				logger.log(LogStatus.FAIL, "PDF not present in the tree structure.");
				getFinalReport(driver, logger, "fields12", false);
			}
		}
		else {
			logger.log(LogStatus.FAIL, "Fields in the Repository page are not as expected.");
			getFinalReport(driver, logger, "fields21", false);
		}
	}

	public void validateTree() throws Exception {
		navigateToRepository();
		Thread.sleep(8000);
		CEP_Repository_Smoke_Page_Factory objR = new CEP_Repository_Smoke_Page_Factory(driver, logger);
		WebElement branch = objR.getBranch();
		if (branch != null) {
//			branch.click();
			Thread.sleep(3000);
//			WebElement search = objR.getSearch();
			Thread.sleep(3000);
			//search.sendKeys("Phoenix AZ - 0N0J");
//			WebElement label = objR.getBrName();
//			label.click();
			fetchAPIReposit();
			if (name != null) {
				logger.log(LogStatus.PASS, "Data for the selected branch is as expected and is matching with API.");
				logger.log(LogStatus.INFO, "Following folders are present:");
				logger.log(LogStatus.INFO, Arrays.toString(name.toArray()));
				blobPath.removeIf(Objects::isNull);
				logger.log(LogStatus.PASS, "Sequence of data is as expected.");
				logger.log(LogStatus.INFO, Arrays.toString(blobPath.toArray()));
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL, "No data fetched from API.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Fields in the Repository page are not as expected.");
			getFinalReport(driver, logger, "fields24", false);
		}
	}
}
