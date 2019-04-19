package mars.JCI.Project.CSD.HomePage.RightTreeMenu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class CSD_HOMEPAGE_RightTreeMenu_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	private final String EMPTY_STRING="";
	
	public CSD_HOMEPAGE_RightTreeMenu_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}

	
	public static boolean waitForElementsPresent(WebDriver driver, List<WebElement> webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(15, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOfAllElements(webElement));
			return true;
		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (TimeoutException e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.INFO, "Element is not present!");
			return false;
		}
	}
	
	
	// RightMenuTree Page -- Right Menu Man Icon.
	@FindBy(css = "a[test-id='btnRightmenu']")
	private WebElement treeMenuPage_ManIconLink;

	public WebElement get_treeMenuPage_ManIconLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, treeMenuPage_ManIconLink, logger)) {
			return treeMenuPage_ManIconLink;
		} else
			return null;
	}
	
	// RightMenuTree Page -- Customer Search Box.
	@FindBy(css = "input[id='txtSearch']")
	private WebElement treeMenuPage_CustomerSearchTextBoxLink;

	public WebElement get_treeMenuPage_CustomerSearchTextBoxLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, treeMenuPage_CustomerSearchTextBoxLink, logger)) {
			return treeMenuPage_CustomerSearchTextBoxLink;
		} else
			return null;
	}
	
	// RightMenuTree Page -- Customer Search Result.
	@FindBy(css = "input[id='txtSearch']")
	private WebElement treeMenuPage_ResultProjectNameLink;

	public WebElement get_treeMenuPage_ResultProjectNameLink() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, treeMenuPage_ResultProjectNameLink, logger)) {
			return treeMenuPage_ResultProjectNameLink;
		} else
			return null;
	}
	
	// RightMenuTree Page -- Customer Search Result. -- Dynamic
	public WebElement get_treeMenuPage_ResultProjectNameLink_Dynamic(String projName) {
		String dynamicProjNameLocator = "//a[@test-id='btnGetProjectData']//span[text()='"+projName+"']";
		WebElement treeMenuPage_ResultProjectNameLink = driver.findElement(By.xpath(dynamicProjNameLocator));
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, treeMenuPage_ResultProjectNameLink, logger)) {
			return treeMenuPage_ResultProjectNameLink;
		} else
			return null;
	}
	
	// RightMenuTree Page -- Project Names List. -- Dynamic -- List
	//@FindBy(css = "a[test-id='btnGetProjectData']")
	@FindBy(css="#cssmenu > ul") ////ancestor::ul
	private List<WebElement> treeMenuPage_ProjectNameListLink;

	public List<WebElement> get_treeMenuPage_ProjectNameListLink() {
		//if (waitForElementsPresent(driver, treeMenuPage_ProjectNameListLink, logger)) {
			return treeMenuPage_ProjectNameListLink;
		//} else
		//	return null;
	}
	
	
	// RightMenuTree Page -- Project Names List. -- Dynamic -- Single 
	@FindBy(xpath="//div[@id='cssmenu']//ul")//"//a[@test-id='btnGetProjectData']") ////ancestor::ul
	private WebElement treeMenuPage_ProjectNameListLink_Static;

	public WebElement get_treeMenuPage_ProjectNameListLink_Static() {
		if (waitForElementsPresent(driver, treeMenuPage_ProjectNameListLink, logger)) {
			return treeMenuPage_ProjectNameListLink_Static;
		} else
			return null;
	}
	
	
	// RightMenuTree Page -- Project Names List. -- Dynamic -- Single -- One By One
	public WebElement get_treeMenuPage_ResultProjectNameLink_Dynamic_OBO(String projNumber) {
		String dynamicProjNameLocator = "div[id='cssmenu']>ul:nth-child("+projNumber+")>li>a[test-id='btnGetProjectData']>span:nth-child(1)";
		System.out.println("dynamicProjNameLocator :"+dynamicProjNameLocator);
		WebElement treeMenuPage_ResultProjectNameLink = driver.findElement(By.cssSelector(dynamicProjNameLocator));
		return treeMenuPage_ResultProjectNameLink;
		/*if (commonFunctions.WebElementCommon.waitForElementPresent(driver, treeMenuPage_ResultProjectNameLink, logger)) {
			return treeMenuPage_ResultProjectNameLink;
		} else
			return null;*/
	}
	
	//TODO -- 
	// RightMenuTree Page -- Asset Details -- Dynamic -- Single -- One By One
	public WebElement get_treeMenuPage_SelectedProjectNameLink_Asset(String projNumber) {
		String dynamicProjNameLocator = "div[id='cssmenu']>ul:nth-child("+projNumber+")>li>a[test-id='btnGetProjectData']>span:nth-child(1)";
		System.out.println("dynamicProjNameLocator :"+dynamicProjNameLocator);
		WebElement SelectedProjectNameLink_Asset = driver.findElement(By.cssSelector(dynamicProjNameLocator));
		return SelectedProjectNameLink_Asset;
		/*if (commonFunctions.WebElementCommon.waitForElementPresent(driver, treeMenuPage_ResultProjectNameLink, logger)) {
			return treeMenuPage_ResultProjectNameLink;
		} else
			return null;*/
	}
	
	//RightMenuTree Page -- Asset Details -- STATIC -- Upon selection of Project Name
	@FindBy(css="span[test-id='btnGetAssetData']")//"//a[@test-id='btnGetProjectData']") ////ancestor::ul
	private List<WebElement> treeMenuPage_ProjectNameListLink_Asset;

	public List<WebElement> get_treeMenuPage_ProjectNameListLink_Asset() {
		//if (waitForElementsPresent(driver, treeMenuPage_ProjectNameListLink_Asset, logger)) {
			return treeMenuPage_ProjectNameListLink_Asset;
		/*} else
			return null;*/
	}
	
	//RightMenuTree Page -- Chiller Details -- STATIC -- Upon selection of Project Name
	@FindBy(css="a[test-id='lnkRedirectToOverview']>span[class='projectNameSpan ng-binding']")//"//a[@test-id='btnGetProjectData']") ////ancestor::ul
	private List<WebElement> treeMenuPage_ProjectNameListLink_Chiller;

	public List<WebElement> get_treeMenuPage_ProjectNameListLink_Chiller() {
		//if (waitForElementsPresent(driver, treeMenuPage_ProjectNameListLink_Asset, logger)) {
			return treeMenuPage_ProjectNameListLink_Chiller;
		/*} else
			return null;*/
	}
	
	
}
