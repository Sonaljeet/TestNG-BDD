package mars.automation.framework.NEWLauncher;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main_FX extends Application {

	private Stage primaryStage;
	private static BorderPane layOut;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("MARS FRAMEWORK GUI");
		showBaseView();
		showHome();
	}

	private void showBaseView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		System.out.println("location "+Main_FX.class.getResource("view/BaseView.fxml"));
		loader.setLocation(Main_FX.class.getResource("view/BaseView.fxml"));
		layOut = loader.load();
		Scene scene = new Scene(layOut);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void showHome() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/Home.fxml"));
		BorderPane home = loader.load();
		layOut.setCenter(home);
	}

	public static void showDashboard() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/Dashboard.fxml"));
		BorderPane dash = loader.load();
		layOut.setCenter(dash);
	}
	
	public static void showWebUI_Automation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/WebUI_Auto.fxml"));
		BorderPane api = loader.load();		
		layOut.setCenter(api);
	}

	public static void showAPI_Automation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/API_Auto.fxml"));
		BorderPane api = loader.load();
		layOut.setCenter(api);
	}
	
	public static void showDesktop_Automation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/Desktop_Auto.fxml"));
		BorderPane api = loader.load();
		layOut.setCenter(api);
	}
	
	public static void showMobile_Automation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/Mobile_Auto.fxml"));
		BorderPane api = loader.load();
		layOut.setCenter(api);
	}
	
	public static void showDeviceBACnet_Automation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/Device_Auto.fxml"));
		BorderPane api = loader.load();
		layOut.setCenter(api);
	}
	
	public static void showPerformance_Automation() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main_FX.class.getResource("view/Performance_Auto.fxml"));
		BorderPane api = loader.load();
		layOut.setCenter(api);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
