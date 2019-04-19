/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.JCI.Project.BCM.Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import commonFunctions.WebElementCommon;

public class BCM_Home_Page_Factory {

	private static WebDriver driver = null;
	private static ExtentTest logger = null;
	
	public BCM_Home_Page_Factory(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"buildingDisplay\"]/a")
	private WebElement homeBuildingImageLink;

	public WebElement get_homeBuildingImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeBuildingImageLink, logger) == true) {
			element = homeBuildingImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnAHU")
	private WebElement homeAHULink;

	public WebElement get_homeAHULink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeAHULink, logger) == true) {
			element = homeAHULink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnVAV")
	private WebElement homeVAVImageLink;

	public WebElement get_homeVAVImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeVAVImageLink, logger) == true) {
			element = homeVAVImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnPAU")
	private WebElement homePAUImageLink;

	public WebElement get_homePAUImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homePAUImageLink, logger) == true) {
			element = homePAUImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnFCU")
	private WebElement homeFCUImageLink;

	public WebElement get_homeFCUImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeFCUImageLink, logger) == true) {
			element = homeFCUImageLink;
		}
		return element;
	}
	//TODO change once id is corrected
	@FindBy(id = "ContentPlaceHolder1_ImgBtnChiler")
	private WebElement homeACPlantImageLink;

	public WebElement get_homeACPlantImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeACPlantImageLink, logger) == true) {
			element = homeACPlantImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnBoiler")
	private WebElement homeBoilerImageLink;

	public WebElement get_homeBoilerImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeBoilerImageLink, logger) == true) {
			element = homeBoilerImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnMisclaneous")
	private WebElement homeExhaustFanImageLink;

	public WebElement get_homeExhaustFanImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeExhaustFanImageLink, logger) == true) {
			element = homeExhaustFanImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnExhaustFan")
	private WebElement homeSumpPumpImageLink;

	public WebElement get_homeSumpPumpImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeSumpPumpImageLink, logger) == true) {
			element = homeSumpPumpImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_ImgBtnSumpPump")
	private WebElement homeMiscellaneousImageLink;

	public WebElement get_homeMiscellaneousImageLink() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeMiscellaneousImageLink, logger) == true) {
			element = homeMiscellaneousImageLink;
		}
		return element;
	}
	
	@FindBy(id = "ContentPlaceHolder1_lblProjectVersion")
	private WebElement homeProductVersionText;

	public WebElement get_homeProductVersionText() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeProductVersionText, logger) == true) {
			element = homeProductVersionText;
		}
		return element;
	}	
	
	@FindBy(id = "ContentPlaceHolder1_lblfooter")
	private WebElement homeCopyRightInfo;

	public WebElement get_homeCopyRightInfo() {
		WebElement element = null;
		if (WebElementCommon.waitForElementPresent(driver, homeCopyRightInfo, logger) == true) {
			element = homeCopyRightInfo;
		}
		return element;
	}
}
