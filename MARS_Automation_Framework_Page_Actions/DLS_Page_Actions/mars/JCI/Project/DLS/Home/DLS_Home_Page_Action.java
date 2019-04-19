package mars.JCI.Project.DLS.Home;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Home_Page_Action {

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The Home page title. */
	public String homePageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	public DLS_Home_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
	}

	public boolean verifyHomePageTitle() {
		boolean pageTitle = false;
		if (desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0) {
			logger.log(LogStatus.PASS, "We are on DLS Home Page");
			pageTitle = true;
		}
		return pageTitle;
	}

}
