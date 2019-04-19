package mars.JCI.Project.CEP.ChillerInformation;

import static mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_API_Page_Action.getProdAccessToken;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
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

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.HeatMap.CEP_HealthCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.HeatMap.CEP_HeatMap_DataBase_Action;
import mars.JCI.Project.CEP.HeatMap.CEP_StatusCheckHeatMap_Page_Factory;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_DataBase_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Factory;

public class CEP_ChillerInformation_Page_Action extends BaseClass {
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";
	private static CommonAPI_Functions CommonAPIfunctions = new CommonAPI_Functions(logger);

	@SuppressWarnings("static-access")
	public CEP_ChillerInformation_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public void validateTitleOfWidget() throws Exception {
		CEP_ChillerInformation_Page_Factory objChillerInfo = new CEP_ChillerInformation_Page_Factory(driver,logger);
		waitForSpinnerToBeGone();
		List<WebElement> element = objChillerInfo.getTitle();
		if (element != null) {
			if (element.get(1).getText().equalsIgnoreCase("Chiller Information")) {
				logger.log(LogStatus.PASS, "Title of the Chiller Information widget is as expected.");
			} else {
				logger.log(LogStatus.FAIL, "Title of the Chiller Information widget is not as expected.");
			}
		} else {
			logger.log(LogStatus.FAIL, "Title not present.");
		}
	}

	public void validateDefaultChiller() throws Exception {
		CEP_ChillerInformation_Page_Factory objChillerInfo = new CEP_ChillerInformation_Page_Factory(driver,logger);
		waitForSpinnerToBeGone();
		WebElement defaultSelectedChiller = objChillerInfo.getDefualtChiller();
		WebElement defaultChiller = objChillerInfo.getDefualtChillerCI();
		if ((defaultSelectedChiller != null) && (defaultChiller != null)) {
			if (defaultSelectedChiller.getText().equalsIgnoreCase(defaultChiller.getText())) {
				logger.log(LogStatus.PASS,
						"Default Chiller which is selected in AssetName is getting displayed in ChillerInformation widget.");
			} else {
				logger.log(LogStatus.FAIL, "Default Chiller is not as expected.");
			}
		} else {
			logger.log(LogStatus.PASS, "Default Chiller is not present.");
		}
	}

