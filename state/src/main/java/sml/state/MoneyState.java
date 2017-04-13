package sml.state;

public class MoneyState extends State {
	@Override
	public void cancel(Context context) {
		context.setState(new StartState());
	}
}
