package mars.JCI.Project.CCT.Commission;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.JavaTimer;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.CCT.Home.CCT_Home_Page_Action;

public class CCT_Commission_Page_Action {
	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The Home page title. */
	public String homePageTitle = "CCT 10.3";

	/** The System page title. */
	public String systemPageTitle = "New System";

	/** The input page title. */
	public String inputPageTitle = "New Module Selection";
	
	/** The Save page title. */
	public String savePageTitle = "Save Confirmation";
	
	/** The Confirm page title. */
	public String confirmPageTitle = "Confirm";

	/** The text. */
	public String text = "";
	
	/** The text. */
	public String BaseURL = "";

	public CCT_Commission_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger, String baseurl) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
		this.BaseURL = baseurl;
	}

	public void cctCommission() throws IOException, InterruptedException {
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
		}
		if (desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0) {
			Thread.sleep(3000);
			desktopDriver.marsMouseClick("", 866, 75, 1, 0);
			if (desktopDriver.marsWinWaitActive(savePageTitle, text, 20) > 0) {
				Thread.sleep(5000);
				desktopDriver.marsMouseClick("", 864, 499, 1, 0);
			}
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 739, 274, 1, 0);
			Thread.sleep(1000);
			desktopDriver.marsControlSend("", text, "", "Pass@123");
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 858, 301, 1, 0);
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 772, 796, 1, 0);
			Thread.sleep(14000);
			desktopDriver.marsMouseClick("", 772, 796, 1, 0);
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 837, 799, 1, 0);
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 861, 496, 1, 0);
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 838, 795, 1, 0);
			JavaTimer.startSessionTimer();
			if (desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0) {
				logger.log(LogStatus.PASS, "Commissioning application took " + JavaTimer.endSessionTimer());
			}

			Thread.sleep(8000);
			desktopDriver.marsMouseClick("", 681, 67, 1, 0);
			if(desktopDriver.marsWinWaitActive(confirmPageTitle, text, 20) > 0)
			{
			Thread.sleep(1000);
			desktopDriver.marsMouseClick("", 887, 497, 1, 0);
			}

		}
	}

}
