package mars.JCI.Project.DES.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.MUI.Login.MUI_Login_Page_Factory;

public class DES_Login_Error_Page_Action {
	private WebDriver driver;
	private ExtentTest logger;
	private WebElement element;

	private final String TITLE = "DES";
	
	private static DES_Login_Page_Factory loginPF = null;
	
	public DES_Login_Error_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPF=new DES_Login_Page_Factory(driver, logger);
	}

	public boolean isAt() {

		return this.driver.getTitle().equals(TITLE);
	}

	public boolean compareErrorText(String textToCompare) {
		boolean errorMessage = false;
		
		element = loginPF.getWrongUserError();
		if (element != null) {
			if (WebElementCommon.waitForTextToAppear(driver, textToCompare, element, logger)) {
				errorMessage = true;
				logger.log(LogStatus.PASS, "Succesfully identify Error Text Message");
			} else {
				logger.log(LogStatus.FAIL, "Get the Error Text Message Failed");
			}

		} else {
			logger.log(LogStatus.FAIL, "Get the Error Text Element Failed");
		}
		return errorMessage;
	}
}
