package mars.JCI.Project.CCT.Simulation;

import java.io.IOException;

import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;

public class CCT_Simulation_Test extends BaseClass {
	

	@Test(description = "This Test case used to check time taken for Simulation to start ")
	public void testSuccessfulSimulationPage() throws IOException {
		try {
			CCT_Simulation_Page_Action simulationPA=new CCT_Simulation_Page_Action(desktopDriver, logger,BaseURL);
			simulationPA.cctSimulation();
			getFinalReport(desktopDriver, logger, methodName, true);
		} catch (Exception e) {
			e.printStackTrace();
			getFinalReport(desktopDriver, logger, methodName, false);
		}
	}


}
