package dados;
import alugueis.*;
import exceptions.*;

public class RepositorioAlugadosLista implements RepositorioAlugados {
	private RepositorioAlugadosLista proximo;
	private Aluguel aluguel;

	public RepositorioAlugadosLista() {
		this.aluguel = null;
		this.proximo = null;
	}

        @Override
	public void alugar(Aluguel aluguel) {
		if (aluguel == null) {
			this.aluguel = aluguel;
			this.proximo = new RepositorioAlugadosLista();
		} else {
			this.proximo.alugar(aluguel);
		}
	}
        @Override
	public void remover(Aluguel aluguel) throws CNAException{
		if (existeCarroAlugado(aluguel.getCarros().getPlaca()) == true ) {
			if (this.aluguel == aluguel) {
				this.aluguel = this.proximo.aluguel;
				this.proximo = this.proximo.proximo;
			} else {
				this.proximo.remover(aluguel);
			}
		}else {
			throw new CNAException();
		}
	}

        @Override
	public void atualizar(Aluguel aluguel) throws ANEException {
		if (existeClienteAlugando(aluguel.getCliente().getCpf()) == true) {
			if (this.aluguel.getCliente() == aluguel.getCliente()) {
				this.aluguel = aluguel;
			}else {
				proximo.atualizar(aluguel);
			}
		}else {
			throw new ANEException();
		}
	}


@Override
public boolean existeClienteAlugando(String cpf) {
	boolean achou = false;
	if (this.aluguel != null) {
		if (aluguel.getCliente().getCpf().equals(cpf)) {
			achou = true;
		}else {
			proximo.existeClienteAlugando(cpf);
		}
	}
	return achou;
}

@Override
public boolean existeCarroAlugado(String placa) {
	boolean achou = false;
	if (this.aluguel != null) {
		if (aluguel.getCarros().getPlaca().equals(placa)) {
			achou = true;
		}else {
			proximo.existeCarroAlugado(placa);
		}
	}
	return achou;
}

@Override
public Aluguel procurarAluguelCarro(String placa) throws CNAException{
	boolean achou = existeCarroAlugado(placa);
	if (achou == true) {
		if (this.aluguel.getCarros().getPlaca().equals(placa)) {
			return this.aluguel;
		}else {
			return proximo.procurarAluguelCarro(placa);
		}
	}else {
		throw new CNAException();
	}
}

@Override
public Aluguel procurarAluguelCliente(String cpf) throws ANEException {
	boolean achou = existeClienteAlugando(cpf);
	if (achou == true) {
		if (this.aluguel.getCliente().getCpf().equals(cpf)) {
			return this.aluguel;
		}else {
			return proximo.procurarAluguelCliente(cpf);
		}
	}else {
		throw new ANEException();
	}
}



}
