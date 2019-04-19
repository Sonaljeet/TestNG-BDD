package mars.JCI.Project.DLS.ExportSearchResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Export_Search_Result_Page_Action {
	/** The MARSDesktopDriver driver. */
	public MARSDesktopDriver desktopDriver;
	
	/** The ExtentTest logger. */
	public ExtentTest logger;
	
	/** The SearchButton. */
	public String searchButton = "";
	
	/** The HomepageTitle */
	public String homepageTitle = "DLS 5 v1.61";
	
	/** The text. */
	public String text = "";
	/** The SaveasPdfPageTitle */
	public String saveasPdfPageTitle = "Save As";
	
	/** The mouseClick. */
	public int mouseClick;

	public DLS_Export_Search_Result_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;

	}

	public void exportSearchResultButton() {
		DLS_Export_Search_Result_Page_Factory exportSearchPF = new DLS_Export_Search_Result_Page_Factory(desktopDriver);
		searchButton = exportSearchPF.getExportSearchResultbutton();
		if (searchButton != null) {

			desktopDriver.marsControlClick(homepageTitle, text, searchButton);

			logger.log(LogStatus.PASS, "Export Search Button Clicked Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click ExportSearch Button");
		}
	}

	public void exportSearchPdfMouseClick() {

		desktopDriver.marsSleep(2000);
		mouseClick = desktopDriver.marsMouseClick("", 695, 111, 1, 0);
		if (mouseClick > 0)
		{

			logger.log(LogStatus.PASS, "PDF Saving Window Opened Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Open PDF Saving Window");
		}
	}

	public void exportSearchPdfName(String Search) {
		DLS_Export_Search_Result_Page_Factory exportSearchPF = new DLS_Export_Search_Result_Page_Factory(desktopDriver);
		searchButton = exportSearchPF.getPdfSaveEdit();

		if (searchButton != null) {
			desktopDriver.marsControlSetText(saveasPdfPageTitle, text, searchButton, Search);
			logger.log(LogStatus.PASS, "File Name added Successfully to PDF ");
		} else {
			logger.log(LogStatus.FAIL, "File Name  not added Successfully to PDF");
		}
	}

	public void saveAsPDFButton() {
		DLS_Export_Search_Result_Page_Factory exportSearchPF = new DLS_Export_Search_Result_Page_Factory(desktopDriver);
		searchButton = exportSearchPF.getPdfSaveButon();
		if (searchButton != null) {
			desktopDriver.marsControlClick(saveasPdfPageTitle, text, searchButton);

			logger.log(LogStatus.PASS, " PDF Save Button Clicked Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click PDF Save Button");
		}
	}

	public void errorOkPDFButton() {
		DLS_Export_Search_Result_Page_Factory exportSearchPF = new DLS_Export_Search_Result_Page_Factory(desktopDriver);
		searchButton = exportSearchPF.getErrorOkPdfButon();
		if (searchButton != null) 
			{
			if(desktopDriver.marsControlEnable(homepageTitle, text, searchButton)>0)
			{
				logger.log(LogStatus.FAIL, "Error While Exporting PDF Search Result");	
			}
			else
			{
				logger.log(LogStatus.PASS, " No error occurred,pdf saved successfully ");
			}
			

			 
		}

	}

	public void exportSearchResult(String Search) {

		try {
			if (desktopDriver.marsWinWaitActive(homepageTitle, text, 20) > 0) {
				desktopDriver.marsSleep(6000);
				exportSearchResultButton();
				desktopDriver.marsSleep(2000);
				exportSearchPdfMouseClick();
				desktopDriver.marsSleep(2000);
				exportSearchPdfName(Search);
				desktopDriver.marsSleep(2000);
				saveAsPDFButton();
				desktopDriver.marsSleep(1000);
				errorOkPDFButton();

			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}

}
