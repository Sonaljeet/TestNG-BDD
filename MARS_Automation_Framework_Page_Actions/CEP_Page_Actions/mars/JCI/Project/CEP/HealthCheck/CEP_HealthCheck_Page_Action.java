package mars.JCI.Project.CEP.HealthCheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import commonFunctions.WebDropDown;
import commonFunctionsAPI.CommonAPI_Functions;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Factory;

public class CEP_HealthCheck_Page_Action extends BaseClass {

	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	@SuppressWarnings("static-access")
	public CEP_HealthCheck_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void waitForSpinnerToBeGone() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		try {
			boolean spinnerStatus = objStatusCheck.getSpinnerStatus();
			if (spinnerStatus) {
				new WebDriverWait(driver, 60).until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.overlayheatmap>spinner")));
			}
		} catch (TimeoutException e) {
			logger.log(LogStatus.FAIL, "Time to fetch data from APIs is more than 30 seconds.");
		}

	}

	public void validateSummaryForHealthCheck() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_HealthCheck_Page_Factory objHealthCheck = new CEP_HealthCheck_Page_Factory(driver, logger);
		waitForSpinnerToBeGone();
		WebElement dropDown = objStatusCheck.getDropDown();
		if (dropDown != null) {
			Thread.sleep(3000);
			Select select = new Select(dropDown);
			select.selectByIndex(1);
			Thread.sleep(3000);
			String selectedValue = WebDropDown.getSelectedOptionFromDropDown(dropDown);
			if (selectedValue.equalsIgnoreCase("Health Check")) {
				logger.log(LogStatus.PASS, "Health Check option selection is as expected.");
				WebElement noDataMessage = objHealthCheck.getNoDataMessage();
				if (noDataMessage != null) {
					if (noDataMessage.getText()
							.equalsIgnoreCase("No active health check data available for the previous five days")) {
						logger.log(LogStatus.PASS, "No data message is as expected.");
						logger.log(LogStatus.INFO,
								"Message: 'No active health check data available for the previous five days' is as expected.");
						getFinalReport(driver, logger, "testHealthCheckSelection", true);
					} else {
						logger.log(LogStatus.PASS,
								"Previous five days details are getting displayed for Health Check.");
						getFinalReport(driver, logger, "testHealthCheckSelection", true);
					}
				}
			} else {
				logger.log(LogStatus.FAIL, "Health Check option selection is not as expected.");
				getFinalReport(driver, logger, "testHealthCheckSelection", false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Drop down is not present.");
		}

	}

	public void validateDropDown() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_HealthCheck_Page_Factory objHealthCheck = new CEP_HealthCheck_Page_Factory(driver, logger);
		waitForSpinnerToBeGone();
		WebElement dropDown = objStatusCheck.getDropDown();
		if (dropDown != null) {
			Thread.sleep(3000);
			Select select = new Select(dropDown);
			select.selectByIndex(1);
			Thread.sleep(3000);
			String selectedValue = WebDropDown.getSelectedOptionFromDropDown(dropDown);
			if (selectedValue.equalsIgnoreCase("Health Check")) {
				logger.log(LogStatus.PASS, "Health Check option is selected successfully.");
				logger.log(LogStatus.PASS, "Details for health check summary is as expected.");
			} else {
				logger.log(LogStatus.FAIL, "Health Check option is not as expected in the drop down.");
			}

		} else {
			logger.log(LogStatus.FAIL, "Drop down is not present.");
		}
	}
}
