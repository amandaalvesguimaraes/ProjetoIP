package Aluguel;

public class CJAException extends Exception {
	public CJAException() {
		super("O carro que voc� est� procurando j� foi alugado.");
	}
}
