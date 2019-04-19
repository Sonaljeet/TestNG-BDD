package mars.JCI.Project.CEP.Performance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Performance_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	public CEP_Performance_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	//Get first customer name
	public WebElement getFirstCust(String customer) throws Exception {
		WebElement element = driver.findElement(By.xpath("//span[@title='"+customer+"']"));
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(60, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	@FindBy(xpath = "//img[@class='pull-right']")
	private WebElement rightArrow;
	
	public WebElement getArrow() throws Exception{
		if (rightArrow!=null) {
			return rightArrow;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='col-md-12']/img")
	private WebElement statusChkRightArrow;
	
	public WebElement getStatusChkArrow() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, statusChkRightArrow, logger) == true) {
			return statusChkRightArrow;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='pull-right']/a/i[@class='fa fa-plus fa_PlusIcon']")
	private WebElement addIconTrendsChillerSnapshot;
	
	public WebElement getAddIcon() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, addIconTrendsChillerSnapshot, logger) == true) {
			return addIconTrendsChillerSnapshot;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//input[@automation-id='btnPreview']")
	private WebElement trendsPDFPrvwBtn;
	
	public WebElement getTrendsPrvwBtn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, trendsPDFPrvwBtn, logger) == true) {
			return trendsPDFPrvwBtn;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//input[@automation-id='btnPrint']")
	private WebElement trendsPDFSaveBtn;
	
	public WebElement getTrendsSaveBtn() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, trendsPDFSaveBtn, logger) == true) {
			return trendsPDFSaveBtn;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement trendsSuccessfulPDFMsg;
	
	public WebElement getTrendsSuccessfulPDFMsg() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, trendsSuccessfulPDFMsg, logger) == true) {
			return trendsSuccessfulPDFMsg;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@aria-label='Chart exported to PDF successfully']")
	private WebElement chillerSnapshotSuccessfulPDFMsg;
	
	public WebElement getSuccessfulPDFMsg() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerSnapshotSuccessfulPDFMsg, logger) == true) {
			return chillerSnapshotSuccessfulPDFMsg;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='content_box']/div/ul/li[2]/a")
	private WebElement comparativeMaximize;
	
	public WebElement getCompMaximize() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, comparativeMaximize, logger) == true) {
			return comparativeMaximize;
		} else {
			return null;
		}
	}

}
