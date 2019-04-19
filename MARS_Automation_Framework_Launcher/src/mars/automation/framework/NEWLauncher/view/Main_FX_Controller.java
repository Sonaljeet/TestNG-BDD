package mars.automation.framework.NEWLauncher.view;

//import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import mars.automation.framework.NEWLauncher.DropDownController;
import mars.automation.framework.NEWLauncher.Main_FX;
import mars.automation.framework.NEWLauncher.SelectingPropertiesFile;
import mars.automation.framework.TestNGRunnerPkg.TestNgRunTests;

public class Main_FX_Controller{

	private Main_FX main_fx;

	@FXML
	private void goDashboard() throws IOException {
		Main_FX.showDashboard();
	}

	@FXML
	private void goHome() throws IOException {
		Main_FX.showHome();
	}

	@FXML
	private void goAPI_Automation() throws IOException {
		Main_FX.showAPI_Automation();
	}

	@FXML
	private void goWebUI_Automation() throws IOException {
		Main_FX.showWebUI_Automation();
	}

	@FXML
	private void goDesktop_Automation() throws IOException {
		Main_FX.showDesktop_Automation();
	}

	@FXML
	private void goMobile_Automation() throws IOException {
		Main_FX.showMobile_Automation();
	}

	@FXML
	private void goDeviceBACnet_Automation() throws IOException {
		Main_FX.showDeviceBACnet_Automation();
	}

	@FXML
	private void goPerformance_Automation() throws IOException {
		Main_FX.showPerformance_Automation();
	}

	@FXML
	private RadioButton upload_XML;

	@FXML
	private RadioButton create_Test_Suite;
	
	
	@FXML
	ComboBox<String> testList;	

	ObservableList<String> projectList = FXCollections.observableArrayList("Metasys Automation", "CSD Automation");
	
	
	@FXML
	private Button btn_ChooseFile;
	
	@FXML
	private ListView txt_XML_Path;
/*
	public void btn_choosefileAction(ActionEvent event){
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		if(selectedFile != null){
			txt_XML_Path.getItems().add
		}else{
			
		}
	}*/
	
	
	@FXML
	private Button btn_executeTests;
	
	
	@FXML
	public void btn_executeTestsClickEvent(ActionEvent event){
		if (event.getSource() == btn_executeTests) {
			System.out.println("Execute button click");
			
			if (!TestNgRunTests.stopTest) {
				//TestNgRunTests.startTest();
			}			
		}
	}
}
