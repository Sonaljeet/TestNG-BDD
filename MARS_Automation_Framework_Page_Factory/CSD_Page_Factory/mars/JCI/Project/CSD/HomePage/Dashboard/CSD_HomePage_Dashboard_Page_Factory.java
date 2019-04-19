/**
 * 
 */
package mars.JCI.Project.CSD.HomePage.Dashboard;

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

/**
 * @author cdeyso
 *
 */
public class CSD_HomePage_Dashboard_Page_Factory {
	
	private WebDriver driver=null;
	private ExtentTest logger=null;
	
	public CSD_HomePage_Dashboard_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	//Method Overload, we are using fluent wait -- For Single Element
	public static boolean waitForElementPresent(WebDriver driver, WebElement webElement, ExtentTest logger) throws TimeoutException{
		try {
			//Thread.sleep(5000);
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  //Wait for the condition with timeout 30 seconds
				      .withTimeout(15, TimeUnit.SECONDS) 
				        // poll interval of 1 seconds. 
				      .pollingEvery(1, TimeUnit.SECONDS) 
				        //ignore the NoSuchElementException
				      .ignoring(NoSuchElementException.class);
			fluentWait.until(ExpectedConditions.visibilityOf(webElement));
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
	
	//Method Overload, we are using fluent wait -- For List of WebElement
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
	
	//Chiller Status  -- RED
	//css - #highcharts-2 > svg > g.highcharts-series-group > g.highcharts-series.highcharts-tracker > rect[fill='#FF0000']
	//xpath -- //*[@id="highcharts-2"]/svg/g[6]/g[1]/rect[1]
	@FindBy(css="#highcharts-2 > svg > g.highcharts-series-group > g.highcharts-series.highcharts-tracker > rect[fill='#FF0000']")
	private WebElement hp_ChillerStatusRedLink;
		
	public WebElement get_hp_ChillerStatusRedLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, hp_ChillerStatusRedLink, logger)){
			return hp_ChillerStatusRedLink;
		}else
			return null;
	}
	
	//Chiller Status  -- GREEN
	@FindBy(css="#highcharts-2 > svg > g.highcharts-series-group > g.highcharts-series.highcharts-tracker > rect[fill='#006400']")
	private WebElement hp_ChillerStatusGreenLink;
		
	public WebElement get_hp_ChillerStatusGreenLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, hp_ChillerStatusGreenLink, logger)){
			return hp_ChillerStatusGreenLink;
		}else
			return null;
	}
	
	//Chiller Status  -- GREY
	@FindBy(css="#highcharts-2 > svg > g.highcharts-series-group > g.highcharts-series.highcharts-tracker > rect[fill='#666666']")
	private WebElement hp_ChillerStatusGreyLink;
		
	public WebElement get_hp_ChillerStatusGreyLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, hp_ChillerStatusGreyLink, logger)){
			return hp_ChillerStatusGreyLink;
		}else
			return null;
	}
	
	//Chiller Status  -- YELLOW
	@FindBy(css="#highcharts-2 > svg > g.highcharts-series-group > g.highcharts-series.highcharts-tracker > rect[fill='#FFFF00']")
	private WebElement hp_ChillerStatusYellowLink;
		
	public WebElement get_hp_ChillerStatusYellowLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, hp_ChillerStatusYellowLink, logger)){
			return hp_ChillerStatusYellowLink;
		}else
			return null;
	}
	
	//Chiller Status  -- ORANGE
	@FindBy(css="#highcharts-2 > svg > g.highcharts-series-group > g.highcharts-series.highcharts-tracker > rect[fill='#FFA500']")
	private WebElement hp_ChillerStatusOrangeLink;
		
	public WebElement get_hp_ChillerStatusOrangeLink(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, hp_ChillerStatusOrangeLink, logger)){
			return hp_ChillerStatusOrangeLink;
		}else
			return null;
	}
	
	//Customer Names Table -- List of the Names Visible
	@FindBy(css="div.customer-name-details > div.row > div.col-md-5 > div > div > div > table:nth-child(2) > tbody > tr")
	private List<WebElement> hp_CustomerNameList;
		
	public List<WebElement> get_hp_CustomerNameList(){
		if(commonFunctions.WebElementCommon.waitForElementsPresent(driver, hp_CustomerNameList, logger)){
			return hp_CustomerNameList;
		}else
			return null;
	}
	
	//Customer Names Table -- Search Customer Name TextBox
	@FindBy(css="div.customer-name-details > div.row > div.col-md-5 > div > div > div > table:nth-child(1) > tbody > tr > td > input")
	private WebElement hp_CustomerNameSearch;
		
	public WebElement get_hp_CustomerNameSearch(){
		if(commonFunctions.WebElementCommon.waitForElementPresent(driver, hp_CustomerNameSearch, logger)){
			return hp_CustomerNameSearch;
		}else
			return null;
	}
	
	//Customer Name Search Result -- Dynamic Upon Selection of a Specific customer Name
	public WebElement get_hp_custNameSearchResultTextElement(String custName) {
		
		WebElement custNameResult = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'"+custName+"')]"));
		return custNameResult;
		
	}
	
	//Site/Faciity Names Table -- Site/Facility Name List VISIBLE
	@FindBy(css="div.customer-name-details > div.row > div.col-md-4 > div > div > div > table > tbody > tr")
	private List<WebElement> hp_SiteFacilityNameList;
		
	public List<WebElement> get_hp_SiteFacilityNameList(){
		if(commonFunctions.WebElementCommon.waitForElementsPresent(driver, hp_SiteFacilityNameList, logger)){
			return hp_SiteFacilityNameList;
		}else
			return null;
	}
	
	//Customer Name Search Result -- Dynamic Upon Selection of a Specific Facility Name
	public WebElement get_hp_facilityNameSearchResultTextElement(String facilityName) {
		
		WebElement custNameResult = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'"+facilityName+"')]"));
		return custNameResult;
		
	}
	
	//Chiller Names Table -- Chiller Name List VISIBLE
	@FindBy(css="div.customer-name-details > div.row > div.col-md-3 > div > div > div > table > tbody > tr")
	private List<WebElement> hp_ChillerNameList;
		
	public List<WebElement> get_hp_ChillerNameList(){
		if(commonFunctions.WebElementCommon.waitForElementsPresent(driver, hp_ChillerNameList, logger)){
			return hp_ChillerNameList;
		}else
			return null;
	}
	
	
	//Chiller Status -- Get Data From the Status ToolTip on MouseHover
	public WebElement get_hp_ChillerStatusMessage(int chillerSize) {
		
		if (chillerSize != 0) {
			//for (int i = 1; i <= chillerSize; i++) {

				WebElement chillerStatus = driver.findElement(By.cssSelector("div.customer-name-details > div.row > div.col-md-3 > div > div > div > table > tbody > tr:nth-child("+chillerSize+") > td > div > a > span.ng-scope"));
				return chillerStatus;
			//} 
		}else if (chillerSize == 0){
			
			WebElement chillerStatus = driver.findElement(By.cssSelector("div.customer-name-details > div.row > div.col-md-3 > div > div > div > table > tbody > tr > td > div > a > span.ng-scope"));
			return chillerStatus;
			
		}
		return null;
		
	}
	
	//Chiller Information -- Point Details -- Number of Points displayed(rows of data)
	@FindBy(css="#divchillerinfo > div:nth-child(2) > div > table > tbody > tr")
	private List<WebElement> hp_ChillerInfoPointsNameList;
		
	public List<WebElement> get_hp_ChillerInfoPointsNameList(){
		if(waitForElementsPresent(driver, hp_ChillerInfoPointsNameList, logger)){ //commonFunctions.WebElementCommon.
			return hp_ChillerInfoPointsNameList;
		}else
			return null;
	}
	
	//Chiller Information -- Point Details -- Name of Points displayed(one by one)
	public WebElement get_hp_ChillerInfoPointsName(int chillerSize) {
		
		if (chillerSize != 0) {
			//for (int i = 1; i <= chillerSize; i++) {

				WebElement chillerStatus = driver.findElement(By.cssSelector("#divchillerinfo > div:nth-child(2) > div > table > tbody > tr:nth-child("+chillerSize+") > td:nth-child(1)"));
				return chillerStatus;
			//} 
		}/*else if (chillerSize == 0){
			
			WebElement chillerStatus = driver.findElement(By.cssSelector("#divchillerinfo > div:nth-child(2) > div > table > tbody > tr:nth-child("+chillerSize+") > td:nth-child(1)"));
			return chillerStatus;
			
		}*/
		return null;
	}
	
	//Chiller Information -- Point Details -- Number of Points' Values displayed(rows of data)
	@FindBy(css="#divchillerinfo > div:nth-child(2) > div > table > tbody > tr")
	private List<WebElement> hp_ChillerInfoPointsValuesList;
		
	public List<WebElement> get_hp_ChillerInfoPointsValuesList(){
		if(commonFunctions.WebElementCommon.waitForElementsPresent(driver, hp_ChillerInfoPointsValuesList, logger)){
			return hp_ChillerInfoPointsValuesList;
		}else
			return null;
	}
	
	//Chiller Information -- Point Details -- Values of Points displayed(one by one)
	public WebElement get_hp_ChillerInfoPointsValue(int chillerSize) {
		
		if (chillerSize != 0) {
			//for (int i = 1; i <= chillerSize; i++) {

				WebElement chillerStatus = driver.findElement(By.cssSelector("#divchillerinfo > div:nth-child(2) > div > table > tbody > tr:nth-child("+chillerSize+") > td:nth-child(2)"));
				return chillerStatus;
			//} 
		}/*else if (chillerSize == 0){
			
			WebElement chillerStatus = driver.findElement(By.cssSelector("#divchillerinfo > div:nth-child(2) > div > table > tbody > tr:nth-child("+chillerSize+") > td:nth-child(2)"));
			return chillerStatus;
			
		}*/
		return null;
	}

}
