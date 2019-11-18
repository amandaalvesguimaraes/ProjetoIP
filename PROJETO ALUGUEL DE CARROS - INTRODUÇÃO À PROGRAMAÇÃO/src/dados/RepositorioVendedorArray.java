package dados;
import vendedores.*;

public class RepositorioVendedorArray implements RepositorioVendedor{
	private Vendedor[] funcionario;
	private int indice;
	
	
	public RepositorioVendedorArray(int valor) {
		indice=0;
		this.funcionario=new Vendedor[valor];
	}
	
	
	public void inserir(Vendedor vendedor) {
			funcionario[indice]=vendedor;
			indice=indice+1;
	}
	
	
	public void remover(int matricula){
		for (int i=0; i < indice; i++) {
			if (this.funcionario[i] != null) {
				if (this.funcionario[i].getMatricula()==matricula) {
					this.funcionario[i]=null;
				}
			}
		}
	}
	
	
	public Vendedor procurar(int matricula){
		Vendedor v=null; //
		for (int i=0; i<indice; i++) {
			if (this.funcionario[i] != null) {
				if (this.funcionario[i].getMatricula()==matricula) {
					v=funcionario[i];
				}
			}
		}
		return v;
	}
	
	
	public boolean existeMatricula(int matricula) {
		boolean existe = false;
		for (int i=0; i<indice; i++) {
			if (this.funcionario[i] != null) {
				if (this.funcionario[i].getMatricula()==matricula) {
					existe=true;
				}
			}
		}
		return existe;
	}
	
	
	public void atualizar(Vendedor vendedor, int matricula) {
		for (int i=0; i<indice; i++) {
			if (this.funcionario[i] != null) {
				if (funcionario[i].getMatricula()==matricula) {
					funcionario[i]=vendedor;
				}
			}
		}
	}
}

