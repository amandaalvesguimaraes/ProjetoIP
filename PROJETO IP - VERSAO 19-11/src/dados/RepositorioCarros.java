package dados;
import carros.*;

public interface RepositorioCarros {
	void inserir(Carros carro);
	Carros procurar(String p); //placa do carro
	void remover(String p); //placa do carro
	void atualizar(Carros carro, String p);
	boolean existePlaca(String p); //placa do carro
	boolean isAlugado(String p);
}

