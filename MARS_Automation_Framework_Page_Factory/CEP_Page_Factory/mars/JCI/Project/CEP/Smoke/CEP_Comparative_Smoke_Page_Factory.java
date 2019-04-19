package mars.JCI.Project.CEP.Smoke;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_Comparative_Smoke_Page_Factory {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public CEP_Comparative_Smoke_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='ui-rangeSlider-container']")
	private WebElement slider;
	
	public WebElement getSlider() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, slider, logger) == true) {
			return slider;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[contains(@class,'text-right margin-right-10')]/button")
	private WebElement addButton;
	
	public WebElement getAddButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, addButton, logger) == true) {
			return addButton;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='col-xs-12 col-sm-12 margin-top-10']/input")
	private WebElement selectAllOverviewPts;
	
	public WebElement getOverviewChkBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectAllOverviewPts, logger) == true) {
			return selectAllOverviewPts;
		} else {
			return null;
		}
	}
	
	//Search text box in Edit Point Window
	@FindBy(xpath="//div[@class='col-xs-6 col-md-4']/div/input")
	private WebElement searchBox;
	
	public WebElement getSearchBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, searchBox, logger) == true) {
			return searchBox;
		} else {
			return null;
		}
	}

	@FindBy(xpath="//div[@class=' col-sm-12 padding-left-10']/div/div[2]/input")
	private WebElement secondOverviewPtCheckBox;
	
	public WebElement getSecondOverviewPtChkBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, secondOverviewPtCheckBox, logger) == true) {
			return secondOverviewPtCheckBox;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class=' col-sm-12 padding-left-10']/div/div[3]/input")
	private WebElement thirdOverviewPtCheckBox;
	
	public WebElement getThirdOverviewPtChkBox() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, thirdOverviewPtCheckBox, logger) == true) {
			return thirdOverviewPtCheckBox;
		} else {
			return null;
		}
	}
	
	
	public WebElement getFourthOverviewPtChkBox() throws Exception {
		WebElement element = driver.findElement(By.xpath(
				"(//div[@class=' col-sm-12 padding-left-10']/div/div[4]/input)[12]"));
		if(element!=null) {
			return element;
		}
		else{
			return null;
		}
	}
	
	@FindBy(xpath="//div[contains(@class,'text-center')]/button[text()='OK']")
	private WebElement okButtonInSelectChart;
	
	public WebElement getOKButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, okButtonInSelectChart, logger) == true) {
			return okButtonInSelectChart;
		} else {
			return null;
		}
	}
	
	public WebElement getOKButtonInEdit() throws Exception {
		WebElement element = driver.findElement(By.xpath(
				"(//div[contains(@class,'col-xs-12 margin-top-bottom-10')]/button[@id='save'])[2]"));
		if(element!=null) {
			return element;
		}
		else{
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='modal-footer text-center']/button[text()='Yes']")
	private WebElement yesButtonInConfirm;
	
	public WebElement getYesButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, yesButtonInConfirm, logger) == true) {
			return yesButtonInConfirm;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='modal-footer text-center']/button[text()='No']")
	private WebElement noButtonInConfirm;
	
	public WebElement getNoButton() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, noButtonInConfirm, logger) == true) {
			return noButtonInConfirm;
		} else {
			return null;
		}
	}

	
//	@FindBy(xpath="//div[@class='modal-footer text-center']/button[text()='Yes']")
//	private List<WebElement> yesButtonForRemoveChart;
	
	public WebElement getYesButtonForRemoveChart() throws Exception {
		return driver.findElement(By.xpath("(//div[@class='modal-footer text-center']/button[text()='Yes'])[2]"));
	}
	
	@FindBy(xpath="//div[@class='col-sm-7']/input")
	private WebElement chartNameInput;
	
	public WebElement getChartNameInput() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chartNameInput, logger) == true) {
			return chartNameInput;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='content-header']/h3")
	private WebElement chartName;
	
	public WebElement getChartName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chartName, logger) == true) {
			return chartName;
		} else {
			return null;
		}
	}
	
	//Default Chart Name
	@FindBy(xpath="//div[@class='content-header']/h3[text()='Compare Chart - 1']")
	private WebElement defaultChartName1;
	
	public WebElement getDefaultChartName1() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, defaultChartName1, logger) == true) {
			return defaultChartName1;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='content-header']/h3[text()='Compare Chart - 2']")
	private WebElement defaultChartName2;
	
	public WebElement getDefaultChartName2() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, defaultChartName2, logger) == true) {
			return defaultChartName2;
		} else {
			return null;
		}
	}
	
	//Ok button in Confirmation window
	@FindBy(xpath="//div[@class='modal-footer text-center']/button[text()='OK']")
	private WebElement okButtonInConfirm;
	
	public WebElement getOkButtonInConfirm() throws Exception {
		if (okButtonInConfirm!=null) {
			return okButtonInConfirm;
		} else {
			return null;
		}
	}
	
	//Get Chart options
	@FindBy(xpath="//div[@class='content-header']/ul/li")
	private List<WebElement> chartOptions;
	
	public List<WebElement> getChartOption() throws Exception {
		if (chartOptions!=null) {
			return chartOptions;
		} else {
			return null;
		}
	}
	@FindBy(xpath="//div[@class='content_box']/div/ul/li[3]/ul/li")
	private List<WebElement> chartOptionsValues;
	
	public List<WebElement> getChartOptionsValues() throws Exception {
		if (chartOptionsValues!=null) {
			return chartOptionsValues;
		} else {
			return null;
		}
	}
}
