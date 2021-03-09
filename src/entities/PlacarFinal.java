package entities;

public class PlacarFinal {
	private String player1;
	private String player2;
	private String resultado;
	
	public PlacarFinal() {
	}

	public PlacarFinal(String player1, String player2, String resultado) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.resultado = resultado;
	}

	public String getPlayer1() {
		return player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public String getResultado() {
		return resultado;
	}

	@Override
	public String toString() {
		return player1+", "+player2+", "+resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player1 == null) ? 0 : player1.hashCode());
		result = prime * result + ((player2 == null) ? 0 : player2.hashCode());
		result = prime * result + ((resultado == null) ? 0 : resultado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlacarFinal other = (PlacarFinal) obj;
		if (player1 == null) {
			if (other.player1 != null)
				return false;
		} else if (!player1.equals(other.player1))
			return false;
		if (player2 == null) {
			if (other.player2 != null)
				return false;
		} else if (!player2.equals(other.player2))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		return true;
	}
	
	
}
