/*-------------------------------------------------------------------------------------

(C) Copyright 2016 Johnson Controls, Inc. 
    Use or Copying of all or any part of this program, except as
    permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/

/**
 * @author cdeyso
 *
 */


package mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commonFunctions.WebElementCommon;
import commonFunctions.WebLink;
import commonFunctions.WebPage;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;

import mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails.CSD_PointDetailsTab_Page_Factory;
import mars.JCI.Project.CSD.HomePage.Dashboard.PointDetails.CSD_PointDetails_DataValidation_Master;

public class CSD_PointDetailsTab_Page_Action {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;

	private static CSD_PointDetailsTab_Page_Factory homePageFactory = null;
	private static CSD_Login_Page_Action loginPageAction = null;
	private static CSD_PointDetails_DataValidation_Master csd_ptDetails_dataVal = null;
	
	private static final By IMAGELOADER = By.id("loader");
	
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String JDBC_DB_URL = "jdbc:sqlserver://csdusql.database.windows.net:1433;database=CSDDB";//;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";//;user=sa;password=password"; //61448
	private static final String USER = "jciazdeploy@csdusql";
	private static final String PASS = "9t%ECTeq^TGg";
	public static Connection conn = null;
	
	public static String project_dir = "C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Projects\\mars\\JCI\\Project\\CSD\\TestResources";
	
	public static String selectedProjectName,selectedSiteName,selectedChillerName = null;
	
	public static Set<String> pointCategoryList = new HashSet<String>();
	public static List<String> pointSubCategoryList = new ArrayList<String>();
	
	public static String chiller_att_id = null;

