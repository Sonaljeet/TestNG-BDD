package mars.JCI.Project.CEP.CustomerListByStatus;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import mars.Component.Functions.BaseClass;

public class CEP_CustomerListByStatus_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;
	public static String configFile = BaseClass.TruncatePath
			+ "/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CEP/Configuration/config.properties";

	public CEP_CustomerListByStatus_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Right Section headers
	@FindBy(xpath="//div[contains(@class,'col-md-8 margin-bottom-15')]/div/div/h3")
	private List<WebElement> rightHeaders;
	
	public List<WebElement> getRightHeaders() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, rightHeaders, logger) == true) {
			return rightHeaders;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='col-sm-3 col-md-3 project-content-height']/div/div/div/div/div/span")
	private WebElement firstChiller;
	
	public WebElement getFirstChiller() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, firstChiller, logger) == true) {
			return firstChiller;
		} else {
			return null;
		}
	}
	//Getting Headers in CustomerListByStatus Section
	@FindBy(xpath="//div[contains(@class,'col-md-5 customer-content-height')]/div/div/p/b")
	private WebElement customerNameHeader;
	
	public WebElement getCustomerNameHeader() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerNameHeader, logger) == true) {
			return customerNameHeader;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[contains(@class,'col-md-4 project-content-height')]/div/div/p/b")
	private WebElement siteNameHeader;
	
	public WebElement getSiteNameHeader() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteNameHeader, logger) == true) {
			return siteNameHeader;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[contains(@class,'col-md-3 project-content-height')]/div/div/p/b")
	private WebElement assetNameHeader;
	
	public WebElement getAssetNameHeader() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, assetNameHeader, logger) == true) {
			return assetNameHeader;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[@class='pull-right']/mark")
	private List<WebElement> countHeaderList;
	
	public List<WebElement> getCountHeaderList() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, countHeaderList, logger) == true) {
			return countHeaderList;
		} else {
			return null;
		}
	}
}