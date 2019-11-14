package sistemaaluguel;

public class Carros {
	private String modelo;
	private String cor;
	private int ano;
	private String placa;
	private int quantidadeportas;
	private boolean alugado;
	private double precodiaria;
	public Carros() {
		this.modelo = null;
		this.cor = null;
		this.ano = 0;
		this.placa = null;
		this.alugado = false;
		this.quantidadeportas = 0;
		this.precodiaria = 0;
	}
	public String getModelo() {
		return this.modelo;
	}
	public String getCor() {
		return this.cor;
	}
	public int getAno() {
		return this.ano;
	}
	public boolean isAlugado() {
		return this.alugado;
	}
	public int getQuantidadePortas() {
		return this.quantidadeportas;
	}
	public double getPrecoDiaria() {
		return this.precodiaria;
	}
	public String getPlaca() {
		return this.placa;
	}
	public void setPrecoDiaria(double a) {
		this.precodiaria = a;
	}
	public void setPlaca(String a) {
		this.placa = a;
	}
	public void setQuantidadePortas(int a) {
		this.quantidadeportas = a;
	}
	public void setAno(int a) {
		this.ano = a;
	}
	public void setCor(String a) {
		this.cor = a;
	}
	public void setModelo(String a) {
		this.modelo = a;
	}
}
// PROCEDIMENTO PARA CADASTRAR UM CARRO:
// primeiro, 'declarar' a variável pra ser o objeto carro.
// receber os atributos. no código, aplicar essas strings a cada atributo. tipo c.setAno(6564648)
// depois, pega esse variável e chama o método cadastrar em repositoriocontasarray e repositoriocontaslista. no caso da lista, já no início do main, é pra declará-la.
// pq só vai ser uma lista.
