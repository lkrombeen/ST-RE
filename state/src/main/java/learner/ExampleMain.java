package learner;

import java.io.File;
import java.io.IOException;

import de.ls5.jlearn.abstractclasses.LearningException;
import de.ls5.jlearn.algorithms.packs.ObservationPack;
import de.ls5.jlearn.equivalenceoracles.WMethodEquivalenceTest;
import de.ls5.jlearn.interfaces.Automaton;
import de.ls5.jlearn.interfaces.EquivalenceOracle;
import de.ls5.jlearn.interfaces.EquivalenceOracleOutput;
import de.ls5.jlearn.interfaces.Learner;
import de.ls5.jlearn.interfaces.Oracle;
import de.ls5.jlearn.logging.HtmlLoggingAppender;
import de.ls5.jlearn.logging.LearnLog;
import de.ls5.jlearn.logging.LogLevel;
import de.ls5.jlearn.logging.PrintStreamLoggingAppender;
import de.ls5.jlearn.util.DotUtil;

public class ExampleMain {

	public static void main(String[] args) throws IOException, LearningException {
		PrintStreamLoggingAppender logger = new PrintStreamLoggingAppender(LogLevel.INFO,System.out);
		
		LearnLog.addAppender(new PrintStreamLoggingAppender(LogLevel.INFO,System.out));
		LearnLog.addAppender(new HtmlLoggingAppender(LogLevel.DEBUG,
            "./tmp/learn.html", false, false, false));
		
		// create oracle for mutex
		Oracle testOracle = new ExampleOracle();

		EquivalenceOracle eqtest = new WMethodEquivalenceTest(4);
		eqtest.setOracle(testOracle);

		Learner learner = new ObservationPack();
		learner.setOracle(testOracle);
		learner.setAlphabet(ExampleTestDriver.SIGMA);
		
		boolean equiv = false;
		while (!equiv)
		{
		      // learn one round
		      learner.learn();
		      Automaton hyp = learner.getResult();

		      logger.log("hypothetical states: " + hyp.getAllStates().size(), LogLevel.INFO, "");

		      // search for counterexample
		      EquivalenceOracleOutput o = eqtest.findCounterExample(hyp);
		      if (o == null) {
		            equiv = true;
		            continue;
		      }
		      learner.addCounterExample(o.getCounterExample(), o.getOracleOutput());
		}

		DotUtil.writeDot(learner.getResult(), new File("./tmp/learnresult.dot"));
	}

}
