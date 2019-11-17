package Clientes;

public class RepositorioClienteLista implements RepositorioCliente {

    private Cliente cliente;
    private RepositorioClienteLista proximo;

    public RepositorioClienteLista() {
        this.cliente = null;
        this.proximo = null;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if (this.proximo == null) {
            this.cliente = cliente;
            this.proximo = new RepositorioClienteLista();
        } else {
            this.proximo.cadastrar(cliente);
        }
    }

    @Override
    public void remover(String cpf) {
        if (this.proximo != null) {
            if (this.cliente.getCpf().equals(cpf)) {
                this.cliente = this.proximo.cliente;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(cpf);
            }
        }
    }

    @Override
    public Clientes procurar(String cpf) {
        Clientes resposta = null;
        if (this.proximo != null) {
            if (this.cliente.getCpf().equals(cpf)) {
                resposta = this.cliente;
            } else {
                resposta = this.proximo.procurar(cpf);
            }
        }
        return resposta;
    }

    @Override
    public String atualizar(Cliente cliente) {
        this.cliente = cliente;
        return "Clientes Cliente atualizado com sucesso!";

    }

    @Override
    public boolean existe(String cpf) {
        boolean exist = false;
        if (this.proximo != null) {
            if (this.cliente.getCpf().equals(cpf)) {
                exist = true;
            } else {
                this.proximo.existe(cpf);
            }
        } else {
            exist = false;
        }
        return exist;
    }
}

