package entities;

public class Player {
	
	private String peca;
	private String nome;
	private String player;
	private int placar;
	
	public Player() {
	}
	
	public Player(String peca, String nome) {
		this.peca = peca;
		this.nome = nome;
	}

	public String getPeca() {
		return peca;
	}

	public String getNome() {
		return nome;
	}
	
	public String getPlayer() {
		return player;
	}

	public int getPlacar() {
		return placar;
	}

	public void setPeca(String peca) {
		this.peca = peca;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPlayer(String player) {
		this.player = player;
	}
	
	public void setPlacar(int placar) {
		this.placar = placar;
	}

	@Override
	public String toString() {
		return "Vez do jogador(a): " + nome;
	}
	
}
