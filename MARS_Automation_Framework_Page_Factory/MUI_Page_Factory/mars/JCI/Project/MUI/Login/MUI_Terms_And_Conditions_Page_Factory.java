package mars.JCI.Project.MUI.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

/**
 * A factory for creating MUI_Terms_And_Conditions_Page_ objects.
 */
public class MUI_Terms_And_Conditions_Page_Factory {
	
	/** The WebDriver driver. */
	private static WebDriver driver;
	
	/** The ExtentTest logger. */
	private static ExtentTest logger;
	
	/**
	 * Instantiates a new MUI terms and conditions page factory.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */
	public MUI_Terms_And_Conditions_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	/** MUI Legal Terms and Conditions page */	
	@FindBy(css = "form[test-id=\"legal-term-container\"]")
	WebElement muiLegalPage;
	
	/**
	 * Gets the legal page.
	 *
	 * @return the legal page element
	 */
	public WebElement getLegalPage() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiLegalPage, logger)) {
			return this.muiLegalPage;
		} else {
			return null;
		}
	}
		
	
	/** MUI Legal Cancel Button element */	
	@FindBy(css = "button[test-id=\"legal-term-cancel-btn\"]")
	WebElement muiLegalCancelButton;
	
	/**
	 * Gets the legal Cancel button.
	 *
	 * @return the legal accept button
	 */
	public WebElement getLegalCancelButton() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiLegalCancelButton, logger)) {
			return this.muiLegalCancelButton;
		} else {
			return null;
		}
	}
	
	/** MUI Legal Accept Button element */	
	@FindBy(css = "button[test-id=\"legal-term-accept-btn\"]")
	WebElement muiLegalAcceptButton;

	/**
	 * Gets the legal accept button.
	 *
	 * @return the legal accept button
	 */
	public WebElement getLegalAcceptButton() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, muiLegalAcceptButton, logger)) {
			return this.muiLegalAcceptButton;
		} else {
			return null;
		}
	}
}
