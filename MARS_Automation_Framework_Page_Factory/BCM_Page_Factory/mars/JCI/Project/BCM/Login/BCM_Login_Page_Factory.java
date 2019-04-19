/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Login;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCM_Login_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	private final String EMPTY_STRING = "";

	public BCM_Login_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	// Element locators for Login Page
	@FindBy(css = "input[automation_id=loginPage_Field_UserName]")
	private WebElement txt_username;

	public WebElement gettxt_username(String username) {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txt_username, logger) == true) {
			return txt_username;
		} else
			return null;
	}

	@FindBy(css = "input[automation_id=loginPage_Field_Password]")
	private WebElement txt_password;

	public WebElement gettxt_password() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txt_password, logger) == true) {
			return txt_password;
		} else
			return null;
	}

	@FindBy(css = "input[automation_id=loginPage_DD_fa_LanguageDropDown]")
	private WebElement dropdown_language;

	public WebElement getdropdown_language() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, dropdown_language, logger) == true) {
			return dropdown_language;
		} else
			return null;
	}

	@FindBy(css = "input[automation_id=loginPage_Field_login_btn]")
	private WebElement btnLogin;

	public WebElement getbtnLogin() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, btnLogin, logger) == true) {
			return btnLogin;
		} else
			return null;
	}

/*	@FindBy(css = "input[automation_id=loginPage_Chkbox_RememberMe]")
	private WebElement chkbxRememberMe;

	public WebElement getchkbxRememberMe() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chkbxRememberMe, logger) == true) {
			return chkbxRememberMe;
		} else
			return null;
	}*/

	@FindBy(css = "a[automation_id=loginPage_Link_ChangePassword]")
	private WebElement linkChangePassword;

	public WebElement getlinkChangePassword() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, linkChangePassword, logger) == true) {
			return linkChangePassword;
		} else
			return null;
	}

	@FindBy(css = "span[automation_id=loginPage_Text_fa_BCMText]")
	private WebElement txtBuildingControlManager;

	public WebElement gettxtBuildingControlManager() {
		WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txtBuildingControlManager, logger) == true) {
			return txtBuildingControlManager;
		} else
			return null;
	}

	@FindBy(css = "span[automation_id=loginPage_Field_copyrightText]")
	private WebElement txtCopyrightInfo;

	public WebElement gettxtCopyrightInfo() {
		WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txtCopyrightInfo, logger) == true) {
			return txtCopyrightInfo;
		} else
			return null;
	}

	@FindBy(css = "span[automation_id=loginPage_Text_BestViewedMessage]")
	private WebElement txtBestViewedBrowser;

	public WebElement gettxtBestViewedBrowser() {
		WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txtBestViewedBrowser, logger) == true) {
			return txtBestViewedBrowser;
		} else
			return null;
	}

	@FindBy(css = "span[automation_id=loginPage_Icon_fa_userIcon]")
	private WebElement imgUsername;

	public WebElement getimgUsername() {
		WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, imgUsername, logger) == true) {
			return imgUsername;
		} else
			return null;
	}

	@FindBy(css = "span[automation_id=loginPage_Icon_fa_PasswordIcon]")
	private WebElement imgPassword;

	public WebElement getimgPassword() {
		WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, imgPassword, logger) == true) {
			return imgPassword;
		} else
			return null;
	}

	@FindBy(css = "span[automation_id=loginPage_Icon_fa_LanguageIcon]")
	private WebElement imgLanguage;

	public WebElement getimgLanguage() {
		WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, imgLanguage, logger) == true) {
			return imgLanguage;
		} else
			return null;
	}

	@FindBy(css = "i[automation_id=loginPage_Img_Exclamation]")
	private WebElement imgExclamationInErrorMessage;

	public WebElement getimgExclamationInErrorMessage() {
		WebElementCommon.staticWait(5000);
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, imgExclamationInErrorMessage,
				logger) == true) {
			return imgExclamationInErrorMessage;
		} else
			return null;
	}

	@FindBy(css = "span[automation_id=loginPage_Field_errorMessageInfo]")
	private WebElement txtErrorMessage;

	public WebElement gettxtErrorMessage() {
		WebElement element=null;
		commonFunctions.WebElementCommon.staticWait(5000);
		try {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txtErrorMessage, logger) == true) {
				element=txtErrorMessage;
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return txtErrorMessage;
		}
		return element;
	}
}
