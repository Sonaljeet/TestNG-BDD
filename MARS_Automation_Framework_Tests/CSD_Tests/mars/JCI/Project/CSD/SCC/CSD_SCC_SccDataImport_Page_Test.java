package mars.JCI.Project.CSD.SCC;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.CPO5.CSD_Home_Page_Action;
import mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails.CSD_PointDetailsTab_Page_Action;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.SCC.CSD_SCC_SccDataImport_Page_Action;

public class CSD_SCC_SccDataImport_Page_Test extends BaseClass{

	
	@SuppressWarnings("static-access")
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="CSD Application SCC Data Import Tab Validations")
	public void testSCCDataImportFunctionalityTest( String correctusername, String correctpassword) 
			throws IOException{   //  Method method
    	try {
    		
    		CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
    		CSD_Home_Page_Action homePA = csd_login_page_action.correctLogin(correctusername, correctpassword);//"cdeyso@jci.com", "Jci@1113" 
			CSD_SCC_SccDataImport_Page_Action csd_scc_DataImp_pa = new CSD_SCC_SccDataImport_Page_Action(driver, logger);
			//CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
			csd_scc_DataImp_pa.clickOnSCCDataImportTabLink();
			csd_scc_DataImp_pa.selectDataSourceForSetup();
			csd_scc_DataImp_pa.selectEquipmentTypeForSetup();
			csd_scc_DataImp_pa.selectCustomerNameForSetup();
			csd_scc_DataImp_pa.selectFacilityNameForSetup();
			csd_scc_DataImp_pa.selectSCCDeatilsNatureNewORExisting(false);
			//csd_scc_DataImp_pa.validateTemplatePointsWithDBForSelectedEquipment();
			//csd_scc_DataImp_pa.validatePointDetailsTabEntries();
			csd_scc_DataImp_pa.validateProperPointImport();
			
			/*//CSD_PointDetailsTab_Page_Action pointDetailsTabPage = new CSD_PointDetailsTab_Page_Action(driver, logger);
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
			pointDetailsTabPage.CloseDBConnection();*/
			
			
			
			
			getFinalReport(driver, logger, methodName ,	true);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
}
