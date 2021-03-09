package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import entities.GameMatch;
import entities.Player;
import gui.util.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GameViewController implements Initializable {

	@FXML
	private Line linha;
	@FXML
	private Button btnSim;
	@FXML
	private Button btnNao;
	@FXML
	private Label lblQuestion;
	@FXML
	private Button menu;
	@FXML
	private Label lblTxt;
	@FXML
	private Label lbl1;
	@FXML
	private Label lbl2;
	@FXML
	private Label lbl3;
	@FXML
	private Label lbl4;
	@FXML
	private Label lbl5;
	@FXML
	private Label lbl6;
	@FXML
	private Label lbl7;
	@FXML
	private Label lbl8;
	@FXML
	private Label lbl9;
	@FXML
	private Label placarX;
	@FXML
	private Label placarO;
	@FXML
	private Label empate;

	private GameMatch game;

	public void gmSVC(GameMatch game) {
		this.game = game;
	}

	@FXML
	public void menu() {
		game.finaliza=3;
		game.listPlacar(game.placarFinal);
		loadView("/gui/MainView.fxml");
	}

	@FXML
	public void lbl1() {
		clickLabel(lbl1, game.vezJogador());
	}

	@FXML
	public void lbl2() {
		clickLabel(lbl2, game.vezJogador());
	}

	@FXML
	public void lbl3() {
		clickLabel(lbl3, game.vezJogador());
	}

	@FXML
	public void lbl4() {
		clickLabel(lbl4, game.vezJogador());
	}

	@FXML
	public void lbl5() {
		clickLabel(lbl5, game.vezJogador());
	}

	@FXML
	public void lbl6() {
		clickLabel(lbl6, game.vezJogador());
	}

	@FXML
	public void lbl7() {
		clickLabel(lbl7, game.vezJogador());
	}

	@FXML
	public void lbl8() {
		clickLabel(lbl8, game.vezJogador());
	}

	@FXML
	public void lbl9() {
		clickLabel(lbl9, game.vezJogador());
	}

	@FXML
	public void btnSim() {
		game.retry(lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9);
		initialize(null, null);
	}

	// Funcao para exibir texto na label informando a vez do jogador
	private void definirPlayer(Player player) {
		lblTxt.setText(player.toString());
	}

	// Funcao para inser peca, validar posicao na matriz e retornar vencedor se
	// houver
	private void clickLabel(Label lbl, Player player) {
		if (game.finaliza == 0) {
			definirPlayer(game.labelNome());
			lbl.setTextFill(Color.GOLD);
			lbl.setText(player.getPeca());
			lbl.setDisable(true);
			char x = lbl.getId().trim().charAt(3);
			String s = String.valueOf(x);
			int i = Integer.parseInt(s);
			game.movimento(player, i);
			game.setLine(linha);
		}
		if (game.finaliza > 0) {
			empate.setText("E: " + game.empate);
			placarO.setText("O: " + game.placarO);
			placarX.setText("X: " + game.placarX);
			lblTxt.setText(null);
			lblQuestion.setVisible(true);
			btnSim.setVisible(true);
			btnNao.setVisible(true);
		}
	}

	@Override
	public synchronized void initialize(URL arg0, ResourceBundle arg1) {
		linha.setVisible(false);
		linha.setLayoutX(258);
		linha.setLayoutY(14);
		linha.setRotate(0);
		linha.setStartX(220);
		linha.setEndX(-246);
		btnSim.setVisible(false);
		btnNao.setVisible(false);
		lblQuestion.setVisible(false);
		Alert.showAlert("Informação", null, "O jogador que escolheu X começa!", AlertType.INFORMATION);
	}
	
	private void loadView(String tela) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(tela));
			AnchorPane anchor = loader.load();
			Scene mainScene = Main.getMainScene();
			AnchorPane mainAnchorPane = (AnchorPane) ((AnchorPane)mainScene.getRoot());
			mainAnchorPane.getChildren().clear();
			mainAnchorPane.getChildren().addAll(anchor.getChildren());
			
		} catch (IOException e) {
			e.printStackTrace();
			Alert.showAlert("Erro", null, "Erro ao carregar a tela!\n" +e.getMessage(),AlertType.ERROR);
		}
	}
}
