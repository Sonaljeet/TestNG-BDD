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
public class CSD_SSF_L1UserActions_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SSF_L1UserActions_Page_Factory(WebDriver driver, ExtentTest logger) {
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
	
	//The Site Setup Tab
	@FindBy(css="a[test-id='SiteSetup-tab']")
	private WebElement l1user_SiteSetupLink;
		
	public WebElement get_l1user_SiteSetupLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_SiteSetupLink, logger)){
			return l1user_SiteSetupLink;
		}else
			return null;
	}
	
	//The SSF Tab
	@FindBy(css="a[test-id='SSF-tab']")
	private WebElement l1user_SSFLink;
		
	public WebElement get_l1user_SSFLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_SSFLink, logger)){
			return l1user_SSFLink;
		}else
			return null;
	}
	
	//The Search Branch TextBox
	@FindBy(css="input[name='BranchName']")
	private WebElement l1user_searchBranchLink;
		
	public WebElement get_l1user_searchBranchLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_searchBranchLink, logger)){
			return l1user_searchBranchLink;
		}else
			return null;
	}
	
	//The SSF Grid Body
	@FindBy(css="#scrollDiv > table > tbody")
	private WebElement l1user_ssfGridBodyLink;
		
	public WebElement get_l1user_ssfGridBodyLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_ssfGridBodyLink, logger)){
			return l1user_ssfGridBodyLink;
		}else
			return null;
	}
	
	
	//Impersonate L1 User Edit SSF Form PAge -- Notes 
	@FindBy(css="#scrollDiv > table > tbody")
	private WebElement l1user_editSSFBottomNotes;
		
	public WebElement get_l1user_editSSFBottomNotes(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_editSSFBottomNotes, logger)){
			return l1user_editSSFBottomNotes;
		}else
			return null;
	}
	
	//Impersonate L1 user -- Update L1 user comments 
	@FindBy(css="textarea[automation-id='txtL1Comment']")
	private WebElement l1user_editL1UserNotes;
		
	public WebElement get_l1user_editL1UserNotes(){
		if(waitForElementPresent(driver, l1user_editL1UserNotes, logger)){
			return l1user_editL1UserNotes;
		}else
			return null;
	}
	
	//Impersonate Page -- Generic Pop UP Handle 
	@FindBy(css="input[id='popup_ok']")
	private WebElement l1user_PopUpOKLink;
		
	public WebElement get_l1user_PopUpOKLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_PopUpOKLink, logger)){
			return l1user_PopUpOKLink;
		}else
			return null;
	}
	
	//Form Status Text Read Element -- SSF Form Update Page
	@FindBy(css="#wrap > div > div > div.row.ng-scope > div > div > div > div:nth-child(2) > span:nth-child(2) > label > b > span")
	private WebElement l1user_SSFFormStatusLink;
		
	public WebElement get_l1user_SSFFormStatusLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_SSFFormStatusLink, logger)){
			return l1user_SSFFormStatusLink;
		}else
			return null;
	}
	
	//Form ID Text Read Element -- SSF Form Update Page
	@FindBy(css="#wrap > div > div > div.row.ng-scope > div > div > div > div:nth-child(1) > span:nth-child(2) > label > b > span")
	private WebElement l1user_SSFFormIDLink;
		
	public WebElement get_l1user_SSFFormIDLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_SSFFormIDLink, logger)){
			return l1user_SSFFormIDLink;
		}else
			return null;
	}
	
	//Approve Button -- Impersonate L1 User Page
	@FindBy(css="input[automation-id='btnSSFApproved']")
	private WebElement l1user_L1ApproveLink;
		
	public WebElement get_l1user_L1ApproveLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_L1ApproveLink, logger)){
			return l1user_L1ApproveLink;
		}else
			return null;
	}
	
	//Save Button -- Impersonate L1 User Page -- After Approval/Completion
	@FindBy(css="input[automation-id='btnSSFMapUser']")
	private WebElement l1user_L1PostApproveSaveLink;
		
	public WebElement get_l1user_L1PostApproveSaveLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_L1PostApproveSaveLink, logger)){
			return l1user_L1PostApproveSaveLink;
		}else
			return null;
	}
	
	//Save Button -- Impersonate L1 User Page -- After Approval/Completion
	@FindBy(css="input[automation-id='btnSSFMapUser']")
	private WebElement l1user_L1PostCompleteSaveLink;
		
	public WebElement get_l1user_L1PostCompleteSaveLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_L1PostCompleteSaveLink, logger)){
			return l1user_L1PostCompleteSaveLink;
		}else
			return null;
	}
	
	//Rejected Button -- Impersonate L1 User Page
	@FindBy(css="input[automation-id='btnSSFRejected']")
	private WebElement l1user_L1RejectLink;
		
	public WebElement get_l1user_L1RejectLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_L1RejectLink, logger)){
			return l1user_L1RejectLink;
		}else
			return null;
	}
	
	//Check if the Grid Page is loaded -- Check for the presence of Right Menu button
	@FindBy(css="a[test-id='btnRightmenu']")
	private WebElement l1user_rightMenuButtonLink;
		
	public WebElement get_l1user_rightMenuButtonLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_rightMenuButtonLink, logger)){
			return l1user_rightMenuButtonLink;
		}else
			return null;
	}
	
	//Add Owner Device Details for the selected SSF form chiller
	@FindBy(css="input[automation-id='btnAddOwnerDevice']")
	private WebElement l2user_addOwnerDeviceLink;
		
	public WebElement get_l2user_addOwnerDeviceLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l2user_addOwnerDeviceLink, logger)){
			return l2user_addOwnerDeviceLink;
		}else
			return null;
	}
	
	//Add Owner Device Details for the selected SSF form chiller -- Account ID 
	@FindBy(css="input[automation-id='txtOwner']")
	private WebElement l2user_ODAccIDLink;
		
	public WebElement get_l2user_ODAccIDLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l2user_ODAccIDLink, logger)){
			return l2user_ODAccIDLink;
		}else
			return null;
	}
	
	//Add Owner Device Details for the selected SSF form chiller -- Account IPassword
	@FindBy(css="input[automation-id='txtDevice']")
	private WebElement l2user_ODAccPassLink;
		
	public WebElement get_l2user_ODAccPassLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l2user_ODAccPassLink, logger)){
			return l2user_ODAccPassLink;
		}else
			return null;
	}
	
	//Add Owner Device Details for the selected SSF form chiller -- update Box
	@FindBy(css="input[automation-id='btUpdateOwnerDevice']")
	private WebElement l2user_ODAccUpdateLink;
		
	public WebElement get_l2user_ODAccUpdateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l2user_ODAccUpdateLink, logger)){
			return l2user_ODAccUpdateLink;
		}else
			return null;
	}
	
	//Onboarding Terms Comments -- L2 User Comments Section
	@FindBy(css="textarea[automation-id='txtAdviserComment']")
	private WebElement l2user_l2CommentsLink;
		
	public WebElement get_l2user_l2CommentsLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l2user_l2CommentsLink, logger)){
			return l2user_l2CommentsLink;
		}else
			return null;
	}
	
	//Complete Form Submission -- L2 User
	@FindBy(css="input[automation-id='btnSSFCompleted']")
	private WebElement l2user_l2ConfirmLink;
		
	public WebElement get_l2user_l2ConfirmLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l2user_l2ConfirmLink, logger)){
			return l2user_l2ConfirmLink;
		}else
			return null;
	}
	
	//SSF Form Rejection -- L2 User
	@FindBy(css="input[automation-id='btnSSFApproveRejected']")
	private WebElement l2user_l2RejectLink;
		
	public WebElement get_l2user_l2RejectLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l2user_l2RejectLink, logger)){
			return l2user_l2RejectLink;
		}else
			return null;
	}
	
	
	
	
	//################################################################################## stop impersonate ##############################################################
	
	//The Stop Impersonate Hyperlink
	@FindBy(css="span[test-id='lnkStopImpersonate']")
	private WebElement l1user_stopImpersonateLink;
		
	public WebElement get_l1user_stopImpersonateLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, l1user_stopImpersonateLink, logger)){
			return l1user_stopImpersonateLink;
		}else
			return null;
	}
	

}
