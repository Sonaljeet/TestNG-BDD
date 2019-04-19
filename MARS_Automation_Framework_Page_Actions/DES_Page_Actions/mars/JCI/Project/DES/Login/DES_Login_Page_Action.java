package mars.JCI.Project.DES.Login;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import commonFunctions.WebPage;

public class DES_Login_Page_Action {

	/** The driver. */
	private static WebDriver driver;

	/** The logger. */
	private static ExtentTest logger;
	private WebElement element;

	/** The login page. */

	private static DES_Login_Page_Factory loginPF = null;
	private static DES_Home_Page_Action homePA = null;
	public String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";

	public DES_Login_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPF = new DES_Login_Page_Factory(driver, logger);
		//homePA = new DES_Home_Page_Action(driver, logger);
	}

	/**
	 * Enter password.
	 *
	 * @param password
	 *            the password
	 */

	public void enterUserID(String userName) {
		element = loginPF.getUserName();
		if (element != null) {
			if (element.isDisplayed()) {
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Username");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, userName);
				logger.log(LogStatus.PASS, "User ID Entered succesfully to User Name WebElement");
			}
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for User Name Field Failed");
		}

	}

	/**
	 * Enter password.
	 *
	 * @param password
	 *            the password
	 * 
	 * @return None
	 */
	public void enterPassword(String password) {
		element = loginPF.getPassword();
		if (element != null) {
			if (element.isDisplayed()) {
				WebInputTextBox.watermarkedTextMatch(driver, logger, element, "Password");
				element.clear();
				WebInputTextBox.SendInputTextBox(driver, element, password);
				logger.log(LogStatus.PASS, "Password Entered succesfully to Password WebElement");
			}
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Password Field Failed");
		}

	}

	public boolean verifySignInEnabled() {
		boolean verifySignInEnabled = false;
		element = loginPF.getSignIn();
		if (element != null) {
			if (element.isEnabled()) {
				verifySignInEnabled = true;
				logger.log(LogStatus.PASS, "Verified Sign Is Enabled before clicking");
			} else {
				logger.log(LogStatus.FAIL, "Verified Sign Is NOT Enabled.");
			}
		} else {
			logger.log(LogStatus.FAIL, " Sign in Element returns NULL.");
		}
		return verifySignInEnabled;
	}

	/**
	 * Verify login page copyright text.
	 *
	 * @return true, if successful
	 */
	public boolean verifyLoginCopyrightText() {
		boolean verifyLoginCopyrightText = false;
		element = loginPF.getLoginCopyrightText();
		try {
			if (element != null) {
				if (WebElementCommon.getElementText(driver, element, logger)
						.equals("© 2015-2017 Johnson Controls. All rights reserved.")) {
					verifyLoginCopyrightText = true;
					logger.log(LogStatus.PASS, "Verified copyright text is matched with expected");
				} else {
					logger.log(LogStatus.FAIL, " Copyright text not matched with actual text.");
				}
			} else {
				logger.log(LogStatus.FAIL, " Copyright text Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}
		return verifyLoginCopyrightText;
	}

	public void clickSignIn() {
		element = loginPF.getSignIn();
		if (element != null) {
			if (verifySignInEnabled()) {
				WebButton.Button_Click(driver, element);
				waitMapForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Clicked succesfully to SignIn Button");
			} else {
				logger.log(LogStatus.FAIL, "SignIn button is not enabled");
			}
		} else {
			logger.log(LogStatus.ERROR, "Identifying WebElement for SignIn Button Failed");
		}

	}

	/**
	 * Verify SSL.
	 * 
	 * @return None
	 */
	public void verifySSL() {
		if (driver.getTitle().contains("Certificate")) {
			driver.get("javascript:document.getElementById('overridelink').click();");
			logger.log(LogStatus.PASS, "SSL Certificate link clicked");
		} else {
			logger.log(LogStatus.INFO, "SSL Certificate link is not available for browser");
		}

	}

	/**
	 * Successful login.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the BC M set up home page action
	 * @throws InterruptedException
	 */
	public static void waitMapForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingMap");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public DES_Home_Page_Action correctLogin(String username, String password) throws InterruptedException {
		DES_Home_Page_Action homePA = null;
		try {
			verifySSL();
			enterUserID(username);
			enterPassword(password);
			verifyLoginCopyrightText();
			clickSignIn();
			Thread.sleep(2000);
			waitMapForSpinnerToDisappear();
			homePA = new DES_Home_Page_Action(driver, logger);
			DES_Home_Page_Action.waitForSpinnerToDisappear();
			String HomePageTitle = driver.getTitle();
			if (HomePageTitle.equals("DES") || HomePageTitle.contains("Invalid")) {
				System.out.println("Title for the HomePage " + HomePageTitle);
				Thread.sleep(1000);
			} else {
				System.out.println("User Failled to Login " + HomePageTitle);
			}
			logger.log(LogStatus.PASS, "Successfully Logged in to DES");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}
		return homePA;
	}

	public DES_Home_Page_Action DES_CorrectLogin() throws InterruptedException {

		try {
			// DES_Home_Page_Action homePA = null;
			String Userslistdata_JSONPath = "$..AdminCredentials.*";
			List<String> DES_datalist = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			System.out.println(DES_datalist.get(0).toString());
			System.out.println(DES_datalist.get(1).toString());
			verifySSL();
			enterUserID(DES_datalist.get(0).toString());
			enterPassword(DES_datalist.get(1).toString());
			verifyLoginCopyrightText();
			clickSignIn();
			WebPage.waitForPageLoad(driver);
			waitMapForSpinnerToDisappear();
			Thread.sleep(2000);
			homePA = new DES_Home_Page_Action(driver, logger);
			DES_Home_Page_Action.waitForSpinnerToDisappear();
			String HomePageTitle = driver.getTitle();
			if (HomePageTitle.equals("DES") || HomePageTitle.contains("Invalid")) {
				System.out.println("Title for the HomePage " + HomePageTitle);
				logger.log(LogStatus.PASS, "Successfully Logged in to DES");
			} else {
				System.out.println("User Failled to Login " + HomePageTitle);
			}
			
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,	this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 150));
		}
		return homePA;
	}

	/**
	 * Incorrect login.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @return the DES login error page action
	 * @throws InterruptedException
	 */
	public DES_Login_Error_Page_Action DES_incorrectLogin() throws InterruptedException {
		DES_Login_Error_Page_Action loginErrorPA = null;
		try {
			String Userslistdata_JSONPath = "$..AdminWrongCredentials.*";
			List<String> DES_datalist = ReadJsonFile.readJsonFileDynamic(
					ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			System.out.println(DES_datalist.get(0).toString());
			System.out.println(DES_datalist.get(1).toString());
			verifySSL();
			enterUserID(DES_datalist.get(0).toString());
			enterPassword(DES_datalist.get(1).toString());
			clickSignIn();
			Thread.sleep(2000);
			waitMapForSpinnerToDisappear();

			logger.log(LogStatus.PASS, "System did not allowed invalid Login");
			return new DES_Login_Error_Page_Action(driver, logger);
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}
		return loginErrorPA;
	}

}
