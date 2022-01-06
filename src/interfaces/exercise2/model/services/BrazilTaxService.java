package interfaces.exercise2.model.services;

public class BrazilTaxService implements TaxService {
	
	@Override
	public double tax(double amount) {
		return (amount <= 100) ? amount * 0.20 : amount * 0.15;
		//Se o valor for menor igual a 100 ele vai retornar o imposto de 20% de amount senao, ele vai retornar 15%
	}
}
