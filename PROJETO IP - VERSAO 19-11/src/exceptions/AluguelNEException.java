package Aluguel;

//Aluguel nao encontrado
public class AluguelNEException extends Exception{
	public AluguelNEException() {
		super("O cliente n�o efetuou nenhum aluguel at� o momento.");
	}

}
