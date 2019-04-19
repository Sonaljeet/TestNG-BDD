package mars.JCI.Project.DES.UsersRole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebDropDown;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.JCI.Project.DES.CustomerSetup.DES_CustomerSetup_Page_Action;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.Users_Role.DES_USERS_Role_Page_Factory;
import mars.JCI.Project.DES.Users_RolesAndRight.DES_USERS_RolesAndRight_Page_Factory;

public class DES_UsersRole_Page_Action {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element = null;
	private static DES_USERS_Role_Page_Factory rolePF = null;
	private static DES_USERS_RolesAndRight_Page_Factory roleRightPF=null;
	private static DES_Home_Page_Action homePA=null;
	private static DES_Login_Page_Action loginPA=null;
	
	private static String roleName = null;
	public String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";

	public DES_UsersRole_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		rolePF = new DES_USERS_Role_Page_Factory(driver, logger);
		roleRightPF=new DES_USERS_RolesAndRight_Page_Factory(driver, logger);
		homePA= new DES_Home_Page_Action(driver, logger);
		loginPA= new DES_Login_Page_Action(driver, logger);
	}

	public static String generateRandomalphabets(int length)
	{
	    String aplhabets = "";
	    for (int i = 1 ; i <= length ; i++)
	    {
	       aplhabets += (char)(Math.random() * ('Z' - 'A' + 1) + 'A');
	    }
	    //System.out.println("Random Alpbahbets is "+aplhabets);
	    return aplhabets;
	}
	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingConfiguration");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}

	public static String getValidationMessageFromGroupPage() {
		String Message = null;
		element = rolePF.getRoleSuccessMessage();
		if (element != null) {
			Message = element.getText();
			System.out.println(Message + " Message From The Page");
			logger.log(LogStatus.PASS, "\"" + Message + "\" Message Recieved from Page");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Get the Message from Page");
		}
		return Message;
	}

	public static void navigateToUsersRolePage() {
		try {
			//loginPA.DES_CorrectLogin();
			waitForSpinnerToDisappear();
			homePA.navigateToSetupPage();
			waitForSpinnerToDisappear();
			element = rolePF.getusersTab();
			if (element != null) {
				element.click();
				waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Navigate to " + element.getText());
				element = rolePF.getroleTab();
				if (element != null) {
					waitForSpinnerToDisappear();
					logger.log(LogStatus.PASS, element.getText() + " Tab is present on the Users tab");
				}
				waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Successfully navigate to " + element.getText() + " Tab");
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Navigate to " + element.getText());
		}
	}

	public static String enterRoleName(String role) {
		element = rolePF.getroleNameTextbox();
		if (element != null) {
			element.clear();
			
			WebInputTextBox.SendInputTextBox(driver, element, role);
			logger.log(LogStatus.PASS, "\"" + role + "\" entered sucessfully in Role Name field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Role Name field");
		}
		return role;
	}

	public static String enterRoleDescription(String roleDescription) {
		element = rolePF.getroledescriptionTextbox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, roleDescription);
			logger.log(LogStatus.PASS, "\"" + roleDescription + "\" entered sucessfully in Description  field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Description  field");
		}
		return roleDescription;

	}
	public static void clickOnAddButton(){
		element = rolePF.getAddbtn();
		if(element!=null){
			waitForSpinnerToDisappear();
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked to Add button");
		}
		else{
			logger.log(LogStatus.FAIL, "Failled to Click Add button");
		}
	}

	public void clickOnUpdateButton(){
		element = rolePF.getUpdatebtn();
		if(element!=null){
			waitForSpinnerToDisappear();
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked to Update button");
		}
		else{
			logger.log(LogStatus.FAIL, "Failled to Click Update button");
		}
	}
	
	public void clickOnDeleteButton(){
		element = rolePF.getDeletebtn();
		if(element!=null){
			waitForSpinnerToDisappear();
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			element=rolePF.getpopup_ok();
			if(element!=null){
				waitForSpinnerToDisappear();
				element.click();
			}
			waitForSpinnerToDisappear();
			getValidationMessageFromGroupPage();
			logger.log(LogStatus.PASS, "Clicked to Delete button");
		}
		else{
			logger.log(LogStatus.FAIL, "Failled to Click Delete button");
		}
	}
	
	
	
	public void clickOnClearButton(){
		element = rolePF.getClearbtn();
		if(element!=null){
			waitForSpinnerToDisappear();
			WebButton.Button_Click(driver, element);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked to Clear button");
		}
		else{
			logger.log(LogStatus.FAIL, "Failled to Click Clear button");
		}
	}
	
	
	public static String enterRoleName() {
		roleName = generateRandomalphabets(6); //DES_CustomerSetup_Page_Action.generateRandomString(new Random(), "DESRole", 5);
		enterRoleName(roleName);
		return roleName;
	}

	public String addRole() {
		try {
			navigateToUsersRolePage();
			String roleDescr = generateRandomalphabets(6);
			String roleAdded= enterRoleName();
			enterRoleDescription(roleDescr);
			WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"),"Role_Name",roleAdded );
			logger.log(LogStatus.PASS, " Added the Role "+ roleAdded +" With Description as "+ roleDescr);
			waitForSpinnerToDisappear();
			clickOnAddButton();
			waitForSpinnerToDisappear();
			//getValidationMessageFromGroupPage();
			logger.log(LogStatus.PASS, "Successfully Added Role "+roleAdded+" to System");
			
		} catch (Exception e) {
			logger.log(LogStatus.FAIL,e.getMessage());

		}
		return roleName;
	}
	
	public void UpdateRole(){
		try {
			String roleName= addRole();
			waitForSpinnerToDisappear();
			element=rolePF.getroleSeachTextbox();
			if(element!=null){
				waitForSpinnerToDisappear();
				element.clear();
				element.sendKeys(roleName);
				waitForSpinnerToDisappear();
				WebElement roleAdded=driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope'][text()='"+roleName+"']"));
				roleAdded.click();
				waitForSpinnerToDisappear();
				enterRoleDescription(roleName+" Updated ");
				element=rolePF.getUpdatebtn();
				if(element!=null){
					waitForSpinnerToDisappear();
					clickOnUpdateButton();
					waitForSpinnerToDisappear();
					getValidationMessageFromGroupPage();
					}
			}
			logger.log(LogStatus.PASS, "Successfully Update Role to System");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.log(LogStatus.FAIL, "Could not Update the Role to System");

		}
	}
	
	public void deleteRole(){
		
		try{
			String roleName= addRole();
			waitForSpinnerToDisappear();
			element=rolePF.getroleSeachTextbox();
		if(element!=null){
			waitForSpinnerToDisappear();
			element.clear();
			element.sendKeys(roleName);
			waitForSpinnerToDisappear();
			WebElement roleAdded=driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope'][text()='"+roleName+"']"));
			roleAdded.click();
			waitForSpinnerToDisappear();
			clickOnDeleteButton();
			waitForSpinnerToDisappear();
			getValidationMessageFromGroupPage();
			logger.log(LogStatus.PASS, "Deleted the role "+roleName);
		}
		}catch (Exception e){
			logger.log(LogStatus.FAIL, "Could not Delete the role ");
		}
	}
	
	public void verifyRoleAvailabilityOnMultiplePages(){
		try{
			String roleName= addRole();
			waitForSpinnerToDisappear();
			element=roleRightPF.getroleandrighttab();
			if(element!=null){
				element.click();
				waitForSpinnerToDisappear();
				element=roleRightPF.getrolenamedropdown();
				if(element!=null){
					waitForSpinnerToDisappear();
					WebDropDown.SelectElementByVisibleText(element, roleName);
				waitForSpinnerToDisappear();
				element=roleRightPF.getrolerightSavebtn();
				if(element!=null){
					element.click();
					waitForSpinnerToDisappear();
					
					logger.log(LogStatus.PASS, "Verified that the roles added on Role page is present on Roles & Right Page");
				}}
			}
			
		}
		catch (Exception e){
			logger.log(LogStatus.FAIL, "Could not verify the role on Roles & Right page");
		}
		
	}
	
	public void verifyClearButton(){
		try{
		navigateToUsersRolePage();
		enterRoleName();
		enterRoleDescription(roleName);
		clickOnClearButton();
		element=rolePF.getroleNameTextbox();
		if(element!=null){
			String roleName1=element.getText();
			System.out.println( "Role Name textbox contains "+roleName1);
		
		element=rolePF.getroledescriptionTextbox();
		if(element!=null){
			String description1=element.getText();
			System.out.println("Role Description textbox contains "+ description1);
		}}
		
		logger.log(LogStatus.PASS, "Both field get cleared on selection of clear button");
		}
		catch(Exception e){
			logger.log(LogStatus.FAIL, "Could not clear fields using Clear button");
		}

		}
	
}
