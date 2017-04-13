package learner;


public class Example {

	private boolean valid;
	
	public Example() {
		valid = false;
	}
	
	public void add(char character) {
		valid = (character == 'a');
	}
	
	public boolean isValid() {
		return valid;
	}
	
}
