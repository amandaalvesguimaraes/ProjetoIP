package vendedores;
import abstrata.*;

public class Vendedor extends Pessoa {
	private int matricula;
    
    public Vendedor(String nome, String cpf, String telefone, int matricula) {
    	super(nome, cpf, telefone);
        this.matricula=matricula;
    }
    
    public int getMatricula() {
        return matricula;
    }
    
    public void setMatricula(int matricula) {
        this.matricula=matricula;
    }
    
        @Override
    public String getNome() {
    	return "VENDEDOR: "+this.nome;
    }

}
