package application;

import gui.util.Alert;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Scene mainScene;
	private static Stage mainStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			AnchorPane pane = loader.load();
			mainScene = new Scene(pane);
			mainStage = primaryStage;
			primaryStage.setScene(mainScene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Jogo da Velha");
			primaryStage.setIconified(true);
			primaryStage.show();
			
		} catch (Exception e) {
			Alert.showAlert("Error", null, "Error"+e.getMessage(), AlertType.ERROR);
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
	
	public static Stage getMainStage() {
		return mainStage;
	}
	
	public static void end(Stage primary) {
		primary.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
