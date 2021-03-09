package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entities.GameMatch;
import gui.util.Alert;
import gui.util.LimitadorDeCampos;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class SelectViewController implements Initializable {

	@FXML
	private TextField txt1;
	@FXML
	private TextField txt2;
	@FXML
	private Label btnXp1;
	@FXML
	private Label btnOp1;
	@FXML
	private Label btnXp2;
	@FXML
	private Label btnOp2;
	@FXML
	private Button confirmar;
	@FXML
	private Button voltar;

	private GameMatch game;

	public void gmSvc(GameMatch game) {
		this.game = game;
	}

	@FXML
	public void bloquearBotão() {
		if (txt1.getLength() >= 4 && txt2.getLength() >= 4) {
			confirmar.setDisable(false);
		} else {
			confirmar.setDisable(true);
		}
	}

	@FXML
	public void labelPiece() {

		if (btnXp1.getTextFill() == Color.GRAY && btnOp1.getTextFill() == Color.BLACK) {

			btnXp2.setTextFill(Color.GRAY);
			btnXp2.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, null, null)));
			btnXp2.setDisable(true);

			btnOp2.setTextFill(Color.BLACK);
			btnOp2.setBackground(new Background(new BackgroundFill(null, null, null)));
			btnOp2.setDisable(false);

			btnXp1.setTextFill(Color.BLACK);
			btnXp1.setBackground(new Background(new BackgroundFill(null, null, null)));
			btnXp1.setDisable(false);

			btnOp1.setTextFill(Color.GRAY);
			btnOp1.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, null, null)));
			btnOp1.setDisable(true);
		} else {
			btnXp2.setTextFill(Color.BLACK);
			btnXp2.setBackground(new Background(new BackgroundFill(null, null, null)));
			btnXp2.setDisable(false);

			btnOp2.setTextFill(Color.GRAY);
			btnOp2.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, null, null)));
			btnOp2.setDisable(true);

			btnXp1.setTextFill(Color.GRAY);
			btnXp1.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, null, null)));
			btnXp1.setDisable(true);

			btnOp1.setTextFill(Color.BLACK);
			btnOp1.setBackground(new Background(new BackgroundFill(null, null, null)));
			btnOp1.setDisable(false);
		}
	}

	@FXML
	public void confirmButton() {
		if (btnXp1.isDisable() == true) {
			game.setInfo(txt1.getText(), txt2.getText(), btnXp1.getText(), btnOp2.getText());
		} else {
			game.setInfo(txt1.getText(), txt2.getText(), btnOp1.getText(), btnXp2.getText());
		}
		
		loadView("/gui/GameView.fxml");

	}

	@FXML
	public void backButton() {
		loadView("/gui/MainView.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		LimitadorDeCampos.textFieldLimiter(txt1);
		LimitadorDeCampos.textFieldLimiter(txt2);

		confirmar.setDisable(true);

		btnXp2.setTextFill(Color.BLACK);
		btnXp2.setBackground(new Background(new BackgroundFill(null, null, null)));
		btnXp2.setDisable(false);

		btnOp2.setTextFill(Color.GRAY);
		btnOp2.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, null, null)));
		btnOp2.setDisable(true);

		btnXp1.setTextFill(Color.GRAY);
		btnXp1.setBackground(new Background(new BackgroundFill(Color.DARKSLATEBLUE, null, null)));
		btnXp1.setDisable(true);

		btnOp1.setTextFill(Color.BLACK);
		btnOp1.setBackground(new Background(new BackgroundFill(null, null, null)));
		btnOp1.setDisable(false);
	}

	private synchronized <T> void loadView(String tela) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(tela));
			AnchorPane anchor = loader.load();
			Scene mainScene = Main.getMainScene();
			AnchorPane mainAnchorPane = (AnchorPane) ((AnchorPane) mainScene.getRoot());
			mainAnchorPane.getChildren().clear();
			mainAnchorPane.getChildren().addAll(anchor.getChildren());
			if(tela.contains("GameView")) {
				GameViewController gameView = loader.getController();
				gameView.gmSVC(game);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Alert.showAlert("Erro", null, "Erro ao carregar a tela!\n" + e.getMessage(), AlertType.ERROR);
		}

	}

}
