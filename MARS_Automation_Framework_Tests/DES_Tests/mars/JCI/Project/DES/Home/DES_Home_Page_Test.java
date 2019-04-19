package mars.JCI.Project.DES.Home;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;

public class DES_Home_Page_Test extends BaseClass {

	public static DES_Home_Page_Action homePA=null;
	
	public DES_Home_Page_Test() {
		homePA= new DES_Home_Page_Action(driver, logger);
	}
	/**
	 * Test successful login.
	 *
	 * @param correctusername
	 *            the correctusername
	 * @param correctpassword
	 *            the correctpassword
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	
	
	// Test Cases for is Map PageHeadingPresent
	@Test(description="Performs a  checks whether the Home page is opened and MAP displayed ")
	public void testSuccessfulLogin() throws IOException { 
																											
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			homePA.isMapPresent();
			homePA.isUserMenuPresent();
			homePA.isMapPageHeadingPresent();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	 //Verify the Logged in user name
	@Test(description=" Checks Logged in user Details ")
		public void testLoggedInUserName() throws IOException { 																				
			try {
				DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
				DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
				homePA.loggedInUserName();
				getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
				getFinalReport(driver, logger, methodName, false);
			}
		}
	 
	@Test(description="Verify the names & Counts number of site or Site assigned and Displayed on Map to user ")
	public void testNumberOfMarkersAvailable() throws IOException { 
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			homePA.isMapPresent();
			homePA.isUserMenuPresent();
			homePA.isMapPageHeadingPresent();
			homePA.countNumberOfSiteMarkersPresent();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	
	@Test(description = "Navigates to Setup page ")
	public void testNavigationToSetupPage() throws IOException { // String
	try {
		homePA= new DES_Home_Page_Action(driver, logger);
		//homePA.clickeOnSetup();
		homePA.navigateToSetupPage();
		getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	

	@Test(description = "Performs a successful login and Navigates to DashBoard using Site Marker ")
	public void testVerifyNavigationToSiteOverviewFromHomePage() throws IOException { // String
	try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Home_Page_Action homePA = loginPA.DES_CorrectLogin();
			homePA.isMapPresent();
			homePA.isUserMenuPresent();
			homePA.isMapPageHeadingPresent();
			//homePA.navigateToDashBoard();
			homePA.navigateToSiteOverviewPage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
			}
	}
	

}
