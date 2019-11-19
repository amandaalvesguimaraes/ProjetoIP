package carros;

public class Carros {
	private String modelo;
	private String cor;
	private int ano;
	private String placa;
	private int quantidadeportas;
	private boolean alugado;
	private double precodiaria;
	public Carros(String m, String c, String p, int a, int qp, double pd) {
		this.modelo = m;
		this.cor = c;
		this.placa = p;
		this.ano = a;
		this.alugado = false;
		this.quantidadeportas = qp;
		this.precodiaria = pd;
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
	public void setAlugar() {
		this.alugado = true;
	}
	public void setDevolver() {
		this.alugado = false;
	}
}
