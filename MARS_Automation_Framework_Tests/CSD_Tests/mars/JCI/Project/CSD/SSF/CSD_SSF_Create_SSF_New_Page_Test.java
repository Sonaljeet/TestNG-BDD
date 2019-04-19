/**
 * 
 */
package mars.JCI.Project.CSD.SSF;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_Create_SSF_New_Page_Test extends BaseClass{
	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername", "correctpassword" })
	@Test(priority=0,description = "Running the SSF Test Module for CSD 3.0 New Functionality Feature. Performs creation of Site Setup Form and SAVING the Form as a Branch USER For NEW Customere and Facility.")
	public void createSSFFunctionalityBranchUserNewCustomer(String correctusername, String correctpassword){
		
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername, correctpassword);//CSD_Home_Page_Action homePA = 
			CSD_SSF_Create_SSF_Page_Action ssfPageAction = new CSD_SSF_Create_SSF_Page_Action(driver, logger);
			ssfPageAction.clickOnSiteSetupLink();
			ssfPageAction.clickOnSSFLink();
			ssfPageAction.clickOnCreateSSFLink();
			ssfPageAction.checkOnContractInformationPage();
			
			ssfPageAction.checkIfValidBranchesAreDisplayedForLoggedUser();
			
			ssfPageAction.selectBranch();
			ssfPageAction.selectContractType();
			ssfPageAction.setPSAAgreementValue();
			ssfPageAction.checkPONumberStatus();
			ssfPageAction.validatePrimaryContactDetails();
			ssfPageAction.setSalesOrderNo();
			
			
			ssfPageAction.setBranchAddress(false); // Updating new Ship to address
						
			ssfPageAction.expandCustomerSiteInfoSection();
			ssfPageAction.selectNewSSFCustomer();
			ssfPageAction.setARNoForNewSSFCustomer();
			ssfPageAction.setNewFacilityForCustomer();
			ssfPageAction.setMendatoryCustomerSiteInfoDetailsNew();
			
			//ssfPageAction.checkMappedCFAUsers();
			ssfPageAction.addL1UserToSSFDetails();
			ssfPageAction.addL2UserToSSFDetails();
			
			//ssfPageAction.selectConnectionType_CellModem();
			ssfPageAction.selectConnectionType_CustomerNetwork();
			
			ssfPageAction.addAssetDetails_expand();
			ssfPageAction.addAssetDetails_ChillerAsset(2);//ssfPageAction.verifyNewAssetIsAdded();ssfPageAction.addAssetDetails_ChillerAsset_2();
			ssfPageAction.verifyNewAssetEdit();
			ssfPageAction.verifyNewAssetDelete();
			
			ssfPageAction.ssfFormAddNotes();
			ssfPageAction.checkMendatoryFields();
			ssfPageAction.ssfFormSAVE();
			
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
