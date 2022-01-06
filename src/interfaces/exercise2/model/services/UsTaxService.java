package interfaces.exercise2.model.services;

public class UsTaxService implements TaxService{

	@Override
	public double tax(double amount) {
		return (amount <= 100) ? amount * 0.15 : amount * 0.10;
	}

}
