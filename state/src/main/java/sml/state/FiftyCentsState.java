package sml.state;

import enums.Coin;

public class FiftyCentsState extends State {
	
	@Override
	public void insertCoin(Context context, Coin coin) {
		switch (coin) {
		case CENT50:
			context.setState(new OneEuroState());
			break;
		case EURO1:
			context.setState(new OneEuroFiftyState());
			break;
		case EURO2:
			System.out.println("INF: The machine returns CENT50");
			context.setState(TwoEuroState.GetTwoEuroState());
			break;
		}
	}
}
