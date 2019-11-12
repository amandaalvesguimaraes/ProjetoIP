
public interface RepositorioAlugados {
	public void alugar(Aluguel aluguel);
	public void remover(Carros carro) throws CNAException;
	public boolean procurarCarro(Carros carro); // v� se o carro foi alugado ou n�o
	public boolean procurarCliente(Cliente cliente); //v� se o cliente j� fez um aluguel
	public int analisarDiasCarro(Carros carro) throws CNAException; //v� a quantidade de dias que restam para o carro voltar a estar dispon�vel
	
}
