package mars.Component.Functions;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serotonin.bacnet4j.LocalDevice;
import com.serotonin.bacnet4j.RemoteDevice;

import mars.Business.Layer.ReadPropertyFile;
import mars.Hardware.hardwareDeviceSetupFactory;

public class HWDeviceBaseClass {

	private StringBuffer verificationErrors = new StringBuffer();
	static String projectPropertiesFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/HW/Configuration/config.properties";
	public static ExtentReports reporter = null;
	/** The method name. */
	public static String methodName;

	/** The logger. */
	public static ExtentTest logger;
	
	public static hardwareDeviceSetupFactory deviceSetupFactory = null;
	public static String BROADCAST_NETWORK = null;//"255.255.255.0";
	public static int BROADCAST_PORT =0;// 0xbac0; // 47808
	public static int DEVICE_INSTANCE_ID =0;// 511248;
	public static String DEVICE_IP = null;//"10.117.17.247";
	public static RemoteDevice remoteDevice = null;
	public static LocalDevice localDevice = null;
	
	@BeforeSuite
	public static void beforeSuite() {

		reporter = null;
		logger = null;
		String reportFile = ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("reportfilepath");
		BROADCAST_NETWORK = ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("broadCastIP");
		BROADCAST_PORT= Integer.parseInt(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("port"));
		DEVICE_INSTANCE_ID = Integer.parseInt(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("instanceID"));
		DEVICE_IP= ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("deviceIP");
		
		System.out.println("reportFile =" + reportFile);
		reporter = ExtentReportManager.getReporter(reportFile.toUpperCase(), true);
	}

	@BeforeMethod
	public void beforeEachTestMethod(Method test) {

		try {
			deviceSetupFactory = new hardwareDeviceSetupFactory(BROADCAST_NETWORK, BROADCAST_PORT);
			remoteDevice = deviceSetupFactory.getDevice(DEVICE_IP, DEVICE_INSTANCE_ID);
			localDevice = deviceSetupFactory.getLocalDevice();
			
			methodName = test.getName();
			reporter.config().documentTitle("MARS Automation Report");
			reporter.config().reportHeadline(" Automation Execution Report");
			reporter.config().reportName("MARS");
			logger = reporter.startTest(test.getAnnotation(Test.class).description());
			System.out.println("Base before method started");

		} catch (Exception e) {
			// print exception if test method is not valid
			System.out.println("Test Method " + test + "is wrong in Before Method");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void afterEachTestMethod() {
		try {
			reporter.endTest(logger);
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
				Assert.fail(verificationErrorString);
			}
			deviceSetupFactory.closeLocalDevice();
		} catch (Exception e) {
			// print exception if test method is not valid
			System.out.println("Extent Test Logger is not identified in After Method");
		}

	}

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

	}

	/**
	 * This method replaces </br>
	 * {@literal<span class='right'>ExtentReports</span>}</br>
	 * in the Extent reports HTML file
	 */
	private static void replaceTextInReportFile() {
		try {
			List<String> fileContent = new ArrayList<>(Files.readAllLines(
					Paths.get(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("reportfilepath")),
					StandardCharsets.UTF_8));
			// System.out.println(fileContent.size());
			for (int i = 0; i < fileContent.size(); i++) {
				// System.out.println(i +" = " +fileContent.get(i));
				if (fileContent.get(i).equalsIgnoreCase("<span class='right'>ExtentReports</span>")) {
					fileContent.set(i, "");
					// System.out.println("done!!!");
					break;
				}
			}
			Files.write(Paths.get(ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("reportfilepath")),
					fileContent, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error occured replacing \"ExtentReports\" text HTML report" + e.getMessage());
		}
	}

	public static void getScreenShot(WebDriver driver, String fileName, ExtentTest logger) throws IOException {
		ExtentReportManager.addScreenShotToReport(driver,
				ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("reportfilepath"), fileName, logger);
	}

	/**
	 * Gets the final report.
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
								ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("screenshotpath"),
								methodName, logger));
			} else {
				String failMessage = "Verified and " + methodName + " Test Case Failed";
				logger.log(LogStatus.FAIL, failMessage,
						ExtentReportManager.addServerScreenShotToReport(driver,
								ReadPropertyFile.getInstance(projectPropertiesFile).getProperty("screenshotpath"),
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
