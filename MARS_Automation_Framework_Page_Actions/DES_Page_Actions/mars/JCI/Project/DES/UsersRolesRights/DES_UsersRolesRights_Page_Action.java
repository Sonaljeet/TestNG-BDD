package mars.JCI.Project.DES.UsersRolesRights;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

import commonFunctions.WebDropDown;
import mars.JCI.Project.DES.Home.DES_Home_Page_Action;
import mars.JCI.Project.DES.UsersRole.DES_UsersRole_Page_Action;
import mars.JCI.Project.DES.Users_RolesAndRight.DES_USERS_RolesAndRight_Page_Factory;

public class DES_UsersRolesRights_Page_Action {

	private static WebDriver driver;
	private static ExtentTest logger;
	private static WebElement element=null;
	private static DES_USERS_RolesAndRight_Page_Factory rolerPF=null;
	private static DES_UsersRole_Page_Action rolePF=null;
	
	public DES_UsersRolesRights_Page_Action(WebDriver driver,ExtentTest logger){
		this.driver=driver;
		this.logger=logger;
		rolerPF=new DES_USERS_RolesAndRight_Page_Factory(driver, logger);
		rolePF=new DES_UsersRole_Page_Action(driver, logger);
	}
	
	public void waitForSpinnerToDisappear(){
		By spinner=By.id("divloadingConfiguration");
		Wait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
       .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
	}
	
	public String getValidationMessageFromGroupPage() {
		String Message = null;
		element = rolerPF.getRoleSuccessMessage();
		if (element != null) {
			Message = element.getText();
			System.out.println(Message + " Message From The Page");
			logger.log(LogStatus.PASS, "\"" + Message + "\" Message Recieved from Page");
		} else {
			logger.log(LogStatus.FAIL, "Failled to Get the Message from Page");
		}
		return Message;
	}
	
	@SuppressWarnings("static-access")
	public void navigateToRoleAndRightTab(){
		try{
		waitForSpinnerToDisappear();
		rolePF.navigateToUsersRolePage();
		waitForSpinnerToDisappear();
		element=rolerPF.getroleandrighttab();
		if(element!=null){
			element.click();
			waitForSpinnerToDisappear();
		}
		logger.log(LogStatus.PASS, "Navigates to Roles & Rights tab");
	}catch(Exception e){
		logger.log(LogStatus.FAIL, "Could not Navigate to Roles & Rights tab");
	}
	}
	public void clickOnSaveButton(){
		element=rolerPF.getrolerightSavebtn();
		if(element!=null){
			element.click();
			waitForSpinnerToDisappear();
		}
		
	}
	
	public void clickOnCancelButton(){
		element=rolerPF.getrolerightcancelbtn();
		if(element!=null){
			element.click();
			waitForSpinnerToDisappear();
		}
	}
	public String  createAndSelectRole(){
		String roleAdded=rolePF.addRole();
		element=rolerPF.getroleandrighttab();
		if(element!=null){
			element.click();
			waitForSpinnerToDisappear();
		}
		element=rolerPF.getrolenamedropdown();
		if(element!=null){
			WebDropDown.SelectElementByVisibleText(element, roleAdded);
			System.out.println(roleAdded+ " Selected from dropdown");
			waitForSpinnerToDisappear();
			
		}
		return roleAdded;
	}
	
	//Create Admin Role
	public String assignAllRightsToRoles(){
		//navigateToRoleAndRightTab();
			String roleAdded=createAndSelectRole();
			List<WebElement> checkbox=driver.findElements(By.xpath("//tbody/tr/td/div/input[@type='checkbox'][@class='ng-pristine ng-untouched ng-valid ng-scope']"));
			for(int i=0;i<=checkbox.size()-1;i++){
				checkbox.get(i).click();
				}
			clickOnSaveButton();
			System.out.println("Admin Role with all rights created with name "+roleAdded);
			return roleAdded;
	}
	//create Role only with view rights
	public void assignOnlyViewRightsToRole(){
		String roleAdded=createAndSelectRole();
		
	}
}
