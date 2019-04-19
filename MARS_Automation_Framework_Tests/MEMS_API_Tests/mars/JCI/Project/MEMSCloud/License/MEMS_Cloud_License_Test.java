package mars.JCI.Project.MEMSCloud.License;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMS_Cloud_License_Test extends BaseClass{

	@Test(priority=0,description = "Get Orgnization Licence")
	public static void get_orgnization_Licence() {
		try {
			MEMSCloud_Orgnization_Action MEMS_cloud_organization_page_action = new MEMSCloud_Orgnization_Action(driver,
					logger);
			MEMS_cloud_organization_page_action.get_orgnization_Licence();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
