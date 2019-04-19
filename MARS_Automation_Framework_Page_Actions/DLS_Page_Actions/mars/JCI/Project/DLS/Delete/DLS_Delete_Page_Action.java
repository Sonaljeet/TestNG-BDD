package mars.JCI.Project.DLS.Delete;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.DLS.Search.DLS_Search_Page_Action;

public class DLS_Delete_Page_Action {
	/** The HomepageTitle */
	public String homepageTitle = "DLS 5 v1.61";

	/** The MARSDesktopDriver driver. */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The Mouse click */
	public int mouseClick;

	/** The delete Yes Control */
	public String deleteYesControl = "";

	/** The text */
	public String text = "";

	public DLS_Delete_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;

	}

	public void deleteYesButton(String filename) {
		DLS_Delete_Page_Factory deletePF = new DLS_Delete_Page_Factory(desktopDriver);
		deleteYesControl = deletePF.getPermanentDeleteYesButton();
		if (deleteYesControl != null) {
			desktopDriver.marsSleep(2000);

			desktopDriver.marsControlClick(homepageTitle, text, deleteYesControl);

			logger.log(LogStatus.PASS, "Account " + filename + " Deleted Permanently");
		} else {
			logger.log(LogStatus.PASS, "Fail to Delete Account " + filename);
		}

	}

	public void deleteControlSend() {
		desktopDriver.marsSleep(3000);
		desktopDriver.marsSend("+{DEL}", 0);
	}

	public void deleteAccount(String filename) {
		try {
			DLS_Search_Page_Action searchPA = new DLS_Search_Page_Action(desktopDriver, logger);
			searchPA.correctAccountSearch(filename);
			desktopDriver.marsSleep(3000);
			deleteControlSend();
			deleteYesButton(filename);

		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}

}
