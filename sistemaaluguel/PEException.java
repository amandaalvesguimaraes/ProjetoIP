package sistemaaluguel;

public class PEException extends Exception {
	
	public PEException() {
		super ("Não foi possível atualizar o cadastro. A placa informada já existe.");
	}
}
