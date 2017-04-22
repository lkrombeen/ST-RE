package sml.state;

import enums.Coin;

public class OneEuroState extends State {
	
	@Override
	public void insertCoin(Context context, Coin coin) {
		switch (coin) {
		case CENT50:
			context.setState(new OneEuroFiftyState());
			break;
		case EURO1:
			context.setState(TwoEuroState.GetTwoEuroState());
			break;
		case EURO2:
			context.setState(TwoEuroState.GetTwoEuroState());
			System.out.println("INF: The machine returns EURO1");
			break;
		}
	}
}
