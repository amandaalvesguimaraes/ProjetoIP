package sistemaaluguel;

import dados.RepositorioCarros;
import sistemaaluguel.*;

public class CadastroCarros {
private RepositorioCarros carros;
	
	public CadastroCarros(RepositorioCarros r) {
		carros = r;
	}
	
	public void cadastrar(String m, String c, String p, int a, int qp, double pd) throws CCException, QPIException, PDIException, ANException {
		if (!carros.existePlaca(p)) {
			if (qp <= 0) {
				throw new QPIException();
			} else {
				if (pd <= 0) {
					throw new PDIException();
				} else {
					if (a <= 0) {
						throw new ANException();
					} else {
						Carros carroc = new Carros();
						carroc.setModelo(m);
						carroc.setCor(c);
						carroc.setPlaca(p);
						carroc.setAno(a);
						carroc.setPrecoDiaria(pd);
						carroc.setQuantidadePortas(qp);
						carros.inserir(carroc);
					}
				}
			}
		} else {
			throw new CCException();
		}
	}
	
	public void remover(String p) throws PNEException {
		if (!carros.existePlaca(p)) {
			throw new PNEException();
		} else {
			carros.remover(p);
		}
	}
	
	public Carros procurar(String p) throws PNEException {
		if (carros.existePlaca(p)) {
			Carros c = new Carros();
			c = carros.procurar(p);
			return c;
		} else {
			throw new PNEException();
		}
	}
	
	public void atualizar(String m, String c, String p, int a, int qp, double pd, String pa) throws PEException, CCException, PNEException, QPIException, PDIException, ANException { //p é a nova placa e pa é a placa antiga
		if (!p.equals(pa)) {
			if (carros.existePlaca(p)) {
				throw new PEException();
			} else {
				if (qp <= 0) {
					throw new QPIException();
				} else {
					if (pd <= 0) {
						throw new PDIException();
					} else {
						if (a <= 0) {
							throw new ANException();
						} else {
							Carros carroc = procurar(pa);
							carroc.setModelo(m);
							carroc.setCor(c);
							carroc.setPlaca(p);
							carroc.setAno(a);
							carroc.setPrecoDiaria(pd);
							carroc.setQuantidadePortas(qp);
						}
					}
				}
			}
		} else {
			if (qp <= 0) {
				throw new QPIException();
			} else {
				if (pd <= 0) {
					throw new PDIException();
				} else {
					if (a <= 0) {
						throw new ANException();
					} else {
						Carros carroc = procurar(pa);
						carroc.setModelo(m);
						carroc.setCor(c);
						carroc.setPlaca(p);
						carroc.setAno(a);
						carroc.setPrecoDiaria(pd);
						carroc.setQuantidadePortas(qp);
					}
				}
			}
		}
	}
	
	public boolean isAlugado(String p) throws PNEException {
		if (carros.existePlaca(p)) {
			return carros.isAlugado(p);
		} else {
			throw new PNEException();
		}
	}
	
	public boolean existePlaca(String p) {
		return carros.existePlaca(p);
	}
}