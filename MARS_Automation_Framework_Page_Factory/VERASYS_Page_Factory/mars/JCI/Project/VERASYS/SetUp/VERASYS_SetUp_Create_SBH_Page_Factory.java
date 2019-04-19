package mars.JCI.Project.VERASYS.SetUp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class VERASYS_SetUp_Create_SBH_Page_Factory {


	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new Verasys login page factory.
	 *
	 * @param driver the driver
	 */
	public VERASYS_SetUp_Create_SBH_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** All WebElements are identified by @FindBy annotation. */
	
	/**
	 * Gets the SBH Tab.
	 *
	 * @return the SBH Tab.
	 */
	@FindBy(css ="a[automation-id=tabDevice]")
	WebElement sbhTab;
	public WebElement getSBHTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sbhTab, logger)) {
			return this.sbhTab;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Customer Drop Down on SBH page.
	 *
	 * @return the Customer Drop Down.
	 */
	@FindBy(css ="select[automation-id=drpdwnsiteCustomers]")
	WebElement selectCustomer;
	public WebElement getCustomerDropDown() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, selectCustomer, logger)) {
			return this.selectCustomer;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Device List.
	 *
	 * @return the Device List.
	 */
	@FindBy(css ="ol[automation-id=DeviceList]")
	WebElement deviceList;
	public WebElement getDeviceList() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, deviceList, logger)) {
			return this.deviceList;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Device list.
	 *
	 * @return  .
	 */
	@FindAll({@FindBy(css ="div.form-control.setup-form.margin-btm")})
	List<WebElement> deviceTile;
	public List<WebElement> getDeviceTiles() {
		if (deviceTile.size()>0) {
			return (List<WebElement>) this.deviceTile;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Gets the SBH ID.
	 *
	 * @return the SBH ID.
	 */
	@FindBy(css ="input[automation-id=DeviceId]")
	WebElement sbhId;
	public WebElement getSBHId() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sbhId, logger)) {
			return this.sbhId;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Validate SBH ID button.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnValidateDevice]")
	WebElement validateSBHBtn;
	public WebElement getValidateBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, validateSBHBtn, logger)) {
			return this.validateSBHBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Cancel button on SBH page.
	 *
	 * @return the cancel btn.
	 */
	@FindBy(css ="button[automation-id=btnCancelSite]")
	WebElement cancelBtn;
	public WebElement getCancelBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, cancelBtn, logger)) {
			return this.cancelBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Validate SBH ID button.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnSaveSite]")
	WebElement saveSBHBtn;
	public WebElement getSaveBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, saveSBHBtn, logger)) {
			return this.saveSBHBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Validate SBH Check Mark.
	 *
	 * @return the Span.
	 */
	@FindBy(css ="span[automation-id=DeviceOK]")
	WebElement okCheck;
	public WebElement getValidateCheck() {
		if (commonFunctions.WebElementCommon.isElementPresent(driver, okCheck)) {
			return this.okCheck;
		} else {
			return null;
		}
	}
	/**
	 * Gets the Validate SBH Check Mark.
	 *
	 * @return the Span.
	*/
	@FindBy(css ="span[automation-id=DeviceCancel]")
	WebElement deviceCross;
	public WebElement getValidateCross() {
		if (commonFunctions.WebElementCommon.isElementPresent(driver, deviceCross)) {
			return this.deviceCross;
		} else {
			return null;
		}
		
	}
	
	/**
	 * Gets the OK button on the confirmation message.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnValidateSBH]")
	WebElement cnfOKBtn;
	public WebElement getCnfOkBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, cnfOKBtn, logger)) {
			return this.cnfOKBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Cancel button on the confirmation message.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnCancelValidateSBH]")
	WebElement cnfCancelBtn;
	public WebElement getCnfCancelBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, cnfCancelBtn, logger)) {
			return this.cnfCancelBtn;
		} else {
			return null;
		}
	}
	/**
	 * Gets the Delete device Ok button.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnDeleteDevice]")
	WebElement deleteSBHBtn;
	public WebElement getdeleteBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, deleteSBHBtn, logger)) {
			return this.deleteSBHBtn;
		} else {
			return null;
		}
	}
}
