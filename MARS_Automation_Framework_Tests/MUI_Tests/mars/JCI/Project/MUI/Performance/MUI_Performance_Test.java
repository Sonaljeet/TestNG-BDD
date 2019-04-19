package mars.JCI.Project.MUI.Performance;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import mars.JCI.Project.MUI.Login.*;
import mars.JCI.Project.MUI.Home.*;
import mars.Component.Functions.*;
import commonFunctions.*;

public class MUI_Performance_Test {
	private WebDriver driver;
	private String baseUrl;
	private WebElement element;
	private Logger logger;
	private StringBuffer verificationErrors = new StringBuffer();
	Map<String, Object[]> data = new TreeMap<String, Object[]>();
	int count = 0;
	
	@BeforeTest
	  public void beforeTest() {
		logger=Logger.getLogger("MUI_Performance_Test");
		
		// configure log4j properties file
		PropertyConfigurator.configure("Log4j.properties");
		
		baseUrl = "https://10.10.87.103/UI/";
		data.put("1", new Object[] {"TEST", "BUILD", "DATE", "NAE", "PROTOCOL", "CLIENT", "TIME_SEC", "SAMPLE_NO"});
    }
	
	/*@BeforeMethod
	public void setUp() throws Exception {
		// Here we need to create logger instance so we need to pass Class name for 
		logger=Logger.getLogger("MUI_Performance_Test");
		
		// configure log4j properties file
		PropertyConfigurator.configure("Log4j.properties");
		
		baseUrl = "https://10.10.87.103/UI/";
	}*/
	@Parameters({"correctusername","correctpassword"})
    @Test(invocationCount = 2)
	public void testSuccessfulLogin(String username, String password){
			
		/*driver = ThreadPool.invokeBrowser(baseUrl, logger);
		MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(this.driver, logger);
		loginPA.VerifySSL();
		loginPA.EnterUserID(username);
		loginPA.EnterPassword(password);
		PerformanceReportGeneration.pageLoadStart();
		loginPA.ClickSignIn();
		MUI_Home_Page_Action hop = new MUI_Home_Page_Action(driver);
		//hop.waitForPageToLoad();
		data.put(Integer.toString(count+1), new Object[] {"adfdsssdssssss", "2.0.0.9817-MUI", 
				PerformanceReportGeneration.getCurrentDate(), "ADS-MUI", "","PC (IE)", 
  				String.valueOf(PerformanceReportGeneration.pageLoadTime()), count});
		PerformanceReportGeneration e = new PerformanceReportGeneration();
		e.writeData(data);
		Assert.assertEquals(hop.isAt(), true);
		driver.close();
	*/}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}*/
	
}
