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

public class EQM_Dashboard_Page_Factory {

	protected static final WebElement Productgroup = null;
	protected static final WebElement GenerateReport = null;
	private WebDriver driver = null;
	private ExtentTest logger = null;
	private WebElement element = null;
	
	public EQM_Dashboard_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.logger = logger;
		this.driver = driver;
	}
	
	public boolean isUserMenuPresent() {
		boolean isUserMenuPresent = false;
		EQM_Dashboard_Page_Factory homePF = new EQM_Dashboard_Page_Factory(driver, logger);
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
	
	private WebElement getUserMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	public void waitForPageToLoad(){
		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) 
	        {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	        
	        public void SelectProductgroup()
	    	{
	    		Productgroup.click();
	    	}
	        public void ClickGenerateReport()
	    	{
	    		GenerateReport.click();;
	    	}
	    	
	    });
	}

	
}