package mars.JCI.Project.DES.VPPGroup;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;

public class DES_VPPGroup_Page_Test extends BaseClass {

	// Test Cases for navigation to VPP group tab
	@Test(priority = 1, description = "Performs a checks whether user able to navigate to VPP Group Page")
	public void testNavigationToVPPGroup() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_VPPGroup_Page_Action vppPA = new DES_VPPGroup_Page_Action(driver, logger);
			vppPA.navigateToVPPGroupTab();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for Addition of VVP Group to Customer
	@Test(priority = 2, description = "Performs a Test Cases for Addition of VVP Group to Customer")
	public void testAddVPPGroup() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_VPPGroup_Page_Action vppPA = new DES_VPPGroup_Page_Action(driver, logger);
			vppPA.addVPPGroup();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for Deletion of VVP Group to Customer
	@Test(priority = 3, description = "Performs a Test Cases for Deletion of VVP Group to Customer")
	public void testDeleteVPPGroup() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_VPPGroup_Page_Action vppPA = new DES_VPPGroup_Page_Action(driver, logger);
			vppPA.deleteVppGroup();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for drag site under VPP group of Customer

	@Test(priority = 4, description = "Test Cases for Drag site under VPP group of Customer")
	public void testAddSiteUnderGroup() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_VPPGroup_Page_Action vppPA = new DES_VPPGroup_Page_Action(driver, logger);
			vppPA.addSiteUnderGroup();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for drag site under VPP group of Customer
	@Test(priority = 5, description = "Test Cases for Remove site under VPP group of Customer")
	public void testRemoveSiteUnderGroup() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_VPPGroup_Page_Action vppPA = new DES_VPPGroup_Page_Action(driver, logger);
			vppPA.removeAsignedSiteFromGroup();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// Test Cases for drag site under VPP group of Customer
	@Test(priority = 6, description = "Test Cases for Remove All VPP group of Customer and Assigns All sites to Customer")
	public void testRemoveVPPGroup() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_VPPGroup_Page_Action vppPA = new DES_VPPGroup_Page_Action(driver, logger);
			vppPA.navigateToVPPGroupTab();
			vppPA.deleteAllGroups();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
