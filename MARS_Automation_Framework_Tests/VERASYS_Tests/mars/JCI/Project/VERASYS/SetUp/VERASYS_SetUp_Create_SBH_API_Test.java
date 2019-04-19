package mars.JCI.Project.VERASYS.SetUp;
import org.json.JSONException;
import org.json.JSONObject;
import io.restassured.http.Header;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.sl.usermodel.Resources;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commonFunctionsAPI.CommonAPI_Functions;
import mars.Business.Layer.ReadJsonFile;
import mars.Component.Functions.API_BaseClass;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Action;

public class VERASYS_SetUp_Create_SBH_API_Test extends API_BaseClass { 
	public static String Access_token="",Authorization;
	public static List<String> Device_id;
	private String Device_Id= "Auto"+RandomStringUtils.randomAlphanumeric(3).toUpperCase();
	
	/**
	 * AP I to get access token.
	 */
	@SuppressWarnings("static-access")
	@Test(groups={"SmokeTest","Add Device"},priority=0,description="API to get the accesstoken for authentication For Verasys DATA SECURITY API")
	public static void API_to_AccessToken()
	{
		try
		{
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			CommonAPI_Functions.loadProperties();
			//String create_device_body= ReadJsonFile.readJsonFileDynamic("Create_Device_Request_Body",properties.getProperty("Access_Token_jsonpath"));
			CommonAPIfunctions.POST_API_Request(CommonAPI_Functions.properties.getProperty("Verasystoken_url"),
					CommonAPI_Functions.properties.getProperty("Verasys_Authorization"),new Header("Content-Type",CommonAPI_Functions.properties.getProperty("Header_Content_type")),
					CommonAPI_Functions.properties.getProperty("verasys_request_body"),methodName);
			Access_token=CommonAPI_Functions.GetToken(methodName);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	@SuppressWarnings("static-access")
	@Test(groups={"SmokeTest","Add Device"},priority=1,description="API_to_Create Device")
	public void API_to_Create_Device() 
	{
		try
		{
		String content = readFile(CommonAPI_Functions.properties.getProperty("Jsonresponse_filepath")+"\\Create_Device_Request_Body.json", StandardCharsets.UTF_8);
		CommonAPI_Functions.loadProperties();
			//MEMS_API_Page_Action memsAPI = new MEMS_API_Page_Action(logger);
			CommonAPI_Functions CommonAPIfunctions=new CommonAPI_Functions(logger);
			Authorization="Bearer "+Access_token;
			CommonAPIfunctions.POST_API_Request(CommonAPI_Functions.properties.getProperty("Create_Device_url")+Device_Id,
					Authorization,new Header("Content-Type",CommonAPI_Functions.properties.getProperty("Header_Content_type_Create_Device")),
					content,methodName);
		 Device_id=ReadJsonFile.readJsonFileDynamic(CommonAPI_Functions.FILENAME,CommonAPI_Functions.properties.getProperty("Created_Device_id"));
			logger.log(LogStatus.PASS, "Successfully created device with Device ID as:   "+Device_id.get(0).toString());
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}

	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},priority=2,description="To validate Cancel button functionality on SBH device page")
	public void testCancelFunction(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHPA.verifyCancel(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,Device_id.get(0).toString());
				//Device_id.get(0).toString()
				//""AutoTestMJK""
				//VERASYS_SetUp_Customer_Page_Test.cutsomer_name
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},priority=3,description="To validate confirmation message cancel button functionality on SBH device page")
	public void testCNFCancelFunction(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHPA.verifyCnfCancel(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,Device_id.get(0).toString());
				//Device_id.get(0).toString()
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest","Add Device"},priority=4,description="To validate and add newly created device to customer on SBH device page")
	public void testXAddDeviceFunction(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHPA.addDevice(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,Device_id.get(0).toString());
				//Device_id.get(0).toString()
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},priority=5,description="To validate incorrect device id could not be added to customer on SBH device page")
	public void testYInvalidDevice(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHPA.validateIncorrectDevice(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,Device_id.get(0).toString());
				//Device_id.get(0).toString()
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},priority=6,description="To validate Existing device could not be added to customer on SBH device page")
	public void testZExistingDevice(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHPA.validateAddedDevice(VERASYS_SetUp_Customer_Page_Test.cutsomer_name);
				//Device_id.get(0).toString()
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	/*@DataProvider(name = "SBHSiteData")
	private static Object[][] data() {
		 
        // The number of times data is repeated, test will be executed the same no. of times
 
        // Here it will execute two times
 
        return new Object[][] {{"SBH_100" },{"SBH_101" },{"SBH_102" },{"SBH_103" },{"SBH_104" },{"SBH_105" },{"SBH_106" },{"SBH_109" }};
 //,{"SBH_100" },{"SBH_101" },{"SBH_102" },{"SBH_103" },{"SBH_104" },{"SBH_105" },{"SBH_106" },{"SBH_109" }
  }*/
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},dependsOnGroups={"associate SBH"},priority=6,dataProvider="SBHSiteData",description="To validate Remove device functionality when SBH is NOT mapped to any site of the customer on SBH page")
	public void testZRemoveDevice(String adminUsername,String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHPA.validateRemoveDevice(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,Device_id.get(0).toString());
				//,VERASYS_SetUp_Customer_Page_Test.cutsomer_name,Device_id.get(0).toString()
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest","Add Device"},priority=4,description="To Add presviously removed device to same customer on SBH page")
	public void testZAddDeviceFunction(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Create_SBH_Page_Action SBHPA = new VERASYS_SetUp_Create_SBH_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHPA.addDevice(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,Device_id.get(0).toString());
				//Device_id.get(0).toString()
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
}
