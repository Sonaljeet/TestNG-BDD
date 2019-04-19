package mars.JCI.Project.CEP.HealthCheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_HealthCheck_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	public CEP_HealthCheck_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	//No data message
	@FindBy(xpath="//div[@class='NoDataStatusCheck']/h4[contains(text(),'five days')]")
	private WebElement noDataMessage;
	
	public WebElement getNoDataMessage() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, noDataMessage, logger) == true) {
			return noDataMessage;
		} else {
			return null;
		}
	}

}
