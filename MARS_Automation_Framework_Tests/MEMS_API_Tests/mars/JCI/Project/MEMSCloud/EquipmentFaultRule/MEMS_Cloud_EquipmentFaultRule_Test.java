package mars.JCI.Project.MEMSCloud.EquipmentFaultRule;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.EquipmentFaultRule.MEMSCloud_EquipmentFaultRule_Action;

public class MEMS_Cloud_EquipmentFaultRule_Test extends BaseClass {

	@Test(priority = 0, description = "Create EquipmentFaultRule")
	public static void create_EquipmentFaultRule() {
		try {
			MEMSCloud_EquipmentFaultRule_Action MEMSCloud_EquipmentFaultRule_Action = new MEMSCloud_EquipmentFaultRule_Action(
					driver, logger);
			MEMSCloud_EquipmentFaultRule_Action.createEuipmentFaultRule();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "Update EquipmentFaultRule")
	public static void update_EquipmentFaultRule() {
		try {
			MEMSCloud_EquipmentFaultRule_Action MEMSCloud_EquipmentFaultRule_Action = new MEMSCloud_EquipmentFaultRule_Action(
					driver, logger);
			MEMSCloud_EquipmentFaultRule_Action.updateEuipmentFaultRule();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 5, description = "Delete EquipmentFaultRule")
	public static void delete_EquipmentFaultRule() {
		try {
			MEMSCloud_EquipmentFaultRule_Action MEMSCloud_EquipmentFaultRule_Action = new MEMSCloud_EquipmentFaultRule_Action(
					driver, logger);
			MEMSCloud_EquipmentFaultRule_Action.deleteEquipmentFaultRule();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 2, description = "Clear EquipmentFaultRule")
	public static void clear_EquipmentFaultRule() {
		try {
			MEMSCloud_EquipmentFaultRule_Action MEMSCloud_EquipmentFaultRule_Action = new MEMSCloud_EquipmentFaultRule_Action(
					driver, logger);
			MEMSCloud_EquipmentFaultRule_Action.clearEquipmentFaultRule();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 3, description = "Delete EquationStatement of EquipmentFaultRule")
	public static void deleteEquationStatement_EquipmentFaultRule() {
		try {
			MEMSCloud_EquipmentFaultRule_Action MEMSCloud_EquipmentFaultRule_Action = new MEMSCloud_EquipmentFaultRule_Action(
					driver, logger);
			MEMSCloud_EquipmentFaultRule_Action.deleteEquationStatement();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 4, description = "Test Fault EquipmentFaultRule")
	public static void testFault_EquipmentFaultRule() {
		try {
			MEMSCloud_EquipmentFaultRule_Action MEMSCloud_EquipmentFaultRule_Action = new MEMSCloud_EquipmentFaultRule_Action(
					driver, logger);
			MEMSCloud_EquipmentFaultRule_Action.testFaultEquipmentFaultRule();
			;
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
