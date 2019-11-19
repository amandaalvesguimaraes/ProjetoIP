package clientes;
import dados.*;
import exceptions.*;

public class CadastroClientes {

    private RepositorioCliente clientes;

    public CadastroClientes(RepositorioCliente cliente) {
        clientes = cliente;
    }

    public void cadastrar(Cliente cliente) throws CJCexception, CNHexception {
        if (cliente.getCpf().length() != 11 || cliente.getCnh().length() != 11) {
            throw new CNHexception();
        } else if (clientes.existeCPF(cliente.getCpf())) {
            throw new CJCexception(cliente.getNome());
        } else if (clientes.existeCNH(cliente.getCnh())) {
        	throw new CNHexception();
        } else {
            clientes.cadastrar(cliente);
        }
    }

    public void remover(String cpf) throws CNCException {
        if (clientes.existeCPF(cpf) == false) {
            throw new CNCException();
        } else {
            clientes.remover(cpf);
        }
    }

    public Cliente procurar(String cpf) throws CNCException {
        if (clientes.existeCPF(cpf) == false) {
            throw new CNCException();
        } else {
            return clientes.procurar(cpf);
        }
    }

    public void atualizar(Cliente cliente, String cpfantigo, String cnhantigo) throws CNCException, CNHexception, CPFException {
        if (cliente.getCpf().length() != 11 | cliente.getCnh().length() != 11) {
            throw new CPFException();
        } else if (clientes.existeCPF(cliente.getCpf())) {
            throw new CNCException();
        } else if (!clientes.existeCPF(cpfantigo)) {
        	throw new CNCException();
        } else if (!clientes.existeCNH(cnhantigo)) {
        	throw new CNCException();
        } else if (clientes.existeCNH(cliente.getCnh())) {
        	throw new CNHexception();
        } else {
            clientes.atualizar(cliente, cpfantigo);
        }
    }
    
    public boolean existeCPF(String cpf) {
    	return clientes.existeCPF(cpf);
    }
    
    public boolean existeCNH(String cnh) {
    	return clientes.existeCNH(cnh);
    }

}
