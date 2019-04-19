package mars.JCI.Project.MEMSCloud.MappedPoint;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud_MappedPoints.MEMSCloud_MappedPoint_Action;

public class MEMS_Cloud_MappedPoint_Test extends BaseClass{

	@Test(priority = 0, description = "Verify the Offline data upload for Period: Year and Resolution: Month for Offline points in Mapped points.")
	public void create_OnlineMeter() {
		try {
			MEMSCloud_MappedPoint_Action MappedPoints = new MEMSCloud_MappedPoint_Action(driver, logger);			
			MappedPoints.uploadOfflineData_Period_Year_Reso_Month();
			getFinalReport(driver, logger, methodName, true);
		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}
	
	
}
