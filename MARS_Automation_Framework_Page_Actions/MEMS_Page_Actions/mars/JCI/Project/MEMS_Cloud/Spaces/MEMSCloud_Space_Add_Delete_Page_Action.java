package mars.JCI.Project.MEMS_Cloud.Spaces;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Business.Layer.ReadJsonFile;
import mars.Business.Layer.ReadPropertyFile;
import mars.Business.Layer.WriteJsonFile;
import mars.Component.Functions.BaseClass;
import mars.JCI.Project.MEMSCloud.MeterConfiguration.MEMSCloud_MeterConfiguration_Page_Factory;
import mars.JCI.Project.MEMSCloud.Spaces.MEMSCloud_Space_Add_Delete_Page_Factory;
import mars.JCI.Project.MEMSCloud.Users.MEMSCloud_Users_Page_Factory;
import mars.JCI.Project.MEMS_Cloud.Orgnization.MEMSCloud_Orgnization_Action;
import mars.JCI.Project.MEMS_Cloud.Users.MEMSCloud_Users_Action;

public class MEMSCloud_Space_Add_Delete_Page_Action {
      

	/** The driver. */
       private static WebDriver driver;

       /** The logger. */
       private static ExtentTest logger;
       private WebElement element;
       public static MEMSCloud_Orgnization_Action orgnizaton_action_obj;

	   MEMSCloud_Users_Action orgobject=null;
       //public static List<String> Spaces_datalist = new ArrayList<String>();
     //  public static String Location_name="",Buildingname="",Floorname="",Wingname="",Roomname="", RoleName="", UpdateRoleName="";
       public String BuildNameNew = null;
       private static MEMSCloud_Space_Add_Delete_Page_Factory space_Add_Delete = null;
       public static List<String> User_Details = new ArrayList<String>();
       public static List<String> SelectUnitsdatalist_data = new ArrayList<String>();
       //public static String username;
      // static String configFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
       //static String configFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/TestResources/FunctionalTest/TestData.json";
       public String configFile=BaseClass.TruncatePath+"/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
       public MEMSCloud_Space_Add_Delete_Page_Action(WebDriver driver, ExtentTest logger) {
             this.driver = driver;
             this.logger = logger;
             space_Add_Delete = new MEMSCloud_Space_Add_Delete_Page_Factory(driver, logger);
             orgnizaton_action_obj=new MEMSCloud_Orgnization_Action(driver, logger);  
             orgobject=new MEMSCloud_Users_Action(driver,logger);
             SelectUnitsdatalist_data = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..SelectUnits.*");
       }
       /**
       * Click CardBaseMenu iCon.
       *
       * @param CardBaseMenu
     * @throws InterruptedException 
       * 
        */

       public void clickOnCardBaseMenu() throws Exception {
             element = space_Add_Delete.getCardbasedmenuicon();
             if (element != null && element.isEnabled()) {
            	    Thread.sleep(1200);
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    element.click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    logger.log(LogStatus.PASS, "Clicked successfully on CardBaseMenu iCon.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for CardBaseMenu is Failed");
                    throw new Exception("Element not found");
             }
       }

       /**
       * Click CardBaseMenu iCon.
       *
       * @param CardBaseMenu
     * @throws Exception 
       * 
        */

