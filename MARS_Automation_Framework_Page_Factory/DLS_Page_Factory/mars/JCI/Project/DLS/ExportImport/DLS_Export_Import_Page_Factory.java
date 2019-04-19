package mars.JCI.Project.DLS.ExportImport;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Export_Import_Page_Factory {

	/** The desktop driver. */
	private MARSDesktopDriver desktopDriver;

	/** The Browse page Title */
	public String browsePageTitle = "Browse For Folder";

	/** The Import select page Title */
	public String importselectPageTitle = "Open";

	/** The Export page Title */
	public String exportOkPageTitle = "Browse For Folder";

	/** The Browse Page Ok Control */
	public String exportOkControl = "Button2";

	/** The import Page Edit Control */
	public String importPageEditControl = "Edit1";

	/** The import Complete Page Control */
	public String importCompleteOkControl = "[Name:ok]";

	/** The import Open Control */
	public String importOpenControl = "Button1";

	/** The import Yes Control */
	public String importYesControl = "[Name:yes]";

	/** The import import Open Control */
	public String text = "";
	/** The HomepageTitle */
	public String homepageTitle = "DLS 5 v1.61";

	public DLS_Export_Import_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	public String getExportOkbutton() {
		if (desktopDriver.marsControlEnable(exportOkPageTitle, text, exportOkControl) == 1) {
			return this.exportOkControl;
		} else {
			return null;
		}

	}

	public String getImportEdit() {
		if (desktopDriver.marsControlEnable(importselectPageTitle, text, importPageEditControl) == 1) {
			return this.importPageEditControl;
		} else {
			return null;
		}

	}

	public String getImportOkButton() {
		
			return this.importCompleteOkControl;
		
	}

	public String getImportOpenButton() {
		if (desktopDriver.marsControlEnable(importselectPageTitle, text, importOpenControl) == 1) {
			return this.importOpenControl;
		} else {
			return null;
		}

	}

	
	

	public String getImportYesButton() {
		
			return this. importYesControl;

	}

}
