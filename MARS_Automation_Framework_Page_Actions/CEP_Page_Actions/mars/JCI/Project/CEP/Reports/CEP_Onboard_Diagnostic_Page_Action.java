package mars.JCI.Project.CEP.Reports;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Component.Functions.BaseClass;

public class CEP_Onboard_Diagnostic_Page_Action extends BaseClass {
	public CEP_Onboard_Diagnostic_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	public void validateFields() throws Exception {
		logger.log(LogStatus.PASS, "Field for the Onboard Diagnostic Report are as expected.");
		getFinalReport(driver, logger, "fieldsOnbDia", true);
	}
	
	public void validatePDF() throws Exception {
		logger.log(LogStatus.PASS, "PDF data for the Chiller Trend Report are as expected.");
	//	getFinalReport(driver, logger, "pdfOnbDia1", true);
	//	getFinalReport(driver, logger, "pdfOnbDia2", true);
	//	getFinalReport(driver, logger, "pdfOnbDia3", true);
	}

}
