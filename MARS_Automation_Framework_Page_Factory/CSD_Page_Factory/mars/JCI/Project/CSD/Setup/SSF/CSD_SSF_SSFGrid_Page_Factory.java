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
public class CSD_SSF_SSFGrid_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_SSF_SSFGrid_Page_Factory(WebDriver driver, ExtentTest logger) {
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
					      .withTimeout(60, TimeUnit.SECONDS) 
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
		
		
		//The Administration Tab
		@FindBy(css="a[test-id='administration-tab']")
		private WebElement ssfTab_AdministrationLink;
			
		public WebElement get_ssfTab_AdministrationLink(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_AdministrationLink, logger)){
				return ssfTab_AdministrationLink;
			}else
				return null;
		}
		
		
		//The Site Setup Tab
		@FindBy(css="a[test-id='SiteSetup-tab']")
		private WebElement ssfTab_SiteSetupLink;
		
		public WebElement get_ssfTab_SiteSetupLink(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SiteSetupLink, logger)){
				return ssfTab_SiteSetupLink;
			}else
				return null;
		}
		
		//The SSF Tab
		@FindBy(css="a[test-id='SSF-tab']")
		private WebElement ssfTab_SSFTabLink;
		
		public WebElement get_ssfTab_SSFTabLink(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SSFTabLink, logger)){
				return ssfTab_SSFTabLink;
			}else
				return null;
		}
		
		// ############################################ Search Boxes -- SSF Grid ###########################################
		
		//Form ID Search Box
		@FindBy(css="input[name='ssfDetailsId']")
		private WebElement ssfTab_FormIDSearch;
		
		public WebElement get_ssfTab_FormIDSearch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_FormIDSearch, logger)){
				return ssfTab_FormIDSearch;
			}else
				return null;
		}
		
		//Branch Search Box
		@FindBy(css="input[name='BranchName']")
		private WebElement ssfTab_BranchSearch;
		
		public WebElement get_ssfTab_BranchSearch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_BranchSearch, logger)){
				return ssfTab_BranchSearch;
			}else
				return null;
		}
		
		//Customer Search Box
		@FindBy(css="input[name='Customer_Name']")
		private WebElement ssfTab_CustomerSearch;
		
		public WebElement get_ssfTab_CustomerSearch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CustomerSearch, logger)){
				return ssfTab_CustomerSearch;
			}else
				return null;
		}
		
		//Facility Search Box
		@FindBy(css="input[name='ProjectName']")
		private WebElement ssfTab_FacilitySearch;
		
		public WebElement get_ssfTab_FacilitySearch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_FacilitySearch, logger)){
				return ssfTab_FacilitySearch;
			}else
				return null;
		}
		
		//Status Search Box
		@FindBy(css="input[name='SsfStatus']")
		private WebElement ssfTab_StatusSearch;
		
		public WebElement get_ssfTab_StatusSearch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_StatusSearch, logger)){
				return ssfTab_StatusSearch;
			}else
				return null;
		}
		
		//ModifiedBy Search Box
		@FindBy(css="input[name='UpdatedBy']")
		private WebElement ssfTab_ModifiedBySearch;
		
		public WebElement get_ssfTab_ModifiedBySearch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_ModifiedBySearch, logger)){
				return ssfTab_ModifiedBySearch;
			}else
				return null;
		}
		
		//ModifiedOn Search Box
		@FindBy(css="input[name='UpdatedOn']")
		private WebElement ssfTab_ModifiedOnSearch;
		
		public WebElement get_ssfTab_ModifiedOnSearch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_ModifiedOnSearch, logger)){
				return ssfTab_ModifiedOnSearch;
			}else
				return null;
		}
		
		//Get First Row For Search
		@FindBy(css="#scrollDiv > table > tbody > tr")
		private WebElement ssfTab_SearchResultsGrid;
		
		public WebElement get_ssfTab_SearchResultsGrid(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid, logger)){
				return ssfTab_SearchResultsGrid;
			}else
				return null;
		}
		
		//Get First Row For Search --- Form ID Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(1)")
		private WebElement ssfTab_SearchResultsGrid_FormID;
		
		public WebElement get_ssfTab_SearchResultsGrid_FormID(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_FormID, logger)){
				return ssfTab_SearchResultsGrid_FormID;
			}else
				return null;
		}
		
		//Get First Row For Search --- Branch Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(2)")
		private WebElement ssfTab_SearchResultsGrid_Branch;
		
		public WebElement get_ssfTab_SearchResultsGrid_Branch(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_Branch, logger)){
				return ssfTab_SearchResultsGrid_Branch;
			}else
				return null;
		}
		
		//Get First Row For Search --- Customer Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(3)")
		private WebElement ssfTab_SearchResultsGrid_Customer;
		
		public WebElement get_ssfTab_SearchResultsGrid_Customer(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_Customer, logger)){
				return ssfTab_SearchResultsGrid_Customer;
			}else
				return null;
		}
		
		//Get First Row For Search --- Facility Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(4)")
		private WebElement ssfTab_SearchResultsGrid_Facility;
		
		public WebElement get_ssfTab_SearchResultsGrid_Facility(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_Facility, logger)){
				return ssfTab_SearchResultsGrid_Facility;
			}else
				return null;
		}
		
		//Get First Row For Search --- Status Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(5)")
		private WebElement ssfTab_SearchResultsGrid_Status;
		
		public WebElement get_ssfTab_SearchResultsGrid_Status(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_Status, logger)){
				return ssfTab_SearchResultsGrid_Status;
			}else
				return null;
		}
		
		//Get First Row For Search --- ModifiedBy Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(6)")
		private WebElement ssfTab_SearchResultsGrid_ModifiedBy;
		
		public WebElement get_ssfTab_SearchResultsGrid_ModifiedBy(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_ModifiedBy, logger)){
				return ssfTab_SearchResultsGrid_ModifiedBy;
			}else
				return null;
		}
		
		//Get First Row For Search --- ModifiedOn Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(7)")
		private WebElement ssfTab_SearchResultsGrid_ModifiedOn;
		
		public WebElement get_ssfTab_SearchResultsGrid_ModifiedOn(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_ModifiedOn, logger)){
				return ssfTab_SearchResultsGrid_ModifiedOn;
			}else
				return null;
		}
		
		//Get First Row For Search --- SCCPartsList Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(8) > div > a")
		private WebElement ssfTab_SearchResultsGrid_SCCPartsList;
		
		public WebElement get_ssfTab_SearchResultsGrid_SCCPartsList(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_SCCPartsList, logger)){
				return ssfTab_SearchResultsGrid_SCCPartsList;
			}else
				return null;
		}
		
		//Get First Row For Search --- View Value
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(9) > i")
		private WebElement ssfTab_SearchResultsGrid_View;
		
		public WebElement get_ssfTab_SearchResultsGrid_View(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_View, logger)){
				return ssfTab_SearchResultsGrid_View;
			}else
				return null;
		}
		
		//Get First Row For Search --- Edit Value 
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(9) > span.ng-scope > i")
		private WebElement ssfTab_SearchResultsGrid_Edit;
		
		public WebElement get_ssfTab_SearchResultsGrid_Edit(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_Edit, logger)){
				return ssfTab_SearchResultsGrid_Edit;
			}else
				return null;
		}
		
		
		//Get SSF Grid Table
		@FindBy(css="#scrollDiv > table")
		private WebElement ssfTab_ResultsGrid_Table;
		
		public WebElement get_ssfTab_ResultsGrid_Table(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_ResultsGrid_Table, logger)){
				return ssfTab_ResultsGrid_Table;
			}else
				return null;
		}
		
		//Get SSF Grid Table -- Search Results Table
		@FindBy(css="#scrollDiv > table > tbody")
		private WebElement ssfTab_searchResultsGrid_Table;
		
		public WebElement get_ssfTab_searchResultsGrid_Table(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_searchResultsGrid_Table, logger)){
				return ssfTab_searchResultsGrid_Table;
			}else
				return null;
		}
		
		
		//Get First Row For Search --- Delete Value  
		@FindBy(css="#scrollDiv > table > tbody > tr > td:nth-child(9) > span:nth-child(3) > span > span > span > i")
		private WebElement ssfTab_SearchResultsGrid_Delete;
		
		public WebElement get_ssfTab_SearchResultsGrid_Delete(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_SearchResultsGrid_Delete, logger)){
				return ssfTab_SearchResultsGrid_Delete;
			}else
				return null;
		}
		
		//The Equipment Section  -- Add -- POP UP -- Asset Details -- POP UP  -- Button
		@FindBy(css="input[id='popup_ok']")
		private WebElement ssfTab_PopUpLink;
			
		public WebElement get_ssfTab_PopUpLink(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_PopUpLink, logger)){
				return ssfTab_PopUpLink;
			}else
				return null;
		}
		
		//The Bottom Section  -- SAVE -- GRID SAVE--  Button//btnSSFSave
		@FindBy(css="input[automation-id='btnSSFSave']") //input[automation-id='btnSSFSave'] --- input[name='btnSave']
		private WebElement ssfTab_Bottom_SaveBtnSSFLink;
			
		public WebElement get_ssfTab_Bottom_SaveBtnSSFLink(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_SaveBtnSSFLink, logger)){
				return ssfTab_Bottom_SaveBtnSSFLink;
			}else
				return null;
		}
		
		//The Equipment Section  -- SUBMIT -- SSF SUBMIT -- Button
		@FindBy(css="input[automation-id='btnSSFSubmitted']") // automation-id='btnSubmit' -- value='Submit'
		private WebElement ssfTab_Bottom_SSFGridSubmitLink;
			
		public WebElement get_ssfTab_Bottom_SSFGridSubmitLink(){
			if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_Bottom_SSFGridSubmitLink, logger)){
				return ssfTab_Bottom_SSFGridSubmitLink;
			}else
				return null;
		}
		
		//The Create SSF Button
		@FindBy(css="input[value='Create SSF']")
		private WebElement ssfTab_CreateSSFLink;
			
			public WebElement get_ssfTab_CreateSSFLink(){
				if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfTab_CreateSSFLink, logger)){
					return ssfTab_CreateSSFLink;
				}else
					return null;
		}
			
			
		//####################################  Check if all the Branches shown oin the Grid are Eligible for the Logged in USER ########################
		
		//Number of Entries to be displayed on one page -- Right Side
		@FindBy(css="#scrollDiv > div > div > div > div > button:nth-child(3)")
		private WebElement ssfGrid_NoOfEntriesLink;
				
			public WebElement get_ssfGrid_NoOfEntriesLink(){
				if(commonFunctions.WebElementCommon.waitForElementPresent(driver, ssfGrid_NoOfEntriesLink, logger)){
					return ssfGrid_NoOfEntriesLink;
				}else
					return null;
		}
				
		//Number of Pages resulted -- Left Side
		@FindBy(css="#scrollDiv > div > div > div > ul > li")
		private WebElement ssfGrid_NoOfPagesLink;
					
			public WebElement get_ssfGrid_NoOfPagesLink(){
				if(waitForElementPresent(driver, ssfGrid_NoOfPagesLink, logger)){
					return ssfGrid_NoOfPagesLink;
				}else
					return null;
		}
		
}
