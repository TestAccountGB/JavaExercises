package polymorphism.exercise.application;

import polymorphism.exercise.entities.Funcionario;
import polymorphism.exercise.entities.Gerente;
import polymorphism.exercise.entities.Relatorio;
import polymorphism.exercise.entities.Vendedor;

public class Program {
	public static void main(String[] args) {
		
		Relatorio relatorio = new Relatorio();
		Funcionario g = new Gerente("Roberto", 40, 5000, 2000);
		Funcionario v = new Vendedor("Marcos", 30, 2000, 20000);
		//Como o java consegue guardar informacoes que o Funcionario nao tem, Como a PNL? O java nao guarda na variavel
		//Do funcionario, essa variavel so serve apenas pra servir como um apontamento, a variavel Funcionario fica no
		//Stack do java e o objeto Gerente/Vendedor fica no heap, e quando a gente chama a variavel ela aponta pro objeto
		//E usa ele, mas o unico problema, e que a variavel funcionario nao vai conseguir alcancar os atributos que ela nao
		//Tem, como a pnl, mas a gente pode fazer um metodo pra isso que faz um cast nele, ou fazer um cast aqui mesmo
		
		//ge.getPnl();
		g.test();
		//Mas uma coisa interessante e que ele vai atras do metodo da classe instaciada na variavel e nao na classe da
		//Variavel em si, mas claro, ela precisa estar sobrescrita.
		Gerente ge = (Gerente) g;
		//Agora a gente o metodo, mas a informacao ta guardada no heap, guardar esse objeto em uma variavel Funcionario
		//Nao vai fazer a Pnl sumir
		relatorio.gerarRelatorioGenerico(ge);
		System.out.println("================");
		v.test();
		relatorio.gerarRelatorioGenerico(v);
		
		//Podemos enviar no metodo uma variavel Funcionario um uma variavel que seja filha de Funcionario que ele vai
		//Fazer um upcast automatico quando entrar no metodo, ou seja, ele vai transformar o Gerente em Funcionario
		
		//Upcast...
		Funcionario test = (Funcionario) ge;
		
		//Downcast...
		ge = (Gerente) test;
		
		//Considerado um Upcast quando a gente utiliza um cast em uma classe filha pra uma classe mais generica que ela, e
		//O Downcast ao contrario
		
		@SuppressWarnings("unused")
		double Double = 3.0;
		float Float = 3.0f;
		
		Double = Float;
	}
}
