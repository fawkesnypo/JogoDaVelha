package gui;

import java.io.IOException;

import application.Main;
import entities.GameMatch;
import gui.util.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainViewController {

	@FXML
	private Button btnJogar;

	@FXML
	private Button btnExit;

	@FXML
	private void clickBtnExit() {
		Main.end(Main.getMainStage());
	}

	private GameMatch game = new GameMatch();

	@FXML
	private void clickBtnJogar() {
		loadView("/gui/SelectView.fxml");
	}

	private synchronized void loadView(String tela) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(tela));
			AnchorPane anchor = loader.load();
			Scene mainScene = Main.getMainScene();
			AnchorPane mainAnchorPane = (AnchorPane) ((AnchorPane) mainScene.getRoot());
			mainAnchorPane.getChildren().clear();
			mainAnchorPane.getChildren().addAll(anchor.getChildren());

			SelectViewController select = loader.getController();
			select.gmSvc(game);

		} catch (IOException e) {
			Alert.showAlert("Erro", null, "Erro ao carregar a tela!\n" + e.getMessage(), AlertType.ERROR);
		}

	}
}
