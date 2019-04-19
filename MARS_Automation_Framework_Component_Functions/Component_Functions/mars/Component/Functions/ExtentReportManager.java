/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.Component.Functions;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.text.html.HTML;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import mars.Desktop.Component.Functions.MARSDesktopDriver;

public class ExtentReportManager {

	/** The ExtentReports reporter. */
	private static ExtentReports reporter;

	private ExtentReportManager() {

	}

	/**
	 * Gets a new Instance of reporter if there is no current instance, else
	 * creates a new instance
	 *
	 * @param reportPath
	 *            the report path. By default the report name is
	 *            ExtentReport.html. It is saved in project's root directory
	 * @param replaceExistingReport
	 *            the replace existing report. By default value is false
	 * @return {@link ExtentReports} instance
	 */
	public synchronized static ExtentReports getReporter(String reportPath, boolean replaceExistingReport) {

		if (reporter == null) {
			reporter = new ExtentReports(reportPath, replaceExistingReport);
			return reporter;
		} else {
			return reporter;
		}
	}

	/**
	 * Adds the screen shot to report. This method can be used only with
	 * WebDriver tests. This is not usable for Desktop applications
	 *
	 * @param driver
	 *            {@link WebDriver}
	 * @param screenshotPath
	 *            {@link String} the directory where the screenshot will be
	 *            stored
	 * @param ScreenshotName
	 *            {@link String} screenshot name
	 * @return {@link String} path where the screenshot is saved
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String captureScreenShot(WebDriver driver, String screenshotPath, String ScreenshotName)
			throws IOException {

		String destinationPath = null;
		try {
			destinationPath = screenshotPath + ScreenshotName + ".png";

			// Cast webdriver to Screenshot
			TakesScreenshot screenshot = (TakesScreenshot) driver;

			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(sourceFile, new File(destinationPath));

			System.out.println("Destin file " + destinationPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error capturing screenshot...\n" + e.getMessage());
		}
		return destinationPath;

	}
	
	/**
	 * Capture Desktop screen shot.
	 *
	 * @param driver the driver
	 * @param screenshotPath the screenshot path
	 * @param ScreenshotName the screenshot name
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static String captureScreenShot(MARSDesktopDriver driver, String screenshotPath, String ScreenshotName)
			throws IOException {

		String destinationPath = null;
		try {
			Thread.sleep(5000);
			destinationPath = screenshotPath + ScreenshotName + ".png";			
			Robot robot = new Robot();
	        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	        ImageIO.write(screenShot, "PNG", new File(destinationPath));
	        Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error capturing screenshot...\n" + e.getMessage());
		}
		return destinationPath;

	}

	/**
	 * Adds the screen shot to report. This method can be used only with
	 * WebDriver tests. This is not usable for Desktop applications
	 *
	 * @param driver
	 *            {@link WebDriver}
	 * @param screenshotPath
	 *            the screenshot path
	 * @param ScreenshotName
	 *            the screenshot name
	 * @param logger
	 *            {@link ExtentTest}
	 * @return {@link HTML} tag with the screenshot path embedded
	 */
	public static String addScreenShotToReport(WebDriver driver, 
												String screenshotPath, 
												String ScreenshotName,
												ExtentTest logger){
		String screenImage = null;
		try {
			String screenshoAbsolutePath = ExtentReportManager.captureScreenShot(driver, screenshotPath,
																				ScreenshotName);
			screenImage = logger.addScreenCapture(screenshoAbsolutePath);
		} catch (Exception e) {
			System.out.println("Error adding screenshot to report...\n" + e.getMessage());
		}
		return screenImage;
	}

	/**
	 * <pre>
	 * Adds the screen shot to report. This method should be used when 
	 * screenshot is saved on Server machine. This method can be used
	 * only with WebDriver tests. This is not usable for Desktop applications
	 * </pre>
	 *
	 * @param driver
	 *            {@link WebDriver}
	 * @param screenshotPath
	 *            the screenshot path
	 * @param ScreenshotName
	 *            the screenshot name
	 * @param logger
	 *            {@link ExtentTest}
	 * @return {@link HTML} tag with the screenshot path embedded
	 */
	public static String addServerScreenShotToReport(WebDriver driver, String screenshotPath, String ScreenshotName,
			ExtentTest logger) {
		String screenImage = null;
		try {
			String screenshoAbsolutePath = ExtentReportManager.captureScreenShot(driver, screenshotPath,
					ScreenshotName);
			// Add http tag to file path
			screenshoAbsolutePath = screenshoAbsolutePath.replace("//", "http://");
			screenImage = logger.addScreenCapture(screenshoAbsolutePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error adding screenshot to report...\n" + e.getMessage());
		}

		return screenImage;
	}
	
	/**
	 * Adds the Desktop server screen shot to report.
	 *
	 * @param driver the driver
	 * @param screenshotPath the screenshot path
	 * @param ScreenshotName the screenshot name
	 * @param logger the logger
	 * @return the string
	 */
	public static String addServerScreenShotToReport(MARSDesktopDriver driver, String screenshotPath, String ScreenshotName,
			ExtentTest logger) {
		String screenImage = null;
		try {
			String screenshoAbsolutePath = ExtentReportManager.captureScreenShot(driver, screenshotPath,
					ScreenshotName);
			// Add http tag to file path
			screenshoAbsolutePath = screenshoAbsolutePath.replace("//", "http://");
			screenImage = logger.addScreenCapture(screenshoAbsolutePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error adding screenshot to report...\n" + e.getMessage());
		}

		return screenImage;
	}
}
