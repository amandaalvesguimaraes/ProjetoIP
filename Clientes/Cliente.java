package Clientes;

public class Cliente {
    private String cpf;
    private String nome;
    private String cnh;
    private long tefone;
    private String data;

    public Cliente(String cpf, String nome, String cnh, long telefone, String data){
        this.cpf = cpf;
        this.nome = nome;
        this.cnh = cnh;
        this.tefone = telefone;
        this.data = data;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public long getTefone() {
        return tefone;
    }

    public void setTefone(long tefone) {
        this.tefone = tefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



}