package mars.JCI.Project.CEP.Smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.JCI.Project.CEP.Login.CEP_Login_Page_Action;
import mars.JCI.Project.CEP.SmokeTest.CEP_Scorecard_Smoke_Page_Action;
import mars.JCI.Project.CEP.StatusCheck.CEP_StatusCheck_Page_Action;

public class CEP_Scorecard_Smoke_Page_Factory {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public CEP_Scorecard_Smoke_Page_Factory(WebDriver driver,ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="SCORECARD")
	private WebElement link;
	
	public WebElement getLink() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, link, logger) == true) {
			return link;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//select[@name='ddlType']")
	private WebElement type;
	
	public WebElement getType() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, type, logger) == true) {
			return type;
		} else {
			return null;
		}
	}
	
	@FindBy(css="g[class*='highcharts-legend-item']>text>tspan")
	private WebElement overview;
	
	public WebElement getOverview() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, overview, logger) == true) {
			return overview;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//span[@id='gridspan']")
	private WebElement iconExport;
	
	public WebElement getIconExport() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, iconExport, logger) == true) {
			return iconExport;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//select[@name='ddlBranch']")
	private WebElement branchDropDown;
	
	public WebElement getBranchDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, branchDropDown, logger) == true) {
			return branchDropDown;
		} else {
			return null;
		}
	}
	
	
	@FindBy(xpath="//i[@class='fa fa-download fa_download']")
	private WebElement downloadIcon;
	
	public WebElement getDownloadIcon() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, downloadIcon, logger) == true) {
			return downloadIcon;
		} else {
			return null;
		}
	}
}
