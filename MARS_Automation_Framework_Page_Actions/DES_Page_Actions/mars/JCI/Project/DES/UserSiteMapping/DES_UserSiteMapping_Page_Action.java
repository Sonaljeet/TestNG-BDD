package mars.JCI.Project.DES.UserSiteMapping;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebDropDown;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.User.DES_User_Page_Action;
import mars.JCI.Project.DES.Users_UserSiteMapping.DES_USERS_UserSiteMapping_Page_Factory;

public class DES_UserSiteMapping_Page_Action {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element = null;
	private static DES_USERS_UserSiteMapping_Page_Factory userSM = null;
	private static DES_Home_Page_Action homePA = null;
	private static DES_User_Page_Action userPA = null;
	private static DES_Login_Page_Action loginPA = null;
	public static String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";

	public DES_UserSiteMapping_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		userSM = new DES_USERS_UserSiteMapping_Page_Factory(driver, logger);
		homePA = new DES_Home_Page_Action(driver, logger);
		userPA = new DES_User_Page_Action(driver, logger);
		loginPA = new DES_Login_Page_Action(driver, logger);
	}

	public void navigateToUserSiteMappingTab() {
		try {
			userPA.navigateToUserTab();
			element = userSM.getusersitemappingtab();
			if (element != null) {
				element.click();
				homePA.waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Successfully navigated to User SiteMapping tab");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to Navigate to User Site Mapping tab");
		}
	}

	public void clickOnSaveButton() {
		try {
			element = userSM.getUserSitemappingSavebtn();
			if (element != null) {
				homePA.waitForSpinnerToDisappear();
				element.click();
				homePA.waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Successfully clicked on Save Button");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to click on Save Button");
		}
	}

	public void selectUserfromDropDown(String user) {
		element = userSM.getusersDropdown();
		if (element != null) {
			homePA.waitForSpinnerToDisappear();
			WebDropDown.SelectElementByVisibleText(element, user);
			logger.log(LogStatus.PASS, "\"" + user + "\" Selected as User successfully from User dropdown");
		} else {
			logger.log(LogStatus.FAIL, "\" " + user + "\" could not select from user dropdown");
		}
	}

	// public void

	@SuppressWarnings("static-access")
	public void createAndAssignSitesToUser() {
		try {
			// loginPA.DES_CorrectLogin();
			// homePA.navigateToSetupPage();
			//navigateToUserSiteMappingTab();
			 userPA.createUser();
			 clickOnUserSiteMappingTab();
			String UserFullNameJsonPath = "$..UserFullName";
			List<String> UserFullName = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), UserFullNameJsonPath);
			selectUserfromDropDown(UserFullName.get(0).toString());
			homePA.waitForSpinnerToDisappear();
			getRoleofUser();
			homePA.waitForSpinnerToDisappear();
			// clickOnSiteCheckBox();
			verifyIfCheckBoxIsChecked();
			homePA.waitForSpinnerToDisappear();
			clickOnSaveButton();
			homePA.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Successfully Assigned the Customer to User");

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to assign sites to user" + e.getMessage());
		}
	}

	public boolean verifyIfCheckBoxIsChecked() {
		boolean checkBoxStatus = false;
		String SiteNameJsonPath = "$..UserDetails.*";
		List<String> SiteName = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), SiteNameJsonPath);
		checkBoxStatus = userSM.getcustomerNamecheckbox(SiteName.get(7).toString()).isSelected();
		if (checkBoxStatus != true) {
			userSM.getcustomerNamecheckbox(SiteName.get(7).toString()).click();
			logger.log(LogStatus.PASS,"Assign the site to user");			
		} else {
			logger.log(LogStatus.FAIL, "Site is already assigned to user");
		}

		return checkBoxStatus;

	}

	@SuppressWarnings("static-access")
	private void clickOnSiteCheckBox() {
		String SiteNameJsonPath = "$..UserDetails.*";
		List<String> SiteName = ReadJsonFile.readJsonFileDynamic(
				ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), SiteNameJsonPath);
		element = userSM.getcustomerNamecheckbox(SiteName.get(7).toString());
		if (element != null) {
			homePA.waitForSpinnerToDisappear();
			element.click();
			homePA.waitForSpinnerToDisappear();
		}

	}

	@SuppressWarnings("static-access")
	private String getRoleofUser() {
		String roleName = "";
		element = userSM.getroleNameLabel();
		if (element != null) {
			homePA.waitForSpinnerToDisappear();
			roleName = element.getText();
			logger.log(LogStatus.PASS, "User has Role of " + roleName);
		}
		return roleName;

	}

	private void clickOnUserSiteMappingTab() {
		homePA.waitForSpinnerToDisappear();
		element = userSM.getusersitemappingtab();
		if (element != null) {
			element.click();
			homePA.waitForMapSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Successfully navigated to User SiteMapping tab");
		}

	}

	@SuppressWarnings("static-access")
	public void validateUserIsAbletoLogin() {

		try {
			String UserNameJsonPath = "$..UserName";
			List<String> UserName1 = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), UserNameJsonPath);
			String userPasswordJsonPath = "$..userPassword";
			List<String> userPassword1 = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), userPasswordJsonPath);
			loginPA.verifySSL();
			loginPA.enterUserID(UserName1.get(0).toString());
			loginPA.enterPassword(userPassword1.get(0).toString());
			loginPA.clickSignIn();
			Thread.sleep(2000);
			homePA.waitForMapSpinnerToDisappear();
			//String loggedinUser=homePA.loggedInUserName();
			String loggedinUser=homePA.clickOnLogOut();
			logger.log(LogStatus.PASS, "Successfully Logged into DES with User created "+loggedinUser );//loggedinUser

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to login with UserName" + e);
		}
	}

}
