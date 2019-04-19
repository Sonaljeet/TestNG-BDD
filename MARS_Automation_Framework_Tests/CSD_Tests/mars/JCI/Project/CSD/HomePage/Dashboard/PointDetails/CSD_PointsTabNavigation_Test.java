/**
 * 
 */
package mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.CPO5.CSD_Home_Page_Action;
/*import mars.JCI.Project.CSD.CPO5.CSD_PointDetailsTab_Page_Action;
import mars.JCI.Project.CSD.CPO5.CSD_SCC_Data_Import_Page_Action;
import mars.JCI.Project.CSD.CPO5.CSD_SCTTemplate_Page_Action;*/
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails.CSD_PointDetailsTab_Page_Action;

/**
 * @author cdeyso
 *
 */
public class CSD_PointsTabNavigation_Test extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername", "correctpassword" })
	@Test(description = "Running the CPO5 Test Module for CSD 3.0 New Functionality Feature. Performs a Navigation of the Point Details Tab and Selects Required Chiller(s)")
	public void getChillerPointDetailsTab( String correctusername, String correctpassword){
	
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin(correctusername, correctpassword);//"cdeyso@jci.com", "Jci@1113" correctusername, correctpassword
			CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
			pointDetailsTabPage.clickOnDashboardLink();
			pointDetailsTabPage.clickOnRightMenuButton();
			pointDetailsTabPage.enterRequiredProject();
			pointDetailsTabPage.selectRequiredProject();
			pointDetailsTabPage.selectRequiredChillerSite();
			pointDetailsTabPage.selectRequiredChillerEquipment();
			String chiller_model = pointDetailsTabPage.getChillerModelDetails();
			pointDetailsTabPage.clickPointDetailsTab();
			String asset_det_id = pointDetailsTabPage.getAssetAttributeID();
			int model_id = pointDetailsTabPage.GetModelIdForChillerModel(chiller_model);
			pointDetailsTabPage.GetChillerAttributeDetails(model_id);
			pointDetailsTabPage.getAssetDetailsForSelectedChiller(asset_det_id);
			pointDetailsTabPage.GetEligibleChillerPointHeadersFromSheet();//GetEligibleChillerPointHeadersFromSheet -- GetChillerPointHeadersFromSheet
			pointDetailsTabPage.CloseDBConnection();
			
			//pointDetailsTabPage.validatePointCategoryDetaisForChillerModel();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	/*
	@SuppressWarnings("unused")
	//@Test(priority = 0,description = " Login to CSD Application !")
	public void loginToCSDApp(Method method) {
		
		try {
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin("cdeyso@jci.com", "Jci@1113");
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
	
	@SuppressWarnings("static-access")
	//@Test(priority = 1,description = " Navigate to Chiller Point Details Tab !")
	public void navigateToChillerPointDetailsTab(Method method) {
		
		try {
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin("cdeyso@jci.com", "Jci@1114");//"cdeyso@jci.com", "Jci@1113" correctusername, correctpassword
			CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
			pointDetailsTabPage.clickOnDashboardLink();
			pointDetailsTabPage.clickOnRightMenuButton();
			pointDetailsTabPage.enterRequiredProject();
			pointDetailsTabPage.selectRequiredProject();
			pointDetailsTabPage.selectRequiredChillerSite();
			pointDetailsTabPage.selectRequiredChillerEquipment();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings("static-access")
	//@Test(priority = 2,description = " Validate All Items Related to Chiller Point Details !")
	public void verifyChillerPointDetails(Method method) {
		
		try {
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin("cdeyso@jci.com", "Jci@1114");//"cdeyso@jci.com", "Jci@1113" correctusername, correctpassword
			CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
			pointDetailsTabPage.clickOnDashboardLink();
			pointDetailsTabPage.clickOnRightMenuButton();
			pointDetailsTabPage.enterRequiredProject();
			pointDetailsTabPage.selectRequiredProject();
			pointDetailsTabPage.selectRequiredChillerSite();
			pointDetailsTabPage.selectRequiredChillerEquipment();
			String chiller_model = pointDetailsTabPage.getChillerModelDetails();
			System.out.println("chiller_model " +chiller_model);
			pointDetailsTabPage.clickPointDetailsTab();
			int model_id = pointDetailsTabPage.GetModelIdForChillerModel(chiller_model);
			pointDetailsTabPage.GetChillerAttributeDetails(model_id);
			pointDetailsTabPage.GetChillerPointHeadersFromSheet();
			pointDetailsTabPage.CloseDBConnection();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	@SuppressWarnings({ "static-access", "unused" })
	//@Test(priority = 2, description = "Download and Validate the SCT Template Form for a Selected Chiller.")
	public void getChillerPointDetailsTab_2(Method method){
		
			try {
				
				CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
				CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin("cdeyso@jci.com", "Jci@1114");//"cdeyso@jci.com", "Jci@1113" correctusername, correctpassword
				CSD_SCTTemplate_Page_Action sctTemplateTabPage = new CSD_SCTTemplate_Page_Action(driver, logger);
				sctTemplateTabPage.clickOnAdministrationLink();
				sctTemplateTabPage.clickOnSCTUploadLink();
				sctTemplateTabPage.clickOnSCTTemplateLink();
				sctTemplateTabPage.selectSCTTemplateEquipment();
				sctTemplateTabPage.selectSCTTemplateModel();
				sctTemplateTabPage.clickSCTTemplateDownloadButton();
				sctTemplateTabPage.clickSCTTemplateDownloadConfirmPopUp();
				String model_id = sctTemplateTabPage.getChillerModelIDFromDB();
				sctTemplateTabPage.StoreResultsetInExelFile(model_id);
				String last_mod_file = sctTemplateTabPage.GetLastModifiedFileName();
				sctTemplateTabPage.CompareDBAndTemplateValues(last_mod_file);
				
				getFinalReport(driver, logger, methodName, true);
				
			} catch (Exception e) {
				e.printStackTrace();
				getFinalReport(driver, logger, methodName, false);
			}
			
		}
	
	@SuppressWarnings("static-access")
	//@Test(priority = 4,description = " Validate All Items Related to Chiller Asset ID Details From DB and UI!")
	public void verifyChillerAssetIDDetails(Method method){
		
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin("cdeyso@jci.com", "Jci@1114");//"cdeyso@jci.com", "Jci@1113" correctusername, correctpassword
			CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
			pointDetailsTabPage.clickOnDashboardLink();
			pointDetailsTabPage.clickOnRightMenuButton();
			pointDetailsTabPage.enterRequiredProject();
			pointDetailsTabPage.selectRequiredProject();
			pointDetailsTabPage.selectRequiredChillerSite();
			pointDetailsTabPage.selectRequiredChillerEquipment();
			String chiller_model = pointDetailsTabPage.getChillerModelDetails();
			pointDetailsTabPage.clickPointDetailsTab();
			
			//Perform Version Validation -- after this step
			
			
			String asset_det_id = pointDetailsTabPage.getAssetAttributeID();
			int model_id = pointDetailsTabPage.GetModelIdForChillerModel(chiller_model);
			pointDetailsTabPage.GetChillerAttributeDetails(model_id);
			pointDetailsTabPage.getAssetDetailsForSelectedChiller(asset_det_id);
			pointDetailsTabPage.GetEligibleChillerPointHeadersFromSheet();//GetEligibleChillerPointHeadersFromSheet -- GetChillerPointHeadersFromSheet
			pointDetailsTabPage.CloseDBConnection();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@SuppressWarnings("static-access")
	//@Parameters({"correctusername", "correctpassword" })
	//@Test(priority = 3,description = "Performs a check on the Point Details of the Existing CPO5 Equipment Setup ")
	public void getChillerSCCDetailsTab(Method method){
	
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin("cdeyso@jci.com", "Jci@1114");//"cdeyso@jci.com", "Jci@1113" correctusername, correctpassword
			CSD_SCC_Data_Import_Page_Action sccPageTest = new CSD_SCC_Data_Import_Page_Action(driver, logger);
			sccPageTest.clickOnAdministrationLink();
			sccPageTest.clickOnSCCTabLink();
			sccPageTest.clickOnSCCDataImportTabLink();
			sccPageTest.selectDataSourceForSetup();
			sccPageTest.selectEquipmentTypeForSetup();
			sccPageTest.selectCustomerNameForSetup();
			sccPageTest.selectFacilityNameForSetup();
			sccPageTest.selectExistingRadioBtnForForSetup();
			sccPageTest.selectExistingChillerEqpmntForForSetup();
			String[] owner_device_name = sccPageTest.validateOwnerDeviceForSelectedChiller();
			//System.out.println(owner_device_name[0]+" "+owner_device_name[1]+" "+owner_device_name[2]);
			sccPageTest.saveSelectedChillerPointsFromDB(owner_device_name);
			sccPageTest.importPointsForTheSelectedChillerFromTemplate();
			sccPageTest.validateTemplatePointsWithDBForSelectedEquipment();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
		
	}
	
	*/
	
}
