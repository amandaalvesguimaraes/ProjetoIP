
public class CadastroAluguel {
	private RepositorioAlugados alugueis;
	private RepositorioCliente clientes;
	
	public CadastroAluguel(RepositorioAlugados rep) {
		alugueis = rep;
	}
	
	public void cadastrar(Aluguel aluguel) throws CJAException, DiaIException{
		if (!alugueis.procurarCarro(aluguel.getCarros())) {
			if  (aluguel.getDias() > 0) {
				try {
					clientes.procurar(aluguel.getCliente().getCpf());
					alugueis.alugar(aluguel);
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
		if (alugueis.procurarCarro(aluguel.getCarros()) == true) {
			alugueis.remover(aluguel.getCarros());
		}else {
			throw new CNAException();
		}
	}
	
	// faltam outros métodos, como atualizar, procurar aluguel(pode usar como parametro pra procurar aluguel o cpf do cliente ou a placa do carro)
	// quando tu cadastrar um aluguel, pega o carro e usa nele o método .setAlugado() pq vai mudar o status dele;
}
