/*-------------------------------------------------------------------------------------

  (C) Copyright 2016 Johnson Controls, Inc. 
      Use or Copying of all or any part of this program, except as
      permitted by License Agreement, is prohibited.

-------------------------------------------------------------------------------------*/


package mars.automation.framework.launcher;

import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * Created by cpandeak on 7/22/2016.
 */
public class MARSFileSelector {

	/**
	 * Choose file.
	 *
	 * @return the string
	 */
	public static String chooseFile() {

		// txt_projectConfig=new TextField();
		javafx.stage.FileChooser chooser = new javafx.stage.FileChooser();
		// File selectedFile=chooser.showOpenDialog(null);
		javafx.stage.FileChooser.ExtensionFilter extensionFilter = new javafx.stage.FileChooser.ExtensionFilter(
				"TXT files (*.properties)", "*.properties");
		chooser.getExtensionFilters().add(extensionFilter);

		// Show Open dialog
		File file = chooser.showOpenDialog(null);
		// txt_projectConfig.setText(file.getAbsolutePath());
		try {
			if (file.getAbsolutePath() != null) {
				return file.getAbsolutePath();
			} else
				return null;
		} catch (Exception e) {
			System.out.println("File not found");
			return null;
		}

	}
}
