package dados;
import alugueis.*;
import exceptions.*;

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

	public void remover(Aluguel aluguel) throws CNAException{
		int i = this.getIndice(aluguel);
		if (i == this.indice) {
			throw new CNAException();
		}else {
			this.indice = this.indice - 1;
			this.aluguel[i] = this.aluguel[this.indice];
			this.aluguel[this.indice] = null;
		}
	}

	public void atualizar(Aluguel aluguel) throws ANException{
		boolean achou = existeClienteAlugando(aluguel.getCliente().getCpf());
		if (achou == false) {
			throw new ANException();
		} else {
			int i = getIndice(aluguel);
			this.aluguel[i] = aluguel;
		}
	}

	private int getIndice(Aluguel aluguelp) {
		boolean achou = false;
		int ind = 0;
		for (int i = 0; i < this.indice && !achou; i++) {
			if (aluguel[i] != null) {
				if (this.aluguel[i].getCarros().getPlaca().equals(aluguelp.getCarros().getPlaca())) {
					achou = true;
					ind = i;
				}
			}
		}
		return ind;
	}



	public boolean existeClienteAlugando(String cpf) {
		// se existe o cliente está alugando algum carro
		boolean achou = false;
		for (int i = 0; i < this.indice && !achou; i++) {
			if (aluguel[i] != null) {
				if (this.aluguel[i].getCliente().getCpf().equals(cpf)) {
					achou = true;
				}
			}
		}
		return achou;
	}

	public boolean existeCarroAlugado(String placa) {
		boolean achou = false;
		for (int i = 0; i < this.indice && !achou; i++) {
			if (aluguel[i] != null) {
				if (this.aluguel[i].getCarros().getPlaca().equals(placa)) {
					achou = true;
				}
			}
		}
		return achou;
	}

	public Aluguel procurarAluguelCarro(String placa) throws CNAException{
		boolean achou = false;
		Aluguel a = null;
		for (int i = 0; i < this.indice && !achou; i++) {
			if (aluguel[i] != null) {
				if (this.aluguel[i].getCarros().getPlaca().equals(placa)) {
					achou = true;
					a = this.aluguel[i];
				}
			}
		}
		if (a != null) {
			return a;
		}else {
			throw new CNAException();
		}
	}

	public Aluguel procurarAluguelCliente(String cpf) throws ANException{
		boolean achou = false;
		Aluguel a = null;
		for (int i = 0; i < this.indice && !achou; i++) {
			if (aluguel[i] != null) {
				if (this.aluguel[i].getCliente().getCpf().equals(cpf)) {
					achou = true;
					a = this.aluguel[i];
				}
			}
		}
		if (a != null) {
			return a;
		}else {
			throw new ANException();
		}
	}
}