package mars.JCI.Project.CCT.System.Selection;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.JavaTimer;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.CCT.Home.CCT_Home_Page_Action;

public class CCT_System_Selection_Page_Action {

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The Home page title. */
	public String homePageTitle = "CCT 10.3";

	/** The System page title. */
	public String systemPageTitle = "New System";

	/** The text. */
	public String text = "";
	
	/** The text. */
	public String BaseURL = "";

	/** The Selection Page Title. */
	public String selectionPageTitle = "System Selection Wizard";

	public CCT_System_Selection_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger, String baseurl) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
		this.BaseURL = baseurl;
	}

	public void cctSytemSelection() throws InterruptedException, IOException {
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
			Thread.sleep(20000);
			if (desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0) {
				desktopDriver.marsMouseClick("", 1316, 68, 1, 0);
				JavaTimer.startSessionTimer();

				if (desktopDriver.marsWinWaitActive(selectionPageTitle, text, 20) > 0) {

					logger.log(LogStatus.PASS,
							"System selection screen took  " + JavaTimer.endSessionTimer() + "  to popup");
				}
				Thread.sleep(4000);
				desktopDriver.marsMouseClick("",912,629,1,0);

			}

		}

	}

}
