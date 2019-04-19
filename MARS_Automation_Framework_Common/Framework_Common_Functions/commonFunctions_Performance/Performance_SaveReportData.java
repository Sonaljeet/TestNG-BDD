//<<<<<<< HEAD:MARS_Automation_Framework_Common/Framework_Common_Functions/commonFunctions_Performance/Performance_SaveReportData.java
/**
 * 
 */
package commonFunctions_Performance;



import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_SaveReportData {
	
	private static ExtentTest logger = null;
	public static  Summariser summer = null;
	public static String projdir = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/TestResources/PerformanceTest";
	

	public Performance_SaveReportData(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static Summariser setSummarizerForResults() {
		
		
		try {
			summer = null;
			String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
			if (summariserName.length() > 0) {
			    summer = new Summariser(summariserName);
			}
			logger.log(LogStatus.PASS, "Summarizer is initialized for the Session!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Error encountered while loading Summarizer.");
			
		}
        
        return summer;
	}
	
	public static void saveResponseResultsForJMeter(HashTree testPlanTree) {
		
		try {
			//Summariser res_summer = setSummarizerForResults();
			
			// Store execution results into a .jtl file, we can save file as csv also
			String reportFile = projdir+"\\reports\\report.jtl";
			String csvFile = projdir+"\\reports\\report.csv";
			//String htmlFile = projdir+"\\HTMLReport\\report.html";
			ResultCollector rc_logger = new ResultCollector(summer);
			rc_logger.setFilename(reportFile);
			ResultCollector csvlogger = new ResultCollector(summer);
			csvlogger.setFilename(csvFile);
			testPlanTree.add(testPlanTree.getArray()[0], rc_logger);
			testPlanTree.add(testPlanTree.getArray()[0], csvlogger);
			
			logger.log(LogStatus.PASS, "JTL and CSV Files are Saved in the Desired Location!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Error Encountered while saving the results into JTL and CSV Files");
		}
		
		
	}

}
