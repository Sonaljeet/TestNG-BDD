package mars.JCI.Project.MEMSCloud.Spaces;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;
import mars.JCI.Project.MEMS_Cloud.Spaces.MEMSCloud_Space_Add_Delete_Page_Action;
public class MEMSCloud_Space_Add_Delete_Page_Factory {
	


	       /** The Selenium Driver */
	       private WebDriver driver;
	       
	       /** The ExtentTest logger. */
	       private ExtentTest logger;
	       
	      // static String configFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	       public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
	       /**
	       * Instantiates a new MEMS CLOUD SPACE ADD EDIT DELETE page factory.
	       *
	       * @param driver the driver
	       */
	       
	       public MEMSCloud_Space_Add_Delete_Page_Factory(WebDriver driver, ExtentTest logger){
	             this.driver = driver;
	             this.logger = logger;
	             PageFactory.initElements(driver, this);
	       }
	       
	       /** All WebElements are identified by @FindBy annotation. */
	       /** The MEMS CLOUD Cardbasedmenuicon WebElement. */
	       @FindBy(css = ".glyphicon.glyphicon-th")
	       WebElement memsCloud_Cardbasedmenuicon;

	       /**
	       * Gets the cardbasedmenuicon.
	       *
	       * @return the cardbasedmenuicon
	       */
	       public WebElement getCardbasedmenuicon()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Cardbasedmenuicon,driver, logger)){
	                    return this.memsCloud_Cardbasedmenuicon;
	             }else{
	                    return null;
	             }
	       }      
	       

	       /** The MEMS CLOUD Setup WebElement. */	      
	       @FindBy(xpath = "//a[@href='/Configuration/Spaces']")
	       WebElement memsCloud_Setup;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getSetup()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Setup,driver, logger)){
	                    return this.memsCloud_Setup;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD Home WebElement. */	      
	       @FindBy(xpath = "//a[@href='#/Home']")
	       WebElement memsCloud_Home;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getHome()throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Home,driver, logger)){
                   return this.memsCloud_Home;
            }else{
                   return null;
            }
	    	   
	       }
	       
	       /** The MEMS CLOUD Create Location WebElement. */
	       //@FindBy(xpath = ".//*[@id='addnodeorgtree']")
	       @FindBy(xpath = "//button[@id='addnodeorgtree']/i")
	       WebElement memsCloud_CreateLocation;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getCreateLocation()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_CreateLocation,driver, logger)){
	                    return this.memsCloud_CreateLocation;
	             }else{
	                    return null;
	             }
	       }      
	       
	       /** The MEMS CLOUD Create facilityname WebElement. */
	       @FindBy(name = "facilityname")
	       WebElement memsCloud_facilityname;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getfacilityname()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_facilityname,driver, logger)){
	                    return this.memsCloud_facilityname;
	             }else{
	                    return null;
	             }
	       }     
	       
	       /** The MEMS CLOUD Maximize Map WebElement. */
	       @FindBy(xpath = "//div[contains(@ng-click, 'plc.resizeMap()')]/span/i")
	       WebElement memsCloud_reSizeMap;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getResizemap()throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_reSizeMap,driver,logger)){
                   return this.memsCloud_reSizeMap;
            }else{
                   return null;
            }
	       }

	       /** The MEMS CLOUD Create AddressLine1 WebElement. */
	       @FindBy(name = "AddressLine1")
	       WebElement memsCloud_AddressLine1;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getAddressLine1()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_AddressLine1,driver,logger)){
	                    return this.memsCloud_AddressLine1;
	             }else{
	                    return null;
	             }
	       }      
	       
	       /** The MEMS CLOUD Create AddressLine2 WebElement. */
	       @FindBy(name = "AddressLine2")
	       WebElement memsCloud_AddressLine2;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getAddressLine2()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_AddressLine2,driver, logger)){
	                    return this.memsCloud_AddressLine2;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD Create city WebElement. */
	       @FindBy(name = "city")
	       WebElement memsCloud_city;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getcity()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_city,driver, logger)){
	                    return this.memsCloud_city;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD Create country WebElement. */
	       @FindBy(name = "country")
	       WebElement memsCloud_country;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getcountry()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_country,driver, logger)){
	                    return this.memsCloud_country;
	             }else{
	                    return null;
	             }
	       }      
	       
	       /** The MEMS CLOUD Create postalcode WebElement. */
	       @FindBy(name = "postalcode")
	       WebElement memsCloud_postalcode;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getpostalcode()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_postalcode,driver, logger)){
	                    return this.memsCloud_postalcode;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD Create latitude WebElement. */
	       @FindBy(name = "latitude")
	       WebElement memsCloud_latitude;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getlatitude()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_latitude,driver, logger)){
	                    return this.memsCloud_latitude;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD Create longitude WebElement. */
	       @FindBy(name = "longitude")
	       WebElement memsCloud_longitude;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getlongitude()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_longitude,driver, logger)){
	                    return this.memsCloud_longitude;
	             }else{
	                    return null;
	             }
	       }      


	       /** The MEMS CLOUD Save button WebElement. */
	       @FindBy(css = ".btn.btn-primary.savebutton")
	       WebElement memsCloud_Save;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getSave()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Save,driver, logger)){
	                    return this.memsCloud_Save;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD Location WebElement. */
	       /*
	       @FindBy(xpath = ".//div[text()='Test_Auto_Location2']")
	       WebElement memsCloud_LocationisPresent;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       /*
	       public WebElement getLocationisPresent(){
	             if(commonFunctions.WebElementCommon.waitForElementPresent(driver, memsCloud_LocationisPresent, logger)){
	                    return this.memsCloud_LocationisPresent;
	             }else{
	                    return null;
	             }
	       }
	*/
	       
	       /** The MEMS CLOUD delete Location WebElement. */
	       @FindBy(xpath = ".//*[@id='deletenodeorgtree']/i")
	       WebElement memsCloud_deleteLocation;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getdeleteLocation()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_deleteLocation,driver, logger)){
	                    return this.memsCloud_deleteLocation;
	             }else{
	                    return null;
	             }
	       }
	       
	       /** The MEMS CLOUD delete Location confirmation WebElement. */
	       @FindBy(xpath = ".//button[text()='Yes']")
	       WebElement memsCloud_deleteconfirmation;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getdeleteConfirmation()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_deleteconfirmation,driver, logger)){
	                    return this.memsCloud_deleteconfirmation;
	             }else{
	                    return null;
	             }
	       }
	       
	       
	       /** The MEMS CLOUD Create BuildingName WebElement. */
	       @FindBy(name = "buildingname")
	       WebElement memsCloud_BuildingName;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getBuildingName()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_BuildingName,driver, logger)){
	                    return this.memsCloud_BuildingName;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD "Gross floor area" WebElement. */
	       @FindBy(name = "buildingarea")
	       WebElement memsCloud_GrossFloorArea;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement get_GrossFloorArea()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_GrossFloorArea,driver, logger)){
	                    return this.memsCloud_GrossFloorArea;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD "Number of occupants" WebElement. */
	       @FindBy(name = "noOfOccupant")
	       WebElement memsCloud_Numberofoccupants;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement get_Numberofoccupants()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Numberofoccupants,driver, logger)){
	                    return this.memsCloud_Numberofoccupants;
	             }else{
	                    return null;
	             }
	       }      

	       /** The MEMS CLOUD "Save" WebElement. */
	       @FindBy(xpath = ".//button[text()='Save'][contains(@ng-disabled,'Buildingform')]")
	       WebElement memsCloud_SaveBuilding;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement get_SaveBuilding()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_SaveBuilding,driver, logger)){
	                    return this.memsCloud_SaveBuilding;
	             }else{
	                    return null;
	             }
	       }      
	       
	       /** The MEMS CLOUD "Expand tree" WebElement. */
	       /*
	       @FindBy(xpath = ".//div[text()='Test_Auto_Location19']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span")
	       WebElement memsCloud_ExpandTree;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       /*
	       public WebElement get_ExpandTree(){
	             if(commonFunctions.WebElementCommon.waitForElementPresent(driver, memsCloud_ExpandTree, logger)){
	                    return this.memsCloud_ExpandTree;
	             }else{
	                    return null;
	             }
	       }    
	       */
	       /** The MEMS CLOUD "Expand tree" WebElement. */
	       public List<WebElement> memsCloud_ExpandTree = null;
	       public List<WebElement> getExpandTree() throws Exception
	       {   
	    	   MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();    	   
	    	   Thread.sleep(2000);	  
	    	   String s = "//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Location")+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span";
	    	   // -- String s = "//div[text()='Location']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span";	    	   
	    	   System.out.println(s);
	    	   memsCloud_ExpandTree = driver.findElements(By.xpath(s));	    	   
	    	   return memsCloud_ExpandTree;
	       }     
	       
	       
	       
	       /** The MEMS CLOUD "Expand Building Tree" WebElement. */
	       /*
	       @FindBy(xpath = "//div[text()='Tulip Building']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span")
	       WebElement memsCloud_ExpandBuildingTree;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       /*
	       public WebElement get_ExpandBuildingTree(){
	             if(commonFunctions.WebElementCommon.waitForElementPresent(driver, memsCloud_ExpandBuildingTree, logger)){
	                    return this.memsCloud_ExpandBuildingTree;
	             }else{
	                    return null;
	             }
	       }   
	       */
	       
	       /** The MEMS CLOUD "Expand Building Tree" WebElement. */
	       public List<WebElement> memsCloud_ExpandBuildingTree = null;
	       public List<WebElement> getExpandBuildingTree() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   memsCloud_ExpandBuildingTree = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Building")+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	   // -- memsCloud_ExpandBuildingTree = driver.findElements(By.xpath("//div[text()='Building']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	   return memsCloud_ExpandBuildingTree;
	       }	    
	       
	       public List<WebElement> memsCloud_ExpandFloorTree = null;
	       public List<WebElement> getExpandFloorTree(){
	    	 memsCloud_ExpandBuildingTree = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Floor")+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	   //memsCloud_ExpandBuildingTree = driver.findElements(By.xpath("//div[text()='DYJIUT']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	   return memsCloud_ExpandBuildingTree;
	       }
	       
	       public List<WebElement> memsCloud_ExpandWingTree = null;
	       public List<WebElement> getExpandWingTree(){
	    	 // System.out.println("xpath : //div[text()='"+MEMSCloud_Space_Add_Delete_Page_Action.Floorname+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle selected']//a//span");
	    	  //System.out.println(MEMSCloud_Space_Add_Delete_Page_Action.Floorname);	    	  
	    	  memsCloud_ExpandWingTree = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Floor")+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	  //memsCloud_ExpandWingTree = driver.findElements(By.xpath("//div[text()='Floor']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	  
	    	   return memsCloud_ExpandWingTree;
	       }
	       
	       public List<WebElement> memsCloud_ExpandRoomTree = null;
	       public List<WebElement> getExpandRoomTree(){
	    	   	//System.out.println("xpath floor : //div[text()='"+MEMSCloud_Space_Add_Delete_Page_Action.Wingname+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span");
	    	   	//System.out.println(MEMSCloud_Space_Add_Delete_Page_Action.Wingname);	    	   
	    	    //memsCloud_ExpandRoomTree = driver.findElements(By.xpath("//div[text()='"+MEMSCloud_Space_Add_Delete_Page_Action.Wingname+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	   	  memsCloud_ExpandRoomTree = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Wing")+"']//ancestor::div[@class='space-tree-node ng-scope angular-ui-tree-handle']//a//span"));
	    	   return memsCloud_ExpandRoomTree;
	       }
	       
	       
	       
	       /** The MEMS CLOUD FloorName WebElement. */
	       @FindBy(name = "floorname")
	       WebElement memsCloud_FloorName;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getFloorName()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_FloorName,driver, logger)){
	                    return this.memsCloud_FloorName;
	             }else{
	                    return null;
	             }
	       }      
	       
	       /** The MEMS CLOUD floorarea WebElement. */
	       @FindBy(name = "floorarea")
	       WebElement memsCloud_floorarea;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getFloorArea()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_floorarea,driver, logger)){
	                    return this.memsCloud_floorarea;
	             }else{
	                    return null;
	             }
	       }      
	       
	       /** The MEMS CLOUD floortag WebElement. */
	       @FindBy(name = "floortag")
	       WebElement memsCloud_floortag;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getFloorTag()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_floortag,driver, logger)){
	                    return this.memsCloud_floortag;
	             }else{
	                    return null;
	             }
	       }      
	       
	       /** The MEMS CLOUD floortype WebElement. */
	       @FindBy(name = "type")
	       WebElement memsCloud_floortype;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getFloorType()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_floortype,driver, logger)){
	                    return this.memsCloud_floortype;
	             }else{
	                    return null;
	             }
	       }      
	       
	       
	       /** The MEMS CLOUD Save floor WebElement. */
	       //@FindBy(xpath = "//button[text()='Save']")
	       @FindBy(xpath = "//form[@name='floorform']//button[text()='Save'][@value='Save']")
	     //form[@name='floorform']//button[text()='Save'][@value='Save']
	       WebElement memsCloud_savefloor;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       public WebElement getsavefloor()throws Exception{
	             if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_savefloor,driver, logger)){
	                    return this.memsCloud_savefloor;
	             }else{
	                    return null;
	             }
	       }      
	         
	       /** The MEMS CLOUD Wing WebElement. */
	       @FindBy(name = "wingname")
	       WebElement memsCloud_wingName;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       
	       public WebElement getWingName() throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_wingName,driver, logger)){
                   return this.memsCloud_wingName;
            }else{
                   return null;
            }
				
			}
	       
	       /** The MEMS CLOUD Room WebElement. */
	       @FindBy(name = "roomname")
	       WebElement memsCloud_RoomName;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       
	       public WebElement getRoomName() throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_RoomName,driver, logger)){
                   return this.memsCloud_RoomName;
            }else{
                   return null;
            }
				
			}
	       
	       /** The MEMS CLOUD Room Area WebElement. */
	       @FindBy(name = "roomarea")
	       WebElement memsCloud_RoomArea;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       
	       public WebElement getRoomArea() throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_RoomArea,driver, logger)){
                   return this.memsCloud_RoomArea;
            }else{
                   return null;
            }
				
			}
	       
	       
	       /** The MEMS CLOUD Save Room WebElement. */
	       @FindBy(xpath = "//button[text()='Save'][contains(@ng-disabled, '!roomform.$valid')]" )
	       WebElement memsCloud_SaveRoom;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       
	       public WebElement getSaveRoom() throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_SaveRoom,driver, logger)){
                   return this.memsCloud_SaveRoom;
            }else{
                   return null;
            }
				
			}
	       
	       /** The MEMS CLOUD Save floor WebElement. */
	       @FindBy(name = "wingarea")
	       WebElement memsCloud_wingarea;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       
	       public WebElement getWingarea() throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_wingarea,driver, logger)){
                   return this.memsCloud_wingarea;
            }else{
                   return null;
            }
				
			}
	       
	       /** The MEMS CLOUD Save Wing WebElement. */
	       @FindBy(xpath = "//button[text()='Save'][contains(@ng-disabled,'!wingform.$valid')]")
	       WebElement memsCloud_savewing;

	       /**
	       * Gets the Setup.
	       *
	       * @return the Setup
	       */
	       
	       public WebElement getsaveWing() throws Exception{
	    	   if(commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_savewing,driver, logger)){
                   return this.memsCloud_savewing;
            }else{
                   return null;
            }
			}
	       
	       public List<WebElement> memsCloud_LocationisPresentOnMap = null;
	       public List<WebElement> getLocationisPresentOnMap() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   memsCloud_LocationisPresentOnMap = driver.findElements(By.xpath("//div[@title='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Location")+"']/img"));             
	    	   return memsCloud_LocationisPresentOnMap;
	       }
	       
	       
	       public List<WebElement> memsCloud_LocationisPresent = null;
	       public List<WebElement> getLocationisPresent() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   memsCloud_LocationisPresent = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Location")+"']"));             
	    	   return memsCloud_LocationisPresent;
	       }	 
	    
	       public List<WebElement> memsCloud_BuildingisPresent = null;
	       public List<WebElement> getBuildingisPresent() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   memsCloud_BuildingisPresent =driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Building")+"']"));    
	    	   //memsCloud_BuildingisPresent =driver.findElements(By.xpath("//div[text()='GZNZJM']"));
	    	   return memsCloud_BuildingisPresent;
	       } 
	    
	       public List<WebElement> memsCloud_FloorisPresent = null;
	       public List<WebElement> getFloorisPresent() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   memsCloud_FloorisPresent = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Floor")+"']"));
	    	 //--memsCloud_FloorisPresent = driver.findElements(By.xpath("//div[text()='Floor']"));
	    	  // System.out.println("memsCloud_FloorisPresent "+memsCloud_FloorisPresent);
	    	   return memsCloud_FloorisPresent;
	       }
		public List<WebElement> getWingisPresent() throws InterruptedException {
			Thread.sleep(2000);
	    	  memsCloud_BuildingisPresent =driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Wing")+"']"));
			   //memsCloud_BuildingisPresent =driver.findElements(By.xpath("//div[text()='Wing']"));
	    	   return memsCloud_BuildingisPresent;
		}
		
		public List<WebElement> memsCloud_RoomisPresent = null;
		public List<WebElement> getRoomisPresent() throws InterruptedException {
			Thread.sleep(5000);
			//System.out.println("Roomname : " + MEMSCloud_Space_Add_Delete_Page_Action.Roomname);
			//List<WebElement> xPath = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Room")+"']"));
			//System.out.println("Xpath : " + xPath);
			memsCloud_RoomisPresent = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Room")+"']"));	    	  
			//memsCloud_RoomisPresent = xPath;
			return memsCloud_RoomisPresent;
		}
		
		
		
		public List<WebElement> memsCloud_PortFolioChkBox = null;
	       public List<WebElement> getPortFolioChkBox() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   //memsCloud_PortFolioChkBox = driver.findElements(By.xpath("//div[text()='"+MEMSCloud_Space_Add_Delete_Page_Action.Floorname+"']"));	    	   
	    	   memsCloud_PortFolioChkBox = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization")+"']//ancestor::div[@class='space-tree-node roles-space-tree-users ng-scope angular-ui-tree-handle']//i[@class='fa fa-1x fa-icon-size-roles fa-square-o']"));
	    	   //System.out.println("memsCloud_PortFolioChkBox "+memsCloud_PortFolioChkBox);
	    	   return memsCloud_PortFolioChkBox;
	       }
		
	       public List<WebElement> memsCloud_PortFolioChkBox_Checked = null;
	       public List<WebElement> getPortFolioChkBox_Checked() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   //memsCloud_PortFolioChkBox = driver.findElements(By.xpath("//div[text()='"+MEMSCloud_Space_Add_Delete_Page_Action.Floorname+"']"));	    	   
	    	   memsCloud_PortFolioChkBox_Checked = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization")+"']//ancestor::div[@class='space-tree-node roles-space-tree-users ng-scope angular-ui-tree-handle']//i[@class='fa fa-1x fa-icon-size-roles fa-check-square-o']"));
	    	   //System.out.println("memsCloud_PortFolioChkBox_Checked "+memsCloud_PortFolioChkBox_Checked);
	    	   return memsCloud_PortFolioChkBox_Checked;
	       }
	       
	       public List<WebElement> portfolioInSpaceTree = null;
	       public List<WebElement> getPortfolioInSpaceTree() throws InterruptedException
	       {
	    	   Thread.sleep(2000);
	    	   //memsCloud_PortFolioChkBox = driver.findElements(By.xpath("//div[text()='"+MEMSCloud_Space_Add_Delete_Page_Action.Floorname+"']"));	    	   
	    	   portfolioInSpaceTree = driver.findElements(By.xpath("//div[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization")+"']"));
	    	  // System.out.println("memsCloud_PortFolioChkBox_Checked "+memsCloud_PortFolioChkBox_Checked);
	    	   return portfolioInSpaceTree;
	       }
	       
		
	/** The MEMS CLOUD Users Module WebElement. */
	@FindBy(xpath = "//a[@id='User']")
	WebElement memsCloud_Users;

	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */

	public WebElement getUsers() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Users,driver, logger)) {
			return this.memsCloud_Users;
		} else {
			return null;
		}

	}

	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(xpath = "//a[contains(text(),'Create role')]")
	WebElement memsCloud_CreateRole;

	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */

	public WebElement getCreateRole() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_CreateRole,driver, logger)) {
			return this.memsCloud_CreateRole;
		} else {
			return null;
		}

	}

	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(name = "RoleName")
	WebElement memsCloud_RoleName;

	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */

	public WebElement getRoleName() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_RoleName,driver, logger)) {
			return this.memsCloud_RoleName;
		} else {
			return null;
		}

	}

	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(name = "Description")
	WebElement memsCloud_Description;

	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */

	public WebElement getDescription() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Description,driver, logger)) {
			return this.memsCloud_Description;
		} else {
			return null;
		}

	}

	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(xpath = "//button[text()='Clear']")
	WebElement memsCloud_Clear;

	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */

	public WebElement getClear() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Clear,driver, logger)) {
			return this.memsCloud_Clear;
		} else {
			return null;
		}

	}

	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(xpath = "//button[text()='Add']")
	WebElement memsCloud_AddRole;

	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */
	public WebElement getAddRole() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_AddRole,driver, logger)) {
			return this.memsCloud_AddRole;
		} else {
			return null;
		}

	}

	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(xpath = "//div/input[@placeholder='Search role']")	                 
	WebElement memsCloud_SearchAddedRole;
	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */
	public WebElement getSearchAddedRole() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_SearchAddedRole,driver, logger)) {
			return this.memsCloud_SearchAddedRole;
		} else {
			return null;
		}
	}
	
	public List<WebElement> memsCloud_getRole = null;
	public List<WebElement> getRole() throws InterruptedException {
		Thread.sleep(2000);
		//System.out.println("Role name : " + MEMSCloud_Space_Add_Delete_Page_Action.RoleName);
		List<WebElement> xPath = driver.findElements(By.xpath("//span[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Role")+"']"));
		System.out.println("Xpath : " + xPath);
		memsCloud_getRole = driver.findElements(By.xpath("//span[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Role")+"']"));	    	  
		memsCloud_getRole = xPath;
		return memsCloud_getRole;
	}
	
	public List<WebElement> memsCloud_getUpdatedRole = null;
	public List<WebElement> getUpdatedRole() throws InterruptedException {
		Thread.sleep(2000);
		//System.out.println("Updated Role Name : " + MEMSCloud_Space_Add_Delete_Page_Action.UpdateRoleName);
		List<WebElement> xPath = driver.findElements(By.xpath("//span[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Role")+"']"));
		System.out.println("Xpath : " + xPath);
		memsCloud_getUpdatedRole = driver.findElements(By.xpath("//span[text()='"+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Role")+"']"));	    	  
		memsCloud_getUpdatedRole = xPath;
		return memsCloud_getUpdatedRole;
	}
	
	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(xpath = "//button[text()='Update']")	                 
	WebElement memsCloud_UpdateRole;
	/**
	 * Gets the Setup.
	 *
	 * @return the Setup
	 */
	public WebElement getUpdateRole() throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_UpdateRole,driver , logger)) {
			return this.memsCloud_UpdateRole;
		} else {
			return null;
		}
	}
	
	/** The MEMS CLOUD Create Role Module WebElement. */
	@FindBy(xpath = "//a[contains(text(),'User list')]")
	WebElement memsCloud_UserList;
	/**
	 * Gets the Setup.
	 * @return 
	 *
	 * @return the Setup
	 */
	
	public WebElement getUserListTab()throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_UserList,driver, logger)) {
			return this.memsCloud_UserList;
		} else {
			return null;
		}
	}

	@FindBy(xpath = "//select[contains(@ng-model,'rrc.role')]")
	//@FindBy(xpath = "//select[contains(@ng-model,'rrc.role')]")
	WebElement memsCloud_UserRole;
	/**
	 * Gets the UserRole.
	 * @return 
	 *
	 * @return the UserRole
	 */
	
	public WebElement getUserRole()throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_UserRole,driver, logger)) {
			return this.memsCloud_UserRole;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//button[@data-target='#confirmDelete']")
	WebElement memsCloud_DeteleUserName;
	/**
	 * Gets the UserRole.
	 * @return 
	 *
	 * @return the UserRole
	 */
	
	public WebElement getDeteleUserName()throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_DeteleUserName,driver, logger)) {
			return this.memsCloud_DeteleUserName;
		} else {
			return null;
		}
	}
	
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement memsCloud_Conformation;
	/**
	 * Gets the delete Conformation.
	 * @return 
	 *
	 * @return the delete Conformation
	 */
	
	public WebElement getConformation()throws Exception{
		if (commonFunctions.WebElementCommon.waitForElementPresent(memsCloud_Conformation,driver, logger)) {
			return this.memsCloud_Conformation;
		} else {
			return null;
		}
	}
	
	
	public List<WebElement> username_inuserlistgrid = null;

	public List<WebElement> checkuserpresent() throws InterruptedException {
		Thread.sleep(2000);
		//System.out.println("username : " + ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..AdminUser"));
		//System.out.println("xpath : " + "//span[text()='" + MEMSCloud_Space_Add_Delete_Page_Action.username + "']");
		username_inuserlistgrid = driver
				.findElements(By.xpath("//span[text()='" + ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..AdminUser") + "']"));
		return username_inuserlistgrid;
	}
	
	
	      
    @FindBy(name = "btnDefaulUnits")
    WebElement SelectUnits_Btn;

    public WebElement getSelectUnits_Btn()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(SelectUnits_Btn,driver, logger)){
                 return this.SelectUnits_Btn;
          }else{
                 return null;
          }
    }      
	
    @FindBy(name = "areaunit")
    WebElement AreaUnitDropDown;

    public WebElement getAreaUnitDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(AreaUnitDropDown,driver, logger)){
                 return this.AreaUnitDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "consumptionDefault")
    WebElement ElectricityDropDown;

    public WebElement getElectricityDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(ElectricityDropDown,driver, logger)){
                 return this.ElectricityDropDown;
          }else{
                 return null;
          }
    }
    
    @FindBy(name = "demandDefault")
    WebElement ElectricityDemandDropDown;

    public WebElement getElectricityDemandDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(ElectricityDemandDropDown,driver, logger)){
                 return this.ElectricityDemandDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "waterDefault")
    WebElement WaterDropDown;

    public WebElement getWaterDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(WaterDropDown,driver, logger)){
                 return this.WaterDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "hotWaterDefault")
    WebElement HotWaterDropDown;

    public WebElement getHotWaterDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(HotWaterDropDown,driver, logger)){
                 return this.HotWaterDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "chilledWaterDefault")
    WebElement ChilledWaterDropDown;

    public WebElement getChilledWaterDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(ChilledWaterDropDown,driver, logger)){
                 return this.ChilledWaterDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "gasDefault")
    WebElement GasDropDown;

    public WebElement getGasDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(GasDropDown,driver, logger)){
                 return this.GasDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "steamDefault")
    WebElement SteamDropDown;

    public WebElement getSteamDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(SteamDropDown,driver, logger)){
                 return this.SteamDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "fuelOilDefault")
    WebElement FuelOilDropDown;

    public WebElement getFuelOilDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(FuelOilDropDown,driver, logger)){
                 return this.FuelOilDropDown;
          }else{
                 return null;
          }
    }  
    
    
    @FindBy(name = "propaneDefault")
    WebElement PropaneDropDown;

    public WebElement getPropaneDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(PropaneDropDown,driver, logger)){
                 return this.PropaneDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "dieselDefault")
    WebElement DieselDropDown;

    public WebElement getDieselDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(DieselDropDown,driver, logger)){
                 return this.DieselDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "sewageDefault")
    WebElement SewageDropDown;

    public WebElement getSewageDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(SewageDropDown,driver, logger)){
                 return this.SewageDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "CoalDefault")
    WebElement CoalDropDown;

    public WebElement getCoalDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(CoalDropDown,driver,logger)){
                 return this.CoalDropDown;
          }else{
                 return null;
          }
    }  
    
    
    @FindBy(name = "Emission")
    WebElement EmissionTextBox;

    public WebElement getEmissionTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(EmissionTextBox,driver,logger)){
                 return this.EmissionTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "currency")
    WebElement CurrencyDropDown;

    public WebElement getCurrencyDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(CurrencyDropDown,driver, logger)){
                 return this.CurrencyDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "ElConsumption")
    WebElement ElectricityValueTextBox;

    public WebElement getElectricityValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(ElectricityValueTextBox,driver, logger)){
                 return this.ElectricityValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "ElDemand")
    WebElement ElectricalDemandValueTextBox;

    public WebElement getElectricalDemandValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(ElectricalDemandValueTextBox,driver, logger)){
                 return this.ElectricalDemandValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "Water")
    WebElement WaterValueTextBox;

    public WebElement getWaterValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(WaterValueTextBox,driver, logger)){
                 return this.WaterValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "HotWater")
    WebElement HotWaterValueTextBox;

    public WebElement getHotWaterValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(HotWaterValueTextBox,driver, logger)){
                 return this.HotWaterValueTextBox;
          }else{
                 return null;
          }
    }  
    
    
    @FindBy(name = "ChilledWater")
    WebElement ChilledWaterValueTextBox;

    public WebElement getChilledWaterValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(ChilledWaterValueTextBox,driver, logger)){
                 return this.ChilledWaterValueTextBox;
          }else{
                 return null;
          }
    }  
    
    
    @FindBy(name = "Gas")
    WebElement GasValueTextBox;

    public WebElement getGasValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(GasValueTextBox,driver, logger)){
                 return this.GasValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "Steam")
    WebElement SteamValueTextBox;

    public WebElement getSteamValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(SteamValueTextBox,driver, logger)){
                 return this.SteamValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "FuelOil")
    WebElement FuelOilValueTextBox;

    public WebElement getFuelOilValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(FuelOilValueTextBox,driver, logger)){
                 return this.FuelOilValueTextBox;
          }else{
                 return null;
          }
    }
    
    @FindBy(name = "Propane")
    WebElement PropaneValueTextBox;

    public WebElement getPropaneValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(PropaneValueTextBox,driver, logger)){
                 return this.PropaneValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "Diesel")
    WebElement DieselValueTextBox;

    public WebElement getDieselValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(DieselValueTextBox,driver, logger)){
                 return this.DieselValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "Sewage")
    WebElement SewageValueTextBox;

    public WebElement getSewageValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(SewageValueTextBox,driver, logger)){
                 return this.SewageValueTextBox;
          }else{
                 return null;
          }
    }  
    
    
    @FindBy(name = "Coal")
    WebElement CoalValueTextBox;

    public WebElement getCoalValueTextBox()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(CoalValueTextBox,driver, logger)){
                 return this.CoalValueTextBox;
          }else{
                 return null;
          }
    }  
    
    @FindBy(name = "TemperatureDefault")
    WebElement TemparatureDropDown;

    public WebElement getTemparatureDropDown()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(TemparatureDropDown,driver, logger)){
                 return this.TemparatureDropDown;
          }else{
                 return null;
          }
    }  
    
    @FindBy(xpath= "(//button[contains(text(),'Submit')])[1]")
    WebElement Submit_Btn;

    public WebElement getSubmit_Btn()throws Exception{
          if(commonFunctions.WebElementCommon.waitForElementPresent(Submit_Btn,driver, logger)){
                 return this.Submit_Btn;
          }else{
                 return null;
          }
    }  
    	
}
