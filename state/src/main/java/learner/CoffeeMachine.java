package learner;





public class CoffeeMachine {

	private float money;
	private float flavour;
	private float sugar;
	
	private int state = 0;
	
	public CoffeeMachine() {
		money = 0;
		flavour = -1;
		sugar = -1;
		
		state = 2;
	}
	
	public void addMoney(float f) {
		if (state == 2) {
			money += f;
		}
	}

	public void selectFlavour(int i) {
		if (state == 0) {
			flavour = i;
		}
	}

	public void selectSugarLevel(int i) {
		if (state == 1) {
			sugar = i;
		}
	}

	public void accept(int i) {
		switch (state) {
		case 0:
			if (flavour != -1) {
				sugar = 1;
				state = 1;
			}
			break;
		case 1:
			if (sugar != -1) {
				state = 3;
			}
			break;
		case 2:
			if (money == 2F) {
				money = 0;
				flavour = 1;
				sugar = -1;
				state = 0;
			} else if (money > 2F) {
				money = 0;
				flavour = -1;
				sugar = 1;
				state = 1;
			}
			break;
		case 3:
			money = 0;
			flavour = -1;
			sugar = -1;
			
			state = 2;
			break;
		}
	}

	public void cancel(int i) {
		if (state != 3) {
			money = 0;
			flavour = -1;
			sugar = -1;
			
			state = 2;
		}
	}

	public boolean hasMoney(float f) {
		if (state == 2) 
			return money >= f;
		return false;
	}

	public boolean hasFlavour(int i) {
		if (state == 0) 
			return flavour == i;
		return false;
	}

	public boolean hasSugarLevel(int i) {
		if (state == 1) 
			return sugar == i;
		return false;
	}

}
