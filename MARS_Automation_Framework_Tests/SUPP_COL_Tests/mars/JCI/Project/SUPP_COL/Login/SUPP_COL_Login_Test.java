package mars.JCI.Project.SUPP_COL.Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.Component.Functions.LocalDriverFactory;
import mars.JCI.Project.EQM.Home.EQM_Home_Page_Action;
import mars.JCI.Project.EQM.Login.EQM_Login_Page_Action;

public class SUPP_COL_Login_Test extends BaseClass{
	
	// Common Class variables
		private WebDriver driver;
		
		// Test Cases for Login Functionality
		@Parameters({"correctusername","correctpassword"})
	    @Test(description="Performs a successful login and checks whether the Home page is opened")
		public void testSuccessfulLogin(String correctusername, String correctpassword) throws IOException{
	    	driver = LocalDriverFactory.createInstance(BaseClass.BaseURL,"chrome");
	    	SUPP_COL_Login_Page_Action loginPA = new SUPP_COL_Login_Page_Action(driver, BaseClass.logger);
			loginPA.correctLogin(correctusername, correctpassword);
			BaseClass.getFinalReport(
								driver, BaseClass.logger, BaseClass.methodName ,
								true);
		}
  
}
