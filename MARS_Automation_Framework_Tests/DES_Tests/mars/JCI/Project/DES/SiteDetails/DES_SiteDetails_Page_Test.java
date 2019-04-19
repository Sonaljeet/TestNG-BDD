package mars.JCI.Project.DES.SiteDetails;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;

public class DES_SiteDetails_Page_Test extends BaseClass{
	
	@Test(priority=0, description="Validate if user is able to Navigate to Details Tab for Selected Site")
	public void testnavigationToDetailsTab(){
		try{
			DES_SiteDetails_Page_Action siteDPA= new DES_SiteDetails_Page_Action(driver, logger);
			siteDPA.navigateToDetailsTab();
			getFinalReport(driver, logger, methodName, true);
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
			getFinalReport(driver, logger, methodName, true);
		}
	}
	
	
	@Test(priority=1, description="Validate Systems Available For Selected Site")
	public void testSystemsAvailableForDetailsTab(){
		try{
			DES_SiteDetails_Page_Action siteDPA= new DES_SiteDetails_Page_Action(driver, logger);
			siteDPA.ValidateWidgetsPresent();
			getFinalReport(driver, logger, methodName, true);
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
			getFinalReport(driver, logger, methodName, true);
		}
	}
	
	
	@Test(priority=2, description="Validate Systems Data Available For Selected Site")
	public void testSystemsDataAvailableForDetailsTab(){
		try{
			DES_SiteDetails_Page_Action siteDPA= new DES_SiteDetails_Page_Action(driver, logger);
			siteDPA.ValidateWidgetsDataPresent();
			getFinalReport(driver, logger, methodName, true);
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
			getFinalReport(driver, logger, methodName, true);
		}
	}

	
	@Test(priority=3, description="Validate Systems Data Available For Selected Site")
	public void testConfigureWidget(){
		try{
			DES_SiteDetails_Page_Action siteDPA= new DES_SiteDetails_Page_Action(driver, logger);
			siteDPA.verifyConfigureWidget();
			getFinalReport(driver, logger, methodName, true);
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
			getFinalReport(driver, logger, methodName, true);
		}
	}
	
	@Test(priority=3, description="Validate Search Function for Details tab")
	public void testSearchFunction(){
		try{
			DES_SiteDetails_Page_Action siteDPA= new DES_SiteDetails_Page_Action(driver, logger);
			siteDPA.verifySeach();
			getFinalReport(driver, logger, methodName, true);
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, e.getMessage());
			getFinalReport(driver, logger, methodName, true);
		}
	}	
}
