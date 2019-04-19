package mars.automation.framework.NEWLauncher;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class DropDownController implements Initializable{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public static void setTheData(ComboBox<String> testList){
		ObservableList<String> projectList = FXCollections.observableArrayList("Metasys Automation", "CSD Automation");

		testList.setItems(projectList);		
	}

}
