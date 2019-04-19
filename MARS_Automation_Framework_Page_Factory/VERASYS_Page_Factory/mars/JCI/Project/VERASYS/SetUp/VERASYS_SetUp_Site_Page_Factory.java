package mars.JCI.Project.VERASYS.SetUp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VERASYS_SetUp_Site_Page_Factory {

	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new Site page factory.
	 *
	 * @param driver the driver
	 */
	public VERASYS_SetUp_Site_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	/** All WebElements are identified by @FindBy annotation. */
	
	/**
	 * Gets the Site Tab.
	 *
	 * @return the Site Tab.
	 */
	@FindBy(css ="a[automation-id='tabSite']")
	WebElement siteTab;
	public WebElement getSiteTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteTab, logger)) {
			return this.siteTab;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Customer Drop Down on Site page.
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
	 * Gets the Site Name.
	 *
	 * @return the Site Name.
	 */
	@FindBy(css ="input[automation-id=siteName]")
	WebElement siteName;
	public WebElement getSiteName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteName, logger)) {
			return this.siteName;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Site Name.
	 *
	 * @return the Site Name.
	 */
	@FindBy(css ="input[automation-id=siteAbbreviation]")
	WebElement siteId;
	public WebElement getSiteId() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteId, logger)) {
			return this.siteId;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Site Address 1.
	 *
	 * @return the Site Address 1.
	 */
	@FindBy(css ="input[automation-id=siteAddress1]")
	WebElement siteAddress1;
	public WebElement getsiteAddress1() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteAddress1, logger)) {
			return this.siteAddress1;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Site Address 2.
	 *
	 * @return the Site Address 2.
	 */
	@FindBy(css ="input[automation-id=siteAddress2]")
	WebElement siteAddress2;
	public WebElement getsiteAddress2() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteAddress2, logger)) {
			return this.siteAddress2;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the Country Drop Down.
	 *
	 * @return the Country Drop Down.
	 */
	@FindBy(css ="select[name=CountryId]")
	WebElement siteCountry;
	public WebElement getSiteCountry() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteCountry, logger)) {
			return this.siteCountry;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the State Drop Down.
	 *
	 * @return the State Drop Down.
	 */
	@FindBy(css ="select[name=StateId]")
	WebElement siteState;
	public WebElement getSiteState() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteState, logger)) {
			return this.siteState;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the City Drop Down.
	 *
	 * @return the City Drop Down.
	 */
	@FindBy(css ="select[name=CityId]")
	WebElement siteCity;
	public WebElement getSiteCity() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteCity, logger)) {
			return this.siteCity;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the site Zipcode.
	 *
	 * @return the site Zipcode.
	 */
	@FindBy(css ="input[automation-id=siteZipcode]")
	WebElement siteZipcode;
	public WebElement getSiteZipcode() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteZipcode, logger)) {
			return this.siteZipcode;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the site Start date.
	 *
	 * @return the site Start date.
	 */
	@FindBy(css ="input[automation-id=siteStartDate]")
	WebElement siteStartDate;
	public WebElement getStartDate() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteStartDate, logger)) {
			return this.siteStartDate;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets the site End date.
	 *
	 * @return the site End date.
	 */
	@FindBy(css ="input[automation-id=siteEndDate]")
	WebElement siteEndDate;
	public WebElement getEndDate() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteEndDate, logger)) {
			return this.siteEndDate;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Primary Customer Contact Name.
	 *
	 * @return Name field.
	 */
	@FindBy(css ="input[automation-id=sitePrimaryName]")
	WebElement sitePrimName;
	public WebElement getPrimName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sitePrimName, logger)) {
			return this.sitePrimName;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Primary Customer Title.
	 *
	 * @return Title field.
	 */
	@FindBy(css ="input[automation-id=sitePrimaryDesignation]")
	WebElement sitePrimaryDesignation;
	public WebElement getPrimDesignation() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sitePrimaryDesignation, logger)) {
			return this.sitePrimaryDesignation;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Primary Customer Contact No.
	 *
	 * @return Contact field.
	 */
	@FindBy(css ="input[automation-id=sitePrimaryContactNumber]")
	WebElement sitePrimaryContactNumber;
	public WebElement getPrimContact() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sitePrimaryContactNumber, logger)) {
			return this.sitePrimaryContactNumber;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Primary Customer Email.
	 *
	 * @return Email field.
	 */
	@FindBy(css ="input[automation-id=sitePrimaryEmail]")
	WebElement sitePrimaryEmail;
	public WebElement getPrimEmail() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, sitePrimaryEmail, logger)) {
			return this.sitePrimaryEmail;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Secondary Customer Contact Name.
	 *
	 * @return Name field.
	 */
	@FindBy(css ="input[automation-id=siteSecondaryContactName]")
	WebElement siteSecName;
	public WebElement getSecName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteSecName, logger)) {
			return this.siteSecName;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Secondary Customer Title.
	 *
	 * @return Title field.
	 */
	@FindBy(css ="input[automation-id=siteSecondDesignation]")
	WebElement siteSecondDesignation;
	public WebElement getSecDesignation() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteSecondDesignation, logger)) {
			return this.siteSecondDesignation;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Secondary Customer Contact No..
	 *
	 * @return Contact field.
	 */
	@FindBy(css ="input[automation-id=siteSecondContactNo]")
	WebElement siteSecondContactNo;
	public WebElement getSecContact() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteSecondContactNo, logger)) {
			return this.siteSecondContactNo;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Secondary Customer Email.
	 *
	 * @return Email field.
	 */
	@FindBy(css ="input[automation-id=siteSecondEmail]")
	WebElement siteSecondEmail;
	public WebElement getSecEmail() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteSecondEmail, logger)) {
			return this.siteSecondEmail;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Add Button.
	 *
	 * @return button .
	 */
	@FindBy(css ="button[automation-id=btnAddSite]")
	WebElement siteAddBtn;
	public WebElement getSiteAddbtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteAddBtn, logger)) {
			return this.siteAddBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Update Button.
	 *
	 * @return button .
	 */
	@FindBy(css ="button[automation-id=btnUpdateSite]")
	WebElement siteUpdateBtn;
	public WebElement getSiteUpdatebtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteUpdateBtn, logger)) {
			return this.siteUpdateBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Delete Button.
	 *
	 * @return button .
	 */
	@FindBy(css ="button[automation-id=btnDeleteSite]")
	WebElement siteDeleteBtn;
	public WebElement getSiteDeletebtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteDeleteBtn, logger)) {
			return this.siteDeleteBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Cancel Button.
	 *
	 * @return button .
	 */
	@FindBy(css ="button[automation-id=btnCancelSite]")
	WebElement siteCancelBtn;
	public WebElement getSiteCancelbtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, siteCancelBtn, logger)) {
			return this.siteCancelBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets Site from left Tree.
	 *
	 * @return  .
	 */
	@FindAll({@FindBy(css ="span[id]")})
	List<WebElement> siteTree;
	public List<WebElement> getSiteTree() {
		if (siteTree.size()>0) {
			return (List<WebElement>) this.siteTree;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets expand node at country level.
	 *
	 * @return  .
	 */
	@FindAll({@FindBy(css ="span[automation-id=expandNode]")})
	List<WebElement> countryExpand;
	public List<WebElement> getcountryExpand() {
		if (countryExpand.size()>0) {
			return (List<WebElement>) this.countryExpand;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets yes button on Pop up while deleting site.
	 *
	 * @return  .
	 */
	@FindBy(css ="button[automation-id=btnDeleteYes]")
	WebElement deleteSiteYesBtn;
	public WebElement getdeleteSiteYesBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, deleteSiteYesBtn, logger)) {
			return this.deleteSiteYesBtn;
		} else {
			return null;
		}
	}
	
	/**
	 * Gets start date label.
	 *
	 * @return .
	 */
	@FindBy(css ="label[automation-id=lblsiteStartDate]")
	WebElement startDateLabel;
	public WebElement getStartDateLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, startDateLabel, logger)) {
			return this.startDateLabel;
		} else {
			return null;
		}
	}
}
