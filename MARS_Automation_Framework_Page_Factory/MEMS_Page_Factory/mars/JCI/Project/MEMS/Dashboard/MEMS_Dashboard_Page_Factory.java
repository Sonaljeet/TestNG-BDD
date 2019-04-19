package mars.JCI.Project.MEMS.Dashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class MEMS_Dashboard_Page_Factory {

	/** The WebDriver driver. */
	private static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	/**
	 * Instantiates a new MEMS dashboard page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEMS_Dashboard_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
		
	
	@FindBy(id = "username")
	private WebElement username;
	public WebElement getUsername(){
	commonFunctions.WebElementCommon.staticWait(5000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, username, logger)==true) {
		return username;
	}else
		return null;
	}

	@FindBy(id = "password")
	private WebElement password;
	public WebElement getPassword(){
	commonFunctions.WebElementCommon.staticWait(5000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, password, logger)==true) {
		return password;
	}else
		return null;
	}
		
	@FindBy(css = ".login-button")
	private WebElement Loginbtn;
	public WebElement getLoginbtn(){
	commonFunctions.WebElementCommon.staticWait(5000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, Loginbtn, logger)==true) {
		return Loginbtn;
	}else
		return null;
	}
	
	@FindBy(xpath = "//div[@class='item ng-scope active']//span[@class='showSettband facility-name ng-binding'][text()='Stark Tower']")
	public List<WebElement> Facilitynames;
	
	@FindBy(xpath = "//div[@class='item ng-scope active']//span[@class='today-weather']//p[@class='weather-value']//span[@title='Min']")
	private WebElement Facilityname_min_temparature;
	public WebElement get_Facilityname_min_temparature(){
	if (Facilitynames.size() >0) {
		return Facilityname_min_temparature;
	}else
		return null;
	}
	@FindBy(id = "Index")
	public List<WebElement> OverviewDashboard;
}