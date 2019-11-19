package dados;
import carros.*;


public class RepositorioCarrosLista implements RepositorioCarros {
	private Carros itemcarro;
	private RepositorioCarrosLista proximo;
	
	public RepositorioCarrosLista() {
		this.itemcarro = null;
		this.proximo = null;
	}
		
        @Override
	public void inserir(Carros carro) {
		if (this.itemcarro == null) {
			this.itemcarro = carro;
			this.proximo = new RepositorioCarrosLista();
		} else {
			this.proximo.inserir(carro);
		}
	}
		
        @Override
	public Carros procurar(String p) {
		if (this.itemcarro.getPlaca().equals(p)) {
			return this.itemcarro;
		} else {
			if (this.proximo != null) {
				if (this.proximo.itemcarro != null) {
					return this.proximo.procurar(p);
				} else {
					return null;
				}
			} else {
				return null;
			}
		}
	}

        @Override
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

        @Override
	public boolean existePlaca(String p) {
		if (this.itemcarro == null) {
			return false;
		} else {
			if (this.itemcarro.getPlaca().equals(p)) {
				return true;
			} else {
				if (this.proximo != null) {
					if (this.proximo.itemcarro != null) {
						return this.proximo.existePlaca(p);
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
	}


        @Override
	public void atualizar(Carros carro, String p) {
		if (this.itemcarro.getPlaca().equals(p)) {
			this.itemcarro = carro;
		} else {
			if (this.proximo != null) {
				if (this.proximo.itemcarro != null) {
					this.proximo.atualizar(carro, p);
				}
			}
		}
	}

        @Override
	public boolean isAlugado(String p) {
		if (this.itemcarro.getPlaca().equals(p)) {
			return this.itemcarro.isAlugado();
		} else {
			if (this.proximo != null) {
				if (this.proximo.itemcarro != null) {
					return this.proximo.isAlugado(p);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
	}


}