	@SuppressWarnings("static-access")
	public Map<String, String> getAPIDetails() throws Exception {
		CEP_ChillerInformation_Page_Factory objChillerInfo = new CEP_ChillerInformation_Page_Factory(driver,logger);
		List<WebElement> selectedList = objChillerInfo.getSelectedCustomerAndProject();
		String selectedCustomer = selectedList.get(0).getText();
		String selectedChiller = objChillerInfo.getDefualtChiller().getText();
		ResultSet rs = CEP_ChillerInformation_DataBase_Action.getAssetandProjectID(selectedCustomer, selectedChiller);
		String assetID = null;
		String projectID = null;
		String uri = null;
		String accessToken = getProdAccessToken();
		List<String> timeSeriesID = new ArrayList<String>();
		List<String> pointNameList = new ArrayList<String>();
		Map<String, String> pointDetails = new LinkedHashMap<String, String>();
		while (rs.next()) {
			assetID = rs.getString("AssetID");
			projectID = rs.getString("ProjectID");
		}
		uri = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..ProdEntityAPI.uri") + "('"
				+ assetID.toLowerCase() + "')";
		System.out.println("Entity:" + uri);
		System.out.println("ProjectID:"+projectID.toLowerCase());
		CommonAPIfunctions.Get_API_Request(uri, "Bearer " + accessToken,
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.headerparameter1"),
				projectID.toLowerCase(),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.headerparameter2"),
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..APICommon.headerparametervalue2"),
				methodName);
		timeSeriesID = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..EntityAPI.pointID"));
		pointNameList = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
				ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..EntityAPI.pointname"));
		String pointName = null;
		for (int i = 0; i < timeSeriesID.size(); i++) {
			if (pointNameList.get(i).equalsIgnoreCase("RETURN CHILLED LIQUID TEMP")) {
				pointName = pointNameList.get(i).replace("RETURN CHILLED LIQUID TEMP", "ENTERING CHW TEMP");
			} else if (pointNameList.get(i).equalsIgnoreCase("LEAVING CHILLED LIQUID TEMP")) {
				pointName = pointNameList.get(i).replace("LEAVING CHILLED LIQUID TEMP", "LEAVING CHW TEMP");
			} else {
				pointName = pointNameList.get(i);
			}
			pointDetails.put(pointName, timeSeriesID.get(i));
		}
		return pointDetails;
	}

	public Map<String, Double> getUIDetails() {
		CEP_ChillerInformation_Page_Factory objChillerInfo = new CEP_ChillerInformation_Page_Factory(driver,logger);
		try{
			List<WebElement> pointNameList = objChillerInfo.getChillerInfoDetails();
			List<WebElement> tempList = objChillerInfo.getTemperature();
			Map<String, Double> pointDetails = new LinkedHashMap<String, Double>();
			String temp = null;
			if (pointNameList != null) {
				for (int i = 0; i < pointNameList.size(); i++) {
					String temperature = tempList.get(i).getText();
					if (temperature.equals("-")) {
						temp = temperature.replace("-", "0.0");
					} else {
						temp = temperature;
					}
					pointDetails.put(pointNameList.get(i).getText(), Double.parseDouble(temp));
				}
			}
			return pointDetails;
		}catch(NullPointerException e) {
				logger.log(LogStatus.INFO, "No Data present.");
				logger.log(LogStatus.PASS, "TC-103051-No Data message is getting displayed as expected.");
				return null;
			}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
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

	public static String getCurrentDate() {
		DateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		Date currentDate = new Date();
		return currentDateFormat.format(currentDate);
	}

	@SuppressWarnings("static-access")
	public double getTimeSeriesValue(String timeseriesID) throws Exception {
		String uri = null;
		String accessToken = getProdAccessToken();
		uri = ReadJsonFile.readJsonFileDynamic_firstentry(
				ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
				"$..DataVerification.uri1")
				+ timeseriesID
				+ ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.uri2")
				+ getYesterdayDate()
				+ ReadJsonFile.readJsonFileDynamic_firstentry(
						ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
						"$..DataVerification.uri3")
				+ getCurrentDate()
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
		try {
			List<Double> tempValue = new ArrayList<Double>();
			tempValue = ReadJsonFile.readJsonFileDynamicDouble(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.tempVal"));
			String truncateTemp = "0";
			if (tempValue.size() > 0) {
				DecimalFormat df = new DecimalFormat("#.00");
				truncateTemp = df.format(tempValue.get(0));
			} else {
				truncateTemp = "0";
			}
			return Double.parseDouble(truncateTemp);
		} catch (IllegalArgumentException e) {
			List<String> tempValue = new ArrayList<String>();
			tempValue = ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,
					ReadJsonFile.readJsonFileDynamic_firstentry(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							"$..DataVerification.tempVal"));
			List<Double> tempValueDouble = new ArrayList<Double>();
			String truncateTemp = "0";
			if (tempValue.size() > 0) {
				for (int i = 0; i < tempValue.size(); i++) {
					tempValueDouble.add(Double.parseDouble(tempValue.get(i)));
				}
				DecimalFormat df = new DecimalFormat("#.00");
				truncateTemp = df.format(tempValueDouble.get(0));
			} else {
				truncateTemp = "0";
			}
			return Double.parseDouble(truncateTemp);

		}
	}
	public static void waitForSpinnerToBeGone() throws Exception {
		CEP_ChillerInformation_Page_Factory objChillerInfo = new CEP_ChillerInformation_Page_Factory(driver,logger);
//		WebElement spinner = objChillerInfo.getSpinner();
		try{
		boolean spinnerStatus = objChillerInfo.getSpinnerStatus();
		if (spinnerStatus) {
	        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.overlayheatmap>spinner")));
	    }
		}catch(TimeoutException e){
			logger.log(LogStatus.FAIL, "Time to fetch data from APIs is more than 30 seconds.");
		}
	}

	@SuppressWarnings("rawtypes")
	public void validateDefaultDetails() throws Exception {
		CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
		Map<String, String> apiDetails = getAPIDetails();
		Map<String, Double> uiDetails = getUIDetails();
		//Thread.sleep(25000);
//		waitForSpinnerToBeGone();
		for (Map.Entry m : apiDetails.entrySet()) {
			if (uiDetails.containsKey(m.getKey())) {
				logger.log(LogStatus.PASS, "Point " + m.getKey() + " present in UI and is matching with API.");
				double temp = getTimeSeriesValue(m.getValue().toString());
				if (uiDetails.containsValue(temp)) {
					logger.log(LogStatus.PASS, "Value for the point " + m.getKey() + " matched with API.");
					logger.log(LogStatus.PASS, "Value in the UI and in API is:" + temp);
				} else {
					logger.log(LogStatus.FAIL, "Value for the point " + m.getKey() + " not matched with API.");
					logger.log(LogStatus.INFO, "Value in the UI is:" + uiDetails.get(m.getKey()));
					logger.log(LogStatus.INFO, "Value in the API is:" + temp);
				}
			}
		}
	}

	public void validateChillerInfoForGeographies() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		List<String> geographies = CEP_LeftPanel_DataBase_Action.geographyListDB();
		for (int iCount = 0; iCount < geographies.size(); iCount++) {
			// if(geographies.get(iCount).equalsIgnoreCase("Europe")) {
			// continue;
			// }
			String customer = CEP_HeatMap_DataBase_Action.getFirstCustomerName("GeographyName",
					geographies.get(iCount));
			WebElement search = objLeftPanel.getSearchBox();
			search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(geographies.get(iCount), "1");
			// WebElement
			// elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(10000);
				System.out.println("Geography:" + geographies.get(iCount));
				logger.log(LogStatus.INFO, "Validation for " + geographies.get(iCount) + " is started.");
				validateDefaultDetails();
				logger.log(LogStatus.INFO, "Validation for " + geographies.get(iCount) + " is completed.");
				getFinalReport(driver, logger, "test" + geographies.get(iCount), true);
			} else {
				logger.log(LogStatus.FAIL, "Geography" + geographies.get(iCount) + "not present.");
				getFinalReport(driver, logger, "test" + geographies.get(iCount), false);
			}

			search.clear();
		}
	}

