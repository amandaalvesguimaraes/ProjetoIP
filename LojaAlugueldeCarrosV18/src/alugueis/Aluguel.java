package alugueis;
import clientes.*;
import vendedores.*;
import carros.*;

public class Aluguel {
	private Cliente cliente;
	private final double valorFixo = 20;
	private double valorTotal;
	private int dias;
	private Vendedor vendedor;
	private Carros carro;
	
	public Aluguel(Vendedor v, Cliente cl, Carros car, int d) {
		this.vendedor = v;
		this.cliente = cl;
		this.carro = car;
		this.dias = d;
		this.valorTotal = (this.carro.getPrecoDiaria()*d)+(this.valorFixo*d);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getValorFixo() {
		return valorFixo;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Carros getCarros() {
		return carro;
	}
	public void setCarros(Carros carro) {
		this.carro = carro;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
}

