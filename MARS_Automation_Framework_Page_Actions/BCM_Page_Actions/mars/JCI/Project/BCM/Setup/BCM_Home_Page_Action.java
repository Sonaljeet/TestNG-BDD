/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class BCM_Home_Page_Action {

	private static WebDriver driver= null;
	private static ExtentTest logger = null;
	private static BCM_Home_Page_Factory homeFactory = null;
	
	private static String BCMusername = "bcmsysagent";
	private static String BCMpassword = "Aug@2016";
	private static final By IMAGELOADER = By.id("loader");
	
	public BCM_Home_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		homeFactory = new BCM_Home_Page_Factory(driver, logger);
		
	}
	
	//WebMethods Start
	public void clickBuildingLink(){
		getBuildingLink().click();
	}
	
	public void clickAHULink(){
		getAHULink().click();
	}
	
	public void clickVAVLink(){
		getVAVLink().click();
	}
	
	public void clickPAULink(){
		getPAULink().click();
	}
	
	public void clickFCULink(){
		getFCULink().click();
	}
	
	public void clickACPlantLink(){
		getACPlantLink().click();
	}
	
	public void clickBoilerLink(){
		getBoilerLink().click();
	}
	
	public void clickExhaustFanLink(){
		getExhaustFanLink().click();
	}
	
	public void clickSumpPumpLink(){
		getSumpPumpLink().click();
	}
	
	public void clickMiscellaneousLink(){
		getMiscellaneousLink().click();
	}
	//WebMethods End
	
	
	//WebElement getters -- START
	public static WebElement getBuildingLink(){
		return homeFactory.get_homeBuildingImageLink();
	}
	
	public static WebElement getAHULink(){
		return homeFactory.get_homeAHULink();
	}
	
	public static WebElement getVAVLink(){
		return homeFactory.get_homeVAVImageLink();
	}
	
	public static WebElement getPAULink(){
		return homeFactory.get_homePAUImageLink();
	}
	
	public static WebElement getFCULink(){
		return homeFactory.get_homeFCUImageLink();
	}
	
	public static WebElement getACPlantLink(){
		return homeFactory.get_homeACPlantImageLink();
	}
	
	public static WebElement getBoilerLink(){
		return homeFactory.get_homeBoilerImageLink();
	}
	
	public static WebElement getExhaustFanLink(){
		return homeFactory.get_homeExhaustFanImageLink();
	}
	
	public static WebElement getSumpPumpLink(){
		return homeFactory.get_homeSumpPumpImageLink();
	}
	
	public static WebElement getMiscellaneousLink(){
		return homeFactory.get_homeMiscellaneousImageLink();
	}
	
	public static WebElement getVersionElement(){
		return homeFactory.get_homeProductVersionText();
	}
	
	private static WebElement getCopyRightElement(){
		return homeFactory.get_homeCopyRightInfo();
	}
	
	//WebElement getters -- END
	

}
