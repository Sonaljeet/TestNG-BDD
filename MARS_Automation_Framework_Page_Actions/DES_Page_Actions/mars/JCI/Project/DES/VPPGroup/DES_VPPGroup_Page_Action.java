package mars.JCI.Project.DES.VPPGroup;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.DragAndDropToObject;

import commonFunctions.WebDropDown;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.JCI.Project.DES.CustomerSetup.DES_CustomerSetup_Page_Action;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Error_Page_Action;
import mars.JCI.Project.DES.Login.DES_Login_Page_Action;
import mars.JCI.Project.DES.UsersRole.DES_UsersRole_Page_Action;

public class DES_VPPGroup_Page_Action {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element = null;
	private static DES_VPPGroup_Page_Factory vppPF = null;
	private static DES_Home_Page_Action homePA= null;
	private static DES_Login_Page_Action loginPA= null;
	public String ConfigFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/DES/Configuration/config.properties";
	
	public String customer = "Main Entity Customer";
	public String vppGroupName = "";
	int index = 0;
	public String newVPPGroupName = "";
	public WebElement newVPPGroup, newlyAddedGroup = null;

	public DES_VPPGroup_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		vppPF = new DES_VPPGroup_Page_Factory(driver, logger);
		homePA =new DES_Home_Page_Action(driver, logger);
		loginPA = new DES_Login_Page_Action(driver, logger);
	}

	public static void waitForSpinnerToDisappear() {
		// driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("divloadingConfiguration");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));

	}

	// Select Customer from Customer dropdown
	public void selectCustomer(String customer) {
		try {

			element = vppPF.getcustomerLabel();
			System.out.println(element.getText() + " Label present");
			Thread.sleep(2000);
			element = vppPF.getdrpdwnCustomers();
			if (element != null) {
				Thread.sleep(2000);
				WebDropDown.SelectElementByVisibleText(element, customer);
				waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "\"" + customer + "\" Selected as Customer");
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not select Customer from Customer dropdown");
		}

	}

	// Navigate to VPP Group
	public void navigateToVPPGroupTab() throws InterruptedException {
		try{
			String Userslistdata_JSONPath = "$..CustomerDetails.*";
			List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
					//loginPA.DES_CorrectLogin();
		waitForSpinnerToDisappear();
		homePA.navigateToSetupPage();
		waitForSpinnerToDisappear();
		String customer= Cust_datalist.get(9).toString();
		waitForSpinnerToDisappear();
		element = vppPF.getgroupTab();
		waitForSpinnerToDisappear();
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, element.getText());
			waitForSpinnerToDisappear();
			Thread.sleep(1000);
		}
		selectCustomer(customer);
		logger.log(LogStatus.PASS, "Navigate to VPP Group Page and selected Customer");
	}catch (Exception e) {
		logger.log(LogStatus.FAIL, "Could not Navigate to VPP Group Page and select Customer");
	}
	}
	public String enterGroupDetails() throws InterruptedException, JsonIOException, JsonSyntaxException, IOException {
		String vppGroupJsonPath="$..VPPGroup_Details.*";
		List<String> vppGroupDetails= ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"), vppGroupJsonPath);
		
		String vppGroupName = DES_UsersRole_Page_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("RuntimedatafileLoc"), "Group_Name",
				vppGroupName);
		waitForSpinnerToDisappear();;
		enterGroupName(vppGroupName);
		enterGroupAbbriviation(DES_UsersRole_Page_Action.generateRandomalphabets(6));
		selectGroupCountry(vppGroupDetails.get(0).toString());
		clickOnSaveButton();
		waitForSpinnerToDisappear();
		getValidationMessageFromGroupPage();
		waitForSpinnerToDisappear();
		return vppGroupName;
	}

	public String getValidationMessageFromGroupPage() {
		String Message = null;
		element = vppPF.getsiteSuccessMessage();
		if (element != null) {
			Message = element.getText();
			logger.log(LogStatus.PASS, "\"" + Message + "\" Message Recieved from Page");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Get the Message from Page");
		}
		return Message;
	}

	private void clickOnSaveButton() {
		// TODO Auto-generated method stub
		element = vppPF.getgroupSaveButton();
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			waitForSpinnerToDisappear();

		}

	}

	private void selectGroupCountry(String country) {
		// TODO Auto-generated method stub
		element = vppPF.getgroupCountryDropdown();
		if (element != null) {
			WebDropDown.SelectElementByVisibleText(element, country);
			logger.log(LogStatus.PASS, "\"" + country + "\" Selected as Country successfully from country dropdown");
		} else {
			logger.log(LogStatus.FAIL, "Failled to find value from Country dropdown");
		}

	}

	private void enterGroupAbbriviation(String siteAbbriviation) {
		// TODO Auto-generated method stub
		element = vppPF.getgroupAbbriviationTextbox();
		if (element != null) {
			WebInputTextBox.SendInputTextBox(driver, element, siteAbbriviation);
			logger.log(LogStatus.PASS, "\"" + siteAbbriviation + "\" entered sucessfully in site Abbriviation field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the site Abbriviation field");

		}

	}

	private void enterGroupName(String groupNamename) {
		// TODO Auto-generated method stub
		element = vppPF.getgroupNameTextbox();
		if (element != null) {
			element.clear();
			WebInputTextBox.SendInputTextBox(driver, element, groupNamename);
			logger.log(LogStatus.PASS, "\"" + groupNamename + "\" entered sucessfully in Group Name field");
		} else {
			logger.log(LogStatus.FAIL, "Failed to find the Group Name field");

		}

	}

	public String createVppGroup() throws InterruptedException {
		
		try {
			
			String Userslistdata_JSONPath = "$..CustomerDetails.*";
			List<String> Cust_datalist = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(ConfigFile).getProperty("Testdatafilelocation"),
					Userslistdata_JSONPath);
			String customer= Cust_datalist.get(9).toString();
			navigateToVPPGroupTab();
			//selectCustomer(customer);
			Thread.sleep(2000);
			List<WebElement> custTree = driver.findElements(By.xpath("//div[@id='treeTemplateDiv']"));
			int count = custTree.size();
			System.out.println(count);
			if (count > 0) {
				Iterator<WebElement> iter = custTree.iterator();
				while (iter.hasNext()) {
					WebElement treeItem = iter.next();
					String treeItemName = treeItem.getText();
					logger.log(LogStatus.PASS, "Node present on Page " + treeItemName);
					if (treeItemName.equalsIgnoreCase(customer)) {
						treeItem.click();
						waitForSpinnerToDisappear();
						element = vppPF.getgroupAddButton();
						if (element.isEnabled()) {
							element.click();
							waitForSpinnerToDisappear();
							logger.log(LogStatus.PASS,"Added new temp VPP Group");
							index = count + 1;
							newVPPGroup = driver.findElement(By.xpath("(//div[@id='treeTemplateDiv'])[" + index + "]"));
							newVPPGroup.click();
							waitForSpinnerToDisappear();
							String newVPPGroupNameTemp = newVPPGroup.getText();
							logger.log(LogStatus.PASS, "Newly temporary Added Group is  " + newVPPGroupNameTemp);
							newVPPGroupName=enterGroupDetails();
							logger.log(LogStatus.PASS, "Added the Group with Complete Details");
							logger.log(LogStatus.PASS,"VPP Group for " + newVPPGroupName + " Added under the customer " + customer);
						}
					}
					break;
					// newVPPGroup.click();
				}
			} else {
				logger.log(LogStatus.FAIL, "No Customer found with Name " + customer);
			}
		} catch (Exception e) {

			logger.log(LogStatus.FAIL, "Could not add VPP Group under customer");
			e.printStackTrace();
		}
		return newVPPGroupName;
	}

	public void addVPPGroup() throws InterruptedException {
		try{
		String vppGroupName=createVppGroup();
		logger.log(LogStatus.PASS, "Successfully added VPPGroup "+ vppGroupName +" to Customer");
		}catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not Add VPP Group");
		}
	}

	public void deleteVppGroup() throws InterruptedException {
		String vppGroupName=createVppGroup();
		Thread.sleep(2000);
		// System.out.println(name);
		WebElement newlyAddedGroup = driver.findElement(By.xpath("(//span[@title='" + vppGroupName + "'])"));
		System.out.println(newlyAddedGroup.getText());
		if (newlyAddedGroup != null) {
			newlyAddedGroup.click();
			waitForSpinnerToDisappear();
			element = vppPF.getgroupDeleteButton();
			if (element != null) {
				waitForSpinnerToDisappear();
				element.click();
				element = vppPF.getOkButton();
				if (element != null) {
					waitForSpinnerToDisappear();
					element.click();
					waitForSpinnerToDisappear();
					Thread.sleep(1000);
					getValidationMessageFromGroupPage();
					waitForSpinnerToDisappear();
					Thread.sleep(1000);

				}
			}

		}
	}

	public String  addSiteUnderGroup() throws InterruptedException {
		String vppGroupName=createVppGroup();
		try {
			waitForSpinnerToDisappear();
			WebElement newlyAddedGroup = driver.findElement(By.xpath("(//span[@title='" + vppGroupName + "'])"));
			System.out.println(newlyAddedGroup.getText());
			if (newlyAddedGroup != null) {
				newlyAddedGroup.click();
				waitForSpinnerToDisappear();
				WebElement siteDropBox = vppPF.getSiteDropBox();
				List<WebElement> siteList = driver
						.findElements(By.xpath("//div[@id='treeTemplateDiv'][@automation-id=3]"));
				int count = siteList.size();
				logger.log(LogStatus.PASS, "Total Number of Sites available are " + count);
				if (count > 0) {
					Iterator<WebElement> iter = siteList.iterator();
					while (iter.hasNext()) {
						WebElement treeItemSite = iter.next();
						String treeItemSiteName = treeItemSite.getText();
						WebElement siteToDrage = driver
								.findElement(By.xpath("//span[text()='" + treeItemSiteName + "'][2]"));
						logger.log(LogStatus.PASS, "Dragging the Site present on Page is " + treeItemSiteName);
						Thread.sleep(2000);
						Actions act = new Actions(driver);
						act.dragAndDrop(siteToDrage, siteDropBox);
						act.build().perform();
						Thread.sleep(2000);
						clickOnSaveButton();
						waitForSpinnerToDisappear();
						getValidationMessageFromGroupPage();
						logger.log(LogStatus.PASS, "Added Site-> " + treeItemSiteName + " Under Group-> " + vppGroupName);
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not Add Site Under Customer");
		}
		return newVPPGroupName;
	}

	public void removeAsignedSiteFromGroup() {
		try {
			String treeItemSiteName = "";
			String vppGroupName= addSiteUnderGroup();
			Thread.sleep(2000);
			
			waitForSpinnerToDisappear();
			WebElement newlyAddedGroup = driver.findElement(By.xpath("(//span[@title='" + vppGroupName + "'])"));
			logger.log(LogStatus.PASS, newlyAddedGroup.getText());
			if (newlyAddedGroup != null) {
				newlyAddedGroup.click();
				waitForSpinnerToDisappear();
				element = vppPF.getremoveSitefromDropBox();
				if (element != null) {
					element.click();
					element = vppPF.getOkButton();
					if (element != null) {
						waitForSpinnerToDisappear();
						element.click();
					}
					// waitForSpinnerToDisappear();
					clickOnSaveButton();
					waitForSpinnerToDisappear();
					logger.log(LogStatus.PASS, "Removed the site under "+vppGroupName);
					Thread.sleep(1000);
					newlyAddedGroup = driver.findElement(By.xpath("(//span[@title='" + vppGroupName + "'])"));
					if (newlyAddedGroup != null) {
						newlyAddedGroup.click();
						waitForSpinnerToDisappear();
					}
					element = vppPF.getgroupDeleteButton();
					if (element != null) {
						element.click();
						waitForSpinnerToDisappear();
						element = vppPF.getOkButton();
						if (element != null) {
							element.click();
							waitForSpinnerToDisappear();
						
						waitForSpinnerToDisappear();
						Thread.sleep(1000);
						//getValidationMessageFromGroupPage();
						waitForSpinnerToDisappear();
						Thread.sleep(1000);
						logger.log(LogStatus.PASS, "Removed  Site-> " + treeItemSiteName + "Under Customer-> " + customer);
						}
						}else{
						logger.log(LogStatus.FAIL, "There are no sites under Group");
					}
					
				}
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Could not Remove Site Under Customer");
		}

	}

	public void deleteAllGroups() {
		try {
			//int count=0;
			waitForSpinnerToDisappear();
			Thread.sleep(2000);
			List<WebElement> groupList = driver.findElements(By.xpath("//div[@id='treeTemplateDiv'][@automation-id=2]"));
			int count = groupList.size();
			while (count > 0) {
				WebElement groupListSingle = driver.findElement(By.xpath("(//div[@id='treeTemplateDiv'][@automation-id=2])[1]"));
				groupListSingle.click();
				element = vppPF.getgroupDeleteButton();
				if (element != null) {
					waitForSpinnerToDisappear();
					element.click();
					waitForSpinnerToDisappear();
				}
				element = vppPF.getOkButton();
				if (element != null) {
					waitForSpinnerToDisappear();
					element.click();
					logger.log(LogStatus.PASS, groupListSingle.getText()+" Group deleted from Customer");
					waitForSpinnerToDisappear();
					//getValidationMessageFromGroupPage();
				}
				count--;
				//deleteAllGroups();	
			}
			
			logger.log(LogStatus.PASS, "There are No More VPP Groups To Delete");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			logger.log(LogStatus.FAIL, "Could not Delete VPP Groups from Customer");

		}
	}
}
