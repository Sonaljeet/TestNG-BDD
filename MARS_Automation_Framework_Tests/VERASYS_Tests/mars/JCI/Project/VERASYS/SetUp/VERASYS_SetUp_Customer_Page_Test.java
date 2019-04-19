package mars.JCI.Project.VERASYS.SetUp;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonFunctions.WebElementCommon;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Action;

public class VERASYS_SetUp_Customer_Page_Test extends BaseClass {
	
	public static String cutsomer_name="AutoTest"+RandomStringUtils.randomAlphanumeric(3).toUpperCase();
			//
			//"AutoTestMJK";
	
	//Test Case to create new customer on the customer setup page.
	@Parameters({"adminUsername","adminPassword"})
    @Test(groups={"SmokeTest"},priority=0,description="Create New Customer using JCI Admin User on define Customer page on Set Up Screen")
	public void testCustomerSetupPage(String adminUsername, String adminPassword) {
    	boolean userLoggedIn;
		try {

			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_Setup_Customer_Page_Action customerPA = new VERASYS_Setup_Customer_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=customerPA.addNewCustomer(cutsomer_name);
				WebElementCommon.staticWait(5000);
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
			//loginPA.successfullLogout();
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	/*
	//Test Case to verify field validation on the customer setup page.
	@Parameters({"adminUsername","adminPassword"})
    @Test(priority=1,description="Create New Customer using JCI Admin User on define Customer page on Set Up Screen")
	public void validateCustomerSetupPage(String adminUsername, String adminPassword) {
    	boolean userLoggedIn=false;
		try {

			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_Setup_Customer_Page_Action customerPA = new VERASYS_Setup_Customer_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				customerPA.customerPageValidation();
				getFinalReport(driver, logger, methodName ,	true);
			}
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}*/

}
