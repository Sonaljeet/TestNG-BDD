package mars.JCI.Project.BCMET.Login;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.BCMET.Constants.BCMETTextConstants;
import mars.JCI.Project.BCMET.Constants.GlobalTestConstants;

public class BCMET_Login_Page_Test extends BaseClass{

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static BCMET_Login_Page_Action loginPageAction= null;
	
	private static void initialize(){
		System.out.println("Initialize");
		driver = BaseClass.driver;
		logger = BaseClass.logger;
		loginPageAction = new BCMET_Login_Page_Action(driver, logger);
	}
	
	@Test(description = "BCMET_Login - Verify successful login")
	public void verifySuccessfulUserLogin(Method method){
		initialize();
		boolean testStatus = false;
		try {
			testStatus = loginPageAction.successfulLogin(GlobalTestConstants.BCMETUsername, GlobalTestConstants.BCMETPassword);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			System.out.println("Complete");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}	
	}
	@Test(description="BCMET_Login - Verify error message for all fields blank")
	public void verifyErrorMessageForAllFieldsBlank(Method method){
		initialize();
		boolean testStatus = false;
		try {
			testStatus = loginPageAction.allFieldsBlankErrorMsgVerification(BCMETTextConstants.Login_BCMET_BlankLoginErrorMessage);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			System.out.println("Complete");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_Login - Verify error message for blank username")
	public void verifyErrorMessageForBlankUsername(Method method){
		initialize();
		boolean testStatus = false;
		try {
			testStatus = loginPageAction.userNameFieldBlankErrMsg(BCMETTextConstants.Login_BCMET_BlankUserName);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			System.out.println("Complete");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}

	@Test(description="BCMET_Login - Verify error message for blank password")
	public void verifyErrorMessageForBlankPassword(Method method){
		initialize();
		boolean testStatus = false;
		try {
			testStatus = loginPageAction.passwordFieldBlankErrMsg(BCMETTextConstants.Login_BCMET_BlankPassword);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			System.out.println("Complete");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
	@Test(description="BCMET_Login - Verify error message for invalid credentials")
	public void verifyErrorMessageForInvalidCredentials(Method method){
		initialize();
		boolean testStatus = false;
		try {
			testStatus = loginPageAction.invalidCredentialsErrorMsgVerification(BCMETTextConstants.Login_BCMET_InvalidCredentialsErrorMessage);
			BaseClass.getFinalReport(driver, logger, method.getName(), testStatus);
			System.out.println("Complete");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			BaseClass.getFinalReport(driver, logger, method.getName(), false);
		}
	}
	
/*	@Test(description="")
	public void verify(Method method){
		
	}
	
	@Test(description="")
	public void verify(Method method){
		
	}*/
}
