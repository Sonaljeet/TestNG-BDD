package mars.JCI.Project.MEMSCloud.User;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Spaces.MEMSCloud_Space_Add_Delete_Page_Action;

public class MEMS_Cloud_Adminuser_Part1_Test extends BaseClass{
	
	@Test(priority=0,description = "Create Admin User.")
	public static void create_AdminUser() {
		try {
			
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.create_AdminUser();			
			getFinalReport(driver, logger, methodName, true);			
			
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
