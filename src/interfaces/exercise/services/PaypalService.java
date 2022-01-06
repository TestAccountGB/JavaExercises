package interfaces.exercise.services;

public class PaypalService implements OnlinePaymentService {
	
	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public double tax(double amount, int month) {
		double amountTaxed = (amount * MONTHLY_INTEREST * month);
		return amountTaxed + (amountTaxed * FEE_PERCENTAGE);
	}
	
}
