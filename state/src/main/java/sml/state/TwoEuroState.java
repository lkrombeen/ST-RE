package sml.state;

import enums.Coin;
import enums.Flavour;

public class TwoEuroState extends State {
	
	@Override
	public void insertCoin(Context context, Coin coin) {
		System.out.println("INF: The machine returns " + coin.toString());
	}
	
	@Override
	public void pickFlavour(Context context) {
		// Sets the default regular, no idea how to make this transition as we designed without adding too many classes.
		new FlavourState().setFlavour(context, Flavour.REGULAR);
	}
}
