package mars.JCI.Project.DES.CustomerSetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;

public class DES_CustomerSetup_Page_Factory {
	/** The WebDriver driver. */
	private static WebDriver driver;

	WebElement element = null;

	/** The ExtentTest logger. */
	private static ExtentTest logger;

	public DES_CustomerSetup_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger)
			throws TimeoutException {
		try {
			// Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					// Wait for the condition with timeout 30 seconds
					.withTimeout(15, TimeUnit.SECONDS)
					// poll interval of 1 seconds.
					.pollingEvery(1, TimeUnit.SECONDS)
					// ignore the NoSuchElementException
					.ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " + e.getMessage().substring(0, 150));
			return false;
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " + e.getMessage().substring(0, 150));
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR, " Failed! -- " + e.getMessage().substring(0, 150));
			return false;
		}
	}

	/** Customer tab Element. */
	@FindBy(css = "a[automation-id='custTab']")
	private WebElement customerTab;

	public WebElement getCustomerTab() {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (WebElementCommon.waitForElementPresent(driver, customerTab, logger) == true) {
			element = customerTab;
		}
		return element;
	}

	/** customerNameLabel */
	@FindBy(css = "label[automation-id='lblcustname']")
	private WebElement customerNameLabel;

	public WebElement getCustomerNameLabel() {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (WebElementCommon.waitForElementPresent(driver, customerNameLabel, logger) == true) {
			element = customerNameLabel;
		}
		return element;
	}

	/** customerNameTextBox */
	@FindBy(css = "input[automation-id='customerName']")
	private WebElement customerNameTextBox;

	public WebElement getCustomerNameTextBox() {
		commonFunctions.WebElementCommon.staticWait(1200);
		if (WebElementCommon.waitForElementPresent(driver, customerNameTextBox, logger) == true) {
			element = customerNameTextBox;
		}
		return element;
	}

	/** customerAbbrivationLabel */
	@FindBy(css = "label[automation-id='lblabbreviation']")
	private WebElement customerAbbrivationLabel;

	public WebElement getCustomerAbbrivationLabel() {
				if (WebElementCommon.waitForElementPresent(driver, customerAbbrivationLabel, logger) == true) {
			element = customerAbbrivationLabel;
		}
		return element;
	}

	/** customerAbbreviationTextBox */
	@FindBy(css = "input[automation-id='custAbbreviation']")
	private WebElement customerAbbreviationTextBox;

	public WebElement getcustomerAbbreviationTextBox() {
		
		if (WebElementCommon.waitForElementPresent(driver, customerAbbreviationTextBox, logger) == true) {
			element = customerAbbreviationTextBox;
		}
		return element;
	}

	/** customerlblcustAddress1Label */
	@FindBy(css = "label[automation-id='lblcustAddress1']")
	private WebElement customerlblcustAddress1Label;

	public WebElement getCustomerlblcustAddress1() {
				if (WebElementCommon.waitForElementPresent(driver, customerlblcustAddress1Label, logger) == true) {
			element = customerlblcustAddress1Label;
		}
		return element;
	}

	/** customerAddress1TextBox */
	@FindBy(css = "input[automation-id='custAddress1']")
	private WebElement customerAddress1TextBox;

	public WebElement getcustomerAddress1TextBox() {
				if (WebElementCommon.waitForElementPresent(driver, customerAddress1TextBox, logger) == true) {
			element = customerAddress1TextBox;
		}
		return element;
	}

	/** customerlblcustAddress2Label */
	@FindBy(css = "label[automation-id='lblAddress2']")
	private WebElement customerlblcustAddress2Label;

	public WebElement getCustomerlblcustAddress2() {
		
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustAddress2Label, logger) == true) {
			element = customerlblcustAddress2Label;
		}
		return element;
	}

	/** customerAddress2TextBox */
	@FindBy(css = "input[automation-id='custAddress2']")
	private WebElement customerAddress2TextBox;

	public WebElement getcustcustomerAddress2TextBox() {
				if (WebElementCommon.waitForElementPresent(driver, customerAddress2TextBox, logger) == true) {
			element = customerAddress2TextBox;
		}
		return element;
	}

	/** customerlblcustCountriesLabel */
	@FindBy(css = "label[automation-id='lblcustCountries']")
	private WebElement customerlblcustCountriesLabel;

	public WebElement getCustomerlblcustCountries() {		
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustCountriesLabel, logger) == true) {
			element = customerlblcustCountriesLabel;
		}
		return element;
	}

	/** customerCountryDropdown */
	@FindBy(css = "select[automation-id='custCountries']")
	private WebElement customerCountryDropdown;

	public WebElement getcustomerCountryDropdown() {		
		if (WebElementCommon.waitForElementPresent(driver, customerCountryDropdown, logger) == true) {
			element = customerCountryDropdown;
		}
		return element;
	}

	/** customerlblcustStates */
	@FindBy(css = "label[automation-id='lblcustStates']")
	private WebElement customerlblcustStates;

	public WebElement getcustomerlblcustStates() {		
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustStates, logger) == true) {
			element = customerlblcustStates;
		}
		return element;
	}

	/** customerStateDropdown */
	@FindBy(css = "select[automation-id='custStates']")
	private WebElement customerStateDropdown;

	public WebElement getcustomerStateDropdown() {
				if (WebElementCommon.waitForElementPresent(driver, customerStateDropdown, logger) == true) {
			element = customerStateDropdown;
		}
		return element;
	}

	/** customerlblcustcities */
	@FindBy(css = "label[automation-id='lblcustcities']")
	private WebElement customerlblcustcities;

	public WebElement getcustomerlblcustcities() {
			if (WebElementCommon.waitForElementPresent(driver, customerlblcustcities, logger) == true) {
			element = customerlblcustcities;
		}
		return element;
	}

	/** customerCityDropdown */
	@FindBy(css = "select[automation-id='custCities']")
	private WebElement customerCityDropdown;

	public WebElement getcustomerCityDropdown() {		
		if (WebElementCommon.waitForElementPresent(driver, customerCityDropdown, logger) == true) {
			element = customerCityDropdown;
		}
		return element;
	}

	/** customerlblcustzipcode */
	@FindBy(css = "label[automation-id='lblcustzipcode']")
	private WebElement customerlblcustzipcode;

	public WebElement getcustomerlblcustzipcode() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustzipcode, logger) == true) {
			element = customerlblcustzipcode;
		}
		return element;
	}

	/** customerZipCode TextBox */
	@FindBy(css = "input[automation-id='custZipcode']")
	private WebElement customerZipcode;

	public WebElement getcustomerZipcode() {
		if (WebElementCommon.waitForElementPresent(driver, customerZipcode, logger) == true) {
			element = customerZipcode;
		}
		return element;
	}

	/** customerlblLogo */
	@FindBy(css = "label[automation-id='lblcustlogo']")
	private WebElement customerlblcustlogo;

	public WebElement getcustomerlblcustlogo() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustlogo, logger) == true) {
			element = customerlblcustlogo;
		}
		return element;
	}

	/** customerLogo inputBox */
	@FindBy(css = "input[automation-id='custLogo']")
	private WebElement customerLogo;

	public WebElement getcustomerLogo() {
		if (WebElementCommon.waitForElementPresent(driver, customerLogo, logger) == true) {
			element = customerLogo;
		}
		return element;
	}

	/** customer contract type label */
	@FindBy(css = "label[automation-id='lblcustContactType']")
	private WebElement customerlblcustContactType;

	public WebElement getcustomerlblcustContactType() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustContactType, logger) == true) {
			element = customerlblcustContactType;
		}
		return element;
	}

	/** customerLogo contract type textbox */
	@FindBy(css = "input[automation-id='custContactType']")
	private WebElement customerContactType;

	public WebElement getcustomerContactTypeTextbox() {
		if (WebElementCommon.waitForElementPresent(driver, customerContactType, logger) == true) {
			element = customerContactType;
		}
		return element;
	}

	/** customer lblcustStartDate label */
	@FindBy(css = "label[automation-id='lblcustStartDate']")
	private WebElement customerlblcustStartDate;

	public WebElement getcustomerlblcustStartDate() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustStartDate, logger) == true) {
			element = customerlblcustStartDate;
		}
		return element;
	}

	/** custStartDate textbox */
	@FindBy(css = "input[automation-id='custStartDate']")
	private WebElement customercustStartDate;

	public WebElement getcustomercustStartDate() {
		if (WebElementCommon.waitForElementPresent(driver, customercustStartDate, logger) == true) {
			element = customercustStartDate;
		}
		return element;
	}

	/** customer lblcustEndDate label */
	@FindBy(css = "label[automation-id='lblcustEndDate']")
	private WebElement customerlblcustEndDate;

	public WebElement getcustomerlblcustEndDate() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustEndDate, logger) == true) {
			element = customerlblcustEndDate;
		}
		return element;
	}

	/** custStartDate textbox */
	@FindBy(css = "input[automation-id='custEndDate']")
	private WebElement customercustEndDate;

	public WebElement getcustomercustEndDate() {
		if (WebElementCommon.waitForElementPresent(driver, customercustEndDate, logger) == true) {
			element = customercustEndDate;
		}
		return element;
	}

	
	/** customer lblCustUnit label */
	@FindBy(css = "label[automation-id='lblCustUnit']")
	private WebElement customerlblCustUnit;

	public WebElement getcustomerlblCustUnit() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblCustUnit, logger) == true) {
			element = customerlblCustUnit;
		}
		return element;
	}

	/** Customer Contract label */
	@FindBy(css = "h3[automation-id='lblcustContact']")
	private WebElement customerContractlabel;

	public WebElement getcustomerContractlabel() {
		if (WebElementCommon.waitForElementPresent(driver, customerContractlabel, logger) == true) {
			element = customerContractlabel;
		}
		return element;
	}

	/** customer customerlblName label */
	@FindBy(css = "label[automation-id='lblName']")
	private WebElement customerlblName;

	public WebElement getcustomerlblName() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblName, logger) == true) {
			element = customerlblName;
		}
		return element;
	}

	/** customercustName textbox */
	@FindBy(css = "input[automation-id='custName']")
	private WebElement customercustName;

	public WebElement getcustomercustName() {
		if (WebElementCommon.waitForElementPresent(driver, customercustName, logger) == true) {
			element = customercustName;
		}
		return element;
	}

	/** customer Designation label */
	@FindBy(css = "label[automation-id='lblcustdesig']")
	private WebElement customerlblcustdesig;

	public WebElement getcustomerlblcustdesig() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblcustdesig, logger) == true) {
			element = customerlblcustdesig;
		}
		return element;
	}

	/** Designation textbox */
	@FindBy(css = "input[automation-id='custDesignation']")
	private WebElement customercustDesignation;

	public WebElement getcustomercustDesignation() {
		if (WebElementCommon.waitForElementPresent(driver, customercustDesignation, logger) == true) {
			element = customercustDesignation;
		}
		return element;
	}

	/** customer Contact No label */
	@FindBy(css = "label[automation-id='lblcontact']")
	private WebElement customerlblcontact;

	public WebElement getcustomerlblcontact() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblcontact, logger) == true) {
			element = customerlblcontact;
		}
		return element;
	}

	/** Contact No textbox */
	@FindBy(css = "input[automation-id='custContact']")
	private WebElement customercustContact;

	public WebElement getcustomercustContact() {
		if (WebElementCommon.waitForElementPresent(driver, customercustContact, logger) == true) {
			element = customercustContact;
		}
		return element;
	}

	/** customer Email label */
	@FindBy(css = "label[automation-id='lblemail']")
	private WebElement customerlblemail;

	public WebElement getcustomerlblemail() {
		if (WebElementCommon.waitForElementPresent(driver, customerlblemail, logger) == true) {
			element = customerlblemail;
		}
		return element;
	}

	/** Email textbox */
	@FindBy(css = "input[automation-id='custEmail']")
	private WebElement customercustEmail;

	public WebElement getcustomercustEmail() {
		if (WebElementCommon.waitForElementPresent(driver, customercustEmail, logger) == true) {
			element = customercustEmail;
		}
		return element;
	}

	/** Get Add button */
	@FindBy(css = "button[automation-id='btnCustAdd']")
	private WebElement Addbtn;

	public WebElement getAddbtn() {
		if (WebElementCommon.waitForElementPresent(driver, Addbtn, logger) == true) {
			element = Addbtn;
		}
		return element;
	}

	/** Get Update button */
	@FindBy(css = "button[automation-id='btnCustUpdate']")
	private WebElement Updatebtn;

	public WebElement getUpdatebtn() {
		if (WebElementCommon.waitForElementPresent(driver, Updatebtn, logger) == true) {
			element = Updatebtn;
		}
		return element;
	}

	/** Get Delete button */
	@FindBy(css = "button[automation-id='btnCustDelete']")
	private WebElement Deletebtn;

	public WebElement getDeletebtn() {
		if (WebElementCommon.waitForElementPresent(driver, Deletebtn, logger) == true) {
			element = Deletebtn;
		}
		return element;
	}

	/** grid forward button */
	@FindBy(css = "button[title='Page forward']")
	private WebElement gridForward;

	public WebElement getgriddForward() {
		if (WebElementCommon.waitForElementPresent(driver, gridForward, logger) == true) {
			element = gridForward;
		}
		return element;
	}

	/** Get Clear button */
	@FindBy(css = "button[automation-id='btnCustClear']")
	private WebElement Clearbtn;

	public WebElement getClearbtn() {
		if (WebElementCommon.waitForElementPresent(driver, Clearbtn, logger) == true) {
			element = Clearbtn;
		}
		return element;
	}

	/** Get success message */
	@FindBy(css = "div[class='growl-message ng-binding']")
	private WebElement CustomerSuccessMessage;

	public WebElement getCustomerSuccessMessage() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerSuccessMessage, logger) == true) {
			element = CustomerSuccessMessage;
		}
		return element;
	}

	/** Get first Element from Grid */
	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-0007-cell') +1) = '0-uiGrid-0007-cell']")
	private WebElement CustomerNameFromGrid;

	public WebElement getCustomerNameFromGrid() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerNameFromGrid, logger) == true) {
			element = CustomerNameFromGrid;
		}
		return element;
	}

	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-0008-cell') +1) = '0-uiGrid-0008-cell']")
	private WebElement CustomerAbbriviationFromGrid;

	public WebElement getCustomerAbbriviationFromGrid() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerAbbriviationFromGrid, logger) == true) {
			element = CustomerAbbriviationFromGrid;
		}
		return element;
	}

	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-0009-cell') +1) = '0-uiGrid-0009-cell']")
	private WebElement CustomerContractTypeFromGrid;

	public WebElement getCustomerContractTypeFromGrid() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerContractTypeFromGrid, logger) == true) {
			element = CustomerContractTypeFromGrid;
		}
		return element;
	}

	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-000A-cell') +1) = '0-uiGrid-000A-cell']")
	private WebElement CustomerContractStartDateGrid;

	public WebElement getCustomerContractStartDateGrid() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerContractStartDateGrid, logger) == true) {
			element = CustomerContractStartDateGrid;
		}
		return element;
	}

	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-000B-cell') +1) = '0-uiGrid-000B-cell']")
	private WebElement CustomerContractEndDateGrid;

	public WebElement getCustomerContractEndDateGrid() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerContractEndDateGrid, logger) == true) {
			element = CustomerContractEndDateGrid;
		}
		return element;
	}

	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-000C-cell') +1) = '0-uiGrid-000C-cell']")
	private WebElement CustomerStateFromGrid;

	public WebElement getCustomerStateFromGrid() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerStateFromGrid, logger) == true) {
			element = CustomerStateFromGrid;
		}
		return element;
	}

	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-000D-cell') +1) = '0-uiGrid-000D-cell']")
	private WebElement CustomerCityFromGrid;

	public WebElement getCustomerCityFromGrid() {
		if (WebElementCommon.waitForElementPresent(driver, CustomerCityFromGrid, logger) == true) {
			element = CustomerCityFromGrid;
		}
		return element;
	}

	@FindBy(xpath = "//div[substring(@id, string-length(@id) - string-length('0-uiGrid-000E-cell') +1) = '0-uiGrid-000E-cell']")
	private WebElement CustomerZipcodeFromGrid;

	public WebElement getCustomerZipcodeFromGrid() {
			if (WebElementCommon.waitForElementPresent(driver, CustomerZipcodeFromGrid, logger) == true) {
			element = CustomerZipcodeFromGrid;
		}
		return element;
	}

	/** Get the First Element of Grid */
	@FindBy(xpath = "//div/div/div[3]/div/div/input")
	private WebElement gridTextBox;

	public WebElement getgridTextBox() {
			if (WebElementCommon.waitForElementPresent(driver, gridTextBox, logger) == true) {
			element = gridTextBox;
		}
		return element;
	}
	
	/** Get the First Element of Grid */
	@FindBy(css = "input[id='popup_ok']")
	private WebElement popup_ok;

	public WebElement getOkButton() {
			if (WebElementCommon.waitForElementPresent(driver, popup_ok, logger) == true) {
			element = popup_ok;
		}
		return element;
	}
	
	/** Get the First Element of Grid */
	@FindBy(css = "input[id='popup_cancel']")
	private WebElement popup_cancel;

	public WebElement getpopup_cancel() {
			if (WebElementCommon.waitForElementPresent(driver, popup_cancel, logger) == true) {
			element = popup_cancel;
		}
		return element;
	}

}
