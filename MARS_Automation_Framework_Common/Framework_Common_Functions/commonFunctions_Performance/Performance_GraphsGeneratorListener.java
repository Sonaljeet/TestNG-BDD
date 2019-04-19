/**
 * 
 */
package commonFunctions_Performance;


import org.apache.jmeter.testbeans.gui.TestBeanGUI;
import org.apache.jmeter.testelement.TestElement;

import com.relevantcodes.extentreports.ExtentTest;

import kg.apc.jmeter.listener.GraphsGeneratorListener;

/**
 * @author cdeyso
 *
 */
public class Performance_GraphsGeneratorListener {
	
	private static ExtentTest logger = null;
	public static  GraphsGeneratorListener graphsGenListener = null;
	public static String projdir = "//10.117.16.71/Project/MEMS/Performance/"; //"C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/TestResources/PerformanceTest";
	public static String projdir_local = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/TestResources/PerformanceTest";
	
	public Performance_GraphsGeneratorListener(ExtentTest logger) {
		
		this.logger = logger;
		graphsGenListener = new GraphsGeneratorListener();
	}
	
	public static GraphsGeneratorListener setGGLProperties(String gglStepName, String filePrefix) {
		
		
		try {
			//the jp@gc - Graphs Generator Listener
			
			graphsGenListener.setName("jp@gc - Graphs Generator Listener");
			graphsGenListener.setEnabled(true);
			//SampleSaveConfiguration sample_gglistener_conf = new SampleSaveConfiguration();
			
			
			graphsGenListener.setProperty("outputBaseFolder", projdir+"\\GraphsGeneratorListenerResult\\");
			graphsGenListener.setProperty("resultsFileName", projdir_local+"\\reports\\report.jtl");//report.jtl
			graphsGenListener.setProperty("exportMode", 0);
			graphsGenListener.setProperty("filePrefix", filePrefix+"- ");
			graphsGenListener.setProperty("graphWidth", 800);
			graphsGenListener.setProperty("graphHeight", 600);
			graphsGenListener.setProperty("paintMarkers", "Undefined");
			graphsGenListener.setProperty("paintZeroing", true);
			graphsGenListener.setProperty("paintGradient", true);
			graphsGenListener.setProperty("preventOutliers", false);
			graphsGenListener.setProperty("relativeTimes", false);
			graphsGenListener.setProperty("autoScaleRows", false);
			graphsGenListener.setProperty("limitRows", "150");
			graphsGenListener.setProperty("granulation", 1000);
			graphsGenListener.setProperty("aggregateRows", false);
			graphsGenListener.setProperty("includeSamplesWithRegex", false);
			graphsGenListener.setProperty("excludeSamplesWithRegex", false);
			
			graphsGenListener.setProperty(TestElement.TEST_CLASS, GraphsGeneratorListener.class.getName());
			graphsGenListener.setProperty(TestElement.GUI_CLASS, TestBeanGUI.class.getName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return graphsGenListener;
	}

}
