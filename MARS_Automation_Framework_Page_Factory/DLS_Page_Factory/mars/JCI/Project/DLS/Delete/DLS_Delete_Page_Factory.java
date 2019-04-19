package mars.JCI.Project.DLS.Delete;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Delete_Page_Factory {

	/** The desktop driver. */
	private MARSDesktopDriver desktopDriver;
	
	/** The import import Open Control */
	public String text = "";
	
	/** The HomepageTitle */
	public String homepageTitle = "DLS 5 v1.61";
	
	/** The import Yes Control */
	public String deleteYesControl = "[Name:yes]";
	
	
	public DLS_Delete_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}
	
	public String getPermanentDeleteYesButton() {
		
		return this.deleteYesControl;

}

	
}

