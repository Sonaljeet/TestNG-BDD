package mars.automation.framework.NEWLauncher.view;

import java.awt.Desktop;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.testng.internal.BaseClassFinder;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
import mars.Component.Functions.BaseClass;
import mars.automation.framework.NEWLauncher.Main_FX;
import mars.automation.framework.NEWLauncher.SelectingPropertiesFile;
import mars.automation.framework.TestNGRunnerPkg.TestNgRunTests;

public class WebUI_AutoController{

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ToggleGroup tgSelectTestSuite;

	@FXML
	private TextField XML_Path;

	@FXML
	private Button Btn_ChooseFile;

	@FXML
	private ComboBox<String> testList;

	@FXML
	private CheckBox chkBx_IE;

	@FXML
	private CheckBox chkBx_Chrome;

	@FXML
	private CheckBox chkBx_Firefox;
	
	
	
	@FXML
	private void goDashboard() throws IOException {
		Main_FX.showDashboard();
	}

	private final ObservableList<String> projectList = FXCollections.observableArrayList("Metasys Automation",
			"BCM UI Automation", "BCMET Automation", "CSD Automation", "DLS Automation", "GEBT Automation");

	@FXML
	void initialize() {
		testList.setItems(projectList);
		testList.valueProperty().addListener(e -> setProjectDetailsData());
	}

	private String projectName = null;

	private String setProjectDetailsData() {
		

		projectName = testList.getValue();
		
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
		return projectName;
	}

	
	private void setTextFieldPath(){
		XML_Path.setText("C:\\MARS_FRAMEWORK\\MARS_Automation_Framework_Tests\\CSD_Web_TestNG.xml");
		Tooltip tooltip = new Tooltip();
		tooltip.setOpacity(0.5);
		tooltip.setText(testngXMlfileName);
		XML_Path.setTooltip(tooltip);
		initialize1();
	}
	

	
	@FXML
	public void getBrowserSelection(ActionEvent event) {
		if (event.getSource() == chkBx_IE) {
			conFigureCheckBox(chkBx_IE);
		}
		if (event.getSource() == chkBx_Chrome) {
			conFigureCheckBox(chkBx_Chrome);
		}
		if (event.getSource() == chkBx_Firefox) {
			conFigureCheckBox(chkBx_Firefox);
		}
	}

	private void conFigureCheckBox(CheckBox chkBox) {
		List<String> browsersSelected = new ArrayList<String>();

		if ((chkBox.getText() != null || chkBox.getText() != "") && chkBox.isSelected()) {
			browsersSelected.add(chkBox.getText());
			System.out.println("Selected browser: " + chkBox.getText());
		}
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
	
	public String testngXMlfileName = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Tests/CSD_Web_TestNG.xml";

	
	@FXML
	public void getChooseFileEvent(ActionEvent event) {
		if (event.getSource() == Btn_ChooseFile && !Btn_ChooseFile.isDisabled()) {
			//testngXMlfileName = SelectingPropertiesFile.getFile();

			XML_Path.clear();
			XML_Path.setText(testngXMlfileName);
			Tooltip tooltip = new Tooltip();
			tooltip.setOpacity(0.5);
			tooltip.setText(testngXMlfileName);
			XML_Path.setTooltip(tooltip);
			initialize1();
			
			
/*			if (testngXMlfileName != null) {
				if (!XML_Path.isDisabled()) {
					XML_Path.clear();
					XML_Path.setText(testngXMlfileName);
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
			BaseClass.projectPropertiesFile = "C:/MARS_FRAMEWORK/MARS_Automation_Framework_Projects/mars/JCI/Project/CSD/Configuration/config.properties";
			if (!TestNgRunTests.stopTest && testngXMlfileName != null) {
				//TestNgRunTests.startTestNgTests(testngXMlfileName);
				TestNgRunTests.startTest(XML_Path.getText());
				
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
				new TestCaseDetailsGridModel(true, "Application Login Test"),
				new TestCaseDetailsGridModel(true, "Successful user creation"),
				new TestCaseDetailsGridModel(true, "Successful user deletion"));
		
		col2.setCellValueFactory(new PropertyValueFactory<TestCaseDetailsGridModel, String>("name"));

		/*col1.setCellFactory(column ->new CheckBoxTableCell<TestCaseDetailsGridModel, Boolean>());
		col1.setCellValueFactory(new PropertyValueFactory<TestCaseDetailsGridModel, Boolean>("check"));*/
		

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
						"C:/MARS_FRAMEWORK/MARS_Automation_Framework_Reports/mars/JCI/Project/CSD/Graphical_Report/CSD_AUTOMATION_EXECUTION_REPORT.HTML");

			}
		});
	}
	
	
}
