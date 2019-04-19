/**
 * 
 */
package mars.JCI.Project.VERASYS.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.JCI.Project.DES.Login.DES_Login_Error_Page_Action;
import mars.JCI.Project.VERASYS.Login.VERASYS_Login_Page_Factory;

/**
 * @author jkadhak
 *
 */
public class VERASYS_Login_Page_Action {

	
	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	/**
	 * Instantiates/Constructor a new Verasys login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public VERASYS_Login_Page_Action(WebDriver driver, ExtentTest logger) {
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
		
		VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
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
		
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
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
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	boolean verifySignInEnabled = false;
	element = loginPF.getLogInButton();
	if(element!= null){
		if(element.isEnabled()){
			verifySignInEnabled = true;
			//logger.log(LogStatus.PASS, "Verified Log In button is Enabled before clicking");
		}
		else{
			logger.log(LogStatus.FAIL, "Verified Log In Is NOT Enabled.");
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
	
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	element = loginPF.getLogInButton();
	if(element!= null){
		if(verifyLogOnEnabled()){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Succesfully clicked on Log In Button");  
		}
		else{
			logger.log(LogStatus.FAIL, "Log In WebElement is not enabled");
		}
	}
	else{
		logger.log(LogStatus.ERROR, "Identifying WebElement for Log In Field Failed");   
	}
	
}

/**
 * Click Log On.
 * 
 * @return None
 */
public void clickSetUpOption() {
	
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	element = loginPF.getSetupOption();
	if(element!= null){
		if(element.isEnabled()){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Succesfully clicked on Setup Option");  
		}
		else{
			logger.log(LogStatus.FAIL, "Setup Option WebElement is not enabled");
		}
	}
	else{
		logger.log(LogStatus.ERROR, "Identifying WebElement for Setup Option Field Failed");   
	}
	
}

/**
 * Click Log On.
 * 
 * @return None
 */
public void clickSetUp() {
	
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	element = loginPF.getSetupIcon();
	if(element!= null){
		if(element.isEnabled()){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Succesfully clicked on Setup");  
			element=loginPF.getLoadingTab();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element,"Loading...")));
		}
		else{
			logger.log(LogStatus.FAIL, "Setup WebElement is not enabled");
		}
	}
	else{
		logger.log(LogStatus.ERROR, "Identifying WebElement for Setup Field Failed");   
	}
	
}
/**
 * Click Log out.
 * 
 * @return None
 */
public void clickLogOut () {
	
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	element = loginPF.getLogoutbtn();
	if(element!= null){
			WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Succesfully clicked on Log Out Button");  
			element = loginPF.getLogoutPage();
			WebElementCommon.waitForElementPresent(driver, element, logger);
			if(element==null){
				logger.log(LogStatus.ERROR, "Logout Failed");
			}
	}
	else{
		logger.log(LogStatus.ERROR, "Identifying WebElement for Log Out Field Failed");   
	}
	
}
/**
 * Click profile drop down.
 * 
 * @return None
 */
public void clickProfile () {
	
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	element = loginPF.getProfileDropDown();
	if(element!= null){
			element.click();
			logger.log(LogStatus.PASS, "Successfully clicked on Profile Drop Down");  
	}
	else{
		logger.log(LogStatus.ERROR, "Identifying WebElement for Profile Drop Down Field Failed");   
	}
	
}

/**
 * Verify login page UserName text.
 *
 * @return true, if successful
 */

/*public boolean verifyDashboardScreen(){
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	boolean verifySetUpScreen = false;
	element = loginPF.getSetUpScreen();
	try {
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element))
					{
				verifySetUpScreen = true;
				logger.log(LogStatus.PASS, "Succesfully verified customer set up screen is displayed when JCI admin Logged In");
			}
			else{
				logger.log(LogStatus.FAIL, " Customer Set Up Screen is NOT displayed when Admin User Logged In");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Set Screen Element returns NULL.");
		}
	} catch (NullPointerException e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	} catch (Exception e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifySetUpScreen;
}*/

/**
 * Verify login page UserName text.
 *
 * @return true, if successful
 */

public boolean verifySetUpScreen(){
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	boolean verifySetUpScreen = false;
	element = loginPF.getSetUpScreen();
	try {
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element))
					{
				verifySetUpScreen = true;
				logger.log(LogStatus.PASS, "Succesfully verified customer set up screen is displayed when JCI admin Logged In");
			}
			else{
				logger.log(LogStatus.FAIL, " Customer Set Up Screen is NOT displayed when Admin User Logged In");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Set Screen Element returns NULL.");
		}
	} catch (NullPointerException e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	} catch (Exception e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifySetUpScreen;
}

/**
 * Verify login page UserName text.
 *
 * @return true, if successful
 */

public boolean verifyLoginError(){
	VERASYS_Login_Page_Factory loginPF = new VERASYS_Login_Page_Factory(driver);
	boolean verifySetUpScreen = false;
	element = loginPF.getWrongUserError();
	try {
		if(element!= null){
			if(element.getText().equalsIgnoreCase("Invalid username and password."))
					{
				verifySetUpScreen = true;
				logger.log(LogStatus.PASS, "Successfully verified Error message while login with incorrect username or password: "+element.getText());
			}
			else{
				logger.log(LogStatus.FAIL, "Error message is not displayed when logged in with incorrect username or password");
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Failed to identify error message webelement");
		}
	} catch (NullPointerException e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	} catch (Exception e) {
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifySetUpScreen;
}

/**
 *  login with correct userName and password.
 *
 * @return true, if successful
 */
public Boolean correctLogin(String username, String password) {
	boolean verifySetUpScreen=false;
	try {
		enterUserID(username);
		enterPassword(password);
		clickLogOn();
		clickSetUpOption();
		clickSetUp();
		verifySetUpScreen = verifySetUpScreen();
	} catch (NullPointerException e) {
		// TODO Auto-generated catch block
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifySetUpScreen;
}

/**
 *  logout .
 *
 * @return true, if successful
 */
public Boolean successfullLogout() {
	boolean verifySetUpScreen=false;
	try {
		clickProfile();
		clickLogOut ();
		verifySetUpScreen = true;
	} catch (NullPointerException e) {
		// TODO Auto-generated catch block
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifySetUpScreen;
}

/**
 * Incorrect login.
 *
 * @param username the username
 * @param password the password
 * @return the login error page action
 */
public Boolean incorrectLogin(String username, String password) {
	boolean verifySetUpScreen=false;
	try {
		
		enterUserID(username);
		enterPassword(password);
		clickLogOn();
		verifySetUpScreen=verifyLoginError();
    } catch (NullPointerException e) {
		// TODO Auto-generated catch block
		logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
	}
	return verifySetUpScreen;
}


}
