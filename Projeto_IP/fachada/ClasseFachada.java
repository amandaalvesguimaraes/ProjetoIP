package fachada;
import carros.*;
import dados.*;
import exceptions.*;
import vendedores.*;

public class ClasseFachada {
	private CadastroCarros cadastrocarro;
	//private CadastroAluguel cadastroaluguel;
	private CadastroVendedor cadastrovendedor;
	// private CadastroCliente cadastrocliente;
	public ClasseFachada(CadastroCarros ccar, CadastroVendedor cven) { // (CadastroCliente ccli, CadastroAluguel cal) {
		this.cadastrocarro = ccar;
		this.cadastrovendedor = cven;
		// thiscadastroaluguel = cal;
		// this.cadastrocliente = ccli;
	}
	
	public void cadastrarCarro(Carros carro) throws CCException, QPIException, PDIException, ANException {
		this.cadastrocarro.cadastrar(carro);
	}
	
	public void removerCarro(String p) throws PNEException {
		this.cadastrocarro.remover(p);
	}
	
	public Carros procurarCarro(String p) throws PNEException {
		return this.cadastrocarro.procurar(p);
	}
	
	public void atualizarCarro(Carros carro, String pa) throws PEException, CCException, PNEException, QPIException, PDIException, ANException {
		this.cadastrocarro.atualizar(carro, pa);
	}
	
	public boolean existePlaca(String p) {
		return this.cadastrocarro.existePlaca(p);
	}
	
	public boolean isAlugado(String p) throws PNEException {
		return this.cadastrocarro.isAlugado(p);
	}
	
	public void cadastrarVendedor(Vendedor vendedor) throws VCException, MATException, TELException, CPFException {
		this.cadastrovendedor.cadastrar(vendedor);
	}
	
	public void removerVendedor(int matricula) throws FNEException {
		this.cadastrovendedor.remover(matricula);
	}
	
	public void atualizarVendedor(Vendedor vendedor, int matricula) throws VCException, MNException, TELException, CPFException {
		this.cadastrovendedor.atualizar(vendedor, matricula);
	}
	
	public boolean existeVendedor(int matricula) {
		return this.cadastrovendedor.existe(matricula);
	}
	
	public Vendedor procurarVendedor(int matricula) throws VCException {
		return this.cadastrovendedor.procurar(matricula);
	}
}

