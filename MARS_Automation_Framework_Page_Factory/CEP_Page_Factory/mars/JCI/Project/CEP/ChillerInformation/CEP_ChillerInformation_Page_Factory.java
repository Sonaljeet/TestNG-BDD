package mars.JCI.Project.CEP.ChillerInformation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_ChillerInformation_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	@SuppressWarnings("static-access")
	public CEP_ChillerInformation_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='col-md-4 margin-bottom-15']/div/div/h3")
	private List<WebElement> titleOfWidget;
	
	public List<WebElement> getTitle() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, titleOfWidget, logger) == true) {
			return titleOfWidget;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[@class='Customer_bottom padding-bottom-30 bg_color']/div/span")
	private WebElement defaultChillerInCustomerListByStatus;
	
	public WebElement getDefualtChiller() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, defaultChillerInCustomerListByStatus, logger) == true) {
			return defaultChillerInCustomerListByStatus;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[@class='col-md-12 margin-top-10 padding-left-10']/p")
	private WebElement defaultChillerInChillerInfo;
	
	public WebElement getDefualtChillerCI() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, defaultChillerInChillerInfo, logger) == true) {
			return defaultChillerInChillerInfo;
		} else {
			return null;
		}
	}
	//Get selected customer and project from the CustomerListByStatus section
	@FindBy(xpath="//div[@class='Customer_bottom bg_color']/div/span")
	private List<WebElement> selectedCustomerAndProject;
	
	public List<WebElement> getSelectedCustomerAndProject() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectedCustomerAndProject, logger) == true) {
			return selectedCustomerAndProject;
		} else {
			return null;
		}
	}
	
	//Get Default Details in the ChillerInformation section
	@FindBy(xpath="//div[@class='row information']/div[@class='col-sm-9 col-md-9 padding-left-0']")
	private List<WebElement> chillerInfoDetails;
	
	public List<WebElement> getChillerInfoDetails() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerInfoDetails, logger) == true) {
			return chillerInfoDetails;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[@class='NoDataChillerInfoWidget']/h4")
	private WebElement chillerInfoNoData;
	
	public WebElement getChillerInfoDetailsNoData() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerInfoNoData, logger) == true) {
			return chillerInfoNoData;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='row information']/div[@class='col-sm-3 col-md-3']")
	private List<WebElement> tempValue;
	
	public List<WebElement> getTemperature() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, tempValue, logger) == true) {
			return tempValue;
		} else {
			return null;
		}
	}
	//Spinner in Chiller Information widget
	@FindBy(css="div.overlayheatmap>spinner")
	private WebElement spinner;
	
	public WebElement getSpinner() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, spinner, logger) == true) {
			return spinner;
		} else {
			return null;
		}
	}
	
	public boolean getSpinnerStatus() throws Exception {
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.visibilityOf(spinner));
	        return spinner.isDisplayed();
	    } catch (org.openqa.selenium.NoSuchElementException
	            | org.openqa.selenium.StaleElementReferenceException
	            | org.openqa.selenium.TimeoutException e) {
	        return false;
	    }
	}
	//Get arrow
	@FindBy(xpath="//div[@class='col-md-12 padding-right-0']/img")
	private List<WebElement> scrollList;
	
	public List<WebElement> getScrollList() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, scrollList, logger) == true) {
			return scrollList;
		} else {
			return null;
		}
	}
	
}
