package sml.state;

import enums.Coin;
import enums.Flavour;

public abstract class State {
	
	private static final String ERR_SUGAR_LEVEL_RANGE = "The sugar level must be either 0, 1, 2 or 3";

	/**
	 * Accept the coffee ordering
	 * @param context Context of the application
	 */
	public void accept(Context context) {
		// Do nothing by default
	}
	
	/**
	 * Cancel the coffee ordering
	 * @param context Context of the application
	 */
	public void cancel(Context context) {
		// Do nothing by default
	}
	
	/**
	 * Go to picking a flavour
	 * @param context
	 */
	public void pickFlavour(Context context) {
		// Do nothing by default
	}
	
	/**
	 * Insert a coin in the machine
	 * @param context Context of the application
	 * @param coin that was inserted
	 */
	public void insertCoin(Context context, Coin coin) {
		// Do nothing by default
	}
	
	public void setFlavour(Context context, Flavour flavour) {
		// Do nothing by default
	}
	
	public void setSugar(Context context, int sugarLevel) {
		if (sugarLevel < 0 || sugarLevel > 3) {
			throw new IllegalArgumentException(ERR_SUGAR_LEVEL_RANGE);
		}
	}
}
