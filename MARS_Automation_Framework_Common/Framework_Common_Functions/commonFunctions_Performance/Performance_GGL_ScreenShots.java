/**
 * 
 */
package commonFunctions_Performance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.ExtentReportManager;

/**
 * @author cdeyso
 *
 */
public class Performance_GGL_ScreenShots {
	
	private static ExtentTest logger = null;
	public static List<String> gglGraphsList = new ArrayList<String>();
	public static String gglGraphsLoacation = "//10.117.16.71/Project/MEMS/Performance/GraphsGeneratorListenerResult"; //"C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/TestResources/PerformanceTest/GraphsGeneratorListenerResult";
	
	@SuppressWarnings("static-access")
	public Performance_GGL_ScreenShots(ExtentTest logger) {
		this.logger = logger;
	}
	
	public static List<String> getAllGraphsNames(){
		
		if(gglGraphsList.size() > 0){gglGraphsList.clear();}
		
		File folder = new File(gglGraphsLoacation);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        gglGraphsList.add(listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }
		    return gglGraphsList;
	}
	
	/*private static String captureScreenShot(String screenshotPath, String ScreenshotName)
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

	}*/
	
	public static String addGGLGraphsToReport(ExtentTest logger_1,String fileName) {
		String screenImage = null;
		try {
			for(int i = 1; i < gglGraphsList.size(); i++){
				
				String temp_name = gglGraphsList.get(i);
				if (temp_name.contains(fileName)) {
					String screenshotAbsolutePath = gglGraphsLoacation + "/" + temp_name;
					screenImage = logger_1.addScreenCapture(screenshotAbsolutePath);
					System.out.println("report is added " + screenshotAbsolutePath);
					logger.log(LogStatus.INFO, temp_name + " -- " + screenImage);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error adding screenshot to report...\n" + e.getMessage());
		}

		return screenImage;
	}

}
