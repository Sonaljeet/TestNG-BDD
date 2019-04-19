package mars.JCI.Project.EQM.Login;

import java.util.Set;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.JCI.Project.BCM.Login.BCM_Login_Page_Factory;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Action;


/**
 * The Class eqm_Login_Page_Action.
 */
public class EQM_Login_Page_Action
{
	
	private static final String EMPTY_STRING = null;

	/** The Selenium driver. */
	public static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	private static EQM_Login_Page_Factory loginPage =null;
	
	/**
	 * Instantiates/Constructor a new eqm login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public EQM_Login_Page_Action(WebDriver driver, ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		loginPage = new EQM_Login_Page_Factory(driver, logger);
	}
	
	/**
	 * Enter user ID.
	 *
	 * @param userName the user name
	 * 
	 * @return None
	 */
	private void enterUserID (String username) 
	{
		
		WebElement element = null; 
		element = loginPage.getUserName();
		if (element != null)
		{
			WebInputTextBox.SendInputTextBox(driver, element, username);
			logger.log(LogStatus.PASS, "User Name entered successfully in User Name field");
		} 
		else
			logger.log(LogStatus.FAIL, "Failed to find User Name field");
	}

		
	/**
	 * Enter password.
	 *
	 * @param password the password
	 * 
	 * @return None
	 */
	private void enterPassword (String password)
	{
		WebElement element = null; 
		element = loginPage.getPassword();
		if(element!= null){
			{
				WebInputTextBox.SendInputTextBox(driver, element, password);
				logger.log(LogStatus.PASS, "Password Entered succesfully to Password WebElement");   
			}
		}
		else
		
			logger.log(LogStatus.FAIL, "Failed to find password field");
		
	}
	
	//Click on login button.
	
	private static void clickOnLoginButton()
	{
		WebElement element = null;
		element = loginPage.getbtLogin();
		if (element != null)
		{
			commonFunctions.WebButton.Button_Click(driver, element);
			logger.log(LogStatus.PASS, "Login button clicked successfully");
		}
		else
			logger.log(LogStatus.FAIL, "Failed to find Login button");
	}
	
	/**
	 * Gets the erro message.
	 *
	 * @return the erro message
	 */
	public static String getErroMessage(String errorMessage) {
		WebElement element = null;
		String errorInfo = EMPTY_STRING;
		try {
			element = loginPage.gettxtErrorMessage();
			if (element != null) {
				WebElementCommon.staticWait(5000);
				WebElementCommon.waitForElementPresent(driver, element, logger);
				errorInfo = element.getText().trim();
				System.out.println("1 . error message -"+errorInfo);
				logger.log(LogStatus.PASS, "Successfully found error message which is </br>\"" + errorInfo + "\"");
				// return errorInfo;
			} else {
				logger.log(LogStatus.FAIL, "Failed to find the Error message element");
				// return EMPTY_STRING;
			}
		}
		catch (TimeoutException e)
		{
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Error occured getting the WebElement" + e.getMessage());
			logger.log(LogStatus.FAIL, "Failed to find the Error message element");
		}
		return errorInfo;
	}

	
	/**
	 * Successful login.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the Eqm set up home page action
	 */
	public boolean successfulLogin(String username, String password)
	{
	
		try 
		{
			
			enterUserID(username);
			enterPassword(password);
			clickbtLogin();
		} 
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return false;
		
    }
	
	

	private void clickbtLogin() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Verify error message for incorrect user name.
	 *
	 * @param username
	 *            the username
	 * @param Password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForIncorrectUserName(String username, String Password) {
		enterUserID(username);
		enterPassword(Password);
		clickOnLoginButton();
		String errInfo = getErroMessage("Invalid Login");
		return errInfo;
	}

	/**
	 * Verify error message for blank user name.
	 *
	 * @param username
	 *            the username
	 * @param Password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForBlankUserName(String username, String Password) {
		enterUserID("");
		enterPassword(Password);
		clickOnLoginButton();
		String errInfo = getErroMessage("Please enter username");
		return errInfo;
	}
	/**
	 * Verify error message for incorrect password.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForIncorrectPassword(String username, String password) 
	{
		String errInfo = null;
		enterUserID(username);
		enterPassword(password);
		clickOnLoginButton();
		errInfo = getErroMessage("Invalid Login");
		return errInfo;
	}

	/**
	 * Verify error message for blank password.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the string
	 */
	public String verifyErrorMessageForBlankPassword(String username, String Password) {
		String errInfo = null;
		enterUserID(username);
		enterPassword(Password);
		clickOnLoginButton();
		errInfo = getErroMessage("We are unable to verify your user ID and/or password. Please verify your information and try again."
+"If you need, help click the appropriate link below.");
		
		System.out.println("errInfo action " +errInfo);
		return errInfo;
	}
}
