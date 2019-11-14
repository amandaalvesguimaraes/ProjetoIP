package Clientes;

public class RepositorioClientesArray implements RepositorioCliente {
    private Cliente[] clientes;
    private int indice;

    public RepositorioClientesArray(int tamanho) {
        clientes = new Cliente[tamanho];
        indice = 0;
    }

    public int getIndice(String cpf) throws CNexception {
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


public void cadastrar(Cliente cliente) throws CPFexception {
    if(cliente.getCpf().length() != 11 | cliente.getCnh().length() != 11){
        throw new CPFexception();
    }else if (clientes.length() == indice) {
            Cliente[] aux = new Cliente[clientes.length * 2];
            for (int i = 0; i < indice; i++) {
                aux[i] = clientes[i];
            }
            this.clientes = aux;
        }
        clientes[indice] = cliente;
        indice = indice + 1;
    }

    public void remover(String cpf) throws CNexception {
        int i = this.getIndice(cpf);
        if (i == this.indice) {
            throw new CNexception();
        } else {
            this.indice = this.indice - 1;
            this.clientes[i] = this.clientes[this.indice];
            this.clientes[this.indice] = null;
        }

    }

    public Cliente procurar(String cpf) throws CNexception {
        Cliente resposta = null;
        int i = this.getIndice(cpf);
        if (i == this.indice) {
            throw new CNexception();
        } else {
            resposta = this.clientes[i];
        }
        return  resposta;
    }

    public String atualizar(Cliente cliente) throws CNexception,CPFexception  {
        if(cliente.getCpf().length()> 11 | cliente.getCnh().length()>11){
            throw new CPFexception();
        }
        int i = this.getIndice(cliente.getCpf());
        if (i == this.indice) {
            throw new CNexception();
        } else {
            this.clientes[i] = cliente;
            return "Clientes.Cliente atualizado com sucesso!";
        }
    }

    public boolean existe(String cpf) throws CNexception {
        int i = this.getIndice(cpf);
        return (i != this.indice);
    }
}
