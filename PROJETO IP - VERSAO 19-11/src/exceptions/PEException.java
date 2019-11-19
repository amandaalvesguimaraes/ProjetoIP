package exceptions;


public class PEException extends Exception {	
	public PEException() {
		super ("Nao foi possivel atualizar o cadastro. A placa informada ja existe.");
	}
}
