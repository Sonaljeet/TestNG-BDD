package mars.JCI.Project.MEMSCloud.User;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Users.MEMSCloud_Users_Action;

public class MEMS_Cloud_Superadminuser_Part1_Test extends BaseClass{
	
	@Test(priority=0,description = "Create User")
	public static void create_user() {
		try {
			MEMSCloud_Users_Action MEMS_cloud_users_page_action = new MEMSCloud_Users_Action(driver, logger);
			MEMS_cloud_users_page_action.create_user();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
