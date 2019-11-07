package projetoip;

public interface RepositorioCarros {
	void cadastrar(Carros  carro) throws CCException;
	Carros procurar(String p) throws PNEException; //placa do carro
	void remover(String p) throws PNEException; //placa do carro
	void atualizar(Carros carro, String p) throws PNEException, CCException;
	boolean existePlaca(String p); //placa do carro
	boolean existeModelo(String m); //modelo do carro
}
