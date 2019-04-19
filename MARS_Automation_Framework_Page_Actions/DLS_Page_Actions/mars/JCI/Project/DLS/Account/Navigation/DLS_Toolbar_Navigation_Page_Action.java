package mars.JCI.Project.DLS.Account.Navigation;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.DLS.Account.Navigation.DLS_Account_Navigation_Page_Factory;
import mars.JCI.Project.DLS.Search.DLS_Search_Page_Action;

public class DLS_Toolbar_Navigation_Page_Action {

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

	public DLS_Toolbar_Navigation_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
	}

	public void clickToolbarTabs(String name) {
		desktopDriver.marsSleep(5000);
		logger.log(LogStatus.PASS, "Started Toolbar Navigation For " + name + " Account");
		desktopDriver.marsToolTip("Save", 19, 92);
		logger.log(LogStatus.PASS, "Save is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Error Check", 55, 92);
		logger.log(LogStatus.PASS, "Error Check is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Wizards", 94, 92);
		logger.log(LogStatus.PASS, "Wizards is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Wizards", 141, 93);
		logger.log(LogStatus.PASS, "Account Revision is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Connect Only", 179, 93);
		logger.log(LogStatus.PASS, "Connect Only is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Global Upload", 213, 93);
		logger.log(LogStatus.PASS, "Global Upload is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Global Download", 251, 93);
		logger.log(LogStatus.PASS, "Global Download is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Communication tags", 282, 93);
		logger.log(LogStatus.PASS, "Communication tags is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Upload Event buffer", 321, 93);
		logger.log(LogStatus.PASS, "Upload Event buffer is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Clear all tags", 356, 93);
		logger.log(LogStatus.PASS, "Clear all tags is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Disconnect When Complete", 397, 93);
		logger.log(LogStatus.PASS, "Disconnect When Complete is Present on " + name + " Account Toolbar");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Print", 446, 93);
		logger.log(LogStatus.PASS, "Print is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("Print preview", 487, 93);
		logger.log(LogStatus.PASS, "Print preview is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsToolTip("System Status Report", 522, 93);
		logger.log(LogStatus.PASS, "System Status Report is Present On Toolbar of " + name + " Account Window");
		desktopDriver.marsSleep(1000);
		desktopDriver.marsMouseClick(text,922, 88,1, 0);
		logger.log(LogStatus.PASS, "Toolbar Navigation Completed Successfully");
		
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
