package mars.JCI.Project.MEMSCloud.Orgnization;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMS_Cloud_Orgnization_Part2_Test extends BaseClass{

	@Test(priority=0,description = "Deactivate orgnization")
	public static void delete_orgnization() {
		try {
			MEMSCloud_Orgnization_Action MEMS_cloud_organization_page_action = new MEMSCloud_Orgnization_Action(driver,
					logger);
			MEMS_cloud_organization_page_action.delete_orgnization();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
