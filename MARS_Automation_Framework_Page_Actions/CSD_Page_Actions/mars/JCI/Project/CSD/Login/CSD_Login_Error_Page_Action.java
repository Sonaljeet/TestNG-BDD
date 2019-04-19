/**
 * 
 */
package mars.JCI.Project.CSD.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;

/**
 * @author cdeyso
 *
 */
public class CSD_Login_Error_Page_Action {

	

	private WebDriver driver;
	private ExtentTest logger;
	private WebElement element;
	
	private final String TITLE = "CSD 2.0";
	
	public CSD_Login_Error_Page_Action(WebDriver driver, ExtentTest logger) {
		
		this.driver = driver;
		this.logger = logger;
	}
	
	public boolean isAt() {
		
		return this.driver.getTitle().equals(TITLE);
	}
	
	
	
}
