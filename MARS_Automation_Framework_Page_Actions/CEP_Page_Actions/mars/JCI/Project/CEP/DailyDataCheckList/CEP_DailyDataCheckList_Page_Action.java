package mars.JCI.Project.CEP.DailyDataCheckList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsAPI.CommonAPI_Functions;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Factory;

import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.*;

public class CEP_DailyDataCheckList_Page_Action extends BaseClass {
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);
	private final String FILEPATH = "C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Reports\\mars\\JCI\\Project\\CEP\\TimeSeriesAPI_Report\\DailyDataChecklist.xlsx";
	private FileInputStream fis;
	private Workbook workbook;
	private Row row;
	private Sheet sheet;
	// Steps Definitions for DataVerification
	@Given("^user receive all point IDs for verification$")
	public List<String> readAllPointIDs() {
		return ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..DataVerification.pointID.*");

	}

	@When("^user hit the server with each point ID for different time intervals$")
	public void userHit() {

	}

	public static List<String> readAllMetric() {
		return ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..DataVerification.metric.*");

	}

	public static String getYesterdayDate() {
		DateFormat yesterdayDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date yesterdayDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(yesterdayDate); // convert your date to Calendar object
		int daysToDecrement = -1;
		cal.add(Calendar.DATE, daysToDecrement);
		yesterdayDate = cal.getTime();
		return yesterdayDateFormat.format(yesterdayDate);
	}

	public static String getYesterdayDateForDailyDelta() {
		DateFormat yesterdayDateFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Date yesterdayDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(yesterdayDate); // convert your date to Calendar object
		int daysToDecrement = -1;
		cal.add(Calendar.DATE, daysToDecrement);
		yesterdayDate = cal.getTime();
		return yesterdayDateFormat.format(yesterdayDate);
	}

	public static String getDayBeforeYesterdayDate() {
		DateFormat dayBeforeYesterdayDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date dayBeforeYesterdayDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dayBeforeYesterdayDate); // convert your date to Calendar
												// object
		int daysToDecrement = -2;
		cal.add(Calendar.DATE, daysToDecrement);
		dayBeforeYesterdayDate = cal.getTime();
		return dayBeforeYesterdayDateFormat.format(dayBeforeYesterdayDate);
	}

	public static String getCurrentDate() {
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Date currentDate = new Date();
		return currentDateFormat.format(currentDate);
	}

	public static String getEndTime() {
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.HOUR, -5);
		currentDate = cal.getTime();
		return currentDateFormat.format(currentDate);
	}

	public static String getStartTime() {
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.HOUR, -9);
		currentDate = cal.getTime();
		return currentDateFormat.format(currentDate);
	}

	public static String getEndTimeForYork() {
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.HOUR, -4);
		currentDate = cal.getTime();
		return currentDateFormat.format(currentDate);
	}

	public static String getStartTimeForYork() {
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.HOUR, -8);
		currentDate = cal.getTime();
		return currentDateFormat.format(currentDate);
	}

	@SuppressWarnings("resource")
	public void updateStartandEndTime() throws IOException {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellTestTime, cellStartTime, cellEndTime;
		Sheet sheet;
		String startTime = getStartTime();
		String endTime = getEndTime();
		fis = new FileInputStream(FILEPATH);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("RealtimeData");
		for (int iRowNumber = 1; iRowNumber < sheet.getLastRowNum(); iRowNumber++) {
			row = sheet.getRow(iRowNumber);
			cellTestTime = row.createCell(0);
			cellTestTime.setCellValue(startTime);
			cellStartTime = row.createCell(7);
			cellStartTime.setCellValue(startTime);
			cellEndTime = row.createCell(8);
			cellEndTime.setCellValue(endTime);
			FileOutputStream fos = new FileOutputStream(FILEPATH);
			workbook.write(fos);
		}

	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Then("^user should receive proper response and data for metric from the server$")
	public void receiveResponse() {
		List<String> pointID = new ArrayList<String>();
		pointID = readAllPointIDs();
		List<String> metric = new ArrayList<String>();
		metric = readAllMetric();
		// List<String> apiMetric = new ArrayList<String>();
		List<String> metricResponse = new ArrayList<String>();
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cell, cellTestTime, cellStartTime, cellEndTime;
		Sheet sheet;
		String uri = null;
		String startTime = getStartTime();
		String endTime = getEndTime();
		try {
			String accessToken = getAccessToken();
			updateStartandEndTime();
			for (int iPointIDCounter = 0; iPointIDCounter < pointID.size(); iPointIDCounter++) {
				if (iPointIDCounter == 33 || iPointIDCounter == 34 || iPointIDCounter == 35 || iPointIDCounter == 36
						|| iPointIDCounter == 37 || iPointIDCounter == 38) {
					startTime = getStartTimeForYork();
					endTime = getEndTimeForYork();
				}
				int iColCount = 9;
				for (int iMetricCounter = 0; iMetricCounter < metric.size(); iMetricCounter++) {

					if (metric.get(iMetricCounter).equalsIgnoreCase("DailyDelta")) {
						uri = ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..DataVerification.uri1")
								+ pointID.get(iPointIDCounter)
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri2")
								+ getDayBeforeYesterdayDate() + "-06:00"
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri3")
								+ getYesterdayDateForDailyDelta() + "-06:00"
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri4")
								+ metric.get(iMetricCounter)
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri5");
						System.out.println(uri);
					} else {
						uri = ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..DataVerification.uri1")
								+ pointID.get(iPointIDCounter)
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri2")
								+ startTime + "-06:00"
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri3")
								+ endTime + "-06:00"
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri4")
								+ metric.get(iMetricCounter)
								+ ReadJsonFile.readJsonFileDynamic_firstentry(
										ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
										"$..DataVerification.uri5");
						System.out.println(uri);
					}

					logger.log(LogStatus.INFO, "ResponseCode for TimeSeries " + pointID.get(iPointIDCounter) + "->"
							+ metric.get(iMetricCounter) + ":");
					CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
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
					metricResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..DataVerification.apiMetric"));
					int iRowNumber = iPointIDCounter + 1;

					if (metricResponse.size() == 0) {
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);
						if ((row.getCell(iColCount).getStringCellValue().equalsIgnoreCase("NA"))) {
							iColCount++;
							continue;
						} else {
							cell = row.createCell(iColCount);
							CellStyle style = workbook.createCellStyle();
							style.setFillForegroundColor(IndexedColors.RED.getIndex());
							style.setFillPattern(CellStyle.SOLID_FOREGROUND);
							cell.setCellValue("No");
							cell.setCellStyle(style);
							// iColCount++;

						}
						System.out.println(iColCount);
						// iColCount++;
						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("Raw")) {
						// System.out.println("Raw");
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);
						cell = row.createCell(9);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);
						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("QuarterHourlyAverage")) {
						// System.out.println("Quarter");

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(10);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					}

					else if (metricResponse.contains("HourlyAverage")) {
						// System.out.println("HourlyAverage");

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(11);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("DailyAverage")) {
						// System.out.println("Daily");

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(12);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("QuarterHourlyStatus")) {

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(13);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("HourlyStatus")) {

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(14);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					}

					else if (metricResponse.contains("QuarterHourlyDelta")) {

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(15);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("HourlyDelta")) {

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(16);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("DailyDelta")) {

						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("RealtimeData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(17);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					}
					iColCount++;

				}

			}

		} catch (IndexOutOfBoundsException ie) {
			ie.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@And("^data for the given metric should be validated and details should be updated in excel$")
	public void validateData() {

	}

	// Steps Definitions for historical data
	@Given("^user receive all point IDs for historical verification$")
	public List<String> readAllHistoricalPointIDs() {
		return ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..HistoryDataVerification.pointID.*");

	}

	public static List<String> readAllMetricForHistoricalVerification() {
		return ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..HistoryDataVerification.metric.*");

	}

	@SuppressWarnings({ "static-access", "deprecation" })
	@Then("^user should receive proper response and data for metric from the server for historical verification$")
	public void receiveResponseForHistoricalData() {
		List<String> pointID = new ArrayList<String>();
		pointID = readAllHistoricalPointIDs();
		List<String> metric = new ArrayList<String>();
		metric = readAllMetricForHistoricalVerification();
		// List<String> apiMetric = new ArrayList<String>();
		List<String> metricResponse = new ArrayList<String>();
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cell;
		Sheet sheet;
		String uri = null;
		try {
			String accessToken = getAccessToken();
			for (int iPointIDCounter = 0; iPointIDCounter < pointID.size(); iPointIDCounter++) {
				for (int iMetricCounter = 0; iMetricCounter < metric.size(); iMetricCounter++) {

					uri = ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..HistoryDataVerification.uri1")
							+ pointID.get(iPointIDCounter)
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..HistoryDataVerification.uri2")
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..HistoryDataVerification.uri3")
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..HistoryDataVerification.uri4")
							+ metric.get(iMetricCounter)
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..HistoryDataVerification.uri5");
					System.out.println(uri);
					logger.log(LogStatus.INFO, "ResponseCode for TimeSeries " + pointID.get(iPointIDCounter) + "->"
							+ metric.get(iMetricCounter) + ":");
					CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
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
					metricResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..HistoryDataVerification.apiMetric"));
					if (metricResponse.size() == 0) {
						System.out.println("No data");
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);
						for (int iColCount = 10; iColCount < 17; iColCount++) {

							if ((row.getCell(iColCount).getStringCellValue().equalsIgnoreCase("NA"))
									|| (row.getCell(iColCount).getStringCellValue().equalsIgnoreCase("Yes"))) {
								continue;
							} else {
								cell = row.createCell(iColCount);
								CellStyle style = workbook.createCellStyle();
								style.setFillForegroundColor(IndexedColors.RED.getIndex());
								style.setFillPattern(CellStyle.SOLID_FOREGROUND);
								cell.setCellValue("No");
								cell.setCellStyle(style);
							}
						}
						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("QuarterHourlyAverage")) {
						// System.out.println("Quarter");
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(10);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					}

					else if (metricResponse.contains("HourlyAverage")) {
						// System.out.println("HourlyAverage");
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(11);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("DailyAverage")) {
						// System.out.println("Daily");
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(12);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("QuarterHourlyStatus")) {
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(13);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("HourlyStatus")) {
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(14);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					}

					else if (metricResponse.contains("QuarterHourlyDelta")) {
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(15);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("HourlyDelta")) {
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(16);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else if (metricResponse.contains("DailyDelta")) {
						int iRowNumber = iPointIDCounter + 1;
						fis = new FileInputStream(FILEPATH);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("HistoryData");
						row = sheet.getRow(iRowNumber);

						cell = row.createCell(17);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cell.setCellValue("Yes");
						cell.setCellStyle(style);

						FileOutputStream fos = new FileOutputStream(FILEPATH);
						workbook.write(fos);
					} else {
						String otherValue = metricResponse.get(0);
						if (metric.get(iMetricCounter).equalsIgnoreCase("QuarterHourlyAverage")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(10);
							cell.setCellValue(otherValue);
						} else if (metric.get(iMetricCounter).equalsIgnoreCase("HourlyAverage")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(11);
							cell.setCellValue(otherValue);
						} else if (metric.get(iMetricCounter).equalsIgnoreCase("DailyAverage")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(12);
							cell.setCellValue(otherValue);
						} else if (metric.get(iMetricCounter).equalsIgnoreCase("QuarterHourlyStatus")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(13);
							cell.setCellValue(otherValue);
						} else if (metric.get(iMetricCounter).equalsIgnoreCase("HourlyStatus")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(14);
							cell.setCellValue(otherValue);
						} else if (metric.get(iMetricCounter).equalsIgnoreCase("QuarterHourlyDelta")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(15);
							cell.setCellValue(otherValue);
						} else if (metric.get(iMetricCounter).equalsIgnoreCase("HourlyDelta")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(16);
							cell.setCellValue(otherValue);
						} else if (metric.get(iMetricCounter).equalsIgnoreCase("DailyDelta")) {
							int iRowNumber = iPointIDCounter + 1;
							fis = new FileInputStream(FILEPATH);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheet("HistoryData");
							row = sheet.getRow(iRowNumber);
							cell = row.createCell(17);
							cell.setCellValue(otherValue);
						}

					}

				}

			}

		} catch (IndexOutOfBoundsException ie) {
			ie.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@And("^historical data for the given metric should be validated and details should be updated in excel$")
	public void validateHistoricalData() {

	}

	// Steps definition for Data Comparison
	public List<String> fetchCSDTime() {
		String csvFile = "C:/Users/jaroraso/Downloads/SAM HOUSTON STATE WOODLANDS_YMC2 Chiller 1_2018_3_LEAVING_CHW_TEMP.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<String> csvTime = new ArrayList<String>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			List<String> timeList = new ArrayList<String>();
			int i = 0;
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] time = line.split(cvsSplitBy);
				timeList.add(time[0]);
			}
			for (i = 1; i < timeList.size(); i++) {
				csvTime.add((timeList.get(i).replace("\"", "")));
			}
			return csvTime;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Double> fetchCSDTemperature() {
		String csvFile = "C:/Users/jaroraso/Downloads/SAM HOUSTON STATE WOODLANDS_YMC2 Chiller 1_2018_3_LEAVING_CHW_TEMP.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<Double> csvDouble = new ArrayList<Double>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			List<String> temperatureList = new ArrayList<String>();
			int i = 0;
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] temperature = line.split(cvsSplitBy);
				temperatureList.add(temperature[1]);
			}
			for (i = 1; i < temperatureList.size(); i++) {
				csvDouble.add(Double.parseDouble(temperatureList.get(i).replace("\"", "")));
			}
			System.out.println(csvDouble.get(0));
			return csvDouble;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@SuppressWarnings("static-access")
	@Given("^data from API and prod should be available$")
	public Map<String, String> getCEPAPIData() {
		List<Double> getTemperatureFromResponse = new ArrayList<Double>();
		List<String> getTimeFromResponse = new ArrayList<String>();
		Map<String, String> getCEPAPIData = new HashMap<String, String>();
		// List<Double> metricTemperature = new ArrayList<Double>();
		String uri = null;
		try {
			String accessToken = getProdAccessToken();
			uri = ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..DataVerification.uri1")
					+ "12904c6d-d523-4de7-b3fb-7b41ed1e2d47"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri2")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri3")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri4")
					+ "Raw"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri5");
			System.out.println(uri);
			CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
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
			getTimeFromResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.time"));
			getTemperatureFromResponse = ReadJsonFile.readJsonFileDynamicDouble(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.tempVal"));
			for (int iCount = 0; iCount < getTimeFromResponse.size(); iCount++) {
				DecimalFormat df = new DecimalFormat("#.0");
				String truncateTemp = df.format(getTemperatureFromResponse.get(iCount));
				String[] split = getTimeFromResponse.get(iCount).split("T");
				String s1 = split[0].substring(5, 7);
				String s2 = split[0].substring(8, 10);
				String s3 = split[0].substring(0, 4);
				String finalDate = s1 + "/" + s2 + "/" + s3;
				String timeStamp = split[1].substring(0, 8);
				String time = finalDate + " " + timeStamp;
				getCEPAPIData.put(time, truncateTemp);
			}

			return getCEPAPIData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@When("^user compare both data$")
	public void userCompareData() {

	}

	@Then("^data should match and status should get updated in the sheet$")
	public void compare() {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellCSDTime, cellCSDTemp, cellCEPTime, cellCEPTemp, cellStatus;
		Sheet sheet;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CSDvsCEPAPI_Historical_TimeSeriesDataStatus.xlsx";
		try {
			Map<String, String> apiData = getCEPAPIData();
			List<Double> getCSVTemperature = fetchCSDTemperature();
			List<String> getCSVTime = fetchCSDTime();
			// int iCount = 0;
			int iRowNumber = 1;
			for (Map.Entry m : apiData.entrySet()) {
				int iColNumber = 0;
				if (getCSVTime.contains(m.getKey().toString())) {
					int index = getCSVTime.indexOf(m.getKey().toString());
					if (m.getValue().equals(getCSVTemperature.get(index).toString())) {
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("YMC2Ch2_VSD IP-KWH");
						row = sheet.createRow(iRowNumber);
						cellCSDTime = row.createCell(iColNumber);
						cellCSDTime.setCellValue(getCSVTime.get(index));
						cellCSDTemp = row.createCell(iColNumber + 1);
						cellCSDTemp.setCellValue(getCSVTemperature.get(index));
						cellCEPTime = row.createCell(iColNumber + 2);
						cellCEPTime.setCellValue(m.getKey().toString());
						cellCEPTemp = row.createCell(iColNumber + 3);
						cellCEPTemp.setCellValue(m.getValue().toString());
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cellStatus = row.createCell(iColNumber + 4);
						cellStatus.setCellValue("Matched");
						cellStatus.setCellStyle(style);
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);
					} else {
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("YMC2Ch2_VSD IP-KWH");
						row = sheet.createRow(iRowNumber);
						cellCSDTime = row.createCell(iColNumber);
						cellCSDTime.setCellValue(getCSVTime.get(index));
						cellCSDTemp = row.createCell(iColNumber + 1);
						cellCSDTemp.setCellValue(getCSVTemperature.get(index));
						cellCEPTime = row.createCell(iColNumber + 2);
						cellCEPTime.setCellValue(m.getKey().toString());
						cellCEPTemp = row.createCell(iColNumber + 3);
						cellCEPTemp.setCellValue(m.getValue().toString());
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.RED.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cellStatus = row.createCell(iColNumber + 4);
						cellStatus.setCellValue("Not Matched");
						cellStatus.setCellStyle(style);
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);

					}
					iRowNumber++;
					// iCount++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// alternate approach to fetch CEP API Data(Time and Temperature)
	@SuppressWarnings("static-access")
	public List<String> getCEPAPITime() {
		List<String> getTimeFromResponse = new ArrayList<String>();
		List<String> cepAPITime = new ArrayList<String>();
		// List<Double> metricTemperature = new ArrayList<Double>();
		String uri = null;
		try {
			String accessToken = getAccessToken();
			uri = ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..DataVerification.uri1")
					+ "90884c63-dcd1-4b7f-bc4c-f26a550c3183"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri2")
					+ "-06:00"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri3")
					+ "-06:00"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri4")
					+ "Raw"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri5");
			System.out.println(uri);
			CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
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
			getTimeFromResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.time"));

			for (int iCount = 0; iCount < getTimeFromResponse.size(); iCount++) {
				String[] split = getTimeFromResponse.get(iCount).split("T");
				String s1 = split[0].substring(5, 7);
				String s2 = split[0].substring(8, 10);
				String s3 = split[0].substring(0, 4);
				String finalDate = s1 + "/" + s2 + "/" + s3;
				String timeStamp = split[1].substring(0, 8);
				String time = finalDate + " " + timeStamp;
				cepAPITime.add(time);
			}

			return cepAPITime;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("static-access")
	public List<String> getCEPAPITemp() {
		List<Double> getTemperatureFromResponse = new ArrayList<Double>();
		List<String> cepAPITemp = new ArrayList<String>();
		// List<Double> metricTemperature = new ArrayList<Double>();
		String uri = null;
		try {
			String accessToken = getAccessToken();
			uri = ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..DataVerification.uri1")
					+ "90884c63-dcd1-4b7f-bc4c-f26a550c3183"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri2")
					+ "-06:00"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri3")
					+ "-06:00"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri4")
					+ "Raw"
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri5");
			System.out.println(uri);
			CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
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
			getTemperatureFromResponse = ReadJsonFile.readJsonFileDynamicDouble(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.tempVal"));
			for (int iCount = 0; iCount < getTemperatureFromResponse.size(); iCount++) {
				DecimalFormat df = new DecimalFormat("#.#");
				String truncateTemp = df.format(getTemperatureFromResponse.get(iCount));
				cepAPITemp.add(truncateTemp);
			}

			return cepAPITemp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<String> getProdAPITime() {
		List<String> getTimeFromResponse = new ArrayList<String>();
		// List<Double> metricTemperature = new ArrayList<Double>();
		String uri = null;
		try {
			uri = ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ProdDataVerification.uri1")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.assetID")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri2")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.pointID")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri3")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.projectId")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri4")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri5")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri6");
			System.out.println(uri);
			CommonAPIfunctions.Get_API_Request_TimeSeries(uri, methodName);
			getTimeFromResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.time"));
			return getTimeFromResponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<String> getProdAPITemp() {
		List<String> getTemperatureFromResponse = new ArrayList<String>();
		List<String> prodTemp = new ArrayList<String>();
		String uri = null;
		try {
			uri = ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ProdDataVerification.uri1")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.assetID")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri2")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.pointID")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri3")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.projectId")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri4")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri5")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri6");
			System.out.println(uri);
			CommonAPIfunctions.Get_API_Request_TimeSeries(uri, methodName);
			getTemperatureFromResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.tempValCHWST"));
			for (int iCount = 0; iCount < getTemperatureFromResponse.size(); iCount++) {
				prodTemp.add(getTemperatureFromResponse.get(iCount));
			}

			return prodTemp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// Steps definition for DataComparisonAPI
	@SuppressWarnings("static-access")
	@Given("^data from prod API and CEP API should be available$")
	public void gettingCSDDataFromAPI() {

	}

	public Map<String, String> getProdAPIData() {
		List<String> getTemperatureFromResponse = new ArrayList<String>();
		List<String> getTimeFromResponse = new ArrayList<String>();
		Map<String, String> getProdAPIData = new HashMap<String, String>();
		// List<Double> metricTemperature = new ArrayList<Double>();
		String uri = null;
		try {
			uri = ReadJsonFile.readJsonFileDynamic_firstentry(
					ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
					"$..ProdDataVerification.uri1")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.assetID")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri2")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.pointID")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri3")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.projectId")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri4")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri5")
					+ ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.uri6");
			System.out.println(uri);
			CommonAPIfunctions.Get_API_Request_TimeSeries(uri, methodName);
			getTimeFromResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.time"));
			getTemperatureFromResponse = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..ProdDataVerification.tempValCHWST"));
			for (int iCount = 0; iCount < getTimeFromResponse.size(); iCount++) {
				getProdAPIData.put(getTimeFromResponse.get(iCount), getTemperatureFromResponse.get(iCount));
			}
			Map<String, String> getAverageProdAPIData = new HashMap<String, String>();
			// getAverageProdAPIData = updateCSDAverageTempData(getProdAPIData);
			// getAverageProdAPIData = updateCSDHourlyTempData(getProdAPIData);
			return getProdAPIData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static Map<String, String> updateCSDAverageTempData(Map<String, String> getCSDData) throws Exception {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellCSDTime, cellCSDTemp;
		List<String> timeList = new ArrayList<String>();
		List<Double> tempList = new ArrayList<Double>();
//		List<Double> sample = tempList.stream().filter(i->!tempList.contains(i))
//		.collect(Collectors.toList());
		Sheet sheet;
		int iRowNumber = 1;
		double averageTemp = 0.0;
		double totalTemp = 0.0;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CSDTempData.xlsx";
		Map<String, String> mapWithAverageTemp = new HashMap<String, String>();
		/*
		 * getCSDData = getCSDData.entrySet().stream().map(entry -> { if
		 * (entry.getValue().toString().isEmpty()) entry.setValue("0.0"); // set
		 * default value return entry;
		 * }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		 */
		getCSDData = getCSDData.entrySet().stream().filter(entry -> !entry.getValue().toString().isEmpty())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		TreeMap<String, String> tMap = new TreeMap<String, String>();
		tMap.putAll(getCSDData);
		// tMap.entrySet().removeIf(entry -> entry.getValue() == null);
		// tMap.values().removeIf(Objects::isNull);
		System.out.println("Size:" + tMap.size());
		for (Map.Entry mProd : tMap.entrySet()) {
			timeList.add(mProd.getKey().toString());
			tempList.add(Double.parseDouble(mProd.getValue().toString()));

			/*
			 * int iColNumber = 0; System.out.println("Adding Row:" +
			 * iRowNumber); fis = new FileInputStream(path); workbook = new
			 * XSSFWorkbook(fis); sheet = workbook.getSheet("Sheet2"); row =
			 * sheet.createRow(iRowNumber); cellCSDTime =
			 * row.createCell(iColNumber);
			 * cellCSDTime.setCellValue(mProd.getKey().toString()); cellCSDTemp
			 * = row.createCell(iColNumber + 1);
			 * cellCSDTemp.setCellValue(mProd.getValue().toString());
			 * FileOutputStream fos = new FileOutputStream(path);
			 * workbook.write(fos); workbook.close(); iRowNumber++;
			 * Thread.sleep(300);
			 */
		}
		for (int i = 0; i < timeList.size() - 14; i++) {
			// averageTemp=(Integer.parseInt(tempList.get(i))+Integer.parseInt(tempList.get(i+1))+Integer.parseInt(tempList.get(i+2))+Integer.parseInt(tempList.get(i+3))+Integer.parseInt(tempList.get(i+4))+Integer.parseInt(tempList.get(i+5))+Integer.parseInt(tempList.get(i+6))+Integer.parseInt(tempList.get(i+7))+Integer.parseInt(tempList.get(i+8))+Integer.parseInt(tempList.get(i+9))+Integer.parseInt(tempList.get(i+10))+Integer.parseInt(tempList.get(i+11))+Integer.parseInt(tempList.get(i+12))+Integer.parseInt(tempList.get(i+13))+Integer.parseInt(tempList.get(i+14)))/15;
			for (int j = 0; j < 15; j++) {
				totalTemp = tempList.get(i + j) + totalTemp;
			}
			/*
			 * averageTemp = (tempList.get(i) + tempList.get(i + 1) +
			 * tempList.get(i + 2) + tempList.get(i + 3) + tempList.get(i + 4) +
			 * tempList.get(i + 5) + tempList.get(i + 6) + tempList.get(i + 7) +
			 * tempList.get(i + 8) + tempList.get(i + 9) + tempList.get(i + 10)
			 * + tempList.get(i + 11) + tempList.get(i + 12) + tempList.get(i +
			 * 13) + tempList.get(i + 14)) / 15;
			 */
			averageTemp = totalTemp / 15;
			DecimalFormat df = new DecimalFormat("#.0");
			String truncateTemp = df.format(averageTemp);
			mapWithAverageTemp.put(timeList.get(i), truncateTemp);
			totalTemp = 0.0;
			System.out.println(truncateTemp);
		}
		/*
		 * for(Map.Entry m:mapWithAverageTemp.entrySet()){
		 * System.out.println("Adding"); int iColNumber = 0; fis = new
		 * FileInputStream(path); workbook = new XSSFWorkbook(fis); sheet =
		 * workbook.getSheet("Sheet2"); row = sheet.createRow(iRowNumber);
		 * cellCSDTime = row.createCell(iColNumber);
		 * cellCSDTime.setCellValue(m.getKey().toString()); cellCSDTemp =
		 * row.createCell(iColNumber + 1);
		 * cellCSDTemp.setCellValue(m.getValue().toString()); FileOutputStream
		 * fos = new FileOutputStream(path); workbook.write(fos);
		 * workbook.close(); iRowNumber++; Thread.sleep(300); }
		 */
		return mapWithAverageTemp;
	}

	public static Map<String, String> updateCSDHourlyTempData(Map<String, String> getCSDData) throws Exception {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellCSDTime, cellCSDTemp;
		List<String> timeList = new ArrayList<String>();
		List<Double> tempList = new ArrayList<Double>();
		Sheet sheet;
		int iRowNumber = 1;
		double averageTemp = 0.0;
		double totalTemp = 0.0;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CSDTempData.xlsx";
		Map<String, String> mapWithAverageTemp = new HashMap<String, String>();
		getCSDData = getCSDData.entrySet().stream().filter(entry -> !entry.getValue().toString().isEmpty())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		TreeMap<String, String> tMap = new TreeMap<String, String>();
		tMap.putAll(getCSDData);
		System.out.println("Size:" + tMap.size());
		for (Map.Entry mProd : tMap.entrySet()) {
			timeList.add(mProd.getKey().toString());
			tempList.add(Double.parseDouble(mProd.getValue().toString()));
		}
		for (int i = 0; i < timeList.size() - 59; i++) {
			for (int j = 0; j < 60; j++) {
				totalTemp = tempList.get(i + j) + totalTemp;
			}
			averageTemp = totalTemp / 60;
			DecimalFormat df = new DecimalFormat("#.0");
			String truncateTemp = df.format(averageTemp);
			mapWithAverageTemp.put(timeList.get(i), truncateTemp);
			totalTemp = 0.0;
			System.out.println(truncateTemp);
		}
		return mapWithAverageTemp;
	}

	@Then("^API data should match and status should get updated in the sheet$")

	// public void ignoreThen() {
	// }

	public void comapreCSDandCEPAPIData() {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellCSDTime, cellCSDTemp, cellCEPTime, cellCEPTemp, cellStatus;
		Sheet sheet;
		int iRowNumber = 1;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CSDvsCEPAPI_Real_TimeSeriesDataStatus.xlsx";
		try {
			Map<String, String> cepAPIData = getCEPAPIData();
			Map<String, String> prodAPIData = getProdAPIData();
			System.out.println("Comparison Started..");
			for (Map.Entry mProd : prodAPIData.entrySet()) {
				int iColNumber = 0;
				if (cepAPIData.containsKey(mProd.getKey())) {
					String cepTimeValue = cepAPIData.get(mProd.getKey());
					if (cepTimeValue.equals(mProd.getValue().toString())) {
						System.out.println("Data Matched");
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("YK CH-1_ACCOPHRS_Raw");
						row = sheet.createRow(iRowNumber);
						cellCSDTime = row.createCell(iColNumber);
						cellCSDTime.setCellValue(mProd.getKey().toString());
						cellCSDTemp = row.createCell(iColNumber + 1);
						cellCSDTemp.setCellValue(mProd.getValue().toString());
						cellCEPTime = row.createCell(iColNumber + 2);
						cellCEPTime.setCellValue(mProd.getKey().toString());
						cellCEPTemp = row.createCell(iColNumber + 3);
						cellCEPTemp.setCellValue(cepTimeValue);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cellStatus = row.createCell(iColNumber + 4);
						cellStatus.setCellValue("Matched");
						cellStatus.setCellStyle(style);
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);
						workbook.close();
					} else {
						System.out.println("Data not Matched");
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("YK CH-1_ACCOPHRS_Raw");
						row = sheet.createRow(iRowNumber);
						cellCSDTime = row.createCell(iColNumber);
						cellCSDTime.setCellValue(mProd.getKey().toString());
						cellCSDTemp = row.createCell(iColNumber + 1);
						cellCSDTemp.setCellValue(mProd.getValue().toString());
						cellCEPTime = row.createCell(iColNumber + 2);
						cellCEPTime.setCellValue(mProd.getKey().toString());
						cellCEPTemp = row.createCell(iColNumber + 3);
						cellCEPTemp.setCellValue(cepTimeValue);
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.RED.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cellStatus = row.createCell(iColNumber + 4);
						cellStatus.setCellValue("Not Matched");
						cellStatus.setCellStyle(style);
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);
						workbook.close();
					}
					iRowNumber++;
				} else {
					System.out.println("No record for " + mProd.getKey().toString() + "in CEP");
				}
			}
			System.out.println("Comparison Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Steps Definitions for GetPointIDCount Scenario
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	Map<String, String> assetIDProjectID = new HashMap<String, String>();

	@Given("^user connected to CEP DB$")
	public void userConnectedToCEPDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://ceppsql.database.windows.net;"
				+ "databaseName=ceppsqldb;user=jciazdeploy;password=jpv2Tur5wZpg7SJb;";
		try {

			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@And("^user fetched AssetID and ProjectID for all Assets$")
	public ResultSet userFetchedAssetDetails() {
		String sql = "Select AssetId, ProjectId, CustomerName, AssetName, TimezoneName from AssetDetails order by CustomerName;";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@When("^user hit the entity API for each Asset$")
	public void userHitEntityAPI() {
		System.out.println("User hitting entity to get count of Point ID");
	}

	@SuppressWarnings("static-access")
	@Then("^count of point ID for each assets should return in the response$")
	public void getPointIDCount() {
		ResultSet getAssetDetails = userFetchedAssetDetails();
		List<String> sqlID = new ArrayList<String>();
		List<String> assetName = new ArrayList<String>();
		List<String> assetID = new ArrayList<String>();
		List<String> projectID = new ArrayList<String>();
		String uri = null;
		List<String> getUnitType = new ArrayList<String>();
		List<String> getRuleType = new ArrayList<String>();
		List<String> getIsManualValue = new ArrayList<String>();
		List<String> getOnOffStatus = new ArrayList<String>();
		int iUnitCounter = 0;
		int iRuleCalculated = 0;
		int iRuleFault = 0;
		int iManualTrueCount = 0;
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellAssetName, cellAssetID, cellProjectID, cellCount, cellSales, cellCalculated, cellFault, cellIsManual,
				cellONOFFStatus;
		Sheet sheet;
		int iRowNumber = 1;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CEP_AssetDetails.xlsx";
		try {
			while (getAssetDetails.next()) {
				sqlID.add(getAssetDetails.getString("AssetSqlid"));
				assetName.add(getAssetDetails.getString("AssetName"));
				assetID.add(getAssetDetails.getString("AssetId").toLowerCase());
				projectID.add(getAssetDetails.getString("ProjectId").toLowerCase());
			}
			String accessToken = getAccessToken();
			int i = 1500;
			for (int iCount = 0; iCount < assetName.size(); iCount++) {
				if ((iCount == i) || (iCount == i + 500) || (iCount == i + 1000) || (iCount == i + 1500)
						|| (iCount == i + 2000) || (iCount == i + 2500) || (iCount == i + 3000) || (iCount == i + 3500)
						|| (iCount == i + 4000)) {
					accessToken = getAccessToken();
				}
				int iColNumber = 0;
				String uri2 = "('" + assetID.get(iCount) + "')";
				uri = ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..EntityAPI.uri") + uri2;
				System.out.println("URI:" + uri);
				CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter1"),
						projectID.get(iCount),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter2"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparametervalue2"),
						methodName);
				List<String> getPointIDs = new ArrayList<String>();
				getPointIDs = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPI.pointID"));
				getUnitType = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPI.unittype"));
				getRuleType = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPI.ruletype"));
				getIsManualValue = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPI.isManual"));
				getOnOffStatus = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPI.attribute"));
				getUnitType.removeIf(Objects::isNull);
				getRuleType.removeIf(Objects::isNull);
				for (int iUnitCount = 0; iUnitCount < getUnitType.size(); iUnitCount++) {
					if (getUnitType.get(iUnitCount).equalsIgnoreCase("Sales")) {
						iUnitCounter++;
					}
				}
				for (int iRuleCount = 0; iRuleCount < getRuleType.size(); iRuleCount++) {
					if (getRuleType.get(iRuleCount).equalsIgnoreCase("calculated")) {
						iRuleCalculated++;
					} else if (getRuleType.get(iRuleCount).equalsIgnoreCase("fault")) {
						iRuleFault++;
					}
				}
				for (int iManualCount = 0; iManualCount < getIsManualValue.size(); iManualCount++) {
					if (String.valueOf(getIsManualValue.get(iManualCount)).equalsIgnoreCase("true")) {
						iManualTrueCount++;
					}
				}
				fis = new FileInputStream(path);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheet("AssetDetails");
				row = sheet.createRow(iRowNumber);
				cellAssetName = row.createCell(iColNumber);
				cellAssetName.setCellValue(sqlID.get(iCount));
				cellAssetName = row.createCell(iColNumber + 1);
				cellAssetName.setCellValue(assetName.get(iCount));
				cellAssetID = row.createCell(iColNumber + 2);
				cellAssetID.setCellValue(assetID.get(iCount));
				cellProjectID = row.createCell(iColNumber + 3);
				cellProjectID.setCellValue(projectID.get(iCount));
				cellCount = row.createCell(iColNumber + 4);
				cellCount.setCellValue(getPointIDs.size());
				cellSales = row.createCell(iColNumber + 5);
				cellSales.setCellValue(iUnitCounter);
				cellCalculated = row.createCell(iColNumber + 6);
				cellCalculated.setCellValue(iRuleCalculated);
				cellFault = row.createCell(iColNumber + 7);
				cellFault.setCellValue(iRuleFault);
				cellIsManual = row.createCell(iColNumber + 8);
				cellIsManual.setCellValue(iManualTrueCount);
				if (getOnOffStatus.contains("ONOFFStatus")) {
					cellONOFFStatus = row.createCell(iColNumber + 9);
					cellONOFFStatus.setCellValue("Yes");
				} else {
					cellONOFFStatus = row.createCell(iColNumber + 9);
					cellONOFFStatus.setCellValue("No");
				}
				FileOutputStream fos = new FileOutputStream(path);
				workbook.write(fos);
				iRowNumber++;
				iUnitCounter = 0;
				iRuleCalculated = 0;
				iRuleFault = 0;
				iManualTrueCount = 0;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^the count should get updated in the excel sheet$")
	public void count() {
		System.out.println("Count updated in excel");
	}

	// Steps Definition for GetPointLatestTimeStamp

	@SuppressWarnings("static-access")
	@Given("^user hit entity and get all Point IDs$")
	public void getPointIDAttributeName() {
		userConnectedToCEPDB();
		List<String> sqlID = new ArrayList<String>();
		List<String> assetName = new ArrayList<String>();
		List<String> assetID = new ArrayList<String>();
		List<String> projectID = new ArrayList<String>();
		Map<String, String> pointIDCHWRT = new HashMap<String, String>();
		Map<String, String> pointIDCHWST = new HashMap<String, String>();
		ResultSet getAssetDetails = userFetchedAssetDetails();
		List<String> getPointIDs = new ArrayList<String>();
		List<String> getAttributeName = new ArrayList<String>();
		String entityURI = null;
		String timeseriesURI = null;
		List<String> timeStamp = new ArrayList<String>();
		List<String> timeStampCHWST = new ArrayList<String>();
		String uri = null;
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellAssetSqlID, cellAssetName, cellAssetID, cellProjectID, cellPointID, cellAttributeName, cellTime;
		Sheet sheet;
		int iRowNumber = 1;

		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CEP_PointStatus.xlsx";
		try {
			while (getAssetDetails.next()) {
				sqlID.add(getAssetDetails.getString("AssetSqlid"));
				assetName.add(getAssetDetails.getString("AssetName"));
				assetID.add(getAssetDetails.getString("AssetId").toLowerCase());
				projectID.add(getAssetDetails.getString("ProjectId").toLowerCase());
			}
			String accessToken = getAccessToken();
			int i = 500;
			for (int iCount = 3950; iCount < assetName.size(); iCount++) {
				if ((iCount == i) || (iCount == i + 500) || (iCount == i + 1000) || (iCount == i + 1500)
						|| (iCount == i + 2000) || (iCount == i + 2500) || (iCount == i + 3000) || (iCount == i + 3500)
						|| (iCount == i + 4000)) {
					accessToken = getAccessToken();
				}
				entityURI = ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..EntityAPIFiltered.uri1") + "('" + assetID.get(iCount)
						+ "')"
						+ ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.uri2");

				System.out.println(entityURI);
				CommonAPIfunctions.Get_API_Request_TimeSeries(entityURI, "Bearer " + accessToken,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter1"),
						projectID.get(iCount),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter2"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparametervalue2"),
						methodName);
				getPointIDs = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.pointID"));
				getAttributeName = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..EntityAPIFiltered.attributeName"));
				if (getAttributeName.contains("CHWR-T")) {
					for (int jCount = 0; jCount < getPointIDs.size(); jCount++) {
						int iColCount = 0;
						if (getAttributeName.get(jCount).equalsIgnoreCase("CHWR-T")) {
							timeseriesURI = ReadJsonFile
									.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile)
											.getProperty("Testdatafilelocation"), "$..TimeSeriesFiltered.uri1")
									+ getPointIDs.get(jCount)
									+ ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile
											.getInstance(configFile).getProperty("Testdatafilelocation"),
											"$..TimeSeriesFiltered.uri2");
							System.out.println("TimeSeries URI:" + timeseriesURI);
							CommonAPIfunctions.Get_API_Request_TimeSeries(timeseriesURI, "Bearer " + accessToken,
									ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile)
											.getProperty("Testdatafilelocation"), "$..APICommon.headerparameter1"),
									ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile)
											.getProperty("Testdatafilelocation"), "$..APICommon.headerparametervalue1"),
									ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile)
											.getProperty("Testdatafilelocation"), "$..APICommon.headerparameter2"),
									ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile)
											.getProperty("Testdatafilelocation"), "$..APICommon.headerparametervalue2"),
									methodName);
							timeStamp = ReadJsonFile
									.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
											ReadJsonFile.readJsonFileDynamic_firstentry(
													ReadPropertyFile.getInstance(configFile)
															.getProperty("Testdatafilelocation"),
													"$..TimeSeriesFiltered.timeStamp"));
							if (timeStamp.size() > 0) {
								fis = new FileInputStream(path);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheet("PointStatus");
								row = sheet.createRow(iRowNumber);
								cellAssetSqlID = row.createCell(iColCount);
								cellAssetSqlID.setCellValue(sqlID.get(iCount));
								cellAssetName = row.createCell(iColCount + 1);
								cellAssetName.setCellValue(assetName.get(iCount));
								cellAssetID = row.createCell(iColCount + 2);
								cellAssetID.setCellValue(assetID.get(iCount));
								cellProjectID = row.createCell(iColCount + 3);
								cellProjectID.setCellValue(projectID.get(iCount));
								cellPointID = row.createCell(iColCount + 4);
								cellPointID.setCellValue(getPointIDs.get(jCount));
								cellAttributeName = row.createCell(iColCount + 5);
								cellAttributeName.setCellValue(getAttributeName.get(jCount));
								cellTime = row.createCell(iColCount + 6);
								cellTime.setCellValue(timeStamp.get(0));
								FileOutputStream fos = new FileOutputStream(path);
								workbook.write(fos);

							} else if (timeStamp.size() == 0) {
								fis = new FileInputStream(path);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheet("PointStatus");
								row = sheet.createRow(iRowNumber);
								cellAssetSqlID = row.createCell(iColCount);
								cellAssetSqlID.setCellValue(sqlID.get(iCount));
								cellAssetName = row.createCell(iColCount + 1);
								cellAssetName.setCellValue(assetName.get(iCount));
								cellAssetID = row.createCell(iColCount + 2);
								cellAssetID.setCellValue(assetID.get(iCount));
								cellProjectID = row.createCell(iColCount + 3);
								cellProjectID.setCellValue(projectID.get(iCount));
								cellPointID = row.createCell(iColCount + 4);
								cellPointID.setCellValue(getPointIDs.get(jCount));
								cellAttributeName = row.createCell(iColCount + 5);
								cellAttributeName.setCellValue(getAttributeName.get(jCount));
								CellStyle style = workbook.createCellStyle();
								style.setFillForegroundColor(IndexedColors.RED.getIndex());
								style.setFillPattern(CellStyle.SOLID_FOREGROUND);
								cellTime = row.createCell(iColCount + 6);
								cellTime.setCellValue("No Data");
								cellTime.setCellStyle(style);
								FileOutputStream fos = new FileOutputStream(path);
								workbook.write(fos);

							}
							iRowNumber++;

						}
					}

				} else {
					updateExcelForCHWST(accessToken, getPointIDs, getAttributeName, sqlID.get(iCount),
							assetName.get(iCount), assetID.get(iCount), projectID.get(iCount), iRowNumber);
					iRowNumber++;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@SuppressWarnings("static-access")
	public void updateExcelForCHWST(String accessToken, List<String> pointIDs, List<String> attributeNames,
			String sqlID, String assetName, String assetID, String projectID, int iRowNumber) {
		int jCount = 0;
		String timeSeriesURI = null;
		List<String> timeStampCHWST = new ArrayList<String>();
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellAssetSqlID, cellAssetName, cellAssetID, cellProjectID, cellPointID, cellAttributeName, cellTime;
		Sheet sheet;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CEP_PointStatus.xlsx";
		try {
			for (jCount = 0; jCount < pointIDs.size(); jCount++) {
				int iColCount = 0;
				if (attributeNames.get(jCount).equalsIgnoreCase("CHWS-T")) {
					timeSeriesURI = ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..TimeSeriesFiltered.uri1")
							+ pointIDs.get(jCount)
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..TimeSeriesFiltered.uri2");
					System.out.println("TimeSeries URI:" + timeSeriesURI);
					CommonAPIfunctions.Get_API_Request_TimeSeries(timeSeriesURI, "Bearer " + accessToken,
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
					timeStampCHWST = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
							ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..TimeSeriesFiltered.timeStamp"));
					if (timeStampCHWST.size() > 0) {
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("PointStatus");
						row = sheet.createRow(iRowNumber);
						cellAssetSqlID = row.createCell(iColCount);
						cellAssetSqlID.setCellValue(sqlID);
						cellAssetName = row.createCell(iColCount + 1);
						cellAssetName.setCellValue(assetName);
						cellAssetID = row.createCell(iColCount + 2);
						cellAssetID.setCellValue(assetID);
						cellProjectID = row.createCell(iColCount + 3);
						cellProjectID.setCellValue(projectID);
						cellPointID = row.createCell(iColCount + 4);
						cellPointID.setCellValue(pointIDs.get(jCount));
						cellAttributeName = row.createCell(iColCount + 5);
						cellAttributeName.setCellValue(attributeNames.get(jCount));
						cellTime = row.createCell(iColCount + 6);
						cellTime.setCellValue(timeStampCHWST.get(0));
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);
					} else if (timeStampCHWST.size() == 0) {
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("PointStatus");
						row = sheet.createRow(iRowNumber);
						cellAssetSqlID = row.createCell(iColCount);
						cellAssetSqlID.setCellValue(sqlID);
						cellAssetName = row.createCell(iColCount + 1);
						cellAssetName.setCellValue(assetName);
						cellAssetID = row.createCell(iColCount + 2);
						cellAssetID.setCellValue(assetID);
						cellProjectID = row.createCell(iColCount + 3);
						cellProjectID.setCellValue(projectID);
						cellPointID = row.createCell(iColCount + 4);
						cellPointID.setCellValue(pointIDs.get(jCount));
						cellAttributeName = row.createCell(iColCount + 5);
						cellAttributeName.setCellValue(attributeNames.get(jCount));
						CellStyle style = workbook.createCellStyle();
						style.setFillForegroundColor(IndexedColors.RED.getIndex());
						style.setFillPattern(CellStyle.SOLID_FOREGROUND);
						cellTime = row.createCell(iColCount + 6);
						cellTime.setCellValue("No Data");
						cellTime.setCellStyle(style);
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);
					}

				} else {
					fis = new FileInputStream(path);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheet("PointStatus");
					row = sheet.createRow(iRowNumber);
					cellAssetSqlID = row.createCell(iColCount);
					cellAssetSqlID.setCellValue(sqlID);
					cellAssetName = row.createCell(iColCount + 1);
					cellAssetName.setCellValue(assetName);
					cellAssetID = row.createCell(iColCount + 2);
					cellAssetID.setCellValue(assetID);
					cellProjectID = row.createCell(iColCount + 3);
					cellProjectID.setCellValue(projectID);
					cellPointID = row.createCell(iColCount + 4);
					cellPointID.setCellValue("Null");
					cellAttributeName = row.createCell(iColCount + 5);
					cellAttributeName.setCellValue("Null");
					CellStyle style = workbook.createCellStyle();
					style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					cellTime = row.createCell(iColCount + 6);
					cellTime.setCellValue("NA");
					cellTime.setCellStyle(style);
					FileOutputStream fos = new FileOutputStream(path);
					workbook.write(fos);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("^user hit timeseries api for each point id$")
	public void userHittingTimeSeries() {
		System.out.println("User hittng timeseries api");
	}

	@SuppressWarnings("static-access")
	@Then("^latest timestamp should be avaialable as response$")
	public void getLatestTimeStamp() {
		System.out.println("Updating excel");
	}

	@And("^details should get updated in the excel$")
	public void udpateExcel() {
		System.out.println("Details updated in excel");
	}

	public static void connectCEPUATDB() {
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionURL = "jdbc:sqlserver://cepdsql.database.windows.net;"
				+ "databaseName=cepdsqldb;user=jciazdeploy;password=bLFJrb5RpcDX9VMH;";
		try {
			// System.load("C:/Users/jaroraso/Downloads/MicrosoftJDBCDriver6.2forSQLServer/sqljdbc_6.2/enu/auth/x64/sqljdbc_auth.dll");
			Class.forName(driverName);
			// System.out.println("Connecting");
			con = DriverManager.getConnection(connectionURL);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Steps definition for RulesData
	@SuppressWarnings("static-access")
	@Given("^user read data from rules json and update it on DB$")
	 //public void ignoreGivenForRulesData(){ //Already updated details in DB 
		//}
	
	 
	public void updateRulesAttributesInDB() {
		List<String> attributeList = new ArrayList<String>();
		List<String> modelList = new ArrayList<String>();
		List<String> ruleIDs = new ArrayList<String>();
		List<String> modelLength = new ArrayList<String>();
		List<String> ruleType = new ArrayList<String>();
		try {
			modelLength = ReadJsonFile.readJsonFileDynamic(
					"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Reports\\mars\\JCI\\Project\\CEP\\TimeSeriesAPI_Report\\ModelLength.json",
					"$..modellength[*]");
			attributeList = ReadJsonFile.readJsonFileDynamic(
					"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Reports\\mars\\JCI\\Project\\CEP\\TimeSeriesAPI_Report\\Rules.json",
					"$..entityruledef");
			modelList = ReadJsonFile.readJsonFileDynamic(
					"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Reports\\mars\\JCI\\Project\\CEP\\TimeSeriesAPI_Report\\Rules.json",
					"$..models[*]");
			ruleIDs = ReadJsonFile.readJsonFileDynamic(
					"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Reports\\mars\\JCI\\Project\\CEP\\TimeSeriesAPI_Report\\Rules.json",
					"$..id");
			ruleType=ReadJsonFile.readJsonFileDynamic(
					"C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Reports\\mars\\JCI\\Project\\CEP\\TimeSeriesAPI_Report\\Rules.json",
					"$..ruletype");
			
			connectCEPUATDB();
			st = con.createStatement();
			System.out.println("Size:" + modelLength.size());
			int length=0;
			for (int iLength = 0; iLength < modelLength.size(); iLength++) {
				System.out.println("Model" + iLength);
				if(ruleType.get(iLength).equalsIgnoreCase("fault")){
					System.out.println("RuleType:"+ruleType.get(iLength));
					String[] splitAttribute = attributeList.get(iLength).split("#attribute");
					System.out.println(Integer.parseInt(modelLength.get(iLength))+length);
					for (int iModelCount = length; iModelCount < Integer.parseInt(modelLength.get(iLength))+length; iModelCount++) {
						//System.out.println(modelList.get(iModelCount));
						for (int j = 1; j < splitAttribute.length; j++) {
							//System.out.println(splitAttribute[j].substring(2, 38));
							String sql = "Insert into ChillerModelCopy values('" + ruleIDs.get(iLength) + "','"
									+ modelList.get(iModelCount) + "','" + splitAttribute[j].substring(2, 38) + "');";
							st.executeUpdate(sql);
						}
						
						
					}
					
				}
				length= length+Integer.parseInt(modelLength.get(iLength));
				System.out.println("Length:" + modelLength.get(iLength));
				
			}

			/*
			 * for(int iCount=0;iCount<attributeList.size();iCount++){ String []
			 * splitAttribute=attributeList.get(iCount).split("#attribute");
			 * for(int j=1;j<splitAttribute.length;j++){ String
			 * sql="Insert into ChillerModel values('"+modelList.get(iCount)+
			 * "','"+splitAttribute[j].substring(2, 38)+"');";
			 * st.executeUpdate(sql);
			 * System.out.println("Models:"+modelList.get(iCount)); }
			 * 
			 * }
			 */
			System.out.println("Size:" + modelList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	@When("^user hit the CEP prod entity with input as Asset and Project ID$")
	public void ignoreWhen() {
	}

	public void userHitCEPEntity() {
		//userConnectedToCEPDB();
		connectCEPUATDB();
		ResultSet getAssetDetails = userFetchedAssetDetails();
		List<String> sqlID = new ArrayList<String>();
		List<String> assetName = new ArrayList<String>();
		List<String> assetID = new ArrayList<String>();
		List<String> projectID = new ArrayList<String>();
		List<String> attributeID = new ArrayList<String>();
		List<String> modelID = new ArrayList<String>();
		List<String> rulesguid = new ArrayList<String>();
		String uri = null;
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellModelID, cellAssetSqlID, cellAssetName, cellAssetID, cellProjectID, cellAttributes,cellRules;
		Sheet sheet;
		int iRowNumber = 1;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CEP_AssetDetails.xlsx";
		try {
			while (getAssetDetails.next()) {
				sqlID.add(getAssetDetails.getString("AssetSqlid"));
				assetName.add(getAssetDetails.getString("AssetName"));
				assetID.add(getAssetDetails.getString("AssetId").toLowerCase());
				projectID.add(getAssetDetails.getString("ProjectId").toLowerCase());
				modelID.add(getAssetDetails.getString("ModelId").toLowerCase());
			}
			String accessToken = getProdAccessToken();
			int i = 700;
			for (int iCount = 4171; iCount < assetName.size(); iCount++) {
				if ((iCount == i) || (iCount == i + 200) || (iCount == i + 400) || (iCount == i + 600)
						|| (iCount == i + 800) || (iCount == i + 1000) || (iCount == i + 1200) || (iCount == i + 1500)
						|| (iCount == i + 1800)||(iCount == i + 2000)) {
					accessToken = getProdAccessToken();
				
				}
				int iColNumber = 0;
				String uri2 = "('" + assetID.get(iCount) + "')";
				uri = ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..ProdEntityAPI.uri") + uri2;
				System.out.println("URI:" + uri);
				CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter1"),
						projectID.get(iCount),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter2"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparametervalue2"),
						methodName);
				attributeID = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..atrributeid[*]");
				rulesguid = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..ruleguid[*]");
				System.out.println(rulesguid.size());
			//	connectCEPUATDB();
				st = con.createStatement();
				String sql=null;
				String assetNameString=assetName.get(iCount);
				if(assetNameString.contains("'")){
					   assetNameString=assetNameString.replace("'", "''");
				   }
				for (int iAttributeCount = 0; iAttributeCount < attributeID.size(); iAttributeCount++) {
					if ((iAttributeCount == 100) || (iAttributeCount == 150) || (iCount == 200) || (iCount == 300)) {
						accessToken = getProdAccessToken();
					}
					   System.out.println("Inserting:"+iCount);
 					   
						sql="Insert into AssetAttributes values('"+sqlID.get(iCount)+"','"+assetNameString+"','"+assetID.get(iCount)+"','"+projectID.get(iCount)+"','"+modelID.get(iCount)+"','"+attributeID.get(iAttributeCount)+"')";
						st.executeUpdate(sql);	
				}
			/*	for (int iAttributeCount = 0; iAttributeCount < attributeID.size(); iAttributeCount++) {
					fis = new FileInputStream(path);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheet("AssetDetails");
					row = sheet.createRow(iRowNumber);
					cellAssetSqlID = row.createCell(iColNumber);
					cellAssetSqlID.setCellValue(sqlID.get(iCount));
					cellAssetName = row.createCell(iColNumber + 1);
					cellAssetName.setCellValue(assetName.get(iCount));
					cellAssetID = row.createCell(iColNumber + 2);
					cellAssetID.setCellValue(assetID.get(iCount));
					cellProjectID = row.createCell(iColNumber + 3);
					cellProjectID.setCellValue(projectID.get(iCount));
					cellModelID = row.createCell(iColNumber + 4);
					cellModelID.setCellValue(modelID.get(iCount));
					cellAttributes = row.createCell(iColNumber + 5);
					cellAttributes.setCellValue(attributeID.get(iAttributeCount));
					FileOutputStream fos = new FileOutputStream(path);
					workbook.write(fos);
					iRowNumber++;
				}*/
				iRowNumber=1;
			/*	for(int j=0;j<rulesguid.size();j++){
					fis = new FileInputStream(path);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheet("RulesGUID");
					row = sheet.createRow(iRowNumber);
					cellRules = row.createCell(iColNumber);
					cellRules.setCellValue(rulesguid.get(j));
					FileOutputStream fos = new FileOutputStream(path);
					workbook.write(fos);
					iRowNumber++;
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^data for each Assets should be available$")
	public void updateData() {

	}

	@And("^attribute details for each assets should get updated in the DB$")
	public void excelUpdate() {

	}

	// Steps definitions for RulesDataMatchedUnMatchedCount
	@Given("^data available in ChillerModel and AssetAttributes table$")
	public ResultSet getAssetDataFromDB() throws Exception {
		connectCEPUATDB();
		String sql="Select * from AssetDetailsCEPP order by AssetSqlId;";
		st = con.createStatement();
		rs = st.executeQuery(sql);
		return rs;
	}

	@Then("^user triggered query in both tables and get the count$")
	public void getMatchedUnMatchedCount() throws Exception {
		ResultSet rsAsset=getAssetDataFromDB();
		Statement stAttribute = null;
		ResultSet rsAttribute = null;
		Statement stAssetAttribute = null;
		ResultSet rsAssetAttribute = null;
		String attributeID = null;
		// HashSet<String> matchedSet = new HashSet<String>();
		// HashSet<String> unMatchedSet = new HashSet<String>();
		List<String> matchedSet = new ArrayList<String>();
		List<String> unMatchedSet = new ArrayList<String>();

		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellMatched, cellUnMatched;
		Sheet sheet;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CEP_Asset_AttributeDetails.xlsx";
		connectCEPUATDB();
		//String sqlFetchModelIDs="Select * from ChillerModel"
		while(rsAsset.next()){
		String sqlFetchRulesID = "Select distinct(RuleID) from ChillerModel where ModelID='1f85ec8c-4610-467b-ac54-71b6d333c92d';";
		List<String> ruleIDs = new ArrayList<String>();
		List<Integer> count = new ArrayList<Integer>();
		try {
			st = con.createStatement();
			rs = st.executeQuery(sqlFetchRulesID);
			while (rs.next()) {
				ruleIDs.add(rs.getString("RuleID"));
			}
			System.out.println(ruleIDs.size());
			for (int iCount = 0; iCount < ruleIDs.size(); iCount++) {
				System.out.println("RuleID: " + ruleIDs.get(iCount));
				String sqlFetchAttributeID = "Select distinct(AttributeID) from ChillerModel where ModelID='1f85ec8c-4610-467b-ac54-71b6d333c92d' and RuleID='"
						+ ruleIDs.get(iCount) + "';";
				stAttribute = con.createStatement();
				rsAttribute = stAttribute.executeQuery(sqlFetchAttributeID);
				while (rsAttribute.next()) {
					attributeID = rsAttribute.getString("AttributeID");
					System.out.println("AttributeID: " + attributeID);
					String sqlGetRuleCount = "Select count(*) as Count from AssetAttributes where AssetSqlID=1 and AttributeID='"
							+ attributeID + "';";
					stAssetAttribute = con.createStatement();
					rsAssetAttribute = stAssetAttribute.executeQuery(sqlGetRuleCount);
					while (rsAssetAttribute.next()) {
						count.add(Integer.parseInt(rsAssetAttribute.getString("Count")));
					}

				}
				if (count.contains(0)) {
					System.out.println(count.get(0));
					unMatchedSet.add(attributeID);
				} else {
					System.out.println(count.get(0));
					matchedSet.add(attributeID);
				}
				count.clear();
			}
			System.out.println(matchedSet.size());
			System.out.println(unMatchedSet.size());
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Result");
			row = sheet.createRow(1);
			cellMatched = row.createCell(5);
			cellMatched.setCellValue(matchedSet.size());
			cellMatched = row.createCell(6);
			cellMatched.setCellValue(unMatchedSet.size());
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			workbook.close();
			Iterator itr = matchedSet.iterator();
			while (itr.hasNext()) {
				System.out.println("Matched Data:" + itr.next());
			}
			itr = unMatchedSet.iterator();
			while (itr.hasNext()) {
				System.out.println("UnMatched Data:" + itr.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	@And("^the count should get updated in the spreadsheet$")
	public void countUpdated() {

	}
	
	//Steps definition for AddDataToDB
	@Given("^Data available and added to DB$")
	public void addDataToDB() throws Exception{
		//fis=new FileInputStream("C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CEP_Asset_AttributeDetails.xlsx");
		fis=new FileInputStream("C:\\Users\\jaroraso\\Documents\\CEP_Automation\\AssetDetails_CEPPDB_Data.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Sheet1");
		int iRowNumber=1;
		connectCEPUATDB();
		st = con.createStatement();
		String sql=null;
		for(int iRow=1040;iRow<4695;iRow++){
			System.out.println("Inserting:"+iRow);
			int iCol=0;
			row=sheet.getRow(iRow);
			sql="Insert into AssetDetailsCEPP values("+row.getCell(iCol).getNumericCellValue()+",'"+row.getCell(iCol+1).getStringCellValue()+"','"+row.getCell(iCol+2).getStringCellValue()+"','"+row.getCell(iCol+3).getStringCellValue()+"','"+row.getCell(iCol+4).getStringCellValue()+"')";
			st.executeUpdate(sql);
		}
	}

	// Steps definition for Hit&GetCEPData
	@Given("^user hit the api and get the value$")
	public void userHitCEPAPI() throws Exception {
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellTime, cellTemp;
		Sheet sheet;
		int iRowNumber = 1;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/CEPData.xlsx";
		Map<String, String> getData = getCEPAPIData();
		for (Map.Entry mProd : getData.entrySet()) {
			int iColNumber = 0;
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("ACCOPHRS");
			row = sheet.createRow(iRowNumber);
			cellTime = row.createCell(iColNumber);
			cellTime.setCellValue(mProd.getKey().toString());
			cellTemp = row.createCell(iColNumber + 1);
			cellTemp.setCellValue(mProd.getValue().toString());
			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
			workbook.close();
			iRowNumber++;
		}
	}
	//Steps definitions for GetPointStatus
	@Given("^assetID and projectID available$")
	public void given(){
		System.out.println("Connecting DB");
	}
	public ResultSet fetchAssetIDProjectID(){
		userConnectedToCEPDB();
		String sql="Select AssetSqlID,AssetName,AssetId,ProjectId from AssetDetails order by AssetSqlID;";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			return rs;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@When("^user hit prod entity for using each assetID$")
	public void userHitEntityApiProd(){
		System.out.println("User hitting API");
	}
	@SuppressWarnings("static-access")
	@Then("^point status should get updated based on response$")
	public void getPointStatusForEachAsset(){
		ResultSet getAssetDetails=fetchAssetIDProjectID();
		List<String> sqlID = new ArrayList<String>();
		List<String> assetName = new ArrayList<String>();
		List<String> assetID = new ArrayList<String>();
		List<String> projectID = new ArrayList<String>();
		List<String> pointID = new ArrayList<String>();
		List<String> ruleType = new ArrayList<String>();
		String status;
		String uri = null;
		String timeSeriesURI=null;
		FileInputStream fis;
		Workbook workbook;
		Row row;
		Cell cellAssetSqlID, cellAssetName, cellAssetID, cellProjectID, cellPointID,cellRuleType,cellStatus;
		Sheet sheet;
		int iRowNumber = 1;
		String path = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CEP/TimeSeriesAPI_Report/AssetWise_PointStatus.xlsx";
		try {
			while (getAssetDetails.next()) {
				sqlID.add(getAssetDetails.getString("AssetSqlid"));
				assetName.add(getAssetDetails.getString("AssetName"));
				assetID.add(getAssetDetails.getString("AssetId").toLowerCase());
				projectID.add(getAssetDetails.getString("ProjectId").toLowerCase());
			}
			String accessToken = getProdAccessToken();
			int i = 700;
			for (int iCount = 0; iCount < assetName.size(); iCount++) {
				if ((iCount == i) || (iCount == i + 200) || (iCount == i + 400) || (iCount == i + 600)
						|| (iCount == i + 800) || (iCount == i + 1000) || (iCount == i + 1200) || (iCount == i + 1500)
						|| (iCount == i + 1800)||(iCount == i + 2000)) {
					accessToken = getProdAccessToken();
				
				}
				String uri2 = "('" + assetID.get(iCount) + "')";
				uri = ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..ProdEntityAPI.uri") + uri2;
				System.out.println("URI:" + uri);
				CommonAPIfunctions.Get_API_Request_TimeSeries(uri, "Bearer " + accessToken,
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter1"),
						projectID.get(iCount),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparameter2"),
						ReadJsonFile.readJsonFileDynamic_firstentry(
								ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
								"$..APICommon.headerparametervalue2"),
						methodName);
				pointID = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..id");
				ruleType = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME, "$..ruletype");
				for(int iPoint=0;iPoint<pointID.size();iPoint++){
					timeSeriesURI= ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.uri1")
							+ pointID.get(iPoint)
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..DataVerification.uri2")
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..DataVerification.uri3")
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..DataVerification.uri4")
							+ "Raw"
							+ ReadJsonFile.readJsonFileDynamic_firstentry(
									ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
									"$..DataVerification.uri5");
					System.out.println(timeSeriesURI);
					int responseCode = CommonAPIfunctions.Get_API_ResponseCode_TimeSeries(timeSeriesURI, "Bearer " + accessToken,
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
					if(responseCode==403){
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("Sheet1");
						row = sheet.createRow(iRowNumber);
						cellAssetSqlID = row.createCell(0);
						cellAssetSqlID.setCellValue(sqlID.get(iCount));
						cellAssetName = row.createCell(1);
						cellAssetName.setCellValue(assetName.get(iCount));
						cellAssetID = row.createCell(2);
						cellAssetID.setCellValue(assetID.get(iCount));
						cellProjectID = row.createCell(3);
						cellProjectID.setCellValue(projectID.get(iCount));
						cellPointID = row.createCell(4);
						cellPointID.setCellValue(pointID.get(iPoint));
						cellRuleType = row.createCell(5);
						cellRuleType.setCellValue(ruleType.get(iPoint));
						cellStatus=row.createCell(6);
						cellStatus.setCellValue("Forbidden");
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);
					}
					else{
						fis = new FileInputStream(path);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheet("Sheet1");
						row = sheet.createRow(iRowNumber);
						cellAssetSqlID = row.createCell(0);
						cellAssetSqlID.setCellValue(sqlID.get(iCount));
						cellAssetName = row.createCell(1);
						cellAssetName.setCellValue(assetName.get(iCount));
						cellAssetID = row.createCell(2);
						cellAssetID.setCellValue(assetID.get(iCount));
						cellProjectID = row.createCell(3);
						cellProjectID.setCellValue(projectID.get(iCount));
						cellPointID = row.createCell(4);
						cellPointID.setCellValue(pointID.get(iPoint));
						cellRuleType = row.createCell(5);
						cellRuleType.setCellValue(ruleType.get(iPoint));
						cellStatus=row.createCell(6);
						cellStatus.setCellValue("Active");
						FileOutputStream fos = new FileOutputStream(path);
						workbook.write(fos);
					}
					
					iRowNumber++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@After
	public static void generateReport() {
		getFinalReport(driver, logger, methodName, true);
	}

}
