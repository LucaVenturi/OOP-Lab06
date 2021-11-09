package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -288979685441144222L;
    private final double battery;

    /**
     * Construct new instance of the exception.
     * 
     * @param battery
     *            the battery level which caused the exception.
     */
    public NotEnoughBatteryException(final double battery) {
        super();
        this.battery = battery;
    }

    /**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Can not move, not enough battery, current level: " + this.battery;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
