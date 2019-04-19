package mars.JCI.Project.DLS.ExportSearchResult;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Export_Search_Result_Page_Factory {
	/** The desktop driver. */
	private MARSDesktopDriver desktopDriver;

	/** The text. */
	public String text = "";

	/** The ExportSearchResultbutton Control */
	public String exportSearchResultButtonControl = "[Name:exportSearchResults]";

	/** The PdfSavebutton Control */
	public String pdfSaveButtonControl = "Button1";

	/** The PdfSaveEdit Control */
	public String pdfSaveEditControl = "Edit1";

	/** The homepageTile */
	public String homepageTile = "DLS 5 v1.61";

	/** The saveaspageTitle Control */
	public String saveaspageTitle = "Save As";

	/** The ErrorPdfokbutton Control */
	public String errorPdfOkButtonControl = "[Name:ok]";

	public DLS_Export_Search_Result_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	public String getExportSearchResultbutton() {
		if (desktopDriver.marsControlEnable(homepageTile, text, exportSearchResultButtonControl) == 1) {
			return this.exportSearchResultButtonControl;
		} else {
			return null;
		}

	}

	public String getPdfSaveEdit() {
		if (desktopDriver.marsControlEnable(saveaspageTitle, text, pdfSaveEditControl) == 1) {
			return this.pdfSaveEditControl;
		} else {
			return null;
		}

	}

	public String getPdfSaveButon() {
		if (desktopDriver.marsControlEnable(saveaspageTitle, text, pdfSaveButtonControl) == 1) {
			return this.pdfSaveButtonControl;
		} else {
			return null;
		}

	}

	public String getErrorOkPdfButon() {
		if (desktopDriver.marsControlEnable(homepageTile, text, errorPdfOkButtonControl) == 1) {
			return this.errorPdfOkButtonControl;
		} else {
			return null;
		}

	}

}
