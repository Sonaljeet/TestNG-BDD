package mars.JCI.Project.MEMS_Cloud.Orgnization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.handler.codec.frame.Delimiters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.OrganizationLicence.MEMSCloud_OrganizationLicence;
import mars.JCI.Project.MEMSCloud.Portfoliosuperadmin.MEMSCloud_PortfolioCreation_Page_Factory;
import mars.JCI.Project.MEMSCloud.Users.MEMSCloud_Users_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Users.MEMSCloud_Users_Action;

public class MEMSCloud_Orgnization_Action {

public static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	//public static String Organizationame="";
	public static List<String> Login_datalist = new ArrayList<String>();
	public static List<String> Orgnization_datalist = new ArrayList<String>();
	public static List<String> SuperAdmin_credentials = new ArrayList<String>();
	/**
	 * Instantiates/Constructor a new MUI login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 * 
	 */
	public MEMSCloud_Orgnization_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	/**
	 * 
	 * @param userid
	 * @throws Exception 
	 */
	
	public void enterUserID(String userid) throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getuser();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, userid);
					logger.log(LogStatus.PASS, "Userid Entered succesfully to Userid text box.");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for userid Field Failed");   
			}
			
		}
	
	
	public void enterPassword(String password) throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getpassword();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, password);
					logger.log(LogStatus.PASS, "Password Entered succesfully to Password text box.");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");   
			}
			
		}
	
	public  void clickSetup_btn() throws Exception {
		System.out.println("in setup click");
		Thread.sleep(10000);
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getSetup();
		if(element!= null){
			if(verifySetup_btn_Enabled()){
				WebButton.Button_Click(driver, element);
				Thread.sleep(5000);
				logger.log(LogStatus.PASS, "Clicked succesfully to Setup WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "Setup WebElement is not enabled");
			}
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Setup Field Failed");   
		}
		
	}
	public void clickSignIn_btn() throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getloginin();
		if(element!= null){
				WebButton.Button_Click(driver, element);
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Clicked succesfully on Log In button.");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Log in Field Failed");   
		}
	}
	
	public void clickCreatorganization_tab() throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getCreate_organization_tab();
		if(element!= null){
			waitForSpinnerToDisappear();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			WebButton.Button_Click(driver, element);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked succesfully to Creatorgnization_tab WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Creatorgnization_tab Field Failed");   
		}
	}
	
	
	public void clickCreatRole_tab() throws Exception{
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getCreate_Role_tab();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked succesfully to CreateRole_tab WebElement.");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for CreateRole_tab Field Failed.");   
		}
	}
	
	
	public void enterPortfolioname(String Portfolioname) throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getPortfolio_name();
			if(element!= null){
				if(element.isDisplayed()){
					waitForSpinnerToDisappear();
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, Portfolioname);
					logger.log(LogStatus.PASS,   Portfolioname+ "Portfolioname Entered succesfully to Portfolioname WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Portfolioname Field Failed");   
			}
			
		}
	
	public void enterDateformat(String Dateformat) throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getdateformat();
			if(element!= null){
					selectByVisibleText(element, Dateformat,logger);
					logger.log(LogStatus.PASS, "dateformat Entered succesfully to dateformat WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "dateformat WebElement for dateformat Field Failed");   
			}
			
		}
	
	
	public void selectAccounttype(String Accounttype) throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getAccount_type();
			if(element!= null){
					selectByVisibleText(element, Accounttype,logger);
					logger.log(LogStatus.PASS, "accounttype Entered succesfully to accounttype WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for accounttype Field Failed");   
			}
			
		}
	
	
	public void clickADD_organization_btn() throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getAdd_organization_btn();
		if(element!= null){
			if(verify_add_orgnization_btn_Enabled()){
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				WebButton.Button_Click(driver, element);
				//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Clicked succesfully to add orgniaztion btn WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "add orgniaztion btn WebElement is not enabled");
			}
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for add orgniaztion btn Field Failed");   
		}
		
	}
	public void select_pagesize() throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getpagesize_dropdown();
			if(element!= null){
					MEMSCloud_Orgnization_Action.selectByVisibleText(element, "100",logger);
					logger.log(LogStatus.PASS, "Pagesize selected succesfully to pagesize dropdown WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for pagesize dropdown Field Failed");   
			}
			
		}
	
	public void clickRecyclebin() throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getRecyclebin_tab();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to Recyclebin_tab WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Recyclebin_tab Field Failed");   
		}
	}
	
	public void clickDeactivate_btn() throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getDeactivate_organization_btn();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to Deactivate button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Deactivate button Field Failed");   
		}
	}
	
	public void clickDeactivate_confirm_btn() throws Exception {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getDeactivateOrgnization_confirm();
		if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to Deactivate confirm button WebElement");  
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Deactivate confirm button Field Failed");   
		}
	}
	
	public void verifyOrgnizationpresent(String Orgnization) throws InterruptedException {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.checkOrgnizationpresent();
		if(element!= null){	
			element.click();
				logger.log(LogStatus.PASS, "Organization:= "+Orgnization+"  is created succesfully and present in grid ");  
		}
		else{
			logger.log(LogStatus.FAIL, "Organization:= "+Orgnization+"  is not created succesfully and not present in grid also");   
		}
	}
	
	public void verifyOrgnizationpresentInRecylebin(String Orgnization) throws InterruptedException {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.checkOrgnizationpresent();
		if(element!= null){	
			element.click();
				logger.log(LogStatus.PASS, "Deactivated organization:= "+Orgnization+" is present in the recycle bin grid ");  
		}
		else{
			logger.log(LogStatus.FAIL, "Deactivated organization:= "+Orgnization+" not present in the recycle bin grid ");   
		}
	}
	
	
	
	public void verifyOrgnizationpresentInLicenseGrid(String Orgnization) throws InterruptedException {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.checkOrgnizationpresent();
		if(element!= null){	
			element.click();
				logger.log(LogStatus.PASS, "License to organization:= "+Orgnization+" is given succesfully and present in license grid ");  
		}
		else{
			logger.log(LogStatus.FAIL, "License to organization:= "+Orgnization+" is not given succesfully and not present in license grid ");   
		}
	}
	
	public void clickOrgnizationpresent() throws InterruptedException {
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.checkOrgnizationpresent();
		if(element!= null){	
				element.click();
				logger.log(LogStatus.PASS, " clicked on organization");  
		}
		else{
			logger.log(LogStatus.FAIL, "organization is not present in grid");   
		}
	}
	
	public void clickOnAddBtn() throws Exception{
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getclickOnAddButton();
		if(element!= null){	
			 	MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				element.click();
				 MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, " clicked on Add Button");  
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for Add Button Field Failed.");   
		}
	}
	
	public void checkAddedRoleName(String roleName) throws Exception{
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		element = PortfolioPF.getAccountTypeDPList();
		boolean flag = false;
		if(element !=  null){			
			String delimiter = "\n";
			String arry[] = element.getText().split(delimiter);
			for (int i = 0; i < arry.length; i++) {
				if(arry[i].contentEquals(roleName)){				
					flag = true;
					break;
				}
			}
			if(flag)
			logger.log(LogStatus.PASS, " Account type add successfully.");
			else
				logger.log(LogStatus.FAIL, "Identifying WebElement for Account type Field Failed.");
			}
	else{
		logger.log(LogStatus.FAIL, "Identifying WebElement for Account type Field Failed.");   
	}
	
}
	
	public void enterOrgnization_insearchbox(String username) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getUser_searchbox();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, username);
					Thread.sleep(3000);
					logger.log(LogStatus.PASS, "Orgnization entered succesfully to orgnization searchbox WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for orgnization searchbox Field Failed");   
			}
			
		}
	
	public void enterRole_InSearchBox(String Rolename) throws Exception {
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getSuperadmin_searchbox();
			sendInputTextBoxWithLogger(element, "Superadmin searchbox", Rolename,logger);	
		}
	
	//Enter Role	
	public void enterRole(String roleName) throws Exception{
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		element = UsersPF.getUser_Role();
		if(element!= null){
			if(element.isDisplayed()){
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, roleName);
				logger.log(LogStatus.PASS, "Role Name Entered succesfully to Role text box.");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for user Role Field Failed.");   
		}
	}
	
	
	// Enter Description
	
	//Enter Role	
		public void enterDescription(String description) throws Exception{
			MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
			element = UsersPF.getRole_Description();
			if(element!= null){
				if(element.isDisplayed()){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, description);
					logger.log(LogStatus.PASS, "Role Description Entered succesfully to Role text box.");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for user Role Field Failed.");   
			}
		}
	
		//Select Account Type		
		public void selectAccountType(String roleName) throws Exception {
			MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getselectAccountType();
			if(element!= null){	
					//element.click();
					waitForSpinnerToDisappear();
					selectByVisibleText(element, roleName,logger);
					waitForSpinnerToDisappear();
					logger.log(LogStatus.PASS, roleName+" Account type selected.");  
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for Account type Field Failed.");   
			}
			
		}

		public void verifySuperadminRolePresent(String role) throws Exception {
			MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.checkRolePresent();
			if(element!= null){	
				element.click();
					logger.log(LogStatus.PASS, "Role:= " +role+ " is created succesfully and present in role grid");  
			}
			else{
				logger.log(LogStatus.FAIL, "Role:= " +role+ " is not created succesfully");   
			}
		}
		public void waitForLoginUser() throws Exception{
			MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getUserImage();
			if(element!= null){	
					logger.log(LogStatus.PASS, "UserImgeIcon is present on application");  
			}
			else{
				logger.log(LogStatus.FAIL, "UserImgeIcon is not present on application");   
			}
		}
		
		public void enterOrganizationInRecycleBinSearchBox(String orgnization) throws Exception {
			MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
			element = PortfolioPF.getUser_searchbox();
			sendInputTextBoxWithLogger(element, "Orgnization recycle bin searchbox", orgnization,logger);	
			
		}
		
	// Create Organization
	public void create_orgnization() throws Exception
	{
	  
		correctLogin();
		String Organizationame=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		String Orgnizationlist_data_JSONPath = "$..Orgnizationdata.*";
		Orgnization_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Orgnizationlist_data_JSONPath);
        //Thread.sleep(1000);
		waitForSpinnerToDisappear();
		clickSetup_btn();
		waitForSpinnerToDisappear();
		clickCreatorganization_tab();
		waitForSpinnerToDisappear();
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Organization",Organizationame);
		enterPortfolioname(Organizationame);
		enterDateformat(Orgnization_datalist.get(0).toString());
		selectAccounttype(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminRole"));
		clickADD_organization_btn();
		//waitForSpinnerToDisappear();
		waitForOrgnizationSpinnerToDisappear();
		enterOrgnization_insearchbox(Organizationame);
		//Thread.sleep(1000);
		verifyOrgnizationpresent(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
	  
	}
	
		
	//*********************************** CREATER ADMIN ROLE ***********************************
	public void create_role() throws Exception 
	{
     
		correctLogin();
		waitForSpinnerToDisappear();
		String Orgnizationlist_data_JSONPath = "$..Orgnizationdata.*";
		//System.out.println("dir"+System.getProperty("user.dir"));
		Orgnization_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Orgnizationlist_data_JSONPath);
        String roleName = MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
        WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"SuperadminRole",roleName);
        String roleDescription = Orgnization_datalist.get(2); 
		Thread.sleep(1000);
		clickSetup_btn();
		waitForSpinnerToDisappear();
		
		clickCreatRole_tab();
		waitForSpinnerToDisappear();
		enterRole(roleName);
		enterDescription(roleDescription);
		clickOnAddBtn();
		waitForSpinnerToDisappear();
		enterRole_InSearchBox(roleName);
		verifySuperadminRolePresent(roleName);
		
		
	}
	
	public void clickAgreePopUp() throws Exception{
		Thread.sleep(10000);
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		List<WebElement>elements = PortfolioPF.getIAgreebtn();
		if(elements!=null && elements.size() >0){
			elements.get(0).click();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Clicked succesfully to I Agree button WebElement");  
		}else{
			logger.log(LogStatus.INFO, "I Agree button popup not present"); 
		}
	}

	//*********************************** DELETER ORGANIZATION ***********************************
	public void delete_orgnization() throws Exception
	{
		
		correctLogin();
        clickSetup_btn();
		waitForSpinnerToDisappear();
        clickCreatorganization_tab();
        waitForSpinnerToDisappear();
        enterOrgnization_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
        clickOrgnizationpresent();
		clickDeactivate_btn();
		//Thread.sleep(1000);enterOrgnization_insearchbox
		clickDeactivate_confirm_btn();
		//Thread.sleep(2000);
		waitForSpinnerToDisappear();
        clickRecyclebin();
		waitForSpinnerToDisappear();
		//select_pagesize();
		//Thread.sleep(1000);
		enterOrganizationInRecycleBinSearchBox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
		verifyOrgnizationpresentInRecylebin(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
		

	}
	
	//*********************************** ADMIN LOGIN ***********************************
	public void correctLogin() throws Exception{			
		//String Loginlistdata_JSONPath = "$..Logindata.*";
		//Login_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("loginFileLoc"), Loginlistdata_JSONPath);
		
		String superAdminCredentials_data = "$..SuperAdminCredentials.*";
		SuperAdmin_credentials = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), superAdminCredentials_data);
		String username = SuperAdmin_credentials.get(0).toString();
		String password = SuperAdmin_credentials.get(1).toString();
		
		enterUserID(username);
		enterPassword(password);
		clickSignIn_btn();
		System.out.println("Successfully Logged In");
		Thread.sleep(6000);
	} 
	
	
	public void correctLogin_admin() throws Exception{			
		String Userslistdata_JSONPath = "$..UserDetails.*";
		Login_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		enterUserID(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser"));
		//enterUserID("admin@mirvac");
		enterPassword(Login_datalist.get(0).toString());
		//enterPassword("123");
		clickSignIn_btn();		
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		Thread.sleep(4000);
		//System.out.println("Successfully Logged In");		
	} 
	
	public void correctLogin_SuperAdmin_withoutfacility_withagreepopup() throws Exception{			
		String Userslistdata_JSONPath = "$..UserDetails.*";
		Login_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		enterUserID(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser"));
		//enterUserID("admin@mirvac");
		enterPassword(Login_datalist.get(0).toString());
		//enterPassword("123");
		clickSignIn_btn();	
		clickAgreePopUp();
		waitForLoginUser();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		Thread.sleep(4000);
		//System.out.println("Successfully Logged In");		
	} 
	public void correctLogin_SuperAdmin_withoutfacility() throws Exception{			
		String Userslistdata_JSONPath = "$..UserDetails.*";
		Login_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		enterUserID(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..SuperadminUser"));
		//enterUserID("admin@mirvac");
		enterPassword(Login_datalist.get(0).toString());
		//enterPassword("123");
		clickSignIn_btn();	
		//clickAgreePopUp();
		waitForLoginUser();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		Thread.sleep(4000);
		//System.out.println("Successfully Logged In");		
	} 
	
	public void correctLogin_Admin_WithoutFacility() throws Exception{			
		String Userslistdata_JSONPath = "$..UserDetails.*";
		Login_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		enterUserID(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..AdminUser"));
		//enterUserID("admin@mirvac");
		enterPassword(Login_datalist.get(0).toString());
		//enterPassword("123");
		clickSignIn_btn();	
		//for i agrre poopup
		
		//clickAgreePopUp();
		waitForLoginUser();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		Thread.sleep(4000);
		//System.out.println("Successfully Logged In");		
	} 
	public void correctLogin_Admin_WithoutFacility_withagreepopup() throws Exception{			
		String Userslistdata_JSONPath = "$..UserDetails.*";
		Login_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Userslistdata_JSONPath);
		enterUserID(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..AdminUser"));
		//enterUserID("admin@mirvac");
		enterPassword(Login_datalist.get(0).toString());
		//enterPassword("123");
		clickSignIn_btn();	
		//for i agrre poopup
		clickAgreePopUp();
		//clickAgreePopUp();
		waitForLoginUser();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		Thread.sleep(4000);
		//System.out.println("Successfully Logged In");		
	} 
	
	public boolean verifySetup_btn_Enabled() throws Exception{
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		boolean verifySetup_btn_Enabled = false;
		element = PortfolioPF.getSetup();
		if(element!= null){
			if(element.isEnabled()){
				verifySetup_btn_Enabled = true;
				logger.log(LogStatus.PASS, "Verified Setup Is Enabled before clicking");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Setup Is NOT Enabled.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Setup Element returns NULL.");
		}
		return verifySetup_btn_Enabled;
	}
	public boolean verify_add_orgnization_btn_Enabled() throws Exception{
		MEMSCloud_PortfolioCreation_Page_Factory PortfolioPF = new MEMSCloud_PortfolioCreation_Page_Factory(driver,logger);
		boolean verify_add_orgnization_btn_Enabled = false;
		element = PortfolioPF.getAdd_organization_btn();
		if(element!= null){
			if(element.isEnabled()){
				verify_add_orgnization_btn_Enabled = true;
				logger.log(LogStatus.PASS, "Verified add orgnization btn Is Enabled before clicking");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified add orgnization btn Is NOT Enabled.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " add orgnization btn Element returns NULL.");
		}
		return verify_add_orgnization_btn_Enabled;
	}
	public static void selectByVisibleText(WebElement element, String text,ExtentTest logger) throws Exception {
		try {
			System.out.println("element "+element+"text "+text);
			new Select(element).selectByVisibleText(text);
			//System.out.println(text.toUpperCase()+" Option is Selected");
			logger.log(LogStatus.INFO, text.toUpperCase()+" Option is Selected");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
			throw new Exception("Element not found");
		}
	}
	public static void selectByVisibleTextWithFluentWait(WebElement element, String text) throws Exception {
		try {
			System.out.println("element "+element+"text "+text);
			new Select(element).selectByVisibleText(text);
			//System.out.println(text.toUpperCase()+" Option is Selected");
			logger.log(LogStatus.INFO, text.toUpperCase()+" Option is Selected");
		} catch (Exception e) {
			int i;
			for(i=0;i<4;i++){
				if(getSelectedOptionFromDropDown(element).equalsIgnoreCase(text)){
					logger.log(LogStatus.INFO, text.toUpperCase()+" after loop Option is Selected");
					break;
				}else{
					Thread.sleep(1000);
					System.out.println("waiting for role dropdown selection  "+i);
				}
			}
			if(i>=30){
				logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
			}
		}
	}
	//not working
	public static void waitForJSJQuery(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i=0;i<30;i++){
			System.out.println("out"+js.executeScript("return angular.element(document.body).injector().get(\'$http\').pendingRequests.length;"));
		if (js.executeScript("return angular.element(document.body).injector().get(\'$http\').pendingRequests.length;") == "0"){
			System.out.println("spinner complete");
			break;
		}else{
			try {
				Thread.sleep(1000);
				System.out.println("in delay");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

		
	}

	public static void waitForSpinnerToDisappear_temp()
	{
		
		
		/*
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.ignoring(NoSuchElementException.class);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		*/
		//WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
        //By spiner = By.id("loadingimage");
		
		By spiner = By.xpath("(//i[@id='loadingimage'][@class='fa fa-refresh fa-spin imageloader'])[2]");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
        System.out.println("temp Spinner executed invisibilty status"+fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner)));
        
        
	}
	public static void waitForSpinnerToDisappear() throws Exception
	{
		/*
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.ignoring(NoSuchElementException.class);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		*/
		//WebDriverWait wait =new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
        //By spiner = By.id("loadingimage");
		try{
	    Thread.sleep(2000);
		By spiner = By.xpath("(//i[@id='loadingimage'][@class='fa fa-refresh fa-spin imageloader'])[2]");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
        //System.out.println("Spinner executed status"+fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner)));
        //waitForSpinnerToDisappear_temp();
        Thread.sleep(2000);
		}catch(Exception e){
			logger.log(LogStatus.FAIL,   "Timeout exception on spinner");  
        	throw new Exception("Element not found");
		}
	}
	
	public static void waitForOrgnizationSpinnerToDisappear() throws Exception{
        //By spiner = By.id("loadingimage");
		try{
		Thread.sleep(4000);	
		By spiner = By.xpath("(//i[@id='loadingimage'][@class='fa fa-refresh fa-spin imageloader'])[2]");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(600, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
        Thread.sleep(4000);
		}catch(Exception e){
			logger.log(LogStatus.FAIL,   "Timeout exception on orgnization spinner");  
        	throw new Exception("Element not found");
		}
	}
	
	
	public static void waitForBaselineSpinnerToDisappear() throws Exception {
		try{
			Thread.sleep(2000);
        By spiner = By.id("loadingimage2");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
        Thread.sleep(2000);
		}catch(Exception e){
			logger.log(LogStatus.FAIL,   "Timeout exception on baseline spinner");  
        	throw new Exception("Element not found");
		}
  }
	public static void waitForPortfoilioLandingPageSpinnerToDisappear() throws Exception{
		try{
			Thread.sleep(2000);	
		for(int i=1;i<3;i++){
        By spiner = By.xpath("(//widget-loader/div/i[@class='fa fa-refresh fa-spin imageloader'])["+i+"]");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
        fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
		}
        waitForSpinnerToDisappear();
			Thread.sleep(4000);
		}catch(Exception e){
			logger.log(LogStatus.FAIL,   "Timeout exception on portfolio landingpage spinner");  
        	throw new Exception("Element not found");
		}
  }
	public static void waitForGenericSpinnerToDisappear(String Pagename) throws Exception
	{
		try{
		Thread.sleep(4000);	
		switch(Pagename.toLowerCase())
		{
		case "portfoliolandingpage":
			                    
								for(int i=1;i<3;i++)
								{
									By spiner = By.xpath("(//widget-loader/div/i[@class='fa fa-refresh fa-spin imageloader'])["+i+"]");
									Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
									fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
								}
								waitForSpinnerToDisappear();
			                    
			                    break;
			                      
		case "baselinepage":
		
											waitForBaselineSpinnerToDisappear();
											break;
		case "common":
							waitForSpinnerToDisappear();
							break;		
		case "equipmentconfigurationpage":	
											By spiner = By.xpath("//div[@id='imgloaderCreateEquip']/i[@id='loadingImgCreateEquip']");
											Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
											fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
											System.out.println("spinner executed");
											Thread.sleep(8000);
											System.out.println("spinner executed");
			                                break;
			                                
		case "constanttemplatepage":
            									By spinner=By.xpath("//div[@id='imgLoaderRules']//i[@id='loadingimage2']");
            									Wait<WebDriver> fluentWait1=new FluentWait<WebDriver>(driver).withTimeout(90,TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
            									fluentWait1.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
            									Thread.sleep(5000);
            									break;
		case "equipmentfaultrule":
            								By spinner1 = By.xpath("//div[@id='imgloaderMeter']//i[@id='loadingimage']");
            								Wait<WebDriver> fluentWait2 = new FluentWait<WebDriver>(driver).withTimeout(90, TimeUnit.SECONDS)
            										.pollingEvery(2, TimeUnit.SECONDS);
            								fluentWait2.until(ExpectedConditions.invisibilityOfElementLocated(spinner1));
            								Thread.sleep(8000);
            								break;


	    }
		Thread.sleep(2000);	
	  }catch(Exception e){
		logger.log(LogStatus.FAIL,   "Timeout exception on spinner");  
      	throw new Exception("Element not found");
	  }
  }
	
	public static String generateRandomalphabets(int length) throws Exception
	{
	    String aplhabets = "";
	    for (int i = 1 ; i <= length ; i++)
	    {
	       aplhabets += (char)(Math.random() * ('Z' - 'A' + 1) + 'A');
	    }
	    //System.out.println("Random Alpbahbets is "+aplhabets);
	    return aplhabets;
	}
	
	 //To Select the specified textfrom the drop Down
	  public static void selectByDesiredIndex(WebElement element, int index,ExtentTest logger) throws Exception {
	        try {
	               System.out.println("element "+element+"index "+index);
	               new Select(element).selectByIndex(index);
	               System.out.println("Option No."+index+" is Selected");
	               logger.log(LogStatus.INFO, "Option No."+index+" is Selected");
	        } catch (Exception e) {
	               logger.log(LogStatus.FAIL, "Unable to select the Desired Option");
	             	throw new Exception("Element not found");
	        }
	  }
	//To get all the Values under a dropdown 
	  public static List<String> getAllOptions(WebElement element) throws Exception{
	      List<String> options = new ArrayList<String>();
	      for (WebElement option : new Select(element).getOptions()) {
	          String txt = option.getText();
	          if (option.getAttribute("value") != "") options.add(option.getText());
	      }
	      return options;
	  }
	  
	  //Get Selected Option From DropDown
	  public static String getSelectedOptionFromDropDown(WebElement element) throws Exception{
	    
	        Select sel_element_Val = new Select(element);
	        String element_Val_text = sel_element_Val.getFirstSelectedOption().getText();
	        return element_Val_text;
	  }
	  /*
	   * 
	   * 
	   */
	//to check whether textbox is blank or not
	  public static boolean checkBlankTextbox(WebElement element) throws Exception{
	      boolean checkobox_status=false;
	      if((element.getAttribute("value").equalsIgnoreCase(""))){
	    	  checkobox_status=true;
	      }
	      return checkobox_status;
	  }
	//to check whether textbox is blank or not
	  public static void checkBlankTextboxWithLogger(WebElement element,String Message,ExtentTest logger) throws Exception{
	      boolean checkobox_status=false;
	      if((element.getAttribute("value").equalsIgnoreCase(""))){
	    	  logger.log(LogStatus.PASS, Message+" textbox is cleared succesfully"); 
	      }else{
	    	  logger.log(LogStatus.FAIL, Message+" textbox is not cleared"); 
	    	  throw new Exception("Element not found");
	      }
	     
	  }
	  
	//to check whether specified dropdown value is present in dropdown or not
	  public static boolean checkDropDownOptionsValue(WebElement element,String dropdownvalue_string) throws Exception{
		  List<String> expecteddropdownvalue=new ArrayList<String>();
		  expecteddropdownvalue.add(dropdownvalue_string);
		  return getAllOptions(element).containsAll(expecteddropdownvalue);
	  }

	  //navigate to url
	  public static void Navigate_to_url(String url) throws Exception{
			driver.get(url);
			
		}
	  
	  /**
	   * 
	   * @param element
	   * @param Message 
	   * @param text
	   * @param logger
	   * @throws Exception
	   */
	  //select dropdown using visible text with logger
	  public static void selectDropDownWithLogger(WebElement element,String Message,String text,ExtentTest logger) throws Exception{
		  if(element!= null){
			  if((element.isDisplayed()) && (element.isEnabled())){
			  if(checkDropDownOptionsValue(element, text)){
				selectByVisibleText(element, text,logger);//accessfrom common methods
				logger.log(LogStatus.PASS, Message+" Entered succesfully to "+ Message+" WebElement");  
			  }else{
				  logger.log(LogStatus.FAIL, "Specified dropdown value is not present in dropdown"); 
				  throw new Exception("Element not found");
			  }
			}
		}
		else{
			logger.log(LogStatus.FAIL, Message+" WebElement for "+Message+" Field Failed"); 
			throw new Exception("Element not found");
		}  
	  }
	  //send input to the textbox with logger
	  public static void sendInputTextBoxWithLogger(WebElement element,String Message,String text,ExtentTest logger) throws Exception{
		  if(element!= null){
				if((element.isDisplayed()) && (element.isEnabled())){
					element.clear();
					WebInputTextBox.SendInputTextBox(driver, element, text);
					logger.log(LogStatus.PASS, Message+ " Entered succesfully to "+Message+ "WebElement");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, "Identifying WebElement for "+Message+" Field Failed");  
				throw new Exception("Element not found");
			}
	  }
	  //click to element  with logger
	  public static void clickWithLogger(WebElement element,String Message,ExtentTest logger) throws Exception{
		  if(element!= null){
			  if((element.isDisplayed()) && (element.isEnabled())){
					element.click();				
					logger.log(LogStatus.PASS, Message+" clicked succesfully.");  
				}
			}
			else{
				logger.log(LogStatus.FAIL, Message+" WebElement identification failed");  
				throw new Exception("Element not found");
			}
	  }
	  //check whether dropdown is blank or not //as per MEMS cloud as such
	  public static void checkDropdownBlankOrNot(WebElement element,String Message,ExtentTest logger) throws Exception{
		  if(MEMSCloud_Orgnization_Action.getSelectedOptionFromDropDown(element).contains("Select")){
				logger.log(LogStatus.PASS, Message+" dropdown is cleared successfully"); 
			}else{
				logger.log(LogStatus.FAIL, Message+" dropdown is not cleared");
				throw new Exception("Element not found");
			}
	  }
	  
	  
	  
	  public static void checkElementPresent(String elementName, List<WebElement> elements, String functionalityMsgName) throws Exception {
          try {

              if (elements.size() > 0) {
                   elements.get(0).click();
                   logger.log(LogStatus.PASS, functionalityMsgName + elementName + " is present in grid");
              } else {
                   logger.log(LogStatus.FAIL, functionalityMsgName + elementName + " is not present in grid");
              }
          } catch (Exception e) {
              logger.log(LogStatus.FAIL, new String("Error Message for is : "+e.getMessage())); 
              throw new Exception("Element not found");
          }
     }
     
     public static void checkElementNotPresent(String elementName, List<WebElement> elements,String functionalityMsgName) throws Exception
     {
          try
          {
              if(elements.size() > 0)
              {
                   logger.log(LogStatus.FAIL, functionalityMsgName + elementName + " is  present in grid");
              }
              else
              {
                   logger.log(LogStatus.PASS, functionalityMsgName + elementName + " is not present in grid");
              }
              
          }catch(Exception e)
          {
              logger.log(LogStatus.FAIL, new String("Error Message for is : "+e.getMessage())); 
              throw new Exception("Element not found");
          }
     }
     
     
     public static void dragAndDrop(WebElement sourceLocation,WebElement destinationLocation,String elementName ) throws Exception
     {
          try {
              (new Actions(driver)).dragAndDrop(sourceLocation, destinationLocation).perform();
              
              
              logger.log(LogStatus.PASS, elementName+" is draged and dropped");
          } catch (Exception e) {
              logger.log(LogStatus.FAIL, new String("Error Message for is : " + e.getMessage()));
              throw new Exception("error while performaing drag and drop");
          }
     }
     
     
     public static void alertWindowHandle() throws Exception{

         
          Alert alert = driver.switchTo().alert();

          String data=alert.getText();

          alert.accept();
          
          logger.log(LogStatus.PASS, data+" alert clicked Successfully");
          
          
     }

     public static boolean checkClearOrNotMultipleCheckbox(WebElement element, String elementName) {

         if ((element.getText().contains("Select"))) {
             logger.log(LogStatus.PASS, elementName + " is empty with no check Boxes checked");
             return true;
         }
         return false;

    }

	  
	  public void clickLicenseTab() throws Exception {
		
		MEMSCloud_OrganizationLicence OrgLic = new MEMSCloud_OrganizationLicence(driver,logger);
		element = OrgLic.getLicence();
		if(element!= null){
			if(element.isDisplayed()){
				element.click();
				Thread.sleep(10000);
				logger.log(LogStatus.PASS, "Licence Tab selected succesfully.");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Licence WebElement Failed"); 
			throw new Exception("Element not found");
		}
	}
	
	public void selectOrganization() throws Exception {
		Thread.sleep(3000);
		MEMSCloud_OrganizationLicence OrgLic = new MEMSCloud_OrganizationLicence(driver,logger);
		element = OrgLic.getorgDpd();
		if(element!= null){
				Thread.sleep(2000);
			    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				selectByVisibleText(element, ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"),logger);
				 MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				 Thread.sleep(3000);
				logger.log(LogStatus.PASS, "Organization drop down  selected succesfully.");  
		}
		else{
			logger.log(LogStatus.FAIL, "Organization drop down WebElement Failed.");   
			throw new Exception("Element not found");
		}
		}

	public void selectLicenseType(String License_type) throws Exception {
		Thread.sleep(2000);
		MEMSCloud_OrganizationLicence OrgLic = new MEMSCloud_OrganizationLicence(driver,logger);
		element = OrgLic.getlicenseType();
		if(element!= null){
				//selectByVisibleText(element, "Enterprise30");
				selectByVisibleText(element, License_type,logger);
				Thread.sleep(3000);
				logger.log(LogStatus.PASS, "license Type drop down selected succesfully.");  
		}
		else{
			logger.log(LogStatus.FAIL, "license Type drop down WebElement Failed.");   
		}
	}
	
	public void selectDuration(String duration) throws Exception {
		Thread.sleep(2000);
		MEMSCloud_OrganizationLicence OrgLic = new MEMSCloud_OrganizationLicence(driver,logger);
		element = OrgLic.getDuration();
		if(element!= null){
				//selectByVisibleText(element, "1 Year");
				selectByVisibleText(element, duration,logger);
				Thread.sleep(3000);
				logger.log(LogStatus.PASS, "Duration drop down selected succesfully.");  
		}
		else{
			logger.log(LogStatus.FAIL, "Duration drop down WebElement Failed.");   
		}
		
	}
	
	
	public void clickOnSaveButton() throws Exception {
		Thread.sleep(4000);
		MEMSCloud_OrganizationLicence OrgLic = new MEMSCloud_OrganizationLicence(driver,logger);
		element = OrgLic.getsaveLic();
		if(element!= null){
			if(element.isDisplayed()){				
				element.click();
				Thread.sleep(4000);
				logger.log(LogStatus.PASS, "license save succesfully.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, "license save WebElement Failed.");   
		}
	}
		public void selectChannel(String channelname) throws Exception {
				MEMSCloud_OrganizationLicence OrgLic = new MEMSCloud_OrganizationLicence(driver, logger);
				element = OrgLic.getChannel();
				if (element != null) {
					waitForSpinnerToDisappear();
					//selectByVisibleText(element, "Metasys");
					selectByVisibleText(element, channelname,logger);
					waitForSpinnerToDisappear();
					logger.log(LogStatus.PASS, "license Type drop down selected succesfully.");
				} else {
					logger.log(LogStatus.FAIL, "license Type drop down WebElement Failed.");
				}
			} 

			
			
		
	/**
	 * @throws Exception 
	 * @
	 * 
	 */
	public void get_orgnization_Licence() throws Exception {
		
			String Orgnizationlist_data_JSONPath = "$..Orgnizationdata.*";
					Orgnization_datalist = ReadJsonFile.readJsonFileDynamic(
							ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"),
							Orgnizationlist_data_JSONPath);
					
					String License_type = Orgnization_datalist.get(3);
					String duration = Orgnization_datalist.get(4);
					String channelname = Orgnization_datalist.get(5);
					correctLogin();
					waitForSpinnerToDisappear();
					clickSetup_btn();
					waitForSpinnerToDisappear();
					clickLicenseTab();
					waitForSpinnerToDisappear();
					selectOrganization();
					System.out.println("select org executed");
					selectChannel(channelname);
					selectLicenseType(License_type);
					waitForSpinnerToDisappear();
					selectDuration(duration);
					waitForSpinnerToDisappear();
					clickOnSaveButton();
					System.out.println("save button executed");
					waitForSpinnerToDisappear();
					enterOrgnization_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization"));
					waitForSpinnerToDisappear();
					verifyOrgnizationpresentInLicenseGrid(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization")); 
			 
	
	
}
	/**
	 * 
	 * 
	 */
	
}