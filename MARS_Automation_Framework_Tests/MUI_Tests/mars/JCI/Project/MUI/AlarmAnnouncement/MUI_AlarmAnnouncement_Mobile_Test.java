package mars.JCI.Project.MUI.AlarmAnnouncement;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import mars.JCI.Project.MUI.Home.*;
import mars.JCI.Project.MUI.Login.MUI_Login_Page_Action;
import mars.JCI.Project.MUI.AlarmAnnouncement.MUI_AlarmAnnouncement_Mobile_Page_Action;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import mars.Component.Functions.BaseClass;

public class MUI_AlarmAnnouncement_Mobile_Test extends BaseClass{
	
//	MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);	
//	MUI_Home_Page_Action homePA;
//	MUI_AlarmAnnouncement_Mobile_Page_Action alarmAnnouncementPA = new MUI_AlarmAnnouncement_Mobile_Page_Action(driver, logger);	
	
	// Test Cases for Alarm Bell functionality
	
	/**
	 * Test Alarm List under Most Recent tab displayed.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    @Test(priority=0, description="Alarm Announcement - Check the Alarm List under Most Recent tab is displayed")
	public void testMostRecentAlarmListDisplayed() throws IOException {
    	try {
    		MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
    		MUI_Home_Page_Action homePA = loginPA.correctLogin("metasyssysagent", "B5F4soft!");
    		Thread.sleep(3000);
    		MUI_AlarmAnnouncement_Mobile_Page_Action alarmAnnouncementPA = new MUI_AlarmAnnouncement_Mobile_Page_Action(driver, logger);
			boolean most_recent_alarm_list_displayed = alarmAnnouncementPA.verifyWorkflowMostRecentAlarmListDisplayed();
			getFinalReport(driver, logger, methodName ,	most_recent_alarm_list_displayed);
		} catch (Exception e) {
			System.out.println(e);
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	/**
	 * Test Alarm List under Priority tab displayed.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    @Test(priority=1, description="Alarm Announcement - Check the Alarm List under Priority tab is displayed")
	public void testPriorityAlarmListDisplayed() throws IOException {
    	try {
    		MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
    		MUI_Home_Page_Action homePA = loginPA.correctLogin("metasyssysagent", "B5F4soft!");
    		Thread.sleep(3000);
    		MUI_AlarmAnnouncement_Mobile_Page_Action alarmAnnouncementPA = new MUI_AlarmAnnouncement_Mobile_Page_Action(driver, logger);
			boolean priority_alarm_list_displayed = alarmAnnouncementPA.verifyWorkflowPriorityAlarmListDisplayed();
			getFinalReport(driver, logger, methodName ,	priority_alarm_list_displayed);
		} catch (Exception e) {
			System.out.println(e);
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	
	
	/**
	 * Test point Alarm Details are displayed.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    @Test(priority=2, description="Alarm Announcement - Check point Alarm Details View displayed")
	public void testPointAlarmDetailsDisplayed() throws IOException {
    	try {
    		MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
    		MUI_Home_Page_Action homePA = loginPA.correctLogin("metasyssysagent", "B5F4soft!");
    		Thread.sleep(3000);
    		MUI_AlarmAnnouncement_Mobile_Page_Action alarmAnnouncementPA = new MUI_AlarmAnnouncement_Mobile_Page_Action(driver, logger);
			boolean pt_alarm_details_displayed = alarmAnnouncementPA.verifyWorkflowPointAlarmDetailsDisplayed();
			getFinalReport(driver, logger, methodName ,	pt_alarm_details_displayed);
		} catch (Exception e) {
			System.out.println(e);
			getFinalReport(driver, logger, methodName ,	false);
		}
	}

	
	/**
	 * Test point Acknowledge Alarm functionality.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    @Test(priority=3, description="Alarm Announcement - Check Acknowledge Alarm functionality.")
	public void testPointAckAlarmFunctionality() throws IOException {
    	try {
    		MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
    		MUI_Home_Page_Action homePA = loginPA.correctLogin("metasyssysagent", "B5F4soft!");
    		Thread.sleep(3000);
    		MUI_AlarmAnnouncement_Mobile_Page_Action alarmAnnouncementPA = new MUI_AlarmAnnouncement_Mobile_Page_Action(driver, logger);
			boolean pt_alarm_details_displayed = alarmAnnouncementPA.verifyWorkflowAckAlarmFunctionality();
			getFinalReport(driver, logger, methodName ,	pt_alarm_details_displayed);
		} catch (Exception e) {
			System.out.println(e);
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	

	/**
	 * Test point Discard Alarm functionality.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    @Test(priority=4, description="Alarm Announcement - Check Discard Alarm functionality.")
	public void testPointDiscardAlarmFunctionality() throws IOException {
    	try {
    		MUI_Login_Page_Action loginPA = new MUI_Login_Page_Action(driver, logger);
    		MUI_Home_Page_Action homePA = loginPA.correctLogin("metasyssysagent", "B5F4soft!");
    		Thread.sleep(3000);
    		MUI_AlarmAnnouncement_Mobile_Page_Action alarmAnnouncementPA = new MUI_AlarmAnnouncement_Mobile_Page_Action(driver, logger);	
			boolean pt_alarm_details_displayed = alarmAnnouncementPA.verifyWorkflowDiscardAlarmFunctionality();
			getFinalReport(driver, logger, methodName ,	pt_alarm_details_displayed);
		} catch (Exception e) {
			System.out.println(e);
			getFinalReport(driver, logger, methodName ,	false);
		}
	}
	
    
//  @Test
//  public void testMobileAlarmAnnouncement() throws MalformedURLException, InterruptedException{
//
//		try{
//		DesiredCapabilities capabilities = DesiredCapabilities.android();
//
//		capabilities.setCapability("chromedriverExecutable", "C:\\apps\\Selenium\\chromedriver.exe");
//		
//		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
//		
//		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
//		
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//
//		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "33006f8b560fa2dd");//33006f8b560fa2dd
//		
//		capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
//		
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		WebDriver driver = new AndroidDriver(url, capabilities);
//
//		//logger.log(LogStatus.PASS, this.getClass().getSimpleName() + " Test Satrted! -- ");
//		driver.get("https://10.10.87.230/UI");
//		
//		Thread.sleep(4000);
//		
//		driver.findElement(By.cssSelector("input[id='UserNameClone0']")).sendKeys("metasyssysagent");
//		
//		
//		driver.findElement(By.cssSelector("input[name='Password']")).sendKeys("B5F4soft!");
//
//		
//		driver.findElement(By.cssSelector("button[test-id='login-btn']")).click();
//
//		Thread.sleep(4000);
//
//		
//		
//		
//		
//		//Locate Alarm Bell on MUI
//		WebElement alarm_bell = driver.findElement(By.cssSelector("section[class='alarm-bell ng-scope']"));
//		
//		//Verify Alarm Bell is displayed
//		if (alarm_bell.isDisplayed()){
//			System.out.println("Alarm Bell is displayed");
//			logger.log(LogStatus.PASS,"Alarm Bell is displayed");
//		}
//
////		//Locate Alarm Bell on MUI
////		WebElement alarm_bell_indicator = alarm_bell.findElement(By.cssSelector("span[class='alarm-count']"));
////		//Verify Alarm Bell visual indication is displayed
////		if (alarm_bell_indicator.isDisplayed()){
////			System.out.println("Alarm Bell visual indication is displayed");
////		}
//		
//		
//		
//		//Click the Alarm Bell
//		alarm_bell.click(); 			System.out.println("Alarm Bell is clicked");
//		
//		Thread.sleep(4000);
//
//		//Locate Alarm Popup on MUI
//		WebElement alarm_popup = driver.findElement(By.cssSelector("div[class='modal-popover-inner']"));
//
//
//		//Verify Alarm Popup is displayed
//		if (alarm_popup.isDisplayed()){
//			System.out.println("Alarm Popup is displayed");
//		}
//
//
//		
//		//Locate Alarm Popup Title on MUI
//		WebElement alarm_popup_title = alarm_popup.findElement(By.cssSelector("h3[class='modal-popover-title']"));
//
//		//Verify Alarm Popup Title is displayed
//		if (alarm_popup_title.isDisplayed()){
//			System.out.println("Alarm Popup Title is displayed");
//		}
//		//Get actual title
//		String actual_title = alarm_popup_title.getText();
//
//		if (actual_title.equals("PENDING ALARMS")){
//			System.out.println("Alarm Popup EXPECTED TITLE: PENDING ALARMS  is successfully matched with "
//					+ " ACTUAL TITLE: " + actual_title);
//		}
//		
//		Thread.sleep(4000);
//
//
//		//Locate Alarm Popup Most Recent alarm tab on MUI
//		WebElement most_recent_tab_alarm = alarm_popup.findElement(By.partialLinkText("Most Recent"));
//
//		//Verify Alarm Popup Most Recent alarm tab is displayed
//		if (most_recent_tab_alarm.isDisplayed()){
//			System.out.println("Alarm Popup Most Recent alarm tab is displayed");
//		}
//		
//		String tab_status = most_recent_tab_alarm.getAttribute("class");
//		if (tab_status.equals("selected")){
//			System.out.println("Most Recent alarm tab is selected.");
//		}
//
//		//Locate Alarm Popup Most Recent alarm tab list of points
//		List<WebElement>  most_recent_point_list = alarm_popup.findElements(By.cssSelector("li[data-ng-repeat='point in date.AlarmResults']"));
//		int most_recent_element_count = most_recent_point_list.size();
//		System.out.println("Elements located under most recent tab is: " + most_recent_element_count);
//		for (WebElement point : most_recent_point_list){
//		//Verify point is displayed
//		if (point.isDisplayed()){
//			WebElement pt_short_name = point.findElement(By.cssSelector("small[class='pull-right text-right shortname']"));
//			WebElement pt_eq_name = point.findElement(By.cssSelector("span[once-text='point.ConcatenatedEquipmentName']"));
//
//			System.out.println("Alarm for POINT: "+ pt_short_name.getText() + " of EQUIPMENT: "
//					+ pt_eq_name.getText() + " is displayed under Most Recent tab.");
//
//		}
//		}
//
//		//Locate Alarm Popup Most Recent alarm tab on MUI
//		WebElement priority_tab_alarm = alarm_popup.findElement(By.linkText("Priority"));
//
//		//Verify Alarm Popup Most Recent alarm tab is displayed
//		if (priority_tab_alarm.isDisplayed()){
//			System.out.println("Alarm Popup Priority alarm tab is displayed");
//		}
//
//		//Click the Priority tab
//		priority_tab_alarm.click(); 			System.out.println("Priority tab is clicked");
//
//		
//		Thread.sleep(4000);
//
//
//		//Locate Alarm Popup Priority alarm tab list of points
//		List<WebElement>  priority_point_list = alarm_popup.findElements(By.cssSelector("li[data-ng-repeat='point in priorityList']")); 
//		int priority_element_count = priority_point_list.size();
//		System.out.println("Elements located under priority tab is: " + priority_element_count);
//		for (WebElement point : priority_point_list){
//		//Verify point is displayed
//		if (point.isDisplayed()){
//			WebElement pt_short_name = point.findElement(By.cssSelector("small[class='pull-right text-right shortname']"));
//			WebElement pt_eq_name = point.findElement(By.cssSelector("span[once-text='point.ConcatenatedEquipmentName']"));
//			WebElement pt_priority = point.findElement(By.cssSelector("small[class='pull-right text-right ng-binding']"));
//			
//			System.out.println(pt_priority.getText());
//			
//			System.out.println("Alarm for POINT: "+ pt_short_name.getText() + " of EQUIPMENT: "
//					+ pt_eq_name.getText() + " is displayed under Priority tab.");
//		}
//		}
//		
//
//		//Locate any Alarm Popup Priority first point
//		WebElement  priority_first_point = alarm_popup.findElement(By.cssSelector("li[data-ng-repeat='point in priorityList']")); 
//		// Click the first point alarm
//		priority_first_point.click();  System.out.println("Alarm point is clicked");
//
//		//Locate any Alarm Details slide in
//		WebElement  alarm_details_view = alarm_popup.findElement(By.cssSelector("div[class='alarm-details-current-info-view']")); 
//
//		//Verify alarm details slide in is displayed
//		if (alarm_details_view.isDisplayed()){
//			System.out.println("Alarm details are displayed");
//		}		
//
//		
//		//Locate alarm point short name
//		WebElement pt_short_name_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_ShortName']"));
//		WebElement pt_short_name = alarm_details_view.findElement(By.cssSelector("span[class='span-inline-block ng-binding']"));
//		
//		System.out.println(pt_short_name_label.getText() + pt_short_name.getText());
//		
//		//Locate alarm point priority
//		WebElement pt_priority_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_Priority']"));
//		WebElement pt_priority = alarm_details_view.findElement(By.cssSelector("dd[class='ng-binding']"));
//		
//		System.out.println(pt_priority_label.getText() + pt_priority.getText());
//
//		//Locate alarm type for point
//		WebElement pt_alarm_type_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_Type']"));
//		WebElement pt_alarm_type = alarm_details_view.findElement(By.xpath("//dd[contains(text(),'Alarm')]"));
//		
//		System.out.println(pt_alarm_type_label.getText() + pt_alarm_type.getText());
//
//		//Locate alarm point equipment
//		WebElement pt_alarm_eq_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_Equipment']"));
//		WebElement pt_alarm_eq = alarm_details_view.findElement(By.linkText("20 - All Point Types (FEC2621)"));
//		
//		System.out.println(pt_alarm_eq_label.getText() + pt_alarm_eq.getText());
//		
//
////		//Locate alarm point High Alarm Limit
////		WebElement pt_high_alarm_limit_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='HighAlarmLimit']"));
////		WebElement pt_high_alarm_limit = alarm_details_view.findElement(By.xpath("//dd[contains(text(),'100')]"));
////		
////		System.out.println(pt_high_alarm_limit_label.getText() + pt_high_alarm_limit.getText());
////		
////		
////		//Locate alarm point Low Alarm Limit
////		WebElement pt_low_alarm_limit_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='LowAlarmLimit']"));
////		WebElement pt_low_alarm_limit = alarm_details_view.findElement(By.xpath("//dd[contains(text(),'20')]"));
////		
////		System.out.println(pt_low_alarm_limit_label.getText() + pt_low_alarm_limit.getText());
//
//
////		//Locate alarm point Trigger value
////		WebElement pt_alarm_trigger_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_TriggerValue']"));
////		WebElement pt_alarm_trigger = alarm_details_view.findElement(By.xpath("//dd[contains(text(),'5.0')]"));
////		
////		System.out.println(pt_alarm_trigger_label.getText() + pt_alarm_trigger.getText());
//
//
//		//Locate alarm point Occurred
//		WebElement pt_alarm_occured_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_Occurred']"));
//		WebElement pt_alarm_occured = alarm_details_view.findElement(By.xpath("//dd[contains(text(),'2017')]"));
//		
//		System.out.println(pt_alarm_occured_label.getText() + pt_alarm_occured.getText());
//
//
//		//Locate alarm point Trigger value
//		WebElement pt_alarm_message_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_MessageText']"));
//		
//		System.out.println(pt_alarm_message_label.getText() + pt_alarm_occured.getText());
//
//
//
//		//Locate alarm point Trigger value
//		WebElement pt_alarm_annotation_label = alarm_details_view.findElement(By.cssSelector("dt[data-bas-translate='Label_AnnotationText']"));
//		WebElement pt_alarm_annotation = alarm_details_view.findElement(By.linkText("Annotations"));
//		
//		System.out.println(pt_alarm_annotation_label.getText() + pt_alarm_annotation.getText());
//
//		//Locate alarm point Acknowledge button
//		WebElement pt_alarm_ack_btn = alarm_details_view.findElement(By.cssSelector("a[ng-click='acknowledgeAlarm()']"));
//		//Verify Acknowledge button is displayed
//		if (pt_alarm_ack_btn.isDisplayed()){
//			
//			System.out.println("Acknowledge button is displayed");
//		}
//
//		//Locate alarm point Discard button
//		WebElement pt_alarm_discard_btn = alarm_details_view.findElement(By.cssSelector("a[ng-click='discardAlarm()']"));
//		//Verify Discard button is displayed
//		if (pt_alarm_discard_btn.isDisplayed()){
//			
//			System.out.println("Discard button is displayed");
//		}
//
//		
//
//		//Click Acknowledge button
//		pt_alarm_ack_btn.click();       System.out.println("Acknowledge button is clicked");
//		Thread.sleep(2000);
//		//Locate Alarm Popup Priority alarm tab list of points
//		List<WebElement>  priority_point_list_after_ack = alarm_popup.findElements(By.cssSelector("li[data-ng-repeat='point in priorityList']")); 
//		int priority_element_count_after_ack = priority_point_list_after_ack.size();
//
//		if (priority_element_count_after_ack == priority_element_count-1){
//			System.out.println("Alarm entry is removed from list");
//		}
//
//		
//		Thread.sleep(4000);
//
//		//Locate any Alarm Popup Priority first point
//		WebElement  priority_first_point_after_ack = alarm_popup.findElement(By.cssSelector("li[data-ng-repeat='point in priorityList']")); 
//		// Click the first point alarm
//		priority_first_point_after_ack.click();           System.out.println("Alarm point is clicked");
//		Thread.sleep(2000);
//		//Verify alarm details slide in is displayed
//		if (alarm_details_view.isDisplayed()){
//			System.out.println("Alarm details are displayed");
//		}		
//		
//		//Click Acknowledge button
//		pt_alarm_discard_btn.click();       System.out.println("Discard button is clicked");
//		
//		Thread.sleep(2000);
//		//Locate Alarm Popup Priority alarm tab list of points
//		List<WebElement>  priority_point_list_after_discard = alarm_popup.findElements(By.cssSelector("li[data-ng-repeat='point in priorityList']")); 
//		int priority_element_count_after_discard = priority_point_list_after_discard.size();
//
//		if (priority_element_count_after_discard == priority_element_count_after_ack-1){
//			System.out.println("Alarm entry is removed from list");
//		}
//		
//		
//		Thread.sleep(4000);
//		
//		
//		//driver.close();
//		getFinalReport(driver, logger, methodName ,	true);
//		} catch (Exception e) {
//			System.out.println(e);
//			getFinalReport(driver, logger, methodName ,	false);
//		}
//		
//	  
//	  
//  }

}
