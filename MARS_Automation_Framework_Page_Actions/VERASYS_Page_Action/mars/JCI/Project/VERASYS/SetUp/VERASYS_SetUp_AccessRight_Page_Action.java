package mars.JCI.Project.VERASYS.SetUp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;
import commonFunctions.WebTable;

public class VERASYS_SetUp_AccessRight_Page_Action {
	/** The Selenium driver. */
	public WebDriver driver;

	/** The ExtentTest logger. */
	private ExtentTest logger;

	/** The WebElement/Locator element. */
	private WebElement element;

	/**
	 * Instantiates/Constructor a new Verasys Access right page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
*/
	
	public VERASYS_SetUp_AccessRight_Page_Action(WebDriver driver,ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
	}
	
	/**
	 * Click on Access right tab
	 * @param none
	 * @return none
	 */
	public void clickAccessTab(){
		VERASYS_SetUp_AccessRight_Page_Factory accessPF= new  VERASYS_SetUp_AccessRight_Page_Factory(driver);
		element=accessPF.getAccessTab();
		if(element!=null){
			element.click();
			logger.log(LogStatus.PASS, "Successfully clicked on Access Right's tab");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Access Right's Tab failed.");
		}
	}

	public void selectRole(String roleName){
		VERASYS_SetUp_AccessRight_Page_Factory accessPF= new  VERASYS_SetUp_AccessRight_Page_Factory(driver);
		element=accessPF.getRoleName();
		if(element!=null){
			WebDropDown.SelectElementByVisibleText(element, roleName);
			logger.log(LogStatus.PASS, "Successfully selected role as: "+roleName);
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Role Name failed.");
		}
	}
	
	/*
	 * to verfiy role field is empty
	 */
	public boolean verifyRoleField(){
		VERASYS_SetUp_AccessRight_Page_Factory accessPF= new  VERASYS_SetUp_AccessRight_Page_Factory(driver);
		element=accessPF.getRoleName();
		if(element!=null){
			Select select=new Select(element);
			if(!select.getFirstSelectedOption().toString().contains("Select Role")){
			logger.log(LogStatus.PASS, "Successfully verified role name field is cleared");
			return true;
			}else{
				logger.log(LogStatus.FAIL, "Role name field is till populated");
			}
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Role Name failed.");
		}
		return false;
	}
	
	public void clickAccess(HashMap<String,String>permission){
		VERASYS_SetUp_AccessRight_Page_Factory accessPF= new  VERASYS_SetUp_AccessRight_Page_Factory(driver);
		element=accessPF.getAccessTable();
		if(element!=null){
			java.util.Iterator<Entry<String, String>> it= permission.entrySet().iterator();
			while(it.hasNext()){
				Entry<String, String> pair = it.next();
				element=accessPF.getAccessTable();
			element=SearchAndReturnRowElement(element,pair.getKey());
			if(pair.getValue().equalsIgnoreCase("View")){
				element=element.findElement(By.cssSelector("input[automation-id='AccessRightViewCheck']"));
				element.click();
				logger.log(LogStatus.PASS, "Successfully Clicked on view permission for "+pair.getKey());
			}else if(pair.getValue().equalsIgnoreCase("Edit")){
			//	System.out.println(element.getAttribute("textContent"));
				element=element.findElement(By.cssSelector("input[automation-id='AccessRightEditCheck']"));
				element.click();
				logger.log(LogStatus.PASS, "Successfully Clicked on Edit permission for "+pair.getKey());
			}else{
				logger.log(LogStatus.FAIL, "No permission mentioned for "+pair.getKey());
			}
		}
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Access table failed.");
		}
	}
	
	/**
	 * Click Save
	 * @param None
	 * @return none
	 */
	public void clickSave(){
		VERASYS_SetUp_AccessRight_Page_Factory accessPF= new  VERASYS_SetUp_AccessRight_Page_Factory(driver);
		element=accessPF.getsaveBtn();
		if(element!=null){
		element.click();
		logger.log(LogStatus.PASS, "Successfully Clicked on Save Button");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Save Button failed.");
		}
	}
	
