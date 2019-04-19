package mars.JCI.Project.MUI.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Action;

/**
 * The Class MUI_Terms_And_Conditions_Page_Action.
 */
public class MUI_Terms_And_Conditions_Page_Action {
	
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
	public MUI_Terms_And_Conditions_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	

	/**
	 * Verify legal Terms and Conditions page displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLegalPageDisplayed(){
		MUI_Terms_And_Conditions_Page_Factory termsConditionPF = new MUI_Terms_And_Conditions_Page_Factory(driver, logger);
		boolean LegalPageDisplayed = false;
		element = termsConditionPF.getLegalPage();
		if(element!= null){
			if(element.isDisplayed()){
				LegalPageDisplayed = true;
				logger.log(LogStatus.PASS, "Verified Terms and Conditions page IS displayed");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Terms and Conditions page is NOT displayed.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Terms and Conditions Page Element returns NULL.");
		}
		return LegalPageDisplayed;
	}
	
	
	/**
	 * Verify legal Terms and Conditions Accept button displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLegalAcceptButtonDisplayed(){
		MUI_Terms_And_Conditions_Page_Factory termsConditionPF = new MUI_Terms_And_Conditions_Page_Factory(driver, logger);
		boolean LegalAcceptButtonDisplayed = false;
		element = termsConditionPF.getLegalAcceptButton();
		if(element!= null){
			if(element.isDisplayed()){
				LegalAcceptButtonDisplayed = true;
				logger.log(LogStatus.PASS, "Verified Terms and Conditions Accept button IS displayed");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Terms and Conditions Accept button NOT displayed.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Terms and Conditions Accept button Element returns NULL.");
		}
		return LegalAcceptButtonDisplayed;
	}
	
	/**
	 * Verify legal Terms and Conditions Cancel button displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLegalCancelButtonDisplayed(){
		MUI_Terms_And_Conditions_Page_Factory termsConditionPF = new MUI_Terms_And_Conditions_Page_Factory(driver, logger);
		boolean verifyLegalCancelButton = false;
		element = termsConditionPF.getLegalCancelButton();
		if(element!= null){
			if(element.isDisplayed()){
				verifyLegalCancelButton = true;
				logger.log(LogStatus.PASS, "Verified Terms and Conditions Cancel button IS displayed");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Terms and Conditions Cancel button NOT displayed.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Terms and Conditions Cancel button Element returns NULL.");
		}
		return verifyLegalCancelButton;
		
		
	}

	/**
	 * Verify legal Terms and Conditions Accept button clicked.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLegalAcceptButtonClicked(){
		MUI_Terms_And_Conditions_Page_Factory termsConditionPF = new MUI_Terms_And_Conditions_Page_Factory(driver, logger);
		boolean LegalAcceptButtonClicked = false;
		element = termsConditionPF.getLegalAcceptButton();
		if(element!= null){
			if(element.isEnabled()){
				WebButton.Button_Click(driver, element);
				LegalAcceptButtonClicked = true;
				logger.log(LogStatus.PASS, "Verified Terms and Conditions Accept button IS clicked");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Terms and Conditions Accept button NOT displayed.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Terms and Conditions Accept button Element returns NULL.");
		}
		return LegalAcceptButtonClicked;
	}
	
	/**
	 * Verify legal Terms and Conditions Cancel button clicked.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLegalCancelButtonClicked(){
		MUI_Terms_And_Conditions_Page_Factory termsConditionPF = new MUI_Terms_And_Conditions_Page_Factory(driver, logger);
		boolean LegalCancelButtonClicked = false;
		element = termsConditionPF.getLegalCancelButton();
		if(element!= null){
			if(element.isEnabled()){
				WebButton.Button_Click(driver, element);
				LegalCancelButtonClicked = true;
				logger.log(LogStatus.PASS, "Verified Terms and Conditions Cancel button IS clicked");
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Terms and Conditions Cancel button NOT clicked.");
			}
		}
		else{
			logger.log(LogStatus.FAIL, " Terms and Conditions Cancel button Element returns NULL.");
		}
		return LegalCancelButtonClicked;
	}
	/**
	 * New user login, legal cancel.
	 *
	 * @param username the new username
	 * @param password the newuser password
	 * @return the MUI home page action
	 */
	public MUI_Login_Page_Action checkMUILoginLegalCancel() {
		MUI_Login_Page_Action loginPA = null;
		try {
			//verifySSL();
			if (verifyLegalPageDisplayed()){
			 WebElementCommon.staticWait(300);
			 if(verifyLegalCancelButtonDisplayed()){
			  WebElementCommon.staticWait(300);
			  verifyLegalCancelButtonClicked();
			  WebElementCommon.staticWait(500);
			 }
			 loginPA = new MUI_Login_Page_Action(driver, logger);
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return loginPA;
    }

	/**
	 * New user login, legal accept.
	 *
	 * @param username the new username
	 * @param password the newuser password
	 * @return the MUI home page action
	 */

	public MUI_Home_Page_Action checkMUILoginLegalAccept() {
		MUI_Home_Page_Action homePA = null;
		try {
			//verifySSL();
			if (verifyLegalPageDisplayed()){
			 WebElementCommon.staticWait(300);
			 if(verifyLegalAcceptButtonDisplayed()){
			  WebElementCommon.staticWait(300);
			  verifyLegalAcceptButtonClicked();
			  WebElementCommon.staticWait(500);
			 }
			 homePA = new MUI_Home_Page_Action(driver, logger);
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return homePA;
    }
	
}
