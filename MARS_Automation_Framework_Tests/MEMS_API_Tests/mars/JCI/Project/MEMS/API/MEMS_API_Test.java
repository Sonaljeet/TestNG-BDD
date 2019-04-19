package mars.JCI.Project.MEMS.API;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctionsAPI.CommonAPI_Functions;
import io.restassured.http.Header;
import mars.Component.Functions.API_BaseClass;
import mars.JCI.Project.MEMS.API.MEMS_API_Datavalidation_Action;
import mars.JCI.Project.MEMS.API.MEMS_API_Page_Action;

public class MEMS_API_Test extends API_BaseClass { 
	public static String Access_token="",Authorization,Point_ID="";
	public static long Hourlyaddition=0L;
	
	/**
	 * AP I to get access token.
	 */
	@SuppressWarnings("static-access")
	@Test(priority=0,description="API to get the accesstoken for authentication")
	public static void API_to_getAccessToken()
	{
		try
		{
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			CommonAPIfunctions.POST_API_Request(CommonAPI_Functions.properties.getProperty("Token_URL"),
					CommonAPI_Functions.properties.getProperty("Authorization"),new Header("Content-Type",CommonAPI_Functions.properties.getProperty("Header_Content_type")),
					CommonAPI_Functions.properties.getProperty("request_body"),methodName);
			Access_token=CommonAPI_Functions.GetToken(methodName);
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
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			Authorization="Bearer "+Access_token;
			CommonAPIfunctions.Get_API_Request(CommonAPIfunctions.properties.getProperty("Point_URL"), Authorization,methodName);
			Point_ID=memsAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Point_IDs_jsonpath"),methodName); 
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	@SuppressWarnings("static-access")
	@Test(priority=2,description="API to get the Hourly Data")
	public static void API_to_getHourlyData() 
	{
		try
		{
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String HourlyData_URL=CommonAPIfunctions.properties.getProperty("Timeseries_host")+"/"+Point_ID +"."+"DeltaHourly/?startTime="+CommonAPIfunctions.properties.getProperty("StartTime")+"&endTime="+CommonAPIfunctions.properties.getProperty("EndTime")+"&convertedUnitsId="+CommonAPIfunctions.properties.getProperty("ConvertedUnitsId");
			CommonAPIfunctions.Get_API_Request(HourlyData_URL, Authorization,methodName);
			Hourlyaddition=memsAPI.HourlyValAddition(CommonAPIfunctions.properties.getProperty("Hourly_Daily_temparature_jsonpath"),methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=3,description="API to get the Daily Data")
	public static void API_to_getDailyData() 
	{
		try
		{	
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String Daily_Data_URL=CommonAPIfunctions.properties.getProperty("Timeseries_host")+"/"+Point_ID +"."+"DeltaDaily/?startTime="+CommonAPIfunctions.properties.getProperty("StartTime")+"&endTime="+CommonAPIfunctions.properties.getProperty("EndTime")+"&convertedUnitsId="+CommonAPIfunctions.properties.getProperty("ConvertedUnitsId");
			CommonAPIfunctions.Get_API_Request(Daily_Data_URL, Authorization,methodName);
			memsAPI.GetvalKeyvalue(CommonAPIfunctions.properties.getProperty("Hourly_Daily_temparature_jsonpath"),methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage()); 
		}
	}
	@SuppressWarnings("static-access")
	@Test(priority=4,description="API to get the Weather Station Data")
	public static void API_to_getWeatherStationData() 
	{
		try
		{	
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String Weather_Station_Data_URL=CommonAPIfunctions.properties.getProperty("API")+"/"+CommonAPIfunctions.properties.getProperty("WeatherStation_URL");
			CommonAPIfunctions.Get_API_Request(Weather_Station_Data_URL,Authorization,methodName);
			Point_ID=memsAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Weather_Station_jsonpath"),methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	@SuppressWarnings("static-access")
	@Test(priority=5,description="API to get the Average temparature Data")
	public static void API_to_get_Average_temparature_Data()
	{
		try
		{	
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String Average_temparature_Data_URL=CommonAPIfunctions.properties.getProperty("Timeseries_host")+"/"+Point_ID +"."+"AverageHourly/?startTime="+CommonAPIfunctions.properties.getProperty("StartTime")+"&endTime="+CommonAPIfunctions.properties.getProperty("EndTime");
			CommonAPIfunctions.Get_API_Request(Average_temparature_Data_URL, Authorization,methodName);
			memsAPI.GetvalKeyvalue(CommonAPIfunctions.properties.getProperty("Max_Min_Avg_temparature_jsonpath"),methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage()); 
		}
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=6,description="API to get the Minimum temparature Data with UI Validation")
	public static void API_to_get_Minimum_temparature_Data_with_UI_Validation()
	{
		try
		{	
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String Minimum_temparature_Data_URL=CommonAPIfunctions.properties.getProperty("Timeseries_host")+"/"+Point_ID +"."+"MinHourly/?startTime="+CommonAPIfunctions.properties.getProperty("StartTime")+"&endTime="+CommonAPIfunctions.properties.getProperty("EndTime");
			CommonAPIfunctions.Get_API_Request(Minimum_temparature_Data_URL, Authorization,methodName);
			MEMS_API_Datavalidation_Action memsAPI_Datavalidation = new MEMS_API_Datavalidation_Action(driver,logger);
			String value=memsAPI.GetvalKeyvalue(CommonAPIfunctions.properties.getProperty("Max_Min_Avg_temparature_jsonpath"),methodName);
			memsAPI_Datavalidation.UI_Datavalidation(driver,logger,value,methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	@SuppressWarnings("static-access")
	@Test(priority=7,description="API to get the Maximum temparature Data")
	public static void API_to_get_Maximum_temparature_Data() 
	{
		try
		{	
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String Maximum_temparature_Data_URL=CommonAPIfunctions.properties.getProperty("Timeseries_host")+"/"+Point_ID +"."+"MaxHourly/?startTime="+CommonAPIfunctions.properties.getProperty("StartTime")+"&endTime="+CommonAPIfunctions.properties.getProperty("EndTime");		
			CommonAPIfunctions.Get_API_Request(Maximum_temparature_Data_URL, Authorization,methodName);
			memsAPI.GetvalKeyvalue(CommonAPIfunctions.properties.getProperty("Max_Min_Avg_temparature_jsonpath"),methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage()); 
		}
	}
	@SuppressWarnings("static-access")
	@Test(priority=8,description="API to get the Current Weather Point_ID Data")
	public static void API_to_get_CurrentWeather_Point_ID__Data() 
	{
		try
		{	
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String Current_Weather_Point_id_Data_URL=CommonAPIfunctions.properties.getProperty("API")+"/"+CommonAPIfunctions.properties.getProperty("WeatherStation_URL");
			CommonAPIfunctions.Get_API_Request(Current_Weather_Point_id_Data_URL, Authorization,methodName);
			Point_ID=memsAPI.GetPointIDfromValueArray(CommonAPIfunctions.properties.getProperty("Capture_Current_temparature_Point_id_jsonpath"),methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	@SuppressWarnings("static-access")
	@Test(priority=9,description="API to get the Current Weather PointCode Data")
	public static void API_to_get_Current_Weather_PointCode_Data()
	{
		try
		{	
			MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			String Current_Weather_PointCode_Data_URL=CommonAPIfunctions.properties.getProperty("Timeseries_host")+"/"+Point_ID +"."+"ModeHourly/?startTime="+CommonAPIfunctions.properties.getProperty("StartTime")+"&endTime="+CommonAPIfunctions.properties.getProperty("EndTime");
			CommonAPIfunctions.Get_API_Request(Current_Weather_PointCode_Data_URL, Authorization,methodName);
			memsAPI.GetvalKeyvalue(CommonAPIfunctions.properties.getProperty("Max_Min_Avg_temparature_jsonpath"),methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
}