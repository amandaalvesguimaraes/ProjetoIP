package Clientes;

public class RepositorioClienteLista implements RepositorioCliente {
    private Cliente cliente;
    private RepositorioClienteLista proximo;
    public RepositorioClienteLista(){
        this.cliente = null;
        this.proximo = null;
    }

    public void cadastrar(Cliente cliente) throws CPFexception {
        if(cliente.getCpf().length()> 11 | cliente.getCnh().length()>11){
            throw new CPFexception();
        }else if(this.proximo == null){
            this.cliente = cliente;
            this.proximo = new RepositorioClienteLista();
        }else {
            this.proximo.cadastrar(cliente);
        }
    }

    public void remover(String cpf) {
        if(this.proximo !=null){
            if(this.cliente.getCpf() == cpf){
                this.cliente = this.proximo.cliente;
                this.proximo = this.proximo.proximo;
            }else{
                this.proximo.remover(cpf);
            }
        }
    }

    public Cliente procurar(String cpf) throws CNexception {
        Cliente resposta = null;
        if(this.proximo!=null){
            if(this.cliente.getCpf()==cpf){
                resposta = this.cliente;
            }else{
                return this.proximo.procurar(cpf);
            }
        }else{
            throw new CNexception();
        }
        return resposta;
    }

    public String atualizar(Cliente cliente) throws CNexception, CPFexception {
        if(cliente.getCpf().length()> 11 | cliente.getCnh().length()>11){
            throw new CPFexception();
        }else if(this.existe(this.cliente.getCpf())==true){
            this.cliente = cliente;
            return "Clientes Cliente atualizado com sucesso!";
        }else{
            throw new CNexception();
        }
    }

    public boolean existe(String cpf) throws CNexception {
        if(this.cliente.getCpf() == cpf){
            return true;
        }else{
            return false;
        }
    }
}