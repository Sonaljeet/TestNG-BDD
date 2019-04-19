package mars.JCI.Project.CEP.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Login_Page_Factory {

	private WebDriver driver;
	private ExtentTest logger;

	public CEP_Login_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement username;

	public WebElement getUserName() throws Exception {

		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, username, logger) == true) {
			return this.username;
		} else {
			return null;
		}
	}

	@FindBy(id = "password")
	private WebElement password;

	public WebElement getPassWord() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, password, logger) == true) {
			return this.password;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	public WebElement getButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, loginButton, logger) == true) {
			return this.loginButton;
		} else {
			return null;
		}
	}

	// Internal Sign-in button
	@FindBy(xpath = "//div[contains(@class,'external-provider')]")
	private WebElement internalSignInButton;

	public WebElement getInternalSignInButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, internalSignInButton, logger) == true) {
			return internalSignInButton;
		} else {
			return null;
		}
	}

	// Email text box for sign-in
	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailTextBox;

	public WebElement getEmailTextBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, emailTextBox, logger) == true) {
			return emailTextBox;
		} else {
			return null;
		}
	}

	// Password for Internal Sign-in
	@FindBy(xpath = "//input[@id='passwordInput']")
	private WebElement passwordTextBox;

	public WebElement getPasswordTextBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, passwordTextBox, logger) == true) {
			return passwordTextBox;
		} else {
			return null;
		}
	}

	// Button to Login for internal user
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement nextButton;

	public WebElement getNextButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, nextButton, logger) == true) {
			return nextButton;
		} else {
			return null;
		}
	}

	// Sign-In Button for Internal Sign-in
	@FindBy(xpath = "//span[@id='submitButton']")
	private WebElement signInButton;

	public WebElement getSignInButtonForInternalUser() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, signInButton, logger) == true) {
			return signInButton;
		} else {
			return null;
		}
	}
	// Handle Modal after Login
	@FindBy(xpath="//button[@class='close']")
	private WebElement modalClose;
	
	public WebElement getModalCloseButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, modalClose, logger) == true) {
			return modalClose;
		} else {
			return null;
		}
	}

	
}
