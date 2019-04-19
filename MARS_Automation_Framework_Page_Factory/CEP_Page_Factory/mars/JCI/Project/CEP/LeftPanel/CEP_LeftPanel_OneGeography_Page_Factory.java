package mars.JCI.Project.CEP.LeftPanel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;

public class CEP_LeftPanel_OneGeography_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";

	@SuppressWarnings("static-access")
	public CEP_LeftPanel_OneGeography_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
