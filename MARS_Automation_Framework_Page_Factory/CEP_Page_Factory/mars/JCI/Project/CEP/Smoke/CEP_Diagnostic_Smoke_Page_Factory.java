package mars.JCI.Project.CEP.Smoke;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Diagnostic_Smoke_Page_Factory {

	private WebDriver driver;
	private ExtentTest logger;

	public CEP_Diagnostic_Smoke_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "DIAGNOSTICS")
	private WebElement diagnosticsLink;

	public WebElement getDiagnosticsLink() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, diagnosticsLink, logger) == true) {
			return diagnosticsLink;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='col-sm-4 col-md-2 margin-bottom-10']/select")
	private WebElement selectBox;

	public WebElement getSelectBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectBox, logger) == true) {
			return selectBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//b[text()='Customer']")
	private WebElement customerDropDown;

	public WebElement getCustomerDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customerDropDown, logger) == true) {
			return customerDropDown;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//select[@name='customerlist']")
	private WebElement selectCustomer;

	public WebElement getSelectCust() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectCustomer, logger) == true) {
			return selectCustomer;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//select[@name='projectList']")
	private WebElement selectProject;

	public WebElement getSelectProject() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectProject, logger) == true) {
			return selectProject;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//b[text()='Facility']")
	private WebElement facilityDropDown;

	public WebElement getFacilityDropDown() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, facilityDropDown, logger) == true) {
			return facilityDropDown;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//button[text()='Load more ']")
	private List<WebElement> loadMoreButton;

	public List<WebElement> getLoadMoreButton() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, loadMoreButton, logger) == true) {
			return loadMoreButton;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'col-md-8 statusList')]/ul/li[1]/input")
	private WebElement greenCheckBox;

	public WebElement getGreenCheckBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, greenCheckBox, logger) == true) {
			return greenCheckBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'col-md-8 statusList')]/ul/li[2]/input")
	private WebElement yellowCheckBox;

	public WebElement getYellowCheckBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, greenCheckBox, logger) == true) {
			return yellowCheckBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'col-md-8 statusList')]/ul/li[3]/input")
	private WebElement orangeCheckBox;

	public WebElement getOrangeCheckBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, greenCheckBox, logger) == true) {
			return orangeCheckBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[contains(@class,'col-md-8 statusList')]/ul/li[4]/input")
	private WebElement redCheckBox;

	public WebElement getRedCheckBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, greenCheckBox, logger) == true) {
			return redCheckBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//div[@class='blob blob-0']")
	private WebElement blob;

	public WebElement getBlob() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, blob, logger) == true) {
			return blob;
		} else {
			return null;
		}
	}

	public boolean getBlobStatus() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(blob));
			return blob.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException
				| org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	@FindBy(xpath = "//button[text()='Show']")
	private WebElement showButton;

	public WebElement getShowButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, showButton, logger) == true) {
			return showButton;
		} else {
			return null;
		}
	}

}
