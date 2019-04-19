package mars.JCI.Project.DES.Site;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.VPPGroup.DES_VPPGroup_Page_Action;

public class DES_Site_Page_Test extends BaseClass {

	// Test Cases for navition to Site Page
	@Test(description="Performs a checks whether user able to navigate to Site Page")
	public void testNavigationToSitePage() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Site_Page_Action sitePA = new DES_Site_Page_Action(driver, logger);
			sitePA.navigateToSitePage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for select Customer
	
	@Test(description = "Performs a  checks whether user able to Add Site to Customer")
	public void testToCreateNewSite() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_Site_Page_Action sitePA = new DES_Site_Page_Action(driver, logger);
			//sitePA.selectCustomer("JCI Cheesland");
			sitePA.addSite();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	
	// Test Cases for select Customer
		@Test(description = "Performs a  checks whether user able to update Site")
		public void testToUpdateSiteDetails() throws IOException {
			try {
				DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
				DES_Site_Page_Action sitePA = new DES_Site_Page_Action(driver, logger);
				sitePA.updateSiteDetails();
				getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
				getFinalReport(driver, logger, methodName, false);
			}
		}
		
		@Test(description = "Performs a  checks whether user able to Delete Site")
		public void testToDeleteSite() throws IOException {
			try {
				DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
				DES_Site_Page_Action sitePA = new DES_Site_Page_Action(driver, logger);
				sitePA.DeleteSite();
				getFinalReport(driver, logger, methodName, true);
			} catch (Exception e) {
				getFinalReport(driver, logger, methodName, false);
			}
		}
}
