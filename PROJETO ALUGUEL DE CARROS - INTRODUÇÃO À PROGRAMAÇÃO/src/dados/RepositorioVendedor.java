package dados;
import vendedores.*;

public interface RepositorioVendedor {
	void inserir(Vendedor vendedor);
	void remover(int matricula);
	Vendedor procurar(int matricula);
	boolean existeMatricula(int matricula);
	void atualizar(Vendedor vendedor, int matricula);
}

