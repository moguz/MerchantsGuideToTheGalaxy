import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Converter. Valid and invalid inputs are tested. Different conversion scenarios and
 * roman number rules are tested.
 * @author Mert
 *
 */
public class ConverterTest {
	
	@Before
	public void setup() {
		ConversionTool conversionTool = new ConversionTool("input.txt");
	}

	@Test
	public void testGalacticToRoman() {
		ConversionTool.galacticToRomanDictionary.put("glob", 'I');
		ConversionTool.galacticToRomanDictionary.put("prok", 'V');
		String galactic = "prok glob";
		assertTrue(Converter.convertGalacticToRoman(galactic).equals("VI"));
		
		galactic = "prok dummy glob";
		assertTrue(Converter.convertGalacticToRoman(galactic).equals("VdummyI"));
	}
	
	@Test
	public void testIsValidRoman() {
		assertTrue(Converter.isValidRoman("MDCLXVII")==true);
		assertTrue(Converter.isValidRoman("MMM")==true);
		assertTrue(Converter.isValidRoman("MMMM")==false);
		assertTrue(Converter.isValidRoman("DDL")==false);
		assertTrue(Converter.isValidRoman("IL")==false);
		assertTrue(Converter.isValidRoman("IXL")==false);
	}
	
	@Test
	public void testConvertRomanToDecimal() {
		assertTrue(Converter.convertRomanToDecimal("VI") == 6);
		assertFalse(Converter.convertRomanToDecimal("VII") == 5);
		assertTrue(Converter.convertRomanToDecimal("MDCLXVIII") == 1668);
	}

}
