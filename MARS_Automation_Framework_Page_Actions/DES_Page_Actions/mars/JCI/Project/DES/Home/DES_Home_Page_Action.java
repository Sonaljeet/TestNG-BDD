package mars.JCI.Project.DES.Home;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import commonFunctions.MouseOperation;
import commonFunctions.WebElementCommon;
import commonFunctions.WebPage;
import mars.Business.Layer.ReadPropertyFile;
import mars.JCI.Project.BCMET.Login.BCMET_Login_Page_Factory;
import mars.JCI.Project.DES.Home.DES_Home_Page_Factory;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Factory;

public class DES_Home_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	private static WebElement element = null;
	private static DES_Home_Page_Factory homePF = null;
	private static DES_Login_Page_Action loginPA = null;
	public static String ConfigFile="C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";

	public DES_Home_Page_Action(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.driver = driver;
		homePF = new DES_Home_Page_Factory(driver, logger);
		loginPA = new DES_Login_Page_Action(driver, logger);

	}

	public String loggedInUserName() {
		String user = "";
		waitForMapSpinnerToDisappear();
		element = homePF.getloggedUser();
		if (element != null) {
			element.click();
			user = element.getText();
			System.out.println("Logged in user is " + user);
			waitForMapSpinnerToDisappear();
		}
		return user;

	}

	public boolean isUserMenuPresent() {
		boolean isUserMenuPresent = false;
		element = homePF.getlogoutMenu();
		if (element != null) {
			DES_Home_Page_Action.waitForSpinnerToDisappear();
			isUserMenuPresent = WebElementCommon.isElementPresent(driver, element);
			if (isUserMenuPresent) {
				logger.log(LogStatus.PASS, "Succesfully identify User Menu WebElement");
			}
		} else {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Identifying WebElement for User Menu Field Failed");
		}
		return isUserMenuPresent;
	}

	public boolean isMapPageHeadingPresent() {
		boolean isMapPageHeadingPresent = false;
		element = homePF.getMapPageHeading();
		if (element != null) {
			isMapPageHeadingPresent = WebElementCommon.isElementPresent(driver, element);
			if (isMapPageHeadingPresent) {
				logger.log(LogStatus.PASS, "Map Page Heading is " + element.getText());
			}
		} else {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + "Map Page Heading is " + element.getText()
					+ "which is not matching with expected heading");
		}
		return isMapPageHeadingPresent;
	}

	public boolean isMapPresent() {
		waitForMapSpinnerToDisappear();
		boolean isMapPresent = false;
		element = homePF.getMapPage();
		if (element != null) {
			DES_Home_Page_Action.waitForSpinnerToDisappear();
			isMapPresent = WebElementCommon.isElementPresent(driver, element);
			if (isMapPresent) {
				logger.log(LogStatus.PASS,
						"As user having multiple sites assigned MAP is present for the user on Home Page");
			} else {
				logger.log(LogStatus.FAIL, "MAP is not present for the user");
			}
		}
		return isMapPresent;
	}

	public void waitForPageToLoad() {
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Current Window State       : "
						+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

	public static void waitForMapSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingMap");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingConfiguration");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public static void waitForSOCSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingsoctrendchart");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	public boolean isLogOutMenuPresent() {
		boolean isLogOutMenuPresent = false;
		// DES_Home_Page_Factory homePF = new DES_Home_Page_Factory(driver,
		// logger);
		element = homePF.getlogoutMenu();
		if (element != null) {
			isLogOutMenuPresent = WebElementCommon.isElementPresent(driver, element);

			if (isLogOutMenuPresent) {
				logger.log(LogStatus.PASS, "Succesfully identify Log Out Menu WebElement");
			}
		} else {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Identifying WebElement for User Menu Field Failed");
		}
		return isLogOutMenuPresent;
	}

	public WebElement countNumberOfSiteMarkersPresent() {
		int count = 1;
		List<WebElement> markers = driver.findElements(By.xpath("//*[@id='map']/div/div/div[1]/div[4]/div[3]/div"));
		System.out.println(markers.size() + " Sites are present on Map");
		for (WebElement marker : markers) {
			System.out.println(marker.getAttribute("title"));
		}

		return element;
	}

	public void getListofSitesFromMap() throws InterruptedException {
		waitForPageToLoad();
		waitForMapSpinnerToDisappear();
		waitForSpinnerToDisappear();
		List<WebElement> siteList = driver.findElements(By.xpath("//*[@id='map']/div/div/div[1]/div[4]/div[3]/div"));
		System.out.println(siteList.size() + " Number of Sites are present for the Logged in user");
		WebPage.waitForPageLoad(driver);
		Iterator<WebElement> itr = siteList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
			for (WebElement site : siteList) {
				waitForSpinnerToDisappear();
				Thread.sleep(6000);
				site.click();
				Thread.sleep(6000);
				WebElement siteName = driver.findElement(By.cssSelector("h3[test_id='markerCustomerName']"));
				String siteNamePrint = siteName.getText();
				System.out.println(siteNamePrint + " Print Successfully");
				WebElement closePopup = driver
						.findElement(By.xpath("//*[@id='map']/div/div/div[1]/div[4]/div[4]/div/img"));
				closePopup.click();
				Thread.sleep(6000);
			}
		}
		// return element;
	}

	public void validateListOfSitesPresentOnMap() {
		try {
			// DES_Home_Page_Action.clickOnSetupButton();
			getListofSitesFromMap();
			logger.log(LogStatus.PASS, "Successfully verified the List of Sites on Map");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failled to Locate the sites on Map Page");
		}

	}

	public void validateLoginUser() {

	}

	public void clickAndVerifyMarkerPresentOnMap() throws InterruptedException {
		int count1 = 1;
		int i = 0;
		// Thread.sleep(2000);
		List<WebElement> markers = driver.findElements(By.xpath("//*[@id='map']/div/div/div[1]/div[4]/div[3]/div"));
		System.out.println("markers.size() " + markers.size());
		for (WebElement marker : markers) {
			if (marker != null && marker.isDisplayed() && marker.isEnabled()) {
				marker.wait(5000);
				System.out.println("Marker at " + count1);
				System.out.println("Marker " + marker.getText());
				Thread.sleep(2000);
				marker.click();
				Thread.sleep(6000);
				WebElement closebtn = driver
						.findElement(By.xpath("//*[@id='map']/div/div/div[1]/div[4]/div[4]/div/img"));
				closebtn.click();

				System.out.println("Clicked on Markers present and verified thee details " + count1);
			} else {
				System.out.println("Markers are not Visible " + count1);
			}
			count1++;
			System.out.println("Completed Site Markers verification");
		}

		/*
		 * for( i=1;i<=markers.size();i++) { Thread.sleep(2000);
		 * //WebElementCommon.isDisplayedByElement((WebElement) markers);
		 * System.out.println("i "+i); WebElement marker =
		 * driver.findElement(By.xpath(
		 * "//*[@id='map']/div/div/div[1]/div[4]/div[3]/div["+i+"]/img"));
		 * marker.click(); WebElement closebtn = driver.findElement(By.xpath(
		 * "//*[@id='map']/div/div/div[1]/div[4]/div[4]/div/img"));
		 * closebtn.click(); System.out.
		 * println("Clicked on Markers present and verified thee details "
		 * +count1); }
		 */

	}

	public void clickOnChevron() throws InterruptedException {
		try {
			WebElement chevron = driver.findElement(By.xpath("//*[@id='demoTree']/li[2]/div/a[1]/i"));
			chevron.click();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Clicked on Chevron to check if site is present");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Failed to click on Chevron to find sitte from customer");
			e.printStackTrace();
		}
	}

	// Navigate to DashBoard
	public WebElement navigateToDashBoard() throws InterruptedException {
		try {
			//waitForMapSpinnerToDisappear();
			element = homePF.getMarkerSite();
			if (element != null) {
				waitForMapSpinnerToDisappear();
				Thread.sleep(2000);
				element.click();
				System.out.println("Clicked to Marker");
				element = homePF.getviewDetailsLink();
				if (element != null) {
					Thread.sleep(1000);
					element.click();
					waitForSOCSpinnerToDisappear();
					Thread.sleep(1000);
					waitForSpinnerToDisappear();
					Thread.sleep(3000);
				}
				logger.log(LogStatus.PASS, "Clicked succesfully to View Details Link and Navigated to dashboard");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Failed to Navigate to Dashboard");
			e.printStackTrace();
		}
		return element;

	}

	public void navigateToSiteOverviewPage() {
		String siteOverViewPageLink= ReadPropertyFile.getInstance(ConfigFile).getProperty("siteOverView");
		try {
			waitForSpinnerToDisappear();
			waitForMapSpinnerToDisappear();
			driver.navigate().to(siteOverViewPageLink);
			waitForSOCSpinnerToDisappear();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Navigate to Overview Page");
		} catch (InterruptedException e) {
			logger.log(LogStatus.FAIL, "Could not navigate to Overview Page");
			e.printStackTrace();
		}
	}

	/**
	 * Verify LogOut is working.
	 * 
	 * @return None
	 */

	public static String clickOnLogOut() {
		String userLoggedin="";
		try {
			waitForMapSpinnerToDisappear();
			waitForSpinnerToDisappear();
			element = homePF.getlogoutMenu();
			if (element != null) {
				element.click();
				userLoggedin=element.getText();
				element = homePF.logoutButton();
				if (element != null) {
					element.click();
					waitForSpinnerToDisappear();
				}
				logger.log(LogStatus.PASS, "Clicked succesfully to Sign Out WebElement");
			}
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, "Identifying WebElement for Sign Out Field Failed");
			e.printStackTrace();
		}
		// return commonPF;
		return userLoggedin;
	}

	/**
	 * Verify user redirects to setup page.
	 * 
	 * @return None
	 * @throws InterruptedException
	 */

	public static void clickeOnSetup() throws InterruptedException {
		try {
			loginPA.DES_CorrectLogin();
			waitForMapSpinnerToDisappear();
			element = homePF.getnavigationMenu();
			if (element != null && element.isEnabled()) {
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
				System.out.println("Hovered  on Menu Button");
				Thread.sleep(1000);
				element = homePF.getSetupbtn();
				if (element != null && element.isEnabled() && element.isDisplayed()) {
					builder.moveToElement(element).perform();
					element.click();
					Thread.sleep(2000);
					waitForSpinnerToDisappear();
					System.out.println("Clicked on Setup Button");
				}
			}
			logger.log(LogStatus.PASS, "Succsesfully navigate to Setup Page");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to navigate to Setup Page");
			e.printStackTrace();
		}
	}

	public static void navigateToSetupPage() {
		String customerSetup= ReadPropertyFile.getInstance(ConfigFile).getProperty("customerSetup");
		try {
			loginPA.DES_CorrectLogin();
			Thread.sleep(2000);
			waitForMapSpinnerToDisappear();
			driver.navigate().to(customerSetup);//"http://des-qa.azurewebsites.net/Configuration#/Customer"
			logger.log(LogStatus.PASS, "Succsesfully navigate to Setup Page");
			waitForSpinnerToDisappear();
			WebPage.waitForPageLoad(driver);
			Thread.sleep(2000);
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not navigate to Setup Page");
		}
	}

	public void clickeOnMapButton() throws InterruptedException {
		try {
			waitForSpinnerToDisappear();
			element = homePF.getnavigationMenuFromCustomer();
			if (element != null && element.isDisplayed() && element.isEnabled()) {
				Actions builder = new Actions(driver);
				builder.moveToElement(element).perform();
				System.out.println("Hovered  on Menu Button");
				Thread.sleep(1000);
				element = homePF.getMapbtn();
				if (element != null && element.isEnabled()) {
					builder.moveToElement(element).perform();
					element.click();
					System.out.println("Clicked on MAP Button Navigated Back to Dashboard");
					waitForMapSpinnerToDisappear();
					waitForMapSpinnerToDisappear();
					Thread.sleep(2000);
				}

			}

			logger.log(LogStatus.PASS, "Succsesfully click on Map Button and Navigated to Map Page");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Failed to click on Map Button");
			e.printStackTrace();
		}
	}
}
