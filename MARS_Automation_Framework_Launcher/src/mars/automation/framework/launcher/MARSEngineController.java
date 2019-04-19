/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.automation.framework.launcher;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

/*import ExperimentalPackage.utilities;*/

// TODO: Auto-generated Javadoc
/**
 * The Class MARSEngineController.
 */
public class MARSEngineController implements Initializable {

	/** The chk bx chrome. */
	@FXML
	private CheckBox chkBx_Chrome;

	/** The chk bx firefox. */
	@FXML
	private CheckBox chkBx_Firefox;

	/** The chk bx internet exp. */
	@FXML
	private CheckBox chkBx_InternetExp;

	/** The radio mail yes. */
	@FXML
	private RadioButton radio_MailYes;

	/** The send email. */
	@FXML
	private ToggleGroup sendEmail;

	/** The radio mail no. */
	@FXML
	private RadioButton radio_MailNo;

	/** The Combo project selection. */
	@FXML
	private ComboBox<String> Combo_projectSelection;

	/** The txt project config. */
	@FXML
	private TextField txt_projectConfig;

	/** The btn load project config. */
	@FXML
	private Button btn_loadProjectConfig;

	/** The txt email config. */
	@FXML
	private TextField txt_emailConfig;

	/** The btn email config. */
	@FXML
	private Button btn_emailConfig;

	/** The txt db config. */
	@FXML
	private TextField txt_dbConfig;

	/** The btn load DBC onfig. */
	@FXML
	private Button btn_loadDBCOnfig;

	/** The btn execute tests. */
	@FXML
	private Button btn_ExecuteTests;

	/** The btn terminate test. */
	@FXML
	private Button btn_TerminateTest;

	/** The radio DB yes. */
	@FXML
	private RadioButton radio_DBYes;

	/** The db acess. */
	@FXML
	private ToggleGroup dbAcess;

	/** The radio DB no. */
	@FXML
	private RadioButton radio_DBNo;

	/** The btn load config class. */
	@FXML
	private Button btn_loadConfigClass;

	/** The project list. */
	ObservableList<String> projectList = FXCollections.observableArrayList("Metasys Automation", "BCM UI Automation");

	/** The stop test. */
	public static boolean stopTest = false;

	/** The stop running test. */
	public Thread stopRunningTest = null;

	/** The chrome browser. */
	public static String chromeBrowser = null;

	/** The firefox browser. */
	public static String firefoxBrowser = null;

	/** The Ie browser. */
	public static String IeBrowser = null;

	/** The send email 1. */
	public static boolean sendEmail1 = false;

	/** The Project config. */
	public static String ProjectConfig = null;

	/** The Email config. */
	public static String EmailConfig = null;

	/** The Db config. */
	public static String DbConfig = null;

	/** The uihelper. */
	private MARSEngineUIHelper uihelper = null;

	/** The mail send yes or no. */
	public boolean mailSendYesOrNo;

	/** The db access yes or no. */
	public boolean dbAccessYesOrNo;

	/**
	 * Instantiates a new MARS engine controller.
	 */
	public MARSEngineController() {

		uihelper = new MARSEngineUIHelper();
		dbAcess = new ToggleGroup();
		sendEmail = new ToggleGroup();
	}

	/**
	 * Sets the btn load project config.
	 *
	 * @param actionEvent
	 *            the new btn load project config
	 */
	public void setBtn_loadProjectConfig(ActionEvent actionEvent) {
		try {
			System.out.println("btn_loadProjectConfig clicked");
			String projectFileName = MARSFileSelector.chooseFile();
			System.out.println(projectFileName);
			if (projectFileName != null && !projectFileName.isEmpty()) {
				txt_projectConfig.setText(projectFileName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("==============================");
			System.out.println("Error setting text to txt_projectConfig \n Error message \n" + e.getMessage());
			System.out.println("==============================");
		}

	}

	/**
	 * Sets the btn email config.
	 *
	 * @param actionEvent
	 *            the new btn email config
	 */
	public void setBtn_emailConfig(ActionEvent actionEvent) {
		try {
			System.out.println("btn_emailConfig clicked");
			String emailFileName = MARSFileSelector.chooseFile();
			System.out.println(emailFileName);
			if (emailFileName != null && !emailFileName.isEmpty()) {
				txt_emailConfig.setText(emailFileName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("==============================");
			System.out.println("Error setting text to txt_emailConfig\n" + e.getMessage());
			System.out.println("==============================");
		}
	}

	/**
	 * Sets the btn load DBC onfig.
	 *
	 * @param actionEvent
	 *            the new btn load DBC onfig
	 */
	public void setBtn_loadDBCOnfig(ActionEvent actionEvent) {
		try {
			System.out.println("btn_loadDBCOnfig clicked");
			String dbConfigFileName = MARSFileSelector.chooseFile();
			System.out.println(dbConfigFileName);
			if (dbConfigFileName != null && !dbConfigFileName.isEmpty()) {
				txt_dbConfig.setText(dbConfigFileName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("==============================");
			System.out.println("Error setting text to txt_dbConfig\n" + e.getMessage());
			System.out.println("==============================");
		}
	}

	/** The rs. */
	RadioButton rs = null;

	/** The rs 1. */
	RadioButton rs1 = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Combo_projectSelection.setItems(projectList);
		Combo_projectSelection.valueProperty().addListener(e -> getProjectName());

		txt_projectConfig.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				ProjectConfig = newValue;
				setProjectConfigInUIHelperClass();
			}

			private void setProjectConfigInUIHelperClass() {
				MARSEngineUIHelper.setProjectConfig(ProjectConfig);
				// System.out.println("ProjectConfig = "+ ProjectConfig);

			}
		});

		txt_emailConfig.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				EmailConfig = newValue;
				setEmailConfigInUIHelperClass();
			}

			private void setEmailConfigInUIHelperClass() {
				MARSEngineUIHelper.setEmailConfig(EmailConfig);
				// System.out.println("EmailConfig = " +EmailConfig);

			}
		});

