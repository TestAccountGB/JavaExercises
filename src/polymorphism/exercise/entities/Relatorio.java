package polymorphism.exercise.entities;

public class Relatorio {
	
	public void gerarRelatorioGenerico(Funcionario funcionario) {
		funcionario.calcularSalario();
		System.out.println("Nome: " + funcionario.getNome());
		System.out.println("Idade: " + funcionario.getIdade());
		System.out.println("Salario: " + funcionario.getSalario());
		if(funcionario instanceof Gerente) {//Mas mesmo fazendo um Upcast o java percebe que aquela varivel aponta
			//Pra um outro tipo de classe
			Gerente g = (Gerente) funcionario;
			System.out.println("PNL: " + g.getPnl());
		}
		else if(funcionario instanceof Vendedor) {
			//Cast entre classes...
			Vendedor v = (Vendedor) funcionario;
			//O java so aceita se o Vendedor for filho de funcionario.
			System.out.println("Vendas: " + v.getVendas());
		}
	}
}