package mars.JCI.Project.DLS.Account.Navigation;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Account_Navigation_Page_Factory {

	/** The MARSDesktopDriver */
	private MARSDesktopDriver desktopDriver;

	/** The home page title. */
	public String homePageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** Navigation Tabs Name Array */
	public String nameControl[] = { "[NAME:Signature Graphic]", "[NAME:Users]", "[NAME:Partitions]", "[NAME:Zones]",
			"[NAME:Schedules]", "[NAME:Communications]", "[NAME:System]", "[NAME:DLS]", "[NAME:PGMs]",
			"[NAME:Wireless]", "[NAME:Keypad]", "[NAME:Audio Options]", "[NAME:Status and Functions]",
			"[NAME:Event Buffer]" };

	/** Navigation Tabs Name Display Array */
	public String displayNav[] = { "Signature Graphic", "Users", "Partitions", "Zones", "Schedules", "Communications",
			"System", "DLS", "PGMs", "Wireless", "Keypad", "Audio Options", "Status and Functions", "Event Buffer" };

	/** search Name Control */
	public String searchNameControl = "[NAME:searchTextBox]";

	/** Tool Bar Control */
	public String toolBarControl = "[NAME:accountFormToolstrip]";

	public DLS_Account_Navigation_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	public String[] getAllTabs() {
		return nameControl;
	}

	public String[] getAllTabNamesToDisplay() {
		return displayNav;
	}

	public String getSearchName() {
		if (desktopDriver.marsControlEnable(homePageTitle, text, searchNameControl) == 1) {
			return this.searchNameControl;
		} else {
			return null;
		}

	}

	public int getToolbar() {
		if (desktopDriver.marsControlEnable(homePageTitle, text, toolBarControl) == 1) {
			return 1;
		} else {
			return 0;
		}

	}

}
