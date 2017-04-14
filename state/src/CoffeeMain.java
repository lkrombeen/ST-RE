package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import de.ls5.jlearn.abstractclasses.LearningException;
import de.ls5.jlearn.algorithms.packs.ObservationPack;
import de.ls5.jlearn.equivalenceoracles.WMethodEquivalenceTest;
import de.ls5.jlearn.interfaces.Automaton;
import de.ls5.jlearn.interfaces.EquivalenceOracle;
import de.ls5.jlearn.interfaces.EquivalenceOracleOutput;
import de.ls5.jlearn.interfaces.Learner;
import de.ls5.jlearn.interfaces.Oracle;
import de.ls5.jlearn.interfaces.State;
import de.ls5.jlearn.interfaces.Symbol;
import de.ls5.jlearn.logging.HtmlLoggingAppender;
import de.ls5.jlearn.logging.LearnLog;
import de.ls5.jlearn.logging.LogLevel;
import de.ls5.jlearn.logging.PrintStreamLoggingAppender;
import de.ls5.jlearn.shared.AutomatonImpl;
import de.ls5.jlearn.util.DotUtil;

public class CoffeeMain {

	private static int states = 50;
	
	public static void main(String[] args) throws IOException, LearningException {
		PrintStreamLoggingAppender logger = new PrintStreamLoggingAppender(LogLevel.INFO,System.out);
		
		LearnLog.addAppender(new PrintStreamLoggingAppender(LogLevel.INFO,System.out));
//		LearnLog.addAppender(new HtmlLoggingAppender(LogLevel.DEBUG,
//            "./tmp/learn.html", false, false, false));
		
		// create oracle for mutex
		Oracle testOracle = new CoffeeOracle();

		EquivalenceOracle eqtest = new WMethodEquivalenceTest(12);
		eqtest.setOracle(testOracle);

		Learner learner = new ObservationPack();
		learner.setOracle(testOracle);
		learner.setAlphabet(CoffeeTestDriver.SIGMA);
		
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
		
		File file = new File("./tmp/learnresult.dot");
		BufferedReader br = new BufferedReader(new FileReader(file));  
		String line = null;  
		StringWriter copy = new StringWriter();
		while ((line = br.readLine()) != null)  
		{  
			boolean ignore = false;
			for (int i = 0; i < states; i++) {
				if (line.startsWith("s" + i +" -> s" + i)) {
					ignore = true;
				}
			}
			
			if (!ignore) {
				copy.append(line + System.lineSeparator());
			}
		}
		br.close();

		PrintWriter out = new PrintWriter("./tmp/learnresult.dot");
		out.print(copy.toString());
		out.close();
		
	}

}
