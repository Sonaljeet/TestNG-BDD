package mars.JCI.Project.MUI.AlarmAnnouncement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating MUI_AlarmAnnouncement_Mobile_Page_ objects.
 */
public class MUI_AlarmAnnouncement_Mobile_Page_Factory {

	/** The Selenium driver. */
	private WebDriver driver;
	
	/** The ExtentTest logger. */
	private ExtentTest logger;

	/**
	 * Instantiates a new MU I alarm announcement mobile page factory.
	 *
	 * @param driver the driver
	 */
	public MUI_AlarmAnnouncement_Mobile_Page_Factory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** The MUI Alarm Bell WebElement. */
	@FindBy(css = "section[class='alarm-bell ng-scope']")  //i[class=\"fa fa-bell\"]
	WebElement alarm_bell;

	/**
	 * Gets the Alarm Bell.
	 *
	 * @return the Alarm Bell
	 */
	public WebElement getAlarmBell() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alarm_bell, logger)) {
			return this.alarm_bell;
		} else {
			return null;
		}

	}


	/** The MUI Alarm Bell Indicator WebElement. */
	@FindBy(css = "span[class='alarm-count']")
	WebElement alarm_bell_indicator;

	/**
	 * Gets the Alarm Bell Indicator.
	 *
	 * @return the Alarm Bell Indicator
	 */
	public WebElement getAlarmBellIndicator() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alarm_bell_indicator, logger)) {
			return this.alarm_bell_indicator;
		} else {
			return null;
		}

	}
	
	/** The MUI Alarm Popup WebElement. */
	@FindBy(css = "div[class='modal-popover-inner']")
	WebElement alarm_popup;

	/**
	 * Gets the Alarm Popup.
	 *
	 * @return the Alarm Popup
	 */
	public WebElement getAlarmPopup() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alarm_popup, logger)) {
			return this.alarm_popup;
		} else {
			return null;
		}

	}

	
	/** The MUI Alarm Popup Title WebElement. */
	@FindBy(css = "h3[class='modal-popover-title']")
	WebElement alarm_popup_title;

	/**
	 * Gets the Alarm Popup Title.
	 *
	 * @return the Alarm Popup Title
	 */
	public WebElement getAlarmPopupTitle() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alarm_popup_title, logger)) {
			return this.alarm_popup_title;
		} else {
			return null;
		}

	}


	/** The MUI Alarm Most Recent Tab WebElement. */
	@FindBy(partialLinkText = "Most Recent")
	WebElement alarm_most_recent_tab;

	/**
	 * Gets the Alarm Most Recent Tab.
	 *
	 * @return the Alarm Most Recent Tab
	 */
	public WebElement getAlarmMostRecentTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alarm_most_recent_tab, logger)) {
			return this.alarm_most_recent_tab;
		} else {
			return null;
		}

	}

	/** The MUI Alarm Priority Tab WebElement. */
	@FindBy(linkText = "Priority")
	WebElement alarm_priority_tab;

	/**
	 * Gets the Alarm Priority Tab.
	 *
	 * @return the Alarm Priority Tab
	 */
	public WebElement getAlarmPriorityTab() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alarm_priority_tab, logger)) {
			return this.alarm_priority_tab;
		} else {
			return null;
		}

	}



	/** The MUI Alarm Point list under Most Recent Tab WebElement. */
	@FindAll(@FindBy(css= "li[data-ng-repeat='point in date.AlarmResults']"))
	List<WebElement> most_recent_point_list;

	/**
	 * Gets the Alarm Point list under Most Recent Tab.
	 *
	 * @return the Alarm Point list under Most Recent Tab
	 */
	public List<WebElement> getMostRecentPointList() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, most_recent_point_list, logger)) {
			return this.most_recent_point_list;
		} else {
			return null;
		}

	}


	/** The MUI Alarm Point list under Priority Tab WebElement. */
	@FindAll(@FindBy(css= "li[data-ng-repeat='point in priorityList']"))
	List<WebElement> priority_point_list;

	/**
	 * Gets the Alarm Point list under Priority Tab.
	 *
	 * @return the Alarm Point list under Priority Tab
	 */
	public List<WebElement> getPriorityPointList() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, priority_point_list, logger)) {
			return this.priority_point_list;
		} else {
			return null;
		}

	}


	/** The MUI Point Short Name WebElement. */
	By pt_short_name = By.cssSelector("small[class='pull-right text-right shortname']");
	

	/**
	 * Gets the Point Short Name.
	 *
	 * @return the Point Short Name
	 */
	public WebElement getAlarmPointShortName(WebElement parentElement) {
		WebElement pt_short_name_element = commonFunctions.WebElementCommon.waitForElementPresent(driver, pt_short_name, parentElement, 10);
		if (pt_short_name_element != null)
		{
			return pt_short_name_element;
		} else {
			return null;
		}

	}


	/** The MUI Point Equipment Name WebElement. */
	By pt_eq_name = By.cssSelector("span[once-text='point.ConcatenatedEquipmentName']");


	/**
	 * Gets the Point Equipment Name.
	 *
	 * @return the Point Equipment Name
	 */
	public WebElement getAlarmPointEqName(WebElement parentElement) {
		WebElement pt_eq_name_element = commonFunctions.WebElementCommon.waitForElementPresent(driver, pt_eq_name, parentElement, 10);
		if (pt_eq_name_element != null){
			return pt_eq_name_element;
		} else {
			return null;
		}

	}

	/** The MUI Point Priority WebElement. */
	@FindBy(css = "small[class='pull-right text-right ng-binding']")
	WebElement pt_priority;

	/**
	 * Gets the Point Priority.
	 *
	 * @return the Point Priority
	 */
	public WebElement getAlarmPointPriority() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, pt_priority, logger)) {
			return this.pt_priority;
		} else {
			return null;
		}

	}

	/** The MUI Point Priority First WebElement. */
	@FindBy(css = "li[data-ng-repeat='point in priorityList']")
	WebElement priority_first_pt;

	/**
	 * Gets the Priority First Point.
	 *
	 * @return the Priority First Point
	 */
	public WebElement getAlarmPriorityFirstPoint() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, priority_first_pt, logger)) {
			return this.priority_first_pt;
		} else {
			return null;
		}

	}

	/** The MUI Point Alarm Details WebElement. */
	@FindBy(css = "div[class='alarm-details-current-info-view']")
	WebElement alarm_details_view;

	/**
	 * Gets the Point Alarm Details.
	 *
	 * @return the Point Alarm Details
	 */
	public WebElement getAlarmDetailsView() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, alarm_details_view, logger)) {
			return this.alarm_details_view;
		} else {
			return null;
		}

	}
	
	
	/** The MUI Alarm Details Point Short Name Label WebElement. */
	@FindBy(css = "dt[data-bas-translate='Label_ShortName']")
	WebElement details_pt_short_name_label;

	/**
	 * Gets the Alarm Details Point Short Name Label.
	 *
	 * @return the Alarm Details Point Short Name Label
	 */
	public WebElement getDetailsPointShortNameLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_short_name_label, logger)) {
			return this.details_pt_short_name_label;
		} else {
			return null;
		}

	}

	/** The MUI Alarm Details Point Short Name WebElement. */
	@FindBy(css = "span[class='span-inline-block ng-binding']")
	WebElement details_pt_short_name;

	/**
	 * Gets the Alarm Details Point Short Name.
	 *
	 * @return the Alarm Details Point Short Name
	 */
	public WebElement getDetailsPointShortName() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_short_name, logger)) {
			return this.details_pt_short_name;
		} else {
			return null;
		}

	}


	/** The MUI Alarm Details Point Priority Label WebElement. */
	@FindBy(css = "dt[data-bas-translate='Label_Priority']")
	WebElement details_pt_priority_label;

	/**
	 * Gets the Alarm Details Point Priority Label.
	 *
	 * @return the Alarm Details Point Priority Label
	 */
	public WebElement getDetailsPointPriorityLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_priority_label, logger)) {
			return this.details_pt_priority_label;
		} else {
			return null;
		}

	}

	/** The MUI Alarm Details Point Priority WebElement. */
	@FindBy(css = "dd[class='ng-binding']")
	WebElement details_pt_priority;

	/**
	 * Gets the Alarm Details Point Priority.
	 *
	 * @return the Alarm Details Point Priority
	 */
	public WebElement getDetailsPointPriority() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_priority, logger)) {
			return this.details_pt_priority;
		} else {
			return null;
		}

	}


	/** The MUI Alarm Details Point Alarm Type Label WebElement. */
	@FindBy(css = "dt[data-bas-translate='Label_Type']")
	WebElement details_pt_alarm_type_label;

	/**
	 * Gets the Alarm Details Point Alarm Type Label.
	 *
	 * @return the Alarm Details Point Alarm Type Label
	 */
	public WebElement getDetailsPointAlarmTypeLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_alarm_type_label, logger)) {
			return this.details_pt_alarm_type_label;
		} else {
			return null;
		}

	}

	/** The MUI Alarm Details Point Alarm Type WebElement. */
	@FindBy(xpath = "//dd[contains(text(),'Alarm')]")
	WebElement details_pt_alarm_type;

	/**
	 * Gets the Alarm Details Point Alarm Type.
	 *
	 * @return the Alarm Details Point Alarm Type
	 */
	public WebElement getDetailsPointAlarmType() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_alarm_type, logger)) {
			return this.details_pt_alarm_type;
		} else {
			return null;
		}

	}

	
	/** The MUI Alarm Details Point Equipment Label WebElement. */
	@FindBy(css = "dt[data-bas-translate='Label_Equipment']")
	WebElement details_pt_eq_label;

	/**
	 * Gets the Alarm Details Point Equipment.
	 *
	 * @return the Alarm Details Point Equipment
	 */
	public WebElement getDetailsPointEquipmentLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_eq_label, logger)) {
			return this.details_pt_eq_label;
		} else {
			return null;
		}

	}

	/** The MUI Alarm Details Point Alarm Type WebElement. */
	@FindBy(linkText = "20 - All Point Types (FEC2621)")
	WebElement details_pt_equipment;

	/**
	 * Gets the Alarm Details Point Alarm Type.
	 *
	 * @return the Alarm Details Point Alarm Type
	 */
	public WebElement getDetailsPointEquipment() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_equipment, logger)) {
			return this.details_pt_equipment;
		} else {
			return null;
		}
	}

	
	/** The MUI Alarm Details Point Occurred Label WebElement. */
	@FindBy(css = "dt[data-bas-translate='Label_Occurred']")
	WebElement details_pt_occurred_label;

	/**
	 * Gets the Alarm Details Point Equipment.
	 *
	 * @return the Alarm Details Point Equipment
	 */
	public WebElement getDetailsPointOccurredLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_occurred_label, logger)) {
			return this.details_pt_occurred_label;
		} else {
			return null;
		}
	}


	/** The MUI Alarm Details Point Occurred WebElement. */
	@FindBy(xpath = "//dd[contains(text(),'2017')]")
	WebElement details_pt_occurred;
	/**
	 * Gets the Alarm Details Point Occurred.
	 *
	 * @return the Alarm Details Point Occurred
	 */
	public WebElement getDetailsPointOccurred() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_occurred, logger)) {
			return this.details_pt_occurred;
		} else {
			return null;
		}
	}

	
	/** The MUI Alarm Details Point Message Label WebElement. */
	@FindBy(css = "dt[data-bas-translate='Label_MessageText']")
	WebElement details_pt_msg_label;

	/**
	 * Gets the Alarm Details Point Message Label.
	 *
	 * @return the Alarm Details Point Message Label
	 */
	public WebElement getDetailsPointMsgLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_msg_label, logger)) {
			return this.details_pt_msg_label;
		} else {
			return null;
		}
	}

	/** The MUI Alarm Details Point Annotation Label WebElement. */
	@FindBy(css = "dt[data-bas-translate='Label_AnnotationText']")
	WebElement details_pt_annotation_label;

	/**
	 * Gets the Alarm Details Point Annotation Label.
	 *
	 * @return the Alarm Details Point Annotation Label
	 */
	public WebElement getDetailsPointAnnotationLabel() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_annotation_label, logger)) {
			return this.details_pt_annotation_label;
		} else {
			return null;
		}
	}


	/** The MUI Alarm Details Point Annotation WebElement. */
	@FindBy(linkText = "Annotations")
	WebElement details_pt_annotation;
	/**
	 * Gets the Alarm Details Point Annotation.
	 *
	 * @return the Alarm Details Point Annotation
	 */
	public WebElement getDetailsPointAnnotation() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_annotation, logger)) {
			return this.details_pt_annotation;
		} else {
			return null;
		}
	}

	/** The MUI Details Point Alarm Acknowledge Button WebElement. */
	@FindBy(css = "a[ng-click='acknowledgeAlarm()']")
	WebElement details_pt_alarm_ack_btn;
	/**
	 * Gets the Alarm Acknowledge Button.
	 *
	 * @return the Alarm Acknowledge Button
	 */
	public WebElement getDetailsPointAckBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_alarm_ack_btn, logger)) {
			return this.details_pt_alarm_ack_btn;
		} else {
			return null;
		}
	}


	/** The MUI Details Point Alarm Discard Button WebElement. */
	@FindBy(css = "a[ng-click='discardAlarm()']")
	WebElement details_pt_alarm_discard_btn;
	/**
	 * Gets the Alarm Discard Button.
	 *
	 * @return the Alarm Discard Button
	 */
	public WebElement getDetailsPointDiscardBtn() {
		if (commonFunctions.WebElementCommon.waitForElementPresent(driver, details_pt_alarm_discard_btn, logger)) {
			return this.details_pt_alarm_discard_btn;
		} else {
			return null;
		}
	}

	
}
