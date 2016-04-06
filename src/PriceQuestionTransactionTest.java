import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * Test class for PriceQuestionTransaction. Valid and invalid inputs are tested. Completely wrong inputs and empty inputs
 * are already covered.
 * @author Mert
 *
 */
public class PriceQuestionTransactionTest {

	@Before
	public void setup(){
		ConversionTool conversionTool = new ConversionTool("input.txt");
		ConversionTool.galacticToRomanDictionary.put("glob", 'I');
		ConversionTool.galacticToRomanDictionary.put("prok", 'V');
		ConversionTool.materialPriceDictionary.put("Silver", 10.0);
	}

	@Test
	public void testProcessTransaction() {
		String line = "how many Credits is glob prok Silver ?";
		PriceQuestionTransaction priceQuestionTransaction = new PriceQuestionTransaction(line);
		priceQuestionTransaction.processTransaction();
		assertTrue(priceQuestionTransaction.result.equals("glob prok Silver is 40 Credits"));
		
		line = "how many Credits is pish glob Silver ?";
		priceQuestionTransaction = new PriceQuestionTransaction(line);
		priceQuestionTransaction.processTransaction();
		assertTrue(priceQuestionTransaction.result.equals("I have no idea what you are talking about"));
	}

}
