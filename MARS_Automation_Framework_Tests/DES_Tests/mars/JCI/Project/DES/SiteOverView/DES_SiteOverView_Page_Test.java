package mars.JCI.Project.DES.SiteOverView;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.SiteOverview.DES_SiteOverview_Page_Action;

public class DES_SiteOverView_Page_Test extends BaseClass{
	
	
	@Test(priority=0, description="Performs a successful login and Navigation to Site overview page ")
	public void testNavigateToDashboard() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			//homePA.navigateToDashBoard();
			homePA.navigateToSiteOverviewPage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=0, description="Navigation to Site overview page and get list of Customers ")
	public void testListOfCustomersPresentOnDashboard() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA=loginPA.DES_CorrectLogin();
			sitePA.getListOfCustomer();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	
	
		
	@Test(priority=0, description=" Search site on Dashboard and View Site details ")	
	public void testSearchonDashBoard() throws IOException { 
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA=loginPA.DES_CorrectLogin();
			sitePA.getSiteFromDashBoard();
							
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=0, description="Validates the site info. widgets are loaded successfully   ")
	public void testSiteOverviewDetails() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA=loginPA.DES_CorrectLogin();			
			sitePA.validateSiteOverviewWidgetsLoad();
							
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	

	
	@Test(priority=0, description="Performs Power widget details validations")
	public void testEnergyDetails() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			sitePA.getPowerDetails();
							
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=0, description="Performs System health widget details validation ")
	public void testSystemHealthDetails() throws IOException {																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			sitePA.getBatteryStateHealthDetails();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	
	@Test(priority=0, description="Performs Site Info widget details validation ")
	public void testSiteInfoWidget() throws IOException { 
			try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			sitePA.getSiteInfo();							
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	
	@Test(priority=0, description="Performs SOC Treand Graph widget details validation ")
	public void testOverviewPageSOCTrendGraph() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();			
			sitePA.getSOCTrendGraph();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority=0, description="Performs Currunt Power Trend Graph widget details validation ")
	public void testOverviewPagePowerTrendGraph() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			sitePA.getcurrentPowerTrendGraph();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=0, description="Performs Validation on Alarm widget details validation ")
	public void testOverviewPageAlarms() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			sitePA.getAlarmsDetailsForSite();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
		
	//@Test(priority=0, description="Performs All Widgets and Graphs details validation on Site Overview Page ")
	public void testOverviewPageAllWidgets() throws IOException { 
	try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_SiteOverview_Page_Action sitePA= new DES_SiteOverview_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			sitePA.validateSiteOverviewWidgets();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
