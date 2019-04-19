package mars.JCI.Project.EQM.Login;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class EQM_Login_Page_Factory {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	private final String EMPTY_STRING = "";
	
	public EQM_Login_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="USER")
	private WebElement username;
	
	
	public WebElement getUserName(){
		WebElement element=null;
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, username, logger)) {
			element=username;
		}
		return element;
	}
	
	@FindBy(name="PASSWORD")
	private WebElement password;
	
	
	public WebElement getPassword(){
		WebElement element=null;
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, password, logger)) {
			element=password;
		}
		return element;
	}
	
	@FindBy(css="input[class=formbutton]")
	private WebElement btLogin;
	
	
	public WebElement getbtLogin()
	{
		WebElement element=null;
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, btLogin, logger)) {
			element=btLogin;
		}
		return element;
	}
	/**
	 * Instantiates a new EQM home page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public void EQM_Home_Page_Factory(WebDriver driver, ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > h4"  )
	private WebElement txtErrorMessage;

	public WebElement gettxtErrorMessage() 
	{
		WebElement element=null;
		commonFunctions.WebElementCommon.staticWait(5000);
		try {
			if (commonFunctions.WebElementCommon.waitForElementPresent(driver, txtErrorMessage, logger) == true) {
				element=txtErrorMessage;
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return txtErrorMessage;
		}
		return element;
	}
}
