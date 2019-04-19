package mars.JCI.Project.CCT.Simulation;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.JavaTimer;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.CCT.Home.CCT_Home_Page_Action;

public class CCT_Simulation_Page_Action {

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The Home page title. */
	public String homePageTitle = "CCT 10.3";

	/** The System page title. */
	public String systemPageTitle = "New System";

	/** The Simulation page title. */
	public String simualtionPageTitle = "Simulation";

	/** The Status page title. */
	public String statusPageTitle = "Status";

	/** The text. */
	public String text = "";
	
	/** The text. */
	public String BaseURL = "";

	public CCT_Simulation_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger, String baseurl) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
		this.BaseURL = baseurl;
	}

	public void cctSimulation() throws IOException, InterruptedException {
		CCT_Home_Page_Action homePA = new CCT_Home_Page_Action(desktopDriver, logger, BaseURL);

		homePA.allDLSProcessClose();

		Thread.sleep(8000);
		homePA.openCCT();
		Thread.sleep(15000);
		desktopDriver.marsMouseClick("", 14, 32, 1, 0);
		Thread.sleep(1000);
		desktopDriver.marsMouseClick("", 13, 48, 1, 0);
		Thread.sleep(1000);

		if (desktopDriver.marsWinWaitActive(systemPageTitle, text, 20) > 0) {
			desktopDriver.marsMouseClick("", 777, 404, 1, 0);
			Thread.sleep(1000);
			desktopDriver.marsControlSend(systemPageTitle, text, "", "System1");
			Thread.sleep(8000);
			desktopDriver.marsMouseClick("", 875, 543, 1, 0);
			Thread.sleep(8000);
			desktopDriver.marsMouseClick("", 767, 628, 1, 0);
			Thread.sleep(5000);
			desktopDriver.marsMouseClick("", 835, 629, 1, 0);
			Thread.sleep(30000);
			if (desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0) {
				desktopDriver.marsMouseClick("", 765, 68, 1, 0);
				Thread.sleep(2000);
				desktopDriver.marsMouseClick("", 862, 498, 1, 0);
				Thread.sleep(2000);
				desktopDriver.marsMouseClick("", 858, 666, 1, 0);
				JavaTimer.startSessionTimer();

				if (desktopDriver.marsWinWaitActive(statusPageTitle, text, 20) > 0) {
					if (desktopDriver.marsWinWaitActive(homePageTitle, text,20)>0) {

						logger.log(LogStatus.PASS,
								"Simulation Start took " + JavaTimer.endSessionTimer() + " to start Simulation window");
					}
					Thread.sleep(6000);
					desktopDriver.marsMouseClick("",677,68, 1, 0);
					Thread.sleep(2000);
					desktopDriver.marsMouseClick("",888,498, 1, 0);
				}
			}
		}

	}
}
