package mars.JCI.Project.CSD.SCC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.JCI.Project.CSD.Setup.SCC.CSD_SCC_Critical_Alarm_Page_Factory;
import mars.JCI.Project.CSD.Setup.SCC.CSD_SCC_Data_Import_Page_Factory;

public class CSD_SCC_Critical_Alarm_Page_Action {
	
	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	private static CSD_SCC_Critical_Alarm_Page_Factory scc_criticalAlarm_pf = null;
	private static CSD_SCC_SccDataImport_Page_Action scc_sccDataImp_pa = null;
	private static CSD_SCC_Data_Import_Page_Factory csdSCCDataImportPF = null;
	
	public static String sccTestDataJSON = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/TestResources/SCC/SCC_DataImport_TestData.json";
	
	public static String commProtocol_Name, owner_Name, device_Name, eqpRef_Name = null;
	
	private static final By IMAGELOADER = By.cssSelector("div[test-id='loaderWidget']");
	
	@SuppressWarnings("static-access")
	public CSD_SCC_Critical_Alarm_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		scc_criticalAlarm_pf = new CSD_SCC_Critical_Alarm_Page_Factory(driver, logger);
		scc_sccDataImp_pa = new CSD_SCC_SccDataImport_Page_Action(driver, logger);
		csdSCCDataImportPF = new CSD_SCC_Data_Import_Page_Factory(driver, logger);
	}
	

	//====================================================================================================================
	
	
	//Navigate to Critical Alarm Selection Page
	@SuppressWarnings("static-access")
	public static void clickOnCriticalAlarmTabLink() {
		
		scc_sccDataImp_pa.waitForSpinnerToDisappear();
		WebElement admin_element = csdSCCDataImportPF.get_sccTab_AdministrationLink();
		if(admin_element!=null){
			admin_element.click();
			logger.log(LogStatus.PASS, "Clicked on Administraation Link.");
			scc_sccDataImp_pa.waitForSpinnerToDisappear();
			WebElement scc_element = csdSCCDataImportPF.get_sccTab_SCCLink();
			if(scc_element!=null){
				scc_element.click();
				logger.log(LogStatus.PASS, "Clicked on SCC Link");
				scc_sccDataImp_pa.waitForSpinnerToDisappear();
				WebElement sccrta_element = scc_criticalAlarm_pf.get_ca_CriticalAlarmLink();
				if(sccrta_element!=null){
					sccrta_element.click();
					logger.log(LogStatus.PASS, "Clicked on Critical Alarm Link.");
				}else{
					logger.log(LogStatus.FAIL, "Failed to Click on Critical Alarm Link.");
				}
			}else{
				logger.log(LogStatus.FAIL, "Failed to Click on SCC Link.");
			}
		}else{
			logger.log(LogStatus.FAIL, "Failed to Click on Administration Link.");
		}
		
	}
	
	//Critical Alarm Selection Page -- Customer Name Selection
	@SuppressWarnings("static-access")
	public static void selectCustomerNameFromDDL(){
		
		scc_sccDataImp_pa.waitForSpinnerToDisappear();
		WebElement element=scc_criticalAlarm_pf.get_ca_CustNameDDLLink();
		if (element !=null) {
			scc_sccDataImp_pa.waitForSpinnerToDisappear();
			List<String> dataSource_name = ReadJsonFile.readJsonFileDynamic(sccTestDataJSON, "$..CA_Customer_Name");
			System.out.println("dataSource_name : "+dataSource_name);
			scc_sccDataImp_pa.selectByVisibleText(element, dataSource_name.get(0));
			logger.log(LogStatus.PASS, "Existing Customer Name for Template Validation Selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Existing Customer Name");
		}
	}
	
	//Critical Alarm Selection Page -- Facility Name Selection
	@SuppressWarnings("static-access")
	public static void selectFacilityNameFromDDL() 
			throws InterruptedException {
		
		WebElement element=scc_criticalAlarm_pf.get_ca_FacilityNameDDLLink();
		scc_sccDataImp_pa.waitForSpinnerToDisappear();
		if (element !=null) {
			Thread.sleep(3000);
			scc_sccDataImp_pa.waitForSpinnerToDisappear();
			List<String> facility_options = scc_sccDataImp_pa.getAllOptions(element); 
			System.out.println("facility_options size : "+facility_options.size());
			if(facility_options.size() != 0){
				if(facility_options.size() == 2){
					scc_sccDataImp_pa.selectByDesiredIndex(element, 1);
					
				}else if(facility_options.size() > 2){
					int random_range_lim = facility_options.size() - 1;
					int random_index = scc_sccDataImp_pa.getRamdomNoBetweenRange(2, random_range_lim);
					scc_sccDataImp_pa.selectByDesiredIndex(element, random_index-1);
				}
			}
			logger.log(LogStatus.PASS, "Facility Name for configuring Critical Alarm selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Facility Name for configuring Critical Alarm");
		}
	}
	
	
	//Critical Alarm Selection Page -- Asset Name Selection
	@SuppressWarnings("static-access")
	public static void selectAssetNameFromDDL() 
			throws InterruptedException {
		
		WebElement element=scc_criticalAlarm_pf.get_ca_AssetNameDDLLink();
		scc_sccDataImp_pa.waitForSpinnerToDisappear();
		if (element !=null) {
			Thread.sleep(3000);
			scc_sccDataImp_pa.waitForSpinnerToDisappear();
			List<String> facility_options = scc_sccDataImp_pa.getAllOptions(element); 
			System.out.println("facility_options size : "+facility_options.size());
			if(facility_options.size() != 0){
				if(facility_options.size() == 2){
					scc_sccDataImp_pa.selectByDesiredIndex(element, 1);
					
				}else if(facility_options.size() > 2){
					int random_range_lim = facility_options.size() - 1;
					int random_index = scc_sccDataImp_pa.getRamdomNoBetweenRange(2, random_range_lim);
					scc_sccDataImp_pa.selectByDesiredIndex(element, random_index-1);
				}
			}
			logger.log(LogStatus.PASS, "Asset Name for configuring Critical Alarm selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Asset Name for configuring Critical Alarm");
		}
	}
	
	
	//Critical Alarm Selection Page -- Get Asset Details From WebPage
	@SuppressWarnings("static-access")
	public static void getAssetDetailsDataFromGUI() {
		
		scc_sccDataImp_pa.waitForSpinnerToDisappear();
		WebElement commProto_element = scc_criticalAlarm_pf.get_ca_CommnProtoLink();
		if(commProto_element!= null){
			commProtocol_Name = commProto_element.getText();
			System.out.println("commProtocol_Name : "+commProtocol_Name);
			logger.log(LogStatus.PASS, "Communication Protocol for the selected Chiller is : "+commProtocol_Name);
		}
		WebElement owner_element = scc_criticalAlarm_pf.get_ca_OwnerDetailsLink();
		if(owner_element!= null){
			owner_Name = owner_element.getText();
			System.out.println("owner_Name : "+owner_Name);
			logger.log(LogStatus.PASS, "Owner Details for the selected Chiller is : "+owner_Name);
		}
		WebElement device_element = scc_criticalAlarm_pf.get_ca_DeviceDetailsLink();
		if(device_element!= null){
			device_Name = device_element.getAttribute("title");
			System.out.println("device_Name : "+device_Name);
			logger.log(LogStatus.PASS, "Device Details for the selected Chiller is : "+device_Name);
		}
		WebElement eqpRef_element = scc_criticalAlarm_pf.get_ca_EqpRefDetailsLink();
		if(eqpRef_element!= null){
			eqpRef_Name = eqpRef_element.getAttribute("title");
			System.out.println("eqpRef_Name : "+eqpRef_Name);
			logger.log(LogStatus.PASS, "Equipment Reference Details for the selected Chiller is : "+eqpRef_Name);
		}
	}
	
	//Critical Alarm Selection Page --  Select Alarm Type from Drop Down
	@SuppressWarnings("static-access")
	public static void selectAlarmTypeFromDDL() 
			throws InterruptedException {
		
		WebElement element=scc_criticalAlarm_pf.get_ca_AlarmTypeDDLLink();
		scc_sccDataImp_pa.waitForSpinnerToDisappear();
		if (element !=null) {
			Thread.sleep(3000);
			scc_sccDataImp_pa.waitForSpinnerToDisappear();
			List<String> facility_options = scc_sccDataImp_pa.getAllOptions(element); 
			System.out.println("facility_options size : "+facility_options.size());
			if(facility_options.size() != 0){
				if(facility_options.size() == 2){
					scc_sccDataImp_pa.selectByDesiredIndex(element, 1);
					
				}else if(facility_options.size() > 2){
					int random_range_lim = facility_options.size() - 1;
					int random_index = scc_sccDataImp_pa.getRamdomNoBetweenRange(2, random_range_lim);
					scc_sccDataImp_pa.selectByDesiredIndex(element, random_index-1);
				}
			}
			logger.log(LogStatus.PASS, "Alarm Type for configuring Critical Alarm selected successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Alarm Type for configuring Critical Alarm");
		}
	}
	
	
}
