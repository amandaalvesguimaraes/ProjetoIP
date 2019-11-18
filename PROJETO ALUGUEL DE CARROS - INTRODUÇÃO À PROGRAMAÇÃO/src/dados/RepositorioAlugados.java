package dados;
import alugueis.*;
import carros.*;
import clientes.*;
import exceptions.*;

public interface RepositorioAlugados {
	public void alugar(Aluguel aluguel);
	public void remover(Aluguel aluguel) throws CNAException;
	public void atualizar(Aluguel aluguel) throws ANException;
	public boolean existeClienteAlugando(String cpf); // vê se o carro foi alugado ou não
	public boolean existeCarroAlugado(String placa); //vê se o cliente já fez um aluguel
	public Aluguel procurarAluguelCarro(String placa) throws CNAException;
	public Aluguel procurarAluguelCliente(String cpf) throws ANException;
}
