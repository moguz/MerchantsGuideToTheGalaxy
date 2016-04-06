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
	public void testProcessTransaction() {
		String line = "glob is I";
		prepare(line);
		assertTrue(ConversionTool.galacticToRomanDictionary.get("glob")=='I');
		
		line = "xxxxx is C";
		prepare(line);
		System.out.println(ConversionTool.galacticToRomanDictionary.toString());
		assertTrue(ConversionTool.galacticToRomanDictionary.get("xxxxx")=='C');
	}
}
