package polymorphism.exercise.entities;

public abstract class Funcionario {
	
	protected String nome;
	protected int idade;
	protected double salario;
	
	public Funcionario(String nome, int idade, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [nome: " + nome + ", idade: " + idade + ", salario: " + salario + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public abstract void calcularSalario();
	
	public void test() {
		System.out.println("Funcionario");
	}
	
}