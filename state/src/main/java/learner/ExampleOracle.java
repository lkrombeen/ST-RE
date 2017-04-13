package learner;

import de.ls5.jlearn.abstractclasses.LearningException;
import de.ls5.jlearn.interfaces.Oracle;
import de.ls5.jlearn.interfaces.Symbol;
import de.ls5.jlearn.interfaces.Word;
import de.ls5.jlearn.shared.WordImpl;

public class ExampleOracle implements Oracle {

    private ExampleTestDriver testDriver;

    public ExampleOracle() {        
        testDriver = new ExampleTestDriver();
    }

    public Word processQuery(Word query) throws LearningException {
        Word trace = new WordImpl();
        testDriver.reset();
        for (Symbol i : query.getSymbolList()) {
            Symbol o = testDriver.executeSymbol(i);
            trace.addSymbol(o);
        }
        return trace;
    }
}