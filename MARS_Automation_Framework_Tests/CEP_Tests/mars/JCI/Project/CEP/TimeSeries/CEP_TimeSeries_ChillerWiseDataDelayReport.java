package mars.JCI.Project.CEP.TimeSeries;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.DailyDataCheckList.CEP_ChillerWiseDataDelay_Page_Action;

public class CEP_TimeSeries_ChillerWiseDataDelayReport {
	
	@Test(priority = 0, description = "Track ChillerWise Data Delay Report on daily basis")
	public void testChillerWiseDataDelay() {
		try {
			CEP_ChillerWiseDataDelay_Page_Action obj = new CEP_ChillerWiseDataDelay_Page_Action();
			obj.getPointID();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
