package sml.state;

public class EndState extends State {
	
	public EndState(Context context) {
		// Coffee was poured, next customer!
		context.setState(new StartState());
	}

}
