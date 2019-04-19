package mars.JCI.Project.CEP.Reports;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class CEP_SCCHealthSummary_Page_Factory {
	private static WebDriver driver;
	private static ExtentTest logger;

	public CEP_SCCHealthSummary_Page_Factory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='LUCKY PLAZA']")
	private WebElement customer;
	
	public WebElement getCustomer() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, customer, logger) == true) {
			return customer;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//span[text()='YK, CHILLER 1']")
	private WebElement equipmentName;
	
	public WebElement getEquipmentName() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, equipmentName, logger) == true) {
			return equipmentName;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//span[text()='K42848335']")
	private WebElement equipmentSerialNum;
	
	public WebElement getEquipmentSerialNum() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, equipmentSerialNum, logger) == true) {
			return equipmentSerialNum;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//span[text()='YKMSMSH95COGS']")
	private WebElement chillerModelNum;
	
	public WebElement getChillerModelNum() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, chillerModelNum, logger) == true) {
			return chillerModelNum;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[@class='row-text']/table/tbody/tr/td")
	private List<WebElement> summaryTable;
	
	public List<WebElement> getSummaryTable() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, summaryTable, logger) == true) {
			return summaryTable;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[contains(@class,'text-center content_border')]/p")
	private List<WebElement> alertAlarmCount;
	
	public List<WebElement> getAlertAlarmCount() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alertAlarmCount, logger) == true) {
			return alertAlarmCount;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//div[contains(@class,'text-center content_border')]/span")
	private List<WebElement> alertAlarmCountData;
	
	public List<WebElement> getAlertAlarmCountData() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alertAlarmCountData, logger) == true) {
			return alertAlarmCountData;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//table[contains(@class,'sinapore_table')]/thead/tr/th")
	private List<WebElement> allHeaders;
	
	public List<WebElement> getAllHeaders() throws Exception {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, allHeaders, logger) == true) {
			return allHeaders;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath="//table[contains(@class,'sinapore_table')]/tbody/tr/td")
	private List<WebElement> allTableContents;
	
	public List<WebElement> getAllTableContents() throws Exception {
		if (allTableContents!=null) {
			return allTableContents;
		} else {
			return null;
		}
	}
}
