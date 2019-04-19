package mars.JCI.Project.DLS.Search;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Search_Page_Action {
	/** The SearchEdit. */
	public String searchEdit = "";

	/** The SearchButton. */
	public String searchButton = "";

	/** The Home page Title */
	public String homepageTitle = "DLS 5 v1.61";

	/** The text */
	public String text = "";

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	public DLS_Search_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;

	}

	public void searchEdit(String Search) {
		DLS_Search_Page_Factory searchPF = new DLS_Search_Page_Factory(desktopDriver);
		searchEdit = searchPF.getSearchEdit();
		if (searchEdit != null) {

			desktopDriver.marsSleep(2000);

			desktopDriver.marsControlSend(homepageTitle, text, searchEdit, Search);

			logger.log(LogStatus.PASS, "Data to be Searched Entered Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Enter data to be Searched");
		}
	}

	public void searchButton() {
		DLS_Search_Page_Factory searchPF = new DLS_Search_Page_Factory(desktopDriver);
		searchButton = searchPF.getSearchButton();
		if (searchButton != null) {

			desktopDriver.marsControlClick(homepageTitle, text, searchButton);

			logger.log(LogStatus.PASS, "Search Button Clicked Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click on Search Button");
		}
	}

	public void correctAccountSearch(String Search) {

		try {

			if (desktopDriver.marsWinWaitActive(homepageTitle, text, 20) > 0) {

				desktopDriver.marsSleep(6000);
				searchEdit(Search);
				desktopDriver.marsSleep(3000);
				searchButton();

			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}
}
