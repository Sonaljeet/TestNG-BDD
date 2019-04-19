package mars.JCI.Project.MEMSCloud.Work_Order;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.WorkOrder.MEMSCloud_Work_Order_Page_Action;

public class MEMS_CLOUD_Work_Order_Test extends BaseClass{
	public static MEMSCloud_Work_Order_Page_Action workOrder_Page_Action = null;


	@Test(priority = 0, description = "Add Service State")
	public static void addServiceState(Method method) {		
		try {
			workOrder_Page_Action = new MEMSCloud_Work_Order_Page_Action(driver, logger);
			workOrder_Page_Action.addServiceState();
			getFinalReport(driver, logger, method.getName(), true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(driver, logger, method.getName(), false);
			
		}
	}
	

}
