package mars.JCI.Project.DLS.Section.Number.Search;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Section_Number_Search_Page_Factory {

	/** The desktop driver. */
	private MARSDesktopDriver desktopDriver;

	/** The home page title. */
	public String homePageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** Tool Bar Control */
	public String toolBarControl = "[NAME:accountFormToolstrip]";

	public DLS_Section_Number_Search_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	public int getToolbar() {
		if (desktopDriver.marsControlEnable(homePageTitle, text, toolBarControl) == 1) {
			return 1;
		} else {
			return 0;
		}

	}

}