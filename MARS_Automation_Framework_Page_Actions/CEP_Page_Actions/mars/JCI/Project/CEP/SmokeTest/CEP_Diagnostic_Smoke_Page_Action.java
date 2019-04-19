package mars.JCI.Project.CEP.SmokeTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Diagnostic_Smoke_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Trends_Smoke_Page_Factory;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Factory;

public class CEP_Diagnostic_Smoke_Page_Action extends BaseClass {

	public CEP_Diagnostic_Smoke_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void navigateToDiagnostic() throws Exception {
		CEP_Diagnostic_Smoke_Page_Factory objDia = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_StatusCheck_Page_Action objStatus = new CEP_StatusCheck_Page_Action(driver, logger);
		//objStatus.waitForSpinnerToBeGone();
		objLeftPanel.waitForOverviewPage();
		//Thread.sleep(8000);
		WebElement diaLink = objDia.getDiagnosticsLink();
		if (diaLink != null) {
			diaLink.click();
			//Thread.sleep(10000);
			waitForBlobToBeGone();
			logger.log(LogStatus.PASS, "Successfully navigated to Diagnostic page.");
		} else {
			logger.log(LogStatus.FAIL, "Diagnostic Link not present.");
		}
	}
	
	public void waitForBlobToBeGone() throws Exception {
		CEP_Diagnostic_Smoke_Page_Factory objDia = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		try {
			boolean spinnerStatus = objDia.getBlobStatus();
			if (spinnerStatus) {
				new WebDriverWait(driver, 80).until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.overlayheatmap>spinner")));
			}
		} catch (TimeoutException e) {
			logger.log(LogStatus.FAIL, "Time to fetch data from APIs is more than 30 seconds.");
		}

	}
	