       public void navigateSetupPage() throws Exception {
             element = space_Add_Delete.getSetup();
             if (element != null) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    element.click();
                    Thread.sleep(500);
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();                    
                    logger.log(LogStatus.PASS, "Navigate successfully on Setup Page.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Setup is Failed.");
                    throw new Exception("Element not found");
             }
       }

       public void gotoHomePage() throws Exception {		
    	   element = space_Add_Delete.getHome();
           if (element != null) {
          	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  element.click();
                  Thread.sleep(1200);
                  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();                    
                  logger.log(LogStatus.PASS, "Navigate successfully on Home Page.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for Home is Failed.");
                  throw new Exception("Element not found");
           }
   	}

       
       public void clickOncreateLocationiCon() throws Exception {
             element = space_Add_Delete.getCreateLocation();
             if (element != null) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    element.click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    Thread.sleep(1000);
                    logger.log(LogStatus.PASS, "Clicked successfully on createLocationiCon iCon.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for createLocationiCon is Failed.");
                    throw new Exception("Element not found");
             }
       }

       public void saveLocation() throws Exception {
   		// Save Location
   		 element = space_Add_Delete.getSave();
            if (element != null) {
                   element.click();                    
                   logger.log(LogStatus.PASS, "Clicked successfully on Save button.");
            } else {
                   logger.log(LogStatus.FAIL, "Identifying WebElement for Save is Failed.");
                   throw new Exception("Element not found");
            }		
   	}

   	public void enterLongitude(String Longitude) throws Exception {
   		  // Enter Longitude
           element = space_Add_Delete.getlongitude();
           if (element != null) {
                  element.clear();
                  element.sendKeys(Longitude);                    
                  logger.log(LogStatus.PASS, Longitude + " Longitude Entered succesfully to Longitude text box.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for Longitude is Failed.");
                  throw new Exception("Element not found");
           }
   		
   	}

   	public void enterLatitude(String Latitude) throws Exception {
   		 element = space_Add_Delete.getlatitude();
            if (element != null) {
                   element.clear();
                   element.sendKeys(Latitude);                    
                   logger.log(LogStatus.PASS, Latitude + " Latitude Entered succesfully to Latitude text box.");
            } else {
                   logger.log(LogStatus.FAIL, "Identifying WebElement for Latitude is Failed.");
                   throw new Exception("Element not found");
            }
   		
   	}

   	public void enterZipcode(String Zipcode) throws Exception{
           // Enter Postal Code
           element = space_Add_Delete.getpostalcode();
           if (element != null) {
                  element.clear();
                  element.sendKeys(Zipcode);                    
                  logger.log(LogStatus.PASS, Zipcode + " Postalcode Entered succesfully to Postalcode text box.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for PostalCode is Failed.");
           }
   		
   	}

   	public void selectCountry(String Country) throws Exception{
           // Select Country
           element = space_Add_Delete.getcountry();
           if (element != null) {             	 	
        	   MEMSCloud_Orgnization_Action.selectByVisibleText(element, Country,logger);                    
                  logger.log(LogStatus.PASS, Country + " selected in Country drop down succesfully.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for PostalCode is Failed.");
           }
   		
   	}

   	public void enterCity(String City) throws Exception {
           // Enter City
           element = space_Add_Delete.getcity();
           if (element != null) {
                  element.clear();
                  element.sendKeys(City);                    
                  logger.log(LogStatus.PASS, City + " City Entered succesfully to City text box.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for City is Failed.");
           }		
   	}

   	public void enterAddressLine2(String Address_line_2) throws Exception {
           // Enter Address Line 2
           element = space_Add_Delete.getAddressLine2();
           if (element != null) {
                  element.clear();
                  element.sendKeys(Address_line_2);                    
                  logger.log(LogStatus.PASS, Address_line_2 + " Address2 Entered succesfully to Address2 text box.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for AddressLine2 is Failed.");
           }		
   	}

   	public void enterAddressLine1(String Address_line_1) throws Exception{
   		element = space_Add_Delete.getAddressLine1();
   		if (element != null) {
   			element.clear();
   			element.sendKeys(Address_line_1);
   			logger.log(LogStatus.PASS, Address_line_1 + " Address1 Entered succesfully to Address1 text box.");
   		} else {
   			logger.log(LogStatus.FAIL, "Identifying WebElement for AddressLine1 is Failed.");
   		}
   	}

   	public void enterLocationname(String Location_name) throws Exception{
       	   element = space_Add_Delete.getfacilityname();
              if (element != null) {
                     element.clear();
                     element.sendKeys(Location_name);                  
                     logger.log(LogStatus.PASS, Location_name +" Location Entered succesfully to Location text box.");
              } else {
                     logger.log(LogStatus.FAIL, "Identifying WebElement for facilityname is Failed.");
              }		
   	}


       // Check is Location created
       public void isLocationCreated() throws Exception {           
             List<WebElement> elements = null;
             elements = space_Add_Delete.getLocationisPresent();
             if (elements.size() > 0) {    
            	 	elements.get(0).click();
                    logger.log(LogStatus.PASS, "Location created successfully.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Location is Failed.");
             }
       }
       
       //ReSize Map       
       public void reSizeMap() throws Exception {		
    	   element = space_Add_Delete.getResizemap();
           if (element != null) {
        	      MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  element.click(); 
                  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  logger.log(LogStatus.PASS, "Map maximize succesfully.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for Map resize is Failed.");
           }		
   		}

       // Check Location present on Map
       public void checkCreatedLocationonMap(String Location) throws Exception{    	   
    	   List<WebElement> elements = null;
           elements = space_Add_Delete.getLocationisPresentOnMap();
           if (elements.size() > 0) {        	     
        	      MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        	      Thread.sleep(1200);
          	 	  elements.get(0).click();
          	 	  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  logger.log(LogStatus.PASS, "Location:= "+Location+" created successfully and is present on Landing Page.");
           } else {
                  logger.log(LogStatus.FAIL, "Location:= "+Location+" is not  present on Landing Page.");
                  throw new Exception("Element not found");
           }
       }
       
       // Check Location deleted on Map
       
       public void checkDeletedLocationonMap(String Location) throws Exception{    	   
    	   List<WebElement> elements = null;
           elements = space_Add_Delete.getLocationisPresentOnMap();
           if (elements.size() > 0) {        	     
        	      MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();  
        	      elements.get(0).click();
                  logger.log(LogStatus.FAIL, "Location:= "+Location+ " is not deleted from Landing Page.");
                  throw new Exception("Element not found");
           } else {
        	   MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();       	 	   
               logger.log(LogStatus.PASS, "Location:= "+Location+ " deleted from Landing Page.");
           }
       }
       
       
       public void isLocationPresent() throws Exception {            
             List<WebElement> elements = null;
             elements = space_Add_Delete.getLocationisPresent();
             System.out.println("Location : " + elements.get(0) + "element Size : " + elements.size());
             if (elements.size() > 0) {            	 	
                    logger.log(LogStatus.PASS, "Created Location is present on navigation tree.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Location is Failed.");
                    throw new Exception("Element not found");
             }
       }

       public void delete_SelectedLocation() throws Exception {             
             List<WebElement> elements = null;
             elements = space_Add_Delete.getLocationisPresent();
             System.out.println("Location : " + elements.get(0) + "element Size : " + elements.size());
             if (elements.size() > 0) {
                    elements.get(0).click();
                    logger.log(LogStatus.PASS, " Location is present.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Location is Failed.");
                    throw new Exception("Element not found");
             }
       }

       public void clickOnDeleteiCon() throws Exception {
             element = space_Add_Delete.getdeleteLocation();
             if (element != null) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    element.click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    Thread.sleep(1400);
                    logger.log(LogStatus.PASS, "clicked on delete iCon ");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Delete iCon is Failed.");
                    throw new Exception("Element not found");
             }
       }

       public void deleteConformation() throws Exception {
             element = space_Add_Delete.getdeleteConfirmation();
             if (element != null) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();   
            	    element.click();
                    Thread.sleep(1000);
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();  
                    logger.log(LogStatus.PASS, "clicked on delete Confirmation iCon.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Delete Confirmation is Failed.");
                    throw new Exception("Element not found");
             }
       }

       public void checkDeletedLocation(String Location) throws Exception {

             List<WebElement> elements = null;
             elements = space_Add_Delete.getLocationisPresent();
             if (elements.size() > 0) {            	 
                    logger.log(LogStatus.FAIL, "Location:= "+Location+" is not deleted.");
                    throw new Exception("Element not found");
             } else {
                    logger.log(LogStatus.PASS, "Location:= "+Location+" is deleted successfully.");
             }

       }

       public void selectBuilding() throws Exception {

             List<WebElement> elements = null;
             elements = space_Add_Delete.getLocationisPresent();
             System.out.println("Selected Building is : " + elements.get(0) + "element Size : " + elements.size());

             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    Thread.sleep(1000);
                    logger.log(LogStatus.PASS, "Building is selected.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Building is Failed.");
                    throw new Exception("Element not found");
             }

       }

       public void enterBuildingDetails(String Grossfloorarea, String Numberofoccupants)
                    throws Exception {
          /*
    	   element = space_Add_Delete.getBuildingName();
             if (element != null) {
                    element.clear();
                    // element.sendKeys(locationName);
                    element.sendKeys(Buildingname);
                    logger.log(LogStatus.PASS, "Building Name Entered succesfully in Building text box.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Building is Failed.");
             }
*/
    	   /*
             element = space_Add_Delete.get_GrossFloorArea();
             if (element != null) {
                    element.clear();
                    // element.sendKeys(locationName);
                    element.sendKeys(Grossfloorarea);
                    logger.log(LogStatus.PASS, "Gross Floor Area Entered succesfully in GrossFloorArea text box.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for GrossFloorArea is Failed.");
             }
*/
          /*   element = space_Add_Delete.get_Numberofoccupants();
             if (element != null) {
                    element.clear();
                    // element.sendKeys(locationName);
                    element.sendKeys(Numberofoccupants);
                    logger.log(LogStatus.PASS, "Number of occupants Entered succesfully in Numberofoccupants text box.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Numberofoccupants is Failed.");
             }*/

             // Click on Save button
             element = space_Add_Delete.get_SaveBuilding();
             if (element != null) {
                    element.click();
                    Thread.sleep(1300);
                    logger.log(LogStatus.PASS, "Clicked on Save button successfully.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Save is Failed.");
             }
       }
       
       // Save building
       public void save_Building() throws Exception {
  		 element = space_Add_Delete.get_SaveBuilding();
           if (element != null) {
                  element.click();
                  Thread.sleep(1300);
                  logger.log(LogStatus.PASS, "Clicked on Save button successfully.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for Save is Failed.");
           }		
  	}
       // Enter Number of Occupants
  	public void enterNumberofoccupants(String Numberofoccupants) throws Exception{
  		element = space_Add_Delete.get_Numberofoccupants();
  		if (element != null) {
  			element.clear();
  			// element.sendKeys(locationName);
  			element.sendKeys(Numberofoccupants);
  			logger.log(LogStatus.PASS, "Number of occupants Entered succesfully in Numberofoccupants text box.");
  		} else {
  			logger.log(LogStatus.FAIL, "Identifying WebElement for Numberofoccupants is Failed.");
  		}
  	}
  	// Enter Gross floor area
  	public void enterGrossfloorarea(String Grossfloorarea) throws Exception{
  		element = space_Add_Delete.get_GrossFloorArea();
  		if (element != null) {
  			element.clear();
  			// element.sendKeys(locationName);
  			element.sendKeys(Grossfloorarea);
  			logger.log(LogStatus.PASS, "Gross Floor Area Entered succesfully in GrossFloorArea text box.");
  		} else {
  			logger.log(LogStatus.FAIL, "Identifying WebElement for GrossFloorArea is Failed.");
  		}

  	}

  	public void enterbuildingName(String Buildingname) throws Exception {
      	   element = space_Add_Delete.getBuildingName();
             if (element != null) {
                    element.clear();
                    // element.sendKeys(locationName);
                    element.sendKeys(Buildingname);
                    logger.log(LogStatus.PASS, "Building Name Entered succesfully in Building text box.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Building is Failed.");
             }
  		
  	}


       
       public void isBuildingPresent(String Building) throws Exception {

             List<WebElement> elements = null;
             elements = space_Add_Delete.getBuildingisPresent();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    logger.log(LogStatus.PASS, "Building:= "+Building+" is created successfully.");
             } else {
                    logger.log(LogStatus.FAIL, "Building:= "+Building+" is not created successfully.");
                    throw new Exception("Element not found");
             }
       }

       public void isBuildingPresentfordelete(String Building) throws Exception {

           List<WebElement> elements = null;
           elements = space_Add_Delete.getBuildingisPresent();
           if (elements.size() > 0) {
          	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  elements.get(0).click();
                  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  logger.log(LogStatus.PASS, "Building:= "+Building+" is Present in space tree.");
           } else {
                  logger.log(LogStatus.FAIL, "Building:= "+Building+" is not Present in space tree.");
                  throw new Exception("Element not found");
           }
     }
       // Expand Navigation Tree
       public void expandNavigationTree() throws Exception {
    	   List<WebElement> elements = null;
             elements = space_Add_Delete.getExpandTree();
             if (elements.size() >0 ){
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    Thread.sleep(3000);
                    logger.log(LogStatus.PASS, "Clicked successfully on Expand Tree iCon.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Expand Tree is Failed.");
                    throw new Exception("Element not found");
             }

       }

       // Expand Building Tree
       public void expandBuildingNavigationTree() throws Exception {
    	   List<WebElement> elements = null;
             elements = space_Add_Delete.getExpandBuildingTree();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    Thread.sleep(1000);
                    logger.log(LogStatus.PASS, "Clicked successfully on Bulding Navigation Tree iCon.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Bulding Navigation Tree is Failed.");
                    throw new Exception("Element not found");
             }

       }
       
       public void expandWingNavigationTree() throws Exception{
    	   List<WebElement> elements = null;
           elements = space_Add_Delete.getExpandWingTree();
           System.out.println("elements.size() "+elements.size());
           if (elements.size() > 0) {
          	      MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  elements.get(0).click();
                  Thread.sleep(1000);
                  logger.log(LogStatus.PASS, "Clicked successfully on Wing Navigation Tree iCon.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for Wing Navigation Tree is Failed.");
                  throw new Exception("Element not found");
           }
       }

       // Building Delete
       public void isBuildingDeleted(String building) throws Exception {

             List<WebElement> elements = null;
             elements = space_Add_Delete.getBuildingisPresent();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    logger.log(LogStatus.FAIL, "Building:= "+building+" is not deleted successfully.");
                    throw new Exception("Element not found");
             } else {
                    logger.log(LogStatus.PASS, "Building:= "+building+" is deleted successfully.");
                    
             }
       }

       // Expand Building Tree
       public void expandBuildingTree() throws Exception {
    	   List<WebElement> elements = null;
             elements = space_Add_Delete.getExpandBuildingTree();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    Thread.sleep(1300);
                    logger.log(LogStatus.PASS, "Clicked successfully on Expand Tree iCon.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Expand Tree is Failed.");
                    throw new Exception("Element not found");
             }

       }

       // Slect Building

       public void slectBuilding() throws Exception {
             /*
             * List<WebElement> elements = null; elements =
             * space_Add_Delete.getBuildingisPresent(); System.out.println(
             * "Selected Building is : " + elements.get(0) + "element Size : " +
             * elements.size());
             * 
              * if (elements.size() > 0) { elements.get(0).click();
             * System.out.println("Building is selected.."); Thread.sleep(5000);
             * logger.log(LogStatus.PASS, "Location is present..."); } else {
             * logger.log(LogStatus.FAIL,
             * "Identifying WebElement for Location is Failed."); }
             */

             List<WebElement> elements = null;
             elements = space_Add_Delete.getBuildingisPresent();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    logger.log(LogStatus.PASS, "Building is Selected successfully.");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Building is Failed.");
                    throw new Exception("Element not found");
             }

       }

      
	// Enter Wing Area.
	public void enterWingarea(String Wingarea) throws Exception{
		element = space_Add_Delete.getWingarea();
		if (element != null) {
			element.clear();
			element.sendKeys(Wingarea);
			logger.log(LogStatus.PASS, "Wing area Entered succesfully to Wing area text box.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Wing area is Failed.");
			throw new Exception("Element not found");
		}
	}

	// Enter Wing Name.
	public void enterWingName(String wingname2) throws Exception{
		element = space_Add_Delete.getWingName();
		if (element != null) {
			element.clear();
			element.sendKeys(wingname2);
			logger.log(LogStatus.PASS, "Floor Name Entered succesfully to Wing name text box.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Wing is Failed.");
			throw new Exception("Element not found");
		}

	} 

       
       // Save Wing
       
       public void saveWing() throws Exception{
    	   element = space_Add_Delete.getsaveWing();
           if (element != null) {
        	      MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  element.click();
                  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  Thread.sleep(2000);
                  logger.log(LogStatus.PASS, "Clicked successfully on Save button.");
           } else {
                  logger.log(LogStatus.FAIL, "Identifying WebElement for Save is Failed.");
                  throw new Exception("Element not found");
           }
   		
   		}
       
       // Check is Wing Created.
       public void isWingPresent(String wing) throws Exception {	
   		List<WebElement> elements = null;
           elements = space_Add_Delete.getWingisPresent();
           if (elements.size() > 0) {
        	      MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  elements.get(0).click();
                  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  logger.log(LogStatus.PASS, "Wing:= "+wing+ " is created successfully...");
           } else {
                  logger.log(LogStatus.FAIL, "Wing:= "+wing+ " is not created successfully...");
           }
   	}
       
   	public void selectFloortype(String Floortype)throws Exception {
		 element = space_Add_Delete.getFloorType();
        if (element != null) {
               // element.clear();
        	MEMSCloud_Orgnization_Action.selectByVisibleText(element, Floortype,logger);
               logger.log(LogStatus.PASS, "Floor Type Entered succesfully to Floor WebElement");
        } else {
               logger.log(LogStatus.FAIL, "Identifying WebElement for Type is Failed.");
               throw new Exception("Element not found");
        }
	}

	public void enterFloorarea(String Floorarea) throws Exception {
		 element = space_Add_Delete.getFloorArea();
        if (element != null) {
               element.clear();
               element.sendKeys(Floorarea);
               logger.log(LogStatus.PASS, "Floor Area Entered succesfully in Floor text box.");
        } else {
               logger.log(LogStatus.FAIL, "Identifying WebElement for Area is Failed.");
               throw new Exception("Element not found");
        }
	}

	public void enterFloortag(String Floortag) throws Exception {
		 element = space_Add_Delete.getFloorTag();
        if (element != null) {
               element.clear();
               element.sendKeys(Floortag);
               logger.log(LogStatus.PASS, "Floor Tag Entered succesfully to Floor WebElement");
        } else {
               logger.log(LogStatus.FAIL, "Identifying WebElement for Tag is Failed.");
               throw new Exception("Element not found");
        }
	}

	public void enterFloorname(String Floorname) throws Exception{
		element = space_Add_Delete.getFloorName();
       if (element != null) {
              element.clear();
              //element.sendKeys(Floorname);
              element.sendKeys(Floorname);
              logger.log(LogStatus.PASS, "Floor Name Entered succesfully in Floor text box.");
       } else {
              logger.log(LogStatus.FAIL, "Identifying WebElement for Floor is Failed.");
              throw new Exception("Element not found");
       }
	}
       
       
       // save Floor
       public void saveFloor() throws Exception {
             element = space_Add_Delete.getsavefloor();
             if (element != null) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    element.click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    Thread.sleep(2000);
                    logger.log(LogStatus.PASS, "Clicked successfully on Save button WebElement");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Save is Failed.");
                    throw new Exception("Element not found");
             }
       }

       // Check is floor save
       public void isFloorPresent(String Floor) throws Exception {

             List<WebElement> elements = null;
             elements = space_Add_Delete.getFloorisPresent();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    logger.log(LogStatus.PASS, ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Floor") + " Floor is created successfully...");
             } else {
                    logger.log(LogStatus.FAIL, "Floor:= "+Floor+" is not created sucessfully");
                    throw new Exception("Element not found");
             }

       }

       // Check Floor is present.
       public void slectFloor() throws Exception {
             List<WebElement> elements = null;
             elements = space_Add_Delete.getFloorisPresent();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    logger.log(LogStatus.PASS, ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Floor") + " Floor is selected successfully...");
             } else {
                    logger.log(LogStatus.FAIL, "Identifying WebElement for Floor is Failed.");
                    throw new Exception("Element not found");
             }
       }

       // Check Floor is deleted.
       public void isFloorDeleted() throws Exception {
             List<WebElement> elements = null;
             elements = space_Add_Delete.getFloorisPresent();
             if (elements.size() > 0) {
            	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    elements.get(0).click();
                    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                    logger.log(LogStatus.FAIL,ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Floor") + " Floor is not deleted");
                    throw new Exception("Element not found");
             } else {
                    logger.log(LogStatus.PASS, ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Floor") + " Floor is deleted successfully.");
             }
       }
       
       public void isWingDeleted(String wing) throws Exception {
   		List<WebElement> elements = null;
           elements = space_Add_Delete.getWingisPresent();
           if (elements.size() > 0) {
        	   MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               elements.get(0).click();
               MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               logger.log(LogStatus.FAIL,"Wing:= "+wing+" is not deleted.");
               throw new Exception("Element not found");
        } else {
               logger.log(LogStatus.PASS, "Wing:= "+wing+" is deleted successfully...");
        }
   		
   	}

   	public void selectWing(String Wing) throws Exception {
   		List<WebElement> elements = null;
           elements = space_Add_Delete.getWingisPresent();
           if (elements.size() > 0) {
           	      MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();	
                  elements.get(0).click();
                  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  logger.log(LogStatus.PASS, "Wing:= "+Wing+" is selected successfully...");
           } else {
                  logger.log(LogStatus.FAIL, "Wing:= "+Wing+" is not selected successfully...");
                  throw new Exception("Element not found");
           }
   		
   	}
   	
	// Enter Room Details
	public void enterRoomarea(String Roomarea) throws Exception{
		element = space_Add_Delete.getRoomArea();
		if (element != null) {
			element.clear();
			element.sendKeys(Roomarea);
			logger.log(LogStatus.PASS, "Room area Entered succesfully to Room area text box.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Room area is Failed.");
			throw new Exception("Element not found");
		}
	}

	// Enter Room Name
	public void enterRoomname(String roomname) throws Exception{
		element = space_Add_Delete.getRoomName();
		if (element != null) {
			element.clear();
			element.sendKeys(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Room"));
			logger.log(LogStatus.PASS, "Room Name Entered succesfully to Wing name text box.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Room is Failed.");
			throw new Exception("Element not found");
		}
	}
	
	// Save Room	
	public void saveRoom() throws Exception {
		 element = space_Add_Delete.getSaveRoom();
        if (element != null) {
        	   MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               element.click();
               MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               Thread.sleep(2000);
               logger.log(LogStatus.PASS, "Clicked successfully on Save button.");
        } else {
               logger.log(LogStatus.FAIL, "Identifying WebElement for Save is Failed.");
               throw new Exception("Element not found");
        }
		
	}
	
	// Check is Wing Created.
    public void isRoomPresent(String Room) throws Exception {	
		List<WebElement> elements = null;
        elements = space_Add_Delete.getRoomisPresent();
        if (elements.size() > 0) {
        	   MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               elements.get(0).click();
               MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               logger.log(LogStatus.PASS, "Room:= "+Room+" is created successfully...");
        } else {
               logger.log(LogStatus.FAIL, "Identifying WebElement for Room is Failed.");
               throw new Exception("Element not found");
        }
	}
  
    // Check deleted Room
    public void isRoomDeleted(String Room) throws Exception {
		List<WebElement> elements = null;
        elements = space_Add_Delete.getRoomisPresent();
        if (elements.size() > 0) {
        	MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
        	elements.get(0).click();
            logger.log(LogStatus.FAIL,"Room:= "+Room+" is not deleted.");
            throw new Exception("Element not found");
     } else {
            logger.log(LogStatus.PASS, "Room:= "+Room+" is deleted successfully...");
        }
		
	}
    
    //Exapand Floor Navigation tree
	public void expandFloorNavigationTree() throws Exception {
		 List<WebElement> elements = null;
         elements = space_Add_Delete.getExpandRoomTree();
         System.out.println("elements.size() "+elements.size());
         if (elements.size() > 0) {
        	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                elements.get(0).click();
                MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                Thread.sleep(1000);
                logger.log(LogStatus.PASS, "Clicked successfully on Room Navigation Tree WebElement");
         } else {
                logger.log(LogStatus.FAIL, "Identifying WebElement for Room Navigation Tree is Failed.");
                throw new Exception("Element not found");
         }
		
	}

	//Select Room
	public void selectRoom(String Room) throws Exception {
		List<WebElement> elements = null;
        elements = space_Add_Delete.getRoomisPresent();
        if (elements.size() > 0) {
        	   MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               elements.get(0).click();
               MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
               logger.log(LogStatus.PASS, "Room:= "+Room+ " is selected successfully...");
        } else {
               logger.log(LogStatus.FAIL, "Room:= "+Room+ " is not selected successfully...");
               throw new Exception("Element not found");
        }        
      
	}

	public void waitTillSpaceDistributionTreeAppear() throws Exception {
        try{
        List<WebElement> waitForPortfolioinspacetree = space_Add_Delete.getPortfolioInSpaceTree();
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(120, TimeUnit.SECONDS)
                                      .pollingEvery(2, TimeUnit.SECONDS);
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(waitForPortfolioinspacetree));
        logger.log(LogStatus.PASS,   " Portfolio is Present on Space Tree");   
        }catch(Exception e){
        	logger.log(LogStatus.FAIL,   " Portfolio is not Present on Space Tree");  
        	throw new Exception("Element not found");
        }
        
}
	
     /*  
       public void navigateSpace() throws InterruptedException{
    	   Thread.sleep(5000);
    	   //String SpaceURL_JSONPath = "$..SpacesURL";
           //String Spaces_URL = ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("SpacedataFileLoc"), SpaceURL_JSONPath);
    	   //driver.get(Spaces_URL);
    	   driver.get("https://mclu-ui.azurewebsites.net/Configuration/Spaces");
    	   MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
    	   Thread.sleep(5000);
       }*/
	
       // Create Location
       public void createLocation() throws Exception 
       {
    	   
    		 List<String> Spaces_datalist = new ArrayList<String>();  
    	   	 orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
    	     String Spaces_datalist_JSONPath = "$..Spacesdata.*";
    	     Spaces_datalist= ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Spaces_datalist_JSONPath);
             //Spaces_datalist = ReadJsonFile.readJsonFileDynamic(configFile, Spaces_datalist_JSONPath);
             //System.out.println("Spaces_datalist : "+Spaces_datalist); 
             //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             //Thread.sleep(1200);             
		    // clickOnCardBaseMenu();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSetupPage();		     
             //navigateSpace();
             MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
    	     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
    	     waitTillSpaceDistributionTreeAppear();
    	     clickOncreateLocationiCon();    	     
             String Location_name=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
             WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Location",Location_name);
             //Thread.sleep(1000);
             enterLocationname(Location_name);
             enterAddressLine1(Spaces_datalist.get(0).toString());
             enterAddressLine2(Spaces_datalist.get(1).toString());
             enterCity(Spaces_datalist.get(2).toString());
             selectCountry(Spaces_datalist.get(3).toString());
             enterZipcode(Spaces_datalist.get(4).toString());
             enterLatitude(Spaces_datalist.get(5).toString());
             enterLongitude(Spaces_datalist.get(6).toString());
             saveLocation(); 
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             isLocationCreated();
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             /*
             clickOnCardBaseMenu();
             System.out.println("2");
             gotoHomePage();
             */
             MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.HomeURL"));
    	     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             reSizeMap();
             checkCreatedLocationonMap(Location_name);
    	   
       }	

	public void deleteLocation() throws Exception {   
		
    	   	 //orgnizaton_action_obj.correctLogin_admin();
			orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();	 
		   // MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		    MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
             Thread.sleep(1200);            
		    // clickOnCardBaseMenu();
		    // MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSetupPage();
		     MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             //navigateSpace();
		     waitTillSpaceDistributionTreeAppear();
             isLocationPresent();
             delete_SelectedLocation();
             clickOnDeleteiCon();
             deleteConformation();
             checkDeletedLocation(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Location"));
             //clickOnCardBaseMenu();
             //gotoHomePage();
             /*
             MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.HomeURL"));
    	    //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             reSizeMap();
             checkDeletedLocationonMap(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Location"));
             */
       
	}

       public void createBuilding() throws Exception 
       {
    	   
    	     MEMSCloud_Space_Add_Delete_Page_Action a = new MEMSCloud_Space_Add_Delete_Page_Action(driver, logger);
    	     orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
    	    // MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
    	     MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
    	     List<String> Spaces_datalist = new ArrayList<String>();  
    	     String Spaces_datalist_JSONPath = "$..Spacesdata.*";
    	     Spaces_datalist= ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Spaces_datalist_JSONPath);
             //Thread.sleep(1200);
             //navigateSpace();
             //clickOnCardBaseMenu();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSetupPage();		             
             MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             waitTillSpaceDistributionTreeAppear();
             selectBuilding();
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             clickOncreateLocationiCon();
             String Buildingname=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);       
             WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Building",Buildingname);
             enterbuildingName(Buildingname);
             enterGrossfloorarea(Spaces_datalist.get(7).toString());
             enterNumberofoccupants(Spaces_datalist.get(8).toString());
             save_Building();
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             isBuildingPresent(Buildingname);
    	   

       }

		public void deleteBuilding() throws Exception {
			
    	     //orgnizaton_action_obj.correctLogin_admin();
    	     orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
    	     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
    	     MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
    	     Thread.sleep(1200);
             //clickOnCardBaseMenu();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSetupPage();		     
             //navigateSpace();    
             MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             waitTillSpaceDistributionTreeAppear();
             expandNavigationTree();
             isBuildingPresentfordelete(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Building"));
             selectBuildingtoDelete(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Building"));
             clickOnDeleteiCon();
             deleteConformation();
             isBuildingDeleted(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Building"));
			
       }

       public void selectBuildingtoDelete(String building) throws Exception {
    	   List<WebElement> elements = null;
           elements = space_Add_Delete.getBuildingisPresent();
           System.out.println("Selected Building is : " + elements.get(0) + "element Size : " + elements.size());
           if (elements.size() > 0) {
          	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  elements.get(0).click();
                  MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                  Thread.sleep(1000);
                  logger.log(LogStatus.PASS, "Building:= "+building+ " is selected.");
           } else {
                  logger.log(LogStatus.FAIL, "Building:= "+building+ " is not selected.");
           }		
	}       
   	
       
     //*********************************** CREATE FLOOR ***********************************
	public void createFloor() throws Exception 
	{            
    	  
		     orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
    	     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
		     List<String> Spaces_datalist = new ArrayList<String>();  
    	     String Spaces_datalist_JSONPath = "$..Spacesdata.*";
    	     Spaces_datalist= ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Spaces_datalist_JSONPath);
    	     //Thread.sleep(5000);
             //navigateSpace();
    	    // clickOnCardBaseMenu();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSetupPage();		
    	     MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();             
             Thread.sleep(5000);
             waitTillSpaceDistributionTreeAppear();
             expandNavigationTree();
             slectBuilding();
             clickOncreateLocationiCon();
             String Floorname=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
             WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Floor",Floorname);
             enterFloorname(Floorname);
             enterFloorarea(Spaces_datalist.get(9).toString());
             enterFloortag(Spaces_datalist.get(10).toString());
             selectFloortype(Spaces_datalist.get(11).toString());         
             saveFloor();
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
             isFloorPresent(Floorname);
    	  
       }

	//*********************************** DELETE FLOOR ***********************************
	public void deleteFloor() throws Exception {
		
    	   //	 orgnizaton_action_obj.correctLogin_admin();
    	   	orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
    	     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
    	   	MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage"); 
    	   	Thread.sleep(1200);
   	         //navigateSpace();
   	         //clickOnCardBaseMenu();
		    // MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSetupPage();	
   	         MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
             MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();    	   
    	   	 Thread.sleep(5000);
    	   	waitTillSpaceDistributionTreeAppear();
             expandNavigationTree();
             expandBuildingNavigationTree();
             slectFloor();
             clickOnDeleteiCon();
             deleteConformation();
             isFloorDeleted();
		
       }
	//*********************************** CREATE WING ***********************************
	public void createWing() throws Exception 
	{  
			//orgnizaton_action_obj.correctLogin_admin();
			orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
			List<String> Spaces_datalist = new ArrayList<String>();  
		     String Spaces_datalist_JSONPath = "$..Spacesdata.*";
    	     Spaces_datalist= ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Spaces_datalist_JSONPath);
		    // Thread.sleep(5000);
		     //clickOnCardBaseMenu();
		     //navigateSetupPage();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSpace();
		     MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     waitTillSpaceDistributionTreeAppear();
		     expandNavigationTree();
		     expandBuildingNavigationTree();
		     slectFloor();
		     clickOncreateLocationiCon();
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     String Wingname=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		     WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Wing",Wingname);
		     enterWingName(Wingname);
		     enterWingarea(Spaces_datalist.get(12).toString());		     
		     saveWing();
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     isWingPresent(Wingname);	
		
	}

	//*********************************** DELETE WING ***********************************
	public void deleteWing() throws Exception {
		   	 //orgnizaton_action_obj.correctLogin_admin();
			orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();     
			//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage"); 
			Thread.sleep(1200);
		     //clickOnCardBaseMenu();
		     //navigateSetupPage();
		     MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSpace();
		     waitTillSpaceDistributionTreeAppear();
		     expandNavigationTree();
		     expandBuildingNavigationTree();
		     expandWingNavigationTree();
		     //slectFloor();		     
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     selectWing(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Wing"));
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     clickOnDeleteiCon();
             deleteConformation();
             isWingDeleted(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Wing"));
		
	}
	//*********************************** CREATER ROOM ***********************************
	public void createRoom() throws Exception 
	{
		
		   	// orgnizaton_action_obj.correctLogin_admin();
			orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
			 //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage"); 
			Thread.sleep(1200);
		     List<String> Spaces_datalist = new ArrayList<String>(); 
		     String Spaces_datalist_JSONPath = "$..Spacesdata.*";
    	     Spaces_datalist= ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), Spaces_datalist_JSONPath);
		     //clickOnCardBaseMenu();
		     //navigateSetupPage();
		     MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSpace();
		     waitTillSpaceDistributionTreeAppear();
		     expandNavigationTree();
		     expandBuildingNavigationTree();
		     expandWingNavigationTree();
		     //slectFloor();		     
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //expandFloorNavigationTree();
		     selectWing(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Wing"));
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     clickOncreateLocationiCon();
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     String Roomname=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);	
		     WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Room",Roomname);
		     enterRoomname(Roomname);
		     enterRoomarea(Spaces_datalist.get(13).toString());		     
		     saveRoom();
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     isRoomPresent(Roomname);
		
	}

	//*********************************** DELETE ROOM ***********************************
	public void deleteRoom() throws Exception {
		
			 orgnizaton_action_obj.correctLogin_Admin_WithoutFacility();
			 //orgnizaton_action_obj.correctLogin_admin();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			 MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
		     Thread.sleep(1200);
		    // clickOnCardBaseMenu();
		     //MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSetupPage();
		     MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     //navigateSpace();
		     waitTillSpaceDistributionTreeAppear();
		     expandNavigationTree();
		     expandBuildingNavigationTree();
		     expandWingNavigationTree();
		     expandFloorNavigationTree();
		     //slectFloor();		     
		     MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		     selectRoom(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Room"));
		     clickOnDeleteiCon();
             deleteConformation();
             isRoomDeleted(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Room"));		
		
	}

	//*********************************** CREATER USER ROLE ***********************************
		public void create_Users_CreateRole() throws Exception
		{
			
			//orgnizaton_action_obj.correctLogin_admin();
			//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			//Thread.sleep(3000);  
			orgnizaton_action_obj.correctLogin_SuperAdmin_withoutfacility_withagreepopup();
			
			//driver.get("https://mclu-ui.azurewebsites.net/Configuration/Spaces");			
			//clickOnCardBaseMenu();
			//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			//navigateSetupPage();
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();			
			click_On_Users();	
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			click_On_Create_Role();			
			String RoleName=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
			WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Role",RoleName);
			enterRoleName(RoleName);
			enterDescription();
			clear();
			enterRoleName(RoleName);
			enterDescription();
			clickOnAdd();			
			searchAddedRole(RoleName);
			selectRole(RoleName);
			String UpdateRoleName = MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
			WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"Role",UpdateRoleName);
			updateRoleName(UpdateRoleName);
			updateDescription();
			clickOnUpdated();
			searchAddedRole(UpdateRoleName);
			selectUpdatedRole(UpdateRoleName);
			
		}

	

	// *********************************** CLICK ON USERS MODULE ***********************************	
	
	public void click_On_Users() throws Exception {
		element = space_Add_Delete.getUsers();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked successfully on Users Tab.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Users is Failed.");
		}

	}

	// *********************************** CLICK ON USERS MODULE ***********************************
	
	public void click_On_Create_Role() throws Exception {
		element = space_Add_Delete.getCreateRole();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked successfully on Create Role Tab.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Create Role is Failed.");
		}

	}
	// *********************************** Update ROLE NAME ***********************************
	public void updateRoleName( String UpdateRoleName) throws Exception {
		element = space_Add_Delete.getRoleName();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.clear();
			element.sendKeys(UpdateRoleName);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Role Name:= "+UpdateRoleName +" updated successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Role is Failed.");
		}
	}
	
	// *********************************** UPDATE ROLE NAME ***********************************
		public void enterRoleName( String RoleName) throws Exception {
			element = space_Add_Delete.getRoleName();
			if (element != null) {
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				element.clear();
				element.sendKeys(RoleName);
				MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
				logger.log(LogStatus.PASS, "Role Name Entered successfully.");
			} else {
				logger.log(LogStatus.FAIL, "Identifying WebElement for Role is Failed.");
			}
		}
	// *********************************** CLICK DESCRIPTION ***********************************	
	public void enterDescription() throws Exception {
		element = space_Add_Delete.getDescription();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.clear();
			element.sendKeys("TEST DESCRIPTION");
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Role Description Entered successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Description is Failed.");
		}

	}
	
	// *********************************** UPDATE DESCRIPTION ***********************************	
	public void updateDescription() throws Exception {
		element = space_Add_Delete.getDescription();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.clear();
			element.sendKeys("TEST DESCRIPTION UPDATE");
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Role Description updated successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Description is Failed.");
		}

	}
	// *********************************** CLEAR FIELDS ***********************************
	public void clear() throws Exception {
		element = space_Add_Delete.getClear();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Role Name and Description text box cleared successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Clear is Failed.");
		}
	}
	// *********************************** ADD RLOE ***********************************
	public void clickOnAdd() throws Exception {
		element = space_Add_Delete.getAddRole();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.click();
			Thread.sleep(2000);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "clicked on Add button successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Add is Failed.");
		}
		
	}
	
	// *********************************** ADD RLOE ***********************************
	public void searchAddedRole(String RoleName) throws Exception {
		element = space_Add_Delete.getSearchAddedRole();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.clear();
			element.sendKeys(RoleName);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Search Role Name:= "+RoleName+" successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Search is Failed.");
		}
	}
	
	// *********************************** CLICK ON SEARCH ICON ***********************************
	public void selectRole() throws Exception{		
		 List<WebElement> elements = null;
         elements = space_Add_Delete.getRole();         
         if (elements.size() > 0) {
        	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
                elements.get(0).click();
                MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();                
                logger.log(LogStatus.PASS, "Role selected is successfully.");
         } else {
                logger.log(LogStatus.FAIL, "Identifying WebElement for Role is Failed.");
         }			
	}
	
	// *********************************** CLICK ON UPDATED ROLE  ***********************************
		public void selectUpdatedRole(String role) throws Exception{		
			 List<WebElement> elements = null;
	         elements = space_Add_Delete.getUpdatedRole();         
	         if (elements.size() > 0) {
	        	    MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
	                elements.get(0).click();
	                Thread.sleep(2000);
	                MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();                
	                logger.log(LogStatus.PASS, "Updated Role Name:= " +role+" is selected successfully.");
	         } else {
	                logger.log(LogStatus.FAIL, "Identifying WebElement for Role is Failed.");
	         }			
		}
	
	
	// *********************************** UPDATE ROLE ***********************************
	public void clickOnUpdated() throws Exception {
		element = space_Add_Delete.getUpdateRole();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.click();
			Thread.sleep(2000);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Role Name update successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Update is Failed.");
		}
		
	}
	//*********************************** CREATER USER ROLE ***********************************
	public void create_AdminUser() throws Exception 
	{

		
		orgnizaton_action_obj.correctLogin_SuperAdmin_withoutfacility();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();		
		Thread.sleep(1200);
		//driver.get("https://mclu-ui.azurewebsites.net/Configuration/Spaces");
		
		//clickOnCardBaseMenu();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		//navigateSetupPage();
		
		MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		click_On_Users();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		select_UserList_Tab();
		String username=MEMSCloud_Orgnization_Action.generateRandomalphabets(6);
		WriteJsonFile.writeJSONFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"),"AdminUser",username);
		String admindentials_data = "$..UserDetails.*";
		User_Details = ReadJsonFile.readJsonFileDynamic(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), admindentials_data);
		orgobject.clickaddUser_icon();
		orgobject.enterUsename(username);		
		orgobject.enterPassword(User_Details.get(0).toString());
		orgobject.enterConfirmpassword(User_Details.get(1).toString());
		orgobject.enterFirstname(User_Details.get(2).toString());
		orgobject.enterLastname(User_Details.get(3).toString());
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();		
		//orgobject.selectRole(User_Details.get(4).toString());
		orgobject.selectRole(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Role"));
		orgobject.enterEmail(User_Details.get(5).toString());
		orgobject.enterContactnumber(User_Details.get(6).toString());
		orgobject.selectLanguage(User_Details.get(7).toString());
		orgobject.clickSubmit_btn();
		//search the added user
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		orgobject.enteruser_insearchbox(username);
	    verifyUserpresent(username);
    		
	}
	
	//*********************************** CHECK USER IS PRESENT ***********************************
	public void verifyUserpresent(String user) throws Exception {
		List<WebElement> elements = null;
		elements = space_Add_Delete.checkuserpresent();
		if (elements.size() > 0) {
			elements.get(0).click();
			logger.log(LogStatus.PASS, " User:= " +user+" is created sucesfully and is present in users grid"); 
		} else {
			logger.log(LogStatus.FAIL, "User:= " +user+ " is not created succesfully");   
		}
	}

	//*********************************** CREATER USER ROLE ***********************************
	public void select_UserList_Tab() throws Exception {
		element = space_Add_Delete.getUserListTab();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			element.click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Navigate User List Tab successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for User List is Failed.");
		}
		
	}
	//*********************************** ASSIGN ADMIN USERS ROLES & RIGHTS ***********************************
	public void assign_AdminUserRolesandRights() throws Exception {
		//orgnizaton_action_obj.correctLogin_admin();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();		
		//Thread.sleep(1200);
	
		orgnizaton_action_obj.correctLogin_SuperAdmin_withoutfacility();
		//driver.get("https://mclu-ui.azurewebsites.net/Configuration/Spaces");	
		//clickOnCardBaseMenu();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		//navigateSetupPage();	
		
		MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();	
		click_On_Users();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		orgobject.clickRolesandRights_tab();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		//selectRole("dd");
		selectRoleDropdown(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Role"));
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		orgobject.selectDashboardView_ChkBox();
		orgobject.selectDashboardEdit_ChkBox();
		orgobject.selectSetUpView_ChkBox();
		orgobject.selectSetUpEdit_ChkBox();
		//orgobject.selectReportsView_ChkBox();
		//orgobject.selectReportsEdit_ChkBox();
		selectPortFoliochkBox();
		orgobject.clickOnSaveBtn();
		
		
	}
	public void verifyUserpresentingridfordelete(String user) throws Exception {
		List<WebElement> elements=null;
		MEMSCloud_Users_Page_Factory UsersPF = new MEMSCloud_Users_Page_Factory(driver,logger);
		elements = UsersPF.checkuserpresent();
		if(elements.size() >0){	
			elements.get(0).click();
			logger.log(LogStatus.PASS, " User:= " +user+" is present in users grid");  
		}
		else{
			logger.log(LogStatus.FAIL, "  User:= " +user+" is not present in users grid");   
		}
	}
	//*********************************** SELECT PORTFOLIO CHECKBOX ***********************************
	public void selectRole(String userRole) throws Exception {
		 List<WebElement> elements = null;
		//element = space_Add_Delete.getUserRole();//
		 elements = space_Add_Delete.getUpdatedRole();
		if (elements.size() >0) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			//MEMSCloud_Orgnization_Action.selectByVisibleText(element, userRole);
			elements.get(0).click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Role:= "+userRole+" selected successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Role is Failed.");
		}
		
	}

	public void selectRoleDropdown(String userRole) throws Exception {
		 List<WebElement> elements = null;
		//element = space_Add_Delete.getUserRole();//
		 element = space_Add_Delete.getUserRole();
		if (element!=null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			MEMSCloud_Orgnization_Action.selectByVisibleText(element, userRole,logger);
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Role:= "+userRole+" selected successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for Role is Failed.");
		}
		
	}
	
	
	//*********************************** SELECT PORTFOLIO CHECKBOX ***********************************
	public void selectPortFoliochkBox() throws Exception {
		 List<WebElement> elements = null;
		 List<WebElement> elements2 = null;
		 
		 elements = space_Add_Delete.getPortFolioChkBox_Checked();         
		 elements2 = space_Add_Delete.getPortFolioChkBox();

		 if(elements.size() > 0){
			 logger.log(LogStatus.PASS, "Port Folio check box already checked."); 
		 }else if(elements2.size() > 0){
			 elements2.get(0).click();
			 MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			 logger.log(LogStatus.PASS, "Port Folio check box checked successfully.");
		 }else{
			 logger.log(LogStatus.FAIL, "Identifying WebElement for Port Folio check box Field Failed.");  
		 }        
        
	}
	
	//*********************************** SELECT PORTFOLIO CHECKBOX ***********************************
	public void delete_AdminUser() throws Exception {
		
		//orgnizaton_action_obj.correctLogin_admin();
		orgnizaton_action_obj.correctLogin_SuperAdmin_withoutfacility();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();		
		//Thread.sleep(1200);
		//driver.get("https://mclu-ui.azurewebsites.net/Configuration/Spaces");
		//clickOnCardBaseMenu();
		//MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		//navigateSetupPage();	
		MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		click_On_Users();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		select_UserList_Tab();
		MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
		//String username = "xyz";
        orgobject.enteruser_insearchbox(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..AdminUser"));		
        verifyUserpresentingridfordelete(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..AdminUser")); 
        clickOnDelete_iCon();
        clickOnConformationMsg();
        verifyisUserDelete(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..AdminUser"));
		
	}

	//*********************************** CLICK ON CONFORMATION MESSAGE ***********************************
	public void clickOnConformationMsg() throws Exception {
		element = space_Add_Delete.getConformation();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();		
			element.click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked on delete iCon successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for delete iCon is Failed.");
		}
		
	}

	//*********************************** VERIFY IS USER DELETE ***********************************
	public void verifyisUserDelete(String user) throws Exception {
		List<WebElement> elements = null;
		elements = space_Add_Delete.checkuserpresent();
		if (elements.size() > 0) {
			elements.get(0).click();
			logger.log(LogStatus.FAIL, " User:= " +user+ " is not deleted from the grid.");			
		} else {
			logger.log(LogStatus.PASS, " User:= " +user+ " is deleted from the grid.");
		}
	}

	//*********************************** SELECT PORTFOLIO CHECKBOX ***********************************
	public void clickOnDelete_iCon() throws Exception {
		element = space_Add_Delete.getDeteleUserName();
		if (element != null) {
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();		
			element.click();
			MEMSCloud_Orgnization_Action.waitForSpinnerToDisappear();
			logger.log(LogStatus.PASS, "Clicked on delete iCon successfully.");
		} else {
			logger.log(LogStatus.FAIL, "Identifying WebElement for delete iCon is Failed.");
		}			
		
	}
	
	//selectunits actions ....
	
	public void clickSelectUnits_Btn() throws Exception{
		MEMSCloud_Orgnization_Action.clickWithLogger(space_Add_Delete.getSelectUnits_Btn(), "Select Units button",logger);
	}
	
	public void selectAreaUnit(String  AreaUnit) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getAreaUnitDropDown(), "AreaUnit", AreaUnit,logger);
	}
	
	public void selectElectricity(String  Electricity) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getElectricityDropDown(), "Electricity", Electricity,logger);
	}
	
	public void selectElectricalDemand(String  ElectricalDemand) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getElectricityDemandDropDown(), "ElectricalDemand", ElectricalDemand,logger);
	}
	
	public void selectWater(String  Water) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getWaterDropDown(), "Water", Water,logger);
	}
	
	public void selectHotWater(String  HotWater) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getHotWaterDropDown(), "HotWater", HotWater,logger);
	}
	
	public void selectChilledWater(String  ChilledWater) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getChilledWaterDropDown(), "ChilledWater", ChilledWater,logger);
	}
	
	public void selectGas(String  Gas) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getGasDropDown(), "Gas", Gas,logger);
	}
	
	public void selectSteam(String  Steam) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getSteamDropDown(), "Steam", Steam,logger);
	}
	
	public void selectFuelOil(String  FuelOil) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getFuelOilDropDown(), "FuelOil", FuelOil,logger);
	}
	
	public void selectPropane(String  Propane) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getPropaneDropDown(), "Propane", Propane,logger);
	}
	
	public void selectDiesel(String  Diesel) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getDieselDropDown(), "Diesel", Diesel,logger);
	}
	public void selectSewage(String  Sewage) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getSewageDropDown(), "Sewage", Sewage,logger);
	}
	
	public void selectCoal(String  Coal) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getCoalDropDown(), "Coal", Coal,logger);
	}
	
	public void selectTemparature(String  Temparature) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getTemparatureDropDown(), "Temparature", Temparature,logger);
	}
	public void enterEmissionFactor(String  EmissionFactor) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getEmissionTextBox(), "EmissionFactor", EmissionFactor,logger);
	}
	
	public void selectCurrency(String  Currency) throws Exception 
	{
		MEMSCloud_Orgnization_Action.selectDropDownWithLogger(space_Add_Delete.getCurrencyDropDown(), "Currency", Currency,logger);
	}
	
	public void enterElectricityCurrencyValue(String  ElectricityCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getElectricityValueTextBox(), "ElectricityCurrencyValue", ElectricityCurrencyValue,logger);
	}
	
	public void enterElectricalDemandCurrencyValue(String  ElectricalDemandCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getElectricalDemandValueTextBox(), "ElectricalDemandCurrencyValue", ElectricalDemandCurrencyValue,logger);
	}
	public void enterWaterCurrencyValue(String  WaterCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getWaterValueTextBox(), "WaterCurrencyValue", WaterCurrencyValue,logger);
	}
	
	public void enterHotWaterCurrencyValue(String  HotWaterCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getHotWaterValueTextBox(), "HotWaterCurrencyValue", HotWaterCurrencyValue,logger);
	}
	
	public void enterChilledWaterCurrencyValue(String  ChilledWaterCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getChilledWaterValueTextBox(), "ChilledWaterCurrencyValue", ChilledWaterCurrencyValue,logger);
	}
	
	public void enterGasCurrencyValue(String  GasCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getGasValueTextBox(), "GasCurrencyValue", GasCurrencyValue,logger);
	}
	
	public void enterSteamCurrencyValue(String  SteamCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getSteamValueTextBox(), "SteamCurrencyValue", SteamCurrencyValue,logger);
	}
	
	public void enterFuelOilCurrencyValue(String  FuelOilCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getFuelOilValueTextBox(), "FuelOilCurrencyValue", FuelOilCurrencyValue,logger);
	}
	public void enterPropaneCurrencyValue(String  PropaneCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getPropaneValueTextBox(), "PropaneCurrencyValue", PropaneCurrencyValue,logger);
	}
	public void enterDieselCurrencyValue(String  DieselCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getDieselValueTextBox(), "DieselCurrencyValue", DieselCurrencyValue,logger);
	}
	public void enterSewageCurrencyValue(String  SewageCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getSewageValueTextBox(), "SewageCurrencyValue", SewageCurrencyValue,logger);
	}
	public void enterCoalCurrencyValue(String  CoalCurrencyValue) throws Exception 
	{
		MEMSCloud_Orgnization_Action.sendInputTextBoxWithLogger(space_Add_Delete.getCoalValueTextBox(), "CoalCurrencyValue", CoalCurrencyValue,logger);
	}
	
	public void clickSubmitBtn() throws Exception{
		MEMSCloud_Orgnization_Action.clickWithLogger(space_Add_Delete.getSubmit_Btn(), "Submit button",logger);
	    Thread.sleep(10000);
		logger.log(LogStatus.PASS, "Orgnization:= "+ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("RuntimedatafileLoc"), "$..Organization")+ " units assigning has completed sucessfully."); 
	}
	
	
	public void selectUnits() throws Exception{
	
		
			orgnizaton_action_obj.correctLogin_Admin_WithoutFacility_withagreepopup();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("portfoliolandingpage");
			MEMSCloud_Orgnization_Action.Navigate_to_url(ReadJsonFile.readJsonFileDynamic_firstentry(ReadPropertyFile.getInstance(configFile).getProperty("Testdatafilelocation"), "$..Spacesdata.SpaceURL"));
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("common");
			clickSelectUnits_Btn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("common");
			selectAreaUnit(SelectUnitsdatalist_data.get(0));
			selectElectricity(SelectUnitsdatalist_data.get(1));
			selectElectricalDemand(SelectUnitsdatalist_data.get(2));
			selectWater(SelectUnitsdatalist_data.get(3));
			selectHotWater(SelectUnitsdatalist_data.get(4));
			selectChilledWater(SelectUnitsdatalist_data.get(5));
			selectGas(SelectUnitsdatalist_data.get(6));
			selectSteam(SelectUnitsdatalist_data.get(7));
			selectFuelOil(SelectUnitsdatalist_data.get(8));
			selectPropane(SelectUnitsdatalist_data.get(9));
			selectDiesel(SelectUnitsdatalist_data.get(10));
			selectSewage(SelectUnitsdatalist_data.get(11));
			selectCoal(SelectUnitsdatalist_data.get(12));
			enterEmissionFactor(SelectUnitsdatalist_data.get(13));
			selectCurrency(SelectUnitsdatalist_data.get(14));
			enterElectricityCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterElectricalDemandCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterWaterCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterHotWaterCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterChilledWaterCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterGasCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterSteamCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterFuelOilCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterPropaneCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterDieselCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterSewageCurrencyValue(SelectUnitsdatalist_data.get(15));
			enterCoalCurrencyValue(SelectUnitsdatalist_data.get(15));
			selectTemparature(SelectUnitsdatalist_data.get(16));
			clickSubmitBtn();
			MEMSCloud_Orgnization_Action.waitForGenericSpinnerToDisappear("common");
		
	}
		
}

