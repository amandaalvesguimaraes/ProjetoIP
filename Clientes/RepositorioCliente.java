package Clientes;

public interface RepositorioCliente {
        void cadastrar(Cliente cliente) throws CPFexception, CJCexception;
        void remover(String cpf) throws CNexception;
        Cliente procurar(String cpf) throws CNexception;
        String atualizar(Cliente cliente) throws CNexception, CPFexception;
        boolean existe(String cpf) throws CNexception;
}

