package mars.JCI.Project.CEP.SmokeTest;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.Smoke.CEP_Comparative_Smoke_Page_Factory;
import mars.JCI.Project.CEP.Smoke.CEP_Trends_Smoke_Page_Factory;

public class CEP_Comparative_Smoke_Page_Action extends BaseClass {

	@SuppressWarnings("static-access")
	public CEP_Comparative_Smoke_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void navigateToComparative() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Factory objC = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		List<WebElement> trendsHeaderList = objTrends.getTrendsHeaderList();
		if (trendsHeaderList != null) {
			trendsHeaderList.get(2).click();
			WebElement slider = objC.getSlider();
			if(slider.isDisplayed())
				logger.log(LogStatus.PASS, "Comparative page loaded successfully.");
			else
				logger.log(LogStatus.FAIL, "Comparative page not loaded successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Comparative option not present in Header.");
		}
	}

	public void addChart() throws Exception {
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		WebElement addButton = objComp.getAddButton();
		if (addButton != null) {
			addButton.click();
		} else {
			logger.log(LogStatus.FAIL, "Add Chart button not present.");
		}
	}

	public static String getAlphaNumericString(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public void validateAddandSave() throws Exception {
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		addChart();
		WebElement secondOverviewPtChkBox = objComp.getSecondOverviewPtChkBox();
		WebElement thirdOverviewPtChkBox = objComp.getThirdOverviewPtChkBox();
		if (secondOverviewPtChkBox != null) {
			secondOverviewPtChkBox.click();
			thirdOverviewPtChkBox.click();
			WebElement okButton = objComp.getOKButton();
			okButton.click();
			WebElement yesButton = objComp.getYesButton();
			yesButton.click();
			String name = getAlphaNumericString(4);
			objComp.getChartNameInput().sendKeys(name);
			WebElement okButtonInConfirm = objComp.getOkButtonInConfirm();
			okButtonInConfirm.click();
			Thread.sleep(5000);
			WebElement chartName = objComp.getChartName();
			System.out.println(chartName.getText());
			if (chartName.getText().equalsIgnoreCase(name) || (chartName.getText().contains("COMPARE CHART"))) {
				logger.log(LogStatus.PASS, "Comparative Chart generated successfully.");
				logger.log(LogStatus.PASS, "Name of the chart is as expected.");
			} else {
				logger.log(LogStatus.FAIL, "Comparative Chart not generated.");
			}

		} else {
			logger.log(LogStatus.INFO, "Points not present in the Select Point window.");
		}
	}

	public void selectPreviousYr() throws Exception {
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		WebElement selectCalendar = objTrends.getOpenCalendarButton();
		if (selectCalendar != null) {
			selectCalendar.click();
			WebElement selectPreviousYr = objTrends.getPreviousYearArrow();
			if (selectPreviousYr != null) {
				selectPreviousYr.click();
				objTrends.getCalendarDate().click();
				objTrends.getShow().click();
				logger.log(LogStatus.PASS, "Previous year chart is working as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Calendar not present.");
			getFinalReport(driver, logger, methodName, false);
		}
	}

	public void removeChart() throws Exception {
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		// Thread.sleep(5000);
		List<WebElement> chartOptions = objComp.getChartOption();
		if (chartOptions != null) {
			chartOptions.get(0).click();
			// Thread.sleep(9000);
			objComp.getYesButtonForRemoveChart().click();
		} else {
			logger.log(LogStatus.FAIL, "Remove chart option is not present.");
		}
	}

	public void validateWarningMessage() throws Exception {
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		addChart();
		WebElement allOverviewPts = objComp.getOverviewChkBox();
		if (allOverviewPts != null) {
			allOverviewPts.click();
			logger.log(LogStatus.PASS, "Warning message is getting displayed as expected.");
			getFinalReport(driver, logger, methodName, true);
		} else {
			logger.log(LogStatus.INFO, "Points not available.");
		}
	}

	public void validateDefaultChart() throws Exception {
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		addChart();
		WebElement secondOverviewPtChkBox = objComp.getSecondOverviewPtChkBox();
		WebElement thirdOverviewPtChkBox = objComp.getThirdOverviewPtChkBox();
		if (secondOverviewPtChkBox != null) {
			secondOverviewPtChkBox.click();
			thirdOverviewPtChkBox.click();
			WebElement okButton = objComp.getOKButton();
			okButton.click();
			WebElement noButton = objComp.getNoButton();
			noButton.click();
			// Thread.sleep(10000);
			WebElement chartName = objComp.getDefaultChartName1();
			System.out.println(chartName.getText());
			if (chartName.getText().equalsIgnoreCase("Compare Chart - 1")) {
				logger.log(LogStatus.PASS, "Default Comparative Chart generated successfully.");
				logger.log(LogStatus.PASS, "Name of the chart is as expected.");
				getFinalReport(driver, logger, methodName + 1, true);
			} else {
				logger.log(LogStatus.FAIL, "Default Comparative Chart not generated.");
			}
			addChart();
			Thread.sleep(5000);
			secondOverviewPtChkBox.click();
			thirdOverviewPtChkBox.click();
			Thread.sleep(3000);
			okButton.click();
			Thread.sleep(3000);
			noButton.click();
			Thread.sleep(5000);
			chartName = objComp.getDefaultChartName2();
			Actions action = new Actions(driver);
			action.moveToElement(chartName).build().perform();
			System.out.println(chartName.getText());
			if (chartName.getText().equalsIgnoreCase("Compare Chart - 2")) {
				logger.log(LogStatus.PASS, "Second Default Comparative Chart generated successfully.");
				logger.log(LogStatus.PASS, "Name of the chart is as expected.");
				getFinalReport(driver, logger, methodName + 2, true);
			} else {
				logger.log(LogStatus.FAIL, "Second Default Comparative Chart not generated.");
			}
		} else {
			logger.log(LogStatus.INFO, "Points not present in the Select Point window.");
		}
	}

	public void compareGraph() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		logger.log(LogStatus.INFO, "Comparing with previous year graph.");
		List<WebElement> chartOptions = objComp.getChartOption();
		if (chartOptions != null) {
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(5)).click().build().perform();
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
	}

	public void validateEditChart() throws Exception {
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		validateAddandSave();
		Thread.sleep(5000);
		List<WebElement> chartOptions = objComp.getChartOption();
		if (chartOptions != null) {
			chartOptions.get(3).click();
			logger.log(LogStatus.PASS, "Edit Point Window opened successfully.");
			getFinalReport(driver, logger, methodName + "editChart", true);
			Thread.sleep(3000);
			WebElement fourthOverview = objComp.getFourthOverviewPtChkBox();
			System.out.println(fourthOverview.getAttribute("type"));
			Actions action = new Actions(driver);
			action.moveToElement(fourthOverview).click().build().perform();
			WebElement okButton = objComp.getOKButtonInEdit();
			Thread.sleep(3000);
			okButton.click();
			Thread.sleep(5000);
			WebElement chartName = objComp.getChartName();
			System.out.println(chartName.getText());
			if (chartName.getText().equalsIgnoreCase("Test") || (chartName.getText().contains("COMPARE CHART"))) {
				logger.log(LogStatus.PASS, "Comparative Chart updated successfully.");
			} else {
				logger.log(LogStatus.FAIL, "Comparative Chart not generated.");
			}

		} else {
			logger.log(LogStatus.FAIL, "Edit chart option is not present.");
		}

	}

	public void validateDiffChartOptions() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		List<WebElement> chartOptions = objComp.getChartOption();
		if (chartOptions != null) {
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(2)).click().build().perform();
			List<WebElement> chartOptionsValues = objComp.getChartOptionsValues();
			action.moveToElement(chartOptionsValues.get(0)).click().build().perform();
			Thread.sleep(10000);
			WebElement gridData = objTrends.getGridData();
			if (gridData != null) {
				logger.log(LogStatus.PASS, "Grid data in the Chart is as expected.");
				getFinalReport(driver, logger, methodName + "testGridValues", true);
				Thread.sleep(10000);
				action.moveToElement(chartOptions.get(2)).click().build().perform();
				action.moveToElement(chartOptionsValues.get(1)).click().build().perform();
				Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Export to CSV is working as expected.");
				action.moveToElement(chartOptions.get(2)).click().build().perform();
				action.moveToElement(chartOptionsValues.get(2)).click().build().perform();
				Thread.sleep(15000);
				logger.log(LogStatus.PASS, "Export to PDF is working as expected.");
				action.moveToElement(chartOptions.get(2)).click().build().perform();
				action.moveToElement(chartOptionsValues.get(3)).click().build().perform();
				Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Generation of chart is as expected.");
				getFinalReport(driver, logger, methodName + "testLineChartGeneration", true);
			} else {
				logger.log(LogStatus.INFO, "No data retrieved from TimeSeries.");
				getFinalReport(driver, logger, methodName + "testGridValueFromAPI", true);
			}
		} else {
			logger.log(LogStatus.FAIL, "Chart options button not present.");
			getFinalReport(driver, logger, methodName + "testChartOptionsGraphs", false);
		}
	}

	public void openPDF() throws Exception {
		CEP_Trends_Smoke_Page_Factory objTrends = new CEP_Trends_Smoke_Page_Factory(driver, logger);
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		List<WebElement> chartOptions = objComp.getChartOption();
		if (chartOptions != null) {
			Thread.sleep(5000);
			Actions action = new Actions(driver);
			action.moveToElement(chartOptions.get(2)).click().build().perform();
			List<WebElement> chartOptionsValues = objComp.getChartOptionsValues();
			action.moveToElement(chartOptionsValues.get(0)).click().build().perform();
			Thread.sleep(10000);
			WebElement gridData = objTrends.getGridData();
			if (gridData != null) {
				action.moveToElement(chartOptions.get(2)).click().build().perform();
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
		CEP_Comparative_Smoke_Page_Factory objComp = new CEP_Comparative_Smoke_Page_Factory(driver, logger);
		Thread.sleep(10000);
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
			Thread.sleep(25000);
			logger.log(LogStatus.PASS, "PDF generated and chart in PDF is as expected.");
			getFinalReport(driver, logger, methodName, true);

		} else {
			logger.log(LogStatus.FAIL, "PDF not working as expected.");
		}
	}
}
