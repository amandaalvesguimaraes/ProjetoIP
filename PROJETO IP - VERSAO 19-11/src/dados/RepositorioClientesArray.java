package dados;
import clientes.*;

public class RepositorioClientesArray implements RepositorioCliente {

    private Cliente[] clientes;
    private int indice;

    public RepositorioClientesArray(int tamanho) {
        clientes = new Cliente[tamanho];
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
    public void cadastrar(Cliente cliente) {
        if (clientes.length == indice) {
            Cliente[] aux = new Cliente[clientes.length * 2];
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
    public Cliente procurar(String cpf) {
        int i = this.getIndice(cpf);
        return this.clientes[i];
    }

    @Override
    public String atualizar(Cliente cliente, String cpfantigo) {
        int i = this.getIndice(cpfantigo);
        this.clientes[i] = cliente;
        return "Cliente atualizado com sucesso!";
    }

    @Override
    public boolean existeCPF(String cpf) {
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
    
    @Override
    public boolean existeCNH(String cnh) {
        boolean exist = false;
        int i = 0;
        while (i < this.indice && !exist) {
            if (this.clientes[i].getCnh().equals(cnh)) {
                exist = true;
            } else {
                i++;
            }
        }
        return exist;
    } 
   
}