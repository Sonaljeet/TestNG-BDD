package mars.JCI.Project.GEBT.Login;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import mars.JCI.Project.GEBT.Login.GEBT_Login_Page_Action;
import mars.Component.Functions.*;

public class GEBT_Login_Test extends BaseClass{
	// Common Class variables
	private WebDriver driver;
	
	// Test Cases for Login Functionality
	@Parameters({"correctusername","correctpassword"})
    @Test(description="Performs a successful login and checks whether the Home page is opened")
	public void testSuccessfulLogin(String correctusername, String correctpassword) throws IOException{
    	driver = LocalDriverFactory.createInstance(BaseClass.BaseURL,"ie");
		GEBT_Login_Page_Action loginPA = new GEBT_Login_Page_Action(driver, BaseClass.logger);
		loginPA.correctLogin(correctusername, correctpassword);
		Assert.assertEquals(BaseClass.getFinalReport(
							driver, BaseClass.logger, BaseClass.methodName ,
							true), false);
	}

}

