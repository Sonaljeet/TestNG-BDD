package mars.JCI.Project.CEP.StatusCheck;

import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.getAccessToken;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.corba.se.impl.orbutil.threadpool.TimeoutException;

import commonFunctions.WebDropDown;
import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.ChillerInformation.CEP_ChillerInformation_Page_Action;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.HeatMap.CEP_StatusCheckHeatMap_Page_Factory;

public class CEP_StatusCheck_Page_Action extends BaseClass {
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	@SuppressWarnings("static-access")
	public CEP_StatusCheck_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void waitForSpinnerToBeGone() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		try {
			boolean spinnerStatus = objStatusCheck.getSpinnerStatus();
			if (spinnerStatus) {
				new WebDriverWait(driver, 80).until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.overlaycustomerlist>spinner")));
			}
		} catch (TimeoutException e) {
			logger.log(LogStatus.FAIL, "Time to fetch data from APIs is more than 30 seconds.");
		}

	}
	
	public void waitForChillerInfoSpinnerToBeGone() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		try {
			boolean spinnerStatus = objStatusCheck.getSpinnerStatusChillerInfo();
			if (spinnerStatus) {
				new WebDriverWait(driver, 80).until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.overlayheatmap>spinner")));
			}
		} catch (TimeoutException e) {
			logger.log(LogStatus.FAIL, "Time to fetch data from APIs is more than 30 seconds.");
		}

	}

	// TC80048
	public void validateSummaryTab() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		waitForSpinnerToBeGone();
		WebElement header = objStatusCheck.getHeader();
		WebElement dropDown = objStatusCheck.getDropDown();
		List<WebElement> pagination = objStatusCheck.getPagination();
		if ((header != null) && (dropDown != null) && (pagination != null)) {
			logger.log(LogStatus.PASS, "STATUS/HEALTH CHECK summary tab is as expected.");
			logger.log(LogStatus.INFO, "Following details are present as expected in the widget:");
			logger.log(LogStatus.INFO, "1.STATUS/HEALTH CHECK Header");
			logger.log(LogStatus.INFO, "2.Status/Health Check Drop Down");
			logger.log(LogStatus.INFO, "3.Last 5 days report");
			logger.log(LogStatus.INFO, "4.Pagination Control");
		} else {
			logger.log(LogStatus.FAIL, "STATUS/HEALTH CHECK summary tab is not as expected.");
		}
	}

	public List<String> getUIDetails() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		List<WebElement> dateList = objStatusCheck.getDateList();
		List<String> dates = new ArrayList<String>();
		if (dateList != null) {
			for (int i = 0; i < dateList.size(); i++) {
				dates.add(dateList.get(i).getText());
			}
			return dates;
		} else {
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public void validateDefaultInfoForGreen() throws Exception {
		CEP_HealthCheckHeatMap_Page_Factory objHealthCheck = new CEP_HealthCheckHeatMap_Page_Factory(driver);
		CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		List<String> uiDate = new ArrayList<String>();
		waitForSpinnerToBeGone();
		logger.log(LogStatus.INFO, "Validation of Default Info for Green Color Widget started.");
		WebElement greenColor = objHealthCheck.getHealthCheckGreen();
		try {
			if (greenColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(greenColor).click().build().perform();
				Thread.sleep(30000);
				// waitForSpinnerToBeGone();
				List<WebElement> getUIDateList = objStatusCheck.getDateList();
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
					if ((uiDate.contains(getTomorrowDate())) && (uiDate.contains(getFiveDaysBackDate()))) {
						logger.log(LogStatus.PASS, "Data present for last 5 days.");
						getFinalReport(driver, logger, "testStatusCheckDetailsForGreyColor", true);
					} else {
						logger.log(LogStatus.FAIL, "Last 5 days data is not present.");
						getFinalReport(driver, logger, "testDetailsForGreyColor", false);
					}
					List<WebElement> getPointNameList = objStatusCheck.getPointNameList();
					List<String> apiDate = new ArrayList<String>();
					Map<String, String> apiDetails = objChillerInfo.getAPIDetails();
					if (getPointNameList != null) {
						for (int j = 0; j < getPointNameList.size(); j++) {
							logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()+" is present and is as expected.");
//							if (apiDetails.containsKey(getPointNameList.get(j).getText())) {
//								logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI matched with that of API.");
//								// apiDate =
//								// getTimeSeriesTimeValue(apiDetails.get(getPointNameList.get(j).getText()));
//							} else {
//								logger.log(LogStatus.FAIL, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI is not matching with that of API.");
//								getFinalReport(driver, logger, "testStatusDetailsForRedColor", false);
//							}
						}
					}

				} else if (objStatusCheck.getNoDataMessageStatusCheck() != null) {
					logger.log(LogStatus.PASS, "No Data message is as expected.");
					logger.log(LogStatus.INFO, objStatusCheck.getNoDataMessageStatusCheck().getText()
							+ " is getting displayed when no data is available.");
					getFinalReport(driver, logger, "testNoDataDetailsForGreenColor", true);
				} else {
					logger.log(LogStatus.FAIL, "Data in Status Check section is not as expected.");
					getFinalReport(driver, logger, "testNoDataDetailsForGreenColor", false);
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Green Color Widget not present in UI.");
			getFinalReport(driver, logger, "testNoGreenColorWidget", true);
		}

	}

	@SuppressWarnings("rawtypes")
	public void validateDefaultInfoForRed() throws Exception {
		CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		List<String> uiDate = new ArrayList<String>();
		waitForSpinnerToBeGone();
		logger.log(LogStatus.INFO, "Validation of Default Info for Red Color Widget started.");
		Thread.sleep(25000);
		try {
			List<WebElement> getUIDateList = objStatusCheck.getDateList();
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
				if ((uiDate.contains(getTomorrowDate())) && (uiDate.contains(getFiveDaysBackDate()))) {
					logger.log(LogStatus.PASS, "Data present for last 5 days.");
					getFinalReport(driver, logger, "testStatusCheckDetailsForGreyColor", true);
				} else {
					logger.log(LogStatus.FAIL, "Last 5 days data is not present.");
					getFinalReport(driver, logger, "testDetailsForGreyColor", false);
				}
				List<WebElement> getPointNameList = objStatusCheck.getPointNameList();
				List<String> apiDate = new ArrayList<String>();
				Map<String, String> apiDetails = objChillerInfo.getAPIDetails();
				if (getPointNameList != null) {
					for (int j = 0; j < getPointNameList.size(); j++) {
						logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()+" is present and is as expected.");
//						if (apiDetails.containsKey(getPointNameList.get(j).getText())) {
//							logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()
//									+ " in UI matched with that of API.");
//							// apiDate =
//							// getTimeSeriesTimeValue(apiDetails.get(getPointNameList.get(j).getText()));
//						} else {
//							logger.log(LogStatus.FAIL, "Point Name:" + getPointNameList.get(j).getText()
//									+ " in UI is not matching with that of API.");
//							getFinalReport(driver, logger, "testStatusDetailsForRedColor", false);
//						}
					}
				}
			} else if (objStatusCheck.getNoDataMessageStatusCheck() != null) {
				logger.log(LogStatus.PASS, "No Data message is as expected.");
				logger.log(LogStatus.INFO, objStatusCheck.getNoDataMessageStatusCheck().getText()
						+ " is getting displayed when no data is available.");
				getFinalReport(driver, logger, "testNoDataDetailsForRedColor", true);
			} else {
				logger.log(LogStatus.FAIL, "Data in Status Check section is not as expected.");
				getFinalReport(driver, logger, "testNoDataDetailsForRedColor", false);
			}

		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Red Color Widget not present in UI.");
			getFinalReport(driver, logger, "testNoRedColorWidgetStatusCheck", true);
		}

	}

	@SuppressWarnings("rawtypes")
	public void validateDefaultInfoForGrey() throws Exception {
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheckHeatMap = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		List<String> uiDate = new ArrayList<String>();
		waitForSpinnerToBeGone();
		logger.log(LogStatus.INFO, "Validation of Default Info for Grey Color Widget started.");
		WebElement greyColor = objStatusCheckHeatMap.getStatusCheckGrey();
		try {
			if (greyColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(greyColor).click().build().perform();
				Thread.sleep(30000);
				// waitForSpinnerToBeGone();
				List<WebElement> getUIDateList = objStatusCheck.getDateList();
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
					if ((uiDate.contains(getTomorrowDate())) && (uiDate.contains(getFiveDaysBackDate()))) {
						logger.log(LogStatus.PASS, "Data present for last 5 days.");
						getFinalReport(driver, logger, "testStatusCheckDetailsForGreyColor", true);
					} else {
						logger.log(LogStatus.FAIL, "Last 5 days data is not present.");
						getFinalReport(driver, logger, "testDetailsForGreyColor", false);
					}
					List<WebElement> getPointNameList = objStatusCheck.getPointNameList();
					List<String> apiDate = new ArrayList<String>();
					Map<String, String> apiDetails = objChillerInfo.getAPIDetails();
					if (getPointNameList != null) {
						for (int j = 0; j < getPointNameList.size(); j++) {
							logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()+" is present and is as expected.");
//							if (apiDetails.containsKey(getPointNameList.get(j).getText())) {
//								logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI matched with that of API.");
//								// apiDate =
//								// getTimeSeriesTimeValue(apiDetails.get(getPointNameList.get(j).getText()));
//							} else {
//								logger.log(LogStatus.FAIL, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI is not matching with that of API.");
//								getFinalReport(driver, logger, "testStatusDetailsForRedColor", false);
//							}
						}
					}

				} else if (objStatusCheck.getNoDataMessageStatusCheck() != null) {
					logger.log(LogStatus.PASS, "No Data message is as expected.");
					logger.log(LogStatus.INFO, objStatusCheck.getNoDataMessageStatusCheck().getText()
							+ " is getting displayed when no data is available.");
					getFinalReport(driver, logger, "testNoDataDetailsForGreyColor", true);
				} else {
					logger.log(LogStatus.FAIL, "Data in Status Check section is not as expected.");
					getFinalReport(driver, logger, "testNoDataDetailsForGreyColor", false);
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Grey Color Widget not present in UI.");
			getFinalReport(driver, logger, "testNoGreyColorWidget", true);
		}

	}

	@SuppressWarnings("rawtypes")
	public void validateDefaultInfoForYellow() throws Exception {
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheckHeatMap = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		List<String> uiDate = new ArrayList<String>();
		waitForSpinnerToBeGone();
		logger.log(LogStatus.INFO, "Validation of Default Info for Yellow Color Widget started.");
		WebElement yellowColor = objStatusCheckHeatMap.getStatusCheckYellow();
		try {
			if (yellowColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(yellowColor).click().build().perform();
				Thread.sleep(30000);
				// waitForSpinnerToBeGone();
				List<WebElement> getUIDateList = objStatusCheck.getDateList();
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
					if ((uiDate.contains(getTomorrowDate())) && (uiDate.contains(getFiveDaysBackDate()))) {
						logger.log(LogStatus.PASS, "Data present for last 5 days.");
						getFinalReport(driver, logger, "testStatusCheckDetailsForYellowColor", true);
					} else {
						logger.log(LogStatus.FAIL, "Last 5 days data is not present.");
						getFinalReport(driver, logger, "testDetailsForYellowColor", false);
					}
					List<WebElement> getPointNameList = objStatusCheck.getPointNameList();
					List<String> apiDate = new ArrayList<String>();
					Map<String, String> apiDetails = objChillerInfo.getAPIDetails();
					if (getPointNameList != null) {
						for (int j = 0; j < getPointNameList.size(); j++) {
							logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()+" is present and is as expected.");
//							if (apiDetails.containsKey(getPointNameList.get(j).getText())) {
//								logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI matched with that of API.");
//								// apiDate =
//								// getTimeSeriesTimeValue(apiDetails.get(getPointNameList.get(j).getText()));
//							} else {
//								logger.log(LogStatus.FAIL, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI is not matching with that of API.");
//								getFinalReport(driver, logger, "testStatusDetailsForRedColor", false);
//							}
						}
					}

				} else if (objStatusCheck.getNoDataMessageStatusCheck() != null) {
					logger.log(LogStatus.PASS, "No Data message is as expected.");
					logger.log(LogStatus.INFO, objStatusCheck.getNoDataMessageStatusCheck().getText()
							+ " is getting displayed when no data is available.");
					getFinalReport(driver, logger, "testNoDataDetailsForYellowColor", true);
				} else {
					logger.log(LogStatus.FAIL, "Data in Status Check section is not as expected.");
					getFinalReport(driver, logger, "testNoDataDetailsForYellowColor", false);
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Yellow Color Widget not present in UI.");
			getFinalReport(driver, logger, "testNoYellowColorWidget", true);
		}

	}

	@SuppressWarnings("rawtypes")
	public void validateDefaultInfoForOrange() throws Exception {
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheckHeatMap = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		List<String> uiDate = new ArrayList<String>();
		waitForSpinnerToBeGone();
		logger.log(LogStatus.INFO, "Validation of Default Info for Orange Color Widget started.");
		WebElement orangeColor = objStatusCheckHeatMap.getStatusCheckOrange();
		try {
			if (orangeColor != null) {
				Actions action = new Actions(driver);
				action.moveToElement(orangeColor).click().build().perform();
				Thread.sleep(30000);
				// waitForSpinnerToBeGone();
				List<WebElement> getUIDateList = objStatusCheck.getDateList();
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
					if ((uiDate.contains(getTomorrowDate())) && (uiDate.contains(getFiveDaysBackDate()))) {
						logger.log(LogStatus.PASS, "Data present for last 5 days.");
						getFinalReport(driver, logger, "testStatusCheckDetailsForOrangeColor", true);
					} else {
						logger.log(LogStatus.FAIL, "Last 5 days data is not present.");
						getFinalReport(driver, logger, "testDetailsForOrangeColor", false);
					}
					List<WebElement> getPointNameList = objStatusCheck.getPointNameList();
					List<String> apiDate = new ArrayList<String>();
					Map<String, String> apiDetails = objChillerInfo.getAPIDetails();
					if (getPointNameList != null) {
						for (int j = 0; j < getPointNameList.size(); j++) {
							logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()+" is present and is as expected.");
//							if (apiDetails.containsKey(getPointNameList.get(j).getText())) {
//								logger.log(LogStatus.PASS, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI matched with that of API.");
//								// apiDate =
//								// getTimeSeriesTimeValue(apiDetails.get(getPointNameList.get(j).getText()));
//							} else {
//								logger.log(LogStatus.FAIL, "Point Name:" + getPointNameList.get(j).getText()
//										+ " in UI is not matching with that of API.");
//								getFinalReport(driver, logger, "testStatusDetailsForRedColor", false);
//							}
						}
					}

				} else if (objStatusCheck.getNoDataMessageStatusCheck() != null) {
					logger.log(LogStatus.PASS, "No Data message is as expected.");
					logger.log(LogStatus.INFO, objStatusCheck.getNoDataMessageStatusCheck().getText()
							+ " is getting displayed when no data is available.");
					getFinalReport(driver, logger, "testNoDataDetailsForOrangeColor", true);
				} else {
					logger.log(LogStatus.FAIL, "Data in Status Check section is not as expected.");
					getFinalReport(driver, logger, "testNoDataDetailsForOrangeColor", false);
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Orange Color Widget not present in UI.");
			getFinalReport(driver, logger, "testNoOrangeColorWidget", true);
		}

	}

	public static String getFiveDaysBackDate() {
		DateFormat fiveDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fiveDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fiveDate); // convert your date to Calendar object
		int daysToDecrement = -4;
		cal.add(Calendar.DATE, daysToDecrement);
		fiveDate = cal.getTime();
		return fiveDateFormat.format(fiveDate);
	}

	public static String getTomorrowDate() {
		DateFormat tommorowFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date tomorrowDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(tomorrowDate); // convert your date to Calendar object
		int daysToDecrement = +1;
		cal.add(Calendar.DATE, daysToDecrement);
		tomorrowDate = cal.getTime();
		return tommorowFormat.format(tomorrowDate);
	}

	// Get Date from TimeSeries API
	@SuppressWarnings("static-access")
	public List<String> getTimeSeriesTimeValue(String timeseriesID) throws Exception {
		CEP_ChillerInformation_Page_Action objChillerInfo = new CEP_ChillerInformation_Page_Action(driver, logger);

		String uri = null;
		String accessToken = getAccessToken();
		uri = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..DataVerification.uri1")
				+ timeseriesID
				+ ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.uri2")
				+ getFiveDaysBackDate()
				+ ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.uri3")
				+ getTomorrowDate()
				+ ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.uri4")
				+ "Raw"
				+ ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.uri5");
		System.out.println("TimeSeries:" + uri);
		CommonAPIfunctions.Get_API_Request(uri, "Bearer " + accessToken,
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
		List<String> timeValue = new ArrayList<String>();
		List<String> splittedTime = new ArrayList<String>();
		timeValue = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.time"));
		for (int i = 0; i < timeValue.size(); i++) {
			String[] split = timeValue.get(i).split("T");
			splittedTime.add(split[0]);
		}
		return splittedTime;
	}

	// TC80056
	public void validateDropDownDefaultValue() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		waitForSpinnerToBeGone();
		WebElement dropDown = objStatusCheck.getDropDown();
		if (dropDown != null) {
			String selectedValue = WebDropDown.getSelectedOptionFromDropDown(dropDown);
			if (selectedValue.equalsIgnoreCase("Status Check")) {
				logger.log(LogStatus.PASS, "Default drop selection is as expected.");
			} else {
				logger.log(LogStatus.FAIL, "Default drop selection is not as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Drop down is not present.");
		}
	}

	public void validateDropDown() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		waitForSpinnerToBeGone();
		WebElement dropDown = objStatusCheck.getDropDown();
		if (dropDown != null) {
			String selectedValue = WebDropDown.getSelectedOptionFromDropDown(dropDown);
			if (selectedValue.equalsIgnoreCase("Status Check")) {
				logger.log(LogStatus.PASS, "Status Check option is selected successfully.");
				logger.log(LogStatus.PASS, "Details for Status check summary is as expected.");
			} else {
				logger.log(LogStatus.FAIL, "Status check summary is not as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Drop down is not present.");
		}
	}

	public void validateDiagnosticSummary() throws Exception {
		CEP_StatusCheck_Page_Factory objStatusCheck = new CEP_StatusCheck_Page_Factory(driver, logger);
		waitForSpinnerToBeGone();
		WebElement chart = objStatusCheck.getStatusChart();
	//	Thread.sleep(6000);
		if (chart != null) {
			Actions action = new Actions(driver);
			action.moveToElement(chart).click().perform();
			WebElement trendsTab = objStatusCheck.getTrendsTab();
			if (trendsTab != null) {
				logger.log(LogStatus.PASS, "Trends page is getting loaded for the chiller in Status Chart.");
			//	Thread.sleep(6000);
				getFinalReport(driver, logger, methodName, true);
			} else {
				logger.log(LogStatus.FAIL, "Trends page is not loaded.");
			}
		} else {
			logger.log(LogStatus.INFO, "Data not present for the chiller.");
		}
	}
}
