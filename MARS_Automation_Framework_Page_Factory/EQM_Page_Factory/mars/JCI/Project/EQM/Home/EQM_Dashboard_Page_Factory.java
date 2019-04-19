package mars.JCI.Project.EQM.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebDropDown;

public class EQM_Dashboard_Page_Factory {
	
	private WebDriver driver = null;
	private ExtentTest logger = null;
	private final String EMPTY_STRING = "";
	
	WebDropDown Webdrop=new WebDropDown();
	
	
	public EQM_Dashboard_Page_Factory(WebDriver driver, ExtentTest logger)
	{
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="ddlBusinessGroup")
	private WebElement Productgroup;
	
	
	
	
	@FindBy(xpath="//input[@value='Generate Report']")
	private WebElement GenerateReport;

	
	
	
	
	

}
