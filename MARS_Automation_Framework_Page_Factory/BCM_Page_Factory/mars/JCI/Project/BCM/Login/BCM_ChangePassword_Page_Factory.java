/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Login;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import commonFunctions.WebPage;

/**
 * @author cpandeak
 *
 */
public class BCM_ChangePassword_Page_Factory {

    private WebDriver driver;
    private ExtentTest logger;
    private WebElement element;

    /**
     * Instantiates a new BCM change password page factory.
     *
     * @param driver the driver
     * @param logger the logger
     */
    public BCM_ChangePassword_Page_Factory(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[automation_id=changePwdPage_Text_BCMHeader]")
    private WebElement txt_BCMHeader;
    
    public WebElement getBCMHeader(){
    	commonFunctions.WebElementCommon.staticWait(5000);
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txt_BCMHeader, logger)==true) {
			return txt_BCMHeader;
		}else
			return null;
    }

    @FindBy(css = "span[automation_id=changePwdPage_Text_ChangePassword]")
    private WebElement txtChangePassword;
    
    /**
     * Gets the txt change password.
     *
     * @return the txt change password
     */
    public WebElement gettxtChangePassword(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txtChangePassword, logger)==true) {
			return txtChangePassword;
		}else
			return null;
    }

    @FindBy(css = "input[automation_id=changePwdPage_Field_UserName]")
    private WebElement fieldUserName;
    
    public WebElement getfieldUserName(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, fieldUserName, logger)==true) {
			return fieldUserName;
		}else
			return null;
    }

    @FindBy(css = "input[automation_id=changePwdPage_Field_Password]")
    private WebElement fieldPassword;
    
    public WebElement getfieldPassword(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, fieldPassword, logger)==true) {
			return fieldPassword;
		}else
			return null;
    }

    @FindBy(css = "input[automation_id=changePwdPage_Field_Password]")
    private WebElement fieldOldPassword;
    
    public WebElement getfieldOldPassword(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, fieldOldPassword, logger)==true) {
			return fieldOldPassword;
		}else
			return null;
    }

    @FindBy(css = "input[automation_id=changePwdPage_Text_NewPassword]")
    private WebElement fieldNewPassword;
    
    public WebElement getfieldNewPassword(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, fieldNewPassword, logger)==true) {
			return fieldNewPassword;
		}else
			return null;
    }

    @FindBy(css = "input[automation_id=changePwdPage_Text_ConfirmPassword]")
    private WebElement fieldConfirmPassword;
    
    public WebElement getfieldConfirmPassword(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, fieldConfirmPassword, logger)==true) {
			return fieldConfirmPassword;
		}else
			return null;
    }

    @FindBy(css = "input[automation_id=changePwdPage_Btn_ChangePassword]")
    private WebElement btnChangePassword;
    
    public WebElement getbtnChangePassword(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, btnChangePassword, logger)==true) {
			return btnChangePassword;
		}else
			return null;
    }

    @FindBy(css = "span[automation_id=changePwdPage_Link_BlockedWordList]")
    private WebElement linkBlockedKeyword;
    
    public WebElement getlinkBlockedKeyword(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, linkBlockedKeyword, logger)==true) {
			return linkBlockedKeyword;
		}else
			return null;
    }

    @FindBy(css = "span[automation_id=changePwdPage_Link_PasswordPolicy]")
    private WebElement linkPasswordPolicy;
    
    public WebElement getlinkPasswordPolicy(){
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, linkPasswordPolicy, logger)==true) {
			return linkPasswordPolicy;
		}else
			return null;
    }

    @FindBy(css = "span[automation_id=loginPage_Field_copyrightText]")
    private WebElement txtCopyRightInfo;
    
    public WebElement gettxtCopyRightInfo(){
    	WebPage.waitForJSandJQueryToLoad(driver);
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txtCopyRightInfo, logger)==true) {
			return txtCopyRightInfo;
		}else
			return null;
    }

    @FindBy(css = "span[automation_id=changePwdPage_Text_ErrorMessage]")
    private WebElement divErrorMessage;
    
    public WebElement getdivErrorMessage(String textToAppear){
    	WebElement element=null;
    	commonFunctions.WebElementCommon.staticWait(5000);
    	try {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, divErrorMessage, logger)==true) {
				logger.log(LogStatus.PASS, "Successfully found Error message");
				element= divErrorMessage;
			}
		} catch (StaleElementReferenceException e) {
			element= divErrorMessage;
			logger.log(LogStatus.FAIL, "Stale element exception. Couldn't locate the element.");
		}catch (TimeoutException e) {
			logger.log(LogStatus.FAIL, "Timeout execption finding the Error message.");
			e.printStackTrace();
		}
		return element;
    }

    @FindBy(css = "span[automation_id=changePwdPage_Img_username]")
    private WebElement imgUserName;
    
    public WebElement getimgUserName(){
    	commonFunctions.WebElementCommon.staticWait(5000);
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, imgUserName, logger)==true) {
			logger.log(LogStatus.PASS, "Successfully found the User Name image");
    		return imgUserName;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the User Name image");
			return null;
			}
    }

    @FindBy(css = "span[automation_id=changePwdPage_Img_Password]")
    private WebElement imgOldPassword;
    
    public WebElement getimgOldPassword(){
    	commonFunctions.WebElementCommon.staticWait(5000);
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, imgOldPassword, logger)==true) {
    		logger.log(LogStatus.PASS, "Successfully found the Old Password image");
    		return imgOldPassword;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find the Old Password image");
			return null;
			}
    }

    @FindBy(css = "span[automation_id=changePwdPage_Img_Exclamation]")
    private WebElement imgExclamation;
    
    public WebElement getimgExclamation(){
    	commonFunctions.WebElementCommon.staticWait(5000);
    	if (commonFunctions.WebElementCommon.waitForElementPresent(driver, imgExclamation, logger)==true) {
			return imgExclamation;
		}else
			return null;
    }

}
