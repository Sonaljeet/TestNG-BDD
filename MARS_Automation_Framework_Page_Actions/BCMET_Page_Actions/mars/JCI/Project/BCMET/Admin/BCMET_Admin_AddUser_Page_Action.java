/**
 * 
 */
package mars.JCI.Project.BCMET.Admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;

/**
 * @author cpandeak
 *
 */
public class BCMET_Admin_AddUser_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static final By IMAGELOADER = By.id("imgLoadingIcon");
	private static BCMET_Admin_AddUser_Page_Factory addUserPageFactory = null;
	/**
	 * 
	 */

	public BCMET_Admin_AddUser_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		addUserPageFactory = new BCMET_Admin_AddUser_Page_Factory(driver, logger);
	}

	//Test Methods --START
	
	public boolean verifyNewAdminUserCanBeCreatedSuccessfully() {
		boolean testStatus = false;
		
		List<WebElement> beforeAddingRecord = getMainTableGrid();
		System.out.println("beforeAddingRecord ="+beforeAddingRecord.size());
		clickOnAddbutton();
		enterUserName("NewAdmin");
		enterUserID("NewAdmin");
		enterPassword("Password@123");
		enterContactNumber("293084023");
		enterEmailID("NewAdmin@NewAdmin.com");
		clickOnDefineRoleIcon();
		clickOnDefineRoleCloseIcon();
		clickOnSaveButton();
		clickOnPopUpOkButton();
		List<WebElement> afterAddingRecord = getMainTableGrid();
		System.out.println("afterAddingRecord ="+afterAddingRecord.size());
		
		if ((afterAddingRecord.size() - beforeAddingRecord.size()) ==1) {
			testStatus = true;
		}
		
		return testStatus;
	}
	
	/**
	 * @return
	 */
	public boolean verifyNewCustomerCanBeAddedSuccessfully() {
		boolean testStatus = false;
		
		List<WebElement> beforeAddingRecord = getMainTableGrid();
		System.out.println("beforeAddingRecord ="+beforeAddingRecord.size());
		clickOnAddbutton();
		
		driver.findElement(By.id("ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_rcbRoleName")).click();
		WebElement combobox = driver.findElement(By.id("ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_rcbRoleName_DropDown"));
		
		List<WebElement> comboboxval = combobox.findElements(By.tagName("li"));
		comboboxval.get(1).click();
		
		enterUserName("NewCustomer");
		enterUserID("NewCustomer");
		enterPassword("Password@123");
		enterContactNumber("109210102");
		enterEmailID("NewCustomer@NewCustomer.com");
		clickOnDefineRoleIcon();
		clickOnDefineRoleCloseIcon();
		clickOnSaveButton();
		clickOnPopUpOkButton();
		List<WebElement> afterAddingRecord = getMainTableGrid();
		System.out.println("afterAddingRecord ="+afterAddingRecord.size());
		
		if ((afterAddingRecord.size() - beforeAddingRecord.size()) ==1) {
			testStatus = true;
		}
		return testStatus;
	}
	
	/**
	 * @return
	 */
	public boolean verifyNewTechnicianCanBeAddedSuccessfully() {
		boolean testStatus = false;
		
		List<WebElement> beforeAddingRecord = getMainTableGrid();
		System.out.println("beforeAddingRecord ="+beforeAddingRecord.size());
		clickOnAddbutton();
		
		driver.findElement(By.id("ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_rcbRoleName")).click();
		WebElement combobox = driver.findElement(By.id("ctl00_bodyPlaceholder_rgAddUser_ctl00_ctl04_rcbRoleName_DropDown"));
		
		List<WebElement> comboboxval = combobox.findElements(By.tagName("li"));
		comboboxval.get(2).click();
		
		enterUserName("NewTechnician");
		enterUserID("NewTechnician");
		enterPassword("Password@123");
		enterContactNumber("10921820102");
		enterEmailID("NewTechnician@NewTechnician.com");
		clickOnDefineRoleIcon();
		clickOnDefineRoleCloseIcon();
		clickOnSaveButton();
		clickOnPopUpOkButton();
		List<WebElement> afterAddingRecord = getMainTableGrid();
		System.out.println("afterAddingRecord ="+afterAddingRecord.size());
		
		if ((afterAddingRecord.size() - beforeAddingRecord.size()) ==1) {
			testStatus = true;
		}
		return testStatus;
	}
	
	/**
	 * @return
	 */
	public boolean verifyExistingCustomerCanBeDeleted() {
		boolean testStatus = false;
		boolean breakAll = false;
		List<WebElement> beforeDeleteingRecord = getMainTableGrid();
		System.out.println("beforeDeleteingRecord =" + beforeDeleteingRecord.size());

		if (beforeDeleteingRecord != null) {
			for (int rows = 0; rows < beforeDeleteingRecord.size(); rows++) {
				List<WebElement> columnValueForRow = beforeDeleteingRecord.get(rows).findElements(By.tagName("td"));

				for (int column = 0; column < columnValueForRow.size(); column++) {
					if ((columnValueForRow.get(column).getText().trim().contentEquals("Technician")
							|| columnValueForRow.get(column).getText().trim().contentEquals("Customer")
							|| columnValueForRow.get(column).getText().trim().contentEquals("Admin"))
							&& (!columnValueForRow.get(3).getText().trim().contentEquals("Admin"))) {
						System.out.println("columnValueForRow.get(column+1).getText().trim()"
								+ columnValueForRow.get(column + 1).getText().trim());
						columnValueForRow.get(0).click();
						logger.log(LogStatus.INFO,
								"Deleteting user with username \"" + columnValueForRow.get(2).getText().trim() + "\"");
						WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
						clickOnDeleteButton();
						clickOnDeleteYesButton();
						String deleteSuccessMessage = getPopUpMessageText();
						if (deleteSuccessMessage.contentEquals("Add User Deleted successfully")) {
							clickOnPopUpOkButton();

							testStatus = true;
						}
						breakAll = true;
						break;
					}
				} // Inner For loop Ends

				if (breakAll) {
					break;
				}
			} // Outer For loop Ends
		}

		return testStatus;
	}
	
	
	/**
	 * @return
	 */
	public boolean verifyErrorMsgForBlankFields() {
		boolean testStatus =false;
		String msgToCompare = "";
		clickOnAddbutton();
		clickOnSaveButton();
		String errMsg = getPopUpMessageText();
		String[] errMsgs = errMsg.split("- ");
		StringBuilder sb = new StringBuilder("");
		if (errMsgs != null) {
			for(int count =0; count<errMsgs.length;count++) {
				sb.append(errMsgs[count].trim());
			}
		}
		msgToCompare = sb.toString().trim();
		System.out.println("msgToCompare ="+sb.toString());
		if (msgToCompare.contentEquals("Please enter user namePlease enter user idPlease enter passwordPlease enter contact numberPlease enter email id")) {
			testStatus = true;
		}
		System.out.println("testStatus=" +testStatus);
		return testStatus;
	}
	
	
	//Test Methods --END
	
	
	//WebElement methods --START
	public static List<WebElement> getMainTableGrid() {
		List<WebElement> tableRows = null;
		WebElement element = addUserPageFactory.get_AddUserMainDataGrid();
		
		if (element != null) {
			tableRows = element.findElements(By.tagName("tr"));
		}
		
		return tableRows;
	}
	
	public static void clickOnAddbutton() {
		WebElement element = addUserPageFactory.get_AddButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Add button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find Add button");
		}
	}
	
	public static void clickOnEditButton() {
		WebElement element = addUserPageFactory.get_editButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Edit button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find Edit button");
		}
	}
	
	public static void clickOnDeleteButton() {
		WebElement element = addUserPageFactory.get_deleteButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find Delete button");
		}
	}
	
	public static void clickOnClearButton() {
		WebElement element = addUserPageFactory.get_clearButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Clear button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find Clear button");
		}
	}
	
	public static void clickOnSaveButton() {
		WebElement element = addUserPageFactory.get_saveButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Save button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find Save button");
		}
	}
	
	public void clickOnPopUpOkButton() {
		WebElement element = addUserPageFactory.get_popupOkButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Ok button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find Ok button");
		}
	}
	
	public String getPopUpMessageText() {
		WebElement element = addUserPageFactory.getPopUpMessage();
		String messageText = null;
		if (element != null) {
			messageText = WebElementCommon.getElementText(driver, element, logger).trim();
		}
		
		return messageText;
	}
	
	public static void enterUserName(String username) {
		WebElement element = addUserPageFactory.get_UserName();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, username);
			logger.log(LogStatus.PASS, "\""+username+"\""+" entered successfully in User Name Field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the User Name field");
		}
	}
	
	public static void enterUserID(String userid) {
		WebElement element = addUserPageFactory.get_UserID();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, userid);
			logger.log(LogStatus.PASS, "\""+userid+"\""+" entered successfully in User ID Field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the User ID field");
		}
	}
	
	public static void enterPassword(String password) {
		WebElement element = addUserPageFactory.get_Password();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, password);
			logger.log(LogStatus.PASS, "\""+password+"\""+" entered successfully in Password Field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Password field");
		}
	}
	
	public static void enterContactNumber(String ContactNumber) {
		WebElement element = addUserPageFactory.get_ContactNumber();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, ContactNumber);
			logger.log(LogStatus.PASS, "\""+ContactNumber+"\""+" entered successfully in Contact Number Field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Contact Number field");
		}
	}
	
	public static void enterEmailID(String EmailID) {
		WebElement element = addUserPageFactory.get_EmailId();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, EmailID);
			logger.log(LogStatus.PASS, "\""+EmailID+"\""+" entered successfully in Email ID Field");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find the Email Id field");
		}
	}
	
	public static void clickOnDefineRoleIcon() {
		WebElement element = addUserPageFactory.get_DefineRoleIcon();
		if (element != null) {
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Define Role clicked successfully");
		}
	}
	
	public static void clickOnDefineRoleCloseIcon() {
		WebElement element = addUserPageFactory.get_DefineRoleCloseIcon();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
		}
	}
	
	public static void clickOnDeleteYesButton() {
		WebElement element = addUserPageFactory.get_deleteYesButton();
		if (element != null) {
			WebButton.Button_Click(driver, element);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Delete Yes button clicked successfully");
		}else {
			logger.log(LogStatus.FAIL, "Failed to find Delete Yes button");
		}
	}
	
	//WebElement methods --END
	
}
