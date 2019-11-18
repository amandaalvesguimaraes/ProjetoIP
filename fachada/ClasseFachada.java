package fachada;
import dados.*;
import sistemaaluguel.*;
import Clientes.*;
import exceptions.*;

public class ClasseFachada {
	private CadastroCarros cadastrocarro;
	//private CadastroAluguel alugueis;
	//private CadastroFuncionario funcionarios;
	private CadastroCliente clientes;
	public ClasseFachada(CadastroCarros ccar, CadastroCliente ccli) { // CadastroFuncionario cfun, CadastroAluguel cal) {
		this.cadastrocarro = ccar;
		// this.alugueis = cal;
		// this.funcionarios = cfun;
		this.clientes = ccli;
	}
	public void cadastrarCliente(Cliente cliente) throws CJCexception, IDexception {
		this.clientes.cadastrar(cliente);
	}
	public void removerCliente(String cpf) throws CNexception{
		this.clientes.remover(cpf);
	}
	public String atualizarCliente(Cliente cliente) throws CNexception, IDexception {
		this.clientes.atualizar(cliente);
	}
	public Cliente procurar(String cpf) throws CNexception {
		this.clientes.procurar(cpf);
	}
	
	public void cadastrarCarro(String a, String b, String c, int d, int qp, double pd) throws CCException, QPIException, PDIException, ANException {
		this.cadastrocarro.cadastrar(a, b, c, d, qp, pd);
	}
	
	public void removerCarro(String p) throws PNEException {
		this.cadastrocarro.remover(p);
	}
	
	public Carros procurarCarro(String p) throws PNEException {
		return this.cadastrocarro.procurar(p);
	}
	
	public void atualizarCarro(String m, String c, String p, int a, int qp, double pd, String pa) throws PEException, CCException, PNEException, QPIException, PDIException, ANException {
		this.cadastrocarro.atualizar(m, c, p, a, qp, pd, pa);
	}
	
	public boolean existePlaca(String p) {
		return this.cadastrocarro.existePlaca(p);
	}
	
	public boolean isAlugado(String p) throws PNEException {
		return this.cadastrocarro.isAlugado(p);
	}
}
