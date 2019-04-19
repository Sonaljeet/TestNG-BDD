package mars.JCI.Project.VERASYS.SetUp;

import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Action;

public class VERASYS_SetUp_AccessRight_Test extends BaseClass {
	@Parameters({"adminUsername","adminPassword"})//groups={"SmokeTest"},
	@Test(description="To assign access right to the Customer Admin role")
	public void testAssignCustomerAdminAccessRights(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			HashMap<String, String> permissions = new HashMap<String, String>();

		     // Creating permission set for Customer Admin Role
			permissions.put("Site", "Edit");
			permissions.put("SBH", "Edit");
			permissions.put("SBH Association", "Edit");
			permissions.put("Role", "View");
			permissions.put("Access Rights", "View");
			permissions.put("User", "Edit");
			permissions.put("User-Site Mapping", "Edit");
			permissions.put("Overview", "Edit");
			permissions.put("Details", "Edit");
			permissions.put("Alarm", "Edit");
			permissions.put("Report", "Edit");
			permissions.put("Trend", "Edit");
			
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_AccessRight_Page_Action accessPA = new VERASYS_SetUp_AccessRight_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=accessPA.setAccessRights(VERASYS_SetUp_Role_Test.role_name, permissions);	
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	/*
	@Parameters({"adminUsername","adminPassword"})//groups={"SmokeTest"},
	@Test(description="To assign access right to Facility Manager Role")
	public void testFacilityManagerAccessRights(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			HashMap<String, String> permissions = new HashMap<String, String>();

		      Creating permission set for Facility Manager Role
			permissions.put("Overview", "View");
			permissions.put("Details", "View");
			permissions.put("Alarm", "View");
			permissions.put("Report", "View");
			permissions.put("Trend", "View");
			
			
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_AccessRight_Page_Action accessPA = new VERASYS_SetUp_AccessRight_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=accessPA.setAccessRights(VERASYS_SetUp_Role_Test.role_name, permissions);	
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@Parameters({"adminUsername","adminPassword"})//groups={"SmokeTest"},
	@Test(description="To assign access right to Read Only Role")
	public void testReadOnlyAccessRights(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			HashMap<String, String> permissions = new HashMap<String, String>();

		      Creating permission set for Read Only Role
			permissions.put("Overview", "View");
			permissions.put("Details", "View");
			permissions.put("Alarm", "View");
			permissions.put("Report", "View");
			permissions.put("Trend", "View");
			
			
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_AccessRight_Page_Action accessPA = new VERASYS_SetUp_AccessRight_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=accessPA.setAccessRights(VERASYS_SetUp_Role_Test.role_name, permissions);	
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
	
	@Parameters({"adminUsername","adminPassword"})//groups={"SmokeTest"},
	@Test(description="To assign access right to Technician Role")
	public void testTechnicianAccessRights(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			HashMap<String, String> permissions = new HashMap<String, String>();

		      Creating permission set for Technician Role
			permissions.put("Site", "Edit");
			permissions.put("SBH", "Edit");
			permissions.put("SBH Association", "Edit");
			permissions.put("Overview", "Edit");
			permissions.put("Details", "Edit");
			permissions.put("Alarm", "Edit");
			permissions.put("Report", "Edit");
			permissions.put("Trend", "Edit");
			
			
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_AccessRight_Page_Action accessPA = new VERASYS_SetUp_AccessRight_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=accessPA.setAccessRights(VERASYS_SetUp_Role_Test.role_name, permissions);	
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}*/
	
	@Parameters({"adminUsername","adminPassword"})//groups={"SmokeTest"},
	@Test(description="To test cancel button functionality on Access Right Page")
	public void testTestCancelAccessRights(String adminUsername, String adminPassword) 
	{
		boolean userLoggedIn;
		try
		{
			
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_AccessRight_Page_Action accessPA = new VERASYS_SetUp_AccessRight_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=accessPA.verifyCancelBtn(VERASYS_SetUp_Role_Test.role_name);	
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
	}
}
