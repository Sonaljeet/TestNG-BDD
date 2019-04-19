package mars.automation.framework.NEWLauncher.view;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.scene.control.Tooltip;

public class Utilities {

	
	public static void openUrlInBrowser(String url){
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Tooltip createNewTooltip(String textToDisplay){
		Tooltip tooltip = new Tooltip();
		tooltip.setText(textToDisplay);

		return tooltip;
	}
}
