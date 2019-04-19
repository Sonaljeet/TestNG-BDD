package mars.JCI.Project.VERASYS.SetUp;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class VERASYS_SetUp_SBH_Association_Page_Factory {



	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new Verasys login page factory.
	 *
	 * @param driver the driver
	 */
	public VERASYS_SetUp_SBH_Association_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	/** All WebElements are identified by @FindBy annotation. */
	
	/**
	 * Gets the SBH Association Tab.
	 *
	 * @return the SBH Association Tab.
	 */
	@FindBy(css ="a[automation-id=tabSiteConfig]")
	WebElement sbhAssociationTab;
	public WebElement getSBHTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sbhAssociationTab, logger)) {
			return this.sbhAssociationTab;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Customer Drop Down on SBH Association page.
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
	 * Gets the SBH ID Drop down.
	 *
	 * @return the SBH ID Drop down.
	 */
	@FindBy(css ="select[automation-id=ddlAutoDeviceId]")
	WebElement sbhID;
	public WebElement getSBHId() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sbhID, logger)) {
			return this.sbhID;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Gets the Remove button.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnRemoveDeviceFromSite]")
	WebElement RemoveSBHBtn;
	public WebElement getRemoveBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, RemoveSBHBtn, logger)) {
			return this.RemoveSBHBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Cancel button on SBH Association page.
	 *
	 * @return the cancel btn.
	 */
	@FindBy(css ="button[automation-id=btnCancelMapDeviceToSite]")
	WebElement cancelBtn;
	public WebElement getCancelBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, cancelBtn, logger)) {
			return this.cancelBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Save button.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnAutoAddSiteDevice]")
	WebElement saveSBHBtn;
	public WebElement getSaveBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, saveSBHBtn, logger)) {
			return this.saveSBHBtn;
		} else {
			return null;
		}
	}
	
	
	/**
	 * Gets the OK button on the confirmation message to remove device from site.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnDeleteDevice]")
	WebElement cnfOKBtn;
	public WebElement getCnfOkBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, cnfOKBtn, logger)) {
			return this.cnfOKBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Cancel button on the confirmation message to remove device from site.
	 *
	 * @return the button.
	 */
	@FindBy(css ="button[automation-id=btnDeleteCancel]")
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
	
	/**
	 * Gets the Site Name Field on SBH Association Page.
	 *
	 * @return the Site Name Field on SBH Association Page.
	 */
	@FindBy(css ="span.themecustrefid")
	WebElement siteName;
	public WebElement getSiteName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteName, logger)) {
			return this.siteName;
		} else {
			return null;
		}
	}
}
