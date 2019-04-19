/**
 * 
 */
package commonFunctions_Performance;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author cdeyso
 *
 */
public class Performance_clearReportsDirectory {
	
	private static ExtentTest logger = null;
	public static String projdir = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/TestResources/PerformanceTest";
	
	@SuppressWarnings("static-access")
	public Performance_clearReportsDirectory(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static void clearReportsDirectory() 
			throws IOException {
		
		FileUtils.cleanDirectory(new File(projdir+"\\reports\\"));
	}

}
