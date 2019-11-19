package exceptions;

public class CJAException extends Exception {
	public CJAException() {
		super("O carro que voce esta procurando ja foi alugado.");
	}
}
