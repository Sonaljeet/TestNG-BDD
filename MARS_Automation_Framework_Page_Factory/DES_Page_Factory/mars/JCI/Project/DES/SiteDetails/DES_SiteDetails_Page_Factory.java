package mars.JCI.Project.DES.SiteDetails;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;

public class DES_SiteDetails_Page_Factory {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	WebElement element = null;
	
	public DES_SiteDetails_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(15, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " +e.getMessage().substring(0, 150));
			return false;
		}
	}

	@FindBy(css="a[automation-id='linkDetails']")
	private WebElement detailsTab;
	
	public WebElement getDetailsTab(){
		if(WebElementCommon.waitForElementPresent(driver, detailsTab, logger)==true){
			element=detailsTab;
		}
		return element;
	}
	
	/**  searchBox  Element. */
	@FindBy(xpath = "//*[@id='unitspopupbody']//button[1]")
	private WebElement btnApply;

	public WebElement getbtnApply() {
		
		if (WebElementCommon.waitForElementPresent(driver, btnApply, logger) == true) {
			element = btnApply;
		}
		return element;
	}
	
	/**  searchBox  Element. */
	@FindBy(xpath = "//*[@id='unitspopupbody']//button[2]")
	private WebElement btnCancel;

	public WebElement getbtnCancel() {
		
		if (WebElementCommon.waitForElementPresent(driver, btnCancel, logger) == true) {
			element = btnCancel;
		}
		return element;
	}
	
	/**  searchBox  Element. */
	@FindBy(xpath = "//button[text()='Configure Widget']")
	private WebElement btnConfigWidget;

	public WebElement getConfigWidgetbtn() {
		
		if (WebElementCommon.waitForElementPresent(driver, btnConfigWidget, logger) == true) {
			element = btnConfigWidget;
		}
		return element;
	}
	
	
	
	@FindBy(css="input[placeholder='Search points..']")
	private WebElement serachTextBox;
	
	public WebElement getsearchTextBox(){
		if(WebElementCommon.waitForElementPresent(driver, serachTextBox, logger)==true)
		{
			element=serachTextBox;
		}
		return serachTextBox;
	}
	
	@FindBy(xpath="//h3[@class='ng-binding']")
	private WebElement systemsHeader;
	
	@FindBy(xpath="//*[@id='METER_MAIN']//table//tr")
	public List<WebElement> MeterPointList;
	
	@FindBy(xpath="//*[@id='BANKCONTROLLER']//table//tr")
	public List<WebElement> BankControllerPointList;
	
	@FindBy(xpath="//*[@id='SPS']//table//tr")
	public List<WebElement> SPSPointList;
	
	@FindBy(xpath="//*[@id='ENCLOSURE']//table//tr")
	public List<WebElement> EnclosurePointList;
	
	@FindBy(xpath="//*[@id='Battery_Inverter']//table//tr")
	public List<WebElement> Battery_InverterPointList;
	
	@FindBy(xpath="//*[@id='Peak_Shaving_Application___Stationary_Energy_Storage']//table//tr")
	public List<WebElement> Peak_Shaving_Application___Stationary_Energy_StoragePointList;
	
	@FindBy(xpath="//*[@id='INVERTER']//table//tr")
	public List<WebElement> INVERTERPointList;
	
	@FindBy(xpath="//div[@id='METER_MAIN']//span/i[@id='expandicon']")
	private WebElement metersExpandIcon;
	
	public WebElement getmetersExpandIcon(){
		if(WebElementCommon.waitForElementPresent(driver, metersExpandIcon, logger)==true){
			element=metersExpandIcon;
		}
		return element;
	}
	
	@FindBy(xpath="//div[@id='BANKCONTROLLER']//span/i[@id='expandicon']")
	private WebElement batteriesExpandIcon;
	
	public WebElement getbatteriesExpandIcon(){
		if(WebElementCommon.waitForElementPresent(driver, batteriesExpandIcon, logger)==true){
			element=batteriesExpandIcon;
		}
		return element;
	}
	
	@FindBy(xpath="//div[@id='SPS']//span/i[@id='expandicon']")
	private WebElement SPSExpandIcon;
	
	public WebElement getSPSExpandIcon(){
		if(WebElementCommon.waitForElementPresent(driver, SPSExpandIcon, logger)==true){
			element=SPSExpandIcon;
		}
		return element;
	}
	
	@FindBy(xpath="//div[@id='Enclosure']//span/i[@id='expandicon']")
	private WebElement EnclosureExpandIcon;
	
	public WebElement getEnclosureExpandIcon(){
		if(WebElementCommon.waitForElementPresent(driver, EnclosureExpandIcon, logger)==true){
			element=EnclosureExpandIcon;
		}
		return element;
	}
	
	@FindBy(xpath="//div[@id='Battery_Inverter']//span/i[@id='expandicon']")
	private WebElement Battery_InverterExpandIcon;
	
	public WebElement getBattery_InverterExpandIcon(){
		if(WebElementCommon.waitForElementPresent(driver, Battery_InverterExpandIcon, logger)==true){
			element=Battery_InverterExpandIcon;
		}
		return element;
	}
	
	
	
	@FindBy(xpath="//span[@class='padding-10-0 ng-binding']")
	private WebElement subSystemHeader;
	
	@FindBy(xpath="(//span[@title='Utility Main Meter'])[1]")
	private WebElement UtilityMainMeter;
	
	public WebElement getUtilityMainMeter(){
		if(WebElementCommon.waitForElementPresent(driver, UtilityMainMeter, logger)==true){
			element=UtilityMainMeter;
		}
		return element;
	}
		
	@FindBy(xpath="(//span[@title='Battery System Meter'])[1]")
	private WebElement BatterySystemMeter;
	
	public WebElement getBatterySystemMeter(){
		if(WebElementCommon.waitForElementPresent(driver, BatterySystemMeter, logger)==true){
			element=BatterySystemMeter;
		}
		return element;
	}
		
	@FindBy(xpath="(//span[@title='Customer Load Meter'])[1]")
	private WebElement CustomerLoadMeter;
	
	public WebElement getCustomerLoadMeter(){
		if(WebElementCommon.waitForElementPresent(driver, CustomerLoadMeter, logger)==true){
			element=CustomerLoadMeter;
		}
		return element;
	}
	
	
	@FindBy(xpath="(//span[@title='Battery String 1 - Bank 1'])[1]")
	private WebElement BatteryStringOneBank;
	
	public WebElement getBatteryStringOneBank(){
		if(WebElementCommon.waitForElementPresent(driver, BatteryStringOneBank, logger)==true){
			element=BatteryStringOneBank;
		}
		return element;
	}
	
	@FindBy(xpath="(//span[@title='Battery String 2 - Bank 1'])[1]")
	private WebElement BatteryStringTwoBank;
	
	public WebElement getBatteryStringTwoBank(){
		if(WebElementCommon.waitForElementPresent(driver, BatteryStringTwoBank, logger)==true){
			element=BatteryStringTwoBank;
		}
		return element;
	}
	
	@FindBy(xpath="//tr[@class='noDataContainer faults-noDataContainer']//td")
	private WebElement noPointMapped;
	
	public WebElement getnoPointMapped(){
		if(WebElementCommon.waitForElementPresent(driver, noPointMapped, logger)==true){
			element=noPointMapped;
		}
		return element;
	}
	
	@FindBy(xpath="//div[@class='conten_header']")
	public List<WebElement> SystemHeaders;
	
}
