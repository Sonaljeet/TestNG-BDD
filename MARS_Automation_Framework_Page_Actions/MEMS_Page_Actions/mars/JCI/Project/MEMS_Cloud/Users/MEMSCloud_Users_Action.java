package mars.JCI.Project.MEMS_Cloud.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.Portfoliosuperadmin.MEMSCloud_PortfolioCreation_Page_Factory;
import mars.JCI.Project.MEMSCloud.Users.MEMSCloud_Users_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;

public class MEMSCloud_Users_Action {

public static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	//public String configFile="C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";	
	public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	public static MEMSCloud_Orgnization_Action orgobject=null;
	//public static String username="";
	public static List<String> Userdatalist_data = new ArrayList<String>();
	public static List<String> Orgnization_datalist = new ArrayList<String>();
	public static List<String> Admin_datalist = new ArrayList<String>();
	public static List<String> Admin_Details = new ArrayList<String>();
	
	/**
	 * Instantiates/Constructor a new MUI login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEMSCloud_Users_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		orgobject=new MEMSCloud_Orgnization_Action(driver,logger);
	}
	
	
	public void enterUsename(String username) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getusername();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, username);
					logger.log(LogStatus.PASS, "username Entered succesfully to username WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for username Field Failed");   
			}
			
		}
	
	
	public void enterPassword(String password) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getpassword();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, password);
					logger.log(LogStatus.PASS, "Password Entered succesfully to Password WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");   
			}
			
		}
	
	public void enterConfirmpassword(String Confirmpassword) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getConfirmPassword();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, Confirmpassword);
					logger.log(LogStatus.PASS, "Confirmpassword Entered succesfully to Confirmpassword WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Confirmpassword Field Failed");   
			}
			
		}
	
	public void enterFirstname(String Firstname) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getfirstname();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, Firstname);
					logger.log(LogStatus.PASS, "Firstname Entered succesfully to Firstname WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Firstname Field Failed");   
			}
			
		}
	public void enterLastname(String Lastname) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getlastname();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, Lastname);
					logger.log(LogStatus.PASS, "Lastname Entered succesfully to Lastname WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Lastname Field Failed");   
			}
			
		}
	
	public void selectOrgnization(String Orgnization) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getorganization();
			if(element!= null){
					Thread.sleep(3000);
					MEMSCloud_Orgnization_Action.selectByVisibleText(element, Orgnization,logger);
					 MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
					logger.log(LogStatus.PASS, "Orgnization Entered succesfully to Orgnization WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Orgnization Field Failed");   
			}
			
		}
	
	public void selectRole(String Role) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getrole();
			if(element!= null){
				    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				    Thread.sleep(2000);				    
					MEMSCloud_Orgnization_Action.selectByVisibleTextWithFluentWait(element, Role);
					MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
					Thread.sleep(5000);
					logger.log(LogStatus.PASS, "Role Entered succesfully to Role WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Role Field Failed");   
			}
		}
	
	public void enterEmail(String Email) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getuserEmail();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, Email);
					logger.log(LogStatus.PASS, "Email Entered succesfully to Email WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Email Field Failed");   
			}
			
		}
	
	public void enterContactnumber(String Contactnumber) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getcontactnumber();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, Contactnumber);
					logger.log(LogStatus.PASS, "Contactnumber Entered succesfully to Contactnumber WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Contactnumber Field Failed");   
			}
			
		}
	public void selectLanguage(String Language) throws Exception{
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(UsersPF.getLanguageDropDown(), "Language", Language,logger);
	}
	
	
	
	public void enteruser_insearchbox(String username) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getUser_searchbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, username);
					logger.log(LogStatus.PASS, "username Entered succesfully to user searchbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for user searchbox Field Failed");   
			}
			
		}
	
	public void clickSubmit_btn() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		element = UsersPF.getuserSubmit_btn();
		if(element!= null){
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				WebButton.Button_Click(driver, element);
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Clicked succesfully to Submit btn WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Submit Field Failed");   
		}
	}
	
	public void clickCreateuser_tab() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		element = UsersPF.getcreateUser_tab();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked succesfully to Createuser_tab WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Createuser_tab Field Failed");   
		}
	}
	
	// Assign user Roles & Rights
	
	public void clickRolesandRights_tab() throws Exception{
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		element = UsersPF.getRolesandRights_tab();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			Thread.sleep(2000);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked succesfully to Roles & Rights tab.");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Roles & Rights tab Field Failed");   
		}
	}
	
	
	
	public void clickaddUser_icon() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		element = UsersPF.getaddUSer_btn();
		if(element!= null){	
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			WebButton.Button_Click(driver, element);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked succesfully to createusericon button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for createusericon Field Failed");   
		}
	}
		
	public void clickDeleteUser_btn() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		element = UsersPF.DeleteUser_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to deleteusericon button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for deleteusericon Field Failed");   
		}
	}
	
	public void clickDeleteUser_confirm() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		element = UsersPF.getDeleteUser_confirm();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to delete user confirm button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for delete user confirm button Field Failed");   
		}
	}
	
	public void verifyUserpresent(String user) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		elements = UsersPF.checkuserpresent();
		if(elements.size() >0){	
			elements.get(0).click();
			logger.log(LogStatus.PASS, " User:= " +user+" is created sucesfully and is present in users grid");  
		}
		else{
			logger.log(LogStatus.FAIL, "  User:= " +user+" is not created sucesfully");   
		}
	}
	
	
	
	public void verifyUserpresentingridfordelete(String user) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		elements = UsersPF.checkuserpresent();
		if(elements.size() >0){	
			elements.get(0).click();
			logger.log(LogStatus.PASS, " User:= " +user+" is present in users grid");  
		}
		else{
			logger.log(LogStatus.FAIL, "  User:= " +user+" is not present in users grid");   
		}
	}
	
	public void verifyUsernotpresent(String user) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		elements = UsersPF.checkuserpresent();
		if(elements.size()>0){	
				logger.log(LogStatus.FAIL, " User:= "+user+ " not delete from the grid");  
		}
		else{
			logger.log(LogStatus.PASS, " User:= "+user+ " deleted succesfully from the grid");   
		}
	}
	public void clickUserpresent() throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		elements = UsersPF.checkuserpresent();
		if(elements.size()>0){	
				elements.get(0).click();
				logger.log(LogStatus.PASS, " clicked on USer");  
		}
		else{
			logger.log(LogStatus.FAIL, "USer is not present in grid");   
		}
	}
	
	public void selectRoleDropDown(String userRole) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_User_Role();
		if(element != null){
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			MEMSCloud_Orgnization_Action.selectByVisibleText(element, userRole,logger);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "User Role:= "+userRole+ " selected successfully in Role drop down list");
		}else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Role drop down Field Failed.");
		}
		
	}

	// Select Dashboard View Check Box
	public void selectDashboardView_ChkBox() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_chkDashboardView();
		boolean bValue = false;
		if (element != null) {
			bValue = commonFunctions.WebCheckBox.isChecked(element, logger);
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Dashboard View Field Failed.");
		}
		if (bValue == true) {
			logger.log(LogStatus.PASS, "Dashboard View check box checked successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Dashboard View Field Failed.");
		}
	}

	// Select Dashboard Edit Check Box
	public void selectDashboardEdit_ChkBox() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_chkDashboardEdit();
		boolean bValue = false;
		if (element != null) {
			bValue = commonFunctions.WebCheckBox.isChecked(element, logger);
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Dashboard Edit Field Failed.");
		}
		if (bValue == true) {
			logger.log(LogStatus.PASS, "Dashboard Edit check box checked successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Dashboard Edit Field Failed.");
		}

	}

	// Select Setup View Check Box
	public void selectSetUpView_ChkBox() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_chkSetupView();
		boolean bValue = false;
		if (element != null) {
			bValue = commonFunctions.WebCheckBox.isChecked(element, logger);
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Setup View Edit Field Failed.");
		}
		if (bValue == true) {
			logger.log(LogStatus.PASS, "Setup View check box checked successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Setup View Field Failed.");
		}

	}

	// Select Setup Edit Check Box
	public void selectSetUpEdit_ChkBox() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_chkSetupEdit();

		boolean bValue = false;
		if (element != null) {
			bValue = commonFunctions.WebCheckBox.isChecked(element, logger);
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Setup Edit Edit Field Failed.");
		}
		if (bValue == true) {
			logger.log(LogStatus.PASS, "Setup Edit check box checked successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Setup Edit Field Failed.");
		}

	}

	// Select Reports View Check Box
	public void selectReportsView_ChkBox() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_chkReportsView();
		boolean bValue = false;
		if (element != null) {
			bValue = commonFunctions.WebCheckBox.isChecked(element, logger);
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Report View Edit Field Failed.");
		}
		if (bValue == true) {
			logger.log(LogStatus.PASS, "Report View check box checked successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Report View Field Failed.");
		}

	}

	// Select Reports Edit Check Box
	public void selectReportsEdit_ChkBox() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_chkReportsEdit();

		boolean bValue = false;
		if (element != null) {
			bValue = commonFunctions.WebCheckBox.isChecked(element, logger);
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Report Edit Field Failed.");
		}
		if (bValue == true) {
			logger.log(LogStatus.PASS, "Report Edit check box checked successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Report Edit Field Failed.");
		}

	}

	// Save Roles
	public void clickOnSaveBtn() throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver, logger);
		element = UsersPF.get_SaveRoles();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Roles Save button clicked successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Save button Field Failed.");
		}
	}	
		
	public void create_user() throws Exception
	{
		
		String username=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);		
		String admindentials_data = "$..AdminDetails.*";
		Admin_Details = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), admindentials_data);			
		orgobject.correctLogin();	
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        orgobject.clickSetup_btn();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        clickCreateuser_tab();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        clickaddUser_icon();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"SuperadminUser",username);
		enterUsename(username);
		enterPassword(Admin_Details.get(0).toString());
		enterConfirmpassword(Admin_Details.get(1).toString());
		enterFirstname(Admin_Details.get(2).toString());
		enterLastname(Admin_Details.get(3).toString());
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		selectOrgnization(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		//selectRole(Admin_Details.get(4).toString());
		enterEmail(Admin_Details.get(5).toString());
		enterContactnumber(Admin_Details.get(6).toString());
		selectLanguage(Admin_Details.get(7).toString());
		selectRole(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminRole"));
		clickSubmit_btn();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        enteruser_insearchbox(username);
	    verifyUserpresent(username);
		
		
	}
	
	public void delete_user() throws Exception
	{
		
		orgobject.correctLogin();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		orgobject.clickSetup_btn();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        clickCreateuser_tab();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        enteruser_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser"));
		clickUserpresent();
		clickDeleteUser_btn();
		clickDeleteUser_confirm();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        enteruser_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser"));
        verifyUsernotpresent(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser"));
	

}		
	public void setAttribute(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].setAttribute('ng-checked','true')",element);
		//js.executeScript("arguments[0].setAttribute('type','sachin')",element);
		js.executeScript("arguments[0].click();",element);
	}

	public void assign_User_rights() throws Exception {
		//String Orgnizationlist_data_JSONPath = "$..Orgnizationdata.*";
		//Orgnization_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Orgnizationlist_data_JSONPath);
        //String roleName = Orgnization_datalist.get(1); 
       
		orgobject.correctLogin();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        orgobject.clickSetup_btn();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        clickRolesandRights_tab();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        selectRoleDropDown(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminRole"));
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        selectDashboardView_ChkBox();
        selectDashboardEdit_ChkBox();
        selectSetUpView_ChkBox();
        selectSetUpEdit_ChkBox();
        //selectReportsView_ChkBox();
        //selectReportsEdit_ChkBox();
        clickOnSaveBtn();
        MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
       
	}
	
}
