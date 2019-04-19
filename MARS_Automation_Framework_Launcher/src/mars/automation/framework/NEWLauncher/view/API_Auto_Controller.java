package mars.automation.framework.NEWLauncher.view;

import java.io.IOException;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import mars.Component.Functions.API_BaseClass;
import mars.Component.Functions.BaseClass;
import mars.automation.framework.NEWLauncher.Main_FX;
import mars.automation.framework.TestNGRunnerPkg.TestNgRunTests;

public class API_Auto_Controller {

	

	@FXML
	private ToggleGroup tgSelectTestSuite;

	@FXML
	private TextField XML_Path;

	@FXML
	private Button Btn_ChooseFile;

	@FXML
	private ComboBox<String> projectDropDown;
	
	@FXML ImageView openReport;
	


	@FXML
	private void goDashboard() throws IOException {
		Main_FX.showDashboard();
	}
	
	private final ObservableList<String> projectList = FXCollections.observableArrayList("MEMS API Automation");

	@FXML
	void initialize() {
		projectDropDown.setItems(projectList);
		projectDropDown.valueProperty().addListener(e -> setProjectDetailsData());
	}
	
	private String projectName = null;

	
	
	private String setProjectDetailsData() {

		projectName = projectDropDown.getValue();
		
		setTextFieldPath();

		if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("Metasys Automation")) {
			
			
		} else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("BCM UI Automation")) {
			
		}
		
		else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("BCMET Automation")) {

		}
		
		else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("CSD Automation")) {

		}
		
		else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("DLS Automation")) {

		}
		
		else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("GEBT Automation")) {

		}
		else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("MEMS API Automation")) {

		}
		
		else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("NAE-55")) {

		}
		
		else if (projectName != null && projectName.toUpperCase().equalsIgnoreCase("MEMS API Automation")) {

		}
		return projectName;
	}

	public String testngXMlfileName = "C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\API_testng.xml";;
	
	private void setTextFieldPath(){
		XML_Path.setText(testngXMlfileName);
		Tooltip tooltip = new Tooltip();
		tooltip.setOpacity(0.5);
		tooltip.setText(testngXMlfileName);
		XML_Path.setTooltip(tooltip);
		initialize1();
	}
	
	@FXML
	public void getTestSuiteChkBoxProperty(ActionEvent event) {

		tgSelectTestSuite.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if (tgSelectTestSuite.getSelectedToggle() != null) {
					RadioButton testSuiteSelection = (RadioButton) tgSelectTestSuite.getSelectedToggle();

					if (testSuiteSelection.getText().equalsIgnoreCase("Select XML")) {
						XML_Path.setDisable(!testSuiteSelection.isSelected());
						Btn_ChooseFile.setDisable(!testSuiteSelection.isSelected());
					}

					if (testSuiteSelection.getText().equalsIgnoreCase("Create Test Suite")) {
						XML_Path.setDisable(testSuiteSelection.isSelected());
						XML_Path.clear();
						Btn_ChooseFile.setDisable(testSuiteSelection.isSelected());
					}
				}
			}
		});
	}
	
	@FXML
	public void getChooseFileEvent(ActionEvent event) {
		if (event.getSource() == Btn_ChooseFile && !Btn_ChooseFile.isDisabled()) {

			XML_Path.setText(testngXMlfileName);
			Tooltip tooltip = new Tooltip();
			tooltip.setOpacity(0.5);
			tooltip.setText(testngXMlfileName);
			XML_Path.setTooltip(tooltip);
			initialize1();
			
/*			if (testngXMlfileName != null) {
				if (!XML_Path.isDisabled()) {
					XML_Path.clear();
					XML_Path.setText("");
					Tooltip tooltip = new Tooltip();
					tooltip.setOpacity(0.5);
					tooltip.setText(testngXMlfileName);
					XML_Path.setTooltip(tooltip);
					initialize1();
				}
			}*/
		}
	}
	@FXML
	private Button btn_executeTests;

	@FXML
	public void btn_executeTestsClickEvent(ActionEvent event){
		if (event.getSource() == btn_executeTests) {
			TestNgRunTests.stopTest = false;
			System.out.println("Execute button click");
			System.out.println("testngXMlfileName: "+testngXMlfileName);
			API_BaseClass.projectPropertiesFile="C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/MEMS/Configuration/config.properties";
			
			if (!TestNgRunTests.stopTest && testngXMlfileName != null) {
				//TestNgRunTests.startTestNgTests(testngXMlfileName);
				//testngXMlfileName= "C:\\MARS_GUI_INTEGRATED\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\HardwareTestNG.xml";
				//TestNgRunTests.startTest(testngXMlfileName);
				
				TestNgRunTests.startTest(XML_Path.getText().toString());
			}
			
/*			if (!RunTestNgSuite.stopTest && testngXMlfileName != null) {
				test = RunTestNgSuite.getInstance();
				test.start();
			}*/
		}
	}
	 
	@FXML
	private Button btn_TerminateTest;
	
	
	@FXML
	public void btn_terminateTest(ActionEvent event){
		if (event.getSource() == btn_TerminateTest) {
			System.out.println("Terminate clicked");
			TestNgRunTests.stopTest = true;
			//test.stopTest = true;
			//TestNgRunTests.stopTest(test1);// = true;
			//TestNgRunTests.stopAllTest();
			//TestNgRunTests.threadTestNgRun.interrupt();
			TestNgRunTests.stopAllTest();
		}	
	}
	
	@FXML
	private TableView<TestCaseDetailsGridModel> testCaseTable;
	
	/*@FXML
	private TableColumn<TestCaseDetailsGridModel, Boolean> col1;*/
	
	@FXML
	private TableColumn<TestCaseDetailsGridModel, String> col2;

	/*public 	ObservableList<TestCaseDetailsGridModel> testCaseName = FXCollections.observableArrayList(new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"));*/
	
	public void initialize1() {

		ObservableList<TestCaseDetailsGridModel> testCaseName = FXCollections.observableArrayList
				(new TestCaseDetailsGridModel(true, "API to get the accesstoken for authentication"),
				new TestCaseDetailsGridModel(true, "API to get the Portfolio_information Data")/*,
				new TestCaseDetailsGridModel(true, "API to get the Hourly Data"),
				new TestCaseDetailsGridModel(true, "API to get the Daily Data"),
				new TestCaseDetailsGridModel(true, "API to get the Weather Station Data"),
				new TestCaseDetailsGridModel(true, "API to get the Average temparature Data"),
				new TestCaseDetailsGridModel(true, "API to get the Minimum temparature Data with UI Validation"),
				new TestCaseDetailsGridModel(true, "API to get the Maximum temparature Data"),
				new TestCaseDetailsGridModel(true, "API to get the Current Weather Point_ID Data"),
				new TestCaseDetailsGridModel(true, "API to get the Current Weather PointCode Data")*/);
		
		

		/*col1.setCellValueFactory(new PropertyValueFactory<TestCaseDetailsGridModel, Boolean>("check"));
		col1.setCellFactory(column -> new CheckBoxTableCell<>());*/

		col2.setCellValueFactory(new PropertyValueFactory<TestCaseDetailsGridModel, String>("name"));
		testCaseTable.setItems(testCaseName);
		
	}

	
	@FXML
	private ImageView OpenImgVRep;
	
	@FXML
	public void openReportFile(Event event) {

		OpenImgVRep.setOnMouseEntered(new javafx.event.EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				System.out.println("Mouse hovered");
				Tooltip.install(OpenImgVRep, Utilities.createNewTooltip("Click To Open Test Report"));
			}
		});

		OpenImgVRep.setOnMouseClicked(new javafx.event.EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				System.out.println("Mouse clicked");
				Utilities.openUrlInBrowser(
						"C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/MEMS/Graphical_Report/MEMS_CLOUD_API_AUTOMATION_EXECUTION_REPORT.HTML");

			}
		});
	}
}
