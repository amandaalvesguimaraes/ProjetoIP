package Aluguel;

public class CJAException extends Exception {
	public CJAException() {
		super("O carro que você está procurando já foi alugado.");
	}
}
