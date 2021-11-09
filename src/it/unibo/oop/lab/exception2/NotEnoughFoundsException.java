package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1018751054348870270L;
	private final double balance;
	private final double amount;
	public NotEnoughFoundsException(double balance, double amount) {
		super();
		this.balance = balance;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Not Enough Founds, current balance is: " + this.balance + ", can't withdraw " + this.amount;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}
}