		txt_dbConfig.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				DbConfig = newValue;
				setDBConfigInUIHelperClass();
			}

			private void setDBConfigInUIHelperClass() {
				MARSEngineUIHelper.setDbConfig(DbConfig);
				// System.out.println("DbConfig = " + DbConfig);

			}
		});

		sendEmail.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				rs = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
				sendEmailInUIHelperClass();
			}

			private void sendEmailInUIHelperClass() {
				if (rs.getText().equalsIgnoreCase("yes")) {
					uihelper.setSendEmail(true);
					mailSendYesOrNo = true;
				}
				if (rs.getText().equalsIgnoreCase("No")) {
					uihelper.setSendEmail(false);
					mailSendYesOrNo = false;
				}
			}
		});

		dbAcess.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				rs1 = (RadioButton) newValue.getToggleGroup().getSelectedToggle();
				setDBAccessInUIHelperClass();
			}

			private void setDBAccessInUIHelperClass() {
				if (rs.getText().equalsIgnoreCase("Yes")) {
					uihelper.setDbAccessRequired(true);
					dbAccessYesOrNo = true;
				}
				if (rs1.getText().equalsIgnoreCase("No")) {
					uihelper.setDbAccessRequired(false);
					dbAccessYesOrNo = false;
				}
			}
		});
		chkBx_Chrome.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				setChromeBrowserInUIHelperClass();
			}

			private void setChromeBrowserInUIHelperClass() {
				if (chkBx_Chrome.isSelected()) {
					uihelper.setChromeBrowser("chrome");
				}
			}
		});

		chkBx_Firefox.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				setFireFoxBrowserInUIHelperClass();
			}

			private void setFireFoxBrowserInUIHelperClass() {
				if (chkBx_Firefox.isSelected()) {
					uihelper.setFireFoxBrowser("firefox");
				}
			}
		});

		chkBx_InternetExp.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				setIEBrowserInUIHelperClass();
			}

			private void setIEBrowserInUIHelperClass() {
				if (chkBx_InternetExp.isSelected()) {
					uihelper.setIeBrowser("ie");
				}
			}
		});
	}

	/**
	 * Gets the project name.
	 *
	 * @return the project name
	 */
	public String getProjectName() {
		String value = "Test project";
		try {
			int value1 = 0;
			value = Combo_projectSelection.getValue();
			System.out.println("Value " + value);
			// "Metasys Automation", "BCM ET Automation", "Dummy project"
			if (value.equalsIgnoreCase("Metasys Automation"))
				value1 = 1;
			else if (value.equalsIgnoreCase("BCM UI Automation"))
				value1 = 2;

			System.out.println(value1);
			switch (value1) {
			case 1:
				// MUI project
				txt_projectConfig.setText(
						"C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MUI/Configuration/config.properties");
				value = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MUI/Configuration/config.properties";
				break;
			case 2:
				// BCM Project
				txt_projectConfig.setText(
						"C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/BCM/Configuration/config.properties");
				value = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/BCM/Configuration/config.properties";
				break;
			default:
				txt_projectConfig.setText("Not a valid project");
				value = "Not a valid project";
				System.out.println("Not a valid project");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("==============================");
			System.out.println("Error selecting project \n Error message \n" + e.getMessage());
			System.out.println("==============================");
		}
		return value;
	}

	/**
	 * Sets the btn execute tests.
	 *
	 * @param event
	 *            the new btn execute tests
	 */
	@FXML
	public void setBtn_ExecuteTests(ActionEvent event) {
		try {
			if (event.getSource() == btn_ExecuteTests) {
				MARSEngineTestNGUtilities ut = new MARSEngineTestNGUtilities();
				stopTest = false;
				System.out.println("btn_ExecuteTests  clicked");
				ut.startTest();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Sets the btn terminate test.
	 *
	 * @param events
	 *            the new btn terminate test
	 */
	@FXML
	public void setBtn_TerminateTest(ActionEvent events) {
		if (events.getSource() == btn_TerminateTest) {
			stopTest = true;
		}
	}

	/**
	 * Btn load config in class.
	 *
	 * @param events
	 *            the events
	 */
	@FXML
	public void btn_loadConfigInClass(ActionEvent events) {
		if (events.getSource() == btn_loadConfigClass) {
			// System.out.println("btn_loadConfigInClass clicked");
			getDetails();
		}
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public void getDetails() {

		System.out.println("uihelper.getSendEmail() = " + uihelper.getSendEmail());
		System.out.println("uihelper.isDbAccessRequired() = " + uihelper.isDbAccessRequired());
		System.out.println("uihelper.getChromeBrowser() = " + uihelper.getChromeBrowser());
		System.out.println("uihelper.getProjectConfig() = " + MARSEngineUIHelper.getProjectConfig());
		System.out.println("uihelper.getEmailConfig() = " + MARSEngineUIHelper.getEmailConfig());
		System.out.println("uihelper.getDbConfig() = " + MARSEngineUIHelper.getDbConfig());
	}
}
