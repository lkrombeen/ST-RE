package learner;

import de.ls5.jlearn.interfaces.Alphabet;
import de.ls5.jlearn.interfaces.Symbol;
import de.ls5.jlearn.shared.AlphabetImpl;
import de.ls5.jlearn.shared.SymbolImpl;

public class ExampleTestDriver {

    // input symbols
    private static final Symbol A_IN = new SymbolImpl("a_in");
    private static final Symbol B_IN = new SymbolImpl("b_in");
    private static final Symbol C_IN = new SymbolImpl("c_in");
    private static final Symbol ISVALID = new SymbolImpl("isvalid?");

    // input alphabet used by learning algorithm
    public static final Alphabet SIGMA;
    static
    {
        SIGMA = new AlphabetImpl();
        SIGMA.addSymbol(A_IN);
        SIGMA.addSymbol(B_IN);
        SIGMA.addSymbol(C_IN);
        SIGMA.addSymbol(ISVALID);
    }

    // return values
    private static final Symbol TOP = new SymbolImpl("true");
    private static final Symbol BOT = new SymbolImpl("false");
    private static final Symbol NOOP = new SymbolImpl("-");
    
    // system under test
    public Example example;
    
    // local test variables
    private final char a = 'a';
    private final char b = 'b';
    private final char c = 'c';

    public Symbol executeSymbol(Symbol s) {
        if (s.equals(A_IN)) {
        	example.add(a);
            return NOOP;
        } else if (s.equals(B_IN)) {
        	example.add(b);
            return NOOP;
        } else if (s.equals(C_IN)) {
        	example.add(c);
            return NOOP;
        } else if (s.equals(ISVALID)){
            return example.isValid() ? TOP : BOT;
        }
        return null;
    }

    public void reset() {
        this.example = new Example();
    }
    
}
