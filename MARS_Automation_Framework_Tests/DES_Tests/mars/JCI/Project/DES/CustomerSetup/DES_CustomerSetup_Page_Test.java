package mars.JCI.Project.DES.CustomerSetup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;

public class DES_CustomerSetup_Page_Test extends BaseClass {

	public static DES_CustomerSetup_Page_Action custSetupPA = null;
	public static DES_Home_Page_Action homePA = null;
	public static DES_Login_Page_Action loginPA = null;

	public DES_CustomerSetup_Page_Test() {
		custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
		homePA = new DES_Home_Page_Action(driver, logger);
		loginPA = new DES_Login_Page_Action(driver, logger);
	}

	@Test(priority = 0, description = " Navigation to Customer Setup Page ")
	public void testNavigationToSetupPage() throws IOException {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			DES_Home_Page_Action.navigateToSetupPage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 0, description = "Navigation Back to to MAP  Page from Setup Page")
	public void testNavigationBackToMapPage() throws IOException {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			DES_Home_Page_Action.navigateToSetupPage();
			// DES_Home_Page_Action.clickeOnSetup();
			homePA.clickeOnMapButton();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(description = " Validates the Labels and textboxes from Customer Setup Page ")
	public void testAllLabelsPresentOnCustomerSetupPage() throws IOException {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.verifyAllLabelsPresentOnCustomerPage();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 0, description = " perform Test To Create  Customer  ")
	public void testCreateCustomer() {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.createCustomer();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(description = "perform Test To Update Customer Details ")
	public void testUpdateCustomer() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_CustomerSetup_Page_Action custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.updateCustomer();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "perform Test To Delete Customer  ")
	public void testDeleteCustomer_() throws IOException {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.deleteCustomerFromGrid();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(description = "perform Test to check if valid date range is accepted while creating Customer ")
	public void testValidDateRangeAccepted() throws IOException {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.validateCorrectDateRange();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(description = "Perform Test to check if Invalid date range is accepted while creating Customer ")
	public void testInValidDateRange() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_CustomerSetup_Page_Action custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.validateInCorrectDateRange();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// @Test(description="Perform Test to check customer data in Database")
	public void testValidateCustomerData() throws IOException {
		try {
			DES_Login_Page_Action loginPA = new DES_Login_Page_Action(driver, logger);
			DES_CustomerSetup_Page_Action custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.ValidateNewCreatedCustomerFromDBandDeleted();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// validateFileUploadForCustomerLog
	@Test(description = "Perform Test File upload functionality for Customer Logo")
	public void testFileUploadForCustomerLogo() throws IOException {

		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.ValidateFileUploadForCustomerLog();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// validate for ClearButton
	@Test(description = "Perform Test to Clear button functionality")
	public void testClearButtonFunctions() throws IOException {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.validateClearButton();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	// createDuplicateUser

	@Test(description = "Perform Test to check Duplicate user Addition to System")
	public void testDuplicateUserAddition() throws IOException {
		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.createDuplicateUser();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}

	}

	// validateListOfCustomerPresentonGrid

	@Test(description = "Perform Test to check the List of Active customer Admin have Added ")
	public void testCustomerAvailableOnGrid() throws IOException {

		try {
			custSetupPA = new DES_CustomerSetup_Page_Action(driver, logger);
			custSetupPA.validateListOfCustomerPresentonGrid();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
