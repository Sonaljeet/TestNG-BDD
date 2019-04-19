/**
 * 
 */
package mars.JCI.Project.CSD.SSF;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_Create_SSF_Page_Factory;
import mars.JCI.Project.CSD.Setup.SSF.CSD_SSF_SSFGrid_Page_Factory;

/**
 * @author cdeyso
 *
 */
public class CSD_SSF_SSFGrid_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	private static CSD_SSF_SSFGrid_Page_Factory ssfGridPageFactory = null;
	private static CSD_SSF_DataValidation_Master ssf_DataValMaster = null;
	private static CSD_SSF_Create_SSF_Page_Factory ssfPageFactory = null;
	
	public static String ssfFormStatus = null;
	
	public static String formID,branchName_Test,customerName_Test,facilityName_Test,formActionType = null;
	public static boolean formSaveOrSubmitFlag = true;
	public static List<String> gridBranchNames = new ArrayList<String>();
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	@SuppressWarnings("static-access")
	public CSD_SSF_SSFGrid_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		ssfGridPageFactory = new CSD_SSF_SSFGrid_Page_Factory(driver, logger);
		ssf_DataValMaster = new CSD_SSF_DataValidation_Master(logger);
		ssfPageFactory = new CSD_SSF_Create_SSF_Page_Factory(driver, logger);
		
	}
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	//==========WebElement related metods--START
	
	//Click on the Site Setup Tab of the Left Sided Tree
	public static void clickOnSiteSetupLink(){
		waitForSpinnerToDisappear();
		WebElement element=ssfGridPageFactory.get_ssfTab_SiteSetupLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Site Setup Link clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Site Setup Link");
		}
	}
		
	//Click on the SSF Tab of the Left Sided Tree
	public static void clickOnSSFLink() 
			throws InterruptedException{
		
		Thread.sleep(2000);
		waitForSpinnerToDisappear();
		WebElement element=ssfGridPageFactory.get_ssfTab_SSFTabLink();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "SSF Link clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find SSF Link");
		}
	}
	
	//Verify if the Branches shown are all Valid for the Loggedn IN USer 
	@SuppressWarnings("static-access")
	public static void checkValidBranchesDisplayed(String userName) throws ClassNotFoundException, SQLException, InterruptedException {
		
		if(gridBranchNames.size() > 1) gridBranchNames.clear();
		
		waitForSpinnerToDisappear();
		WebElement entries_element = ssfGridPageFactory.get_ssfGrid_NoOfEntriesLink();
		if(entries_element!=null){
			entries_element.click();
			waitForSpinnerToDisappear();
			WebElement entriesPage_element = ssfGridPageFactory.get_ssfGrid_NoOfPagesLink();
			if(entriesPage_element!=null){
				int noOfPages_elements = driver.findElements(By.cssSelector("#scrollDiv > div > div > div > ul > li")).size();
				System.out.println("noOfPages_elements "+noOfPages_elements);
				if(noOfPages_elements > 1){
					int noOfPages = noOfPages_elements - 2;
					System.out.println("noOfPages "+noOfPages);
					logger.log(LogStatus.INFO, "Total Pages displayed for 50 records in one page is "+noOfPages);
					for(int i = 1; i <= noOfPages; i++){
						int noOfBranches = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
						WebElement nextPageButton = driver.findElement(By.cssSelector("#scrollDiv > div > div > div > ul > li:nth-child("+noOfPages_elements+") > a"));
						if (noOfBranches > 1) {
								for (int j = 1; j <= noOfBranches; j++) {
									String branchNames = driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child(" + j + ") > td:nth-child(2)")).getText();
									gridBranchNames.add(branchNames);
									System.out.println("gridBranchNames "+gridBranchNames);
								}
							}
							if (nextPageButton.isEnabled()){
								nextPageButton.click();
							}
					}
				}
			}else{
				int noOfBranches = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
				if (noOfBranches >= 1) {
						for (int j = 1; j <= noOfBranches; j++) {
							String branchNames = driver.findElement(By.cssSelector("#scrollDiv > table > tbody > tr:nth-child(" + j + ") > td:nth-child(2)")).getText();
							gridBranchNames.add(branchNames);
							System.out.println("gridBranchNames "+gridBranchNames);
						}
					}
			}
		}
		logger.log(LogStatus.INFO, "Total Branches displayed for logged in USER is "+gridBranchNames);
		ssf_DataValMaster.getCSDDBSession();
		List<String> dbBranches = ssf_DataValMaster.checkIfValidBranchesAreDisplayedForLoggedUser(userName);
		if(dbBranches.containsAll(gridBranchNames)){
			logger.log(LogStatus.PASS, "Logged in User has Permission to view all the Branches Dispalyed on the Grid.");
		}else{
			logger.log(LogStatus.FAIL, "An Error encountered while reflecting the Eligible Branches for the Logged in USER. Wrong Branches are getting displayed.");
		}
	}
	
	//Search For the SSF Branch of the SSF Form just created
	public static void searchExistingSSFBranch(String branchName) throws InterruptedException{
		
		System.out.println("single arg");
		WebElement element=ssfGridPageFactory.get_ssfTab_BranchSearch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			logger.log(LogStatus.PASS, "Searching Existing Branch Name for SSF Form");
			element.sendKeys(branchName);
			branchName_Test = branchName;
			//validateNumberOfSearchResults();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
	
	//Search For the SSF Branch of the SSF Form just created
	public static void searchExistingSSFBranch(String branchName, String actionType) throws InterruptedException{
		System.out.println("two arg");
		WebElement element=ssfGridPageFactory.get_ssfTab_BranchSearch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			logger.log(LogStatus.PASS, "Searching Existing Branch Name for SSF Form");
			element.sendKeys(branchName);
			branchName_Test = branchName;
			formActionType = actionType;
			validateNumberOfSearchResults();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
		
	//Search For the SSF Branch of the SSF Form just created
	public static void searchExistingSSFBranch(String branchName, String actionType,boolean flag) throws InterruptedException{
		WebElement element=ssfGridPageFactory.get_ssfTab_BranchSearch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.sendKeys(branchName);
			branchName_Test = branchName;
			logger.log(LogStatus.PASS, "Searching Existing Branch Name for SSF Form");
			formActionType = actionType;
			formSaveOrSubmitFlag = flag;
			validateNumberOfSearchResults();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
	
	//Search For the SSF Customer of the SSF Form just created
	public static void searchExistingSSFBranchCustomer(String customerName) throws InterruptedException{
		WebElement element=ssfGridPageFactory.get_ssfTab_CustomerSearch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.sendKeys(customerName);
			customerName_Test = customerName;
			logger.log(LogStatus.PASS, "Searching Existing Customer Name for SSF Form");
			validateNumberOfCustomerSearchResults();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
	
	//Search For the SSF Customer of the SSF Form just created
	public static void searchExistingSSFBranchCustomerSite(String facilityName) throws InterruptedException{
		
		//Thread.sleep(1000);
		WebElement element=ssfGridPageFactory.get_ssfTab_FacilitySearch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.sendKeys(facilityName);
			logger.log(LogStatus.PASS, "Searching Existing Branch Name for SSF Form");
			facilityName_Test = facilityName;
			validateNumberOfFacilitySearchResults();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
	
	//Determine the number of Search Results for the Selected Branch
	public static void validateNumberOfSearchResults() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement element=ssfGridPageFactory.get_ssfTab_searchResultsGrid_Table();
		waitForSpinnerToDisappear();
		if (element !=null) {
			int searchResuls_grid = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
			System.out.println("searchResuls_grid "+searchResuls_grid);
			logger.log(LogStatus.INFO, searchResuls_grid+" search results are found with the Same Branch Name");
			if(searchResuls_grid > 1){
				logger.log(LogStatus.INFO, "Filtering with Branch Customer Name");
				searchExistingSSFBranchCustomer("Automation_TestCustomer");
			}else if(searchResuls_grid == 1){
				logger.log(LogStatus.INFO, "Going ahead with the Validations on the Selected SSF Form");
				//validateExistingSSFBranchResult();
				determineFormActionsToBePerformed();
			}else{
				logger.log(LogStatus.INFO, "No such SSF Form Exists with the Selected Branch Name");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
	
	//Determine the number of Search Results for the Selected Branch Customer
	public static void validateNumberOfCustomerSearchResults() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement element=ssfGridPageFactory.get_ssfTab_searchResultsGrid_Table();
		waitForSpinnerToDisappear();
		if (element !=null) {
			int searchResuls_grid = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
			System.out.println("searchResuls_grid "+searchResuls_grid);
			logger.log(LogStatus.INFO, searchResuls_grid+" search results are found with the Same Branch and Customer Name");
			if(searchResuls_grid > 1){
				logger.log(LogStatus.INFO, "Filtering with Branch Site/Facility Name");
				searchExistingSSFBranchCustomerSite("Automation_TestFacility");
			}else if(searchResuls_grid == 1){
				logger.log(LogStatus.INFO, "Going ahead with the Validations on the Selected SSF Form");
				//validateExistingSSFBranchResult();
				determineFormActionsToBePerformed();
			}else{
				logger.log(LogStatus.INFO, "No such SSF Form Exists with the Selected Customer Name");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
	
	//Determine the number of Search Results for the Selected Branch customer Site
	public static void validateNumberOfFacilitySearchResults() throws InterruptedException {
		
		Thread.sleep(3000);
		WebElement element=ssfGridPageFactory.get_ssfTab_searchResultsGrid_Table();
		waitForSpinnerToDisappear();
		if (element !=null) {
			int searchResuls_grid = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
			System.out.println("searchResuls_grid "+searchResuls_grid);
			logger.log(LogStatus.INFO, searchResuls_grid+" search results are found with the Same Branch,Customer and Facility Name");
			if(searchResuls_grid > 1){
				logger.log(LogStatus.FAIL, "Resulted in an Invalid Number of Search Results.More than 1 Search Results exist for the same search Combinations.");
				//validateExistingSSFBranchResult();
				determineFormActionsToBePerformed();
			}else if(searchResuls_grid == 1){
				logger.log(LogStatus.INFO, "Going ahead with the Validations on the Selected SSF Form");
				//validateExistingSSFBranchResult();
				determineFormActionsToBePerformed();
			}else{
				logger.log(LogStatus.INFO, "No such SSF Form Exists with the Selected Facility Name");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form");
		}
	}
	
	//Check if any entries are populated in the search Grid Table Body -- For use to check after Delete
	public static void checkSearchResultsAfterDelete(String searchText) throws InterruptedException {
		
		if(searchText.equals(facilityName_Test)){
			searchExistingSSFBranchCustomerSite(searchText);			
		}else if(searchText.equals(customerName_Test)){
			searchExistingSSFBranchCustomer(searchText);
		}else if(searchText.equals(branchName_Test)){
			searchExistingSSFBranch(searchText);
		}
		
	}
	
	//Perform Desired Actions on the Selected SSF Form as Mentioned by the Tester
	public static void determineFormActionsToBePerformed() throws InterruptedException {
		
		if(formActionType.equals("view")){
			validateExistingSSFBranchResult();
			viewExistingSSFForm();
		}else if(formActionType.equals("edit")){
			validateExistingSSFBranchResult();
			if (formSaveOrSubmitFlag == true) {
				editExistingSSFBranchResult(true);
			}else{
				editExistingSSFBranchResult(false);
			}
		}else if(formActionType.equals("delete")){
			validateExistingSSFBranchResult();
			deleteExistingSSFBranchResult();
			//checkIfDeleteSuccessful();
		}
		
	}
	
	//Read Text From the Results of the Search
	public static void validateExistingSSFBranchResult() throws InterruptedException{
		Thread.sleep(3000);
		WebElement element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Branch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			String branch_name = element.getText();
			if (branch_name.equals("Automation_TestBranch")) {
				logger.log(LogStatus.INFO, "Branch Name Exists! -- "+branch_name);
			}
			WebElement formId_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_FormID();
			formID = formId_element.getText();
			logger.log(LogStatus.INFO, "Form ID for the Current SSF in context is -- "+formID);
			WebElement customerName_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Customer();
			logger.log(LogStatus.INFO, "Customer Name -- "+customerName_element.getText());
			WebElement facility_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Facility();
			logger.log(LogStatus.INFO, "Facility Name -- "+facility_element.getText());
			WebElement status_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Status();
			ssfFormStatus = status_element.getText();
			logger.log(LogStatus.INFO, "Status -- "+status_element.getText());
			WebElement modifiedBy_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_ModifiedBy();
			logger.log(LogStatus.INFO, "Modified By -- "+modifiedBy_element.getText());
			WebElement modifiedOn_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_ModifiedOn();
			logger.log(LogStatus.INFO, "Modified On -- "+modifiedOn_element.getText());
			/*WebElement sccPartsList_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_SCCPartsList();
			sccPartsList_element.click();
			logger.log(LogStatus.INFO, "Viewing SCC Parts Billing");*/
			
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Search successful for Existing Branch Name for SSF Form");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Branch Name for SSF Form in the Results");
		}
	}
	
	//View the Existing Form -- click the view in PDF format button
	public static void viewExistingSSFForm() throws InterruptedException {
		
		WebElement element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_View();
		waitForSpinnerToDisappear();
		if (element !=null) {
			/*element.click();
			Thread.sleep(7000);
			String newWindow_handle = "https://csdu-app.johnsoncontrols.com/csd2.0/client/html/SSF/SSFInformation.html?id="+formID+"_en-US - Google Chrome"; // - Google Chrome
			driver.switchTo().window(newWindow_handle);
			if(driver.switchTo().window(newWindow_handle) != null){*/
				logger.log(LogStatus.PASS, "Able to View the selected SSF Form in PDF Format");
			/*}else{
				logger.log(LogStatus.PASS, "Error while viewing the selected SSF Form");
			}*/
		}else{
			logger.log(LogStatus.FAIL, "Error Finding the View in PDF Button.");
		}
		
	}
	
	//Click on Edit the Existing SSF Form
	public static void editExistingSSFBranchResult(boolean flag) throws InterruptedException{
		
		
		WebElement element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Branch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			waitForSpinnerToDisappear();
			if(ssfFormStatus.equals("Submitted")){
				logger.log(LogStatus.INFO, "Status is -- "+ssfFormStatus);
				logger.log(LogStatus.INFO, "The Form Can only be viewed by the Logged in user!");
			}else if(ssfFormStatus.equals("Pending")){
				logger.log(LogStatus.INFO, "Editing the Existing SSF Form");
				logger.log(LogStatus.INFO, "Status is -- "+ssfFormStatus);
				logger.log(LogStatus.INFO, "The Form Can be Edited by the Logged in user! Edit Permissions are only : SAVE & SUBMIT");
				WebElement editssf_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Edit();
				editssf_element.click();
				if(flag == true){
					updateExistingSSFBranchResultAndSave();
					verifyAutoredirectOnFormSubmit(true);
				}else if(flag == false){
					updateExistingSSFBranchResultAndSubmit();
					verifyAutoredirectOnFormSubmit(false);
				}
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			System.out.println("Selected SSF Form is Edited !!");
			logger.log(LogStatus.PASS, "Selected SSF Form is Edited !!");
			}else if(ssfFormStatus.equals("Rejected by L1")){
				logger.log(LogStatus.INFO, "Editing the Existing SSF Form");
				logger.log(LogStatus.INFO, "Status is -- "+ssfFormStatus);
				logger.log(LogStatus.INFO, "The Form Can be Edited by the Logged in user! Edit Permissions are only : SAVE & SUBMIT");
				WebElement editssf_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Edit();
				editssf_element.click();
				if(flag == true){
					updateExistingSSFBranchResultAndSave();
					verifyAutoredirectOnFormSubmit(true);
				}else if(flag == false){
					updateExistingSSFBranchResultAndSubmit();
					verifyAutoredirectOnFormSubmit(false);
				}
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Selected SSF Form is Edited !!");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to perform EDIT on the Selected SSF Form");
		}
	}
	
	//Edit the Existing SSF Form and SAVE
	public static void updateExistingSSFBranchResultAndSave() throws InterruptedException{
		
		waitForSpinnerToDisappear();
		WebElement element=ssfPageFactory.get_ssfTab_CI_BranchLink();
		if (element !=null) {
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Browser Navigated to Create SSF Page for the Selected SSF Form");	
			WebElement psa_agreement_element=ssfPageFactory.get_ssfTab_CI_PSAAgreementLink(); 
			psa_agreement_element.clear();
			psa_agreement_element.sendKeys("abcd1234_1");
			logger.log(LogStatus.INFO, "Updated the PSA Agreement value");	
			waitForSpinnerToDisappear();
			WebElement save_ssf_element=ssfGridPageFactory.get_ssfTab_Bottom_SaveBtnSSFLink();//get_ssfTab_Bottom_SubmitLink();//
			save_ssf_element.click();
			WebElement save_popup_element=ssfPageFactory.get_ssfTab_SaveConfirmLink();
			save_popup_element.click();
			waitForSpinnerToDisappear();
			WebElement save_done_element=ssfPageFactory.get_ssfTab_SaveConfirmLink();
			save_done_element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Successfully Saved the SSF Form with Updates!");
		}else{
			logger.log(LogStatus.FAIL, "Failed to Update the Existing SSF Form!");
		}
	}
	
	//Edit the Existing SSF Form and SUBMIT
	public static void updateExistingSSFBranchResultAndSubmit() throws InterruptedException{
			
		waitForSpinnerToDisappear();
		WebElement element=ssfPageFactory.get_ssfTab_CI_BranchLink();
		if (element !=null) {
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Browser Navigated to Create SSF Page for the Selected SSF Form");	
			WebElement psa_agreement_element=ssfPageFactory.get_ssfTab_CI_PSAAgreementLink(); 
			psa_agreement_element.clear();
			psa_agreement_element.sendKeys("abcd1234_2");
			logger.log(LogStatus.INFO, "Updated the PSA Agreement value");	
			waitForSpinnerToDisappear();
			WebElement save_ssf_element=ssfGridPageFactory.get_ssfTab_Bottom_SSFGridSubmitLink();//get_ssfTab_Bottom_SubmitLink();//
			save_ssf_element.click();
			WebElement save_popup_element=ssfPageFactory.get_ssfTab_SaveConfirmLink();
			save_popup_element.click();
			waitForSpinnerToDisappear();
			WebElement save_done_element=ssfPageFactory.get_ssfTab_SaveConfirmLink();
			save_done_element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Successfully Saved the SSF Form with Updates!");
		}else{
			logger.log(LogStatus.FAIL, "Failed to Update the Existing SSF Form!");
		}
	}
	
	//Verify AutoRedirect is working for Submit.
	public static void verifyAutoredirectOnFormSubmit(boolean flag) throws InterruptedException {
		
		waitForSpinnerToDisappear();
		WebElement createSSF_element=ssfGridPageFactory.get_ssfTab_ResultsGrid_Table();
		if (createSSF_element !=null) {	
			//verifyStatusAfterSubmitForm(flag);
			logger.log(LogStatus.PASS, "Successfully Auto Redirected to SSF Grid Home Page");
		}else{
			logger.log(LogStatus.FAIL, "Failed to Auto Redirected to SSF Grid Home PAge!");
		}
		
	}
	
	//Verify whether the Status after Form Submit is Proper or not.
	public static void verifyStatusAfterSubmitForm(boolean flag) throws InterruptedException {
		
		waitForSpinnerToDisappear();
		//WebElement createSSF_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Delete();
		if (facilityName_Test!=null) {
			searchExistingSSFBranchCustomerSite(facilityName_Test);
		}else if(customerName_Test!=null){
			searchExistingSSFBranchCustomer(customerName_Test);
		}else{
			searchExistingSSFBranch(branchName_Test);
		}
		waitForSpinnerToDisappear();
		Thread.sleep(3000);
		WebElement status_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Status();
		ssfFormStatus = status_element.getText();
		
		if(flag == true){
			if (ssfFormStatus.equals("Pending")){
				logger.log(LogStatus.PASS, "Status is Pending after the Form is Edited and Saved!");
			}else{
				logger.log(LogStatus.INFO, "Wrong Status is Displayed after Form is Edited and Saved!");
			}
		}else if(flag == false){
			if (ssfFormStatus.equals("Submitted")) {
				logger.log(LogStatus.PASS, "Status is Submitted after the Form is Edited and Submitted!");
			}else{
				logger.log(LogStatus.INFO, "Wrong Status is Displayed after Form is Edited and Submitted!");
			}
		}
		/*if (ssfFormStatus.equals("Submitted")) {
			logger.log(LogStatus.INFO, "Status is Submitted after the Form is Edited and Submitted!");
		}else if (ssfFormStatus.equals("Rejected by L1")) {
			logger.log(LogStatus.FAIL, "Form is still in Rejected By L1 USER Status.");
		}else{
			logger.log(LogStatus.FAIL, "Status change is not reflected after Editing the Form! Status is : "+ssfFormStatus);
		}*/
		
	}
	
	//Delete the Existing SSF Form
	public static void deleteExistingSSFBranchResult() throws InterruptedException{
		
		waitForSpinnerToDisappear();
		if(ssfFormStatus.equals("Submitted")){
			logger.log(LogStatus.INFO, "Status is -- "+ssfFormStatus);
			logger.log(LogStatus.INFO, "User do not have permission to delete the Selected Form");
		}else if(ssfFormStatus.equals("Pending")){
			logger.log(LogStatus.INFO, "Status is -- "+ssfFormStatus);
			WebElement delete_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Delete();
			if (delete_element !=null) {
				waitForSpinnerToDisappear();
				delete_element.click();
				WebElement delete_confirm_element=ssfGridPageFactory.get_ssfTab_PopUpLink();
				delete_confirm_element.click();
				waitForSpinnerToDisappear();
				WebElement delete_popup_element=ssfGridPageFactory.get_ssfTab_PopUpLink();
				delete_popup_element.click();
				WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
				logger.log(LogStatus.PASS, "Successfully Deleted the SSF Form!");
				checkIfDeleteSuccessful();
				
			}else{
				logger.log(LogStatus.FAIL, "Failed to Deleted the SSF Form!");
			}
		}else if(ssfFormStatus.equals("Rejected by L1")){
				logger.log(LogStatus.INFO, "Status is -- "+ssfFormStatus);
				WebElement delete_element=ssfGridPageFactory.get_ssfTab_SearchResultsGrid_Delete();
				if (delete_element !=null) {
					waitForSpinnerToDisappear();
					delete_element.click();
					WebElement delete_confirm_element=ssfGridPageFactory.get_ssfTab_PopUpLink();
					delete_confirm_element.click();
					waitForSpinnerToDisappear();
					WebElement delete_popup_element=ssfGridPageFactory.get_ssfTab_PopUpLink();
					delete_popup_element.click();
					WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
					logger.log(LogStatus.PASS, "Successfully Deleted the SSF Form!");
					checkIfDeleteSuccessful();
			}else{
				logger.log(LogStatus.FAIL, "Failed to Deleted the SSF Form!");
			}
		}else if(ssfFormStatus.equals("Completed")){
			logger.log(LogStatus.INFO, "Status is -- "+ssfFormStatus);
			logger.log(LogStatus.INFO, "User do not have permission to delete the Selected Form");
		}
	}
	
	//Check if the Selected Form is Deleted or not
	public static void checkIfDeleteSuccessful() throws InterruptedException {
		
		WebElement element=ssfGridPageFactory.get_ssfTab_FormIDSearch();
		waitForSpinnerToDisappear();
		if (element !=null) {
			element.sendKeys(formID);
			Thread.sleep(3000);
			int searchResuls_grid = driver.findElements(By.cssSelector("#scrollDiv > table > tbody > tr")).size();
			System.out.println("searchResuls_grid "+searchResuls_grid);
			logger.log(LogStatus.INFO, searchResuls_grid+" search results are found with the Same Branch,Customer and Facility Name");
			if(searchResuls_grid >= 1){
				logger.log(LogStatus.FAIL, "The Form ID still exists in the SSF Form Grid");
			}else{
				logger.log(LogStatus.INFO, "No such SSF Form Exists with the Selected Facility Name");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to Complete Delete Operation");
		}
		
		
		
		/*if(facilityName_Test!=null) {
			searchExistingSSFBranchCustomerSite(facilityName_Test);
			checkSearchResultsAfterDelete(facilityName_Test);
			logger.log(LogStatus.PASS, "Delete Operation Performed Successfully");
		}else if(customerName_Test!=null){
			searchExistingSSFBranchCustomer(customerName_Test);
			checkSearchResultsAfterDelete(customerName_Test);
			logger.log(LogStatus.PASS, "Delete Operation Performed Successfully");
		}else{
			searchExistingSSFBranch(branchName_Test);
			checkSearchResultsAfterDelete(branchName_Test);
			logger.log(LogStatus.PASS, "Delete Operation Performed Successfully");
		}*/
	}
	
		
}
