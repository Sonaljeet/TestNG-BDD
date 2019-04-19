package mars.JCI.Project.CEP.Reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_eCloudReport_Page_Factory {
	
	private static WebDriver driver;
	private static ExtentTest logger;

	public CEP_eCloudReport_Page_Factory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='HONG KONG']")
	private WebElement branch;
	
	public WebElement getBranch() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, branch, logger) == true) {
			return branch;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//span[text()='TIMES SQUARE']")
	private WebElement customer;
	
	public WebElement getCustomer() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customer, logger) == true) {
			return customer;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//span[text()='08/01/2018 - 08/31/2018']")
	private WebElement coveringPeriod;
	
	public WebElement getCoveringPeriod() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, coveringPeriod, logger) == true) {
			return coveringPeriod;
		} else {
			return null;
		}
	}
}