	public void validateChillerInfoForCountries() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		List<String> countries = CEP_LeftPanel_DataBase_Action.countryListDB();
		for (int iCount = 0; iCount < countries.size(); iCount++) {
			String customer = CEP_HeatMap_DataBase_Action.getFirstCustomerName("CountryName", countries.get(iCount));
			WebElement search = objLeftPanel.getSearchBox();
			search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(countries.get(iCount), "2");
			// WebElement
			// elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(10000);
				logger.log(LogStatus.INFO, "Validation for " + countries.get(iCount) + " is started.");
				validateDefaultDetails();
				logger.log(LogStatus.INFO, "Validation for " + countries.get(iCount) + " is completed.");
				getFinalReport(driver, logger, "test" + countries.get(iCount), true);
			} else {
				logger.log(LogStatus.FAIL, "Country" + countries.get(iCount) + "not present.");
				getFinalReport(driver, logger, "test" + countries.get(iCount), false);
			}

			search.clear();
		}
	}

	public void validateChillerInfoForBranches() throws Exception {
		CEP_LeftPanel_Page_Factory objLeftPanel = new CEP_LeftPanel_Page_Factory(driver);
		List<String> branches = CEP_LeftPanel_DataBase_Action.branchListDB();
		for (int iCount = 0; iCount < branches.size(); iCount++) {
			if (branches.get(iCount).equalsIgnoreCase("Atlanta GA - 0N04")) {
				continue;
			}
			String customer = CEP_HeatMap_DataBase_Action.getFirstCustomerName("BranchName", branches.get(iCount));
			WebElement search = objLeftPanel.getSearchBox();
			search.sendKeys(customer);
			objLeftPanel.getSearchBoxButton().click();
			//Thread.sleep(3000);
			WebElement element = objLeftPanel.getLeftPanelElement(branches.get(iCount), "3");
			// WebElement
			// elementDiv=objLeftPanel.getLeftPanelElementDiv(geographies.get(iCount));
			if (element != null) {
				Actions action = new Actions(driver);
				action.moveToElement(element).click().perform();
				//Thread.sleep(10000);
				logger.log(LogStatus.INFO, "Validation for " + branches.get(iCount) + " is started.");
				validateDefaultDetails();
				logger.log(LogStatus.INFO, "Validation for " + branches.get(iCount) + " is completed.");
				getFinalReport(driver, logger, "test" + branches.get(iCount), true);
			} else {
				logger.log(LogStatus.FAIL, "Country" + branches.get(iCount) + "not present.");
				getFinalReport(driver, logger, "test" + branches.get(iCount), false);
			}

			search.clear();
		}
	}
	public void validateScrolls() throws Exception {
		CEP_StatusCheckHeatMap_Page_Factory objStatusCheck = new CEP_StatusCheckHeatMap_Page_Factory(driver);
		CEP_ChillerInformation_Page_Factory objChillerInfo = new CEP_ChillerInformation_Page_Factory(driver,logger);
		waitForSpinnerToBeGone();
		WebElement greyColor = objStatusCheck.getStatusCheckGrey();
		if (greyColor != null) {
			Actions action = new Actions(driver);
			action.moveToElement(greyColor).click().build().perform();
			//Thread.sleep(10000);
			List<WebElement> selectedList = objChillerInfo.getSelectedCustomerAndProject();	
			List<String> assetList = CEP_ChillerInformation_DataBase_Action.getAssetList(selectedList.get(1).getText());
			List<WebElement> scrollList = objChillerInfo.getScrollList();
			if(scrollList!=null){
				scrollList.get(0).click();
				//Thread.sleep(2000);
				logger.log(LogStatus.PASS, "TC-103053 and TC-103068-Gray color widget details is as expected.");
				if(assetList.contains(objChillerInfo.getDefualtChiller().getText())) {
					logger.log(LogStatus.PASS, "Forward Scroll is working as expected.");					
					getFinalReport(driver, logger, "testRightScroll", true);
				}
				else{
					logger.log(LogStatus.FAIL, "Expected Chiller is not present after clicking on Forward Scroll.");
					getFinalReport(driver, logger, "testRightScroll", false);
				}
				scrollList.get(1).click();
				//Thread.sleep(2000);
				if(assetList.contains(objChillerInfo.getDefualtChiller().getText())) {
					logger.log(LogStatus.PASS, "Back Scroll is working as expected.");					
					getFinalReport(driver, logger, "testLeftScroll", true);
				}
				else{
					logger.log(LogStatus.FAIL, "Expected Chiller is not present after clicking on Back Scroll.");
					getFinalReport(driver, logger, "testLeftScroll", false);
				}

			}
			else{
				logger.log(LogStatus.FAIL, "Scroll not present in Chiller Information widget.");
				getFinalReport(driver, logger, "testScroll", false);
			}
		}
		else{
			logger.log(LogStatus.INFO, "Grey color widget not present.");
		}
	}
}
