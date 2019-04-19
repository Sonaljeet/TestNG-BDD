/**
 * 
 */
package commonFunctions_Performance;

import java.io.IOException;
import java.util.List;

import org.apache.jmeter.testelement.TestElement;

import com.googlecode.jmeter.plugins.webdriver.config.ChromeDriverConfig;
import com.googlecode.jmeter.plugins.webdriver.config.gui.ChromeDriverConfigGui;
import com.googlecode.jmeter.plugins.webdriver.proxy.ProxyType;
import com.googlecode.jmeter.plugins.webdriver.sampler.WebDriverSampler;
import com.googlecode.jmeter.plugins.webdriver.sampler.gui.WebDriverSamplerGui;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author cdeyso
 *
 */
public class Performance_CHROMEDriverConfig {
	
	private static ExtentTest logger = null;
	private static ChromeDriverConfig exChromeDivConf = null;
	public static String chrome_path = "C:/MARS_FRAMEWORK/Drivers/chromedriver.exe";
	
	public Performance_CHROMEDriverConfig(ExtentTest logger) {
		
		this.logger = logger;
		exChromeDivConf = new ChromeDriverConfig();
	}
	
	@SuppressWarnings("static-access")
	public static ChromeDriverConfig setJMeterChromeDriverConfig(String SampleStepName) {
		
		
		 exChromeDivConf.setName(SampleStepName);
		 exChromeDivConf.setEnabled(true);
		 exChromeDivConf.setProxyType(ProxyType.SYSTEM);
		 exChromeDivConf.setBrowserMaximized(true);
		 exChromeDivConf.setRecreateBrowserOnIterationStart(true);
		 exChromeDivConf.setDevMode(false);
		 exChromeDivConf.setChromeDriverPath(chrome_path);
		 exChromeDivConf.setProperty(TestElement.TEST_CLASS, ChromeDriverConfig.class.getName());
		 exChromeDivConf.setProperty(TestElement.GUI_CLASS, ChromeDriverConfigGui.class.getName());
		 return exChromeDivConf;
		
	}

}
