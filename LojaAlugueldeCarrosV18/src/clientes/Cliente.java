package clientes;
import abstrata.*;

public class Cliente extends Pessoa {
    private String cnh;
    private String data;

    public Cliente(String nome, String cpf, String telefone, String cnh,  String data){
    	super(nome, cpf, telefone);
        this.cnh = cnh;
        this.data = data;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

	public String getNome() {
		return "CLIENTE: "+ this.nome;
	}
}
