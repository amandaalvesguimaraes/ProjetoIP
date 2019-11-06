package projetoip;

public class RepositorioCarrosArray {
	private Carros[] carros;
	private int indice;
	public void cadastrar(Carros carro) throws CCException {
		// eu acho que aqui é pra receber os parametros e usar o método set na classe carros.
		// tipo carros[indice].setModelo(modelo);
		// pra chegar aqui, ele precisa da classe cadastro.
		// MUDAR OS PARAMETROS AÍ E NA CLASSE REPOSITORIOCONTAS;
		boolean achou = false;
		if (indice == 0) {
			carros[indice] = carro;
			indice = indice + 1;
		} else {
			for (int i = 0; i < indice && !achou; i++) {
				if (carros[i].getPlaca().equals(carro.getPlaca())) {
					achou = true;
				}
			}
		}
		if (achou) {
			throw new CCException();
		} else {
			carros[indice] = carro;
			indice = indice + 1;
		}
		// ver se já está cadastrado. colocar um for aí.
	}
	public Carros procurar(String p) throws PNEException {
		boolean achou = false;
		Carros c = null; //variável que vai receber o objeto carro que estamos procurando.
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i].getPlaca().equals(p)) {
				c = carros[i];
				achou = true;
			}
		}
		if (!achou) {
			throw new PNEException();
		}
		return c;
	
	}
	public void remover(String p) throws PNEException {
		boolean achou = false;
		achou = existePlaca(p);
		if (!achou) {
			throw new PNEException();
		} else {
			carros[getIndice(p)] = null;
		}
	}
	
	public void atualizar(Carros carro, String p) throws PNEException, CCException {
		// ao atualizar, ele vai ter que reinserir todas as informações como se estivesse fazendo um novo cadastro.
		// vamos ter que receber um outro parametro para o carro "antigo" que queremos modificar. esse parametro será a placa ANTIGA.
		// pode procurar a placa antiga do carro.
		// poderia até não solicitar tudo ao usuario, ou seja, solicitar o que ele deseja alterar. o que ele não desejar alterar, mandaremos como parametro. 
		remover(p);
		cadastrar(carro);
		
	}
	
	public boolean existePlaca(String p) {
		for (int i = 0; i < indice; i++) {
			if (carros[i].getPlaca().equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existeModelo(String m) {
		for (int i = 0; i < indice; i++) {
			if (carros[i].getModelo().equals(m)) {
				return true;
			}
		}
		return false;
	}
	
	public int getIndice(String p) throws PNEException {
		// esse método vai retornar o índice no array de um carro.
		//** AQUI PRECISA TER UM CASO DE ERRO SE NÃO ACHARMOS UM ÍNDICE PARA A PLACA **//
		int ind = 0; //corrigir essa "gambiarra"
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i].getPlaca().equals(p)) {
				ind = i;
				achou = true;
			}
		}
		if (!achou) {
			 throw new PNEException();
		} else {
			return ind;
		}
	}
}
