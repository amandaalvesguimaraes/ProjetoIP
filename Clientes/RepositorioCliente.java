package Clientes;

public interface RepositorioCliente {
        void cadastrar(Clientes cliente);
        void remover(String cpf);
        Clientes procurar(String cpf);
        String atualizar(Clientes cliente) ;
        boolean existe(String cpf);
}

