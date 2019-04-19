package mars.JCI.Project.CEP.LeftPanel;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

public class CEP_LeftPanel_TestNG_Runner extends BaseClass {
//	@Test(priority = 0, description = "Validating Login")
//	public void testLeftPanelLogin() {
//
//		try {
//			CEP_Login_Page_Action cepLogin = new CEP_Login_Page_Action(driver, logger);
//			cepLogin.enterAdminCredential();
//			cepLogin.clickLogin();
//			getFinalReport(driver, logger, methodName, true);
//		} catch (Exception e) {
//			e.printStackTrace();
//			getFinalReport(driver, logger, methodName, false);
//		}
//	}
//
//	@Test(priority = 1, description = "Validating Left Panel")
//	public void testLeftPanelAdmin() {
//
//		try {
//			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver, logger);
//			testLeftPanelLogin();
//			objLeftPanel.user_is_on_overview_page();
//			objLeftPanel.left_panel_details_loaded();
//			objLeftPanel.user_validates_active_tab();
//			getFinalReport(driver, logger, methodName, true);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			getFinalReport(driver, logger, methodName, false);
//		}
//	}
	@Test(priority = 0, description = "TC78732-Verify left panel navigation tree for user mapped with more than one geography")
	public void testTreeMoreThanOneGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.user_validate_the_tree_structure_in_the_left_panel();
			objLeftPanel.validateDatawithDB();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 1,description = "TC78733-Verify left panel navigation tree for user mapped with one geography")
	public void testTreeOneGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_OneGeography_Page_Action objLeftPanel = new CEP_LeftPanel_OneGeography_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithOneGeographyUser();
			objLeftPanel.validateLeftPanelTreeStructure();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 2,description = "TC78740-Verify default selected tab for user mapped with more than one geography")
	public void testDefaultTabMoreThanOneGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateDefaultTab();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 3,description = "TC78921-Verify default selected tab in left panel for user with one geography")
	public void testDefaultTabOneGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_OneGeography_Page_Action objLeftPanel = new CEP_LeftPanel_OneGeography_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithOneGeographyUser();
			objLeftPanel.validateDefaultTab();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 4,description = "TC78743-Verify active tab to be displayed on default selected tab in left panel navigation tree ")
	public void testActiveTabInLeftPanel() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.user_validates_active_tab();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 5,description = "TC78746-Verify active tab to be displayed on the tab based on the selection made by user")
	public void testActiveTabBasedOnSelection() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateActiveTabBasedOnSelection();
			logger.log(LogStatus.PASS, "Tab is getting selected and active tab is displayed based on the selection by the user.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 6,description = "TC78747-Verify state of overview page change to default after refreshing of page")
	public void testOverviewPageRefresh() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.refreshStatus();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 7,description = "TC78852-Verify Overview tab displayed when 'JCI' is selected in left panel navigation tree")
	public void testOverviewTabforJCI() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("JCI","1");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 8,description = "TC78853-Verify Overview tab displayed when Geography is selected in left panel navigation tree")
	public void testOverviewTabforGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("North America","2");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 9,description = "TC78854-Verify Overview tab displayed when Country is selected in left panel navigation tree")
	public void testOverviewTabforCountry() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("United States","3");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	String branch=CEP_LeftPanel_DataBase_Action.branchNameForUS();
	@Test(priority = 10,description = "TC78855-Verify Overview tab displayed when Branch is selected in left panel navigation tree")
	public void testOverviewTabforBranch() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements(branch,"4");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	String customer=CEP_LeftPanel_DataBase_Action.customerListDB(branch).get(0);
	@Test(priority = 11,description = "TC78856-Verify Overview tab displayed when Customer is selected in left panel navigation tree")
	public void testOverviewTabforCustomer() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements(customer,"5");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	String site=CEP_LeftPanel_DataBase_Action.siteListDB(customer).get(0);
	@Test(priority = 12,description = "TC78857-Verify Overview tab displayed when Site is selected in left panel navigation tree")
	public void testOverviewTabforSite() {
		try {
			CEP_LeftPanel_Page_Factory objLeftPanelPageFactory = new CEP_LeftPanel_Page_Factory(driver);
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanelPageFactory.customerArrowForFirstCustomer(customer);
			objLeftPanel.validateOverviewTabAfterClickingElements(site,"6");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 13,description = "TC78858-Verify Trends page to be displayed when Chiller is selected in left panel navigation tree")
	public void testTrendsPageforChiller() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			//objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			Thread.sleep(20000);
			CEP_LeftPanel_Page_Factory objLeftPanelPageFactory = new CEP_LeftPanel_Page_Factory(driver);
			objLeftPanelPageFactory.customerArrowForFirstCustomer(customer);
			objLeftPanelPageFactory.projectArrowForFirstSite(site);
			String chiller=CEP_LeftPanel_DataBase_Action.chillerListDB(customer).get(0);
			objLeftPanel.validateTrendsPageForChiller(chiller,"7");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 14,description = "TC78912-Verify breadcrumb sequences in Overview tab")
	public void testBreadCrumbSequence() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.validateBreadCrumbSequence();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 15,description = "TC81027-To verify the search functionality of left navigation tree")
	public void testSearchFunctionality() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateSearchFunctionality();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 16,description = "TC81389-Verify overview tab in left panel for user with one geography")
	public void testOverviewTabOneGeography() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_OneGeography_Page_Action objLeftPanel = new CEP_LeftPanel_OneGeography_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithOneGeographyUser();
			objLeftPanel.validateOverviewTab();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
