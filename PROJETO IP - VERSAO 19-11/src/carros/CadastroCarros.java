package carros;

import dados.*;
import exceptions.*;
import fachada.*;
import vendedores.*;

public class CadastroCarros {

    private RepositorioCarros carros;

    public CadastroCarros(RepositorioCarros r) {
        carros = r;
    }

    public void cadastrar(Carros carro) throws CCException, QPIException, PDIException, ANException {
        if (!carros.existePlaca(carro.getPlaca())) {
            if (carro.getQuantidadePortas() <= 0) {
                throw new QPIException();
            } else {
                if (carro.getPrecoDiaria() <= 0) {
                    throw new PDIException();
                } else {
                    if (carro.getAno() <= 0) {
                        throw new ANException();
                    } else {
                        carros.inserir(carro);
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
            return carros.procurar(p);
        } else {
            throw new PNEException();
        }
    }

    public void atualizar(Carros carro, String pa) throws PEException, CCException, PNEException, QPIException, PDIException, ANException, NPAException { //p � a nova placa e pa � a placa antiga
    	if (carros.existePlaca(pa)) {
			if (!carro.getPlaca().equals(pa)) {
				if (carros.existePlaca(carro.getPlaca())) {
					throw new PEException();
				} else {
					if (carros.isAlugado(pa)) {
						throw new NPAException();
					} else {
						if (carro.getQuantidadePortas() <= 0) {
							throw new QPIException();
						} else {
							if (carro.getPrecoDiaria() <= 0) {
								throw new PDIException();
							} else {
								if (carro.getAno() <= 0) {
									throw new ANException();
								} else {
									carros.atualizar(carro, pa);
								}
							}
						}
					}
				}
			} else {
				if (carro.getQuantidadePortas() <= 0) {
					throw new QPIException();
				} else {
					if (carro.getPrecoDiaria() <= 0) {
						throw new PDIException();
					} else {
						if (carro.getAno() <= 0) {
							throw new ANException();
						} else {
							carros.atualizar(carro, pa);
						}
					}
				}
			}
		} else {
			throw new PNEException();	
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