	@SuppressWarnings("static-access")
	public CSD_PointDetailsTab_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		loginPageAction = new CSD_Login_Page_Action(driver, logger);
		homePageFactory = new CSD_PointDetailsTab_Page_Factory(driver, logger);
		csd_ptDetails_dataVal = new CSD_PointDetails_DataValidation_Master(logger);
	}

	//==========WebElement related metods--START
	
	//Click on the Dashboard Tab of the Left Sided Tree
	public static void clickOnDashboardLink(){
		
		waitForSpinnerToDisappear();
		WebElement element=homePageFactory.get_pointDetailsTab_DashboardLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element !=null && element.isEnabled()) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Dashboard Link clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to find Dashboard Link");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Click on the Right Menu Button on the right side of the page -- to search the various chillers and projects and sites.
	public static void clickOnRightMenuButton(){
		WebElement element = homePageFactory.get_pointDetailsTab_RightmenuLink();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Right Menu Button clicked successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to click Right Menu Button");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Enter the Required Project for validation -- Method to perform that
	public static void enterRequiredProject() 
			throws InterruptedException{
		WebElement element = homePageFactory.get_pointDetailsTab_SearchChillerTxtBox();
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element != null) {
			waitForSpinnerToDisappear();
			element.sendKeys("Peets_org_segwayz_2");//element.click();//Peets_org_segwayz_2 -- FREDKIN BUSINESS SERVICES
			selectedProjectName = "Peets_org_segwayz_2";
			Thread.sleep(2000);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Random Chiller Project entered successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to enter Random Chiller Project");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Select the Required Project for validation -- Method to perform that
	public static void selectRequiredProject() 
			throws InterruptedException{
		//WebElement element = homePageFactory.get_pointDetailsTab_ChillerDetailsOne();
		WebElement element = homePageFactory.get_pointDetailsTab_ChillerDetailsOne(selectedProjectName);
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Random Chiller Project Selected successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Random Chiller Project");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Select the Required Project Site for validation -- Method to perform that
	public static void selectRequiredChillerSite() 
			throws InterruptedException{
		waitForSpinnerToDisappear();
		selectedSiteName = "Peets_org_segwayz";
		WebElement element = homePageFactory.get_pointDetailsTab_ChillerDetailsTwo(selectedSiteName);
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Required Chiller Site is Selected successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Required Chiller Site");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Select the Required Project Site Chiller Equipment for validation -- Method to perform that
	public static void selectRequiredChillerEquipment(){
		
		waitForSpinnerToDisappear();
		selectedChillerName = "YK Chiller 4_JCI-14";
		WebElement element = homePageFactory.get_pointDetailsTab_ChillerDetailsThree(selectedChillerName);
		waitForSpinnerToDisappear();
		boolean elementStatus=false;
		if (element != null) {
			element.click();
			logger.log(LogStatus.PASS, "Required Chiller Equipment is Selected successfully");
			elementStatus=true;
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Required Chiller Equipment");
			elementStatus=false;
		}
		//return elementStatus;
	}
	
	//Select the Required Project Site Chiller Equipment for validation -- Method to perform that
	public static void clickPointDetailsTab() throws InterruptedException{
		waitForSpinnerToDisappear();
		WebElement element=homePageFactory.get_pointDetailsTab_PointDetaialsTabLink();
		boolean elementStatus=false;
		waitForSpinnerToDisappear();
		//Thread.sleep(5000);
		if (element !=null) {
			waitForSpinnerToDisappear();
			element.click();
			logger.log(LogStatus.PASS, "Point Details Tab link clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to click Point Details Tab link");
		}
		//return elementStatus;
	}
	
	//Click on the Manage Active Points Tab
	public static void clickManageActivePointsButton() {
		
		waitForSpinnerToDisappear();
		WebElement element=homePageFactory.get_pointDetailsTab_ManageActivePointsButton();
		if (element !=null) {
			waitForSpinnerToDisappear();
			element.click();
			logger.log(LogStatus.PASS, "Point Details Tab link clicked successfully");
		}else{
			logger.log(LogStatus.FAIL, "Failed to click Point Details Tab link");
		}
	}
	
	//Get the Required Chiller Equipment Model Details for validation -- Method to perform that
	public static String getChillerModelDetails() throws InterruptedException {
		
		WebElement element_img=homePageFactory.get_pointDetailsTab_ChillerModelDetailsImgLink();
		String chiller_model_name = null;
		waitForSpinnerToDisappear();
		//Thread.sleep(2000);
		boolean elementStatus=false;
		if (element_img !=null) {
			waitForSpinnerToDisappear();
			element_img.click();
			waitForSpinnerToDisappear();
		    WebElement element_txt=homePageFactory.get_pointDetailsTab_ChillerModelDetailsTxtLink();
			if (element_txt !=null) {
				chiller_model_name = element_txt.getText().substring(6);
				System.out.println("chiller model name "+chiller_model_name);
				logger.log(LogStatus.PASS, "Chiller Model Name Collected successfully");
				element_img.click();
				elementStatus=true;
			}else{
				elementStatus=false;
				logger.log(LogStatus.FAIL, "Failed to collect Chiller Model Details");
			}
			logger.log(LogStatus.PASS, "Chiller Model Details Image clicked successfully");
			elementStatus=true;
		}else{
			elementStatus=false;
			logger.log(LogStatus.FAIL, "Failed to click Chiller Model Details Image link");
		}
		//return elementStatus;
		return chiller_model_name;
		
		
	}
	
	//Get the Required Chiller Equipment Model ID Details for validation From DB -- Method to perform that
	public static int GetModelIdForChillerModel(String chiller_name) throws ClassNotFoundException, SQLException {
		
		int model_id = 0;
		if(chiller_name != null){
		
		System.out.println("Inside GetModelIdForChillerModel Method !");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
		System.out.println("Establishing Connection to CSDDB !!");
		conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
		System.out.println("Connection to CSDDB established !!");
		logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
		Statement statement = conn.createStatement();
        String queryString = "select ModelId from tblmstmodel where modelname='"+chiller_name+"'";//Point_Group,
        ResultSet rs = statement.executeQuery(queryString);
        if(rs.wasNull()){
        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated !");
        }
        else{
        	logger.log(LogStatus.PASS, "Query Executed Successfully.");
        }
        	
        System.out.println("Query Executed !!");
        
        ResultSetMetaData metaData = rs.getMetaData();
        //int rowIndex = 0;
        while (rs.next()) {
            /*for (int i=1; i<=metaData.getColumnCount(); i++) {
                    System.out.print("  "  + rs.getString(i));
                    model_id = rs.getString(i).to;*/
        	model_id = rs.getInt("ModelId");
            }
           System.out.println();
		
		}
		else{
			logger.log(LogStatus.FAIL, "Chiller Name Received is NULL");
		}
			
		return model_id;
	}
	
	public void GetChillerAttributeDetails(int model_id) throws SQLException, IOException {
		
		if (model_id != 0){
			
		System.out.println("Inside GetChillerAttributeDetails MEthod!");
		Statement statement = conn.createStatement();
        String queryString = "select A.Point_Group,A.Attributename,B.Description from dbo.tblAttributeLookup A inner join dbo.tblAssetAttributes B on A.AttributeName=B.AttributeName where A.Model_Id="+model_id+" order by A.Point_Group";//Point_Group,
        ResultSet rs = statement.executeQuery(queryString);
        System.out.println("Query Executed !!");
        if(rs.wasNull()){
        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated !");
        }
        else{
        	logger.log(LogStatus.PASS, "Query Executed Successfully.");
        }
        //Load all the entries into Exel file
        //FileInputStream fileIn = new FileInputStream(project_dir+"\\PointAttributeDetails.xls");
        HSSFWorkbook wb = new HSSFWorkbook();//fileIn
        HSSFSheet sheet = wb.createSheet("Point Details Description");
        wb.setSheetOrder("Point Details Description", 0);
        HSSFRow rowhead = sheet.createRow((short) 0);
        rowhead.createCell((short) 0).setCellValue("Point_Group");
        rowhead.createCell((short) 1).setCellValue("Attributename");
        rowhead.createCell((short) 2).setCellValue("Description");
        
        int index = 1;
        while (rs.next()) {

                HSSFRow row = sheet.createRow((short) index);
                row.createCell((short) 0).setCellValue(rs.getString(1));
                row.createCell((short) 1).setCellValue(rs.getString(2));
                row.createCell((short) 2).setCellValue(rs.getString(3));
               
                index++;
        }
        
        FileOutputStream fileOut = new FileOutputStream(project_dir+"\\PointAttributeDetails.xls");
        wb.write(fileOut);
        fileOut.close();
        wb.close();
        System.out.println("Chiller Attribute Data is saved in excel file.");
        logger.log(LogStatus.PASS, "Chiller Attribute Data is saved in excel file - Point Details Description");
        rs.close();
        
        String queryString_2 = "select distinct(A.Point_Group) from dbo.tblAttributeLookup A inner join dbo.tblAssetAttributes B on A.AttributeName=B.AttributeName where A.Model_Id="+model_id+" order by A.Point_Group";
        ResultSet rs_2 = statement.executeQuery(queryString_2);
        System.out.println("Query Executed !!");
        //FileInputStream fileIn_2 = new FileInputStream(project_dir+"\\PointAttributeDetails.xls");
        //HSSFWorkbook wb_2 = new HSSFWorkbook();//fileIn_2
        HSSFSheet sheet_2 = wb.createSheet("Point Details Category");
        wb.setSheetOrder("Point Details Category", 1);
        HSSFRow rowhead_2 = sheet_2.createRow((short) 0);
        rowhead_2.createCell((short) 0).setCellValue("Point_Group");
        int index_2 = 1;
        while (rs_2.next()) {
        	
                HSSFRow row = sheet_2.createRow((short) index_2);
                row.createCell((short) 0).setCellValue(rs_2.getString(1));
               
                index_2++;
        }
        //System.out.println("index_2 "+index_2);
        HSSFRow row = sheet_2.createRow((short) index_2);
        row.createCell((short) 0).setCellValue("CPO 5"); //Hardcode the Value for all the Checks !!
        
        FileOutputStream fileOut_2 = new FileOutputStream(project_dir+"\\PointAttributeDetails.xls");
        wb.write(fileOut_2);
        fileOut_2.close();
        wb.close();
        System.out.println("Chiller Attribute Data is saved in excel file.");
        logger.log(LogStatus.PASS, "Chiller Attribute Data is saved in excel file - Point Details Category");
        rs_2.close();
        
        
		}
		else{
			logger.log(LogStatus.FAIL, "Model ID is received is NULL");
		}
        
	}
	
	public void GetEligibleChillerPointHeadersFromSheet() 
			throws BiffException, IOException, SQLException {
		
		if(pointCategoryList.size() > 0) pointCategoryList.clear();
		if(pointSubCategoryList.size() > 0) pointSubCategoryList.clear();
		
		System.out.println("Inside GetEligibleChillerPointHeadersFromSheet Method !");
		String CellGetContent_lst,CellGetContent_name,att_point_name = null;
		//Thread.sleep(2000);
		//Read the Exel File for the all available points inside the Point Details Tab
		File inputWorkbook = new File(project_dir+"\\TestData_CPO5.xls");
		Workbook workbook = Workbook.getWorkbook(inputWorkbook);
		Sheet points_sheet = workbook.getSheet(1);
		File inputWorkbook_att = new File(project_dir+"\\PointAttributeDetails.xls");
		Workbook workbook_att = Workbook.getWorkbook(inputWorkbook_att);
		Sheet points_sheet_att = workbook_att.getSheet(1);
		////button[contains(text(),'Manage Active Points')]
		driver.findElement(By.xpath(".//*[@id='wrap']/div/div/div/div/div[3]/div/point-wise-analytics-dir/div/div[1]/div[2]/div/div[2]/button")).click();
		System.out.println("Inside PointDetails Pop Up!");
		for (int j = 1; j < points_sheet_att.getRows(); j++){ //points_sheet_att
			att_point_name = points_sheet_att.getCell(0,j).getContents();
			logger.log(LogStatus.PASS, "Checking availability for : "+att_point_name);
			for (int i = 1; i < points_sheet.getRows(); i++){
				CellGetContent_lst = points_sheet.getCell(0,i).getContents();
				CellGetContent_name = points_sheet.getCell(1,i).getContents();
				
				System.out.println("Checking availability for : "+CellGetContent_name);
				//logger.log(LogStatus.PASS, "Checking availability for : "+CellGetContent_name);
				if(CellGetContent_name.equalsIgnoreCase(att_point_name)){
				logger.log(LogStatus.PASS, CellGetContent_name.toUpperCase()+" is a valid point Category for the Respective Chiller");
				boolean status = validatetPointGroupDatails(CellGetContent_name);
				System.out.println(status);
				if(status == true){
					logger.log(LogStatus.PASS, CellGetContent_name.toUpperCase()+" is a valid and also an Eligible point Category for the Respective Chiller");
					GetChillerPointsFromUIDynamic(CellGetContent_lst,i);
				}
				else{
					logger.log(LogStatus.INFO, CellGetContent_name.toUpperCase()+" is a valid but not an Eligible point Category for the Respective Chiller");
					//break;
				}
			}/*else{
			logger.log(LogStatus.FAIL, CellGetContent_name.toUpperCase()+" is NOT a valid point Category for the Respective Chiller");
			}*/
		}
			//logger.log(LogStatus.FAIL, CellGetContent_name.toUpperCase()+" is NOT a valid point Category for the Respective Chiller");
			//validateChillerPointHeaders(CellGetContent_name,CellGetContent_lst,i);
			/*boolean status = validateChillerPointHeaders(CellGetContent_name,CellGetContent_lst,i);
			if(status == true)
				logger.log(LogStatus.PASS, CellGetContent_name.toUpperCase()+" is a valid point Category for the Respective Chiller");
			logger.log(LogStatus.FAIL, CellGetContent_name.toUpperCase()+" is NOT a valid point Category for the Respective Chiller");*/
		}	
		
		System.out.println("pointCategoryList : "+pointCategoryList);
		logger.log(LogStatus.INFO, "Cumulated Points Category List : "+pointCategoryList);
		System.out.println("pointSubCategoryList : "+pointSubCategoryList);
		logger.log(LogStatus.INFO, "Cumulated Points List : "+pointSubCategoryList);
		
	}
	
	//------------------------------------------------------------------------------------------------------------------------
	public void GetChillerPointHeadersFromSheet() throws InterruptedException, IOException, BiffException, SQLException {
		String CellGetContent_lst,CellGetContent_name,att_point_name = null;
		System.out.println("Inside GetChillerPointHeadersFromSheet Method !");
		//Thread.sleep(2000);
		//Read the Exel File for the all available points inside the Point Details Tab
		File inputWorkbook = new File(project_dir+"\\TestData_CPO5.xls");
		Workbook workbook = Workbook.getWorkbook(inputWorkbook);
		Sheet points_sheet = workbook.getSheet(1);
		File inputWorkbook_att = new File(project_dir+"\\PointAttributeDetails.xls");
		Workbook workbook_att = Workbook.getWorkbook(inputWorkbook_att);
		Sheet points_sheet_att = workbook_att.getSheet(1);
		driver.findElement(By.xpath(".//*[@id='wrap']/div/div/div/div/div[3]/div/point-wise-analytics-dir/div/div[1]/div[2]/div/div[2]/button")).click();
		System.out.println("Inside PointDetails Pop Up!");
		System.out.println("points_sheet.getRows() "+points_sheet.getRows());
		for (int i = 1; i < points_sheet.getRows(); i++) //points_sheet
		{
			System.out.println("i "+i);
			CellGetContent_lst = points_sheet.getCell(0,i).getContents();
			CellGetContent_name = points_sheet.getCell(1,i).getContents();
			
			System.out.println("Checking availability for : "+CellGetContent_name);
			logger.log(LogStatus.PASS, "Checking availability for : "+CellGetContent_name);//
			Thread.sleep(2000);
			System.out.println("points_sheet_att.getRows() "+points_sheet_att.getRows());
			for (int j = 1; j < points_sheet_att.getRows(); j++){ //points_sheet_att
				System.out.println("j "+j);
				att_point_name = points_sheet_att.getCell(0,j).getContents();
				if(CellGetContent_name.equalsIgnoreCase(att_point_name)){
					logger.log(LogStatus.PASS, CellGetContent_name.toUpperCase()+" is a valid point Category for the Respective Chiller");
					boolean status = validatetPointGroupDatails(CellGetContent_name);
					System.out.println(status);
					if(status == true){
						logger.log(LogStatus.PASS, CellGetContent_name.toUpperCase()+" is a valid and also an Eligible point Category for the Respective Chiller");
						GetChillerPointsFromUIDynamic(CellGetContent_lst,i);
					}
					else{
						logger.log(LogStatus.FAIL, CellGetContent_name.toUpperCase()+" is a valid but not an Eligible point Category for the Respective Chiller");
						//break;
					}
				}/*else{
				logger.log(LogStatus.FAIL, CellGetContent_name.toUpperCase()+" is NOT a valid point Category for the Respective Chiller");
				}*/
			}
			logger.log(LogStatus.FAIL, CellGetContent_name.toUpperCase()+" is NOT a valid point Category for the Respective Chiller");
			//validateChillerPointHeaders(CellGetContent_name,CellGetContent_lst,i);
			/*boolean status = validateChillerPointHeaders(CellGetContent_name,CellGetContent_lst,i);
			if(status == true)
				logger.log(LogStatus.PASS, CellGetContent_name.toUpperCase()+" is a valid point Category for the Respective Chiller");
			logger.log(LogStatus.FAIL, CellGetContent_name.toUpperCase()+" is NOT a valid point Category for the Respective Chiller");*/
		}	
		
	
	}
	
	//Get the Dynamic XPATH for every point category -- TO MAKE THE XPATH DYNAMIC 
	public void GetChillerPointsFromUIDynamic(String point_header, int row_num) throws BiffException, IOException, SQLException {
		
		//if(pointCategoryList.size() > 0) pointCategoryList.clear();
		//if(pointSubCategoryList.size() > 0) pointSubCategoryList.clear();
		
		System.out.println("Inside GetChillerPointsFromUIDynamic Method !");
		waitForSpinnerToDisappear();
		String point_sub_category = null;
		if(driver.findElements(By.xpath("//span[@test-id='"+point_header+"']")).size() != 0){
			File inputWorkbook = new File(project_dir+"\\TestData_CPO5.xls");//PointAttributeDetails -- TestData_CPO5
			Workbook workbook = Workbook.getWorkbook(inputWorkbook);
			Sheet points_sheet = workbook.getSheet(1);
			String CellGetContent = points_sheet.getCell(1,row_num).getContents();
			
			System.out.println("Getting "+CellGetContent+" Point Details for the selected Chiller !");
			List<WebElement> point_details = driver.findElements(By
	                .xpath("//span[@test-id='"+point_header+"']/ancestor::ul/ul")); //ancestor //span[@test-id='lst-CPO 5']/parent::ul/ul /ul
	        System.out.println(CellGetContent+" Points : "+point_details.size());
	        logger.log(LogStatus.PASS, CellGetContent+" Points : "+point_details.size());
	        for (int i = 1; i < point_details.size()+1; i++) {
	            WebElement linkElement = driver.findElement(By.xpath("//span[@test-id='"+point_header+"']/ancestor::ul/ul["+i+"]/li"));
	            pointCategoryList.add(point_header);
	            System.out.println(linkElement.getText());
	            point_sub_category = linkElement.getText();
	            pointSubCategoryList.add(point_sub_category);
	            logger.log(LogStatus.PASS, point_header.toUpperCase()+" category point is : "+point_sub_category);
	            validatePointsSubCategoryWithDB(point_header,point_sub_category);
	        }
		}
		else{
			System.err.println("Going to check the Next iteration !");
			logger.log(LogStatus.FAIL, "Failed to Retrieve Point Details!");
		}
	}
	
	/*public void validateChillerPointHeaders(String sheet_point_header,String sheet_point_locator,int sheet_row_num) throws BiffException, IOException {
		String CellGetContent = null;
		File inputWorkbook = new File(project_dir+"\\PointAttributeDetails.xls");
		Workbook workbook = Workbook.getWorkbook(inputWorkbook);
		Sheet points_sheet = workbook.getSheet(1);
		for (int i = 1; i < points_sheet.getRows(); i++) 
		{
			CellGetContent = points_sheet.getCell(0,i).getContents();
			if(sheet_point_header.toLowerCase().equalsIgnoreCase(CellGetContent))
			{
				logger.log(LogStatus.PASS, CellGetContent.toUpperCase()+" is a valid point Category for the Respective Chiller");
				GetChillerPointsFromUIDynamic(sheet_point_locator,sheet_row_num);
				//return true;
			}
			else{
				return false;
			}
		}
		//return false;
		
	}*/
	
	
	public static void waitForSpinnerToDisappear(){
		//driver.findElement(By.id("loadingWidget"));
		By spiner = By.id("loadingWidget");
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(spiner));
	}
	
	public String getAssetAttributeID() {
		WebElement element = homePageFactory.get_pointDetailsTab_ChillerModelDetailsImgLink();
		//String chiller_att_id=null;
		if (element != null) {
			waitForSpinnerToDisappear();
			element.click();
			WebElement assetID_element = driver.findElement(By.cssSelector("span[test-id='AssetDetailsId']"));
			String chiller_att =  (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML", assetID_element);//element.getText();
			chiller_att_id = chiller_att;
			System.out.println("Chiller asset ID : "+chiller_att_id);
			waitForSpinnerToDisappear();
			element.click();
			WebElementCommon.waitForElementToDisappear(driver, IMAGELOADER);
			logger.log(LogStatus.PASS, "Selected Chiller's AssetDetailsID Selected successfully. Asset Detail ID is : "+chiller_att_id);
		}else{
			logger.log(LogStatus.FAIL, "Failed to select Chiller's AssetDetailsID");
		}
		return chiller_att_id;
		
	}
	
	public void getAssetDetailsForSelectedChiller(String chiller_asset_id) 
			throws SQLException, IOException, ClassNotFoundException {
		
		if(chiller_asset_id != null)
		{
			if(conn == null){
				System.out.println("Inside GetModelIdForChillerModel Method !");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				logger.log(LogStatus.PASS, "Establishing Connection to CSDDB !!");
				System.out.println("Establishing Connection to CSDDB !!");
				conn = DriverManager.getConnection(JDBC_DB_URL, USER, PASS);
				System.out.println("Connection to CSDDB established !!");
				logger.log(LogStatus.PASS, "Connection to CSDDB established !!");
			}else{
				System.out.println("Connection Exists!");
			}
			System.out.println("Inside getAssetDetailsForSelectedChiller MEthod!");
			Statement statement = conn.createStatement();
	        String queryString = "select A.pointid,A.name,A.pointname from tblPoint A inner join tblNAEName B on A.NAEId = B.naeid where B.AssetDetailsId="+chiller_asset_id;
	        ResultSet rs = statement.executeQuery(queryString);
	        System.out.println("Query to get the PointID and PointName details is Executed !!");
	        if(rs.wasNull()){
	        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated !");
	        }
	        else{
	        	logger.log(LogStatus.PASS, "Query to get the PointID and PointName details is Executed Successfully.");
	        }
	        //Load all the entries into Exel file
	        FileInputStream fileIn = new FileInputStream(project_dir+"\\PointAttributeDetails.xls");
	        HSSFWorkbook wb = new HSSFWorkbook(fileIn);//fileIn
	        HSSFSheet sheet = wb.createSheet("AssetDetailsID");
	        wb.setSheetOrder("AssetDetailsID", 2);
	        HSSFRow rowhead = sheet.createRow((short) 0);
	        rowhead.createCell((short) 0).setCellValue("Point_ID");
	        rowhead.createCell((short) 1).setCellValue("Name");
	        rowhead.createCell((short) 2).setCellValue("PointName");
	        rowhead.createCell((short) 3).setCellValue("AssetDetailsID");
	        
	        int index = 1;
	        while (rs.next()) {

	                HSSFRow row = sheet.createRow((short) index);
	                row.createCell((short) 0).setCellValue(rs.getInt(1));
	                row.createCell((short) 1).setCellValue(rs.getString(2));
	                row.createCell((short) 2).setCellValue(rs.getString(3));
	                row.createCell((short) 3).setCellValue(chiller_asset_id);
	                
	                index++;
	        }
	        
	        
	        FileOutputStream fileOut = new FileOutputStream(project_dir+"\\PointAttributeDetails.xls");
	        wb.write(fileOut);
	        fileOut.close();
	        wb.close();
	        System.out.println("Chiller Asset Details Data is saved in excel file.");
	        logger.log(LogStatus.PASS, "Chiller Asset Details Data is saved in excel file - AssetDetailsID");
	        rs.close();
	        
	        //Eligible point details
	        String queryString_2 = "select distinct (D.Point_Category_Name) from tblPoint A inner join tblNAEName B on A.NAEId = B.naeid inner join tblpointcategoryrelation C on C.pointid=A.pointId inner join tblpointcategory D on D.Point_Category_ID=C.PointCategoryID where B.AssetDetailsId="+chiller_asset_id;
	        ResultSet rs_2 = statement.executeQuery(queryString_2);
	        System.out.println("Query to get the Eligible points for the Chiller is Executed !!");
	        if(rs_2.wasNull()){
	        	logger.log(LogStatus.FAIL, "ResultSet is Not Generated ! Query Execution Faiuled !");
	        }
	        else{
	        	logger.log(LogStatus.PASS, "Query is executed to get the Eligible Chiller Point Category Data");
	        }
	        
	        FileInputStream fileIn_2 = new FileInputStream(project_dir+"\\PointAttributeDetails.xls");
	        HSSFWorkbook wb_2 = new HSSFWorkbook(fileIn_2);
	        HSSFSheet sheet_2 = wb_2.createSheet("Eligible Point Category");
	        wb_2.setSheetOrder("Eligible Point Category", 3);
	        HSSFRow rowhead_2 = sheet_2.createRow((short) 0);
	        rowhead_2.createCell((short) 0).setCellValue("Eligible_Point_Group");
	        int index_2 = 1;
	        while (rs_2.next()) {
	        	
	                HSSFRow row = sheet_2.createRow((short) index_2);
	                row.createCell((short) 0).setCellValue(rs_2.getString(1));
	                
	                index_2++;
	        }
	        FileOutputStream fileOut_2 = new FileOutputStream(project_dir+"\\PointAttributeDetails.xls");
	        wb_2.write(fileOut_2);//fileOut_2
	        fileOut_2.close();
	        wb_2.close();
	        System.out.println("Eligible Chiller Point Category Data is saved in excel file.");
	        logger.log(LogStatus.PASS, "Eligible Chiller Point Category Data is saved in excel file - Eligible Point Category");
	        rs_2.close();
	        
	        
		}
		
	}
	
	public boolean validatetPointGroupDatails(String point_category) throws BiffException, IOException {
		
		System.out.println("Inside validatetPointGroupDatails Method !");
		File inputWorkbook = new File(project_dir+"\\PointAttributeDetails.xls");
		//File file = new File(project_dir+"\\PointAttributeDetails.xls");
		//WorkbookSettings wbSettings = new WorkbookSettings();
		Workbook workbook = Workbook.getWorkbook(inputWorkbook);
		//wbSettings.setLocale(new Locale("en", "EN"));
	    //WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		Sheet points_sheet = workbook.getSheet(1);
		Sheet eligible_points_sheet = workbook.getSheet(3);
		String CellGetContent = null;
		String eligible_CellGetContent = null;
		boolean point_present_or_not = false;
		System.out.println("eligible_points_sheet.getRows() "+eligible_points_sheet.getRows());
		/*for (int i = 1; i < points_sheet.getRows(); i++) 
		{
			CellGetContent = points_sheet.getCell(0,i).getContents();*/
			for (int j = 1; j < eligible_points_sheet.getRows(); j++) 
			{
				System.out.println("j "+j);
				eligible_CellGetContent = eligible_points_sheet.getCell(0,j-1).getContents();
				System.out.println("eligible_CellGetContent "+eligible_CellGetContent);
				System.out.println("point_category "+point_category);
				if(eligible_CellGetContent.toLowerCase().equalsIgnoreCase(point_category))
				{
					//logger.log(LogStatus.PASS, point_category.toUpperCase()+" is a valid Eligible Point Category for the Respective Chiller");
					point_present_or_not = true;
					break;
					//workbook.createSheet("Final Point Category", 4);
					//GetChillerPointsFromUIDynamic(sheet_point_locator,sheet_row_num);
					//return true;
				}
				else if(point_present_or_not == false){
					//System.out.println(point_category);
					//logger.log(LogStatus.FAIL, point_category.toUpperCase()+" is NOT a valid Eligible Point Category for the Respective Chiller");
					point_present_or_not = false;
					
				}
			}
		//}
			
			return point_present_or_not;
		
	}
	
	//New Method -- Introduced on 27-03-2017
	public void validatePointCategoryDetaisForChillerModel() throws BiffException, IOException, SQLException {
		
		System.out.println("Inside validatePointCategoryDetaisForChillerModel Method !");
		
		File inputWorkbook = new File(project_dir+"\\TestData_CPO5.xls");
		Workbook workbook = Workbook.getWorkbook(inputWorkbook);
		Sheet points_sheet = workbook.getSheet(1);
		File inputWorkbook_att = new File(project_dir+"\\PointAttributeDetails.xls");
		Workbook workbook_att = Workbook.getWorkbook(inputWorkbook_att);
		Sheet points_sheet_att = workbook_att.getSheet(1);
		File inputWorkbook_att_elig = new File(project_dir+"\\PointAttributeDetails.xls");
		Workbook workbook_att_elig = Workbook.getWorkbook(inputWorkbook_att_elig);
		Sheet points_sheet_att_elig = workbook_att_elig.getSheet(3);
		
		String CellGetContent_lst,CellGetContent_name = null;
		
		for (int i = 1; i < points_sheet_att_elig.getRows(); i++)
		{
			String elig_cell_val = points_sheet_att_elig.getCell(0, i).getContents();
			System.out.println(elig_cell_val);
			System.out.println(i);
			//logger entry
			for (int j = 1; j < points_sheet_att_elig.getRows(); j++)
			{
				String valid_cell_val = points_sheet_att.getCell(0, j).getContents();
				System.out.println(valid_cell_val);
				if(elig_cell_val.equalsIgnoreCase(valid_cell_val)){
					System.out.println("Valid Match !");
					for (int k = 1; k < points_sheet_att_elig.getRows(); k++)
					{
						CellGetContent_lst = points_sheet.getCell(0,k).getContents();
						CellGetContent_name = points_sheet.getCell(1,k).getContents();
						//Logger entry
						if(valid_cell_val.equalsIgnoreCase(CellGetContent_name)){
							System.out.println("CellGetContent_lst "+CellGetContent_lst);
							GetChillerPointsFromUIDynamic(CellGetContent_lst,k);
						}
					}
				}
				else{
					System.out.println("CPO 5 !");
					for (int k = 1; k < points_sheet_att_elig.getRows(); k++)
					{
						CellGetContent_lst = points_sheet.getCell(0,k).getContents();
						CellGetContent_name = points_sheet.getCell(1,k).getContents();
						//Logger entry
						if(elig_cell_val.equalsIgnoreCase(CellGetContent_name)){
							System.out.println("CellGetContent_lst "+CellGetContent_lst);
							GetChillerPointsFromUIDynamic(CellGetContent_lst,k);
						}
					}
				}
			}
		}
			
		
	}
	
	
	public void validatePointsSubCategoryWithDB(String point_header,String point_sub_category) throws BiffException, IOException, SQLException{
		
		System.out.println("Inside validatePointsSubCategoryWithDB Method !");
		
		File inputWorkbook = new File(project_dir+"\\PointAttributeDetails.xls");
		Workbook workbook = Workbook.getWorkbook(inputWorkbook);
		Sheet points_sheet = workbook.getSheet(2);
		String chiller_asset_id = points_sheet.getCell(3,1).getContents();
		System.out.println(chiller_asset_id);
		Statement statement = conn.createStatement();
        String queryString = "select distinct (D.Point_Category_Name),F.Description from tblPoint A inner join tblNAEName B on A.NAEId = B.naeid inner join tblpointcategoryrelation C on C.pointid=A.pointId inner join tblpointcategory D on D.Point_Category_ID=C.PointCategoryID inner join tblselpoint E on E.pointid=A.pointid inner join tblassetattributes F on F.AssetAttributesId=E.AssetAttributesId where B.AssetDetailsId="+chiller_asset_id+" and Point_Category_Name= '"+point_header+"' and Description='"+point_sub_category.toUpperCase()+"'";
        ResultSet rs = statement.executeQuery(queryString);
        System.out.println("Query to get the Point Sub Category for the Point Header Category is Executed !!");
        logger.log(LogStatus.PASS, "Query to get the Point Sub Category for the Point Header Category is Executed !!");
        if(rs.wasNull()){
        	logger.log(LogStatus.FAIL, "The Selected Point SubCategory is not Valid");
        }
        else{
        	logger.log(LogStatus.PASS, "Point SubCategory : "+point_sub_category+" is a Valid SubCategory for Point Header : "+point_header);
        }
        
        workbook.close();
        rs.close();
	}
	
	public void CloseDBConnection() throws SQLException {
		System.out.println("Inside CloseDBConnection Method !");
		conn.close();
		System.out.println("DB Connection to CSD DB is closed !");
		logger.log(LogStatus.PASS, "DB Connection to CSD DB is closed !");
	}
	
	
//=========Test case methods--END ============
	
}





































