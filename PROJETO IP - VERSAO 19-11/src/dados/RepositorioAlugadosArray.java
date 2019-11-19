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

        @Override
	public void alugar(Aluguel aluguel) {
		this.aluguel[indice] = aluguel;
		indice = indice + 1;
	}

        @Override
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

        @Override
	public void atualizar(Aluguel aluguel) throws ANEException{
		boolean achou = existeClienteAlugando(aluguel.getCliente().getCpf());
		if (achou == false) {
			throw new ANEException();
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



        @Override
	public boolean existeClienteAlugando(String cpf) {
		// se existe o cliente esta alugando algum carro
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

        @Override
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

        @Override
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

        @Override
	public Aluguel procurarAluguelCliente(String cpf) throws ANEException {
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
		} else {
			throw new ANEException();
		}
	}
}