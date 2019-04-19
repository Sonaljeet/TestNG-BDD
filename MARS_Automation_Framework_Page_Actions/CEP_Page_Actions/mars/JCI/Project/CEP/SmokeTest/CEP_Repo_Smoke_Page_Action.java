package mars.JCI.Project.CEP.SmokeTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CEP.Smoke.CEP_Repo_Smoke_Page_Factory;

public class CEP_Repo_Smoke_Page_Action extends BaseClass {

	public CEP_Repo_Smoke_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	public void navigateToRepo() throws Exception {
		CEP_Repo_Smoke_Page_Factory objR = new CEP_Repo_Smoke_Page_Factory(driver, logger);
		WebElement link = objR.getRepoLink();
		if(link!=null){
			link.click();
			//logger.log(LogStatus.PASS, "Successfully navigated to Repository page.");
			//Thread.sleep(3000);
		//	getFinalReport(driver, logger, "page", true);
		}
		else{
			logger.log(LogStatus.FAIL, "Repository link not present.");
		//	getFinalReport(driver, logger, "page", false);
		}
	}
}
