package sistemaaluguel;

public class PEException extends Exception {
	
	public PEException() {
		super ("N�o foi poss�vel atualizar o cadastro. A placa informada j� existe.");
	}
}
