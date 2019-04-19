package mars.JCI.Project.MEMSCloud.OrganizationLicence;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class MEMSCloud_OrganizationLicence {
	
	private static WebDriver driver;
	private ExtentTest logger;

	public MEMSCloud_OrganizationLicence(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "License")
	private WebElement license;
	public WebElement getLicence() throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(license,driver,logger)==true) {
		return license;
	}else
		return null;
	}
	
	@FindBy(name = "orgDpd")
	private WebElement orgDpd;
	public WebElement getorgDpd()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(orgDpd,driver, logger)==true) {
		return orgDpd;
	}else
		return null;
	}

	@FindBy(xpath="//select[contains(@ng-model, 'lc.selectedLicense')]")
	private WebElement licenseType;
	public WebElement getlicenseType()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(licenseType,driver, logger)==true) {
		return licenseType;
	}else
		return null;
	}

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveLic;
	public WebElement getsaveLic()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(saveLic,driver, logger)==true) {
		return saveLic;
	}else
		return null;
	}

	@FindBy(name = "durationDPd")
	private WebElement duration;
	public WebElement getDuration()throws Exception{
	commonFunctions.WebElementCommon.staticWait(2000);
	if (commonFunctions.WebElementCommon.waitForElementPresent(duration,driver,logger)==true) {
		return duration;
	}else
		return null;
	}
		@FindBy(xpath = "//select[contains(@ng-model, 'lc.selectedChannel')]")
			private WebElement channel;
			public WebElement getChannel()throws Exception{
			commonFunctions.WebElementCommon.staticWait(2000);
			if (commonFunctions.WebElementCommon.waitForElementPresent(channel,driver, logger)==true) {
				return channel;
			}else
				return null;
			} 
			
			@FindBy(xpath = "//input[@type='search']")
			private WebElement search;
			public WebElement getSearch()throws Exception{
			commonFunctions.WebElementCommon.staticWait(2000);
			if (commonFunctions.WebElementCommon.waitForElementPresent(search,driver, logger)==true) {
				return search;
			}else
				return null;
			} 

}
