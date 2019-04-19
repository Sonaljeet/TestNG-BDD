package mars.JCI.Project.MEMSCloud.MeterConfiguration;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.MeterConfiguration.MEMSCloud_MeterConfiguration_Action;

public class MEMS_Cloud_MeterConfiguration_Part1_Test extends BaseClass {

	@Test(priority = 0, description = "Add Online Meter.")
	public static void create_OnlineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.createOnlineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "Add Online Point Under Online Meter.")
	public static void create_OnlinePoint_UnderOnlineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.OnlinePoint_UnderOnlineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 2, description = "Add Virtual Point Under Online Meter.")
	public static void create_VirtualPoint_UnderOnlineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.add_VirtualPoint_UnderOnlineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 3, description = "Delete Virtual Point Under Online Meter.")
	public static void delete_VirtualPoint_UnderOnlineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.delete_VirtualPoint_UnderOnlineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	@Test(priority = 4, description = "Delete Online Point Under Online Meter.")
	public static void delete_OnlinePoint_UnderOnlineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.delete_OnlinePoint_UnderOnlineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	@Test(priority = 5, description = "Configure Meter Point.")
	public static void create_ConfigureMeterPoint() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.ConfigureMeterPoint();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 6, description = "Map Meter Point.")
	public static void create_MapMeterPoint() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.mapMeterPoint();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 7, description = "Set Historical Request.")
	public static void create_setHistoricalRequest() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.setHistoricalRequest();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 8, description = "Add Virtual Meter.")
	public static void create_VirtualMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.createVirtualMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 9, description = "Delete Virtual Meter point.")
	public static void create_DeleteVirtualMeterPoint() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.deleteVirtualMeterPoint();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 10, description = "Delete Virtual Meter.")
	public static void create_DeleteVirtualMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.deleteVirtualMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 11, description = "Delete Mapped Meter Point.")
	public static void create_DeleteMappedMeterPoint(Method method) {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.deleteMappedMeterPoint();
			getFinalReport(driver, logger, method.getName(), true);
		} catch (Exception e) {
			getFinalReport(driver, logger, method.getName(), false);
		}
	}

	@Test(priority = 12, description = "Delete Online Meter.")
	public static void create_DeleteOnlineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Page_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Page_Action.deleteOnlineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 13, description = "Add Offline Meter.")
	public static void create_OfflineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Action.createOfflineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 14, description = "Add Offline meter point.")
	public static void Create_OfflineMeterPoint() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Action.createOfflineMeterPoint();
			getFinalReport(driver, logger, methodName, true);

		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 15, description = "Delete Offline meter point.")
	public static void delete_OfflineMeterPoint() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Action.deleteOfflineMeterPoint();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 16, description = "Delete Offline Meter.")
	public static void delete_OfflineMeter() {
		try {
			MEMSCloud_MeterConfiguration_Action MEMSCloud_MeterConfiguration_Action = new MEMSCloud_MeterConfiguration_Action(
					driver, logger);
			MEMSCloud_MeterConfiguration_Action.deleteOfflineMeter();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
