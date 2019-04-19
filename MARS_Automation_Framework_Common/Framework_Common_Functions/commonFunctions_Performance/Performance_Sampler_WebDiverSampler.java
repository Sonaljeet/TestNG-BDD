/**
 * 
 */
package commonFunctions_Performance;

import java.io.IOException;
import java.util.List;

import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.TestElement;

import com.googlecode.jmeter.plugins.webdriver.sampler.WebDriverSampler;
import com.googlecode.jmeter.plugins.webdriver.sampler.gui.WebDriverSamplerGui;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions_Performance.Performance_HandleJSONScript;

/**
 * @author cdeyso
 *
 */
public class Performance_Sampler_WebDiverSampler {
	
	private static ExtentTest logger = null;
	public static WebDriverSampler ex_WDSampler = null;
	public static Performance_HandleJSONScript csdJSONHandler  = null;

	public Performance_Sampler_WebDiverSampler(ExtentTest logger) {
		
		this.logger = logger;
		csdJSONHandler = new Performance_HandleJSONScript(logger);
	}
	
	@SuppressWarnings("static-access")
	public static WebDriverSampler setJMeterWDS(int scriptNo) {
		
		
		 try {
			 
			 ex_WDSampler = new WebDriverSampler();
			 String script = csdJSONHandler.readScriptFromJSONFile(scriptNo);
			 List<String> sampleName = csdJSONHandler.getWDSName(scriptNo);
			 List<String> sampleLanguage = csdJSONHandler.getWDSLanguage(scriptNo);
			 System.out.println(sampleName.get(0)+" -- "+sampleLanguage.get(0));
			 //WebDriverSampler sample_WDS = new WebDriverSampler();
			 ex_WDSampler.setName(sampleName.get(0));
			 ex_WDSampler.setScriptLanguage(sampleLanguage.get(0));
			 ex_WDSampler.setEnabled(true);
			 ex_WDSampler.setScript(script);
			 ex_WDSampler.setProperty(TestElement.TEST_CLASS, WebDriverSampler.class.getName());
			 ex_WDSampler.setProperty(TestElement.GUI_CLASS, WebDriverSamplerGui.class.getName());
			 logger.log(LogStatus.INFO, "Performance WebDriver Sampler is Set for the Thread Group User.");
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return ex_WDSampler;
		
	}

}
