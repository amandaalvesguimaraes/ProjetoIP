package exceptions;

public class NPAException extends Exception {
	public NPAException() {
		super ("Não foi possível atualizar o veículo. O carro está sendo alugado!");
	}
}
