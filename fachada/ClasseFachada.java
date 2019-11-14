package fachada;
import dados.*;
import sistemaaluguel.*;

public class ClasseFachada {
	private CadastroCarros cadastrocarro;
	//private CadastroAluguel cadastroaluguel;
	//private CadastroFuncionario cadastrofuncionario;
	// private CadastroCliente cadastrocliente;
	public ClasseFachada(CadastroCarros ccar) { //, CadastroFuncionario cfun, CadastroCliente ccli, CadastroAluguel cal) {
		this.cadastrocarro = ccar;
		// thiscadastroaluguel = cal;
		// this.cadastrofuncionario = cfun;
		// this.cadastrocliente = ccli;
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
