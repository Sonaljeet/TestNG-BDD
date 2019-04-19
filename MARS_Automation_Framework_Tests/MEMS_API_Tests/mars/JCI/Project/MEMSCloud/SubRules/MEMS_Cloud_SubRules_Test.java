package mars.JCI.Project.MEMSCloud.SubRules;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.SubRules.MEMSCloud_SubRules_Action;

public class MEMS_Cloud_SubRules_Test extends BaseClass {
//
	@Test(priority = 0, description = "Create SubRules")
	public static void create_SubRules() {
		try {
			MEMSCloud_SubRules_Action MEMSCloud_SubRules_Action = new MEMSCloud_SubRules_Action(driver, logger);
			MEMSCloud_SubRules_Action.createSubRules();
			getFinalReport(driver, logger, methodName, true);
			//new chnanges
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 1, description = "Update SubRules")
	public static void update_SubRules() {
		try {
			MEMSCloud_SubRules_Action MEMSCloud_SubRules_Action = new MEMSCloud_SubRules_Action(driver, logger);
			MEMSCloud_SubRules_Action.updateSubRules();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 2, description = "Clear SubRules")
	public static void clear_SubRules() {
		try {
			MEMSCloud_SubRules_Action MEMSCloud_SubRules_Action = new MEMSCloud_SubRules_Action(driver, logger);
			MEMSCloud_SubRules_Action.clearSubRules();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 6, description = "Delete SubRules")
	public static void delete_SubRules() {
		try {
			MEMSCloud_SubRules_Action MEMSCloud_SubRules_Action = new MEMSCloud_SubRules_Action(driver, logger);
			MEMSCloud_SubRules_Action.deleteSubRules();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 3, description = "Custom  SubRules")
	public static void custom_SubRules() {
		try {
			MEMSCloud_SubRules_Action MEMSCloud_SubRules_Action = new MEMSCloud_SubRules_Action(driver, logger);
			MEMSCloud_SubRules_Action.customSubRules();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 4, description = "Equation Statement Clear SubRules")
	public static void equationStatement_SubRules() {
		try {
			MEMSCloud_SubRules_Action MEMSCloud_SubRules_Action = new MEMSCloud_SubRules_Action(driver, logger);
			MEMSCloud_SubRules_Action.deleteEquationStatementSubRules();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

	@Test(priority = 5, description = "Test Fault")
	public static void testFault_SubRules() {
		try {
			MEMSCloud_SubRules_Action MEMSCloud_SubRules_Action = new MEMSCloud_SubRules_Action(driver, logger);
			MEMSCloud_SubRules_Action.testFaultSubRules();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
