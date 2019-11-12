
public class RepositorioAlugadosLista implements RepositorioAlugados {
	private RepositorioAlugadosLista proximo;
	private Aluguel aluguel;
	
	public RepositorioAlugadosLista() {
		this.aluguel = null;
		this.proximo = null;
	}
	
	public void alugar(Aluguel aluguel) {
		if (aluguel == null) {
			this.aluguel = aluguel;
			this.proximo = new RepositorioAlugadosLista();
		} else {
			this.proximo.alugar(aluguel);
		}
	}
	public void remover(Carros carro) throws CNAException{
		if (procurarCarro(carro) == true ) {
			if (this.aluguel.getCarros() == carro) {
				this.aluguel = this.proximo.aluguel;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(carro);
			}
		}else {
			throw new CNAException();
		}
	}

	public boolean procurarCarro(Carros carro) {
		if (this.aluguel != null) {
			if (this.aluguel.getCarros() == carro) {
				return true;
			} else {
				return this.proximo.procurarCarro(carro);
			}
		}else {
			return false;
		}
	}
	
	public boolean procurarCliente(Cliente cliente) {
		if (this.aluguel != null) {
			if (this.aluguel.getCliente() == cliente) {
				return true;
			} else {
				return this.proximo.procurarCliente(cliente);
			}
		}else {
			return false;
		}
	}
	public int analisarDiasCarro(Carros carro) throws CNAException {
		if (procurarCarro(carro) == true) {
			if (this.aluguel.getCarros() == carro) {
				return this.aluguel.getDias();
			} else {
				return this.proximo.analisarDiasCarro(carro);
			}
		}else {
			throw new CNAException();
		}
	}
	
	
	
}
