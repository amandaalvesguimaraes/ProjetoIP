package Clientes;

import dados.*;
import.exceptions.*;

public class CadastroClientes {

    private RepositorioCliente clientes;

    public CadastroClientes(RepositorioCliente cliente) {
        clientes = cliente;
    }

    public void cadastrar(Clientes cliente) throws CJCexception, IDexception {
        if (cliente.getCpf().length() != 11 | cliente.getCnh().length() != 11) {
            throw new Clientes.IDexception();
        } else if (clientes.existe(cliente.getCpf()) == false) {
            throw new CJCexception(cliente.getNome());
        } else {
            cliente.cadastrar(cliente);
        }
    }

    public void remover(String cpf) throws CNexception {
        if (clientes.existe(cpf) == false) {
            throw new CNexception();
        } else {
            clientes.remover(cpf);
        }
    }

    public Clientes procurar(String cpf) throws CNexception {
        if (clientes.existe(cpf) == false) {
            throw new CNexception();
        } else {
            return clientes.procurar(cpf);
        }
    }

    public void atualizar(Clientes cliente) throws CNexception, IDexception {
        if (cliente.getCpf().length() != 11 | cliente.getCnh().length() != 11) {
            throw new Clientes.CPFexception();
        } else if (clientes.existe(cliente.getCpf() == false)) {
            throw new CNexception();
        } else {
            clientes.atualizar(cliente);
        }
    }

}