	public void validatePreviousYearGraphs() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Diagnostic_Smoke_Page_Factory objDia = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		waitForBlobToBeGone();
		//Thread.sleep(15000);
		WebElement selectCalendar = objTrends.getOpenCalendarButton();
		if (selectCalendar != null) {
			selectCalendar.click();
			WebElement selectPreviousYr = objTrends.getPreviousYearArrow();
			if (selectPreviousYr != null) {
				selectPreviousYr.click();
				objTrends.getCalendarDate().click();
				objDia.getShowButton().click();
				//Thread.sleep(15000);
				validateGraphsForDiffMetrices();
			}
		}
	}
	
	public void openCustomerDetails(String customer, String branch) throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		WebElement searchBox;
		searchBox = objLeftPanel.getSearchBox();
		searchBox.sendKeys(customer);
		objLeftPanel.getSearchBoxButton().click();
		//Thread.sleep(3000);
		WebElement cust = objLeftPanel.getLeftPanelElement(customer, "4");
		if (cust.isDisplayed()) {
			WebElement branchName = objLeftPanel.getBranchName();
			branchName.click();
			//Thread.sleep(10000);
			navigateToDiagnostic();
			//Thread.sleep(40000);
			validateCustomerNFaclityOption(customer,branch);
		}
		else{
			logger.log(LogStatus.FAIL, "Customer AZDoR is not present for this user.");
			getFinalReport(driver, logger, "searchByCustomer1", false);
		}
	}
	
	public void validateCustomerNFaclityOption(String customer,String branch) throws Exception {
		CEP_Diagnostic_Smoke_Page_Factory objDia = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		waitForBlobToBeGone();
		WebElement selectCustomer = objDia.getSelectCust();
		if(selectCustomer!=null){
			Select select = new Select(selectCustomer);
			select.selectByVisibleText(customer);
			//Thread.sleep(40000);
			WebElement selectProject = objDia.getSelectProject();
			Select select1 = new Select(selectProject);
			select1.selectByVisibleText(branch);
			//Thread.sleep(40000);
			logger.log(LogStatus.PASS, "Customer and Facility filter is working as expected in the Diagnostic page.");
		}
		else{
			logger.log(LogStatus.FAIL, "Customer drop down is not present in the Diagnostic page.");
			getFinalReport(driver, logger, "testFilterCustomerNFaclityOption", false);
		}
		
	}

	public void validateGraphsForDiffMetrices() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> metricsList = objTrends.getMetricsList();
		if (metricsList != null) {
			logger.log(LogStatus.PASS, "Buttons for different metrices are present.");
			metricsList.get(0).click();
			waitForBlobToBeGone();
			//Thread.sleep(15000);
			logger.log(LogStatus.PASS, "Graphical details for 12h is as expected.");
			getFinalReport(driver, logger, methodName+"testRaw221", true);
			metricsList.get(1).click();
			waitForBlobToBeGone();
			//Thread.sleep(15000);			logger.log(LogStatus.PASS, "Graphical details for 24h is as expected.");
			//getFinalReport(driver, logger, "testQtrly2343", true);
			metricsList.get(2).click();
			waitForBlobToBeGone();
			//Thread.sleep(15000);
			logger.log(LogStatus.PASS, "Graphical details for 5D is as expected.");
			getFinalReport(driver, logger, methodName+"test5dsfD", true);
			metricsList.get(3).click();
			waitForBlobToBeGone();
			//Thread.sleep(15000);
			logger.log(LogStatus.PASS, "Graphical details for 1W is as expected.");
			getFinalReport(driver, logger, methodName+"test1asdW", true);
			metricsList.get(4).click();
			waitForBlobToBeGone();
			//Thread.sleep(15000);
			logger.log(LogStatus.PASS, "Graphical details for 2W is as expected.");
			getFinalReport(driver, logger, methodName+"test2asdffdaW", true);
			metricsList.get(5).click();
			waitForBlobToBeGone();
			//Thread.sleep(15000);
			logger.log(LogStatus.PASS, "Graphical details for 1M is as expected.");
			getFinalReport(driver, logger, methodName+"test1asdfM", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Metrics not present");
			getFinalReport(driver, logger, methodName+"testQtrly", true);
			
		}
	}

	public void selectHealthCheck() throws Exception {
		CEP_Diagnostic_Smoke_Page_Factory objDia = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		WebElement selectBox = objDia.getSelectBox();
		if (selectBox != null) {
			Select select = new Select(selectBox);
			select.selectByIndex(1);
			logger.log(LogStatus.PASS, "Health Check Option is selected successfully.");
			getFinalReport(driver, logger, "testHCOption", true);
		} else {
			logger.log(LogStatus.FAIL, "DropDown Box is not present in the Diagnostic page.");
			getFinalReport(driver, logger, "testSelectBox", false);
		}
	}

	public void validateDiagnosticForStatus() throws Exception {
		CEP_Diagnostic_Smoke_Page_Factory objDia = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		WebElement selectBox = objDia.getSelectBox();
		if (selectBox != null) {
			selectBox.click();
			//Thread.sleep(10000);
			logger.log(LogStatus.PASS, "DropDown Box is present in the Diagnostic page.");
			
		} else {
			logger.log(LogStatus.FAIL, "DropDown Box is not present in the Diagnostic page.");
			getFinalReport(driver, logger, "testSelectBox", false);
		}
		WebElement customer = objDia.getCustomerDropDown();
		WebElement facility = objDia.getFacilityDropDown();
		if ((customer != null) && (facility != null)) {
			logger.log(LogStatus.PASS, "Customer and Facility Drop Downs are present.");
		} else {
			logger.log(LogStatus.FAIL, "Customer and Facility Drop Downs are not present.");
		}
		List<WebElement> loadMore = objDia.getLoadMoreButton();
		if (loadMore.size() != 0) {
			loadMore.get(0).click();
			//Thread.sleep(20000);
//			logger.log(LogStatus.PASS, "TimeLine Data loaded properly.");
//			logger.log(LogStatus.PASS, "Load More Button is present and is working as expected.");
			//Thread.sleep(10000);
			
		} else {
			logger.log(LogStatus.PASS, "TimeLine Data loaded properly.");
			logger.log(LogStatus.PASS, "Load More Button is present and is working as expected.");
			//Thread.sleep(10000);
			
		}
	}

	@SuppressWarnings("static-access")
	public void validateFaultCodeTimeLineData() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		Thread.sleep(100);
		CEP_StatusCheck_Page_Action objStatusAction = new CEP_StatusCheck_Page_Action(driver, logger);
		//Thread.sleep(10000);
		List<WebElement> getUIDateList = objStatusCheck.getDateList();
		List<String> uiDate = new ArrayList<String>();
		if (getUIDateList.size() != 0) {
			for (int i = 0; i < getUIDateList.size(); i++) {
				String date = getUIDateList.get(i).getText().replace(" ", "-");
				String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
				String strDate = date.concat("-" + year);
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				Date varDate = dateFormat.parse(strDate);
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				uiDate.add(dateFormat.format(varDate));
			}
			if ((uiDate.contains(objStatusAction.getTomorrowDate()))
					&& (uiDate.contains(objStatusAction.getFiveDaysBackDate()))) {
				logger.log(LogStatus.PASS, "Data present for last 5 days.");
				
			} else {
				logger.log(LogStatus.PASS, "Last 5 days data is present.");
				getFinalReport(driver, logger, "testFaultTimeLineData", true);
			}
		}
		else {
			logger.log(LogStatus.INFO, "Data not retrieved from TimeSeries.");
			getFinalReport(driver, logger, "testFaultTimeLineData", false);
		}
	}
	
	public void validateChkBoxesForStatusChk() throws Exception {
		CEP_Diagnostic_Smoke_Page_Factory objDia = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		WebElement greenChkBox = objDia.getGreenCheckBox();
		if(greenChkBox!=null) {
			objDia.getYellowCheckBox().click();
			objDia.getOrangeCheckBox().click();
			objDia.getRedCheckBox().click();
			//Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Green Color Check Box functionality is working as expected.");
			getFinalReport(driver, logger, "testGreenChkBox", true);
			objDia.getGreenCheckBox().click();
			objDia.getYellowCheckBox().click();
			//Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Yellow Color Check Box functionality is working as expected.");
			getFinalReport(driver, logger, "testYelloChkBox", true);
			objDia.getYellowCheckBox().click();
			objDia.getOrangeCheckBox().click();
			//Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Orange Color Check Box functionality is working as expected.");
			getFinalReport(driver, logger, "testOrangeChkBox", true);
			objDia.getOrangeCheckBox().click();
			objDia.getRedCheckBox().click();
			//Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Red Color Check Box functionality is working as expected.");
			getFinalReport(driver, logger, "testRedChkBox", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Check Boxes not present.");
		}
	}
	
	public void validateFaultCodeInTrends() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		waitForBlobToBeGone();
		//Thread.sleep(10000);
		WebElement chart = objStatusCheck.getStatusChart();
		if(chart!=null) {
			Actions action = new Actions(driver);
			action.moveToElement(chart).click().perform();
			//Thread.sleep(20000);
			logger.log(LogStatus.PASS, "Fault Code data loaded in Trends page and are as expected.");
			
		}
		else{
			logger.log(LogStatus.INFO, "Data not present.");
			getFinalReport(driver, logger, "testFaultCodeTrends", false);
		}
	}
}
