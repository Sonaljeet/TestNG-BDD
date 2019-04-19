/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/



package mars.Component.Functions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import mars.Business.Layer.EmailReports;
import mars.Business.Layer.ReadPropertyFile;
import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.automation.framework.launcher.MARSEngineController;
import mars.automation.framework.launcher.MARSEngineUIHelper;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseClass.
 */
public class API_BaseClass {

	/** The driver. */
	public static WebDriver driver;
	
	public static MARSDesktopDriver desktopDriver;

	/**
	 * Instantiates a new base class.
	 */
	public API_BaseClass() {
		this.driver = driver;
	}

	// Set up Extent Report Instance for accessing through out MARS Framework

	/** The reporter. */
	public static ExtentReports reporter = null;

	/** The method name. */
	public static String methodName;

	/** The logger. */
	public static ExtentTest logger;

	/** The Base URL. */
	public static String BaseURL;

	/** The report. */
	public static EmailReports report;

	/** The browser name. */
	// cpandeak
	public static String browserName = null;

	/** The mail config file. */
	public static String mailConfigFile = null;

	/** The maincontroller. */
	public static MARSEngineController maincontroller = null;

	/** The verification errors. */
	private StringBuffer verificationErrors = new StringBuffer();
	// TODO -- Need to set this path dynamically once Windows
	/** The prop File. */
	// Start up program integrate with MARS Framework.
	public static String projectPropertiesFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";

	/** The where to run. */
	private static String whereToRun = "local"; // possible values - local,
												// server
	// desktop app initilization

	/** The desk prop F ile. */
	String deskPropFIle = null;

	/** The desk mail config. */
	String deskMailConfig = null;

	/** The uihelper. */
	private static MARSEngineUIHelper uihelper = null;

	/** The send email. */
	private static boolean sendEmail;

	/** The db access required. */
	private static boolean dbAccessRequired;

	/** The browsers. */
	private static List<String> browsers = null;

	/** The prop F ile 1. */
	static String projectConfigFile = null;

	/**
	 * Contains Test Suites related setups. This method executes first in the
	 * class, this will executes before executing all tests. This Method set the
	 * graphical report path.
	 *
	 * @return none
	 */
	@BeforeSuite
	public static void beforeSuite() {
		initilizeLauncher(whereToRun);
		reporter = null;
		logger = null;
		String reportFile = ReadPropertyFile.getInstance(projectConfigFile).getProperty("reportfilepath");
		System.out.println("reportFile =" + reportFile);
		reporter = ExtentReportManager.getReporter(reportFile.toUpperCase(), true);

	}

	/**
	 * Initilize launcher.
	 *
	 * @param whereToRun
	 *            the where to run
	 */
	private static void initilizeLauncher(String whereToRun) {

		switch (whereToRun) {
		case "local":

			browserName = "";//desktop //chrome
			projectConfigFile = projectPropertiesFile;

			break;
		case "server":

			maincontroller = new MARSEngineController();
			uihelper = new MARSEngineUIHelper();
			sendEmail = uihelper.getSendEmail();
			dbAccessRequired = uihelper.isDbAccessRequired();
			browsers = uihelper.getBrowserDetails();
			browserName = uihelper.getBrowserDetails().get(0);
			System.out.println("browserName===" + browserName);
			projectConfigFile = MARSEngineUIHelper.getProjectConfig();
			System.out.println(browsers.size());
			for (int i = 0; i < browsers.size(); i++) {
				if (uihelper.getBrowserDetails().get(i) != null) {
					browserName = uihelper.getBrowserDetails().get(i);
					break;
				}
			}

			System.out.println("uihelper.getSendEmail() =" + uihelper.getSendEmail());
			System.out.println("uihelper.isDbAccessRequired() =" + uihelper.isDbAccessRequired());
			/*
			 * System.out.println("uihelper.getChromeBrowser() ="+
			 * uihelper.getChromeBrowser());
			 * System.out.println("uihelper.getFireFoxBrowser() "+
			 * uihelper.getFireFoxBrowser());
			 * System.out.println("uihelper.getIeBrowser() " +
			 * uihelper.getIeBrowser());
			 */
			System.out.println("uihelper.getProjectConfig() = " + MARSEngineUIHelper.getProjectConfig());
			System.out.println("uihelper.getEmailConfig() = " + MARSEngineUIHelper.getEmailConfig());
			System.out.println("uihelper.getDbConfig() = " + MARSEngineUIHelper.getDbConfig());
			break;

		default:
			break;
		}

	}

