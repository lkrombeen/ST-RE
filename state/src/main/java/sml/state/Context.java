package sml.state;

public class Context {

	/**
	 * State of the context
	 */
	private State state;
	
	/**
	 * Create a new Context with no start state
	 */
	public Context() {
		this.state = null;
	}
	
	/**
	 * Create a context with a start state
	 * @param startState state to start with
	 */
	public Context(State startState) {
		this.state = null;
	}
	
	/**
	 * Gets the state
	 * @return state of the Context
	 */
	public State getState() {
		return this.state;
	}
	
	/**
	 * Sets the state
	 * @param state new State
	 */
	public void setState(State state) {
		System.out.println("State switched from " + this.state.toString() + " to " + state.toString());
		this.state = state;
	}
}
