/**
 * 
 */
package mars.JCI.Project.CSD.SSF;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.SSF.CSD_SSF_DeleteForm_Master;

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_DeleteForm_Test extends BaseClass {
	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername", "correctpassword" })
	@Test(priority=0,description = "Deleting the Form created after Validations.")
	public void deleteSSFBranchAfterValidations(String correctusername, String correctpassword){
		
		try {
			
			CSD_SSF_DeleteForm_Master csd_ssf_DeleteForm = new CSD_SSF_DeleteForm_Master(driver, logger);
			csd_ssf_DeleteForm.deleteFormIDAfterValidationComplete();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
