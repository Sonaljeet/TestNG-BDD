package mars.JCI.Project.CEP.Smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Repo_Smoke_Page_Factory {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public CEP_Repo_Smoke_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="REPOSITORY")
	private WebElement repoLink;
	
	public WebElement getRepoLink() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, repoLink, logger) == true) {
			return repoLink;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement save;
	
	public WebElement getSave() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, save, logger) == true) {
			return save;
		} else {
			return null;
		}
	}
}
