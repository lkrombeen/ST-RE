package sml.state;

import enums.Flavour;

public class FlavourState extends State {

	/**
	 * Return the money (2,-) that was inserted and go to the start state
	 */
	@Override
	public void cancel(Context context) {
		System.out.println("INF: the machine ejected 2,- euro");
		context.setState(new StartState());
	}
	
	@Override
	public void setSugar(Context context, int sugarLevel) {
		context.setState(new SugarState(context, sugarLevel));
	}
	
	@Override
	public void setFlavour(Context context, Flavour flavour) {
		switch (flavour) {
		case CAPPUCCINO:
			context.setState(new FlavourCappuccinoState());
			break;
		case ESPRESSO:
			context.setState(new FlavourEspressoState());
			break;
		case REGULAR:
			context.setState(new FlavourRegularState());
			break;
		}
	}
}
