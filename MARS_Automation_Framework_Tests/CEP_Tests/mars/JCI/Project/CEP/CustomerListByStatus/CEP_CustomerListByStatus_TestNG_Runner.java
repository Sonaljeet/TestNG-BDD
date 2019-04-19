package mars.JCI.Project.CEP.CustomerListByStatus;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

public class CEP_CustomerListByStatus_TestNG_Runner extends BaseClass{
	@Test(priority = 0, description = "TC79426-To check and verify the default status of  'Customer list by status' tab")
	public void testDefaultStatus() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateDefaultStatus();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default status of 'Customer list by status' tab is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 1, description = "TC79428-To check and verify the 'Customer list by status' tab")
	public void testTab() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateTab();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "'Customer list by status' tab is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 2, description = "TC79430-To check and verify the functionality of  customer name 'Search' box")
	public void testSearch() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateSearchBox();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Search By Customer functionality is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 3, description = "TC79492-To check and verify the default count of  'Customer list' on customer list by status tab")
	public void testDefaultCustomerCount() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateDefaultCustomerCount();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default Count of customer is not as expected in 'Customer List' section.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 4, description = "TC79494-To check and verify the default count of  'Chiller' on 'customer list by status' tab")
	public void testDefaultChillerCount() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateDefaultChillerCount();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default count of Chillers is not as expected in 'Customer List By Status' section.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 5, description = "TC79553-To check and verify the default count of  'Site/Facility Name' on 'customer list by status' tab")
	public void testDefaultSiteCount() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateDefaultSiteCount();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Default count of Chillers is not as expected in 'Customer List By Status' section.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 6, description = "TC79558-To check and verify change in 'CustomerListByStatus' when Green color clicked.")
	public void testCustomerListForGreen() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.loadOveriviewPage();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateForGreen();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Changes in CustomerListByStatus for Green color widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(description="Testing Thread Pool")
	public void testThreadPool() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//Thread.sleep(8000);
			CountDownLatch latch = new CountDownLatch(3);
			ExecutorService executor = Executors.newFixedThreadPool(3);
			for(int i=0;i<3;i++){
				executor.submit(new CEP_CustomerListByStatus_Page_Action2(driver, logger,latch));
			}
			latch.await();
			//CEP_CustomerListByStatus_Page_Action2 objCustList=new CEP_CustomerListByStatus_Page_Action2(driver, logger,latch);
			//objLogin.loadOveriviewPage();
			//objLogin.closeModal();
//			//Thread.sleep(10000);
//			objCustList.validateForGreen();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Changes in CustomerListByStatus for Green color widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 7, description = "TC79559-To check and verify change in 'CustomerListByStatus' when Yellow color clicked.")
	public void testCustomerListForYellow() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.loadOveriviewPage();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateForYellow();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Changes in CustomerListByStatus for Yellow color widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 8, description = "TC79561-To check and verify change in 'CustomerListByStatus' when Orange color clicked.")
	public void testCustomerListForOrange() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.loadOveriviewPage();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateForOrange();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Changes in CustomerListByStatus for Orange color widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 9, description = "TC79563-To check and verify change in 'CustomerListByStatus' when Grey color clicked.")
	public void testCustomerListForGrey() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.loadOveriviewPage();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateForGrey();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Changes in CustomerListByStatus for Grey color widget is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 10, description = "TC79565-To check and verify the 'site/facility name' section under the respective 'chillers'.")
	public void testSiteListForCustomers() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.loadOveriviewPage();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateSiteListForGreenCustomer();
			objCustList.validateSiteListForRedCustomer();
			objCustList.validateSiteListForYellowCustomer();
			objCustList.validateSiteListForOrangeCustomer();
			objCustList.validateSiteListForGreyCustomer();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Site/Facility Name is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 11, description = "TC79566-To check and verify the 'customer list by status' section under the respective 'chillers' and 'site/facility'.")
	public void testChillerListForCustomers() {
		try {
			CEP_Login_Page_Action objLogin = new CEP_Login_Page_Action(driver, logger);
			CEP_CustomerListByStatus_Page_Action objCustList=new CEP_CustomerListByStatus_Page_Action(driver, logger);
			objLogin.loginToCEPWithAdmin();
			//objLogin.loadOveriviewPage();
			//objLogin.closeModal();
			//Thread.sleep(10000);
			objCustList.validateChillerListForGreenCustomer();
			objCustList.validateChillerListForRedCustomer();
			objCustList.validateChillerListForYellowCustomer();
			objCustList.validateChillerListForOrangeCustomer();
			objCustList.validateChillerListForGreyCustomer();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Chiller Name is not as expected.");
			getFinalReport(driver, logger, methodName, false);
		}
	}
}