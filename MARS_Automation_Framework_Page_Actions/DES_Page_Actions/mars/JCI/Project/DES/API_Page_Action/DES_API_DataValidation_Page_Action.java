package mars.JCI.Project.DES.API_Page_Action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.API_BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.SiteOverView.DES_SiteOverView_Page_Factory;
import mars.JCI.Project.DES.SiteOverview.DES_SiteOverview_Page_Action;

public class DES_API_DataValidation_Page_Action extends API_BaseClass {

	public static DES_SiteOverView_Page_Factory sitePF = null;
	public static DES_Login_Page_Action loginPA = null;
	public static DES_SiteOverview_Page_Action siteOvPA = null;

	public DES_API_DataValidation_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		sitePF = new DES_SiteOverView_Page_Factory(driver, logger);
		loginPA = new DES_Login_Page_Action(driver, logger);
		siteOvPA = new DES_SiteOverview_Page_Action(driver, logger);
	}

	public static String UI_SOCDataValidation(WebDriver driver, ExtentTest logger, String value, String methodName) {
		try {
			loginPA.DES_CorrectLogin();
			logger.log(LogStatus.PASS, "Validating Overview screen SOC widget Data");
			commonFunctions.WebElementCommon.staticWait(2500);
			verifySOC(value, methodName);

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage() + "failled to validate");
		}
		return value;
	}

	public static String UI_DC_CAPACITY_Validation(WebDriver driver, ExtentTest logger, String value,String methodName) {
		String value1="";
		try {
			loginPA.DES_CorrectLogin();
			logger.log(LogStatus.PASS, "Validating Overview screen SOC widget Data for DC_CAPACITY ");
			commonFunctions.WebElementCommon.staticWait(2500);
			value1=verifyDC_Capacity(value, methodName);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage() + "failled to validate");
		}

		return value1;
	}

	private static String verifyDC_Capacity(String value, String methodName) {
		try {
			value = siteOvPA.getDCCapacity();
			logger.log(LogStatus.PASS, "Value from UI is :" + value);
			//API_BaseClass.getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not get DC Capacity value from UI");
		}
		return value;
	}

	private static String verifySOC(String value, String methodName) throws InterruptedException {
		try {
			value = siteOvPA.getStateOfChargeDetails();
			logger.log(LogStatus.PASS, "Value from UI is :" + value);
			//API_BaseClass.getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to validate the SOC Value");

		}
		return value;
	}

	public String UI_Power_Validation(WebDriver driver, ExtentTest logger, String value, String methodName) {
		String value1="";
		try {
			loginPA.DES_CorrectLogin();
			logger.log(LogStatus.PASS, "Validating Overview screen Power widget Data for Real Power ");
			commonFunctions.WebElementCommon.staticWait(2500);
			value1=verifyPower_Details(value, methodName);

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to validate the Real Power");
		}
		return value1;
	}

	private String verifyPower_Details(String value, String methodName) {
		try {
			value = siteOvPA.getPowerDetails();
			logger.log(LogStatus.PASS, "Value from UI is :" + value);
			//API_BaseClass.getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to validate the Real Power");
		}
		return value;

	}
	
	public String UI_AcCapacity_Validation(WebDriver driver, ExtentTest logger, String value, String methodName){
		String value1="";
		try{
			loginPA.DES_CorrectLogin();
			logger.log(LogStatus.PASS, "Validating Overview screen Power widget Data for AC Capacity ");
			commonFunctions.WebElementCommon.staticWait(2500);
			value1=verifyAcCapacity_Details(value, methodName);
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to validate the AC Capacity");
		}
		return value1;
		
	}

	private String verifyAcCapacity_Details(String value, String methodName) {
		try{
			value=siteOvPA.getACCapacity();
			logger.log(LogStatus.PASS, "Value from UI is :" + value);
			//API_BaseClass.getFinalReport(driver, logger, methodName, true);
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to get AC Capacity");
		}
		return value;
		
	}
	
	public String UI_BSOCH_Validation(WebDriver driver, ExtentTest logger, String value, String methodName){
		String value1="";
		try{
			loginPA.DES_CorrectLogin();
			logger.log(LogStatus.PASS, "Validating Overview screen BATTERY STATE OF HEALTH ");
			commonFunctions.WebElementCommon.staticWait(2500);
			value1=verifyBSOCH_Details(value,methodName);
			
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to validate the BATTERY STATE OF HEALTH Value");
		}
		return value1;
		
	}

	private String verifyBSOCH_Details(String value, String methodName) {
		try{
			value=siteOvPA.getBatteryStateHealthDetails();
			logger.log(LogStatus.PASS, "Value from UI is :" + value);
			//API_BaseClass.getFinalReport(driver, logger, methodName, true);

		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to validate the BATTERY STATE OF HEALTH Value from Dashboard");
		}
		return value;
		
	}
	
	public String UITimeStamp_Validation(WebDriver driver, ExtentTest logger, String value, String methodName){
		String value1="";
		try {
			loginPA.DES_CorrectLogin();
			logger.log(LogStatus.PASS, "Validating Overview screen Last Data Collected ");
			commonFunctions.WebElementCommon.staticWait(2500);
			value1=verifyLastdataCollected(value, methodName);
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to validate Last Data Collected Fields");
		}
		
		return value1;
	}

	private String verifyLastdataCollected(String value, String methodName) {
		try{
		value=siteOvPA.getLastDataCollectedDetails();
		logger.log(LogStatus.PASS, "Value from UI is :" + value);
		//API_BaseClass.getFinalReport(driver, logger, methodName, true);
		}catch (Exception e){
			logger.log(LogStatus.FAIL, "Value received from Dashboard is "+value +e.getMessage());
		}
		return value;
	}
	
	public void analyzeLog() {
		List<LogEntry> logs1=driver.manage().logs().get(LogType.BROWSER).getAll();
		for(LogEntry lg:logs1){
		System.out.println("--"+ lg);
		}
		
		String s = driver.getPageSource();
		while(s.contains("Error converting value") || s.contains("Internal server")){
			logger.log(LogStatus.FAIL, s);
		}
    }

}
