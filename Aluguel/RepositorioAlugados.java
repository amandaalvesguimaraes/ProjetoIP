
public interface RepositorioAlugados {
	public void alugar(Aluguel aluguel);
	public void remover(Carros carro) throws CNAException;
	public boolean procurarCarro(Carros carro); // vê se o carro foi alugado ou não
	public boolean procurarCliente(Cliente cliente); //vê se o cliente já fez um aluguel
	public int analisarDiasCarro(Carros carro) throws CNAException; //vê a quantidade de dias que restam para o carro voltar a estar disponível
	
}
