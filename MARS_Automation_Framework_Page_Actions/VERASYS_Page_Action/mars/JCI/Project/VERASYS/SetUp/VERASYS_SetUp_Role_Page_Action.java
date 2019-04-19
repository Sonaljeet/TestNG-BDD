package mars.JCI.Project.VERASYS.SetUp;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebInputTextBox;
import mars.Component.Functions.BaseClass;

public class VERASYS_SetUp_Role_Page_Action {

	/** The Selenium driver. */
	public WebDriver driver;

	/** The ExtentTest logger. */
	private ExtentTest logger;

	/** The WebElement/Locator element. */
	private WebElement element;

	/**
	 * Instantiates/Constructor a new Verasys Site page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
*/
	public VERASYS_SetUp_Role_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	} 

	/**
	 * Click on User's tab
	 * @param none
	 * @return none
	 */

	public void clickUserTab(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getUserTab();
		if(element!=null){
			element.click();
			logger.log(LogStatus.PASS, "Successfully clicked on User's Tab");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for User's Tab failed.");
		}
	}

	/**
	 * Click on Role tab
	 * @param none
	 * @return none
	 */
	public void clickRoleTab(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getRoleTab();
		if(element!=null){
			element.click();
			logger.log(LogStatus.PASS, "Successfully clicked on Role's tab");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Role's Tab failed.");
		}
	}

	/**
	 * Enter Role Name
	 * @param Role Name
	 * @return none
	 */
	public void enterRoleName(String roleName){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getRoleName();
		if(element!=null){
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, roleName);
			logger.log(LogStatus.PASS, "Successfully entered Role name as: "+roleName);
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Role Name failed.");
		}
	}
	
	/**
	 * Enter Role Description
	 * @param Role Description
	 * @return none
	 */
	public void enterRoleDesc(String description){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getRoleDescription();
		if(element!=null){
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, description);
			logger.log(LogStatus.PASS, "Successfully entered description");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for description failed.");
		}
	}
	
	/**
	 * Enter Role Name in search box
	 * @param Role Name
	 * @return none
	 * @throws IOException 
	 */
	public void searchRoleName(String roleName) throws IOException{
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		VERASYS_Setup_Customer_Page_Action customerPA =new VERASYS_Setup_Customer_Page_Action(driver,logger);
		element=role.getSearchRole();
		if(element!=null){
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, roleName);
			logger.log(LogStatus.PASS, "Successfully entered Role Name in Search box");
			//element.sendKeys(Keys.ENTER);
			element=customerPA.searchGrid(roleName);
			element.click();	
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for searching Role name failed.");
		}
	}
	
	/**
	 * Enter Role Description in search box
	 * @param Role Description
	 * @return none
	 * @throws IOException 
	 */
	public void searchRoleDesc(String description) throws IOException{
		VERASYS_Setup_Customer_Page_Action customerPA =new VERASYS_Setup_Customer_Page_Action(driver,logger);
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getSearchDescription();
		if(element!=null){
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, description);
			logger.log(LogStatus.PASS, "Successfully entered Role Description in Search box");
			element=customerPA.searchGrid(description);
			//element.sendKeys(Keys.ENTER);
		
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for searching Role description failed.");
		}
	}
	
	/**
	 * Click Add
	 * @param None
	 * @return none
	 */
	public void clickAdd(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getAddBtn();
		if(element!=null){
		element.click();
		logger.log(LogStatus.PASS, "Successfully Clicked on Add Button");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Add Button failed.");
		}
	}
	
	/**
	 * Click Update
	 * @param None
	 * @return none
	 */
	public void clickUpdate(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getUpdateBtn();
		if(element!=null){
		element.click();
		logger.log(LogStatus.PASS, "Successfully Clicked on Update Button");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Update Button failed.");
		}
	}
	
	/**
	 * Click Delete
	 * @param None
	 * @return none
	 */
	public void clickDelete(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getDeleteBtn();
		if(element!=null){
		element.click();
		logger.log(LogStatus.PASS, "Successfully Clicked on Delete Button");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Delete Button failed.");
		}
	}
	
	/**
	 * Click Cancel
	 * @param None
	 * @return none
	 */
	public void clickCancel(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getCancelBtn();
		if(element!=null){
			if(element.isEnabled()){
		element.click();
		logger.log(LogStatus.PASS, "Successfully Clicked on Cancel Button");
			}else{
				logger.log(LogStatus.PASS, "Verified Cancel Button is disabled");
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Cancel Button failed.");
		}
	}
	
	/**
	 * Click Ok button on Confirmation Message on Delete role
	 * @param None
	 * @return none
	 */
	public void clickOkBtn(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getOKBtnCnf();
		if(element!=null){
		element.click();
		logger.log(LogStatus.PASS, "Successfully verified confirmation message is displayed and Clicked on Ok Button while deleting role");
		}else{
			logger.log(LogStatus.FAIL, "Verified Confirmation Message is not displayed");
		}
	}
	
	/**
	 * Click No button on Confirmation Message on Delete role
	 * @param None
	 * @return none
	 */
	public void clickNoBtn(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getNOBtnCnf();
		if(element!=null){
		element.click();
		logger.log(LogStatus.PASS, "Successfully verified confirmation message is displayed and Clicked on No Button while deleting role");
		}else{
			logger.log(LogStatus.FAIL, "Verified Confirmation Message is not displayed");
		}
	}
	
	/**
	 * Verify Role Name field disabled
	 * @param None
	 * @return none
	 */
	public void verifyRoleName(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getRoleName();
		if(element!=null){
		if(!element.isEnabled()){
			logger.log(LogStatus.PASS, "Successfully verified role name field is disabled");
		}else{
			logger.log(LogStatus.FAIL, "Role name field is enabled");
		}
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for role name failed.");
		}
	}
	
	
	/**
	 * Verify Add button is disabled
	 * @param None
	 * @return none
	 */
	public void verifyAddBtn(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getAddBtn();
		if(element!=null){
		if(!element.isEnabled()){
			logger.log(LogStatus.PASS, "Successfully verified Add button is disabled");
		}else{
			logger.log(LogStatus.FAIL, "Add Button is enabled");
		}
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Add button failed.");
		}
	}
	
	/**
	 * Verify Text in Role Name Field
	 * @param None
	 * @return none
	 */
	public boolean verifyRoleNameText(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getRoleName();
		if(element.isEnabled()){
		if(element.getText().isEmpty()){
			logger.log(LogStatus.PASS, "Successfully verified Role Name Text Field is Empty");
			return true;
		}else{
			logger.log(LogStatus.FAIL, "Role Name Text Field is Not Empty");
			
		}
		}else{
			logger.log(LogStatus.FAIL, "Role Name field is disabled");
		}
		return false;
	}
	
	/**
	 * Verify Text in Description Field
	 * @param None
	 * @return none
	 */
	public void verifyDescriptionText(){
		VERASYS_SetUp_Role_Page_Factory role=new VERASYS_SetUp_Role_Page_Factory(driver);
		element=role.getRoleDescription();
		if(element.isEnabled()){
		if(element.getText().isEmpty()){
			logger.log(LogStatus.PASS, "Successfully verified Description Text Field is Empty");
		}else{
			logger.log(LogStatus.FAIL, "Description Text Field is Not Empty");
		}
		}else{
			logger.log(LogStatus.FAIL, "Role Description is disabled.");
		}
	}
	
	/**
	 * Create Role using JCI Admin User
	 * @param Role Name, Role Description
	 * @param Boolean
	 * @throws IOException 
	 */
	
	public boolean creatNewRole(String roleName,String roleDescription) throws IOException
	{
		VERASYS_Setup_Customer_Page_Action customerPA =new VERASYS_Setup_Customer_Page_Action(driver,logger);
		clickUserTab();
		clickRoleTab();
		enterRoleName(roleName);
		enterRoleDesc(roleDescription);
		clickAdd();
		String toasterMsg=customerPA.verifyMessage();
		BaseClass.getScreenShot(driver, "Role added successfully", logger);
		if(toasterMsg.contains("Role added successfully"))
		{
			logger.log(LogStatus.PASS, "Alert message for Role creation captured successfully as"+toasterMsg);  
			return true;
		}
		return false;
	}
	
	/**
	 * Update Role using JCI Admin User
	 * @param Role Name, Updated Role Description
	 * @param Boolean
	 * @throws IOException 
	 */
	
	public boolean updateNewRole(String roleName,String roleDescription) throws IOException
	{
		VERASYS_Setup_Customer_Page_Action customerPA =new VERASYS_Setup_Customer_Page_Action(driver,logger);
		clickUserTab();
		clickRoleTab();
		searchRoleName(roleName);
		verifyRoleName();
		enterRoleDesc("Updated"+roleDescription);
		verifyAddBtn();
		clickUpdate();
		String toasterMsg=customerPA.verifyMessage();
		BaseClass.getScreenShot(driver, "Role edited successfully", logger);
		if(toasterMsg.contains("Role edited successfully"))
		{
			logger.log(LogStatus.PASS, "Alert message for Role edition captured successfully");  
			searchRoleDesc("Updated"+roleDescription);
			return true;
		}
		return false;
	}
	
	/**
	 * Delete Role using JCI Admin User
	 * @param Role Name
	 * @param Boolean
	 * @throws IOException 
	 */
	
	public boolean deleteNewRole(String roleName) throws IOException
	{
		VERASYS_Setup_Customer_Page_Action customerPA =new VERASYS_Setup_Customer_Page_Action(driver,logger);
		clickUserTab();
		clickRoleTab();
		searchRoleName(roleName);
		verifyRoleName();
		verifyAddBtn();
		clickDelete();
		clickNoBtn();
		BaseClass.getScreenShot(driver, "Clicked No on delete Role", logger);
		searchRoleName(roleName);
		clickDelete();
		clickOkBtn();
		String toasterMsg=customerPA.verifyMessage();
		BaseClass.getScreenShot(driver, "Role deleted successfully", logger);
		if(toasterMsg.contains("Role deleted successfully"))
		{
			logger.log(LogStatus.PASS, "Alert message for Role deletion captured successfully");  
			return true;
		}
		return false;
	}
	
	/**
	 * Cancel 
	 * @param Role Name, description
	 * @param Boolean
	 * @throws IOException 
	 */
	
	public boolean verifyCancel(String roleName,String description) throws IOException
	{
		clickUserTab();
		clickRoleTab();
		enterRoleName(roleName);
		enterRoleDesc(description);
		clickCancel();
		if(verifyRoleNameText())
		{
		verifyDescriptionText();
		logger.log(LogStatus.PASS, "Text entered is cleared on Cancel click");  
		}else{
			logger.log(LogStatus.FAIL, "Text entered is NOT cleared on Cancel click");  
		}
		
		searchRoleName(roleName);
		clickCancel();
		if(verifyRoleNameText())
		{
		verifyDescriptionText();
		logger.log(LogStatus.PASS, "Text entered is cleared on Cancel click after searching");  
		return true;
		}else{
			logger.log(LogStatus.FAIL, "Text entered is NOT cleared on Cancel click after searching");  
		}
		
		return false;
	}
}
