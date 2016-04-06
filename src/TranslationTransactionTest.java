import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for TransactionTranslation. Valid and invalid inputs are tested. Completely wrong inputs and empty inputs
 * are already covered.
 * @author Mert
 *
 */
public class TranslationTransactionTest {
	
	@Before
	public void setup(){
		ConversionTool conversionTool = new ConversionTool("input.txt");
	}
	
	public void prepare(String line){
		TranslationTransaction translationTransaction = new TranslationTransaction(line);
		translationTransaction.processTransaction();
	}

	@Test
	public void testValidInput() {
		String line = "glob is I";
		prepare(line);
		assertTrue(ConversionTool.galacticToRomanDictionary.get("glob")=='I');
	}
	
	@Test
	public void testWrongRoman() {
		String line = "prop is II";
		prepare(line);
		assertFalse(ConversionTool.galacticToRomanDictionary.containsKey("glob"));
	}
}
