package learner;





import de.ls5.jlearn.interfaces.Alphabet;
import de.ls5.jlearn.interfaces.Symbol;
import de.ls5.jlearn.shared.AlphabetImpl;
import de.ls5.jlearn.shared.SymbolImpl;

public class CoffeeTestDriver {

    // input symbols
    /*private static final Symbol M1_IN = new SymbolImpl(".50_in");
    private static final Symbol M2_IN = new SymbolImpl("1.00_in");
    private static final Symbol M3_IN = new SymbolImpl("2.00_in");

    private static final Symbol F1_IN = new SymbolImpl("cappuccino_in");
    private static final Symbol F2_IN = new SymbolImpl("espresso_in");
    private static final Symbol F3_IN = new SymbolImpl("regular_in");
    
    private static final Symbol S1_IN = new SymbolImpl("sugar_1_in");
    private static final Symbol S2_IN = new SymbolImpl("sugar_2_in");
    private static final Symbol S3_IN = new SymbolImpl("sugar_3_in");

    private static final Symbol C_IN = new SymbolImpl("cancel_in");
    private static final Symbol A_IN = new SymbolImpl("accept_in");

    private static final Symbol ISM1 = new SymbolImpl("money_.50?");
    private static final Symbol ISM2 = new SymbolImpl("money_1?");
    private static final Symbol ISM3 = new SymbolImpl("money_1.50?");
    private static final Symbol ISM4 = new SymbolImpl("money_2.00?");

    private static final Symbol ISF1 = new SymbolImpl("flavour_cappuccino?");
    private static final Symbol ISF2 = new SymbolImpl("flavour_espresso?");
    private static final Symbol ISF3 = new SymbolImpl("flavour_regular?");

    private static final Symbol ISS1 = new SymbolImpl("sugar_1?");
    private static final Symbol ISS2 = new SymbolImpl("sugar_2?");
    private static final Symbol ISS3 = new SymbolImpl("sugar_3?");*/
    private static final Symbol M1_IN = new SymbolImpl("c1");
    private static final Symbol M2_IN = new SymbolImpl("c2");
    private static final Symbol M3_IN = new SymbolImpl("c3");

    private static final Symbol F1_IN = new SymbolImpl("f1");
    private static final Symbol F2_IN = new SymbolImpl("f2");
    private static final Symbol F3_IN = new SymbolImpl("f3");
    
    private static final Symbol S1_IN = new SymbolImpl("s1");
    private static final Symbol S2_IN = new SymbolImpl("s2");
    private static final Symbol S3_IN = new SymbolImpl("s3");

    private static final Symbol C_IN = new SymbolImpl("C");
    private static final Symbol A_IN = new SymbolImpl("A");

    private static final Symbol ISM1 = new SymbolImpl("c4?");
    private static final Symbol ISM2 = new SymbolImpl("c5?");
    private static final Symbol ISM3 = new SymbolImpl("c6?");
    private static final Symbol ISM4 = new SymbolImpl("c7?");

    private static final Symbol ISF1 = new SymbolImpl("f4?");
    private static final Symbol ISF2 = new SymbolImpl("f5?");
    private static final Symbol ISF3 = new SymbolImpl("f3?");

    private static final Symbol ISS1 = new SymbolImpl("s4?");
    private static final Symbol ISS2 = new SymbolImpl("s5?");
    private static final Symbol ISS3 = new SymbolImpl("s6?");

    // input alphabet used by learning algorithm
    public static final Alphabet SIGMA;
    static
    {
        SIGMA = new AlphabetImpl();
        SIGMA.addSymbol(M1_IN);
        SIGMA.addSymbol(M2_IN);
        SIGMA.addSymbol(M3_IN);
        
        SIGMA.addSymbol(F1_IN);
        SIGMA.addSymbol(F2_IN);
        SIGMA.addSymbol(F3_IN);
        
        SIGMA.addSymbol(S1_IN);
        SIGMA.addSymbol(S2_IN);
        SIGMA.addSymbol(S3_IN);
        
        SIGMA.addSymbol(C_IN);
        SIGMA.addSymbol(A_IN);

        SIGMA.addSymbol(ISM1);
        SIGMA.addSymbol(ISM2);
        SIGMA.addSymbol(ISM3);
        SIGMA.addSymbol(ISM4);
        
        SIGMA.addSymbol(ISF1);
        SIGMA.addSymbol(ISF2);
        SIGMA.addSymbol(ISF3);
        
        SIGMA.addSymbol(ISS1);
        SIGMA.addSymbol(ISS2);
        SIGMA.addSymbol(ISS3);
    }

    // return values
    private static final Symbol TOP = new SymbolImpl("true");
    private static final Symbol BOT = new SymbolImpl("false");
    private static final Symbol NOOP = new SymbolImpl("-");
    
    // system under test
    public CoffeeMachine machine;
    
    public Symbol executeSymbol(Symbol s) {
        if (s.equals(M1_IN)) {
        	machine.addMoney(0.50F);
            return NOOP;
        } else if (s.equals(M2_IN)) {
        	machine.addMoney(1F);
            return NOOP;
        } else if (s.equals(M3_IN)) {
        	machine.addMoney(2F);
            return NOOP;
        } else if (s.equals(F1_IN)){
        	machine.selectFlavour(1);
            return NOOP;
        } else if (s.equals(F2_IN)){
        	machine.selectFlavour(2);
            return NOOP;
        } else if (s.equals(F3_IN)){
        	machine.selectFlavour(3);
            return NOOP;
        } else if (s.equals(S1_IN)){
	    	machine.selectSugarLevel(1);
	        return NOOP;
        } else if (s.equals(S2_IN)){
	    	machine.selectSugarLevel(2);
	        return NOOP;
	    } else if (s.equals(S3_IN)){
	    	machine.selectSugarLevel(3);
	        return NOOP;
        } else if (s.equals(A_IN)){
	    	machine.accept(2);
	        return NOOP;
	    } else if (s.equals(C_IN)){
	    	machine.cancel(3);
	        return NOOP;
	    } else if (s.equals(ISM1)){
            return machine.hasMoney(0.50F) ? TOP : BOT;
	    } else if (s.equals(ISM2)){
            return machine.hasMoney(1F) ? TOP : BOT;
	    } else if (s.equals(ISM3)){
            return machine.hasMoney(1.50F) ? TOP : BOT;
	    } else if (s.equals(ISM4)){
            return machine.hasMoney(2F) ? TOP : BOT;
	    } else if (s.equals(ISF1)){
            return machine.hasFlavour(1) ? TOP : BOT;
	    } else if (s.equals(ISF2)){
            return machine.hasFlavour(2) ? TOP : BOT;
	    } else if (s.equals(ISF3)){
            return machine.hasFlavour(3) ? TOP : BOT;
	    } else if (s.equals(ISS1)){
            return machine.hasSugarLevel(1) ? TOP : BOT;
	    } else if (s.equals(ISS2)){
            return machine.hasSugarLevel(2) ? TOP : BOT;
	    } else if (s.equals(ISS3)){
            return machine.hasSugarLevel(3) ? TOP : BOT;
	    }
        return null;
    }

    public void reset() {
        this.machine = new CoffeeMachine();
    }
    
}
