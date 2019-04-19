package mars.JCI.Project.DLS.AdvanceSearch;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Advance_Search_Page_Action {
	/** The MARSDesktopDriver driver. */
	public MARSDesktopDriver desktopDriver;
	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The SearchHomepageTitle */
	public String searchHomepageTitle = "Advanced Search";

	/** The AdvanceSearchButton */
	public String advanceSearchButton = "";

	/** The AdvanceSearchEdit */
	public String advanceSearchEdit = "";
	
	/** The AdvanceSearchScreenCreatedByEdit */
	public String advanceSearchScreenCreatedByEdit = "";
	
	/** The AdvanceSearchScreenCreatedByEdit */
	public String advanceSearchByComment = "";

	/** The HomepageTitle */
	public String homepageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** The SearchButton. */
	public String searchButton = "";

	public DLS_Advance_Search_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;

	}

	public void clickAdvanceSearchButton() {
		DLS_Advance_Search_Page_Factory advanceSearchPF = new DLS_Advance_Search_Page_Factory(desktopDriver);
		advanceSearchButton = advanceSearchPF.getAdvanceSearchButton();

		if (advanceSearchButton != null) {

			desktopDriver.marsControlClick(homepageTitle, text, advanceSearchButton);

			logger.log(LogStatus.PASS, "Advance Search Button Clicked Successfully on DLS Home Page");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click Advance Search Button");
		}
	}

	public void advanceSearchByName(String Search) {
		DLS_Advance_Search_Page_Factory advanceSearchPF = new DLS_Advance_Search_Page_Factory(desktopDriver);
		advanceSearchEdit = advanceSearchPF.getAdvanceSearchEdit();

		if (advanceSearchEdit != null) {

			desktopDriver.marsSleep(4000);
			desktopDriver.marsControlSetText(searchHomepageTitle, text, advanceSearchEdit, Search);

			logger.log(LogStatus.PASS, "User Name Search data Entered Successfully on Advance Search POP-UP");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Enter User Name Search data");
		}
	}

	public void clickAdvanceSearchScreenButton() {
		DLS_Advance_Search_Page_Factory advanceSearchPF = new DLS_Advance_Search_Page_Factory(desktopDriver);
		searchButton = advanceSearchPF.getAdvanceSearchScreenbutton();
		if (searchButton != null) {
			desktopDriver.marsControlClick(searchHomepageTitle, text, searchButton);
			logger.log(LogStatus.PASS, "User Account using User Name Searched Successfully");
		} else {
			logger.log(LogStatus.FAIL, "User Account using User Name Failed to Search data");
		}
	}

	public void searchOnAdvanceSearch(String Search) {

		try {

			if (desktopDriver.marsWinWaitActive(homepageTitle, text, 20) > 0) {
				desktopDriver.marsSleep(6000);
				clickAdvanceSearchButton();
				advanceSearchByName(Search);
				clickAdvanceSearchScreenButton();
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}
	
	
	public void advanceSearchByCreatedUsername(String correctusername) {
		DLS_Advance_Search_Page_Factory advanceSearchPF = new DLS_Advance_Search_Page_Factory(desktopDriver);
		advanceSearchScreenCreatedByEdit = advanceSearchPF.getAdvanceSearchScreenCreatedByAccountname();

		if (advanceSearchScreenCreatedByEdit != null) {

			desktopDriver.marsSleep(4000);
			desktopDriver.marsControlSetText(searchHomepageTitle,text,advanceSearchScreenCreatedByEdit, correctusername);

			logger.log(LogStatus.PASS, "Search by Created Username Entered Successfully on Advance Search POP-UP");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Enter Created by Username");
		}
	}
	
	public void searchByCreatedUsernameOnAdvanceSearch(String correctusername) {

		try {

			if (desktopDriver.marsWinWaitActive(homepageTitle, text, 20) > 0) {
				desktopDriver.marsSleep(6000);
				clickAdvanceSearchButton();
				advanceSearchByCreatedUsername(correctusername);
				clickAdvanceSearchScreenButton();
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}
	
	public void advanceSearchByComments(String comment) {
		DLS_Advance_Search_Page_Factory advanceSearchPF = new DLS_Advance_Search_Page_Factory(desktopDriver);
		advanceSearchByComment = advanceSearchPF.getAdvanceSearchByComment();

		if (advanceSearchByComment != null) {

			desktopDriver.marsSleep(4000);
			desktopDriver.marsControlSetText(searchHomepageTitle,text,advanceSearchByComment,comment);

			logger.log(LogStatus.PASS, "Search by Comments Entered Successfully on Advance Search POP-UP");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Enter Comments");
		}
	}
	
	
	public void searchByCommentsOnAdvanceSearch(String comment) {

		try {

			if (desktopDriver.marsWinWaitActive(homepageTitle, text, 20) > 0) {
				desktopDriver.marsSleep(6000);
				clickAdvanceSearchButton();
				advanceSearchByComments(comment);
				clickAdvanceSearchScreenButton();
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}
	
	
	
	

}
