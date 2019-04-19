package mars.JCI.Project.CEP.SmokeTesting;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_Page_Action;
import mars.JCI.Project.CEP.LeftPanel.CEP_LeftPanel_TestNG_Runner;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

public class CEP_LeftPanel_Smoke_TestNG_Runner extends BaseClass {
	@Test(description = "Validate Left Panel details loaded successfully")
	public void testLeftPanelLoad() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate Left Panel Tree Structure")
	public void testLeftPanelTreeStructure() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.user_validate_the_tree_structure_in_the_left_panel();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate BreadCrumb Sequence for JCI, Geography,Branch")
	public void testBreadCrumbSequence() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.validateBreadCrumbSequence();
			} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate Left Panel Search Functionality")
	public void testSearchFunctionality() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateSearchFunctionality();
			objLeftPanel.validateSearchByOtherItems();
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate Change in Dashboard after clicking on JCI")
	public void testDashboardAfterClickingJCI() {
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
	@Test(description = "Validate Change in Dashboard after clicking on Geography")
	public void testDashboardAfterClickingGeography() {
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
	@Test(description = "Validate Change in Dashboard after clicking on Country")
	public void testDashboardAfterClickingCountry() {
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
	@Test(description = "Validate Change in Dashboard after clicking on Branch")
	public void testDashboardAfterClickingBranch() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_LeftPanel_Page_Action objLeftPanel = new CEP_LeftPanel_Page_Action(driver,
					logger);
			objLogin.loginToCEPWithAdmin();
			objLeftPanel.user_is_on_overview_page();
			objLeftPanel.left_panel_details_loaded();
			objLeftPanel.validateOverviewTabAfterClickingElements("Albany GA - 0N91","4");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description = "Validate Trends Page after clicking on Chiller")
	public void testDashboardAfterClickingChiller() {
		try {
			CEP_LeftPanel_TestNG_Runner objLeftPanel = new CEP_LeftPanel_TestNG_Runner();
			objLeftPanel.testTrendsPageforChiller();
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
