/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.testelement.TestElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author cdeyso
 *
 */
public class Performance_Sampler_HTTPSampler {
	
	private static ExtentTest logger = null;
	public static HTTPSamplerProxy ex_HTTPSampler = null;

	public Performance_Sampler_HTTPSampler(ExtentTest logger) {
		
		this.logger = logger;
	}

	
	public static HTTPSamplerProxy setJMeterHTTPSampler(String domain_url) {
		
		try {
			ex_HTTPSampler = new HTTPSamplerProxy();
			ex_HTTPSampler.setDomain(domain_url);
			ex_HTTPSampler.setPort(80);
			ex_HTTPSampler.setPath("/");
			ex_HTTPSampler.setMethod("GET");
			ex_HTTPSampler.setName("Open Test Domain");
			ex_HTTPSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
			ex_HTTPSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
			
			logger.log(LogStatus.PASS, "HTTP Sampler for the Performance Session is Set !");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Error Encountered while loading HTTP Sampler!");
		}
		
		
		return ex_HTTPSampler;
	}
}
