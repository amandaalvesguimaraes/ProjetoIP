package vendedores;
import exceptions.*;
import dados.*;

public class CadastroVendedor {
	private RepositorioVendedor rv;
	
	public CadastroVendedor(RepositorioVendedor rv) {
		this.rv=rv;
	}
	
	public void cadastrar(Vendedor vendedor) throws VCException, MATException, TELException, CPFException{
		if (this.existe(vendedor.getMatricula())==false) {
			if (vendedor.getMatricula()<10000 || vendedor.getMatricula()>99999) {
				throw new MATException(); //matricula invalida
			} else {
				char[] c = new char[8];
				for (int i=0; i<8; i++) {
					c[i]=vendedor.getTelefone().charAt(i);
					if (!Character.isDigit(c[i])) {
						throw new TELException(); //telefone invalido
					} else {
						if (c[i]<0) {
							throw new TELException(); //telefone invalido
						}
					}
				}
				char[] d = new char[11];
				for (int i=0; i<11; i++) {
					d[i]=vendedor.getCpf().charAt(i);
					if (!Character.isDigit(d[i])) {
						throw new CPFException(); //cpf invalido
					} else {
						if (d[i]<0) {
							throw new CPFException(); //cpf invalido
						}
					}
				}
				this.rv.inserir(vendedor);
				
			}

		} else {
			throw new VCException(); //vendedor ja cadastrado
		}
	}
	
	public void remover(int matricula) throws FNEException{
		if (this.existe(matricula)) {
			this.rv.remover(matricula);
		} else {
			throw new FNEException(); //funcionario nao encontrado
		}
	}
	
	public void atualizar(Vendedor vendedor, int matricula) throws VCException, MNException, TELException, CPFException{
		if (this.existe(matricula)) {
			if (vendedor.getMatricula()!=matricula) { //matricula nova diferente da antiga
				if (vendedor.getMatricula()<10000 || vendedor.getMatricula()>99999) {
					throw new MNException(); //matricula nova invalida
				}
			}
			char[] c = new char[8];
			for (int i=0; i<8; i++) {
			c[i] = vendedor.getTelefone().charAt(i);
			if (!Character.isDigit(c[i])) {
				throw new TELException(); //telefone invalido
			} else {
				if (c[i]<0) {
					throw new TELException(); //telefone invalido
				}
			}
			}
			
			char[] d = new char[11];
			for (int i=0; i<11; i++) {
				c[i]=vendedor.getCpf().charAt(i);
				if (!Character.isDigit(c[i])) {
					throw new CPFException(); //cpf invalido
				} else {
					if (c[i]<0) {
						throw new CPFException(); //cpf invalido
					}
				}
			}
			this.rv.atualizar(vendedor,matricula);
		} else {
			throw new VCException();
		}
	}
	
	public Vendedor procurar(int matricula) throws VCException{
		if (this.existe(matricula)) {
			return this.rv.procurar(matricula);
		} else {
			throw new VCException();
		}
	}
	
	public boolean existe(int matricula) {
		return rv.existeMatricula(matricula);
	}
}
