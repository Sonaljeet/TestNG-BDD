package mars.automation.framework.NEWLauncher;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

public class SelectingPropertiesFile {

	private static FileChooser fileChooser = null;
	private static String filePath = null;
	
	public static String getFile(){
		fileChooser = new FileChooser();
		fileChooser.setTitle("Select TestNg XML File");
		
		ExtensionFilter filter = new ExtensionFilter("XML files (*.xml)", "*.XML");
		fileChooser.getExtensionFilters().add(filter);
		
		File file = fileChooser.showOpenDialog(null);
		
		if (file != null) {
			filePath = file.getAbsolutePath();
		}
		return filePath;
	}
}
