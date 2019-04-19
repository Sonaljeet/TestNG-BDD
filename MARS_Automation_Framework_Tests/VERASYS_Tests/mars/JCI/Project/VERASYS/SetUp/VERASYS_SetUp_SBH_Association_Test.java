package mars.JCI.Project.VERASYS.SetUp;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Action;

public class VERASYS_SetUp_SBH_Association_Test extends BaseClass {
	
	/*@DataProvider(name = "SBHSiteData")
	private static Object[][] data() {
		 
        // The number of times data is repeated, test will be executed the same no. of times
 
        // Here it will execute two times
 
        return new Object[][] {{ "LGSite4", "SBH_102" },{ "LGSite 8", "SBH_104" },{ "LGsite8", "SBH_104" },{ "LGsite2", "SBH_106" }};
 
  }*/
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest","associate SBH"},description="To verify SBH association to customer site")
	public void testSBHAssociation(String adminUsername,String adminPassword){

		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_SBH_Association_Page_Action SBHAssociatn=new VERASYS_SetUp_SBH_Association_Page_Action(driver,logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHAssociatn.validateDeviceAssociation(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,VERASYS_SetUp_Site_Page_Test.site_name,VERASYS_SetUp_Create_SBH_API_Test.Device_id.get(0).toString());
				//VERASYS_SetUp_Customer_Page_Test.cutsomer_name,VERASYS_SetUp_Site_Page_Test.site_name,VERASYS_SetUp_Create_SBH_API_Test.Device_id.get(0).toString();
			}
			getFinalReport(driver, logger, methodName, userLoggedIn);
		}catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
		
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest","associate SBH"},description="To verify SBH unmapping from customer site",dataProvider="SBHSiteData")
	public void testSBHUnMapping(String adminUsername,String adminPassword){

		boolean userLoggedIn;
		try
		{
			
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_SBH_Association_Page_Action SBHAssociatn=new VERASYS_SetUp_SBH_Association_Page_Action(driver,logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHAssociatn.validateDeviceUnmapping(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,VERASYS_SetUp_Site_Page_Test.site_name,VERASYS_SetUp_Create_SBH_API_Test.Device_id.get(0).toString());
				//VERASYS_SetUp_Customer_Page_Test.cutsomer_name,VERASYS_SetUp_Site_Page_Test.site_name,VERASYS_SetUp_Create_SBH_API_Test.Device_id.get(0).toString();
			}
			getFinalReport(driver, logger, methodName, userLoggedIn);
		}catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
		
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest","associate SBH"},description="To verify previously umapped device could be associated again to customer site")
	public void testSBHVAssociation(String adminUsername,String adminPassword){

		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_SBH_Association_Page_Action SBHAssociatn=new VERASYS_SetUp_SBH_Association_Page_Action(driver,logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=SBHAssociatn.validateDeviceAssociation(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,VERASYS_SetUp_Site_Page_Test.site_name,VERASYS_SetUp_Create_SBH_API_Test.Device_id.get(0).toString());
				//VERASYS_SetUp_Customer_Page_Test.cutsomer_name,VERASYS_SetUp_Site_Page_Test.site_name,VERASYS_SetUp_Create_SBH_API_Test.Device_id.get(0).toString();
			}
			getFinalReport(driver, logger, methodName, userLoggedIn);
		}catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
		
	}
}
