package mars.JCI.Project.MEO.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;

public class MEO_Login_Page_Action {
	
	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	/**
	 * Instantiates/Constructor a new MEO login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MEO_Login_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	/**
	 * Enter user ID.
	 *
	 * @param userName the user name
	 * 
	 * @return None
	 */
	public void enterUserID (String userName) {
		
		MEO_Login_Page_Factory loginPF = new MEO_Login_Page_Factory(driver);
		element = loginPF.getUserName();
		if(element!= null){
			if(element.isDisplayed()){
				//WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Username");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, userName);
				logger.log(LogStatus.PASS, "User ID Entered succesfully to User Name WebElement");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");   
		}
		
	}
	/**
	 * Enter password.
	 *
	 * @param password the password
	 * 
	 * @return None
	 */
public void enterPassword (String passWord) {
		
		MEO_Login_Page_Factory loginPF = new MEO_Login_Page_Factory(driver);
		element = loginPF.getPassword();
		if(element!= null){
			if(element.isDisplayed()){
				//WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Password");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, passWord);
				logger.log(LogStatus.PASS, "User Password Entered succesfully to User Password WebElement");  
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Identifying WebElement for User Password Field Failed");   
		}
		
	}

/**
 * Verify Log On enabled.
 *
 * @return true, if successful
 */
public boolean verifyLogOnEnabled(){
	MEO_Login_Page_Factory loginPF = new MEO_Login_Page_Factory(driver);
	boolean verifySignInEnabled = false;
	element = loginPF.getLogon();
	if(element!= null){
		if(element.isEnabled()){
			verifySignInEnabled = true;
			logger.log(LogStatus.PASS, "Verified Log On is Enabled before clicking");
		}
		else{
			logger.log(LogStatus.FAIL, "Verified Log On Is NOT Enabled.");
		}
	}
	else{
		logger.log(LogStatus.FAIL, " Log On Element returns NULL.");
	}
	return verifySignInEnabled;
}

/**
 * Click Log On.
 * 
 * @return None
 */
public void clickLogOn () {
	
	MEO_Login_Page_Factory loginPF = new MEO_Login_Page_Factory(driver);
	element = loginPF.getLogon();
	if(element!= null){
		if(verifyLogOnEnabled()){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Clicked succesfully to Log On WebElement");  
		}
		else{
			logger.log(LogStatus.FAIL, "Log On WebElement is not enabled");
		}
	}
	else{
		logger.log(LogStatus.ERROR, "Identifying WebElement for Log On Field Failed");   
	}
	
}

/**
 * Verify login page UserName text.
 *
 * @return true, if successful
 */

public boolean verifyLoginPageUserText(String username){
	MEO_Login_Page_Factory loginPF = new MEO_Login_Page_Factory(driver);
	boolean verifyLoginPageUserText = false;
	element = loginPF.getLoginPageUserText();
	//String userName="clungev";
	try {
		if(element!= null){
			if(WebElementCommon.getElementText(driver, element, logger).equalsIgnoreCase(username))
					{
				verifyLoginPageUserText = true;
				logger.log(LogStatus.PASS, "Home Page Displayed for logged in User matched with expected");
			}
			else{
				logger.log(LogStatus.FAIL, " Logged in Username not matched with actual text.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Logged in Username text Element returns NULL.");
		}
	} catch (NullPointerException e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	} catch (Exception e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifyLoginPageUserText;
}
/**
 *  login with correct userName and password.
 *
 * @return true, if successful
 */
public Boolean correctLogin(String username, String password) {
	boolean verifyLoginPageUserText=false;
	try {
		enterUserID(username);
		enterPassword(password);
		clickLogOn();
		 verifyLoginPageUserText = verifyLoginPageUserText(username);
	} catch (NullPointerException e) {
		// TODO Auto-generated catch block
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifyLoginPageUserText;
}
/**
 *  login with incorrect userName and password.
 *
 * @return false, if successful correct error message is shown
 */
public boolean wrongUser_login(String wrngUsername, String wrngPassword){
	boolean verifyLoginErrorText=false;
	try {
	enterUserID(wrngUsername);
	enterPassword(wrngPassword);
	clickLogOn();
	 verifyLoginErrorText = verifyLoginErrorText("Login was unsuccessful");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return verifyLoginErrorText;
	}

public boolean verifyLoginErrorText(String textToCompare) {
	boolean errorMessage = false;
	MEO_Login_Page_Factory loginPF = new MEO_Login_Page_Factory(driver);
	element = loginPF.getWrongUserError();
	if(element!= null){
		if(WebElementCommon.waitForTextToAppear(driver, 
											textToCompare, 
											element,
											logger)){
			errorMessage = true;
			logger.log(LogStatus.PASS, "Succesfully identify Login Error Text Message");
		}else{
			logger.log(LogStatus.FAIL, "Get the login Error Text Message Failed"); 
		}
		
	}else{
		logger.log(LogStatus.FAIL, "Get the login Error Text Element Failed");   
	}
	return errorMessage;
}
}
