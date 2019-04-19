package mars.JCI.Project.CCT.Home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.JavaTimer;
import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class CCT_Home_Page_Action {

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The Home page title. */
	public String homePageTitle = "CCT 10.3";

	/** The text. */
	public String text = "";
	
	/** The text. */
	public String BaseURL = "";

	public CCT_Home_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger, String baseurl) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;
		this.BaseURL = baseurl;
	}

	public void verifyHomePageTitle() throws IOException, InterruptedException {

		allDLSProcessClose();
		Thread.sleep(15000);
		openCCT();
		JavaTimer.startSessionTimer();

		if (desktopDriver.marsWinWaitActive(homePageTitle, text, 20) > 0) {

			logger.log(LogStatus.PASS, "CCT Window opened Successfully with time " + JavaTimer.endSessionTimer());

		}
	}

	public void allDLSProcessClose() throws IOException {

		String findProcess = "javaw.exe";
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

			desktopDriver.marsWinClose(homePageTitle, text);
			desktopDriver.marsMouseClick("", 864, 499, 1, 0);

		}

	}

	public void openCCT() {
		desktopDriver.marsRun(BaseURL);
	}

}
