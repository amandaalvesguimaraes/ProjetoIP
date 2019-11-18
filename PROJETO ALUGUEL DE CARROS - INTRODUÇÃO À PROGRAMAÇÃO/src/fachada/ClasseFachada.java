package fachada;
import carros.*;
import dados.*;
import exceptions.*;
import vendedores.*;
import clientes.*;
import alugueis.*;

public class ClasseFachada {
	private CadastroCarros cadastrocarro;
	private CadastroAluguel cadastroaluguel;
	private CadastroVendedor cadastrovendedor;
	private CadastroClientes cadastrocliente;
	
	public ClasseFachada(CadastroCarros ccar, CadastroVendedor cven, CadastroClientes ccli, CadastroAluguel cal) {
		this.cadastrocarro = ccar;
		this.cadastrovendedor = cven;
		this.cadastroaluguel = cal;
		this.cadastrocliente = ccli;
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
	
	public void cadastrarCliente(Cliente cliente) throws CJCexception, IDexception {
		this.cadastrocliente.cadastrar(cliente);
	}
	
	public void removerCliente(String cpf) throws CNexception{
		this.cadastrocliente.remover(cpf);
	}
	
	public void atualizarCliente(Cliente cliente, String cpfantigo, String cnhantigo) throws CNexception, IDexception, CPFException {
		this.cadastrocliente.atualizar(cliente, cpfantigo, cnhantigo);
	}
	
	public Cliente procurarCliente(String cpf) throws CNexception {
		return this.cadastrocliente.procurar(cpf);
	}
	
	public boolean existeCliente(String cpf) {
		return this.cadastrocliente.existeCPF(cpf);
	}
	
	public void cadastrarAluguel(Aluguel aluguel) throws CJAException, CJACException, CaNCException, CNCException, VNCException, DiaIException, CNexception {
		if (this.cadastrocarro.existePlaca(aluguel.getCarros().getPlaca())) {
			if (this.cadastrocliente.existeCPF(aluguel.getCliente().getCpf())) {
				if (this.cadastrovendedor.existe(aluguel.getVendedor().getMatricula())) {
					this.cadastroaluguel.cadastrar(aluguel);
				} else {
					throw new VNCException();
				}
			} else {
				throw new CNCException();
			}
		} else {
			throw new CaNCException();
		}
	}
	
	public void removerAluguel(String cpf) throws ANEException, CNAException, ANException {
		Aluguel a = null;
		a = this.cadastroaluguel.procurarAluguelCliente(cpf);
		this.cadastroaluguel.remover(a);
	}
	
	public void atualizarAluguel(Aluguel aluguel, String placaantiga, String cpfantigo) throws PNEException, CNexception, CJAException, CJACException, CaNCException, VNCException, CNCException, ANException {
		if (this.cadastrocarro.isAlugado(placaantiga)) {
			if (this.cadastroaluguel.existeClienteAlugando(cpfantigo)) {
				if (this.cadastrocarro.existePlaca(aluguel.getCarros().getPlaca())) {
					if (this.cadastrocliente.existeCPF(aluguel.getCliente().getCpf())) {
						if (this.cadastrovendedor.existe(aluguel.getVendedor().getMatricula())) {
							Cliente a = null;
							Carros b = null;
							a = this.cadastrocliente.procurar(cpfantigo);
							b = this.cadastrocarro.procurar(placaantiga);
							this.cadastroaluguel.atualizar(aluguel);
						} else {
							throw new VNCException();
						}
					} else {
						throw new CNCException();
					}
				} else {
					throw new CaNCException();
				}
			} else {
				throw new CNexception();
			}
		} else {
			throw new CaNCException();
		}
	}
	
	public boolean existeClienteAlugando(String cpf) {
		return this.cadastroaluguel.existeClienteAlugando(cpf);
	}
	
	public boolean existeCarroAlugado(String placa) {
		return this.cadastroaluguel.existeCarroAlugado(placa);
	}
	
	public Aluguel procurarAluguelCarro(String placa) throws CaNCException, CNAException {
		if (this.cadastrocarro.existePlaca(placa)) {
			return this.cadastroaluguel.procurarAluguelCarro(placa);
		} else {
			throw new CaNCException();
		}
	}
	
	public Aluguel procurarAluguelCliente(String cpf) throws CNCException, ANException {
		if (this.cadastrocliente.existeCPF(cpf)) {
			return this.cadastroaluguel.procurarAluguelCliente(cpf);
		} else {
			throw new CNCException();
		}
	}
	
}

