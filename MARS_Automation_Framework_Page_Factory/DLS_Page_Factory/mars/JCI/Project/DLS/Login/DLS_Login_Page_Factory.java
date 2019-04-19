package mars.JCI.Project.DLS.Login;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating DLS_Login_Page_ objects.
 */
public class DLS_Login_Page_Factory {

	/** The MARSDesktopDriver */
	private MARSDesktopDriver desktopDriver;

	/** The Login page title. */
	public String loginPageTitle = "Welcome To DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** The password Control */
	public String passwordControl = "[NAME:TXT_Password]";

	/** The Button ok Control */
	public String buttonOKControl = "[NAME:Btn_Ok]";

	/**
	 * Instantiates a new DLS login page factory.
	 *
	 * @param desktopDriver
	 *            the desktop driver
	 */
	public DLS_Login_Page_Factory(MARSDesktopDriver desktopDriver) {
		this.desktopDriver = desktopDriver;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		if (desktopDriver.marsControlEnable(loginPageTitle, text, passwordControl) == 1) {
			return this.passwordControl;
		} else {
			return null;
		}

	}

	/**
	 * Gets the OK Button.
	 *
	 * @return the String
	 */
	public String getOKBtn() {
		if (desktopDriver.marsControlEnable(loginPageTitle, text, buttonOKControl) == 1) {
			return this.buttonOKControl;
		} else {
			return null;
		}

	}

}
