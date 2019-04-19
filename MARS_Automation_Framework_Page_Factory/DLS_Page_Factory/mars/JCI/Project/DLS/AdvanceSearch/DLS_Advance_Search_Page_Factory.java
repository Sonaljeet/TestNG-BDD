package mars.JCI.Project.DLS.AdvanceSearch;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_Advance_Search_Page_Factory {
	/** The MARSDesktopDriver driver. */
	private MARSDesktopDriver desktopDriver;

	/** The AdvanceSearchbutton Control */
	public String advanceSearchbuttonControl = "[Name:advancedSearch]";

	/** The AdvanceSearchEdit Control */
	public String advanceSearchEditControl = "[Name:nameSearch]";

	/** The AdvanceSearchScreenbutton Control */
	public String advanceSearchScreenbuttonControl = "[Name:button1]";

	/** The advanceSearchScreenCreatedBy Control */
	public String advanceSearchScreenCreatedByUsernameControl = "[Name:createdBySearch]";

	/** The advanceSearchScreenBy Comment Control */
	public String advanceSearchScreenByCommentControl = "[Name:commentSearch]";

	/** The AdvanceSearchpageTile */
	public String advanceSearchpageTile = "Advanced Search";

	/** The text. */
	public String text = "";

	/** The homepageTitle */
	public String homepageTitle = "DLS 5 v1.61";

	public DLS_Advance_Search_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	public String getAdvanceSearchButton() {
		if (desktopDriver.marsControlEnable(homepageTitle, text, advanceSearchbuttonControl) == 1) {
			return this.advanceSearchbuttonControl;
		} else {
			return null;
		}
	}

	public String getAdvanceSearchEdit() {
		return this.advanceSearchEditControl;

	}

	public String getAdvanceSearchScreenbutton() {

		if (desktopDriver.marsControlEnable(advanceSearchpageTile, text, advanceSearchScreenbuttonControl) == 1) {
			return this.advanceSearchScreenbuttonControl;
		} else {
			return null;
		}

	}

	public String getAdvanceSearchScreenCreatedByAccountname() {
		return this.advanceSearchScreenCreatedByUsernameControl;

	}

	public String getAdvanceSearchByComment() {
		return this.advanceSearchScreenByCommentControl;

	}

}
