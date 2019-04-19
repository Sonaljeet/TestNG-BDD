/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/

package mars.JCI.Project.BCMET.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCMET_Login_Page_Factory {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	public BCMET_Login_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	//@FindBy(id= "txtUserName")
	@FindBy(css= "input[automation_id=autField_UserName]")
	private WebElement username;
	public WebElement get_username(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, username, logger)==true) {
			element = username;
		}
		return element;
	}
	//@FindBy(id="txtPassword")
	@FindBy(css= "input[automation_id=autField_Password]")
	private WebElement password;
	public WebElement get_password(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, password, logger)==true) {
			element = password;
		}
		return element;
	}
		
	@FindBy(id= "ltHeader")
	private WebElement BCMHeader;
	public WebElement get_BCMHeader(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, BCMHeader, logger)==true) {
			element = BCMHeader;
		}
		return element;
	}
	
	@FindBy(css= "span[automation_id=autField_copyrightText]")
	private WebElement copyrightInfo;
	public WebElement get_copyrightInfo(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, copyrightInfo, logger)==true) {
			element = copyrightInfo;
		}
		return element;
	}
	
	@FindBy(css= "input[automation_id=\"autField_login_btn\"]")
	private WebElement btnLogin;
	public WebElement get_btnLogin(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, btnLogin, logger)==true) {
			element = btnLogin;
		}
		return element;
	}
	
	@FindBy(id= "lblerror")
	private WebElement ErrorInfo;
	public WebElement get_ErrorInfo(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, ErrorInfo, logger)==true) {
			element = ErrorInfo;
		}
		return element;
	}
/*	
	@FindBy(css= "")
	private WebElement username;
	public WebElement get_(){
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, webElement, logger)) {
			element = ;
		}
		return element;
	}
*/
}
