package mars.JCI.Project.DES.API;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsAPI.CommonAPI_Functions;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import mars.Component.Functions.API_BaseClass;
import mars.JCI.Project.DES.API_Page_Action.DES_API_DataValidation_Page_Action;
import mars.JCI.Project.DES.API_Page_Action.DES_API_Page_Action;
import mars.JCI.Project.MEMS.API.MEMS_API_Page_Action;

public class DES_API_Test extends API_BaseClass{
	
	public static String Access_token="",Authorization,Point_Value="",Point_ID="",DC_CapacityUnits="",Power_Units="",acCapacity="",value="";
	public static Response API_JSON_Response;
	public static String Filename;

	public static String body1="grant_type=password&username=superadmindes@jci.com&password=Jci@1234&scope=read write securityapi_all"; 
	
	
	
	/**
	 * AP I to get access token.
	 */
	@SuppressWarnings("static-access")
	@Test(priority=0,description="API to get the accesstoken for authentication")
	public static void API_to_getAccessToken()
	{
		try
		{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			/*CommonAPIfunctions.POST_API_Request(CommonAPI_Functions.properties.getProperty("Token_URL"),
					CommonAPI_Functions.properties.getProperty("Authorization"),new Header("Header_Content_type",CommonAPI_Functions.properties.getProperty("Header_Content_type")),
					CommonAPI_Functions.properties.getProperty("request_body"),methodName);
			Access_token=CommonAPI_Functions.GetToken(methodName);*/
			//Header header=new Header("header_content_type","application/x-www-form-urlencoded");
			//CommonAPI_Functions.POST_API_Request("https://uat-api.digitalvault.cloud/Identity/ims/connect/token", "Basic ZGVzLmFwaTpnbnFackg1Y0JGU05nVGVZd0U1Mm5YeG09",header,"grant_type=password&username=superadmindes@jci.com&password=Jci@1234&scope=read write securityapi_all",methodName);
			//CommonAPIfunctions.POST_API_Request(CommonAPI_Functions.properties.getProperty("Token_URL"),CommonAPI_Functions.properties.getProperty("Authorization"), new Header ("Content-Type", CommonAPI_Functions.properties.getProperty("Header_Content_type")),CommonAPI_Functions.properties.getProperty("request_body"), methodName);
			//CommonAPIfunctions.POST_API_Request("https://uat-api.digitalvault.cloud/Identity/ims/connect/token","Basic ZGVzLmFwaTpnbnFackg1Y0JGU05nVGVZd0U1Mm5YeG09", new Header ("Content-Type", "application/x-www-form-urlencoded"),body1, methodName);
			API_JSON_Response= RestAssured.given()
					.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
					.header("Content-Type", "application/x-www-form-urlencoded").and().
					header("Authorization","Basic ZGVzLmFwaTpnbnFackg1Y0JGU05nVGVZd0U1Mm5YeG09")
					.body(body1).post("https://uat-api.digitalvault.cloud/Identity/ims/connect/token");
			
			System.out.println(API_JSON_Response.asString());
		
			CommonAPI_Functions.WriteAPI_Response_to_Jsonfile(API_JSON_Response.asString(),methodName);
			Access_token=CommonAPI_Functions.GetToken(methodName);
			System.out.println(Access_token);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="API to get the different Points")
	public static void API_to_getPoints() 
	{
		try
		{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);
			
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=desAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDs_jsonpath"),methodName); 
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1,description="API to get the Points value from timeseries")
	public static void API_to_getPointValue() 
	{
		try
		{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			DES_API_DataValidation_Page_Action desAPIDataValidation = new DES_API_DataValidation_Page_Action(driver, logger);
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);			
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=desAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDs_jsonpath"),methodName);
			String timeSeriesStateOfChargeUrl=(CommonAPIfunctions.properties.getProperty("Timeseries_host")+Point_ID+"/samples?limit=1");
			logger.log(LogStatus.PASS,timeSeriesStateOfChargeUrl);
			CommonAPIfunctions.Get_API_Request(timeSeriesStateOfChargeUrl, Authorization, methodName);
			Point_Value=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("Bank_State_of_Charge_jsonpath"), methodName);
								
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2, description="Validate API data for SOC with Dashboard UI")
	public static void validate_API_SOC_DataWithUI(){
		try{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			DES_API_DataValidation_Page_Action desAPIDataValidation = new DES_API_DataValidation_Page_Action(driver, logger);
			
			/*API_JSON_Response= RestAssured.given()
					.config(RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()))
					.header("Content-Type", "application/x-www-form-urlencoded").and().
					header("Authorization","Basic ZGVzLmFwaTpnbnFackg1Y0JGU05nVGVZd0U1Mm5YeG09")
					.body(body1).post("https://uat-api.digitalvault.cloud/Identity/ims/connect/token");
			System.out.println(API_JSON_Response.asString());
			CommonAPI_Functions.WriteAPI_Response_to_Jsonfile(API_JSON_Response.asString(),methodName);
			Access_token=CommonAPI_Functions.GetToken(methodName);
			System.out.println(Access_token);*/
			
			
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);	
			String timeSeriesStateOfChargeUrl=(CommonAPIfunctions.properties.getProperty("Timeseries_host")+Point_ID+"/samples?limit=1");
			logger.log(LogStatus.PASS,timeSeriesStateOfChargeUrl);
			CommonAPIfunctions.Get_API_Request(timeSeriesStateOfChargeUrl, Authorization, methodName);
			String Point_Value1=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("Bank_State_of_Charge_jsonpath"), methodName);
			String UI_SOC_Value=desAPIDataValidation.UI_SOCDataValidation(driver, logger, Point_Value1, methodName);
			if(Point_Value1==UI_SOC_Value){
				logger.log(LogStatus.PASS, "Value from UI and TimeSeries matched for SOC");
			}else{
				logger.log(LogStatus.FAIL, "Values appeared to be not matching "+ Point_Value1 +""+ UI_SOC_Value);
			}
			getFinalReport(driver, logger, methodName, true);
			
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Error is :"+ e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2, description="Validate API data for DC Capacitywith Dashboard UI")
	public static void validate_API_DCCapacity_DataWithUI(){
		try{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			DES_API_DataValidation_Page_Action desAPIDataValidation = new DES_API_DataValidation_Page_Action(driver, logger);
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);	
			
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=desAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDs_DCCapacitys_jsonpath"),methodName);
			DC_CapacityUnits=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("Point_IDs_DCCapacitysUnit_jsonpath"),methodName);
			String timeSeriesDCCapacityUrl=(CommonAPIfunctions.properties.getProperty("Timeseries_host")+Point_ID+"/samples?limit=1");
			logger.log(LogStatus.PASS,timeSeriesDCCapacityUrl);
			CommonAPIfunctions.Get_API_Request(timeSeriesDCCapacityUrl, Authorization, methodName);
			Point_Value=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("DCCapacitys_jsonpath"), methodName);
			String UI_DCCapacity_Value=desAPIDataValidation.UI_DC_CAPACITY_Validation(driver, logger,Point_Value, methodName);
			String DCCapacity="DC CAPACITY "+Point_Value+" "+DC_CapacityUnits;
			logger.log(LogStatus.PASS, "Values appeared to be not matching "+ DCCapacity +" "+ UI_DCCapacity_Value);
			getFinalReport(driver, logger, methodName, true);
			
			//DC CAPACITY 56 kWh
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Error is :"+ e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}

	
	@SuppressWarnings("static-access")
	@Test(priority=2, description="Validate API data for Power with Dashboard UI")
	public static void validate_API_Power_DataWithUI(){
		try{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			DES_API_DataValidation_Page_Action desAPIDataValidation = new DES_API_DataValidation_Page_Action(driver, logger);
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);	
			
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=desAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDs_Power_jsonpath"),methodName);
			Power_Units=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("Point_IDs_PowerUnit_jsonpath"),methodName);
			String timeSeriesPowerUrl=(CommonAPIfunctions.properties.getProperty("Timeseries_host")+Point_ID+"/samples?limit=1");
			logger.log(LogStatus.PASS,timeSeriesPowerUrl);
			CommonAPIfunctions.Get_API_Request(timeSeriesPowerUrl, Authorization, methodName);
			
			Point_Value=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("DCCapacitys_jsonpath"), methodName);
			String UI_Power_Value=desAPIDataValidation.UI_Power_Validation(driver, logger,Point_Value, methodName);
			String Power= Point_Value+Power_Units;
			logger.log(LogStatus.PASS, Power+ " Power from timeseries" +" & on UI " + UI_Power_Value);
			getFinalReport(driver, logger, methodName, true);			
			
		}catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
			logger.log(LogStatus.FAIL, "Error is :"+ e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2, description="Validate API data for Power widget AC_Capacity with Dashboard UI")
	public static void validate_API_AC_Capacity_DataWithUI(){
		try{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			DES_API_DataValidation_Page_Action desAPIDataValidation = new DES_API_DataValidation_Page_Action(driver, logger);
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);	
			
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=desAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDs_ACCapacity_jsonpath"),methodName);
			Power_Units=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("Point_IDs_ACCapacityUnit_jsonpath"),methodName);
			String timeSeriesPowerUrl=(CommonAPIfunctions.properties.getProperty("Timeseries_host")+Point_ID+"/samples?limit=1");
			logger.log(LogStatus.PASS,timeSeriesPowerUrl);
			CommonAPIfunctions.Get_API_Request(timeSeriesPowerUrl, Authorization, methodName);
			
			Point_Value=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("DCCapacitys_jsonpath"), methodName);
			String UI_AC_Capacity_Value=desAPIDataValidation.UI_AcCapacity_Validation(driver, logger, Point_Value, methodName);
			String AC_Capacity= Point_Value+Power_Units;
			logger.log(LogStatus.PASS, AC_Capacity+ " Power from timeseries" +" & on UI " + UI_AC_Capacity_Value+Power_Units);
			getFinalReport(driver, logger, methodName, true);			
			
		}catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
			logger.log(LogStatus.FAIL, "Error is :"+ e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2, description="Validate API data for Power widget BATTERY STATE OF HEALTH with Dashboard UI")
	public static void validate_API_BatteryStateOfHealth_DataWithUI(){
		try{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			DES_API_DataValidation_Page_Action desAPIDataValidation = new DES_API_DataValidation_Page_Action(driver, logger);
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);	
			
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=desAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDs_BSOH_jsonpath"),methodName);
			Power_Units=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("Point_IDs_BSOHUnit_jsonpath"),methodName);
			String timeSeriesPowerUrl=(CommonAPIfunctions.properties.getProperty("Timeseries_host")+Point_ID+"/samples?limit=1");
			logger.log(LogStatus.PASS,timeSeriesPowerUrl);
			CommonAPIfunctions.Get_API_Request(timeSeriesPowerUrl, Authorization, methodName);
			
			Point_Value=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("DCCapacitys_jsonpath"), methodName);
			String UI_BSOCH_Capacity_Value=desAPIDataValidation.UI_BSOCH_Validation(driver, logger, Point_Value, methodName);
			String BSOCH_Capacity= Point_Value+Power_Units;
			logger.log(LogStatus.PASS, BSOCH_Capacity+ " BATTERY STATE OF HEALTH from timeseries" +" & on UI " + UI_BSOCH_Capacity_Value);
			getFinalReport(driver, logger, methodName, true);			
		}catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
			logger.log(LogStatus.FAIL, "Error is :"+ e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=2, description="Validate API data for Last Data Collected with Dashboard UI")
	public static void validate_API_LastDataCollected_DataWithUI(){
		try{
			DES_API_Page_Action desAPI= new DES_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			DES_API_DataValidation_Page_Action desAPIDataValidation = new DES_API_DataValidation_Page_Action(driver, logger);
			Authorization="Bearer "+Access_token;
			System.out.println(Authorization);	
			
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=desAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDsHEARTBEAT_jsonpath"),methodName);
			//Power_Units=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("Point_IDs_BSOHUnit_jsonpath"),methodName);
			String timeSeriesPowerUrl=(CommonAPIfunctions.properties.getProperty("Timeseries_host")+Point_ID+"/samples?limit=1");
			logger.log(LogStatus.PASS,timeSeriesPowerUrl);
			CommonAPIfunctions.Get_API_Request(timeSeriesPowerUrl, Authorization, methodName);
			
			Point_Value=desAPI.getPointValueFromTimeSeries(CommonAPIfunctions.properties.getProperty("timeStamp_Val_jsonpath"), methodName);
			String UI_TimeStamp_Value=desAPIDataValidation.UITimeStamp_Validation(driver,logger,Point_Value,methodName);
			logger.log(LogStatus.PASS, Point_Value+ " UTC Time from timeseries" +" & on Dashboard it shows Local Site Time " + UI_TimeStamp_Value+" ");
				
			String[] date= Point_Value.split("T", 2);
			for(String day:date){
				System.out.println(day);
			}
			
			/*String browserLogs=driver.manage().logs().getAvailableLogTypes().toString();
			logger.log(LogStatus.PASS, "Browser Logs "+ browserLogs);	
			
			Iterator<LogEntry> logsx=driver.manage().logs().get(LogType.BROWSER).iterator();
			System.out.println("********************Client log "+logsx.next().getMessage().toString().toUpperCase());
			Iterator<LogEntry> logs2=driver.manage().logs().get(LogType.CLIENT).iterator();
			System.out.println("********************Client log "+logs2.next().getMessage().toString().toUpperCase());
			
			Iterator<LogEntry> logs3=driver.manage().logs().get(LogType.DRIVER).iterator();
			System.out.println("********************Drive log "+logs3.next().getMessage().toString().toUpperCase());
			
			Iterator<LogEntry> logs4=driver.manage().logs().get(LogType.PERFORMANCE).iterator();
			System.out.println("********************PERFORMANCE log "+logs4.next().getMessage().toString().toUpperCase());
			
			Iterator<LogEntry> logs5=driver.manage().logs().get(LogType.PROFILER).iterator();
			System.out.println("********************Browser log "+logs5.next().getMessage().toString().toUpperCase());*/
			desAPIDataValidation.analyzeLog();
			getFinalReport(driver, logger, methodName, true);
		}catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
			logger.log(LogStatus.FAIL, "Error is :"+ e.getMessage());
		}
	}
}
