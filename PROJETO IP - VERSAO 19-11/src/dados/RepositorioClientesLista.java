package dados;
import clientes.*;

public class RepositorioClientesLista implements RepositorioCliente {

    private Cliente cliente;
    private RepositorioClientesLista proximo;

    public RepositorioClientesLista() {
        this.cliente = null;
        this.proximo = null;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if (this.proximo == null) {
            this.cliente = cliente;
            this.proximo = new RepositorioClientesLista();
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
    public Cliente procurar(String cpf) {
        Cliente resposta = null;
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
    public String atualizar(Cliente cliente, String cpfantigo) {
    	if (this.cliente.getCpf().equals(cpfantigo)) {
			this.cliente = cliente;
			return "Cliente atualizado com sucesso!";
		} else {
			return this.proximo.atualizar(cliente, cpfantigo); 
		}

    }

    @Override
    public boolean existeCPF(String cpf) {
        boolean exist = false;
        if (this.proximo != null) {
            if (this.cliente.getCpf().equals(cpf)) {
                exist = true;
            } else {
                this.proximo.existeCPF(cpf);
            }
        } else {
            exist = false;
        }
        return exist;
    }
    
    @Override
    public boolean existeCNH(String cnh) {
    	boolean exist = false;
        if (this.proximo != null) {
            if (this.cliente.getCnh().equals(cnh)) {
                exist = true;
            } else {
                this.proximo.existeCNH(cnh);
            }
        } else {
            exist = false;
        }
        return exist;
    }
    
}
