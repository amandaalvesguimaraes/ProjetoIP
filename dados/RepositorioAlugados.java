package Aluguel;

public interface RepositorioAlugados {
	public void alugar(Aluguel aluguel);
	public void remover(Aluguel aluguel) throws CNAException;
	public void atualizar(Aluguel aluguel) throws AluguelNEException;
	public boolean existeClienteAlugando(String cpf); // v� se o carro foi alugado ou n�o
	public boolean existeCarroAlugado(String placa); //v� se o cliente j� fez um aluguel
	public Aluguel procurarAluguelCarro(String placa) throws CNAException;
	public Aluguel procurarAluguelCliente(String cpf) throws AluguelNEException;
}
