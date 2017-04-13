package sml.state;

import enums.Coin;

public class OneEuroFiftyState extends State {
	
	@Override
	public void insertCoin(Context context, Coin coin) {
		switch (coin) {
		case CENT50:
			context.setState(new TwoEuroState());
			break;
		case EURO1:
			System.out.println("INF: The machine returns CENT50");
			context.setState(new TwoEuroState());
			break;
		case EURO2:
			System.out.println("INF: The machine returns EURO1+CENT50");
			context.setState(new TwoEuroState());
			break;
		}
	}
}
