package mars.JCI.Project.CSD.HomePage.RightTreeMenu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import mars.JCI.Project.CSD.HomePage.RightTreeMenu.CSD_HOMEPAGE_RightTreeMenu_Page_Factory;
import mars.JCI.Project.CSD.HomePage.RightTreeMenu.CSD_HOMEPAGE_DataValidation_Master;
import mars.JCI.Project.CSD.COMMONS.CSD_COMMONS_ValidationMethods;

public class CSD_HOMEPAGE_RightTreeMenu_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static final By IMAGELOADER = By.id("loadingWidget");
	
	private static CSD_HOMEPAGE_RightTreeMenu_Page_Factory csdHPtreePageFactory = null;
	private static CSD_HOMEPAGE_DataValidation_Master csdHPDataValMaster = null;
	private static CSD_COMMONS_ValidationMethods csdCommonMethods = null;
	
	public static int noOfCustomers = 0;
	
	public static List<String> customerNameUIList = new ArrayList<String>();
	
	@SuppressWarnings("static-access")
	public CSD_HOMEPAGE_RightTreeMenu_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		csdHPtreePageFactory = new CSD_HOMEPAGE_RightTreeMenu_Page_Factory(driver, logger);
		csdHPDataValMaster = new CSD_HOMEPAGE_DataValidation_Master(logger);
		csdCommonMethods = new CSD_COMMONS_ValidationMethods(driver, logger);
	}
	
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	
	public static void clickOnRightTreeIcon() {
		
		waitForSpinnerToDisappear();
		WebElement rightTreeMenuIcon = csdHPtreePageFactory.get_treeMenuPage_ManIconLink();
		waitForSpinnerToDisappear();
		if(rightTreeMenuIcon!= null){
			rightTreeMenuIcon.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Clicked on the Customer Tree Icon");
		}else{
			logger.log(LogStatus.FAIL, "Failed to Click on the Customer Tree Icon");
		}
	}
	
	public static void readTheDisplayedCustomerNames() throws InterruptedException {
		
		if(customerNameUIList.size()>0)customerNameUIList.clear();
		waitForSpinnerToDisappear();
		List<WebElement> rightTreeMenuList = csdHPtreePageFactory.get_treeMenuPage_ProjectNameListLink();
		//WebElement rightTreeMenuList = csdHPtreePageFactory.get_treeMenuPage_ResultProjectNameLink_Dynamic_OBO("3");
		waitForSpinnerToDisappear();
		if(rightTreeMenuList!= null){
			//System.out.println("rightTreeMenuList "+rightTreeMenuList.getText());
			int listSize = rightTreeMenuList.size();
			System.out.println("listSize "+listSize);
			noOfCustomers = listSize;
			for(int i = 1; i<= listSize; i++){
				//Thread.sleep(800);
				String locVal = new Integer(i+1).toString();
				System.out.println("locVal :"+locVal);
				WebElement rightTreeMenuListSingle = csdHPtreePageFactory.get_treeMenuPage_ResultProjectNameLink_Dynamic_OBO(locVal);
				//Thread.sleep(800);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rightTreeMenuListSingle);
				String customerNames = rightTreeMenuListSingle.getText();
				System.out.println("Customer Name :"+" "+i+" "+customerNames);
				//logger.log(LogStatus.INFO, "Customer Name :"+" "+i+" "+customerNames);
				customerNameUIList.add(customerNames);
			}
			logger.log(LogStatus.INFO, "Customer Name List :"+customerNameUIList);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "The Customer List Validated Successfully.");
		}else{
			logger.log(LogStatus.FAIL, "Failed to validate Customer List Successfully.");
		}
	}
	
	
	@SuppressWarnings("static-access")
	public static void validateSingleEntryCustomerDetails() throws InterruptedException {
		
		csdCommonMethods.waitForSpinnerToDisappear();
		Thread.sleep(2000);
		int custLocVal = csdCommonMethods.getRamdomNoBetweenRange(0, noOfCustomers);
		String locVal = new Integer(custLocVal+1).toString();
		WebElement selCustElement = csdHPtreePageFactory.get_treeMenuPage_ResultProjectNameLink_Dynamic_OBO(locVal);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selCustElement);
		if(selCustElement!=null){
			String customerNames = selCustElement.getText();
			System.out.println("Customer Name selected for validations :"+customerNames);
			selCustElement.click();
			logger.log(LogStatus.PASS, "Customer Name selected for validations :"+customerNames);
			Thread.sleep(2000);
			List<WebElement> selAssetElement = csdHPtreePageFactory.get_treeMenuPage_ProjectNameListLink_Asset();
			if(selAssetElement!=null){
				logger.log(LogStatus.INFO, "Customer name Name is expaded for Validations!");
				if(selAssetElement.size() == 1){
					WebElement selAssetElement_single = selAssetElement.get(0);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selAssetElement_single);
					String assetNameText = selAssetElement_single.getText();
					System.out.println("Asset Name selected for validations :"+assetNameText);
					selAssetElement_single.click();
					logger.log(LogStatus.PASS, "Asset Name selected for validations :"+assetNameText);
					Thread.sleep(2000);
					List<WebElement> selChillerElement = csdHPtreePageFactory.get_treeMenuPage_ProjectNameListLink_Chiller();
					if(selChillerElement!=null){
						logger.log(LogStatus.INFO, "Customer name Name is expaded for Validations!");
						if(selChillerElement.size() == 1){
							WebElement selChillerElement_single = selChillerElement.get(0);
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selChillerElement_single);
							String chillerNameText = selChillerElement_single.getText();
							System.out.println("Chiller Name selected for validations :"+chillerNameText);
							//selAssetElement_single.click();//Webdriver click is not working
							Actions actions = new Actions(driver);
							actions.moveToElement(selChillerElement_single);
							actions.click().build().perform();
							logger.log(LogStatus.PASS, "Chiller Name selected for validations :"+chillerNameText);
							
						}else if(selChillerElement.size() > 1){
							int chillerLocVal = csdCommonMethods.getRamdomNoBetweenRange(0, selChillerElement.size()-1);
							WebElement selChillerElement_single = selChillerElement.get(chillerLocVal);
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selChillerElement_single);
							String chillerNameText = selChillerElement_single.getText();
							System.out.println("Chiller Name selected for validations :"+chillerNameText);
							//selAssetElement_single.click();//Webdriver click is not working
							Actions actions = new Actions(driver);
							actions.moveToElement(selChillerElement_single);
							actions.click().build().perform();
							logger.log(LogStatus.PASS, "Chiller Name selected for validations :"+chillerNameText);
						}
					}
					
				}else if(selAssetElement.size() > 1){
					int assetLocVal = csdCommonMethods.getRamdomNoBetweenRange(0, selAssetElement.size()-1);
					WebElement selAssetElement_single = selAssetElement.get(assetLocVal);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selAssetElement_single);
					String assetNameText = selAssetElement_single.getText();
					System.out.println("Asset Name selected for validations :"+assetNameText);
					selAssetElement_single.click();
					logger.log(LogStatus.PASS, "Asset Name selected for validations :"+assetNameText);
					Thread.sleep(2000);
					List<WebElement> selChillerElement = csdHPtreePageFactory.get_treeMenuPage_ProjectNameListLink_Chiller();
					if(selChillerElement!=null){
						logger.log(LogStatus.INFO, "Customer name Name is expaded for Validations!");
						if(selChillerElement.size() == 1){
							WebElement selChillerElement_single = selChillerElement.get(0);
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selChillerElement_single);
							String chillerNameText = selChillerElement_single.getText();
							System.out.println("Chiller Name selected for validations :"+chillerNameText);
							//selAssetElement_single.click();//Webdriver click is not working
							Actions actions = new Actions(driver);
							actions.moveToElement(selChillerElement_single);
							actions.click().build().perform();
							logger.log(LogStatus.PASS, "Chiller Name selected for validations :"+chillerNameText);
							
						}else if(selChillerElement.size() > 1){
							int chillerLocVal = csdCommonMethods.getRamdomNoBetweenRange(0, selChillerElement.size()-1);
							WebElement selChillerElement_single = selChillerElement.get(chillerLocVal);
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selChillerElement_single);
							String chillerNameText = selChillerElement_single.getText();
							System.out.println("Chiller Name selected for validations :"+chillerNameText);
							//selAssetElement_single.click();//Webdriver click is not working
							Actions actions = new Actions(driver);
							actions.moveToElement(selChillerElement_single);
							actions.click().build().perform();
							logger.log(LogStatus.PASS, "Chiller Name selected for validations :"+chillerNameText);
						}
					}
					
				}
			}
		}
	}

	
	@SuppressWarnings("static-access")
	public static void validateProjectDetailsTree(String loggedUser) 
			throws ClassNotFoundException, SQLException {
		
		csdHPDataValMaster.validateRightTreeEntriesWithLoggedUser(loggedUser);
		System.out.println("customerNameUIList.size() "+customerNameUIList.size());
		System.out.println("csdHPDataValMaster.customerNameDBList.size() "+csdHPDataValMaster.customerNameDBList.size());
		if(customerNameUIList.size() == csdHPDataValMaster.customerNameDBList.size()){
			logger.log(LogStatus.PASS, "Proper Number of Entries are reflected under the Right Menu Tree");
		}else{
			logger.log(LogStatus.FAIL, "There is a mismatch in the number of entries with the Logged in user's access.");
		}
		
	}
	
}
