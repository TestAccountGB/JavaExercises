package polymorphism.exercise.entities;

public class Vendedor extends Funcionario {
	
	private double vendas;
	
	public Vendedor(String nome, int idade, double salario, double vendas) {
		super(nome, idade, salario);
		this.vendas = vendas;
	}
	
	@Override
	public String toString() {
		return "Vedendor [vendas: " + vendas + "]";
	}

	public double getVendas() {
		return vendas;
	}

	public void setVendas(double vendas) {
		this.vendas = vendas;
	}

	@Override
	public void calcularSalario() {
		this.salario = this.salario + (this.vendas * 0.10);
	}
	
	@Override
	public void test() {
		System.out.println("Vendedor");
	}
}