package dados;
import clientes.*;

public interface RepositorioCliente {
    void cadastrar(Cliente cliente);
    void remover(String cpf);
    Cliente procurar(String cpf);
    String atualizar(Cliente cliente, String cpfantigo) ;
    boolean existeCPF(String cpf);
    boolean existeCNH(String cnh);
}
