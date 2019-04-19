package mars.JCI.Project.DLS.Programmed.Data.Search;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.DLS.Search.DLS_Search_Page_Action;
import mars.JCI.Project.DLS.Section.Number.Search.DLS_Section_Number_Search_Page_Factory;

public class DLS_Programmed_Data_Search_Page_Action {
	/** The Home page title. */
	public String homePageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** The MARSDesktopDriver driver. */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	public DLS_Programmed_Data_Search_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;

	}

	public void selectProgrammedData(String programmedDataName) {
		desktopDriver.marsSleep(3000);
		desktopDriver.marsMouseClick(text, 726, 116, 1, 0);
		desktopDriver.marsSend(programmedDataName, 1);
		logger.log(LogStatus.PASS, "Programmed Data is Entered Successfully to Programmed Data Search WindowElement");
		desktopDriver.marsMouseClick(text, 791, 124, 1, 0);
		logger.log(LogStatus.PASS, "Programmed Data Search done Successfully");

	}

	public int openSearchAccount(String userName) {
		DLS_Section_Number_Search_Page_Factory sectionNumberPF = new DLS_Section_Number_Search_Page_Factory(
				desktopDriver);
		desktopDriver.marsSleep(4000);
		DLS_Search_Page_Action searchPA = new DLS_Search_Page_Action(desktopDriver, logger);
		searchPA.correctAccountSearch(userName);
		desktopDriver.marsMouseClick(text, 105, 241, 2, 0);
		desktopDriver.marsSleep(6000);
		if (sectionNumberPF.getToolbar() > 0) {
			logger.log(LogStatus.PASS, "Clicked on " + userName + " Account and Opened Successfully");
			return 1;
		} else {
			logger.log(LogStatus.PASS, userName + " Account is Not Present");
			return 0;
		}
	}

}
