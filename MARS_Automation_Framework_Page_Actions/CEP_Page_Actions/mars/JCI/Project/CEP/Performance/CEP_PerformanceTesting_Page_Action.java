package mars.JCI.Project.CEP.Performance;

import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.CustomerListByStatus.CEP_CustomerListByStatus_Page_Factory;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.HeatMap.CEP_HeatMap_DataBase_Action;
import mars.JCI.Project.CEP.Smoke.CEP_Diagnostic_Smoke_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Reports_Smoke_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Scorecard_Smoke_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Trends_Smoke_Page_Factory;
import mars.JCI.Project.CEP.SmokeTest.CEP_Comparative_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Repo_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Reports_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Scorecard_Smoke_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Trends_Smoke_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Factory;

public class CEP_PerformanceTesting_Page_Action extends BaseClass {

	@SuppressWarnings("static-access")
	public CEP_PerformanceTesting_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	// private String serverUAT = "13.68.85.191";
	// private String serverProd = "172.16.47.4";
	// private int port = 8125;

	public void validateLoadForOverivew() throws Exception {
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		long start = System.nanoTime();
		objStatusChk.waitForSpinnerToBeGone();
		Thread.sleep(1000);
		long elapsedTime = System.nanoTime() - start;
		double timeInSecs = ((double) elapsedTime) / 1E9;
		if (timeInSecs <= 30) {
			logger.log(LogStatus.PASS, "Time taken to load Landing Page is within threshold limit. Page Load Time is: "
					+ timeInSecs + "s");
			Thread.sleep(1000);
			getFinalReport(driver, logger, methodName, true);
		} else {
			logger.log(LogStatus.FAIL,
					"Time taken to load Landing Page is not within threshold limit. Page Load Time is: " + timeInSecs
							+ "s");
			getFinalReport(driver, logger, methodName, false);
		}
		// StatsDClient statsd = new
		// NonBlockingStatsDClient("cepp.jobs.loadTime",serverUAT,port);
		// statsd.gauge("overview", elapsedTime);
	}

