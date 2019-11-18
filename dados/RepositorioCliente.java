package Clientes;

public interface RepositorioCliente {
        void cadastrar(Cliente cliente);
        void remover(String cpf);
        Clientes procurar(String cpf);
        String atualizar(Cliente cliente) ;
        boolean existe(String cpf);
}

