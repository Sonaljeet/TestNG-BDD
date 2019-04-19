package mars.JCI.Project.DLS.NewAccount;

import java.io.IOException;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import mars.Desktop.Component.Functions.MARSDesktopDriver;
import mars.JCI.Project.DLS.Home.DLS_Home_Page_Action;

public class DLS_New_Account_Page_Action {
	/** The New Account page title. */
	public String newAccountPageTitle = "Create New Account (Basic)";
	
	/** The New Account Comment page title. */
	public String newAccountCommentPageTitle = "Create A New Account";

	/** The text. */
	public String text = "";

	/** The MARSDesktopDriver */
	public MARSDesktopDriver desktopDriver;

	/** The mouseClick */
	public int mouseClick;

	/** The ExtentTest logger. */
	public ExtentTest logger;

	/** The username Control */
	public String usernamecontrol = "";

	/** The phonenumber Control */
	public String phonenumbercontrol = "";

	/** The CreateControl */
	public String createControl = "";

	/** The Home page Title */
	public String homepageTitle = "DLS 5 v1.61";

	/** The mouse Click On Comment */
	public int mouseClickOnComment;

	/** The advance Button */
	public String advanceButton = "";

	/** The comment Edit Field Control Button */
	public String commentEditFieldControl = "";
	/**
	 * Instantiates/Constructor a new DLS New Account page action.
	 *
	 * @param desktopDriver
	 *            the desktopDriver
	 * @param logger
	 *            the logger
	 * @param baseURL
	 */
	public DLS_New_Account_Page_Action(MARSDesktopDriver desktopDriver, ExtentTest logger) {
		this.desktopDriver = desktopDriver;
		this.logger = logger;

	}

	public void mouseClick() {

		mouseClick = desktopDriver.marsMouseClick("", 56, 191, 1, 0);
		if (mouseClick > 0) {
			logger.log(LogStatus.PASS, "New Account Window Clicked and Opened Successfully");
		} else {
			logger.log(LogStatus.FAIL, "New Account Window Failed to Open");
		}
	}

	public void enterUsername(String username) {
		DLS_New_Account_Page_Factory newAccountPF = new DLS_New_Account_Page_Factory(desktopDriver);
		usernamecontrol = newAccountPF.getUsername();
		if (usernamecontrol != null) {

			desktopDriver.marsControlSend(newAccountPageTitle, text, usernamecontrol, username);

			logger.log(LogStatus.PASS, "Username is " + username + " Entered succesfully to Username WindowElement");
		} else {
			logger.log(LogStatus.FAIL, "Failed to add Username" + username);
		}
	}

	public void enterPhoneno(String phonenumber) {
		DLS_New_Account_Page_Factory newAccountPF = new DLS_New_Account_Page_Factory(desktopDriver);
		phonenumbercontrol = newAccountPF.getPhonenumber();
		if (phonenumbercontrol != null) {
			desktopDriver.marsControlSend(newAccountPageTitle, text, phonenumbercontrol, phonenumber);

			logger.log(LogStatus.PASS,
					"User Phonenumber is " + phonenumber + " Entered succesfully to User Phonenumber WindowElement");
		} else {
			logger.log(LogStatus.FAIL, "Failed to add Phonenumber" + phonenumber);
		}
	}

	public void clickCreate() {
		DLS_New_Account_Page_Factory newAccountPF = new DLS_New_Account_Page_Factory(desktopDriver);
		createControl = newAccountPF.getCreatebuttonOnComment();
		if (createControl != null) {

			desktopDriver.marsControlClick(newAccountCommentPageTitle, text,createControl);

			logger.log(LogStatus.PASS, "User Account Created Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Create User Account");
		}

	}
	
	
	public void advanceClickButton()
	{
		DLS_New_Account_Page_Factory newAccountPF = new DLS_New_Account_Page_Factory(desktopDriver);
		advanceButton= newAccountPF.getAdvancebutton();
		if (advanceButton!= null) {

			desktopDriver.marsControlClick(newAccountPageTitle, text,advanceButton);

			logger.log(LogStatus.PASS, "Advance Button Clicked Successfully On New Account Page");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Click Advance Button on New Account Page");
		}
	}
	
	
	
	public void mouseClickOnCommentPage()
	{
		mouseClickOnComment = desktopDriver.marsMouseClick("", 514,228, 1, 0);
		if (mouseClickOnComment > 0) {
			logger.log(LogStatus.PASS, "New Account Comment Section Clicked and Open Sucessfully");
		} else {
			logger.log(LogStatus.FAIL, "New Account Comment Section Failed to Open");
		}
	}
	
	public void commentSectionEditField(String comment)
	{
		DLS_New_Account_Page_Factory newAccountPF = new DLS_New_Account_Page_Factory(desktopDriver);
		commentEditFieldControl= newAccountPF.getEditFieldOnComment();
		if (commentEditFieldControl!= null) {
     System.out.println("Hello bhai12");
			desktopDriver.marsControlSetText(newAccountCommentPageTitle,text,commentEditFieldControl,comment);

			logger.log(LogStatus.PASS, "Comments "+comment+ "  Added on Account Page Successfully");
		} else {
			logger.log(LogStatus.FAIL, "Failed to Add Comments"+comment+" on Account Page");
		}
	}

	public void correctUserAccount(String username, String phonenumber,String comment) throws IOException {
		try {
			desktopDriver.marsSleep(5000);
			mouseClick();

			if (desktopDriver.marsWinWaitActive(newAccountPageTitle, text, 20) > 0) {
				enterUsername(username);
				enterPhoneno(phonenumber);
				advanceClickButton();
				desktopDriver.marsSleep(2000);
				mouseClickOnCommentPage();
				desktopDriver.marsSleep(2000);
				commentSectionEditField(comment);
				clickCreate();
		
			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}
		
	}

	public void withoutUsernameAccount(String phonenumber) {
		try {
			desktopDriver.marsSleep(8000);
			mouseClick();

			if (desktopDriver.marsWinWaitActive(newAccountPageTitle, text, 20) > 0) {
				enterPhoneno(phonenumber);

				logger.log(LogStatus.PASS,
						" Failed to Create User Account Without Username With phonenumber " + phonenumber);

			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}

	public void withoutPhonenumberUserAccount(String username) {
		try {
			desktopDriver.marsSleep(8000);
			mouseClick();

			if (desktopDriver.marsWinWaitActive(newAccountPageTitle, text, 20) > 0) {
				enterUsername(username);
				userAcccountclickCreate();
				logger.log(LogStatus.PASS,
						" Failed to Create User Account Without Phonenumber With Username " + username);

			}
		} catch (NullPointerException e) {
			logger.log(LogStatus.ERROR,
					this.getClass().getSimpleName() + " Failed! -- " + e.getMessage().substring(0, 90));
		}

	}

	public void userAcccountclickCreate() {
		DLS_New_Account_Page_Factory newAccountPF = new DLS_New_Account_Page_Factory(desktopDriver);
		createControl = newAccountPF.getCreatebutton();
		if (createControl != null) {

			desktopDriver.marsControlClick(newAccountPageTitle, text, createControl);

		}
	}
	
	
	

}
