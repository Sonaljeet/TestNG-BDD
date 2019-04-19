/**
 * 
 */
package mars.JCI.Project.CSD.Notification;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mars.Component.Functions.BaseClass;
import mars.JCI.Project.CSD.Login.CSD_Login_Page_Action;
import mars.JCI.Project.CSD.Functionality.Notification.CSD_NOTIF_ConfigureNotification_Page_Action;

/**
 * @author cdeyso
 * mars.JCI.Project.CSD.Notification.CSD_NOTIF_ConfigureNotification_Page_Test
 *
 */
public class CSD_NOTIF_ConfigureNotification_Page_Test extends BaseClass{

	
	@SuppressWarnings("static-access")
	@Parameters({"correctusername", "correctpassword" })
	@Test(priority=0,description = "Performs setting up Notifications For Existing Customere and Facility.")
	public void createSSFFunctionalityBranchUserExistingCustomer( String correctusername, String correctpassword){
		
		try {
			
			CSD_Login_Page_Action csd_login_page_action = new CSD_Login_Page_Action(driver, logger);
			csd_login_page_action.correctLogin(correctusername, correctpassword);
			CSD_NOTIF_ConfigureNotification_Page_Action csd_notif_page_Action = new CSD_NOTIF_ConfigureNotification_Page_Action(driver, logger);
			csd_notif_page_Action.clickOnConfigNotificationLink();
			csd_notif_page_Action.selectCustomerNameLink("FREDKIN BUSINESS SERVICES");
			csd_notif_page_Action.selectFacilityNameLink("FRIEDKIN BUSINESS SERVICE");
			csd_notif_page_Action.clickAlarmTypeLink();
			csd_notif_page_Action.clickSetNotificationCheckBox();
			csd_notif_page_Action.clickConfigureLink();
			csd_notif_page_Action.selectBranchUserCriticalAlarm();
			csd_notif_page_Action.selectNotifFrequencyCriticalAlarm();
			csd_notif_page_Action.selectNotifTypeSMSCriticalAlarm();
			csd_notif_page_Action.selectNotifTypeEMAILCriticalAlarm();
			csd_notif_page_Action.selectBranchUserHealthCheck();
			csd_notif_page_Action.selectNotifFreqHealthCheck();
			csd_notif_page_Action.selectNotifTypeSMSHealthCheck();
			csd_notif_page_Action.selectNotifTypeEMAILHealthCheck();
			csd_notif_page_Action.clickADDNotifDetailsButton();
			csd_notif_page_Action.checkNotificationTrue("update");		
			csd_notif_page_Action.checkNotificationTrue("delete");	
			csd_notif_page_Action.checkIfDeleteIsSuccessful();
			
			getFinalReport(driver, logger, methodName, true);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			getFinalReport(driver, logger, methodName, false);
		}
	}
}
