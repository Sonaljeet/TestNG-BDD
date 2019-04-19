package mars.JCI.Project.MEMSCloud.Spaces;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Spaces.MEMSCloud_Space_Add_Delete_Page_Action;

public class MEMS_Cloud_Spaces_creation_Test extends BaseClass{

	@Test(priority=0,description = "Verify that user is able to select units")
	public void testSelectUnits()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.selectUnits();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}

	}
	
	@Test(priority=1,description = "Verify that user is able to Create Facility/Location.")
	public void testCreateLocation()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.createLocation();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}

	}
	
	@Test(priority=2,description = "Verify that user is able to Create Building")
	public void testCreateBuilding() {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.createBuilding();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}

	}
	@Test(priority=3,description = "Verify that user is able to Create Floor")
	public void testCreateFloor()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.createFloor();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=4,description = "Verify that user is able to Create Wing.")
	public void testCreateWing()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.createWing();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority=5,description = "Verify that user is able to Create Room.")
	public void testCreateRoom()  {
		try {
			MEMSCloud_Space_Add_Delete_Page_Action MEMS_cloud_Space_Add_Delete_page_action = new MEMSCloud_Space_Add_Delete_Page_Action(
					driver, logger);
			MEMS_cloud_Space_Add_Delete_page_action.createRoom();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
