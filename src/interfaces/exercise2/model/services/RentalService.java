package interfaces.exercise2.model.services;

import interfaces.exercise2.model.entities.CarRental;
import interfaces.exercise2.model.entities.Invoice;

public class RentalService {
	
	private double pricePerDay;
	private double pricePerHour;
	private TaxService service;
	//Como podemos ver, podemos tipo que usar um atributo generico que todas as classes que estender essa interface
	//Vao ser obrigadas a usar tal metodo, entao podemos fazer a chamada por um atributo generico no metodo
	//"processInvoice".
	
	public RentalService(double pricePerDay, double pricePerHour, TaxService service) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		
		//A pessoa vai ser obrigada a passar uma instacia de uma classe que implementa TaxService, entao ele pode trocar
		//A hora que quiser no progama principal, ele pode usar tanto Brazil quanto Us que nao vai dar nenhum erro
		this.service = service;
		//Podemos fazer isso com classe abstrata generica? Sim, pois uma interface e basicamente uma classe abstrata mais
		//Limitada, mas pensa assim, porque estariamos retirando o direito de tal estender outra classe, porque como voce
		//Sabe, uma classe so pode extender uma classe, entao vamos estar reteriando esse direito de ela estender outra
		//Classe, porque estamos usando para estender uma classe que faz algo muito simple e que pode ser substituido por
		//Uma interface. Entao, Seria muito melhor usar uma interface, pois nao estariamos reteriando esse direto, e uma
		//Mesma classe pode implementar diversas interfaces.
		//Entao use essa regra quando estiver em duvida de usar uma classe abstrata ou uma interface.
		//Caso voce precise obrigar uma classe tenha tais atibutos e tais metodos, que vai ter getter e setters e os kraio a 4,
		//Use uma classe abstrata. Mas caso precise apenas obrigar uma classe a ter um metodo simples para cumprir o
		//Contrato, como, toda classe que estender "moveable" tem que ter o metodo move(), pode usar uma interface
		//https://pt.stackoverflow.com/questions/377018/por-que-usar-interface-aos-inv%C3%AAs-de-heran%C3%A7a
	}
	
	public void processInvoice(CarRental carRental) {
		long start = carRental.getStart().getTimeInMillis();
		long finish = carRental.getFinish().getTimeInMillis();
		
		double hours = (double) (finish - start) / 1000 / 60 / 60; //Dividimos por mil ai ira transformar em segundos, em 60
		//Para minutos e em 60 denovo para finalmente transformar em horas
		
		double basicPayment;
		
		//A regra do nosso progama e cobrar por hora nas primeiras 12 horas, depois disso vai ser cobrado o valor por dia,
		//Ou seja...
		
		if(hours <= 12) {
			basicPayment = Math.ceil(hours) * this.pricePerHour;
			//Math.ceil arredonda o valor pra cima, ou seja, se as horas voltaram como 5.40, ele vai arredondar pra cima (6)
		} else {
			basicPayment = Math.ceil(hours / 24) * this.pricePerDay;
			//Se as horas retornar 25.6 ele vai arrendor pra 2, pois 25.6/24 = 1,06. Nao importa se so passou uma hora, o
			//Sistema vai contar como se fosse 2 horas
		}
		
		double tax = service.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
}
