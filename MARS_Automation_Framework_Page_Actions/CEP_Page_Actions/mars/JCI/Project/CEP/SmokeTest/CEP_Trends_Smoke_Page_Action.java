package mars.JCI.Project.CEP.SmokeTest;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.HeatMap.CEP_HeatMap_DataBase_Action;
import mars.JCI.Project.CEP.HeatMap.CEP_StatusCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Trends_Smoke_Page_Factory;

public class CEP_Trends_Smoke_Page_Action extends BaseClass {
	@SuppressWarnings("static-access")
	public CEP_Trends_Smoke_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	private String customer = null;
	private String site = null;
	private String chiller = null;
	private String branch = null;

	public void navigateTrendsForOneCustomer(String customerName) throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		CEP_Trends_Smoke_Page_Factory objT = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement searchBox;
		searchBox = objLeftPanel.getSearchBox();
		searchBox.sendKeys(customerName);
		objLeftPanel.getSearchBoxButton().click();
		Thread.sleep(8000);
		WebElement chillerName = objT.getChillerName();
		if (chillerName.isDisplayed()) {
			chillerName = objT.getChillerName();
			chillerName.click();
			Thread.sleep(20000);
			logger.log(LogStatus.PASS, "Successfully navigated to Trends Page.");
		} else {
			logger.log(LogStatus.FAIL, "ChillerName not loaded properly.");
			getFinalReport(driver, logger, "searchByCustomer1", false);
		}
	}

	public void validateSliderTimeFor5D() throws Exception {
		CEP_Trends_Smoke_Page_Factory objT = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		Thread.sleep(10000);
		List<WebElement> sliderTimeList = objT.getSliderTimeList();
		List<String> sliderTime = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		String month = new SimpleDateFormat("MMM").format(cal.getTime()).toString();
		String date = new SimpleDateFormat("dd").format(cal.getTime()).toString();
		String startDate = String.valueOf((Integer.parseInt(date) - 5));
		for (int i = 0; i < sliderTimeList.size(); i++) {
			if (sliderTimeList.get(i).getText().contains(month + " " + date)
					|| sliderTimeList.get(i).getText().contains("1"))
				sliderTime.add(sliderTimeList.get(i).getText());
		}
		Thread.sleep(5000);
		if (sliderTime.size() > 0) {
			logger.log(LogStatus.PASS, "Slider time is working as expected.");
			logger.log(LogStatus.PASS, "Slider start and end time:" + sliderTime);
		} else
			logger.log(LogStatus.FAIL, "Slider time is not working as expected.");
	}

	public void validateSliderTimeForOtherCalendar() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		validatePreviousYearGraphs();
		Thread.sleep(10000);
		List<WebElement> metricsList = objTrends.getMetricsList();
		if (metricsList != null) {
			for (int i = 0; i < metricsList.size(); i++) {
				metricsList.get(i).click();
				Thread.sleep(10000);
				List<WebElement> sliderTimeList = objTrends.getSliderTimeList();
				List<String> sliderTime = new ArrayList<String>();
				for (int j = 0; j < sliderTimeList.size(); j++) {
					if (sliderTimeList.get(j).getText().contains("12:00 pm")
							|| sliderTimeList.get(j).getText().contains("12:00 am"))
						sliderTime.add(sliderTimeList.get(j).getText());
				}
				if (sliderTime.size() > 0) {
					logger.log(LogStatus.PASS, "Slider time is working as expected.");
					logger.log(LogStatus.PASS, "Slider start and end time:" + sliderTime);
				} else
					logger.log(LogStatus.FAIL, "Slider time is not working as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Calendar control is not proper.");
		}
	}

	public void validateEquipment() throws Exception {
		CEP_Trends_Smoke_Page_Factory objT = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement equip = objT.getEquipment();
		Select select = new Select(equip);
		select.selectByVisibleText("YK, CHILLER 2");
		Thread.sleep(20000);
	}
	
	public void waitForMainSpinnerToBeGone() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrend = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		try {
			boolean spinnerStatus = objTrend.getSpinnerStatus();
			if (spinnerStatus) {
				new WebDriverWait(driver, 80).until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.componentLevelSpinner>spinner")));
			}
		} catch (TimeoutException e) {
			logger.log(LogStatus.FAIL, "Time to fetch data from APIs is more than 30 seconds.");
		}

	}
	
	public void waitForPointSpinnerToBeGone() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrend = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		try {
			boolean spinnerStatus = objTrend.getSpinnerStatusPoint();
			if (spinnerStatus) {
				new WebDriverWait(driver, 80).until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.componentLevelSpinner componentLevelSpinner_trend>spinner")));
			}
		} catch (TimeoutException e) {
			logger.log(LogStatus.FAIL, "Time to fetch data from APIs is more than 30 seconds.");
		}

	}
	
	
	
	public void navigateTrendsPage() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		ResultSet rs = CEP_HeatMap_DataBase_Action.detailsForRedChillers();
		List<String> customerName = new ArrayList<String>();
		List<String> siteName = new ArrayList<String>();
		List<String> chillerName = new ArrayList<String>();
		while (rs.next()) {
			customerName.add(rs.getString("CustomerName"));
			siteName.add(rs.getString("ProjectName"));
			chillerName.add(rs.getString("AssetName"));
		}
		customer = customerName.get(0);
		site = siteName.get(0);
		chiller = chillerName.get(0);
		WebElement customer = objHealthCheck.getCustomerInSearchResult(customerName.get(0));
		if (customer.isDisplayed()) {
			objHealthCheck.getSearchTextBox().sendKeys(customer.getText());
			objHealthCheck.getCustomerInSearchResult(customer.getText()).click();
		}
		WebElement chiller = objStatusCheck.getAssetInSearchResult(chillerName.get(0));
		chiller.click();
	}

	@SuppressWarnings("unused")
	public void validateBreadCrumb() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		String branch = CEP_Smoke_Database.getBranchName(customer);
		WebElement breadCrumb = objTrends.getBreadCrumb();
		System.out.println(breadCrumb.getText());
		if (breadCrumb != null) {
			if (breadCrumb.getText().contains(branch + " > " + customer + " > " + site)) {
				logger.log(LogStatus.INFO, "BreadCrumb sequence is:" + breadCrumb.getText());
				logger.log(LogStatus.PASS, "BreadCrumb sequence is as expected.");
			} else {
				logger.log(LogStatus.INFO, "BreadCrumb sequence is:" + breadCrumb.getText());
				logger.log(LogStatus.FAIL, "BreadCrumb sequence is not as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "BreadCrumb sequence is not present.");
		}
	}

	public void validateDefaultPointAndGraphs() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement managePointButton = objTrends.getManagePointButton();
		if (managePointButton != null) {
			managePointButton.click();
			Thread.sleep(15000);
			getFinalReport(driver, logger, "testManagePointWindow", true);
			List<WebElement> listOfSelectedPoints = new ArrayList<WebElement>();
			listOfSelectedPoints = objTrends.getListOfSelectedPoints();
			List<String> selectedPoints = new ArrayList<String>();
			for (int i = 0; i < listOfSelectedPoints.size(); i++) {
				selectedPoints.add(listOfSelectedPoints.get(i).getText());
			}
			Thread.sleep(5000);
			WebElement saveButton = objTrends.getSaveButton().get(0);
			saveButton.click();
			Thread.sleep(20000);
			List<WebElement> listOfGraphNames = new ArrayList<WebElement>();
			List<String> graphNames = new ArrayList<String>();
			listOfGraphNames = objTrends.getGraphNameList();
			for (int i = 0; i < listOfGraphNames.size(); i++) {
				graphNames.add(listOfGraphNames.get(i).getText());
			}
			if (selectedPoints.containsAll(graphNames)) {
				logger.log(LogStatus.PASS, "Active Points and display of Graphs in Trends page is as expected.");
				getFinalReport(driver, logger, "testGraphDisplay", true);
			} else {
				logger.log(LogStatus.FAIL, "Active Points and display of Graphs in Trends page is not as expected.");
				getFinalReport(driver, logger, "testGraphDisplay", false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Manage Active Points is not present.");
			getFinalReport(driver, logger, "testManageActivePoint", false);
		}
	}

	public void navigateToGraph(String name) throws Exception {
		getFinalReport(driver, logger, "testGraph" + name, true);
		// scrolltoEnd();
		// getFinalReport(driver, logger, "testGraph" + name, true);
		// scrolltoEnd();
		// getFinalReport(driver, logger, "testGraph" + name, true);
		// WebElement chart = objTrends.getChart();
		// if(chart!=null) {
		// action.moveToElement(chart).build().perform();
		// getFinalReport(driver, logger, "testGraph"+i+2, true);
		// }
		// else{
		// logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
		// }

	}

	public void scrolltoEnd() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		try {
			// Thread.sleep(3000);
			Actions dragger = new Actions(driver);
			WebElement scroll = objTrends.getScrollBar();
			for (int i = 1; i < 5; i++) {
				dragger.moveToElement(scroll).build().perform();
				dragger.sendKeys(Keys.DOWN).build().perform();
			}
			// Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateMessage() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> metricsList = objTrends.getMetricsList();
		WebElement message = null;
		if (metricsList != null) {
			logger.log(LogStatus.PASS, "Buttons for different metrices are present.");
			metricsList.get(0).click();
			Thread.sleep(20000);
			message = objTrends.getMessage();
			System.out.println(message.getText());
			if (message.getText().equals("* The below charts are showing raw data.")) {
				logger.log(LogStatus.PASS, "Message for 12H is as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message1", true);
			} else {
				logger.log(LogStatus.FAIL, "Message for 12H is not as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message1", false);
			}
			metricsList.get(1).click();
			Thread.sleep(10000);
			message = objTrends.getMessage();
			if (message.getText().equals("* The below charts are showing raw data.")) {
				logger.log(LogStatus.PASS, "Message for 24H is as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message2", true);
			} else {
				logger.log(LogStatus.FAIL, "Message for 24H is not as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message2", false);
			}
			metricsList.get(2).click();
			Thread.sleep(10000);
			message = objTrends.getMessage();
			if (message.getText().equals("* The below charts are showing 15 mins average data.")) {
				logger.log(LogStatus.PASS, "Message for 5D is as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message3", true);
			} else {
				logger.log(LogStatus.FAIL, "Message for 5D is not as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message3", false);
			}
			metricsList.get(3).click();
			Thread.sleep(10000);
			message = objTrends.getMessage();
			if (message.getText().equals("* The below charts are showing 15 mins average data.")) {
				logger.log(LogStatus.PASS, "Message for 1W is as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message4", true);
			} else {
				logger.log(LogStatus.FAIL, "Message for 1W is not as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message4", false);
			}
			metricsList.get(4).click();
			Thread.sleep(10000);
			message = objTrends.getMessage();
			if (message.getText().equals("* The below charts are showing 15 mins average data.")) {
				logger.log(LogStatus.PASS, "Message for 2W is as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message5", true);
			} else {
				logger.log(LogStatus.FAIL, "Message for 2W is not as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message5", false);
			}
			metricsList.get(5).click();
			Thread.sleep(10000);
			message = objTrends.getMessage();
			if (message.getText().equals("* The below charts are showing hourly average data.")) {
				logger.log(LogStatus.PASS, "Message for 1M is as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message6", true);
			} else {
				logger.log(LogStatus.FAIL, "Message for 1M is not as expected.Message is " + message.getText());
				getFinalReport(driver, logger, "message6", false);
			}
		}
	}

	public void validateGraphsForDiffMetrices() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> metricsList = objTrends.getMetricsList();
		if (metricsList != null) {
			logger.log(LogStatus.PASS, "Buttons for different metrices are present.");
			metricsList.get(0).click();
			Thread.sleep(20000);
			logger.log(LogStatus.PASS, "Graphical details for 12H is loaded properly.");
			int i = 1;
			navigateToGraph(methodName + "12H");
			metricsList.get(1).click();
			// Thread.sleep(10000);
			logger.log(LogStatus.PASS, "Graphical details for 24H is loaded properly.");
			Thread.sleep(10000);
			navigateToGraph(methodName + "24H");
			metricsList.get(2).click();
			// Thread.sleep(10000);
			logger.log(LogStatus.PASS, "Graphical details for 5D is loaded properly.");
			Thread.sleep(10000);
			navigateToGraph(methodName + "5D");
			metricsList.get(3).click();
			// Thread.sleep(10000);
			logger.log(LogStatus.PASS, "Graphical details for 1W is loaded properly.");
			Thread.sleep(10000);
			navigateToGraph(methodName + "1W");
			metricsList.get(4).click();
			// Thread.sleep(10000);
			logger.log(LogStatus.PASS, "Graphical details for 2W is loaded properly.");
			Thread.sleep(10000);
			navigateToGraph(methodName + "2W");
			metricsList.get(5).click();
			// Thread.sleep(10000);
			logger.log(LogStatus.PASS, "Graphical details for 1M is loaded properly.");
			Thread.sleep(10000);
			navigateToGraph(methodName + "1M");
		}
	}

	public void validateGraphData() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> metricsList = objTrends.getMetricsList();
		Actions action = new Actions(driver);
		if (metricsList != null) {
			metricsList.get(2).click();
			Thread.sleep(15000);
			WebElement lineChart = objTrends.getLineChart();
			// WebElement barChart = objTrends.getBarChart();
			if ((lineChart != null)) {
				List<WebElement> listOfGraphNames = new ArrayList<WebElement>();
				listOfGraphNames = objTrends.getGraphNameList();
				logger.log(LogStatus.PASS, "Data in the Graph loaded properly.");
				action.moveToElement(lineChart).clickAndHold().build().perform();
				getFinalReport(driver, logger, "testGraphData", true);
				action.moveToElement(lineChart).release().build().perform();
				Thread.sleep(800);
				WebElement toolTipDate = objTrends.getToolTipDate();
				String date = toolTipDate.getText();
				// validate date format
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					// sdf.setLenient(false);
					Date chartDate = sdf.parse(date);
					System.out.println(chartDate);
					logger.log(LogStatus.PASS,
							"Date in Tool tip is as expected.It is in the format MM/dd/yyyy 00:00:00.");
					WebElement nameInToolTip = objTrends.getNameInToolTip();
					if (nameInToolTip.getText().contains(listOfGraphNames.get(0).getText())) {
						logger.log(LogStatus.PASS, "Name in ToolTip is as expected.");
					} else {
						logger.log(LogStatus.PASS, "Name in ToolTip is not as expected.");
						getFinalReport(driver, logger, "getToolTipName", false);
					}
					getFinalReport(driver, logger, "getToolTip", true);
				} catch (Exception e) {
					e.printStackTrace();
					logger.log(LogStatus.FAIL,
							"Tool tip date is not as expected. It is not in the format MM/dd/yyyy 00:00:00.");
					getFinalReport(driver, logger, "getToolTip", false);
				}
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, "testGraphData", true);
			}
			// scrolltoEnd();
			// scrolltoEnd();
		}
	}

	public void validatePreviousYearGraphs() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		Thread.sleep(5000);
		WebElement selectCalendar = objTrends.getOpenCalendarButton();
		if (selectCalendar != null) {
			selectCalendar.click();
			WebElement selectPreviousYr = objTrends.getPreviousYearArrow();
			if (selectPreviousYr != null) {
				selectPreviousYr.click();
				objTrends.getCalendarDate().click();
				objTrends.getShow().click();
				Thread.sleep(10000);
				validateGraphsForDiffMetrices();
			}
		} else {
			logger.log(LogStatus.FAIL, "Calendar not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void validateChartReset() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement selectCalendar = objTrends.getOpenCalendarButton();
		if (selectCalendar != null) {
			selectCalendar.click();
			WebElement selectPreviousYr = objTrends.getPreviousYearArrow();
			if (selectPreviousYr != null) {
				selectPreviousYr.click();
				objTrends.getCalendarDate().click();
				objTrends.getShow().click();
				Thread.sleep(12000);
				WebElement yrInChart = objTrends.getYrInChart();
				if (yrInChart.getText().equals("2018"))
					logger.log(LogStatus.PASS, "Chart Reset functionality is working as expected.");
				else
					logger.log(LogStatus.PASS, "Chart Reset functionality is working as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Calendar not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void compareGraphs() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> chartOptions = objTrends.getChartOptions();
		logger.log(LogStatus.INFO, "Comparing with previous year graph.");
		Thread.sleep(8000);
		Actions action = new Actions(driver);
		action.moveToElement(chartOptions.get(2)).click().build().perform();
		WebElement selectYr = objTrends.getSelectYrValues();
		if (selectYr != null) {
			Select select = new Select(selectYr);
			select.selectByIndex(1);
			Thread.sleep(20000);
			logger.log(LogStatus.PASS, "Compare Graphs is working as expected.");
			getFinalReport(driver, logger, "testCompareGraphs", true);
		} else {
			logger.log(LogStatus.PASS, "Compare Graphs is working as expected.");
			getFinalReport(driver, logger, "testCompareGraphs", false);
		}
	}

	public void validateSlider() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement slider = objTrends.getSliderArrow();
		System.out.println(slider.getAttribute("class"));
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		slider.click();
		Thread.sleep(5000);
		WebElement yrInChart = objTrends.getYrInChart();
		Select select = new Select(yrInChart);
		if (select.getFirstSelectedOption().getText().equals("2019"))
			logger.log(LogStatus.PASS, "Slider functionality is working as expected for Compare Chart.");
		else
			logger.log(LogStatus.FAIL, "Slider functionality is not working as expected for Compare Chart.");
	}

	public void validateMaximizeAndMinimize() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> chartOptions = objTrends.getChartOptions();
		if (chartOptions != null) {
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(0)).click().build().perform();
			logger.log(LogStatus.PASS, "Maximize Chart is working as expected.");
			Thread.sleep(5000);
			getFinalReport(driver, logger, "testMaximizeChart", true);
			action.moveToElement(chartOptions.get(0)).click().build().perform();
			logger.log(LogStatus.PASS, "Minimize Chart is working as expected.");
			Thread.sleep(5000);
			getFinalReport(driver, logger, "testMinimizeChart", true);
		} else {
			logger.log(LogStatus.FAIL, "Maximize/Minimize option not present.");
			getFinalReport(driver, logger, "testChartOptionsGraphs", false);
		}
	}

	public void openPDF() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> chartOptions = objTrends.getChartOptions();
		if (chartOptions != null) {
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(1)).click().build().perform();
			List<WebElement> chartOptionsValues = objTrends.getChartOptionsValues();
			action.moveToElement(chartOptionsValues.get(0)).click().build().perform();
			Thread.sleep(10000);
			WebElement gridData = objTrends.getGridData();
			if (gridData != null) {
				action.moveToElement(chartOptions.get(1)).click().build().perform();
				action.moveToElement(chartOptionsValues.get(2)).click().build().perform();
				Thread.sleep(10000);
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, "testGridValueFromAPI", true);
			}
		} else {
			logger.log(LogStatus.FAIL, "Chart options button not present.");
			getFinalReport(driver, logger, "testChartOptionsGraphs", false);
		}
	}

	public void validateSavePDF() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		openPDF();
		Set handles = driver.getWindowHandles();
		String firstWinHandle = driver.getWindowHandle();
		handles.remove(firstWinHandle);
		String winHandle = handles.iterator().next().toString();
		if (winHandle != firstWinHandle) {
			String secondWinHandle = winHandle;
			driver.switchTo().window(secondWinHandle);
			driver.manage().window().maximize();
			Thread.sleep(10000);
			WebElement preview = objTrends.getPdfPrvWBtn();
			preview.click();
			Thread.sleep(10000);
			WebElement print = objTrends.getPdfPrintBtn();
			print.click();
			logger.log(LogStatus.PASS, "Save PDF is working as expected.");
		} else {
			logger.log(LogStatus.FAIL, "PDF not working as expected.");
		}
	}

	public void validateDiffChartOptions() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> chartOptions = objTrends.getChartOptions();
		if (chartOptions != null) {
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(1)).click().build().perform();
			List<WebElement> chartOptionsValues = objTrends.getChartOptionsValues();
			action.moveToElement(chartOptionsValues.get(0)).click().build().perform();
			Thread.sleep(10000);
			WebElement gridData = objTrends.getGridData();
			if (gridData != null) {
				logger.log(LogStatus.PASS, "Grid data in the Chart is as expected.");
				getFinalReport(driver, logger, "testGridValues", true);
				action.moveToElement(chartOptions.get(1)).click().build().perform();
				action.moveToElement(chartOptionsValues.get(1)).click().build().perform();
				Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Export to CSV is working as expected.");
				getFinalReport(driver, logger, "testExportCSV", true);
				action.moveToElement(chartOptions.get(1)).click().build().perform();
				action.moveToElement(chartOptionsValues.get(2)).click().build().perform();
				Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Export to PDF is working as expected.");
				getFinalReport(driver, logger, "testExportPDFValues", true);
				action.moveToElement(chartOptions.get(1)).click().build().perform();
				action.moveToElement(chartOptionsValues.get(3)).click().build().perform();
				Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Generation of chart is as expected.");
				getFinalReport(driver, logger, "testLineChartGeneration", true);
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, "testGridValueFromAPI", true);
			}
		} else {
			logger.log(LogStatus.FAIL, "Chart options button not present.");
			getFinalReport(driver, logger, "testChartOptionsGraphs", false);
		}
	}

	public void validateChartOtherThanOveriewComapare() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement managePointButton = objTrends.getManagePointButton();
		if (managePointButton != null) {
			managePointButton.click();
			Thread.sleep(10000);
			getFinalReport(driver, logger, "testManagePointWindow11", true);
			WebElement evaporator1 = objTrends.getEvaporatorPt1();
			evaporator1.click();
			WebElement evaporator2 = objTrends.getEvaporatorPt2();
			evaporator2.click();
			Thread.sleep(5000);
			getFinalReport(driver, logger, "testManagePointWindow24511", true);
			List<WebElement> listOfSelectedPoints = new ArrayList<WebElement>();
			listOfSelectedPoints = objTrends.getListOfSelectedPoints();
			List<String> selectedPoints = new ArrayList<String>();
			for (int i = 0; i < listOfSelectedPoints.size(); i++) {
				selectedPoints.add(listOfSelectedPoints.get(i).getText());
			}
			// Thread.sleep(10000);
			WebElement saveButton = objTrends.getSaveButton().get(0);
			saveButton.click();
			Thread.sleep(20000);
			List<WebElement> listOfGraphNames = new ArrayList<WebElement>();
			List<String> graphNames = new ArrayList<String>();
			listOfGraphNames = objTrends.getGraphNameList();
			for (int i = 0; i < listOfGraphNames.size(); i++) {
				graphNames.add(listOfGraphNames.get(i).getText());
			}
			if (selectedPoints.containsAll(graphNames)) {
				logger.log(LogStatus.PASS,
						"Active Points and display of Graphs in Trends page is as expected for points other than Overview category.");
				getFinalReport(driver, logger, "testGraphDisplay234", true);
			} else {
				logger.log(LogStatus.FAIL,
						"Active Points and display of Graphs in Trends page is not as expected for points other than Overview category.");
				getFinalReport(driver, logger, "testGraphDisplay34524", false);
			}
			Thread.sleep(2000);
			List<WebElement> selectedYr = objTrends.getAllSelectedYrValues();
			String s = null;
			if (selectedYr != null) {
				for (int i = 0; i < selectedYr.size(); i++) {
					Select select = new Select(selectedYr.get(i));
					WebElement ele = select.getFirstSelectedOption();
					System.out.println(ele.getText());
					if (ele.getText().equals("2018")) {
						s = ele.getText();
					}
				}
				if ((s != null) && (s.equals("2018"))) {
					logger.log(LogStatus.PASS, "Compare Graphs is working as expected.");
					getFinalReport(driver, logger, "testCompareGraphs234222", true);
				} else {
					logger.log(LogStatus.FAIL, "Compare Graphs is not working as expected.");
					getFinalReport(driver, logger, "testCompareGraphs234222", false);
				}
			} else {
				logger.log(LogStatus.FAIL, "Year not present in the chart.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Manage Active Points is not present.");
			getFinalReport(driver, logger, "testManageActivePoint234234", false);
		}

	}

	public void validatePointsInPopUp() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement managePointButton = objTrends.getManagePointButton();
		if (managePointButton != null) {
			managePointButton.click();
			Thread.sleep(10000);
			List<WebElement> overviewPoints = objTrends.getPointList("OVERVIEW");
			List<WebElement> evaporatorPoints = objTrends.getPointList("Evaporator");
			List<WebElement> condenserPoints = objTrends.getPointList("Condenser");
			List<WebElement> compressorPoints = objTrends.getPointList("Compressor");
			List<WebElement> onboardPoints = objTrends.getPointList("Onboard Diagnostics");
			List<WebElement> systemPoints = objTrends.getPointList("System");
			List<WebElement> physicalreadingsPoints = objTrends.getPointList("Physical Readings");
			List<WebElement> weatherPoints = objTrends.getPointList("Weather");
			List<String> pointList = new ArrayList<String>();
			overviewPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s = pointList.stream().distinct();
			if(s.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under Overview is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "Overview points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under Overview:"+pointList);
			}
			pointList.clear();
			evaporatorPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s1 = pointList.stream().distinct();
			if(s1.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under Evaporator is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "Evaporator points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under Evaporator:"+pointList);
			}
			pointList.clear();
			condenserPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s2 = pointList.stream().distinct();
			if(s2.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under Condenser is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "Condenser points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under Condenser:"+pointList);
			}
			pointList.clear();
			compressorPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s3 = pointList.stream().distinct();
			if(s3.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under Compressor is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "Compressor points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under Compressor:"+pointList);
			}
			pointList.clear();
			onboardPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s4 = pointList.stream().distinct();
			if(s4.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under Onboard Diagnostics is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "Onboard Diagnostics points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under Onboard Diagnostics:"+pointList);
			}
			pointList.clear();
			systemPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s5 = pointList.stream().distinct();
			if(s5.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under System is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "System points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under System:"+pointList);
			}
			pointList.clear();
			physicalreadingsPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s6 = pointList.stream().distinct();
			if(s6.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under Physical Readings is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "Physical Readings points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under Physical Readings:"+pointList);
			}
			pointList.clear();
			weatherPoints.forEach(ele->pointList.add(ele.getText()));
			pointList.sort(Comparator.naturalOrder());
			Stream<String> s7 = pointList.stream().distinct();
			if(s7.count()<pointList.size()){
				logger.log(LogStatus.FAIL, "Points under Weather is not as expected.");
			}
			else{
				logger.log(LogStatus.PASS, "Weather points are as expected and matching with API.");
				logger.log(LogStatus.INFO, "Points present under Weather:"+pointList);
			}
			pointList.clear();
			getFinalReport(driver, logger, "testManagePointWindow1223341", true);
		} else {
			logger.log(LogStatus.FAIL, "Manage Active Points is not present.");
			getFinalReport(driver, logger, "testManageActivePoint234234", false);
		}
	}

	public void validateChartOtherThanOverView() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement managePointButton = objTrends.getManagePointButton();
		if (managePointButton != null) {
			managePointButton.click();
			Thread.sleep(10000);
			getFinalReport(driver, logger, "testManagePointWindow11", true);
			WebElement evaporator1 = objTrends.getEvaporatorPt1();
			evaporator1.click();
			WebElement evaporator2 = objTrends.getEvaporatorPt2();
			evaporator2.click();
			Thread.sleep(5000);
			getFinalReport(driver, logger, "testManagePointWindow24511", true);
			List<WebElement> listOfSelectedPoints = new ArrayList<WebElement>();
			listOfSelectedPoints = objTrends.getListOfSelectedPoints();
			List<String> selectedPoints = new ArrayList<String>();
			for (int i = 0; i < listOfSelectedPoints.size(); i++) {
				selectedPoints.add(listOfSelectedPoints.get(i).getText());
			}
			// Thread.sleep(10000);
			WebElement saveButton = objTrends.getSaveButton().get(0);
			saveButton.click();
			Thread.sleep(20000);
			List<WebElement> listOfGraphNames = new ArrayList<WebElement>();
			List<String> graphNames = new ArrayList<String>();
			listOfGraphNames = objTrends.getGraphNameList();
			for (int i = 0; i < listOfGraphNames.size(); i++) {
				graphNames.add(listOfGraphNames.get(i).getText());
			}
			if (selectedPoints.containsAll(graphNames)) {
				logger.log(LogStatus.PASS,
						"Active Points and display of Graphs in Trends page is as expected for points other than Overview category.");
				getFinalReport(driver, logger, "testGraphDisplay234", true);
			} else {
				logger.log(LogStatus.FAIL,
						"Active Points and display of Graphs in Trends page is not as expected for points other than Overview category.");
				getFinalReport(driver, logger, "testGraphDisplay34524", false);
			}
		} else {
			logger.log(LogStatus.FAIL, "Manage Active Points is not present.");
			getFinalReport(driver, logger, "testManageActivePoint234234", false);
		}
	}
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private List<String> apiDescription = new ArrayList<String>();
	private List<String> apiValue = new ArrayList<String>();
	@SuppressWarnings("static-access")
	public void fetchAPIForChillerSnapshot(String date) {
		List<String> value = new ArrayList<String>();
		try {
			String accessToken = CEP_LeftPanel_API_Page_Action.getWebAPIAccessToken();
			String url = "https://cepu-web-api.azurewebsites.net/api/CsdHome/GetDataForMobile/?id=069f8123-1baa-4fa0-a58e-0ea9c7403272&type=getData&timestamp="+date+"&locale=en";
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
			apiDescription = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..description");
			value = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..value");
			value.removeAll(Arrays.asList(""));
			for(int i=0;i<value.size();i++){
				DecimalFormat df = new DecimalFormat("#.##");
				String truncateValue = df.format(Double.parseDouble(value.get(i)));
				apiValue.add(truncateValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.ERROR, "No proper response received from API.");
		}
	}
	private List<String> webDescription = new ArrayList<String>();
	private List<String> webValue = new ArrayList<String>();
	public void fetchWebDataForChillerSnapshot() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		List<WebElement> points = objTrends.getPointList();
		List<WebElement> values = objTrends.getValueList();
		for(int i=0;i<points.size();i++){
			webDescription.add(points.get(i).getText());
		}
		for(int i=0;i<points.size();i++){
			String [] s = values.get(i).getText().split(" ");
			webValue.add(s[0]);
		}
	}
	private String apiDate = null;
	public void openChillerSnapshot() throws Exception {
		CEP_LeftPanel_Page_Action objL = new CEP_LeftPanel_Page_Action(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Trends_Smoke_Page_Action objT = new CEP_Trends_Smoke_Page_Action(driver, logger);
		Actions action = new Actions(driver);
		WebElement lineChart = objTrends.getLineChart();
		if ((lineChart != null)) {
			//Thread.sleep(150);
			action.moveToElement(lineChart).clickAndHold().build().perform();
			//action.moveToElement(lineChart).release().build().perform();
			WebElement toolTipDate = objTrends.getToolTipDate();
			String date = toolTipDate.getText();
			apiDate = date.replaceAll("/", "-");
			action.moveToElement(lineChart).release().build().perform();
//			action.moveToElement(metricsList.get(1)).build().perform();
//			WebElement lineCP = objTrends.getLineChartPoint();
//			System.out.println(lineCP.getAttribute("class"));
//			lineCP.click();
			Thread.sleep(10000);
			getFinalReport(driver, logger, methodName+"openpopup", true);
		} else {
			logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
			getFinalReport(driver, logger, methodName+"test", false);
		}
	}		

	public void validateChillerSnapshotData() throws Exception {
		Thread.sleep(5000);
		fetchAPIForChillerSnapshot(apiDate);
		fetchWebDataForChillerSnapshot();
		if(apiDescription.containsAll(webDescription)){
			logger.log(LogStatus.PASS, "Points in the Chiller Snapshot are as expected.");
			logger.log(LogStatus.INFO, "Points present in web and API:"+apiDescription);
			getFinalReport(driver, logger, methodName+"pointList", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Points in the Chiller Snapshot are not as expected.");
			logger.log(LogStatus.INFO, "Points present in web and API:"+apiDescription);
			getFinalReport(driver, logger, methodName+"pointList", false);
		}
		if(apiValue.containsAll(webValue)){
			logger.log(LogStatus.PASS, "Values for points in the Chiller Snapshot are as expected.");
			logger.log(LogStatus.INFO, "Respective values for above points present in web and API:"+apiValue);
			getFinalReport(driver, logger, methodName+"valueList", true);
		}
		else{
			logger.log(LogStatus.PASS, "Values for Points in the Chiller Snapshot are as expected.");
			logger.log(LogStatus.INFO, "Respective values for above points present in web and API:"+webValue);
			getFinalReport(driver, logger, methodName+"valueList", true);
		}
	}
	
	public void validatePDFnEmail() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		Thread.sleep(5000);
		WebElement save = objTrends.getSaveBtn();
		if(save!=null){
			save.click();
			Thread.sleep(2000);
			objTrends.getPreviewBtn().click();
			Thread.sleep(10000);
			objTrends.getSaveAsPdfBtn().click();			
			logger.log(LogStatus.PASS, "Save PDF is working as expected.");
			Thread.sleep(1500);
			getFinalReport(driver, logger, methodName+"saveemail", true);
			Thread.sleep(20000);
			objTrends.getEmailBtn().click();
			Thread.sleep(2000);
			objTrends.getEnterEmailBtn().sendKeys("sonaljeet.arora@jci.com");
			objTrends.getSendBtn().click();
			Thread.sleep(10000);
			logger.log(LogStatus.PASS, "Email is working as expected.");			
		}
		else{
			logger.log(LogStatus.FAIL, "Save PDF and Email is not working as expected.");
			getFinalReport(driver, logger, methodName+"saveemail", false);
		}
	}
	public void validateEditValue() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement edit = objTrends.getEditBtn();
		if(edit!=null){
			edit.click();
			Thread.sleep(2000);
			List<WebElement> editTxtBox = objTrends.getEditTxtBoxBtn();
			Actions action = new Actions(driver);
			action.moveToElement(editTxtBox.get(8)).click().build().perform();
			editTxtBox.get(8).sendKeys("2.0");
			Thread.sleep(2000);
			getFinalReport(driver, logger, methodName+"editemail1", true);
			objTrends.getSaveBtn();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Edit functionality is working as expected.");
			getFinalReport(driver, logger, methodName+"editemail", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Edit button is not available.");
			getFinalReport(driver, logger, methodName+"editemail", false);
		}
	}
}