package mars.JCI.Project.DLS.Login;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.DLS.Home.DLS_Home_Page_Action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The Class DLS_Login_Page_Action.
 */
public class DLS_Login_Page_Action {

	/** The Login page title. */
	public String loginPageTitle = "Welcome To DLS 5 v1.61";

	/** The Home page title. */
	public String homePageTitle = "DLS 5 v1.61";

	/** The text. */
	public String text = "";

	/** The baseURL */
	public String baseURL = "";

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The window control. */
	public String windowControl;

	/**
	 * Instantiates/Constructor a new DLS login page action.
	 *
	 * @param desktopDriver
	 *            the desktopDriver
	 * @param logger
	 *            the logger
	 * @param baseURL
	 */
	public DLS_Login_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger, String baseURL) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
		this.baseURL = baseURL;
	}

	/**
	 * Enter password.
	 *
	 * @param password
	 *            the password
	 * 
	 * @return None
	 */
	public void enterPassword(String password) {
		DLS_Login_Page_Factory loginPF = new DLS_Login_Page_Factory(desktopDriver);
		windowControl = loginPF.getPassword();
		if (windowControl != null) {
			desktopDriver.marsControlSend(loginPageTitle, text, windowControl, password);

			logger.log(LogStatus.PASS, "Password Entered succesfully to Password WindowElement");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Enter Password to Password WindowElement");
		}
	}

	public void clickOK() {
		DLS_Login_Page_Factory loginPF = new DLS_Login_Page_Factory(desktopDriver);
		windowControl = loginPF.getOKBtn();
		if (windowControl != null) {
			desktopDriver.marsControlClick("Welcome To DLS 5 v1.61", "", "[Name:Btn_Ok]");
			logger.log(LogStatus.PASS, "OK button Clicked Succesfully on DLS Login Window");
		} else {
			logger.log(LogStatus.ERROR, "Identifying Window Control for OK Button Field Failed");
		}
	}

	public void openDLSWindowClose() throws IOException {
		try {
			desktopDriver.marsSleep(1000);

			desktopDriver.marsWinClose(homePageTitle, text);

			desktopDriver.marsWinClose(homePageTitle, text);

			desktopDriver.marsWinClose(homePageTitle, text);

			logger.log(LogStatus.PASS, "DLS Window  Closed Successfully");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "DLS Window Failed to Close");
		}
	}

	public void allDLSProcessClose() throws IOException {

		String findProcess = "DLSMDIHost.exe";
		String filenameFilter = "/nh /fi \"Imagename eq " + findProcess + "\"";
		String tasksCmd = System.getenv("windir") + "/system32/tasklist.exe " + filenameFilter;

		Process p = Runtime.getRuntime().exec(tasksCmd);
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

		ArrayList<String> procs = new ArrayList<String>();
		String line = null;
		while ((line = input.readLine()) != null)
			procs.add(line);

		input.close();
		Boolean processFound = procs.stream().filter(row -> row.indexOf(findProcess) > -1).count() > 0;

		if (processFound) {

			desktopDriver.marsWinClose(loginPageTitle, text);
			desktopDriver.marsWinClose(homePageTitle, text);
			logger.log(LogStatus.PASS, "DLS is Closed we Identified it was Opened Before Execution");

		} else {
			logger.log(LogStatus.PASS, "DLS is not Found Opened bBfore Execution");
		}
	}

	public void commonCorrectLogin(String password) throws IOException {
		try {
			allDLSProcessClose();
			desktopDriver.marsSleep(2000);
			openDLS();
			if (desktopDriver.marsWinWaitActive(loginPageTitle, text, 20) > 0) {
				enterPassword(password);
				clickOK();
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}

	public void openDLS() {
		desktopDriver.marsRun(baseURL);
	}

	public DLS_Home_Page_Action correctLogin(String password) throws IOException {
		DLS_Home_Page_Action homePA = null;
		try {
			allDLSProcessClose();
			desktopDriver.marsSleep(2000);
			openDLS();
			if (desktopDriver.marsWinWaitActive(loginPageTitle, text, 20) > 0) {
				enterPassword(password);
				clickOK();
				homePA = new DLS_Home_Page_Action(desktopDriver, logger);
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}
		return homePA;
	}

	public DLS_Login_Error_Page_Action inCorrectLogin(String password) throws IOException {
		DLS_Login_Error_Page_Action errorPA = null;
		try {
			openDLSWindowClose();
			desktopDriver.marsSleep(1000);
			allDLSProcessClose();
			openDLS();
			if (desktopDriver.marsWinWaitActive(loginPageTitle, text, 20) > 0) {
				enterPassword(password);
				clickOK();
				errorPA = new DLS_Login_Error_Page_Action(desktopDriver, logger);
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}
		return errorPA;
	}
}
