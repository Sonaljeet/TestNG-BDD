package mars.JCI.Project.CEP.TimeSeries;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.DailyDataCheckList.CEP_DailyDataCheckList_Page_Action;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

@CucumberOptions(glue = { "mars.JCI.Project.CEP.Login", "mars.JCI.Project.CEP.DailyDataCheckList" }, tags = {
		"@GetPointLatestTimeStamp" })
public class CEP_TimeSeries_GetPointLatestTimeStamp_TestRunner extends BaseClass {
	@Test(description = "Validating TimeSeries Data")
	public void testTimeSeriesData() {

		try {
			CEP_Login_Page_Action cepLogin = new CEP_Login_Page_Action(driver, logger);
			new TestNGCucumberRunner(getClass()).runCukes();

		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
