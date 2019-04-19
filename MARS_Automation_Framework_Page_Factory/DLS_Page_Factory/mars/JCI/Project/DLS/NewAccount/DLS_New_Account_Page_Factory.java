package mars.JCI.Project.DLS.NewAccount;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class DLS_New_Account_Page_Factory {
	/** The MARSDesktopDriver */
	private MARSDesktopDriver desktopDriver;

	/** The New Account page title. */
	public String newAccountPageTitle = "Create New Account (Basic)";

	/** The New Account Comment page title. */
	public String newAccountCommmentPageTitle = "Create A New Account";

	/** The text. */
	public String text = "";

	/** The Username Control */
	public String userNameControl = "[Name:accountName]";

	/** The Phonenumber Control */
	public String phoneNumberControl = "[Name:phoneNumber]";

	/** The Create control */
	public String createButtonControl = "[Name:btcCreate]";

	/** The Advance control */
	public String advanceButtonControl = "[Name:advanced]";

	/** The Create Button on comments control */
	public String createButtonOnCommentControl = "[Name:create]";

	/** The UserAccount Comment control */
	public String userAccountCommentfield= "[Name:textBox2]";



	/** The homepageTile */
	public String homepageTile = "DLS 5 v1.61";

	/**
	 * Instantiates a new DLS login page factory.
	 *
	 * @param desktopDriver
	 *            the desktop driver
	 */
	public DLS_New_Account_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	public String getUsername() {
		if (desktopDriver.marsControlEnable(newAccountPageTitle, text, userNameControl) == 1) {
			return this.userNameControl;
		} else {
			return null;
		}

	}

	public String getPhonenumber() {
		if (desktopDriver.marsControlEnable(newAccountPageTitle, text, phoneNumberControl) == 1) {
			return this.phoneNumberControl;
		} else {
			return null;
		}
	}

	public String getCreatebutton() {
		if (desktopDriver.marsControlEnable(newAccountPageTitle, text, createButtonControl) == 1) {
			return this.createButtonControl;
		} else {
			return null;
		}

	}

	public String getAdvancebutton() {
		if (desktopDriver.marsControlEnable(newAccountPageTitle, text, advanceButtonControl) == 1) {
			return this.advanceButtonControl;
		} else {
			return null;
		}

	}
	public String getCreatebuttonOnComment() {
		if (desktopDriver.marsControlEnable(newAccountCommmentPageTitle, text, createButtonOnCommentControl) == 1) {
			return this.createButtonOnCommentControl;
		} else {
			return null;
		}

	}

	public String getEditFieldOnComment() {
		if (desktopDriver.marsControlEnable(newAccountCommmentPageTitle,text, userAccountCommentfield) == 1) {
			return this. userAccountCommentfield;
		} else {
			return null;
		}

	}



}
