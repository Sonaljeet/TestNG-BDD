package mars.JCI.Project.MEMSCloud.Roleandrights;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Spaces.MEMSCloud_Space_Add_Delete_Page_Action;

public class MEMS_Cloud_Admin_roleandrights_Test extends BaseClass{

	@Test(priority=0,description = "Create User Role.")
	public static void create_User_role() {
		try {
			
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.create_Users_CreateRole();			
			getFinalReport(driver, logger, methodName, true);			
			
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority=1,description = "Assign User Roles & Rigts.")
	public static void create_AdminUserRolesandRights() {
		try {
			
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.assign_AdminUserRolesandRights();			
			getFinalReport(driver, logger, methodName, true);			
			
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
