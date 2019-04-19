package mars.JCI.Project.EQM.Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.WebElementCommon;

public class EQM_Home_Page_Action {

	private WebDriver driver = null;
	private ExtentTest logger = null;
	private WebElement element = null;
	
	public EQM_Home_Page_Action(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.driver = driver;
	}
	
	public boolean isUserMenuPresent() {
		boolean isUserMenuPresent = false;
		EQM_Home_Page_Factory homePF = new EQM_Home_Page_Factory(driver, logger);
		element = homePF.getUserMenu();
		if(element!= null){
			isUserMenuPresent = WebElementCommon.isElementPresent(driver, element);
			if(isUserMenuPresent){
				logger.log(LogStatus.PASS, "Succesfully identify User Menu WebElement");   
			}
		}
		else{
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Identifying WebElement for User Menu Field Failed");   
		}
		return isUserMenuPresent;
	}
	
	public void waitForPageToLoad(){
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}

	
}