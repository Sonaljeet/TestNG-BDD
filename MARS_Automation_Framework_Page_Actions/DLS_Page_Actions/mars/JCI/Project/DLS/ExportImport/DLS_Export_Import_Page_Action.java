package mars.JCI.Project.DLS.ExportImport;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

import mars.JCI.Project.DLS.Search.DLS_Search_Page_Action;


public class DLS_Export_Import_Page_Action {

	/** The MARSDesktopDriver driver. */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The Export page Title */
	public String exportOkPageTitle = "Browse For Folder";

	/** The Import select page Title */
	public String importselectPageTitle = "Open";

	/** The MouseClick */
	public int mouseclick;

	/** The export Ok Button */
	public String exportOkButton = "";

	/** The export Open Button */
	public String exportOpenButton = "";

	/** The text */
	public String text = "";

	/** The HomepageTitle */
	public String homepageTitle = "DLS 5 v1.61";

	/** The Import file name Control */
	public String importfilenameControl = "";

	/** The Import Yes Control */
	public String importYesControl = "";

	public DLS_Export_Import_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
	}

	public void clickExportButton() {
		desktopDriver.marsSleep(6000);

		mouseclick = desktopDriver.marsMouseClick("", 386, 190, 1, 0);

		if (mouseclick > 0) {

			logger.log(LogStatus.PASS, "Export Button Clicked Successfully on DLS Home Page");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click Export Button");
		}
	}

	public void exportOkButton() {
		DLS_Export_Import_Page_Factory exportImportPF = new DLS_Export_Import_Page_Factory(desktopDriver);
		exportOkButton = exportImportPF.getExportOkbutton();

		if (exportOkButton != null) {

			desktopDriver.marsControlClick(exportOkPageTitle, text, exportOkButton);

			logger.log(LogStatus.PASS, "Clicked Export Ok Button Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Fail to Clicked Export Ok Button");
		}
	}

	public void exportFile(String filename) {
		try {
			DLS_Search_Page_Action searchPA = new DLS_Search_Page_Action(desktopDriver, logger);

			if (desktopDriver.marsWinWaitActive(homepageTitle, text, 20) > 0) {
				desktopDriver.marsSleep(3000);
				searchPA.correctAccountSearch(filename);
				desktopDriver.marsSleep(3000);

				clickExportButton();
				desktopDriver.marsSleep(3000);
				exportOkButton();
				desktopDriver.marsSleep(1000);
				importYesButton();
				logger.log(LogStatus.PASS, "File with name " + filename + " Exported Successfully");

			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}

	public void importMouseClick() {
		desktopDriver.marsSleep(6000);

		mouseclick = desktopDriver.marsMouseClick("", 473, 191, 1, 0);

		if (mouseclick > 0) {

			logger.log(LogStatus.PASS, "Import Button Clicked Successfully on DLS Home Page");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click Import Button");
		}
	}

	public void importFilename(String filename) {
		DLS_Export_Import_Page_Factory exporrimportPF = new DLS_Export_Import_Page_Factory(desktopDriver);
		importfilenameControl = exporrimportPF.getImportEdit();
		if (importfilenameControl != null) {

			desktopDriver.marsSleep(2000);

			desktopDriver.marsControlSend(importselectPageTitle, text, importfilenameControl, filename);

			logger.log(LogStatus.PASS, "Name of file to be Imported Entered Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Enter Name of file to be Imported");
		}
	}

	public void importOpenButton() {
		DLS_Export_Import_Page_Factory exportImportPF = new DLS_Export_Import_Page_Factory(desktopDriver);
		exportOpenButton = exportImportPF.getImportOpenButton();

		if (exportOpenButton != null) {

			desktopDriver.marsControlClick(importselectPageTitle, text, exportOpenButton);

			logger.log(LogStatus.PASS, "Clicked Import File Open Button Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click Import File Open Button");
		}
	}

	public void importYesButton() {
		DLS_Export_Import_Page_Factory exportImportPF = new DLS_Export_Import_Page_Factory(desktopDriver);
		importYesControl = exportImportPF.getImportYesButton();
		desktopDriver.marsControlClick(homepageTitle, text, importYesControl);

		logger.log(LogStatus.PASS, "File already exists to be imported So,Clicked Ok button");

	}

	public void importFile(String filename) {
		try {
			DLS_Export_Import_Page_Factory exportImportPF = new DLS_Export_Import_Page_Factory(desktopDriver);

			if (desktopDriver.marsWinWaitActive(homepageTitle, text, 20) > 0) {

				desktopDriver.marsSleep(3000);
				importMouseClick();
				desktopDriver.marsSleep(3000);
				importFilename(filename);
				desktopDriver.marsSleep(3000);
				importOpenButton();
				desktopDriver.marsSleep(1000);
				importYesButton();
				desktopDriver.marsSleep(2000);

				desktopDriver.marsControlClick(homepageTitle, text, exportImportPF.getImportOkButton());
				logger.log(LogStatus.PASS, "File with name " + filename + " Imported Successfully");

			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}
}
