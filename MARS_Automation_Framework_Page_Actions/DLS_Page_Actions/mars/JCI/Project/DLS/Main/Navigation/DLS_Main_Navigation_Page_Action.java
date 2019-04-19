package mars.JCI.Project.DLS.Main.Navigation;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Main_Navigation_Page_Action {
	/** The Home page title. */
	public String homePageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	public DLS_Main_Navigation_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
	}

	public void clickMainWindowTabs() {

		if (desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0) {
			logger.log(LogStatus.PASS, "Started Navigation For Main Menu on DLS Home Page");
			desktopDriver.marsSleep(3000);
			desktopDriver.marsMouseClick(text, 21, 35, 1, 0);
			logger.log(LogStatus.PASS, "File is Present in Main Menu");
			desktopDriver.marsSleep(3000);
			desktopDriver.marsMouseClick(text, 60, 37, 1, 0);
			logger.log(LogStatus.PASS, "View is Present in Main Menu");
			desktopDriver.marsSleep(3000);
			desktopDriver.marsMouseClick(text, 113, 33, 1, 0);
			logger.log(LogStatus.PASS, "Tools is Present in Main Menu");
			desktopDriver.marsSleep(3000);
			desktopDriver.marsMouseClick(text, 169, 38, 1, 0);
			logger.log(LogStatus.PASS, "Window is Present in Main Menu");
			desktopDriver.marsSleep(3000);
			desktopDriver.marsMouseClick(text, 223, 36, 1, 0);
			logger.log(LogStatus.PASS, "Help is Present in Main Menu");
			logger.log(LogStatus.PASS, "Main Menu Navigation is Completed Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Main Menu Navigation is Unsuccessfull");
		}
	}

}
