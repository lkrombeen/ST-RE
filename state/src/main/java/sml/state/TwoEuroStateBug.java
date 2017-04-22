package sml.state;

import enums.Coin;
import enums.Flavour;

public class TwoEuroStateBug extends TwoEuroState {

	// This method causes the unwanted transition
	@Override
	public void setSugar(Context context, int sugarLevel) {
		context.setState(new SugarState(context, sugarLevel));
	}
}