	/**
	 * Contains ExtentTest logger. This method executes before each @Test
	 * method.
	 *
	 * @param test
	 *            the test method name
	 * @return none
	 */
	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeEachTestMethod(String browser_Name,Method test) {

		try {
			
			methodName = test.getName();
			reporter.config().documentTitle("MARS Automation Report");
			reporter.config().reportHeadline(" Automation Execution Report");
			reporter.config().reportName("MARS");
			logger = reporter.startTest(browser_Name.toUpperCase()+ " - " + test.getAnnotation(Test.class).description());
			System.out.println("Base before method started");
			BaseURL = ReadPropertyFile.getInstance(projectConfigFile).getProperty("url");
			if(!(browser_Name.equalsIgnoreCase("")) && (browser_Name!=null) && !(browser_Name.equalsIgnoreCase("null"))){
				driver = LocalDriverFactory.createInstance(BaseURL, browser_Name);
			}
		} catch (Exception e) {
			// print exception if test method is not valid
			System.out.println("Test Method " + test + "is wrong in Before Method");
			e.printStackTrace();
		}
	}

	/**
	 * Contains ExtentReports instance. This method executes after each @Test
	 * method.
	 *
	 * @return none
	 */
	@AfterMethod
	public void afterEachTestMethod() {
		try {
			reporter.endTest(logger);
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				Assert.fail(verificationErrorString);
			}
			driver.quit();
		} catch (Exception e) {
			// print exception if test method is not valid
			System.out.println("Extent Test Logger is not identified in After Method");
		}

	}

	/**
	 * Contains class related setups. This method executes before each class.
	 *
	 * @return none
	 */

	@BeforeClass
	public void beforeClass() {

	}

	/**
	 * Contains class related setups. This method executes after each class.
	 *
	 * @return none
	 */
	@AfterClass
	public void afterClass() {
	}

	/**
	 * Contains Test Method related setups. This method executes before
	 * all @Test method once.
	 *
	 * @return none
	 */
	@BeforeTest
	public void beforeTest() {
	}

	/**
	 * Contains Test Method related setups. This method executes after all @Test
	 * method once.
	 *
	 * @return none
	 */
	@AfterTest
	public void afterTest() {
	}

	/**
	 * Contains Test Suites related setups. This method executes last in the
	 * class, this will executes after executing all tests. This Method generate
	 * report on path.
	 *
	 * @return none
	 */
	@AfterSuite
	public static void afterSuite() {
		reporter.flush();
		replaceTextInReportFile();
		// code to send email
		System.out.println("Sending Email");
		// sendEmail(true);
		//sendEmail(uihelper.getSendEmail());
		if (whereToRun.equalsIgnoreCase("server")) {
			sendEmail(uihelper.getSendEmail());
		}
		if(whereToRun.equalsIgnoreCase("local")){
			sendEmail(true);
		}
	}
	
    /**
     * This method replaces </br>{@literal<span class='right'>ExtentReports</span>}</br> in the Extent reports HTML file
     */
    private static void replaceTextInReportFile() {	
    	try {
    		File htmlContent = new File(ReadPropertyFile.getInstance(projectConfigFile).getProperty("reportfilepath"));
    		Document doc = Jsoup.parse(htmlContent, "utf-8");
    		Elements ReportHeader = doc.getElementsByAttributeValue("class", "right");
    		for (Element header : ReportHeader)
    		{  
    			header.text("MARS");
    		} 
    		String html=doc.html();
    		Writer writer = new PrintWriter(ReadPropertyFile.getInstance(projectConfigFile).getProperty("reportfilepath"));
    		writer = new BufferedWriter(writer);
    		writer.write(doc.html());
    		writer.close();
    	} catch (FileNotFoundException e) {
    		logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
    	} catch (IOException e) {
    			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
    	}
    }

	/**
	 * Send email.
	 *
	 * @param mail
	 *            the mail
	 */
	private static void sendEmail(boolean mail) {

		if (mail) {
			if (whereToRun.equalsIgnoreCase("local")) {
				EmailReports er = new EmailReports(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("emailconfigfile"));
				er.sendEmailWithReports();
			}
			if (whereToRun.equalsIgnoreCase("server")){
					System.out.println("MARSEngineUIHelper.getEmailConfig()" + MARSEngineUIHelper.getEmailConfig());
					EmailReports er = new EmailReports(MARSEngineUIHelper.getEmailConfig());
					er.sendEmailWithReports();
			}
		} else
			System.out.println("User choosed not to send email!!");
	}

	/**
	 * Gets the screen shot.
	 *
	 * @param driver
	 *            the driver
	 * @param fileName
	 *            the file name
	 * @param logger
	 *            the logger
	 * @return the screen shot
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void getScreenShot(WebDriver driver, String fileName, ExtentTest logger) throws IOException {
		ExtentReportManager.addScreenShotToReport(driver,
				ReadPropertyFile.getInstance(projectConfigFile).getProperty("reportfilepath"), fileName, logger);
	}

	
	/**
	 * Gets the UI/FUnctional/Mobile final report.
	 *
	 * @param driver
	 *            the driver
	 * @param logger
	 *            the logger
	 * @param methodName
	 *            the method name
	 * @param isPresent
	 *            the is present
	 * @return the final report
	 */
	public static boolean getFinalReport(WebDriver driver, ExtentTest logger, String methodName, boolean isPresent) {
		boolean isFinalReport = false;
		try {
			if (isPresent) {
				isFinalReport = true;
				String passMessage = "Verified and " + methodName + " Test Case Passed";
				logger.log(LogStatus.PASS, passMessage,
						ExtentReportManager.addServerScreenShotToReport(driver,
								ReadPropertyFile
										.getInstance(
												projectConfigFile)
										.getProperty("screenshotpath"),
								methodName, logger));
			} else {
				String failMessage = "Verified and " + methodName + " Test Case Failed";
				logger.log(LogStatus.FAIL, failMessage,
						ExtentReportManager.addServerScreenShotToReport(driver,
								ReadPropertyFile
										.getInstance(
												projectConfigFile)
										.getProperty("screenshotpath"),
								methodName, logger));
			}
		} catch (Exception e) {
			System.out.println("Error creating final report..." + e.getMessage());
			e.printStackTrace();
		}
		return isFinalReport;
	}
	
	/**
	 * Gets the Desktop final report.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 * @param methodName the method name
	 * @param isPresent the is present
	 * @return the final report
	 */
	public static boolean getFinalReport(MARSDesktopDriver driver, ExtentTest logger, String methodName, boolean isPresent) {
		boolean isFinalReport = false;
		try {
			if (isPresent) {
				isFinalReport = true;
				String passMessage = "Verified and " + methodName + " Test Case Passed";
				logger.log(LogStatus.PASS, passMessage,
						ExtentReportManager.addServerScreenShotToReport(driver,
								ReadPropertyFile
										.getInstance(
												projectConfigFile)
										.getProperty("screenshotpath"),
								methodName, logger));
			} else {
				String failMessage = "Verified and " + methodName + " Test Case Failed";
				logger.log(LogStatus.FAIL, failMessage,
						ExtentReportManager.addServerScreenShotToReport(driver,
								ReadPropertyFile
										.getInstance(
												projectConfigFile)
										.getProperty("screenshotpath"),
								methodName, logger));
			}
		} catch (Exception e) {
			System.out.println("Error creating final report..." + e.getMessage());
			e.printStackTrace();
		}
		return isFinalReport;
	}

	/**
	 * Gets the final report @Override method which return String.
	 *
	 * @param driver
	 *            the driver
	 * @param logger
	 *            the logger
	 * @param methodName
	 *            the method name
	 * @param isStringPresent
	 *            the is string present
	 * @return String - the final report
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String getFinalReport(WebDriver driver, ExtentTest logger, String methodName, String isStringPresent)
			throws IOException {
		String isFinalReport = null;
		if (isStringPresent != null) {
			isFinalReport = isStringPresent;
			logger.log(LogStatus.PASS, "verified");
		} else {
			logger.log(LogStatus.FAIL, "verified");
		}
		driver.quit();
		return isFinalReport;
	}

}