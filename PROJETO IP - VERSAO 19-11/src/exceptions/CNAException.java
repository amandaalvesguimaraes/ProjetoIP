package exceptions;

public class CNAException extends Exception{
	public CNAException() {
		super("O carro que voce esta procurando nao foi alugado.");
	}
}
