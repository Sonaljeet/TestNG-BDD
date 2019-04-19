package mars.JCI.Project.MUI.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Action;

/**
 * The Class MUI_Change_Password_Page_Action.
 */
public class MUI_Change_Password_Page_Action {
	
	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	/**
	 * Instantiates/Constructor a new MUI Change Password page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MUI_Change_Password_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	public MUI_Change_Password_Page_Action() {
		MUI_Change_Password_Page_Action instance = new MUI_Change_Password_Page_Action(driver, logger);
	}
	
	/**
	 * Verify old password is displayed.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public boolean verifyOldPasswordIsDisplayed () {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		boolean isOldPasswordDisplayed = false;
		element = changePasswordPF.getOldPasswordField();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				logger.log(LogStatus.PASS, "Verified Old Password field IS Displayed"); 
				isOldPasswordDisplayed = true;
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Old Password field is NOT Displayed");
				isOldPasswordDisplayed = false;
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified Old Password field WebElement is NOT available on Page");   
		}
		return isOldPasswordDisplayed;
	}

	/**
	 * Verify value entered in old password field.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void verifyEnterOldPassword (String oldPassword) {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		element = changePasswordPF.getOldPasswordField();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Old Password");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, oldPassword);
				logger.log(LogStatus.PASS, "Old password IS entered succesfully to Old Password field."); 
				}
			else{
				logger.log(LogStatus.FAIL, "Old password is NOT entered to Old Password field.");
				}
		}
		else{
			logger.log(LogStatus.FAIL, "Old Password field WebElement is NOT available on Page");   
		    }
		}

	/**
	 * Verify new password is displayed.
	 * 
	 * @param None
	 * 
	 * @return None
	 */
	public boolean verifyNewPasswordIsDisplayed () {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		boolean isNewPasswordDisplayed = false;
		element = changePasswordPF.getNewPasswordField();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				logger.log(LogStatus.PASS, "Verified New Password field IS Displayed"); 
				isNewPasswordDisplayed = true;
			}
			else{
				logger.log(LogStatus.FAIL, "Verified New Password field is NOT Displayed");
				isNewPasswordDisplayed = false;
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified New Password field WebElement is NOT available on Page");   
		}
		return isNewPasswordDisplayed;
	}
	
	/**
	 * Verify value entered in new password field.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void verifyEnterNewPassword (String newPassword) {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		element = changePasswordPF.getNewPasswordField();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "New Password");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, newPassword);
				logger.log(LogStatus.PASS, "New password IS entered succesfully to Old Password field."); 
				}
			else{
				logger.log(LogStatus.FAIL, "New password is NOT entered to Old Password field.");
				}
		}
		else{
			logger.log(LogStatus.FAIL, "New Password field WebElement is NOT available on Page");   
		    }
		}

	/**
	 * Verify confirm password is displayed.
	 * 
	 * @param None
	 * 
	 * @return None
	 */
	public boolean verifyConfirmPasswordIsDisplayed () {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		boolean isConfirmPasswordDisplayed = false;
		element = changePasswordPF.getConfirmPasswordField();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				logger.log(LogStatus.PASS, "Confirm Password field IS Displayed");
				isConfirmPasswordDisplayed=true;
			}
			else{
				logger.log(LogStatus.FAIL, "Confirm Password field is NOT Displayed");
				isConfirmPasswordDisplayed=false;
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Confirm Password field WebElement is NOT available on Page");   
		}
		return isConfirmPasswordDisplayed;
	}

	/**
	 * Verify value entered in confirm password field.
	 *
	 * @param None
	 * 
	 * @return None
	 */
	public void verifyEnterConfirmPassword (String newPassword) {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		element = changePasswordPF.getConfirmPasswordField();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Confirm Password");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, newPassword);
				logger.log(LogStatus.PASS, "New password IS entered succesfully to Confirm Password field."); 
				}
			else{
				logger.log(LogStatus.FAIL, "New password is NOT entered to Confirm Password field.");
				}
		}
		else{
			logger.log(LogStatus.FAIL, "Confirm Password field WebElement is NOT available on Page");   
		    }
		}

	/**
	 * Verify Cancel update password button is displayed.
	 * 
	 * @param None
	 * 
	 * @return None
	 */
	public boolean verifyCancelUpdatePasswordBtnIsDisplayed () {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		boolean CancelUpdatePasswordBtnDisplayed = false;
		element = changePasswordPF.getCancelUpdatePasswordButton();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				logger.log(LogStatus.PASS, "Verified Confirm Password field IS Displayed");
				CancelUpdatePasswordBtnDisplayed=true;
			}
			else{
				logger.log(LogStatus.FAIL, "Verified Confirm Password field is NOT Displayed");
				CancelUpdatePasswordBtnDisplayed=false;
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Verified New Confirm field WebElement is NOT available on Page");   
		}
		return CancelUpdatePasswordBtnDisplayed;
	}

	/**
	 * Verify Cancel update password button is clicked.
	 * 
	 * @param None
	 * 
	 * @return None
	 */
	public void verifyCancelUpdatePasswordBtnClicked () {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		element = changePasswordPF.getCancelUpdatePasswordButton();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				WebButton.Button_Click(driver, element);
				logger.log(LogStatus.PASS, "Cancel update Password button IS clicked");				
			}
			else{
				logger.log(LogStatus.FAIL, "Cancel update Password button is NOT clicked");				
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Cancel update Password button is NOT available on Page");   
		}		
	}

	/**
	 * Verify Submit button to update password is displayed.
	 * 
	 * @param None
	 * 
	 * @return None
	 */
	public boolean verifyUpdatePasswordBtnIsDisplayed () {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		boolean UpdatePasswordBtnDisplayed = false;
		element = changePasswordPF.getCancelUpdatePasswordButton();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				logger.log(LogStatus.PASS, "Submit button to update the password IS Displayed");
				UpdatePasswordBtnDisplayed=true;
			}
			else{
				logger.log(LogStatus.FAIL, "Submit button to update the password is NOT Displayed");
				UpdatePasswordBtnDisplayed=false;
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Submit button to update the password WebElement is NOT available on Page");   
		}
		return UpdatePasswordBtnDisplayed;
	}

	
	/**
	 * Verify Submit button update password is clicked.
	 * 
	 * @param None
	 * 
	 * @return None
	 */
	public void verifyUpdatePasswordBtnClicked () {
		MUI_Change_Password_Page_Factory changePasswordPF = new MUI_Change_Password_Page_Factory(driver, logger);
		element = changePasswordPF.getUpdatePasswordButton();
		if(element!= null){
			if(WebElementCommon.isDisplayedByElement(element)){
				WebButton.Button_Click(driver, element);
				logger.log(LogStatus.PASS, "Submit button to update password IS clicked");				
			}
			else{
				logger.log(LogStatus.FAIL, "Submit button to update password is NOT clicked");				
			}
		}
		else{
			logger.log(LogStatus.FAIL, "Submit button to update password is NOT available on Page");   
		}		
	}

	/**
	 * Change Password user login cancel.
	 *
	 * @param username the change password username
	 * @param password the change password old password
	 * @return the MUI home page action
	 */
	public MUI_Login_Page_Action checkMUIChangePassCancel() {
		MUI_Login_Page_Action loginPA = null;
		try {
			//verifySSL();
			if (verifyOldPasswordIsDisplayed()){
			 if(verifyNewPasswordIsDisplayed()){
      		  verifyCancelUpdatePasswordBtnClicked();
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
	 * Change Password for user.
	 *
	 * @param username the change password username
	 * @param password the change password old password
	 * @param password the change password old password
	 * @return the MUI home page action
	 */
	public MUI_Home_Page_Action checkMUIChangePassSubmit(String oldPassword, String newPassword) {
		MUI_Home_Page_Action homePA = null;
		try {
			//verifySSL();
			if (verifyOldPasswordIsDisplayed()){
			 verifyEnterOldPassword(oldPassword);	
			 WebElementCommon.staticWait(200);
			 if(verifyNewPasswordIsDisplayed()){
			  verifyEnterNewPassword(newPassword);	 
			  WebElementCommon.staticWait(200);
			  verifyConfirmPasswordIsDisplayed();
			  verifyEnterConfirmPassword(newPassword);
			  WebElementCommon.staticWait(200);
			  verifyUpdatePasswordBtnClicked();
			  WebElementCommon.staticWait(300);
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
