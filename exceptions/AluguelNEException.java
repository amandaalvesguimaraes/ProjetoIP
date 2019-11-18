package Aluguel;

//Aluguel nao encontrado
public class AluguelNEException extends Exception{
	public AluguelNEException() {
		super("O cliente não efetuou nenhum aluguel até o momento.");
	}

}
