
package commonFunctions_Performance;

import java.io.File;
import java.util.List;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.util.JMeterUtils;
import mars.Business.Layer.ReadPropertyFile;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_Testlnitializer {
	
	private static ExtentTest logger = null;
	public static String jmeterPropFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/Configuration/preformanceConfig.properties";
	public static File jmeterHome =  null;
	public static String slash = System.getProperty("file.separator");
	public static StandardJMeterEngine jmeter = null;
	
	@SuppressWarnings("static-access")
	public Performance_Testlnitializer(ExtentTest logger) {
		
		this.logger = logger;
	}
	
	public static StandardJMeterEngine getJMeterEngine() {
		
		//String file_location = ReadPropertyFile.getInstance(jmeterPropFile).getProperty("jmeterHome");
		jmeterHome = new File("C:\\Users\\cdeyso\\Desktop\\RnD\\JMeter\\apache-jmeter-3.1");
		if (jmeterHome.exists()) {
			
			logger.log(LogStatus.PASS, "System is JMeter Compatible!");
            File jmeterProperties = new File(jmeterHome.getPath() + slash + "bin" + slash + "jmeter.properties");
            if (jmeterProperties.exists()) {
            	System.out.println("IF -- getJMeterEngine");
                //JMeter Engine
                jmeter = new StandardJMeterEngine();

                //JMeter initialization (properties, log levels, locale, etc)
                JMeterUtils.setJMeterHome(jmeterHome.getPath());
                JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
                //JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
                JMeterUtils.initLocale();
                
                logger.log(LogStatus.PASS, "JMeter Engine is Initiated !");
            }else{
                logger.log(LogStatus.FAIL, "ERROR Initiating JMeter Engine!");
            }
		}else{
			logger.log(LogStatus.FATAL, "Please Check the Location of JMeter in your System!");
		}
		return jmeter;
	}
	

}
