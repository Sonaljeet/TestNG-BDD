package mars.JCI.Project.CEP.SmokeTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Smoke.CEP_Reports_Smoke_Page_Factory;

public class CEP_Reports_Smoke_Page_Action extends BaseClass {

	@SuppressWarnings("static-access")
	public CEP_Reports_Smoke_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void navigateToReport() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		WebElement reportLink = objRep.getReportsLink();
		if (reportLink != null) {
			reportLink.click();
			logger.log(LogStatus.PASS, "Report page loaded successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Report link not present.");
		}
	}

	public void validateFieldsInReportsPage() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		//Thread.sleep(6000);
		navigateToReport();
		//Thread.sleep(5000);
		WebElement report = objRep.getReportDropDown();
		if (report != null) {
			logger.log(LogStatus.PASS, "Reports field is present.");
		} else {
			logger.log(LogStatus.FAIL, "Reports field is not present.");
		}
		WebElement customer = objRep.getCustomerDropDown();
		if (customer != null) {
			logger.log(LogStatus.PASS, "Customer field is present.");
		} else {
			logger.log(LogStatus.FAIL, "Customer field is not present.");
		}
		WebElement facility = objRep.getFacilityDropDown();
		if (facility != null) {
			logger.log(LogStatus.PASS, "Facility field is present.");
		} else {
			logger.log(LogStatus.FAIL, "Facility field is not present.");
		}
		WebElement asset = objRep.getAssetDropDown();
		if (asset != null) {
			logger.log(LogStatus.PASS, "Asset field is present.");
		} else {
			logger.log(LogStatus.FAIL, "Asset field is not present.");
		}
		List<WebElement> startDate = objRep.getCalendarButton();
		if (startDate != null) {
			logger.log(LogStatus.PASS, "StartDate and EndDate fields are present.");
		} else {
			logger.log(LogStatus.FAIL, "StartDate and EndDate fields are not present.");
		}
		WebElement reportButton = objRep.getReportButton();
		if (reportButton != null) {
			logger.log(LogStatus.PASS, "Report Button is present.");
		} else {
			logger.log(LogStatus.FAIL, "Report Button is not present.");
		}
	}

	@SuppressWarnings("rawtypes")
	public void validateReportForChillerHealthSummary() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		//Thread.sleep(6000);
		navigateToReport();
		//Thread.sleep(5000);
		WebElement reportButton = objRep.getReportButton();
		if (reportButton != null) {
			reportButton.click();
			//Thread.sleep(15000);
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = handles.iterator().next().toString();
			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				WebElement element = objRep.getSiteLocation();
				logger.log(LogStatus.PASS, "Report loaded successfully and is as expected.");
				getFinalReport(driver, logger, "testReport1"+methodName, true);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
				getFinalReport(driver, logger, "testReport2"+methodName, true);
			}
		} else {
			logger.log(LogStatus.FAIL, "Report Button not present.");
		}
	}

	public void validateReportsForChillerPerf() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		//Thread.sleep(6000);
		navigateToReport();
		//Thread.sleep(5000);
		WebElement reports = objRep.getReportDropDown();
		if (reports != null) {
			Select select = new Select(reports);
			select.selectByVisibleText("Chiller Performance Summary");
			//Thread.sleep(3000);
			getFinalReport(driver, logger, "testReport0"+methodName, true);
			WebElement reportButton = objRep.getReportButton();
			reportButton.click();
			//Thread.sleep(3000);
			WebElement efficiencyMax = objRep.getEfficincyMax();
			efficiencyMax.sendKeys("1");
			WebElement okButton = objRep.getOkButton();
			okButton.click();
			//Thread.sleep(20000);
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = handles.iterator().next().toString();
			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				logger.log(LogStatus.PASS, "Report loaded successfully and is as expected.");
				getFinalReport(driver, logger, "testReport1"+methodName, true);
				for (int i = 2; i <= 22; i++) {
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
					getFinalReport(driver, logger, "testReport"+methodName + i, true);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Report field not present.");
		}
	}
	
	public void validateReportForChillerPerfReportECloud() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		//Thread.sleep(6000);
		navigateToReport();
		//Thread.sleep(5000);
		WebElement reports = objRep.getReportDropDown();
		if (reports != null) {
			Select select = new Select(reports);
			select.selectByVisibleText("Chiller Performance Report (eCloud)");
			//Thread.sleep(3000);
			getFinalReport(driver, logger, "testReport0"+methodName, true);
			WebElement reportButton = objRep.getReportButton();
			reportButton.click();
			//Thread.sleep(20000);
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = handles.iterator().next().toString();
			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				WebElement element = objRep.getFacilityInECloudReport();
				logger.log(LogStatus.PASS, "Report loaded successfully and is as expected.");
				getFinalReport(driver, logger, "testReport1"+methodName, true);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
				getFinalReport(driver, logger, "testReport2"+methodName, true);
			}
		} else {
			logger.log(LogStatus.FAIL, "Report field not present.");
		}
	}
	
	public void validateReportForSCCChiller() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		//Thread.sleep(6000);
		navigateToReport();
		Thread.sleep(8000);
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
			//objRep.getECloudConfirmYesButton().click();
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
				logger.log(LogStatus.PASS, "Report loaded successfully and is as expected.");
				getFinalReport(driver, logger, "testReport1"+methodName, true);
				for (int i = 2; i <= 7; i++) {
					((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
					getFinalReport(driver, logger, "testReport"+methodName + i, true);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Report field not present.");
		}
	}
	
	public void validateReportsForHealthCheck() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		//Thread.sleep(6000);
		navigateToReport();
		Thread.sleep(8000);
		WebElement reports = objRep.getReportDropDown();
		if (reports != null) {
			Select select = new Select(reports);
			select.selectByVisibleText("Health Check For All Chillers");
			//Thread.sleep(3000);
			getFinalReport(driver, logger, "testReport0"+methodName, true);
			WebElement reportButton = objRep.getReportButton();
			reportButton.click();
			//Thread.sleep(15000);
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = handles.iterator().next().toString();
			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				logger.log(LogStatus.PASS, "Report loaded successfully and is as expected.");
				getFinalReport(driver, logger, "testReport1"+methodName, true);
			}
		} else {
			logger.log(LogStatus.FAIL, "Report field not present.");
		}
	}
	
	public void validateRawDataReport() throws Exception {
		CEP_Reports_Smoke_Page_Factory objRep = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		//Thread.sleep(8000);
		navigateToReport();
		Thread.sleep(8000);
		WebElement reports = objRep.getReportDropDown();
		if (reports != null) {
			Select select = new Select(reports);
			select.selectByVisibleText("Raw Data Report");
			Thread.sleep(3000);
			getFinalReport(driver, logger, "testReport0"+methodName, true);
			objRep.getSelectPointLink().click();
			objRep.getSelectPointsChkBox().click();
			objRep.getSaveButton().click();
			//Thread.sleep(5000);
			WebElement reportButton = objRep.getReportButton();
			reportButton.click();
			//Thread.sleep(15000);
			reportButton.click();
			logger.log(LogStatus.INFO, "Raw Data Report initiated for the customer.");
			getFinalReport(driver, logger, "testReport1"+methodName, true);			
			
		} else {
			logger.log(LogStatus.FAIL, "Report field not present.");
		}
	}
}