	public void validateLoadForOnChillerStatusWidget() throws Exception {
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		Thread.sleep(1000);
		WebElement dropDown = objStatusCheck.getDropDown();
		if (dropDown != null) {
			Thread.sleep(3000);
			Select select = new Select(dropDown);
			select.selectByVisibleText("Health Check");
			long start = System.nanoTime();
			objStatusChk.waitForSpinnerToBeGone();
			Thread.sleep(500);
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if (timeInSecs <= 2) {
				logger.log(LogStatus.PASS,
						"Time taken to load On Chiller Status Widget is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to load On Chiller Status Widget is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(500);
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Chiller Status Drop down is not present.");
		}
		// StatsDClient statsd = new
		// NonBlockingStatsDClient("cepp.jobs.loadTime",serverUAT,port);
		// statsd.gauge("overview", elapsedTime);
	}

	public String getFirstGreenCustomer() throws Exception {
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForGreenChillers();
		String customer = null;
		while (rs.next()) {
			customer = rs.getString("CustomerName");
		}
		return customer;
	}

	public void validateLoadForCustomerListByStatus() throws Exception {
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_Performance_Page_Factory objPerf = new CEP_Performance_Page_Factory(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		String customerDB = getFirstGreenCustomer();
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		if (greenColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greenColor).click().build().perform();
			long start = System.nanoTime();
			Thread.sleep(200);
			WebElement ele = objPerf.getFirstCust(customerDB);
			if (ele.getText().equalsIgnoreCase(customerDB)) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if (timeInSecs <= 1) {
					logger.log(LogStatus.PASS,
							"Time taken to load Customer List By Status is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load Customer List By Status is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			} else {
				logger.log(LogStatus.FAIL, "Customer not present in Customer List By Status.");
				getFinalReport(driver, logger, methodName + "1", false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Color widget not loaded properly.");
			getFinalReport(driver, logger, methodName + "1", false);
		}
	}

	public void validateLoadOfChillerInfoWidget() throws Exception {
		CEP_Performance_Page_Factory objPerf = new CEP_Performance_Page_Factory(driver, logger);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		Actions action = new Actions(driver);
		action.moveToElement(greenColor).click().build().perform();
		Thread.sleep(1000);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement arrow = objPerf.getArrow();
		if (arrow != null) {
			arrow.click();
			long start = System.nanoTime();
			objStatusChk.waitForChillerInfoSpinnerToBeGone();
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if (timeInSecs <= 1) {
				logger.log(LogStatus.PASS,
						"Time taken to load Chiller Information Widget is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to load Chiller Information Widget is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(500);
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Chiller Information Widget not loaded properly.");
			getFinalReport(driver, logger, methodName + "1", false);
		}
	}

	public void validateLoadOfStatusHealthChkWidget() throws Exception {
		CEP_Performance_Page_Factory objPerf = new CEP_Performance_Page_Factory(driver, logger);
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		Actions action = new Actions(driver);
		action.moveToElement(greenColor).click().build().perform();
		Thread.sleep(2000);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement arrow = objPerf.getStatusChkArrow();
		if (arrow != null) {
			arrow.click();
			long start = System.nanoTime();
			objStatusChk.waitForSpinnerToBeGone();
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if (timeInSecs <= 1) {
				logger.log(LogStatus.PASS,
						"Time taken to load Status Check/Health Check Widget is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to load Status Check/Health Check Widget is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(500);
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Status Check/Health Check Widget not loaded properly.");
			getFinalReport(driver, logger, methodName + "1", false);
		}
	}

	public void validateLoadForTrends() throws Exception {
		CEP_CustomerListByStatus_Page_Factory objChill = new CEP_CustomerListByStatus_Page_Factory(driver);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Action objTrendsAction = new CEP_Trends_Smoke_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement firstChiller = objChill.getFirstChiller();
		if (firstChiller != null) {
			firstChiller.click();
			long start = System.nanoTime();
			WebElement maximizeButton = objTrends.getMaximizeButton();
			if (maximizeButton != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if (timeInSecs <= 1.15) {
					logger.log(LogStatus.PASS,
							"Time taken to load Trends data is within threshold limit. Page Load Time is: " + timeInSecs
									+ "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load Trends is not within threshold limit. Page Load Time is: " + timeInSecs
									+ "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			} else {
				logger.log(LogStatus.FAIL, "Time taken to load Trends is not within threshold limit.");
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Data not present.");
		}
	}

	public void validateLoadOfTrendsFromStatusChk() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		if (chart != null) {
			Actions action = new Actions(driver);
			action.moveToElement(chart).click().perform();
			long start = System.nanoTime();
			WebElement maximizeButton = objTrends.getMaximizeButton();
			if (maximizeButton != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if (timeInSecs <= 1.15) {
					logger.log(LogStatus.PASS,
							"Time taken to load Trends data from Status Check/Health Check widget is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load Trends Status Check/Health Check widget is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			} else {
				logger.log(LogStatus.FAIL, "Time taken to load Trends is not within threshold limit.");
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.INFO, "Data not present for the chiller.");
		}
	}

	public void validateLoadOfAllTrendsWidgets() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		long start = System.nanoTime();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if (timeInSecs <= 30) {
				logger.log(LogStatus.PASS,
						"Time taken to load all Trends' widget is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to load all Trends' widget is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(500);
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Trends is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
		WebElement equip = objTrends.getEquipment();
		Select select = new Select(equip);
		select.selectByIndex(1);
		start = System.nanoTime();
		maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if (timeInSecs <= 15) {
				logger.log(LogStatus.PASS,
						"Time taken to load all Trends' widget after changing the equipment is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to load all Trends' widget after changing the equipment is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(500);
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.FAIL,
					"Time taken to load Trends after changing the equipment is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadOfTrendsAfterTransition() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			List<WebElement> metricsList = objTrends.getMetricsList();
			metricsList.get(0).click();
			start = System.nanoTime();
			maximizeButton = objTrends.getMaximizeButton();
			if (maximizeButton != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs <= 5) || (timeInSecs <= 10)) {
					logger.log(LogStatus.PASS,
							"Time taken to load all Trends' widget after transitioning from 5d is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load all Trends' widget after transitioning from 5d is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Trends is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadForTrendsAfterMovingSlider() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			WebElement slider = objTrends.getSliderArrow();
			System.out.println(slider.getAttribute("class"));
			for (int i = 0; i < 10; i++)
				slider.click();
			start = System.nanoTime();
			maximizeButton = objTrends.getMaximizeButton();
			if (maximizeButton != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs <= 3) || (timeInSecs <= 5)) {
					logger.log(LogStatus.PASS,
							"Time taken to load all Trends' widget after moving the Slider is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load all Trends' widget after moving the Slider is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Trends after moving slide is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadForTrendsManageActivePoints() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			WebElement managePointButton = objTrends.getManagePointButton();
			managePointButton.click();
			start = System.nanoTime();
			WebElement saveButton = objTrends.getSaveButton().get(0);
			if (saveButton != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs <= 2)) {
					logger.log(LogStatus.PASS,
							"Time taken to load active points is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load active points is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load active points is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadForTrendsAfterAddingPoints() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			WebElement managePointButton = objTrends.getManagePointButton();
			managePointButton.click();
			Thread.sleep(2000);
			WebElement evaporator1 = objTrends.getEvaporatorPt1();
			evaporator1.click();
			WebElement saveButton = objTrends.getSaveButton().get(0);
			saveButton.click();
			start = System.nanoTime();
			maximizeButton = objTrends.getMaximizeButton();
			if (maximizeButton != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs <= 2)) {
					logger.log(LogStatus.PASS,
							"Time taken to load Trends after adding points is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load Trends after adding points is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Trends after adding points is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadOfDashboradExpansion() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			maximizeButton.click();
			start = System.nanoTime();
			maximizeButton = objTrends.getMaximizeButton();
			if (maximizeButton != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs <= 1)) {
					logger.log(LogStatus.PASS,
							"Time taken to load chart after expansion is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load chart after expansion is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load chart after expansion is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	public void validateLoadOfChillerSnapshot() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			Actions action = new Actions(driver);
			WebElement lineChart = objTrends.getLineChart();
			if ((lineChart != null)) {
				lineChart.click();
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, methodName + "test", false);
			}
			start = System.nanoTime();
			WebElement edit = objTrends.getEditBtn();
			if (edit != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs <= 15) || (timeInSecs <= 20)) {
					logger.log(LogStatus.PASS,
							"Time taken to load Chiller Snapshot is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load Chiller Snapshot is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Chiller Snapshot is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadOfGridData() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			List<WebElement> chartOptions = objTrends.getChartOptions();
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(1)).click().build().perform();
			start = System.nanoTime();
			List<WebElement> chartOptionsValues = objTrends.getChartOptionsValues();
			action.moveToElement(chartOptionsValues.get(0)).click().build().perform();
			Thread.sleep(200);
			WebElement gridData = objTrends.getGridData();
			if (gridData != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if (timeInSecs < 1) {
					logger.log(LogStatus.PASS,
							"Time taken to load grid data in Trends page is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(2000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load grid data in Trends page is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load grid data in Trends page is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadOfCSV() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Trends_Smoke_Page_Action objT = new CEP_Trends_Smoke_Page_Action(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			List<WebElement> chartOptions = objTrends.getChartOptions();
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(1)).click().build().perform();
			List<WebElement> chartOptionsValues = objTrends.getChartOptionsValues();
			action.moveToElement(chartOptionsValues.get(0)).click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(chartOptions.get(1)).click().build().perform();
			action.moveToElement(chartOptionsValues.get(1)).click().build().perform();
			start = System.nanoTime();
			objT.waitForPointSpinnerToBeGone();
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if (timeInSecs < 1) {
				logger.log(LogStatus.PASS,
						"Time taken to export to CSV in Trends page is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(2000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to export to CSV in Trends page is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to export to CSV in Trends page is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadOfTrendPDF() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Trends_Smoke_Page_Action objT = new CEP_Trends_Smoke_Page_Action(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			List<WebElement> chartOptions = objTrends.getChartOptions();
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(1)).click().build().perform();
			List<WebElement> chartOptionsValues = objTrends.getChartOptionsValues();
			action.moveToElement(chartOptionsValues.get(0)).click().build().perform();
			Thread.sleep(3000);
			action.moveToElement(chartOptions.get(1)).click().build().perform();
			action.moveToElement(chartOptionsValues.get(2)).click().build().perform();
			start = System.nanoTime();
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = handles.iterator().next().toString();
			if (winHandle != firstWinHandle) {
				String secondWinHandle = winHandle;
				driver.switchTo().window(secondWinHandle);
				driver.manage().window().maximize();
				WebElement preview = objTrends.getPdfPrvWBtn();
				try {
					Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
					wait.until(
							ExpectedConditions.elementToBeClickable(By.xpath("//input[@automation-id='btnPreview']")));
					action.moveToElement(preview).build().perform();
					preview.click();
				} catch (WebDriverException e) {
					preview.click();
				}
				WebElement print = objTrends.getPdfPrintBtn();
				try {
					Wait<WebDriver> wait = new FluentWait<WebDriver>(driver);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@automation-id='btnPrint']")));
					action.moveToElement(print).build().perform();
					print.click();
				} catch (WebDriverException e) {
					print.click();
				}
				WebElement success = objP.getTrendsSuccessfulPDFMsg();
				if (success != null) {
					// getFinalReport(driver, logger, methodName, true);
					long elapsedTime = System.nanoTime() - start;
					double timeInSecs = ((double) elapsedTime) / 1E9;
					if ((timeInSecs <= 5) || (timeInSecs <= 10)) {
						logger.log(LogStatus.PASS,
								"Time taken to save PDF in Trends page is within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(2000);
						getFinalReport(driver, logger, methodName, true);
					} else {
						logger.log(LogStatus.FAIL,
								"Time taken to save PDF in Trends page is not within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(1000);
						getFinalReport(driver, logger, methodName, false);
					}
				}
			}

		} else {
			logger.log(LogStatus.FAIL, "Time taken to save PDF in Trends page is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadOfEditChillerSnapshot() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			Actions action = new Actions(driver);
			WebElement lineChart = objTrends.getLineChart();
			if ((lineChart != null)) {
				lineChart.click();
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, methodName + "test", false);
			}
			WebElement edit = objTrends.getEditBtn();
			if (edit != null) {
				edit.click();
				start = System.nanoTime();
				WebElement addIcon = objP.getAddIcon();
				if (addIcon != null) {
					long elapsedTime = System.nanoTime() - start;
					double timeInSecs = ((double) elapsedTime) / 1E9;
					if ((timeInSecs < 1)) {
						logger.log(LogStatus.PASS,
								"Time taken to load Edit Chiller Snapshot is within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(1000);
						getFinalReport(driver, logger, methodName, true);
					} else {
						logger.log(LogStatus.FAIL,
								"Time taken to load Edit Chiller Snapshot is not within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(500);
						getFinalReport(driver, logger, methodName, false);
					}
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Edit Chiller Snapshot is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadOfSaveChillerSnapshot() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			WebElement lineChart = objTrends.getLineChart();
			if ((lineChart != null)) {
				lineChart.click();
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, methodName + "test", false);
			}
			WebElement save = objTrends.getSaveBtn();
			if (save != null) {
				save.click();
				start = System.nanoTime();
				objTrends.getPreviewBtn().click();
				objTrends.getSaveAsPdfBtn().click();
				WebElement success = objP.getSuccessfulPDFMsg();
				if (success != null) {
					long elapsedTime = System.nanoTime() - start;
					double timeInSecs = ((double) elapsedTime) / 1E9;
					if ((timeInSecs < 2)) {
						logger.log(LogStatus.PASS,
								"Time taken to download Chiller Snapshot report is within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(1000);
						getFinalReport(driver, logger, methodName, true);
					} else {
						logger.log(LogStatus.FAIL,
								"Time taken to download Chiller Snapshot report is not within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(500);
						getFinalReport(driver, logger, methodName, false);
					}
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to download Chiller Snapshot report is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadForDiagnostic() throws Exception {
		CEP_Diagnostic_Smoke_Page_Factory objD = new CEP_Diagnostic_Smoke_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		WebElement diaLink = objD.getDiagnosticsLink();
		if (diaLink != null) {
			diaLink.click();
			long start = System.nanoTime();
			List<WebElement> loadMore = objD.getLoadMoreButton();
			if (loadMore != null) {
				long elapsedTime = System.nanoTime() - start;
				logger.log(LogStatus.PASS,
						"Time taken to load Diagnostics Page: " + ((double) elapsedTime) / 1E9 + "s");
				// StatsDClient statsd = new
				// NonBlockingStatsDClient("cepp.jobs.loadTime",serverUAT,port);
				// statsd.gauge("diagnostics", elapsedTime);
			} else {
				logger.log(LogStatus.FAIL, "Error in loading Diagnostic Page.");
			}

		} else {
			logger.log(LogStatus.FAIL, "Diagnostic link not present.");
		}
	}
	
	public void validateLoadForComparative() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Action objC = new CEP_Comparative_Smoke_Page_Action(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			start = System.nanoTime();
			objC.navigateToComparative();
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if ((timeInSecs < 1)) {
				logger.log(LogStatus.PASS,
						"Time taken to load Comparative is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to load Comparative is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(500);
				getFinalReport(driver, logger, methodName, false);
			}			
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Comparative is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	public void validateLoadForAddComparativeChart() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Action objC = new CEP_Comparative_Smoke_Page_Action(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			objC.navigateToComparative();
			start = System.nanoTime();
			objC.validateAddandSave();
			long elapsedTime = System.nanoTime() - start;
			double timeInSecs = ((double) elapsedTime) / 1E9;
			if ((timeInSecs < 2)) {
				logger.log(LogStatus.PASS,
						"Time taken to add Comparative Chart is within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL,
						"Time taken to add Comparative Chart is not within threshold limit. Page Load Time is: "
								+ timeInSecs + "s");
				Thread.sleep(1000);
				getFinalReport(driver, logger, methodName, false);
			}			
		} else {
			logger.log(LogStatus.FAIL, "Time taken to add Comparative Chart is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	public void validateCompLoadForMaximizeOfChart() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Action objC = new CEP_Comparative_Smoke_Page_Action(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		if (maximizeButton != null) {
			objC.navigateToComparative();
			objC.validateAddandSave();
			maximizeButton = objP.getCompMaximize();
			if (maximizeButton != null) {
				start = System.nanoTime();
				maximizeButton.click();
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs <= 1)) {
					logger.log(LogStatus.PASS,
							"Time taken to load chart after expansion is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load chart after expansion is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load chart after expansion is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	public void validateLoadOfChillerSnapshotComp() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Action objC = new CEP_Comparative_Smoke_Page_Action(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		objC.navigateToComparative();
		objC.validateAddandSave();
		maximizeButton = objP.getCompMaximize();
		if (maximizeButton != null) {
			Actions action = new Actions(driver);
			WebElement lineChart = objTrends.getLineChart();
			if ((lineChart != null)) {
				lineChart.click();
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, methodName + "test", false);
			}
			start = System.nanoTime();
			WebElement edit = objTrends.getEditBtn();
			if (edit != null) {
				long elapsedTime = System.nanoTime() - start;
				double timeInSecs = ((double) elapsedTime) / 1E9;
				if ((timeInSecs < 16) || (timeInSecs < 21)) {
					logger.log(LogStatus.PASS,
							"Time taken to load Chiller Snapshot in Comparative page is within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(1000);
					getFinalReport(driver, logger, methodName, true);
				} else {
					logger.log(LogStatus.FAIL,
							"Time taken to load Chiller Snapshot in Comparative page is not within threshold limit. Page Load Time is: "
									+ timeInSecs + "s");
					Thread.sleep(500);
					getFinalReport(driver, logger, methodName, false);
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Chiller Snapshot in Comparative page is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	public void validateLoadOfEditChillerSnapshotComp() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Action objC = new CEP_Comparative_Smoke_Page_Action(driver, logger);
		CEP_Performance_Page_Factory objP = new CEP_Performance_Page_Factory(driver, logger);
		long start = 0;
		objStatusChk.waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
		chart.click();
		WebElement maximizeButton = objTrends.getMaximizeButton();
		objC.navigateToComparative();
		objC.validateAddandSave();
		maximizeButton = objP.getCompMaximize();
		if (maximizeButton != null) {
			Actions action = new Actions(driver);
			WebElement lineChart = objTrends.getLineChart();
			if ((lineChart != null)) {
				lineChart.click();
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, methodName + "test", false);
			}
			WebElement edit = objTrends.getEditBtn();
			if (edit != null) {
				edit.click();
				start = System.nanoTime();
				WebElement addIcon = objP.getAddIcon();
				if (addIcon != null) {
					long elapsedTime = System.nanoTime() - start;
					double timeInSecs = ((double) elapsedTime) / 1E9;
					if ((timeInSecs < 1)) {
						logger.log(LogStatus.PASS,
								"Time taken to load Edit Chiller Snapshot Comparative is within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(1000);
						getFinalReport(driver, logger, methodName, true);
					} else {
						logger.log(LogStatus.FAIL,
								"Time taken to load Edit Chiller Snapshot Comparative is not within threshold limit. Page Load Time is: "
										+ timeInSecs + "s");
						Thread.sleep(500);
						getFinalReport(driver, logger, methodName, false);
					}
				}
			}
		} else {
			logger.log(LogStatus.FAIL, "Time taken to load Edit Chiller Snapshot Comparative is not within threshold limit.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateLoadForReport() throws Exception {
		CEP_Reports_Smoke_Page_Action objR = new CEP_Reports_Smoke_Page_Action(driver, logger);
		CEP_Reports_Smoke_Page_Factory objR1 = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		objR.navigateToReport();
		long start = System.nanoTime();
		WebElement report = objR1.getReportButton();
		if (report != null) {
			long elapsedTime = System.nanoTime() - start;
			logger.log(LogStatus.PASS, "Time taken to load Report Page: " + ((double) elapsedTime) / 1E9 + "s");
			// StatsDClient statsd = new
			// NonBlockingStatsDClient("cepp.jobs.loadTime",serverUAT,port);
			// statsd.gauge("report", elapsedTime);
		} else {
			logger.log(LogStatus.FAIL, "Error in loading Diagnostic Page.");
		}
	}

	public void validateLoadForScorecard() throws Exception {
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		CEP_Scorecard_Smoke_Page_Action objS = new CEP_Scorecard_Smoke_Page_Action(driver, logger);
		CEP_Scorecard_Smoke_Page_Factory objS1 = new CEP_Scorecard_Smoke_Page_Factory(driver, logger);
		objS.navigateToScoreCard();
		long start = System.nanoTime();
		WebElement overview = objS1.getOverview();
		if (overview != null) {
			long elapsedTime = System.nanoTime() - start;
			logger.log(LogStatus.PASS, "Time taken to load Scorecard Page: " + ((double) elapsedTime) / 1E9 + "s");
			// StatsDClient statsd = new
			// NonBlockingStatsDClient("cepp.jobs.loadTime",serverUAT,port);
			// statsd.gauge("scorecard", elapsedTime);
		} else {
			logger.log(LogStatus.FAIL, "Error in loading Scorecard Page.");
		}
	}

	public void validateLoadForRepo() throws Exception {
		CEP_StatusCheck_Page_Action objStatusChk = new CEP_StatusCheck_Page_Action(driver, logger);
		objStatusChk.waitForSpinnerToBeGone();
		CEP_Repo_Smoke_Page_Action objR = new CEP_Repo_Smoke_Page_Action(driver, logger);
		objR.navigateToRepo();
		long start = System.nanoTime();
		CEP_Reports_Smoke_Page_Factory objR1 = new CEP_Reports_Smoke_Page_Factory(driver, logger);
		WebElement save = objR1.getSaveButton();
		if (save != null) {
			long elapsedTime = System.nanoTime() - start;
			logger.log(LogStatus.PASS, "Time taken to load Repository Page: " + ((double) elapsedTime) / 1E9 + "s");
			// StatsDClient statsd = new
			// NonBlockingStatsDClient("cepp.jobs.loadTime",serverUAT,port);
			// statsd.gauge("repository", elapsedTime);
		} else {
			logger.log(LogStatus.FAIL, "Error in loading Repository Page.");
		}
	}

}
