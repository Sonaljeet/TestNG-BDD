package mars.JCI.Project.MUI.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Component.Functions.Common_Component_Functions;
import mars.JCI.Project.MUI.Home.*;

/**
 * The Class MUI_Login_Page_Action.
 */
public class MUI_Login_Page_Action {
	
	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	/**
	 * Instantiates/Constructor a new MUI login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MUI_Login_Page_Action(WebDriver driver, ExtentTest logger) {
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
		
		MUI_Login_Page_Factory loginPF = new MUI_Login_Page_Factory(driver);
		element = loginPF.getUserName();
		if(element!= null){
			if(element.isDisplayed()){
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Username");
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
	public void enterPassword (String password) {
		
		MUI_Login_Page_Factory loginPF = new MUI_Login_Page_Factory(driver);
		element = loginPF.getPassword();
		if(element!= null){
			if(element.isDisplayed()){
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Password");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, password);
				logger.log(LogStatus.PASS, "Password Entered succesfully to Password WebElement");   
			}
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Password Field Failed");   
		}
		
	}
	
	/**
	 * Verify sign in enabled.
	 *
	 * @return true, if successful
	 */
	public boolean verifySignInEnabled(){
		MUI_Login_Page_Factory loginPF = new MUI_Login_Page_Factory(driver);
		boolean verifySignInEnabled = false;
		element = loginPF.getSignIn();
		if(element!= null){
			if(element.isEnabled()){
				verifySignInEnabled = true;
				logger.log(LogStatus.PASS, "Verified Sign Is Enabled before clicking");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Sign Is NOT Enabled.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Sign IN Element returns NULL.");
		}
		return verifySignInEnabled;
	}

		
	/**
	 * Verify login page copyright text.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLoginCopyrightText(){
		MUI_Login_Page_Factory loginPF = new MUI_Login_Page_Factory(driver);
		boolean verifyLoginCopyrightText = false;
		element = loginPF.getLoginCopyrightText();
		try {
			if(element!= null){
				if(WebElementCommon.getElementText(driver, element, logger).equals
						("© Johnson Controls, Inc. 2013-2017")){
					verifyLoginCopyrightText = true;
					logger.log(LogStatus.PASS, "Verified copyright text is matched with expected");
				}
				else{
					logger.log(LogStatus.FAIL, " Copyright text not matched with actual text.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Copyright text Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return verifyLoginCopyrightText;
	}
	
	/**
	 * Click sign in.
	 * 
	 * @return None
	 */
	public void clickSignIn () {
		
		MUI_Login_Page_Factory loginPF = new MUI_Login_Page_Factory(driver);
		element = loginPF.getSignIn();
		if(element!= null){
			if(verifySignInEnabled()){
				WebButton.Button_Click(driver, element);
				logger.log(LogStatus.PASS, "Clicked succesfully to Sign IN WebElement");  
			}
			else{
				logger.log(LogStatus.FAIL, "Sign IN WebElement is not enabled");
			}
		}
		else{
			logger.log(LogStatus.ERROR, "Identifying WebElement for Sign IN Field Failed");   
		}
		
	}

	/**
	 * Verify SSL.
	 * 
	 * @return None
	 */
	public void verifySSL () {
		if(driver.getTitle().contains("Certificate")){
			driver.get("javascript:document.getElementById('overridelink').click();");
			logger.log(LogStatus.PASS, "SSL Certificate link clicked");
		}
		else{
			logger.log(LogStatus.INFO, "SSL Certificate link is not available for browser");
		}
		
	}
	
	/**
	 * Correct login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the MUI home page action
	 */
	public MUI_Home_Page_Action correctLogin(String username, String password) {
		MUI_Home_Page_Action homePA = null;
		try {
			verifySSL();
			enterUserID(username);
			enterPassword(password);
			verifyLoginCopyrightText();
			clickSignIn();
			homePA = new MUI_Home_Page_Action(driver, logger);

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return homePA;
    }
	
	public Object correctLogin1(String username, String password) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println(super.getClass().getSimpleName());
		System.out.println(super.getClass().getCanonicalName());
		Class<?> myClass = Class.forName(super.getClass().getCanonicalName());
		Class homePA = (Class) myClass.newInstance();
		try {
			verifySSL();
			enterUserID(username);
			enterPassword(password);
			//verifyLoginCopyrightText();
			clickSignIn();
			//Object [] parameterType  = new Object[WebDriver driver , ExtentTest t];
			//homePA = new 
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return homePA;
    }
	
	/**
	 * Incorrect login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the MUI login error page action
	 */
	public MUI_Login_Error_Page_Action incorrectLogin(String username, String password) {
		MUI_Login_Error_Page_Action loginErrorPA = null;
		try {
			verifySSL();
			enterUserID(username);
			enterPassword(password);
			clickSignIn();
			loginErrorPA = new MUI_Login_Error_Page_Action(driver, logger);
	    } catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return loginErrorPA;
	}


	
}
