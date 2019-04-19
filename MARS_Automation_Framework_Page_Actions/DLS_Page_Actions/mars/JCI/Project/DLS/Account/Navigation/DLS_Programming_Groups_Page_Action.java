package mars.JCI.Project.DLS.Account.Navigation;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.DLS.Account.Navigation.DLS_Account_Navigation_Page_Factory;
import mars.JCI.Project.DLS.Search.DLS_Search_Page_Action;

public class DLS_Programming_Groups_Page_Action {
	/** The Home page title. */
	public String homePageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The window control. */
	public String[] windowControl;

	/** The window controlD. */
	public String[] windowControlD;

	/** The window controlD. */
	public String windowControlN;

	public DLS_Programming_Groups_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
	}

	public void clickProgrammingGroupsTabs(String name) {
		DLS_Account_Navigation_Page_Factory accountNavigationPF = new DLS_Account_Navigation_Page_Factory(
				desktopDriver);
		windowControl = accountNavigationPF.getAllTabs();
		windowControlD = accountNavigationPF.getAllTabNamesToDisplay();
		desktopDriver.marsSleep(5000);
		logger.log(LogStatus.PASS, "Started Navigation for Programming Groups of " + name + " Account");
		for (int i = 0; i <= 13; i++) {
			if (desktopDriver.marsControlShow(homePageTitle, text, windowControl[i]) > 0) {
				desktopDriver.marsControlClick(homePageTitle, text, windowControl[i]);
				desktopDriver.marsSleep(2500);
				logger.log(LogStatus.PASS,
						windowControlD[i] + " is Present on " + name + " Account Programming Groups");
			} else {
				logger.log(LogStatus.PASS,
						windowControlD[i] + " is Not Present on " + name + " Account Programming Groups");
			}
		}

		logger.log(LogStatus.PASS, "Programming Groups Navigation Completed Successfully");

	}

	public int openSearchAccount(String userName) {
		DLS_Account_Navigation_Page_Factory accountNavigationPF = new DLS_Account_Navigation_Page_Factory(
				desktopDriver);
		DLS_Search_Page_Action searchPA = new DLS_Search_Page_Action(desktopDriver, logger);
		searchPA.correctAccountSearch(userName);
		desktopDriver.marsMouseClick(text, 105, 241, 2, 0);
		desktopDriver.marsSleep(6000);
		if (accountNavigationPF.getToolbar() > 0) {
			logger.log(LogStatus.PASS, "Clicked on " + userName + " Account and Opened Successfully");
			return 1;
		} else {
			logger.log(LogStatus.PASS, userName + " Account is Not Present");
			return 0;
		}
	}

}
