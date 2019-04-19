package mars.JCI.Project.GEBT.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.WebButton;
import commonFunctions.WebInputTextBox;

/**
 * The Class GEBT_Login_Page_Action.
 */
public class GEBT_Login_Page_Action {
	
	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	/**
	 * Instantiates/Constructor a new GEBT login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public GEBT_Login_Page_Action(WebDriver driver, ExtentTest logger) {
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
		
		GEBT_Login_Page_Factory loginPF = new GEBT_Login_Page_Factory(driver);
		element = loginPF.getUserName();
		if(element!= null){
			if(element.isDisplayed()){
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
		
		GEBT_Login_Page_Factory loginPF = new GEBT_Login_Page_Factory(driver);
		element = loginPF.getPassword();
		if(element!= null){
			if(element.isDisplayed()){
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
		GEBT_Login_Page_Factory loginPF = new GEBT_Login_Page_Factory(driver);
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
	 * Click sign in.
	 * 
	 * @return None
	 */
	public void clickSignIn () {
		
		GEBT_Login_Page_Factory loginPF = new GEBT_Login_Page_Factory(driver);
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
	 * @return the eqm home page action
	 */
	public void correctLogin(String username, String password) {
		try {
			verifySSL();
			enterUserID(username);
			enterPassword(password);
			clickSignIn();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
    }
}