package exceptions.exercise.exceptions;

public class OlderDateException extends Exception{

	private static final long serialVersionUID = 2L;

	public OlderDateException() {
		 super("Error: The updated date must be newer than the old one");
	}

	public OlderDateException(String message) {
		super(message);
	}
}