	/**
	 * Click Cancel
	 * @param None
	 * @return none
	 */
	public void clickCancel(){
		VERASYS_SetUp_AccessRight_Page_Factory accessPF= new  VERASYS_SetUp_AccessRight_Page_Factory(driver);
		element=accessPF.getcancelBtn();
		if(element.isEnabled()){
			WebDriverWait wait= new WebDriverWait(driver,5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		logger.log(LogStatus.PASS, "Successfully Clicked on Cancel Button");
		}else{
			logger.log(LogStatus.FAIL, "Identifying webelement for Cancel Button failed.");
		}
	}
	
	/**
	 * Search and return row element by name.
	 *
	 * @param tableElement the table element
	 * @param textToSearch the text to search
	 * @return the web element
	 * NOTE: This method will work only when the WebElement has text visible on UI.
	 * If there is no text visible on UI, NULL will be returned
	 */
	public static WebElement SearchAndReturnRowElement(WebElement tableName, String textToSearch){
		List<WebElement> rows = null;
		List<WebElement> columns = null;
		String visibleText = null;
		String visibleText1 = null;
		WebElement foundElement = null;
		WebElement tableBody = tableName.findElement(By.tagName("tbody"));
		//System.out.println("Tbody found");
		rows = tableBody.findElements(By.tagName("tr"));
		if (rows !=null) {
			//System.out.println("rows not null");
			for (WebElement rowElements : rows) {
				columns = rowElements.findElements(By.tagName("td"));
				//System.out.print("Column Size : "+columns.size());
				for (WebElement columnElements : columns) {
					//System.out.print("\t\tcolumnElements Name : "+ columnElements.getAttribute("id"));
					visibleText = columnElements.getAttribute("textContent").trim().toUpperCase();
					visibleText1 = columnElements.getText().trim().toUpperCase();
					//System.out.println("visible text : " +visibleText);
					//System.out.println("visible text1 : " +visibleText1);
					if (visibleText.contentEquals(textToSearch.toUpperCase()) || visibleText1.contentEquals(textToSearch.toUpperCase())) {
						foundElement = rowElements;
						//System.out.println("Text \""+visibleText +"\" found");
						break;
					}
				}
			}
		}
		return foundElement;
	}
	
	public boolean setAccessRights(String roleName,HashMap<String,String>permission){
		
		VERASYS_SetUp_Role_Page_Action rolePA= new VERASYS_SetUp_Role_Page_Action(driver,logger);
		VERASYS_Setup_Customer_Page_Action customerPA= new VERASYS_Setup_Customer_Page_Action(driver,logger);
		rolePA.clickUserTab();
		customerPA.waitPageLoad();
		clickAccessTab();
		selectRole(roleName);
		clickAccess(permission);
		clickSave();
		String toasterMsg=customerPA.verifyMessage();
		//BaseClass.getScreenShot(driver, "SBH added successfully", logger);
		if(toasterMsg.equalsIgnoreCase("Access rights assigned to role successfully!"))
		{
			logger.log(LogStatus.PASS, "Alert message verified successfully:"+toasterMsg); 
			
			return true;
		}
		return false;
	}
	
	public boolean verifyCancelBtn(String roleName){
		VERASYS_SetUp_Role_Page_Action rolePA= new VERASYS_SetUp_Role_Page_Action(driver,logger);
		VERASYS_Setup_Customer_Page_Action customerPA= new VERASYS_Setup_Customer_Page_Action(driver,logger);
		rolePA.clickUserTab();
		WebElementCommon.staticWait(2000);
		clickAccessTab();
		WebElementCommon.staticWait(2000);
		selectRole(roleName);
		WebElementCommon.staticWait(2000);
		clickCancel();
		return(verifyRoleField());
	}
}
