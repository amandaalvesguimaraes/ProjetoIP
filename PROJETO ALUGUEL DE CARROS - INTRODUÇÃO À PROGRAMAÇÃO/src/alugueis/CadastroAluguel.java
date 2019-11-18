package alugueis;
import dados.*;
import clientes.*;
import exceptions.*;
import carros.*;
import vendedores.*;

public class CadastroAluguel {
	private RepositorioAlugados alugueis;
	private RepositorioCliente clientes;
	
	public CadastroAluguel(RepositorioAlugados rep1, RepositorioCliente rep2) {
		alugueis = rep1;
		clientes = rep2;
	}
	
	public void cadastrar(Aluguel aluguel) throws CJAException, DiaIException, CNexception{
		if (aluguel.getCarros().isAlugado() == false) {
			if  (aluguel.getDias() > 0) {
				clientes.procurar(aluguel.getCliente().getCpf());
				alugueis.alugar(aluguel);
				aluguel.getCarros().setAlugar();
			}else {
				throw new DiaIException();
			}
		}else {
			throw new CJAException();
		}
		
	}
	
	public void remover(Aluguel aluguel) throws CNAException {
		if (alugueis.existeCarroAlugado(aluguel.getCarros().getPlaca()) == true) {
			alugueis.remover(aluguel);
			aluguel.getCarros().setDevolver();
		}else {
			throw new CNAException(	);
		}
	}
	public void atualizar(Aluguel aluguel) throws ANException {
		if (alugueis.existeClienteAlugando(aluguel.getCliente().getCpf())) {
			alugueis.atualizar(aluguel);
		}else {
			throw new ANException();
		}
	}
	
	public boolean existeClienteAlugando(String cpf) {
		return alugueis.existeClienteAlugando(cpf);
	}
	
	public boolean existeCarroAlugado(String placa) {
		return alugueis.existeCarroAlugado(placa);
	}
	
	public Aluguel procurarAluguelCarro(String placa) throws CNAException{
		if (existeCarroAlugado(placa)) {
			return alugueis.procurarAluguelCarro(placa);
		} else {
			throw new CNAException();
		}
	}
	
	public Aluguel procurarAluguelCliente(String cpf) throws ANException {
		if (existeClienteAlugando(cpf)) {
			return alugueis.procurarAluguelCliente(cpf);
		} else {
			throw new ANException();
		}
	}
}