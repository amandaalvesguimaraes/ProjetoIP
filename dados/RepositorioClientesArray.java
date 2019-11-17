package Clientes;

public class RepositorioClientesArray implements RepositorioCliente {

    private Clientes[] clientes;
    private int indice;

    public RepositorioClientesArray() {
        clientes = new Clientes[10];
        indice = 0;
    }

    public int getIndice(String cpf) {
        String n;
        boolean achou = false;
        int i = 0;
        while ((!achou) && (i < this.indice)) {
            n = clientes[i].getCpf();
            if (n.equals(cpf)) {
                achou = true;
            } else {
                i++;
            }
        }
        return i;
    }

    @Override
    public void cadastrar(Clientes cliente) {
        if (clientes.length == indice) {
            Clientes[] aux = new Clientes[clientes.length * 2];
            for (int i = 0; i < indice; i++) {
                aux[i] = clientes[i];
            }
            this.clientes = aux;
        }
        clientes[indice] = cliente;
        indice++;
    }

    @Override
    public void remover(String cpf) {
        int i = this.getIndice(cpf);
        this.indice = this.indice - 1;
        this.clientes[i] = this.clientes[this.indice];
        this.clientes[this.indice] = null;
    }

    @Override
    public Clientes procurar(String cpf) {
        int i = this.getIndice(cpf);
        return this.clientes[i];
    }

    @Override
    public String atualizar(Clientes cliente) {
        int i = this.getIndice(cliente.getCpf());
        this.clientes[i] = cliente;
        return "Cliente atualizado com sucesso!";
    }

    @Override
    public boolean existe(String cpf) {
        boolean exist = false;
        int i = 0;
        while (i < this.indice && !exist) {
            if (this.clientes[i].getCpf().equals(cpf)) {
                exist = true;
            } else {
                i++;
            }
        }
        return exist;
    } 
   
}


