package mars.JCI.Project.MEMSCloud.Spaces;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Spaces.MEMSCloud_Space_Add_Delete_Page_Action;

public class MEMS_Cloud_Spaces_deletion_Test extends BaseClass{

	@Test(priority=0,description = "Verify that user is able to delete Room.")
	public void testDeleteRoom()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.deleteRoom();
			//System.out.println("Room deleted successfully.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority=1,description = "Verify that user is able to delete Wing.")
	public void testDeleteWing()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.deleteWing();
			//System.out.println("Wing deleted successfully.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}

	}
	
	@Test(priority=2,description = "Verify that user is able to delete Floor")
	public void testDeleteFloor()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.deleteFloor();
			//System.out.println("Floor deleted successfully.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}

	}
	
	@Test(priority=3,description = "Verify that user able to delete Building.")
	public void testDeleteBuilding()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.deleteBuilding();
			//System.out.println("Building deleted successfully.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}

	}

	@Test(priority=4,description = "Verify that user is able to Delete Facility/Location.")
	public void testDeleteLocation()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.deleteLocation();
			//System.out.println("Facility/Location deleted successfully.");
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
