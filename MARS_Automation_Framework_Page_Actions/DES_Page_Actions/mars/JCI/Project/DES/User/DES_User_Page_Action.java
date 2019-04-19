package mars.JCI.Project.DES.User;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.helger.commons.annotation.OverrideOnDemand;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.UsersRole.DES_UsersRole_Page_Action;
import mars.JCI.Project.DES.UsersRolesRights.DES_UsersRolesRights_Page_Action;
import mars.JCI.Project.DES.Users_User.DES_USERS_User_Page_Factory;

public class DES_User_Page_Action {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element = null;
	private static DES_USERS_User_Page_Factory userPF = null;
	private static DES_UsersRolesRights_Page_Action roleRPF = null;
	private static DES_Home_Page_Action homePA = null;
	private static DES_UsersRole_Page_Action userRolePA = null;
	public static String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";

	public DES_User_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		userPF = new DES_USERS_User_Page_Factory(driver, logger);
		roleRPF = new DES_UsersRolesRights_Page_Action(driver, logger);
		homePA = new DES_Home_Page_Action(driver, logger);
	}

	public static void waitForSpinnerToDisappear() {
		By spinner = By.id("divloadingConfiguration");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
	}

	public String getValidationMessageFromPage() {
		String Message = null;
		element = userPF.getUserSuccessMessage();
		if (element != null) {
			Message = element.getText();
			System.out.println(Message + " Message From The Page");
			logger.log(LogStatus.PASS, "\"" + Message + "\" Message Recieved from Page");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Get the Message from Page");
		}
		return Message;
	}

	public String createUser() {
		String roleAdded = "";
		try {
			roleAdded = roleRPF.assignAllRightsToRoles();
			waitForSpinnerToDisappear();
			element = userPF.getusertab();
			if (element != null) {
				waitForSpinnerToDisappear();
				element.click();
				waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Successfully navigated to " + element.getText());
				enterUserDetails(roleAdded);
				//String userFirstName=enterUserDetails();
				waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Successfully Added User With Role " + roleAdded);
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not create Admin user");
		}
		return roleAdded;

	}

	public static void navigateToUserTab() {
		userRolePA.navigateToUsersRolePage();
		waitForSpinnerToDisappear();
		element = userPF.getusertab();
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			waitForSpinnerToDisappear();
		}
	}

	public void createSuperAdminUser() {
		try {
			navigateToUserTab();
			waitForSpinnerToDisappear();
			String userFirstNameUpdate= enterAdminUserDetails();
			WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "User_FirstName",userFirstNameUpdate);
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Succeesfully added user with SuperAdmin Role");
		} catch (Exception e) {
				logger.log(LogStatus.FAIL, "Failled to add user with superAdmin Role");
		}
	}

	public void updateUser() {
		try {
			navigateToUserTab();
			waitForSpinnerToDisappear();
			String userDetailsJsonPath = "$..UserFirstName";
			List<String> userDetails = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), userDetailsJsonPath);

			element = userPF.getfirstNameSearchTextbox();
			if (element != null) {
				waitForSpinnerToDisappear();
				element.sendKeys(userDetails.get(0).toString());
				waitForSpinnerToDisappear();
				element = userPF.getUserFirstNameFromGrid();
				System.out.println(element.getText());
				if (element != null) {
					element.click();
					waitForSpinnerToDisappear();
					String userLastNameUpdate = enterUserLastName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
					WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "User_LastName",userLastNameUpdate);
					waitForSpinnerToDisappear();
					element = userPF.getbtnUpdateUser();
					waitForSpinnerToDisappear();
					if (element != null && element.isEnabled())
						element.click();
					waitForSpinnerToDisappear();
					getValidationMessageFromPage();
					logger.log(LogStatus.PASS, "User updated with new details");
				}

			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to update user details");
		}

	}

	public void deleteUser() {
		try {
			navigateToUserTab();
			waitForSpinnerToDisappear();
			String userDetailsJsonPath = "$..UserFirstName";
			List<String> userDetails = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), userDetailsJsonPath);

			element = userPF.getfirstNameSearchTextbox();
			if (element != null) {
				waitForSpinnerToDisappear();
				element.sendKeys(userDetails.get(0).toString());
				waitForSpinnerToDisappear();
				element = userPF.getUserFirstNameFromGrid();
				System.out.println(element.getText());
				if (element != null) {
					element.click();
					waitForSpinnerToDisappear();
					element = userPF.getbtnDeleteUser();
					waitForSpinnerToDisappear();
					if (element != null && element.isEnabled())
						element.click();
					waitForSpinnerToDisappear();
					element=userPF.getconfirmOKButton();
					if(element!=null){
						element.click();
						waitForSpinnerToDisappear();
						getValidationMessageFromPage();
					}
					logger.log(LogStatus.PASS, "User Deleted ");
				}

			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to Delete user");
		}

	}

	private static String enterUserDetails(String roleAdded) throws JsonIOException, JsonSyntaxException, IOException {
		String userFirstName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
		String userLastname = DES_UsersRole_Page_Action.generateRandomalphabets(6);
		String userDetailsJsonPath = "$..UserDetails.*";
		List<String> userDetails = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), userDetailsJsonPath);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"),
				"UserFirstName", userFirstName);
		String userEmail = userFirstName + userDetails.get(0).toString();
		String userPassword= userDetails.get(4).toString();
		String userFullName = (userFirstName +" "+ userLastname);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"),
				"UserFullName", userFullName);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"),
				"UserName", userEmail);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"),
				"userPassword", userPassword);
		/*
		 * String roleAddedJsonPath="$..Role_Name.*"; List<String> roleDetails=
		 * ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(
		 * ConfigFile).getProperty("RuntimedatafileLoc"),roleAddedJsonPath);
		 */
		enterUserFisrtName(userFirstName);
		waitForSpinnerToDisappear();
		enterUserLastName(userLastname);
		waitForSpinnerToDisappear();
		enterUserName(userEmail);// email id
		waitForSpinnerToDisappear();
		selectRole(roleAdded); // select from dropdown
		waitForSpinnerToDisappear();
		enterPassword(userPassword);
		waitForSpinnerToDisappear();
		enterConfirmPassword(userPassword);
		waitForSpinnerToDisappear();
		enterEmailAddress(userEmail);
		waitForSpinnerToDisappear();
		enterContactNumber(userDetails.get(5).toString());
		waitForSpinnerToDisappear();
		uploadProfilePicture(userDetails.get(6).toString());
		waitForSpinnerToDisappear();
		clickOnAddButton();
		waitForSpinnerToDisappear();
		return roleAdded;

	}

	private static String enterAdminUserDetails() throws JsonIOException, JsonSyntaxException, IOException {
		String userFirstName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
		String userDetailsJsonPath = "$..UserDetails.*";
		List<String> userDetails = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), userDetailsJsonPath);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"),
				"UserFirstName", userFirstName);
		String userEmail = userFirstName + userDetails.get(0).toString();
		/*
		 * String roleAddedJsonPath="$..Role_Name.*"; List<String> roleDetails=
		 * ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(
		 * ConfigFile).getProperty("RuntimedatafileLoc"),roleAddedJsonPath);
		 */
		enterUserFisrtName(userFirstName);
		waitForSpinnerToDisappear();
		enterUserLastName(DES_UsersRole_Page_Action.generateRandomalphabets(6));
		waitForSpinnerToDisappear();
		enterUserName(userEmail);// email id
		waitForSpinnerToDisappear();
		selectRole(userDetails.get(1).toString()); // select from dropdown
		waitForSpinnerToDisappear();
		enterPassword(userDetails.get(4).toString());
		waitForSpinnerToDisappear();
		enterConfirmPassword(userDetails.get(4).toString());
		waitForSpinnerToDisappear();
		enterEmailAddress(userEmail);
		waitForSpinnerToDisappear();
		enterContactNumber(userDetails.get(5).toString());
		waitForSpinnerToDisappear();
		uploadProfilePicture(userDetails.get(6).toString());
		waitForSpinnerToDisappear();
		clickOnAddButton();
		waitForSpinnerToDisappear();
		return userFirstName;
	}

	private static void clickOnAddButton() {
		element = userPF.getbtnAddUser();
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked on Addd button successfully");
		} else {
			logger.log(LogStatus.FAIL, "Could not Click on Add button");
		}

	}

	private static void uploadProfilePicture(String profilepic) {
		element = userPF.getuserProfilepicTextbox();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, profilepic);
			logger.log(LogStatus.PASS, "Successfully added profile pic for the User");
		} else {
			logger.log(LogStatus.PASS, "Failled to add profile pic");
		}

	}

	private static void enterContactNumber(String contactNumber) {
		element = userPF.getuserContactnumberTextbox();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, contactNumber);
			logger.log(LogStatus.PASS, "\" " + contactNumber + "\" entered successfully in contactNumber field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to enter contactNumber");
		}

	}

	private static void enterEmailAddress(String emailAddress) {
		element = userPF.getusersemailTextbox();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, emailAddress);
			logger.log(LogStatus.PASS, "\" " + emailAddress + "\" entered successfully in Confirm password field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to enter email Address");
		}

	}

	private static void enterConfirmPassword(String confirmPassword) {
		element = userPF.getConfirmpasswordTextbox();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, confirmPassword);
			logger.log(LogStatus.PASS, "\" " + confirmPassword + "\" entered successfully in Confirm password field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to enter confirm password");
		}

	}

	private static void enterPassword(String password) {
		element = userPF.getPasswordTextbox();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, password);
			logger.log(LogStatus.PASS, "\"" + password + "\" entered sucessfully in firstname  field");
		} else {
			logger.log(LogStatus.FAIL, "Failled to enter Password");
		}

	}

	private static void selectRole(String role) {
		element = userPF.getRoleidTextbox();
		if (element != null) {
			WebDropDown.SelectElementByVisibleText(element, role);
			logger.log(LogStatus.PASS, "\"" + role + "\" Selected Role successfully from Role dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from Role dropdown");
		}

	}

	private static void enterUserFisrtName(String firstname) {
		element = userPF.getuserFirstnameTextbox();
		if (element != null) {
			waitForSpinnerToDisappear();
			WebInputTextBox.SendInputTextBox(driver, element, firstname);
			logger.log(LogStatus.PASS, "\"" + firstname + "\" entered sucessfully in firstname  field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Firstname field");
		}

	}

	private static String enterUserLastName(String Lastname) {
		element = userPF.getuserLastnameTextbox();
		if (element != null) {
			waitForSpinnerToDisappear();
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, Lastname);
			logger.log(LogStatus.PASS, "\"" + Lastname + "\" entered sucessfully in Lastname  field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Lastname field");
		}
		return Lastname;

	}

	private static void enterUserName(String UserName) {
		element = userPF.getUsernameTextbox();
		if (element != null) {
			waitForSpinnerToDisappear();
			WebInputTextBox.SendInputTextBox(driver, element, UserName);
			logger.log(LogStatus.PASS, "\"" + UserName + "\" entered sucessfully in UserName  field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the UserName field");
		}

	}

}
