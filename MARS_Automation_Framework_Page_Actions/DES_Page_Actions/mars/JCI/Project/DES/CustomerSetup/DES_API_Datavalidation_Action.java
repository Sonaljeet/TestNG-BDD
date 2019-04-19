package mars.JCI.Project.DES.CustomerSetup;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebInputTextBox;
import commonFunctionsAPI.CommonAPI_Functions;
import mars.Component.Functions.API_BaseClass;
import mars.JCI.Project.DES.Login.DES_Login_Page_Factory;

public class DES_API_Datavalidation_Action extends API_BaseClass{
	
	public static DES_Login_Page_Factory loginPF=null;
	
	public DES_API_Datavalidation_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPF= new DES_Login_Page_Factory(driver, logger);
	}
	
	public static void UI_DataValidation(WebDriver driver,ExtentTest logger,String value,String methodName){
		driver.manage().window().maximize();
		enterUsername();
		enterPassword();
		clickOnBtnLogin();
		commonFunctions.WebElementCommon.staticWait(25000);
		verifyFacility_Minimum_temparature_Text(value,methodName);
		
	}

	private static void verifyFacility_Minimum_temparature_Text(String value, String methodName) {
		// TODO Auto-generated method stub
	/*	List<WebElement> FacilityWebElements = null;
		WebElement FacilityMin_Temp_WebElement = null;
		int flag=0;
		for (int count = 0; count < 20; count++) {
			FacilityWebElements = loginPF.Facilitynames;
			if (FacilityWebElements.size() > 0) {
				FacilityMin_Temp_WebElement = loginPF.get_Facilityname_min_temparature();
				API_BaseClass.getFinalReport(driver, logger, methodName, false);
				flag=1;
				break;
			}
			Thread.sleep(2000);
		}
		for (int i = 0; i < 5; i++) {
			if (FacilityMin_Temp_WebElement != null) {
				if (FacilityMin_Temp_WebElement.getText().contains(value)) {
					logger.log(LogStatus.INFO, "UI value is = "+FacilityMin_Temp_WebElement.getText().replace("°F",""));
					logger.log(LogStatus.PASS, "UI and API response values are matching");
				} else {
					throw new Exception("UI value ="+ FacilityMin_Temp_WebElement.getText().replace("°F","")+" and API response value= "+ value.replace(".0", "")+" are not matching");
				}
				break;
			}
		}
		if(loginPF.OverviewDashboard.size()==0){
			throw new Exception("Overview Dashboard page is not present");
		}
	}*/
		
	}

	private static void clickOnBtnLogin() {
		// TODO Auto-generated method stub
		WebElement element = null;
		element = loginPF.getSignIn();
		if (element != null) {
			element.click();
			logger.log(LogStatus.PASS, "Successfully clicked Login button");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Login button Failed");
		}
		
	}

	private static void enterPassword() {
		// TODO Auto-generated method stub
		WebElement element = null;
		element=loginPF.getPassword();
			if (element != null) {
				WebInputTextBox.SendInputTextBox(driver, element, CommonAPI_Functions.properties.getProperty("UI_Password"));
				logger.log(LogStatus.PASS, "Password Entered succesfully to Password field");
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Password Field Failed");
			}
		
	}

	private static void enterUsername() {
		// TODO Auto-generated method stub
		WebElement element = null;
		element=loginPF.getUserName();
			if (element != null) {
				WebInputTextBox.SendInputTextBox(driver, element, CommonAPI_Functions.properties.getProperty("UI_Username"));
				logger.log(LogStatus.PASS, "Username Entered succesfully to Username field");
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Username Field Failed");
			}
	}
	

}
