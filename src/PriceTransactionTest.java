import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for PriceTransaction. Valid and invalid inputs are tested. Completely wrong inputs and empty inputs
 * are already covered.
 * @author Mert
 *
 */
public class PriceTransactionTest {

	@Before
	public void setup(){
		ConversionTool conversionTool = new ConversionTool("input.txt");
		TranslationTransaction translationTransaction = new TranslationTransaction("glob is I");
		translationTransaction.processTransaction();
	}
	
	public void prepare(String line){
		PriceTransaction priceTransaction = new PriceTransaction(line);
		priceTransaction.processTransaction();
	}

	@Test
	public void testProcessTransaction() {
		String line = "glob glob Silver is 34 Credits";
		prepare(line);
		assertTrue(ConversionTool.materialPriceDictionary.get("Silver")==17);
		
		line = "glob glob Silver Bar is 34 Credits";
		prepare(line);
		assertTrue(ConversionTool.materialPriceDictionary.get("Silver Bar")==17);
		
		line = "globs glob Gold is 34 Credits";
		prepare(line);
		assertFalse(ConversionTool.materialPriceDictionary.containsKey("Gold"));
	}
}
