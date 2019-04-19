package mars.JCI.Project.CEP.LeftPanel;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;

@CucumberOptions(glue = { "mars.JCI.Project.CEP.Login", "mars.JCI.Project.CEP.LeftPanel" }, tags = { "@TC9" })

public class CEP_LeftPanel_LocalUser_TestRunner extends BaseClass {

	@Test(description = "Validating CEP Local User Left Panel Functionalities")
	public void testLeftPanelNaUser() {

		try {
			CEP_Login_Page_Action cepLogin = new CEP_Login_Page_Action(driver, logger);
			new TestNGCucumberRunner(getClass()).runCukes();

		} catch (Exception e) {
			getFinalReport(driver, logger, methodName, false);
		}
	}

}
