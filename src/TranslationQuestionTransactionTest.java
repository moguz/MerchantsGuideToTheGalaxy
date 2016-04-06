import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for TranslationQuestionTransaction. Valid and invalid inputs are tested. 
 * Completely wrong inputs and empty inputs are already covered.
 * @author Mert
 *
 */
public class TranslationQuestionTransactionTest {

	@Before
	public void setup(){
		ConversionTool conversionTool = new ConversionTool("input.txt");
		ConversionTool.galacticToRomanDictionary.put("glob", 'I');
		ConversionTool.galacticToRomanDictionary.put("prok", 'V');
		ConversionTool.galacticToRomanDictionary.put("pish", 'X');
		ConversionTool.galacticToRomanDictionary.put("tegj", 'L');
	}
	
	@Test
	public void testProcessTransaction() {
		String line = "how much is pish tegj glob glob ?";
		TranslationQuestionTransaction translationQuestionTransaction = new TranslationQuestionTransaction(line);
		translationQuestionTransaction.processTransaction();
		assertTrue(translationQuestionTransaction.result.equals("pish tegj glob glob is 42"));
		
		line = "how much is pish tegj glob globs ?";
		translationQuestionTransaction = new TranslationQuestionTransaction(line);
		translationQuestionTransaction.processTransaction();
		assertTrue(translationQuestionTransaction.result.equals("I have no idea what you are talking about"));
	}
}
