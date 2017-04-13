package sml.state;

public class SugarState extends State {
	private int sugarLevel;
	
	public SugarState(Context context, int sugarLevel) {
		this.setSugar(context, sugarLevel);
	}
	
	@Override
	public void setSugar(Context context, int sugarLevel) {
		super.setSugar(context, sugarLevel);
		this.sugarLevel = sugarLevel;
	}

	/**
	 * Return the money (2,-) that was inserted and go to the start state
	 */
	@Override
	public void cancel(Context context) {
		System.out.println("INF: the machine ejected 2,- euro");
		context.setState(new StartState());
	}
	
	@Override
	public void accept(Context context) {
		// Finish and pour the coffee
		context.setState(new EndState(context));
	}
}
