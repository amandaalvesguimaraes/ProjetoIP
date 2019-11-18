package clientes;
import dados.*;
import exceptions.*;

public class CadastroClientes {

    private RepositorioCliente clientes;

    public CadastroClientes(RepositorioCliente cliente) {
        clientes = cliente;
    }

    public void cadastrar(Cliente cliente) throws CJCexception, IDexception {
        if (cliente.getCpf().length() != 11 || cliente.getCnh().length() != 11) {
            throw new IDexception();
        } else if (clientes.existeCPF(cliente.getCpf())) {
            throw new CJCexception(cliente.getNome());
        } else if (clientes.existeCNH(cliente.getCnh())) {
        	throw new IDexception();
        } else {
            clientes.cadastrar(cliente);
        }
    }

    public void remover(String cpf) throws CNexception {
        if (clientes.existeCPF(cpf) == false) {
            throw new CNexception();
        } else {
            clientes.remover(cpf);
        }
    }

    public Cliente procurar(String cpf) throws CNexception {
        if (clientes.existeCPF(cpf) == false) {
            throw new CNexception();
        } else {
            return clientes.procurar(cpf);
        }
    }

    public void atualizar(Cliente cliente, String cpfantigo, String cnhantigo) throws CNexception, IDexception, CPFException {
        if (cliente.getCpf().length() != 11 | cliente.getCnh().length() != 11) {
            throw new CPFException();
        } else if (clientes.existeCPF(cliente.getCpf())) {
            throw new CNexception();
        } else if (!clientes.existeCPF(cpfantigo)) {
        	throw new CNexception();
        } else if (!clientes.existeCNH(cnhantigo)) {
        	throw new CNexception();
        } else if (clientes.existeCNH(cliente.getCnh())) {
        	throw new IDexception();
        } else {
            clientes.atualizar(cliente, cpfantigo);
        }
    }
    
    public boolean existeCPF(String cpf) {
    	return clientes.existeCPF(cpf);
    }

}
