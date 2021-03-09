package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gui.GameViewController;
import gui.util.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GameMatch {

	public List<String> list = new ArrayList<String>();
	public int position = 0;
	public GameViewController gv = new GameViewController();
	public Player player1 = new Player();
	public Player player2 = new Player();
	public PlacarFinal placarFinal = new PlacarFinal();
	public Map<String, PlacarFinal> listPF = new HashMap<String, PlacarFinal>();
	public int jogada = 1;
	public String[][] mat = new String[3][3];
	public double x, y, r;
	public Integer finaliza = 0;
	public int placarX, placarO, empate;

	public void gameMatch() {
	}

	// Funcao retry
	public void retry(Label lbl1, Label lbl2, Label lbl3, Label lbl4, Label lbl5, Label lbl6, Label lbl7, Label lbl8,
			Label lbl9) {

		lbl1.setText(null);
		lbl1.setDisable(false);
		lbl2.setText(null);
		lbl2.setDisable(false);
		lbl3.setText(null);
		lbl3.setDisable(false);
		lbl4.setText(null);
		lbl4.setDisable(false);
		lbl5.setText(null);
		lbl5.setDisable(false);
		lbl6.setText(null);
		lbl6.setDisable(false);
		lbl7.setText(null);
		lbl7.setDisable(false);
		lbl8.setText(null);
		lbl8.setDisable(false);
		lbl9.setText(null);
		lbl9.setDisable(false);

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				mat[i][j] = null;
			}
		}
		jogada = 1;

		finaliza = 0;
	}

	// Funcao para passar os valores para os atributos do jogador, que
	// serao pegos atraves da interface grafica
	public void setInfo(String p1, String p2, String pc1, String pc2) {
		player1.setNome(p1);
		player2.setNome(p2);
		player1.setPeca(pc1);
		player2.setPeca(pc2);
		player1.setPlayer("player1");
		player2.setPlayer("player2");

	}

	// Tratamento para retornar nome do player ao clicar
	public Player labelNome() {
		if (vezJogador().getPlayer().contains("player1")) {
			return player2;
		} else {
			return player1;
		}
	}

	// Tratamento de jogador da primeira rodada
	public Player primeiraRodada() {
		if (player1.getPeca().contains("X")) {
			return player1;
		} else {
			return player2;
		}
	}

	// Funcao para retornar o jogador em sua vez
	public Player vezJogador() {
		if (jogada == 1) {
			return primeiraRodada();
		} else if (jogada % 2 == 0 && player1.getPeca().contains("O")) {
			return player1;
		} else if (jogada % 2 != 0 && player1.getPeca().contains("X")) {
			return player1;
		} else {
			return player2;
		}

	}

	// Funcao para tranferir valor inteiro para um valor da matriz
	public void movimento(Player player, int posicao) {

		switch (posicao) {
		case 1:
			mat[0][0] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 2:
			mat[1][0] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 3:
			mat[2][0] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 4:
			mat[0][1] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 5:
			mat[1][1] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 6:
			mat[2][1] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 7:
			mat[0][2] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 8:
			mat[1][2] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		case 9:
			mat[2][2] = player.getPeca();
			verificaPreenchimento(player);
			jogada++;
			break;

		default:
			break;
		}
	}

	// Funcao para exibir linha na tela
	public void setLine(Line linha) {
		if (finaliza == 1) {
			linha.setLayoutX(x);
			linha.setLayoutY(y);
			linha.setRotate(r);
			linha.setStrokeWidth(2);
			linha.setStroke(Color.GRAY);
			linha.setVisible(true);
		} else {
			linha.setVisible(false);
		}
	}

	// Funcao que retorna posicao da linha na tela
	public void exibeLinha(int s) {

		switch (s) {
		case 159:
			x = 263;
			y = 219;
			r = 44;
			break;

		case 357:
			x = 263;
			y = 219;
			r = 135;
			break;

		case 147:
			x = 123;
			y = 219;
			r = 90;
			break;

		case 258:
			x = 263;
			y = 219;
			r = 90;
			break;

		case 369:
			x = 403;
			y = 219;
			r = 90;
			break;

		case 123:
			x = 263;
			y = 84;
			r = 0;
			break;

		case 456:
			x = 263;
			y = 219;
			r = 0;
			break;

		case 789:
			x = 263;
			y = 357;
			r = 0;
			break;

		default:
			break;
		}
	}

	// Verifica se todas as posicoes da matriz foram preenchidas, pega as posiçoes
	// atraves da interface grafica
	public void verificaPreenchimento(Player player) {

		if ((mat[0][0] != null) && (mat[0][1] != null) && (mat[0][2] != null)) {
			finaliza = 0;
		}

		if ((mat[1][0] != null) && (mat[1][1] != null) && (mat[1][2] != null)) {
			finaliza = 0;
		}

		if ((mat[2][0] != null) && (mat[2][1] != null) && (mat[2][2] != null)) {
			finaliza = 0;
		}

		if ((mat[0][0] != null) && (mat[1][0] != null) && (mat[2][0] != null)) {
			finaliza = 0;
		}

		if ((mat[0][1] != null) && (mat[1][1] != null) && (mat[2][1] != null)) {
			finaliza = 0;
		}

		if ((mat[0][2] != null) && (mat[1][2] != null) && (mat[2][2] != null)) {
			finaliza = 0;
		}

		if ((mat[0][0] != null) && (mat[1][1] != null) && (mat[2][2] != null)) {
			finaliza = 0;
		}

		if ((mat[2][0] != null) && (mat[1][1] != null) && (mat[0][2] != null)) {
			finaliza = 0;
		}

		if (finaliza == 0) {
			vencedor(player);
		}
	}

	// Verifica se alguem ganhou o jogo
	public void vencedor(Player player) {

		String x = player.getPeca();
		String y = player.getNome();

		if ((mat[0][0] == x) && (mat[0][1] == x) && (mat[0][2] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(147);
			finaliza = 1;
		}

		if ((mat[1][0] == x) && (mat[1][1] == x) && (mat[1][2] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(258);
			finaliza = 1;
		}

		if ((mat[2][0] == x) && (mat[2][1] == x) && (mat[2][2] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(369);
			finaliza = 1;
		}

		if ((mat[0][0] == x) && (mat[1][0] == x) && (mat[2][0] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(123);
			finaliza = 1;
		}

		if ((mat[0][1] == x) && (mat[1][1] == x) && (mat[2][1] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(456);
			finaliza = 1;
		}

		if ((mat[0][2] == x) && (mat[1][2] == x) && (mat[2][2] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(789);
			finaliza = 1;
		}

		if ((mat[0][0] == x) && (mat[1][1] == x) && (mat[2][2] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(159);
			finaliza = 1;
		}

		if ((mat[2][0] == x) && (mat[1][1] == x) && (mat[0][2] == x)) {
			Alert.showAlert("Fim da partida", null, "O jogador " + y + " ganhou", AlertType.CONFIRMATION);
			exibeLinha(357);
			finaliza = 1;
		}

		if ((mat[0][0] != null) && (mat[0][1] != null) && (mat[0][2] != null) && (mat[1][0] != null)
				&& (mat[1][1] != null) && (mat[1][2] != null) && (mat[2][0] != null) && (mat[2][1] != null)
				&& (mat[2][2] != null) && (finaliza == 0)) {

			Alert.showAlert("Fim da partida", null, "Houve um empate", AlertType.CONFIRMATION);
			empate++;
			finaliza = 2;
		}

		if (finaliza == 1) {
			placar(player);
		}
	}

	// Funcao para definir placar
	public void placar(Player player) {
		if (player.getPeca().contains("X")) {
			placarX++;
			player.setPlacar(placarX);
		}
		if (player.getPeca().contains("O")) {
			placarO++;
			player.setPlacar(placarO);
		}

		placarFinal = new PlacarFinal(player1.getNome() + " " + player1.getPeca(),
				player2.getNome() + " " + player2.getPeca(), player1.getPeca() + ": " + player1.getPlacar() + " "
						+ player2.getPeca() + ": " + player2.getPlacar() + " E: " + empate);

		listPlacar(placarFinal);

	}

	// Funcao para adicionar placar a lista
	public void listPlacar(PlacarFinal placarFinal) {
		if ((placarX != 0 || placarO != 0 || empate != 0) && finaliza == 3) {

			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\temp\\registroDosJogos.txt", true))){

				listPF.put(placarFinal.toString(), placarFinal);
				String[] line = new String[] { listPF.get(placarFinal.toString()).toString() };
				for (String strings : line) {
					bw.write(strings);
					bw.newLine();
				}
				Alert.showAlert("Information", null, "Um registro do jogo foi salvo no caminho:\nC:\\temp\\registroDosJogos.txt", AlertType.INFORMATION);
			}

			catch (IOException e) {
				Alert.showAlert("Erro", null, "Erro ao salvar registro dos jogos!\n" + e.getMessage(), AlertType.ERROR);
			}
		}
	}
}
