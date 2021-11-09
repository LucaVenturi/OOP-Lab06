package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5186015990336694793L;
	private final double quota;
	
	public TransactionsOverQuotaException(double quota) {
		super();
		this.quota = quota;
	}
	
	@Override
	public String toString() {
		return "Number of ATM transactions exceeded the limit of " + this.quota;
	}
	
	@Override
	public String getMessage() {
		return this.toString();
	}
}
