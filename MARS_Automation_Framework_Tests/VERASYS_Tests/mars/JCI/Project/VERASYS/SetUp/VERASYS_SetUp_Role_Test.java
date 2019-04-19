package mars.JCI.Project.VERASYS.SetUp;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Action;

public class VERASYS_SetUp_Role_Test extends BaseClass {
	
	public static String role_name= "AutoCustomerAdmin";
	//+RandomStringUtils.randomAlphanumeric(3).toUpperCase();
	
	@Parameters({"adminUsername","adminPassword"})//groups={"SmokeTest"}
	@Test(description="To verify JCI admin User is able to create Role")
	public void testCreateRole(String adminUsername,String adminPassword){

		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Role_Page_Action rolePA=new VERASYS_SetUp_Role_Page_Action(driver,logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=rolePA.creatNewRole(role_name, "Role Created using Automation Script");
		}
			getFinalReport(driver, logger, methodName, userLoggedIn);
		}catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
		
	}
	
	/*@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest"},description="To verify JCI admin User is able to Update Role")
	public void testUpdateRole(String adminUsername,String adminPassword){

		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Role_Page_Action rolePA=new VERASYS_SetUp_Role_Page_Action(driver,logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=rolePA.updateNewRole(role_name, "Role Created using Automation Script");
		}
			getFinalReport(driver, logger, methodName, userLoggedIn);
		}catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
		
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},description="To verify JCI admin User is able to Delete Role")
	public void testzDeleteRole(String adminUsername,String adminPassword){

		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Role_Page_Action rolePA=new VERASYS_SetUp_Role_Page_Action(driver,logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=rolePA.deleteNewRole(role_name);
		}
			getFinalReport(driver, logger, methodName, userLoggedIn);
		}catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
		
	}
	
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},description="To verify cancel button functionality on Role Page")
	public void testVerifyCancel(String adminUsername,String adminPassword){

		boolean userLoggedIn;
		try
		{
			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_SetUp_Role_Page_Action rolePA=new VERASYS_SetUp_Role_Page_Action(driver,logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=rolePA.verifyCancel(role_name, "Role Created using Automation Script");
		}
			getFinalReport(driver, logger, methodName, userLoggedIn);
		}catch(Exception e)
		{
			logger.log(LogStatus.FAIL, "Error is:   "+e.getMessage());
		}
		
	}*/

}
