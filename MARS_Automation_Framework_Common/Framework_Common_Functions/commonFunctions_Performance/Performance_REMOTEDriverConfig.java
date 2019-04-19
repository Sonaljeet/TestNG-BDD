/**
 * 
 */
package commonFunctions_Performance;

import org.apache.jmeter.testelement.TestElement;

import com.googlecode.jmeter.plugins.webdriver.config.ChromeDriverConfig;
import com.googlecode.jmeter.plugins.webdriver.config.RemoteCapability;
import com.googlecode.jmeter.plugins.webdriver.config.RemoteDesiredCapabilitiesFactory;
import com.googlecode.jmeter.plugins.webdriver.config.RemoteDriverConfig;
import com.googlecode.jmeter.plugins.webdriver.config.gui.ChromeDriverConfigGui;
import com.googlecode.jmeter.plugins.webdriver.config.gui.RemoteDriverConfigGui;
import com.googlecode.jmeter.plugins.webdriver.proxy.ProxyType;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author cdeyso
 *
 */
public class Performance_REMOTEDriverConfig {

	private static ExtentTest logger = null;
	private static RemoteDriverConfig exRemoteDivConf = null;
	public static String chrome_path = "C:/MARS_FRAMEWORK/Drivers/chromedriver.exe";
	
	public Performance_REMOTEDriverConfig(ExtentTest logger) {
		
		this.logger = logger;
		exRemoteDivConf = new RemoteDriverConfig();
	}
	
	@SuppressWarnings("static-access")
	public static RemoteDriverConfig setJMeterRemoteDriverConfig(String SampleStepName) {
		
		exRemoteDivConf.setName(SampleStepName);
		exRemoteDivConf.setSeleniumGridUrl("http://127.0.0.1:4444/wd/hub");
		/*RemoteDesiredCapabilitiesFactory selectedCapability = new RemoteDesiredCapabilitiesFactory();
		selectedCapability.build(RemoteCapability.CHROME);*/
		exRemoteDivConf.setCapability(RemoteCapability.CHROME);
		exRemoteDivConf.setProperty(TestElement.TEST_CLASS, RemoteDriverConfig.class.getName());
		exRemoteDivConf.setProperty(TestElement.GUI_CLASS, RemoteDriverConfigGui.class.getName());
		
		return exRemoteDivConf;
		
	}
}
