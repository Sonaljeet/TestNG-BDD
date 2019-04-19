package mars.JCI.Project.MUI.AlarmAnnouncement;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.WebButton;
import commonFunctions.WebElementCommon;
import commonFunctions.WebInputTextBox;
import mars.Component.Functions.Common_Component_Functions;
import mars.JCI.Project.MUI.Home.*;
import mars.JCI.Project.MUI.AlarmAnnouncement.MUI_AlarmAnnouncement_Mobile_Page_Factory;


// TODO: Auto-generated Javadoc
/**
 * The Class MUI_AlarmAnnouncement_Page_Action.
 */
public class MUI_AlarmAnnouncement_Mobile_Page_Action {

	
	/** The Selenium driver. */
	public WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;
	
	/** The WebElement/Locator element. */
	private WebElement element;
	
	/** The WebElement/Locator list. */
	private List<WebElement> element_list;
	
	private By by;
	
	/**
	 * Instantiates/Constructor a new MUI login page action.
	 *
	 * @param driver the driver
	 * @param logger the logger
	 */

	public MUI_AlarmAnnouncement_Mobile_Page_Action(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;

	}

	/** The alarm announcement PF. */
	MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);

	
	/**
	 * Verify on Alarm Popup under Most Recent tab, Alarm List displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyWorkflowMostRecentAlarmListDisplayed(){
		boolean flag = true;

		if (verifyAlarmBellDisplayed()==false) { flag = false; }
		if (verifyAlarmBellClicked()==false) { flag = false; }
		if (verifyAlarmPopupDisplayed()==false) { flag = false; }
		if (verifyAlarmTitleDisplayed()==false) { flag = false; }
		if (verifyAlarmTitleMatchExpected()==false) { flag = false; }
		if (verifyAlarmMostRecentTabDisplayed()==false) { flag = false; }
		if (verifyAlarmMostRecentTabSelected()==false) { flag = false; }
		if (verifyMostRecentPointListDisplayed()==false) { flag = false; }
				
		return flag;
	}
	
	
	/**
	 * Verify on Alarm Popup under Priority tab, Alarm List displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyWorkflowPriorityAlarmListDisplayed(){
		boolean flag = true;

		if (verifyAlarmBellDisplayed()==false) { flag = false; }
		if (verifyAlarmBellClicked()==false) { flag = false; }
		if (verifyAlarmPopupDisplayed()==false) { flag = false; }
		if (verifyAlarmPriorityTabDisplayed()==false) { flag = false; }
		if (verifyAlarmPriorityTabClicked()==false) { flag = false; }
		if (verifyAlarmPriorityTabSelected()==false) { flag = false; }
		if (verifyPriorityPointListDisplayed()==false) { flag = false; }
				
		return flag;
	}

	/**
	 * Verify for point, Alarm Details are displayed.
	 *
	 * @return true, if successful
	 * @throws InterruptedException 
	 */
	public boolean verifyWorkflowPointAlarmDetailsDisplayed() throws InterruptedException{
		boolean flag = true;
		
		Thread.sleep(2000);
		if (verifyAlarmBellClicked()==false) { flag = false; }
		if (verifyAlarmPriorityTabClicked()==false) { flag = false; }
		if (verifyAlarmPriorityFirstPointClicked()==false) { flag = false; }
		Thread.sleep(2000);
		if (verifyAlarmDetailsViewDisplayed()==false) { flag = false; }
		if (verifyDetailsPointShortNameLabelDisplayed()==false) { flag = false; }
		if (verifyDetailsPointShortNameDisplayed()==false) { flag = false; }
		if (verifyDetailsPointPriorityLabelDisplayed()==false) { flag = false; }
		if (verifyDetailsPointPriorityDisplayed()==false) { flag = false; }
		if (verifyDetailsPointEquipmentLabelDisplayed()==false) { flag = false; }
		if (verifyDetailsPointEquipmentDisplayed()==false) { flag = false; }
		if (verifyDetailsPointOccurredLabelDisplayed()==false) { flag = false; }
		if (verifyDetailsPointOccurredDisplayed()==false) { flag = false; }
		if (verifyDetailsPointAnnotationLabelDisplayed()==false) { flag = false; }
		if (verifyDetailsPointAnnotationDisplayed()==false) { flag = false; }
		if (verifyDetailsPointAckBtnDisplayed()==false) { flag = false; }
		if (verifyDetailsPointDiscardBtnDisplayed()==false) { flag = false; }		
		
		return flag;
	}

	/**
	 * Verify Acknowledge button functionality.
	 *
	 * @return true, if successful
	 * @throws InterruptedException 
	 */
	public boolean verifyWorkflowAckAlarmFunctionality() throws InterruptedException{
		boolean flag = true;
		Thread.sleep(2000);
		if (verifyAlarmBellClicked()==false) { flag = false; }
		if (verifyAlarmPriorityTabClicked()==false) { flag = false; }
		Thread.sleep(2000);
		if (verifyPriorityPointListCount()==false) { flag = false; }
		if (verifyAlarmPriorityFirstPointClicked()==false) { flag = false; }
		Thread.sleep(2000);
		if (verifyDetailsPointAckBtnClicked()==false) { flag = false; }
		Thread.sleep(3000);
		if (verifyPriorityPointListCount()==false) { flag = false; }
		
		return flag;
	}


	/**
	 * Verify Discard button functionality.
	 *
	 * @return true, if successful
	 * @throws InterruptedException 
	 */
	public boolean verifyWorkflowDiscardAlarmFunctionality() throws InterruptedException{
		boolean flag = true;
		Thread.sleep(2000);
		if (verifyAlarmBellClicked()==false) { flag = false; }
		if (verifyAlarmPriorityTabClicked()==false) { flag = false; }
		Thread.sleep(2000);
		if (verifyPriorityPointListCount()==false) { flag = false; }
		if (verifyAlarmPriorityFirstPointClicked()==false) { flag = false; }
		Thread.sleep(2000);
		if (verifyDetailsPointDiscardBtnClicked()==false) { flag = false; }
		Thread.sleep(3000);
		if (verifyPriorityPointListCount()==false) { flag = false; }
		
		return flag;
	}
	
	
	/**
	 * Verify Alarm Bell displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmBellDisplayed(){
		boolean alarm_bell_displayed = false;		
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmBell();   //driver.findElement(By.cssSelector("section[class=\"alarm-bell ng-scope\"]"));
		try {
			if(element!= null){
				if(element.isDisplayed()){
					alarm_bell_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Bell IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Bell is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Bell Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return alarm_bell_displayed;
	}

	/**
	 * Verify Alarm Bell clicked.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmBellClicked(){
		boolean alarm_bell_clicked = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmBell();
		try {
			if(element!= null){
				    WebButton.Button_Click(driver, element);
					alarm_bell_clicked = true;
					logger.log(LogStatus.PASS, "Alarm Bell IS clicked.");
				}
			else{
				logger.log(LogStatus.FAIL, " Alarm Bell Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return alarm_bell_clicked;
	}
	
	/**
	 * Verify Alarm Popup displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmPopupDisplayed(){
		boolean alarm_popup_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmPopup();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					alarm_popup_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Popup IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Popup is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Popup Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return alarm_popup_displayed;
	}

	/**
	 * Verify Alarm Popup Title displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmTitleDisplayed(){
		boolean alarm_popup_title_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmPopupTitle();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					alarm_popup_title_displayed = true;
					logger.log(LogStatus.PASS, "Alarm popup Title IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm popup Title is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm popup Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return alarm_popup_title_displayed;
	}

	/**
	 * Verify Alarm popup Title match expected.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmTitleMatchExpected(){
		boolean alarm_popup_title_match_expected = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmPopupTitle();
		try {
			if(element!= null){
				String actual_title = element.getText();
				if(actual_title.equals("PENDING ALARMS")){
					alarm_popup_title_match_expected = true;
					logger.log(LogStatus.PASS, "Alarm popup ACTUAL TITLE: " + actual_title + 
							" IS matched with expected title.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm popup actual title is NOT matched with expected title.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm popup title Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return alarm_popup_title_match_expected;
	}

	
	/**
	 * Verify Alarm Popup Most Recent tab displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmMostRecentTabDisplayed(){

		boolean most_recent_tab_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmMostRecentTab();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					most_recent_tab_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Most Recent tab IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Most Recent tab is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Most Recent tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return most_recent_tab_displayed;
	}

	/**
	 * Verify Alarm Popup Most Recent tab clicked.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmMostRecentTabClicked(){

		boolean most_recent_tab_clicked = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getAlarmMostRecentTab();
		try {
			if(element!= null){
				    WebButton.Button_Click(driver, element);
					most_recent_tab_clicked = true;
					logger.log(LogStatus.PASS, "Alarm Most Recent tab IS clicked.");
				}
			else{
				logger.log(LogStatus.FAIL, " Alarm Most Recent tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return most_recent_tab_clicked;
	}

	
	/**
	 * Verify Alarm Popup Most Recent tab selected.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmMostRecentTabSelected(){

		boolean most_recent_tab_selected = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmMostRecentTab();
		try {
			if(element!= null){
				String tab_status = element.getAttribute("class");
				if(tab_status.equals("selected")){
					most_recent_tab_selected = true;
					logger.log(LogStatus.PASS, "Most Recent alarm tab IS selected.");
				}
				else{
					logger.log(LogStatus.FAIL, " Most Recent alarm tab is NOT selected.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Most Recent tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return most_recent_tab_selected;
	}

	/**
	 * Verify Most Recent point list displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyMostRecentPointListDisplayed(){

		boolean most_recent_pt_list_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element_list = alarmAnnouncementPF.getMostRecentPointList();
		try {
			if(element_list!= null){
				for (WebElement point : element_list){
				
				if(point.isDisplayed()){ 

					WebElement pt_short_name = alarmAnnouncementPF.getAlarmPointShortName(point);
					WebElement pt_eq_name = alarmAnnouncementPF.getAlarmPointEqName(point); 
					
					most_recent_pt_list_displayed = true;
					logger.log(LogStatus.PASS, "Alarm for POINT: "+ pt_short_name.getText() + " of EQUIPMENT: "
					+ pt_eq_name.getText() + " IS displayed under Most Recent tab..");
				}
				else{
					logger.log(LogStatus.FAIL, " Most Recent alarm is NOT displayed.");
				}
			} }
			else{
				logger.log(LogStatus.FAIL, " Alarm Most Recent tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return most_recent_pt_list_displayed;
	}

	/**
	 * Verify Most Recent point list count.
	 *
	 * @return true, if successful
	 */
	public boolean verifyMostRecentPointListCount(){

		boolean list_count_calculated = false;
		int list_count = 0;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element_list = alarmAnnouncementPF.getMostRecentPointList();
		try {
			if(element_list!= null){
				    list_count = element_list.size();
				    list_count_calculated = true;
					logger.log(LogStatus.PASS, "Most Recent point list count is: " + list_count);
				}
			else{
				logger.log(LogStatus.FAIL, " Most Recent point list Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return list_count_calculated;
	}

	
	/**
	 * Verify Alarm Popup Priority tab displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmPriorityTabDisplayed(){

		boolean priority_tab_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getAlarmPriorityTab();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					priority_tab_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Priority tab IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Priority tab is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Priority tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return priority_tab_displayed;
	}

	/**
	 * Verify Alarm Popup Priority tab clicked.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmPriorityTabClicked(){

		boolean priority_tab_clicked = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getAlarmPriorityTab();
		try {
			if(element!= null){
				    WebButton.Button_Click(driver, element);
					priority_tab_clicked = true;
					logger.log(LogStatus.PASS, "Alarm Priority tab IS clicked.");				
				}
			else{
				logger.log(LogStatus.FAIL, " Alarm Priority tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return priority_tab_clicked;
	}

	
	/**
	 * Verify Alarm Popup Priority tab selected.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmPriorityTabSelected(){

		boolean priority_tab_selected = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getAlarmPriorityTab();
		try {
			if(element!= null){
				String tab_status = element.getAttribute("class");
				if(tab_status.equals("selected")){
					priority_tab_selected = true;
					logger.log(LogStatus.PASS, "Priority alarm tab IS selected.");
				}
				else{
					logger.log(LogStatus.FAIL, " Priority alarm tab is NOT selected.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Priority tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return priority_tab_selected;
	}


	
	/**
	 * Verify Priority point list displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyPriorityPointListDisplayed(){

		boolean priority_pt_list_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element_list = alarmAnnouncementPF.getPriorityPointList();
		try {
			if(element_list!= null){
				for (WebElement point : element_list){
				
				if(point.isDisplayed()){ 

					WebElement pt_short_name = alarmAnnouncementPF.getAlarmPointShortName(point);
					WebElement pt_eq_name = alarmAnnouncementPF.getAlarmPointEqName(point); 
					
					priority_pt_list_displayed = true;
					logger.log(LogStatus.PASS, "Alarm for POINT: "+ pt_short_name.getText() + " of EQUIPMENT: "
					+ pt_eq_name.getText() + " IS displayed under Priority tab..");
				}
				else{
					logger.log(LogStatus.FAIL, " Priority alarm is NOT displayed.");
				}
			} }
			else{
				logger.log(LogStatus.FAIL, " Priority Recent tab Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return priority_pt_list_displayed;
	}

	/**
	 * Verify Priority point list count.
	 *
	 * @return true, if successful
	 */
	public boolean verifyPriorityPointListCount(){

		boolean list_count_calculated = false;
		int list_count = 0;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element_list = alarmAnnouncementPF.getPriorityPointList();
		try {
			if(element_list!= null){
				    list_count = element_list.size();
				    list_count_calculated = true;
					logger.log(LogStatus.PASS, "Priority point list count is: " + list_count);
				}
			else{
				logger.log(LogStatus.FAIL, " Priority point list Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return list_count_calculated;
	}


	
	/**
	 * Verify Alarm Popup Priority first point clicked.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmPriorityFirstPointClicked(){

		boolean priority_first_pt_clicked = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getAlarmPriorityFirstPoint();
		try {
			if(element!= null){
				    WebButton.Button_Click(driver, element);
					priority_first_pt_clicked = true;
					logger.log(LogStatus.PASS, "Alarm Priority First point IS clicked.");				
				}
			else{
				logger.log(LogStatus.FAIL, " Alarm Priority First point Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return priority_first_pt_clicked;
	}


	/**
	 * Verify Alarm Details View for point displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyAlarmDetailsViewDisplayed(){

		boolean alarm_details_view_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getAlarmDetailsView();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					alarm_details_view_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return alarm_details_view_displayed;
	}
	

	/**
	 * Verify Alarm Details View point short name label displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointShortNameLabelDisplayed(){

		boolean pt_short_name_label_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointShortNameLabel();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_short_name_label_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point short name Label: "+
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point short name Label is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point short name Label Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_short_name_label_displayed;
	}

	/**
	 * Verify Alarm Details View point short name displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointShortNameDisplayed(){

		boolean pt_short_name_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointShortName();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_short_name_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point short name: " + 
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point short name is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point short name Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_short_name_displayed;
	}

	/**
	 * Verify Alarm Details View point Priority label displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointPriorityLabelDisplayed(){

		boolean pt_priority_label_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointPriorityLabel();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_priority_label_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Priority Label: " +
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Priority Label is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Priority Label Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_priority_label_displayed;
	}

	/**
	 * Verify Alarm Details View point Priority displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointPriorityDisplayed(){

		boolean pt_priority_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointPriority();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_priority_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Priority: " + 
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Priority is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Priority Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_priority_displayed;
	}
	
	/**
	 * Verify Alarm Details View point Equipment label displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointEquipmentLabelDisplayed(){

		boolean pt_eq_label_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointEquipmentLabel();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_eq_label_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Equipment Label: " +
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Equipment Label is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Equipment Label Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_eq_label_displayed;
	}

	/**
	 * Verify Alarm Details View point Equipment displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointEquipmentDisplayed(){

		boolean pt_eq_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointEquipment();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_eq_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Equipment: " + 
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Equipment is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Equipment Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_eq_displayed;
	}

	/**
	 * Verify Alarm Details View point Occurred label displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointOccurredLabelDisplayed(){

		boolean pt_occured_label_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointOccurredLabel();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_occured_label_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Occured Label: " + 
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Occured Label is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Occured Label Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_occured_label_displayed;
	}

	/**
	 * Verify Alarm Details View point Occurred displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointOccurredDisplayed(){

		boolean pt_occurred_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointOccurred();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_occurred_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Occurred: " +
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Occurred is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Occurred Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_occurred_displayed;
	}

	/**
	 * Verify Alarm Details View point Annotation label displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointAnnotationLabelDisplayed(){

		boolean pt_annotation_label_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointAnnotationLabel();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_annotation_label_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Annotation Label: " + 
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Annotation Label is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Annotation Label Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_annotation_label_displayed;
	}

	/**
	 * Verify Alarm Details View point Annotation displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointAnnotationDisplayed(){

		boolean pt_annotation_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointAnnotation();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_annotation_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Annotation: " + 
					element.getText() + " IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Annotation is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Annotation Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_annotation_displayed;
	}
	
	
	/**
	 * Verify Alarm details view Acknowledge button displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointAckBtnDisplayed(){

		boolean pt_ack_btn_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getDetailsPointAckBtn();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_ack_btn_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Acknowledge button IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Acknowledge button is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Acknowledge button Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_ack_btn_displayed;
	}

	/**
	 * Verify Alarm details view Acknowledge button displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointAckBtnClicked(){

		boolean pt_ack_btn_clicked = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointAckBtn();
		try {
			if(element!= null){
				    WebButton.Button_Click(driver, element);
					pt_ack_btn_clicked = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Acknowledge button IS clicked.");
				}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Acknowledge button Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_ack_btn_clicked;
	}

	/**
	 * Verify Alarm details view Discard button displayed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointDiscardBtnDisplayed(){

		boolean pt_discard_btn_displayed = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);
		element = alarmAnnouncementPF.getDetailsPointDiscardBtn();
		try {
			if(element!= null){
				if(element.isDisplayed()){
					pt_discard_btn_displayed = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Discard button IS displayed.");
				}
				else{
					logger.log(LogStatus.FAIL, " Alarm Details View point Discard button is NOT displayed.");
				}
			}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Discard button Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_discard_btn_displayed;
	}

	/**
	 * Verify Alarm details view Discard button clicked.
	 *
	 * @return true, if successful
	 */
	public boolean verifyDetailsPointDiscardBtnClicked(){

		boolean pt_discard_btn_clicked = false;
		MUI_AlarmAnnouncement_Mobile_Page_Factory alarmAnnouncementPF = new MUI_AlarmAnnouncement_Mobile_Page_Factory(driver);		
		element = alarmAnnouncementPF.getDetailsPointAckBtn();
		try {
			if(element!= null){
				    WebButton.Button_Click(driver, element);
					pt_discard_btn_clicked = true;
					logger.log(LogStatus.PASS, "Alarm Details View point Discard button IS clicked.");
				}
			else{
				logger.log(LogStatus.FAIL, " Alarm Details View point Discard button Element returns NULL.");
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		} catch (Exception e) {
			logger.log(LogStatus.ERROR, this.getClass().getSimpleName() + " Failed! -- " +e.getMessage().substring(0, 90));
		}
		return pt_discard_btn_clicked;
	}

	
}
