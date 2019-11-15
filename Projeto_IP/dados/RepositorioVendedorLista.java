package dados;
import vendedores.*;

public class RepositorioVendedorLista implements RepositorioVendedor{
	private Vendedor funcionario;
	private RepositorioVendedorLista proximo;
	
	
	public RepositorioVendedorLista() {
		this.funcionario=null;
		this.proximo=null;
	}
	
	
	public void inserir(Vendedor vendedor) {
		if (this.proximo==null) {
			this.funcionario=vendedor;
			this.proximo = new RepositorioVendedorLista();
		} else {
			this.proximo.inserir(vendedor);
		}
	}
	
	
	public void remover(int matricula) {
		if (this.funcionario.getMatricula()==matricula) {
			this.funcionario=this.proximo.funcionario;
			this.proximo=this.proximo.proximo;
		} else {
			this.proximo.remover(matricula);
		}
	}
	
	 
	public Vendedor procurar(int matricula) {
		if (this.funcionario.getMatricula()==matricula) {
			return this.funcionario;
		} else {
			return this.proximo.procurar(matricula);
		}
	}
	
	
	public boolean existeMatricula(int matricula){
		if (this.proximo==null) {
			return false;
		} else if (this.funcionario.getMatricula()==matricula) {
			return true;
		} else {
			return this.proximo.existeMatricula(matricula);
		}
	}
	
	
	public void atualizar(Vendedor vendedor, int matricula) {
		if (this.funcionario.getMatricula()==matricula) {
			this.funcionario = vendedor;
		} else {
			this.proximo.atualizar(vendedor,matricula); //atualização feita
		}
	}
}
