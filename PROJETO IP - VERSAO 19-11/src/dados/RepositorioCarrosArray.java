package dados;
import carros.*;

public class RepositorioCarrosArray implements RepositorioCarros {
	private int indice;
	private Carros[] carros = new Carros[indice];
	
	
	public RepositorioCarrosArray(int tamanho) {
		carros = new Carros[tamanho];
		indice = 0;
	}
	
	
        @Override
	public void inserir(Carros carro) {
		carros[indice] = carro;
		indice ++;
	}
	
        @Override
	public Carros procurar(String p) {
		boolean achou = false;
		Carros c = null; //variavel que vai receber o objeto carro que estamos procurando.
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					c = carros[i];
					achou = true;
				}
			}
		}
		return c;
	}
	
	
        @Override
	public void remover(String p) {
		carros[getIndice(p)] = null;
	}

	
        @Override
	public void atualizar(Carros carro, String p) {
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					carros[i] = carro;
					achou = true;
				}
			}
		}
	}

	
        @Override
	public boolean existePlaca(String p) {
		for (int i = 0; i < indice; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					return true;
				}
			}
		}
		return false;
	}


	public int getIndice(String p) {
		// esse metodo vai retornar o indice no array de um carro.
		int ind = 0;
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					ind = i;
					achou = true;
				}
			}
		}
		return ind;
	}
	

        @Override
	public boolean isAlugado(String p) {
		boolean achou = false;
		for (int i = 0; i < indice && !achou; i++) {
			if (carros[i] != null) {
				if (carros[i].getPlaca().equals(p)) {
					achou = true;
				}
			}
		}
		return achou;
	}
	
	
}
