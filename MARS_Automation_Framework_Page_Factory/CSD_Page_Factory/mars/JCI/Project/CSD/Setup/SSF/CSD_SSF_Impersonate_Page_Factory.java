/**
 * 
 */
package mars.JCI.Project.CSD.Setup.SSF;

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

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_Impersonate_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SSF_Impersonate_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	//Method Overload, we are using fluent wait
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
				logger.log(LogStatus.INFO, "Element is not present!");
				return false;
			}catch (TimeoutException e) {
				// TODO Auto-generated catch block
				logger.log(LogStatus.INFO, "Element is not present!");
				return false;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				logger.log(LogStatus.INFO, "Element is not present!");
				return false;
			}
		}

	//Branch/User View Tab
	@FindBy(css="a[test-id='BranchUserView-tab']")
	private WebElement impersonate_BranchUserLink;
		
	public WebElement get_impersonate_BranchUserLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_BranchUserLink, logger)){
			return impersonate_BranchUserLink;
		}else
			return null;
	}
	
	
	//User search Textbox
	@FindBy(css="#wrap > div > div > div > div.row > div > div > div:nth-child(2) > div > span:nth-child(2) > input")
	private WebElement impersonate_searchUserLink;
		
	public WebElement get_impersonate_searchUserLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_searchUserLink, logger)){
			return impersonate_searchUserLink;
		}else
			return null;
	}
	
	//User Impersonate Icon Image
	@FindBy(css="#wrap > div > div > div > div.row > div > div > div:nth-child(2) > div > div > table > tbody > tr.ng-scope > td:nth-child(1) > span > img")
	private WebElement impersonate_ImpersonateUserLink;
		
	public WebElement get_impersonate_ImpersonateUserLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ImpersonateUserLink, logger)){
			return impersonate_ImpersonateUserLink;
		}else
			return null;
	}
	
	//Verify Impersonate HomePage is loaded
	@FindBy(css="span[test-id='lnkStopImpersonate']")
	private WebElement impersonate_ImpersonateHomePageLink;
		
	public WebElement get_impersonate_ImpersonateHomePageLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, impersonate_ImpersonateHomePageLink, logger)){
			return impersonate_ImpersonateHomePageLink;
		}else
			return null;
	}
	
	
}
