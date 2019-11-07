package projetoip;

public class RepositorioCarrosLista implements RepositorioCarros{
	private Carros itemcarro; // item carro é o objeto carro.
	private RepositorioCarrosLista proximo;
	
	public RepositorioCarrosLista() {
		this.itemcarro = null;
		this.proximo = null;
	}
	
	public void cadastrar(Carros carro) {
		if (this.itemcarro == null) {
			this.itemcarro = carro;
			this.proximo = new RepositorioCarrosLista();
		} else {
			this.proximo.cadastrar(carro);
		}
		
	}

	public Carros procurar(String p) {
		if (this.itemcarro.getPlaca().equals(p)) {
			return this.itemcarro;
		} else {
			if (this.proximo != null) {
				if (this.proximo.itemcarro != null) {
					return this.proximo.procurar(p);
				}
			}
		}
		return null;
	}

	public void remover(String p) {
		if (this.itemcarro.getPlaca().equals(p)) {
			this.itemcarro = this.proximo.itemcarro;
			this.proximo = this.proximo.proximo;
		} else {
			if (this.proximo != null) {
				if (this.proximo.itemcarro != null) {
					this.proximo.remover(p);
				}
			}
		}
		
	}

	public boolean existePlaca(String p) {
		if (this.itemcarro.getPlaca().equals(p)) {
			return true;
		} else {
			if (this.proximo != null) {
				if (this.proximo.itemcarro != null) {
					return this.proximo.existePlaca(p);
				}
			}
		}
		return false;
	}

	public boolean existeModelo(String m) { // m é o modelo informado pelo cliente.
		if (this.itemcarro.getModelo().equals(m)) {
			return true;
		} else {
			if (this.proximo != null) {
				if (this.proximo.itemcarro != null) {
					return this.proximo.existePlaca(m);
				}
			}
		}
		return false;
	}
	// criar outra aqui pra retornar o carro modelo.

	@Override
	public void atualizar(Carros carro, String p) throws PNEException, CCException {
		// TODO Auto-generated method stub
		
	}
}
