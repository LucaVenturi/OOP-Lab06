package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7190620326792084901L;
	private final int actualUser,expectedUser;

	/**
	 * @param actualUser
	 *
	 * @param expectedUser
	 */
	public WrongAccountHolderException(int actualUser, int expectedUser) {
		super();
		this.actualUser = actualUser;
		this.expectedUser = expectedUser;
	}

	@Override
	public String toString() {
		return "Wrong Account Holder, expected: " + this.expectedUser + ", given: " + this.actualUser;
	}
	
    @Override
    public String getMessage() {
        return this.toString();
    }
}
