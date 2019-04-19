package mars.JCI.Project.DLS.Search;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Search_Page_Factory {

	/** The MARSDesktopDriver */
	private MARSDesktopDriver desktopDriver;

	/** The Edit Control */
	public String editControl = "[Name:searchTextBox]";

	/** The Searchbutton Control */
	public String searchButtonControl = "[Name:searchButton]";

	/** The homepageTile */
	public String homepageTile = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	public DLS_Search_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	public String getSearchEdit() {
		if (desktopDriver.marsControlEnable(homepageTile, text, editControl) == 1) {

			return this.editControl;
		} else {
			return null;
		}

	}

	public String getSearchButton() {
		if (desktopDriver.marsControlEnable(homepageTile, text, searchButtonControl) == 1) {
			return this.searchButtonControl;
		} else {
			return null;
		}

	}

}
