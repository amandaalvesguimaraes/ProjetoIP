
public class RepositorioAlugadosArray implements RepositorioAlugados{
	private Aluguel[] aluguel;
	private int indice;
	
	public RepositorioAlugadosArray(int tamanho) {
		aluguel = new Aluguel[tamanho];
		indice = 0;
	}
	
	public void alugar(Aluguel aluguel) {
		this.aluguel[indice] = aluguel;
		indice = indice + 1;
	}
	
	public void remover(Carros carro) throws CNAException{
		int i = this.getIndiceCarro(carro);
		if (i == this.indice) {
			throw new CNAException();
		}else {
			this.indice = this.indice - 1;
			this.aluguel[i] = this.aluguel[this.indice];
			this.aluguel[this.indice] = null;
		}
	}

	public boolean procurarCarro(Carros carro) {
		int i = this.getIndiceCarro(carro);
		if (i == this.indice) {
			return false;
		}else {
			return true;
		}
	}
	public boolean procurarCliente(Cliente cliente) {
		int i = this.getIndiceCliente(cliente);
		if (i == this.indice) {
			return false;
		}else {
			return true;
		}
	}

	public int analisarDiasCarro(Carros carro) throws CNAException{
		int i = this.getIndiceCarro(carro);
		if (i == this.indice) {
			throw new CNAException();
		}else {
			return this.aluguel[i].getDias();
		}
		
	}
	private int getIndiceCarro(Carros carro) {
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < this.indice)) {
			if (carro == aluguel[i].getCarros()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	private int getIndiceCliente(Cliente cliente) {
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < this.indice)) {
			if (cliente == aluguel[i].getCliente()) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

}
