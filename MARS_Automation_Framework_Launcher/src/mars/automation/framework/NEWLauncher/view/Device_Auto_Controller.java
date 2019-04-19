package mars.automation.framework.NEWLauncher.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import mars.automation.framework.NEWLauncher.Main_FX;
import mars.automation.framework.NEWLauncher.SelectingPropertiesFile;
import mars.automation.framework.TestNGRunnerPkg.TestNgRunTests;

public class Device_Auto_Controller {

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
	
	private final ObservableList<String> projectList = FXCollections.observableArrayList("NAE-55");

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
		return projectName;
	}
	
	
	public String testngXMlfileName = "C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\HardwareTestNG.xml";;
	
	private void setTextFieldPath(){
		XML_Path.setText("C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\HardwareTestNG.xml");
		Tooltip tooltip = new Tooltip();
		tooltip.setOpacity(0.5);
		tooltip.setText(testngXMlfileName);
		XML_Path.setTooltip(tooltip);
		initialize1();
	}
	


	@FXML
	public void getChooseFileEvent(ActionEvent event) {
		if (event.getSource() == Btn_ChooseFile && !Btn_ChooseFile.isDisabled()) {
			//testngXMlfileName = SelectingPropertiesFile.getFile();
			//testngXMlfileName= "C:\\MARS_GUI_INTEGRATED\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\HardwareTestNG.xml";
			XML_Path.setText("C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\HardwareTestNG.xml");
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
	
	@FXML
	private TableColumn<TestCaseDetailsGridModel, Boolean> col1;
	
	@FXML
	private TableColumn<TestCaseDetailsGridModel, String> col2;

	/*public 	ObservableList<TestCaseDetailsGridModel> testCaseName = FXCollections.observableArrayList(new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"),
			new TestCaseDetailsGridModel("Hello", "World"));*/
	
	
	public void initialize1() {

		ObservableList<TestCaseDetailsGridModel> testCaseName = FXCollections.observableArrayList(
				new TestCaseDetailsGridModel(true, "DSWP - B -BTL - 9.22.1.X2 Write Property REAL"),
				new TestCaseDetailsGridModel(true, "DSWP - B -BTL - 9.22.1.X2 Write Property BOOLEAN for unwritable property"),
				new TestCaseDetailsGridModel(true, "DSWP - B -BTL - 9.22.1.X2 Write Property BOOLEAN"),
				new TestCaseDetailsGridModel(true, "DSWP - B -BTL - 9.22.1.X2 Write Property Unsigned"),
				new TestCaseDetailsGridModel(true, "Data Sharing - ReadProperty- Enumerated property values"),
				new TestCaseDetailsGridModel(true, "Data Sharing - ReadProperty- Unsigned property values"),
				new TestCaseDetailsGridModel(true, "Data Sharing - ReadProperty- Contains BOOLEAN property values"),
				new TestCaseDetailsGridModel(true, "Data Sharing - ReadProperty- Contains REAL property values"),
				new TestCaseDetailsGridModel(true, "Data sharing Read Multiple Property from Multiple objects"),
				new TestCaseDetailsGridModel(true, "Data sharing Read Multiple Property from Multiple objects"),
				new TestCaseDetailsGridModel(true, "Reading Multiple properties from Single objects"),
				new TestCaseDetailsGridModel(true, "Reading Single property from multiple objects"));
		
		col2.setCellValueFactory(new PropertyValueFactory<TestCaseDetailsGridModel, String>("name"));
/*
		col1.setCellFactory(column ->new CheckBoxTableCell<TestCaseDetailsGridModel, Boolean>());
		col1.setCellValueFactory(new PropertyValueFactory<TestCaseDetailsGridModel, Boolean>("check"));
		*/

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
						"C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/HW/Graphical_Report/BACnet_AUTOMATION_EXECUTION_REPORT.HTML");

			}
		});
	}
}
