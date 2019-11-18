package Aluguel;

public class CadastroAluguel {
	private RepositorioAlugados alugueis;
	private RepositorioCliente clientes;
	
	public CadastroAluguel(RepositorioAlugados rep1, RepositorioCliente rep2) {
		alugueis = rep1;
		clientes = rep2;
	}
	
	public void cadastrar(Aluguel aluguel) throws CJAException, DiaIException{
//		if (!alugueis.procurarCarro(aluguel.getCarros())) {
		if (aluguel.getCarros().isAlugado() == false) {
			if  (aluguel.getDias() > 0) {
				try {
					clientes.procurar(aluguel.getCliente().getCpf());
					alugueis.alugar(aluguel);
					aluguel.getCarros().setAlugado(true);
				}catch(CNexception cn) {
					cn.getMessage();
				}
			}else {
				throw new DiaIException();
			}
		}else {
			throw new CJAException();
		}
		
	}
	
	public void remover(Aluguel aluguel) throws CNAException {
		if (alugueis.existeCarroAlugado(aluguel.getCarros().getPlaca()) == true) {
			alugueis.remover(aluguel);
			aluguel.getCarros().setAlugado(false);
		}else {
			throw new CNAException(	);
		}
	}
	public void atualizar(Aluguel aluguel) throws AluguelNEException {
		if (alugueis.existeClienteAlugando(aluguel.getCliente().getCpf()) == true) {
			alugueis.atualizar(aluguel);
		}else {
			throw new AluguelNEException();
		}
	}
	
	public boolean existeClienteAlugando(String cpf) {
		return alugueis.existeClienteAlugando(cpf);
	}
	
	public boolean existeCarroAlugado(String placa) {
		return alugueis.existeCarroAlugado(placa);
	}
	
	public Aluguel procurarAluguelCarro(String placa) throws CNAException{
		if (existeCarroAlugado(placa)) {
			return alugueis.procurarAluguelCarro(placa);
		} else {
			throw new CNAException();
		}
	}
	
	public Aluguel procurarAluguelCliente(String cpf) throws AluguelNEException {
		if (existeClienteAlugando(cpf)) {
			return alugueis.procurarAluguelCliente(cpf);
		} else {
			throw new AluguelNEException();
		}
	}
	
	// faltam outros métodos, como atualizar, procurar aluguel(pode usar como parametro pra procurar aluguel o cpf do cliente ou a placa do carro)
	// quando tu cadastrar um aluguel, pega o carro e usa nele o método .setAlugado() pq vai mudar o status dele;
}
