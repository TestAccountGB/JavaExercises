package exceptions.exercise.exceptions;

public class CheckoutException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public CheckoutException() {
		 super("Error: Check-out date must be after check-in date");
	}
	
	public CheckoutException(String message) {
		super(message);
	}
}
