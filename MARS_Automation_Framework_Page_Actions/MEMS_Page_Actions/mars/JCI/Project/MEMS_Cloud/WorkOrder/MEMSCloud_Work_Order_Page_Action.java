package mars.JCI.Project.MEMS_Cloud.WorkOrder;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.JCI.Project.MEMSCloud.MeterConfiguration.MEMSCloud_MeterConfiguration_Page_Factory;
import mars.JCI.Project.MEMSCloud.WorkOrder.MEMSCloud_WorkOrder_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.MeterConfiguration.MEMSCloud_MeterConfiguration_Action;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_Work_Order_Page_Action {
	public String configFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	private static WebDriver driver;
	private static ExtentTest logger;
	public static MEMSCloud_WorkOrder_Page_Factory workOrderPageFactory = null;
	public static MEMSCloud_MeterConfiguration_Action loginPA;
	WebElement element = null;
	
	public MEMSCloud_Work_Order_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		workOrderPageFactory = new MEMSCloud_WorkOrder_Page_Factory(driver, logger);
		loginPA = new MEMSCloud_MeterConfiguration_Action(driver, logger);
	}
	
	public void addServiceState() {

		try {
			MEMSCloud_MeterConfiguration_Page_Factory MeterConfig = new MEMSCloud_MeterConfiguration_Page_Factory(driver, logger);
			String Userslistdata_JSONPath = "$..OfflineMeter.*";
			List<String> MeterConfiguration_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
			loginPA.correctLogin(MeterConfiguration_datalist.get(0).toString(), MeterConfiguration_datalist.get(1).toString());
			Thread.sleep(5000);
			//MEMSCloud_Orgnization_Action.MEMSCloud_MeterConfiguration_Action.waitForLoginUser();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL, new String("Error Message for is : " + e.getMessage()));
			
		}

	}

}
