package main;

public class ErrorInputException extends Exception {
	private String message;

	public ErrorInputException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
