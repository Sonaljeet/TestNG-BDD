package mars.JCI.Project.MEMSCloud.Roleandrights;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;
import mars.JCI.Project.MEMS_Cloud.Users.MEMSCloud_Users_Action;

public class MEMS_Cloud_Superadmin_roleandrights_Test extends BaseClass{
	
	@Test(priority=0,description = "Create Role")
	public static void create_role() {
		try {
			MEMSCloud_Orgnization_Action MEMS_cloud_organization_page_action = new MEMSCloud_Orgnization_Action(driver,
					logger);
			MEMS_cloud_organization_page_action.create_role();
			getFinalReport(driver, logger, methodName, true);    //do the changes in all tests
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
			//testcaseStatus=false;
		}
	}
	
	@Test(priority=1,description = "Assign User Rights")   //chnage
	public static void assign_User_rights() {
		try {
			MEMSCloud_Users_Action MEMS_cloud_users_page_action = new MEMSCloud_Users_Action(driver, logger);
			MEMS_cloud_users_page_action.assign_User_rights();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
			//testcaseStatus=false;
		}
	}
}
