package mars.JCI.Project.VERASYS.SetUp;


import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonFunctions.WebElementCommon;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Action;

public class VERASYS_SetUp_Site_Page_Test extends BaseClass {


	public static String site_name= "Auto"+RandomStringUtils.randomAlphanumeric(3).toUpperCase();

	//Test Case to create new site for existing customer on the Site setup page.
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest"},priority=0,description="Create new site for existing customer using JCI Admin user on set up screen")
	public void testCreateSite(String adminUsername, String adminPassword) {
		boolean userLoggedIn;
		try {

			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_Setup_Site_Page_Action sitePA = new VERASYS_Setup_Site_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			site_name=randomSiteName();
			if(userLoggedIn){
				userLoggedIn=sitePA.addSite(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,site_name);
				//VERASYS_SetUp_Customer_Page_Test.cutsomer_name,"AutoTestZGI"
				WebElementCommon.staticWait(5000);
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
			//loginPA.successfullLogout();
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	//Test Case to update created site on the Site setup page.
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest"},description="Update existing site on the Site setup page using JCI Admin user on set up screen")
	public void testUpdateSite(String adminUsername, String adminPassword) {
		boolean userLoggedIn;
		try {

			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_Setup_Site_Page_Action sitePA = new VERASYS_Setup_Site_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=sitePA.updateSite(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,site_name);
				WebElementCommon.staticWait(5000);
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
			loginPA.successfullLogout();
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	private String randomSiteName()
	{
		site_name= RandomStringUtils.randomAlphanumeric(3).toUpperCase();
		return site_name;
	}

	//Test Case to delete created site on the Site setup page.
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"RegressionTest"},dependsOnGroups={"Add Device"},description="Delete existing site on the Site setup page using JCI Admin user on set up screen")
	public void testXDeleteSite(String adminUsername, String adminPassword) {
		boolean userLoggedIn;
		try {

			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_Setup_Site_Page_Action sitePA = new VERASYS_Setup_Site_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=sitePA.deleteSite(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,site_name);
				WebElementCommon.staticWait(5000);
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
			//	loginPA.successfullLogout();
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}	
	
	//Test Case to create site again with same name as previously deleted
	@Parameters({"adminUsername","adminPassword"})
	@Test(groups={"SmokeTest"},priority=0,description="Create Site with same name as previously deleted site for existing customer using JCI Admin user on set up screen")
	public void testZCreateSite(String adminUsername, String adminPassword) {
		boolean userLoggedIn;
		try {

			VERASYS_Login_Page_Action loginPA = new VERASYS_Login_Page_Action(driver, logger);
			VERASYS_Setup_Site_Page_Action sitePA = new VERASYS_Setup_Site_Page_Action(driver, logger);
			userLoggedIn=loginPA.correctLogin(adminUsername, adminPassword);
			if(userLoggedIn){
				userLoggedIn=sitePA.addSite(VERASYS_SetUp_Customer_Page_Test.cutsomer_name,site_name);
				//VERASYS_SetUp_Customer_Page_Test.cutsomer_name,"AutoTestZGI"
				WebElementCommon.staticWait(5000);
			}
			getFinalReport(driver, logger, methodName ,	userLoggedIn);
			//loginPA.successfullLogout();
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
