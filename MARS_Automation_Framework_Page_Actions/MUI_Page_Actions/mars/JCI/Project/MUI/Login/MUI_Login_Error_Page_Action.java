package mars.JCI.Project.MUI.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.MUI.Home.MUI_Home_Page_Factory;

public class MUI_Login_Error_Page_Action {
	
	private WebDriver driver;
	private ExtentTest logger;
	private WebElement element;
	
	private final String TITLE = "Metasys UI";
	
	public MUI_Login_Error_Page_Action(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
	}
	
	public boolean isAt() {
		
		return this.driver.getTitle().equals(TITLE);
	}
	
	public boolean compareErrorText(String textToCompare) {
		boolean errorMessage = false;
		MUI_Login_Page_Factory loginPF = new MUI_Login_Page_Factory(driver);
		element = loginPF.getWrongUserError();
		if(element!= null){
			if(WebElementCommon.waitForTextToAppear(driver, 
												textToCompare, 
												element,
												logger)){
				errorMessage = true;
				logger.log(LogStatus.PASS, "Succesfully identify Error Text Message");
			}else{
				logger.log(LogStatus.FAIL, "Get the Error Text Message Failed"); 
			}
			
		}else{
			logger.log(LogStatus.FAIL, "Get the Error Text Element Failed");   
		}
		return errorMessage;
    }

	
	public boolean isErrorMsgPresent() {

		boolean errMsgPresent = false;
		try {
			MUI_Login_Page_Factory loginPF = new MUI_Login_Page_Factory(driver);
			element = loginPF.getWrongUserError();
			if(element!= null){
				logger.log(LogStatus.PASS, "Succesfully identify Invalid username or password error message");
				errMsgPresent = true;
//			errMsgPresent = WebElementCommon.isElementPresent(driver, element);
//			if(errMsgPresent){
//				logger.log(LogStatus.PASS, "Succesfully identify Invalid username or password error message");   
//			}
			}
			else{
				logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Identifying WebElement for Invalid Username or Password error message Failed");   
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return errMsgPresent;
	}

}
