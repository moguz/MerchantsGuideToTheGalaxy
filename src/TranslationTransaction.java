/**
 * TranslationTransaction: "pish is X". This class processes the transaction.
 * @author Mert
 *
 */
public class TranslationTransaction implements Transaction {
	
	private String line;
	private String galactic;
	private char roman;

	public TranslationTransaction(String line) {
		this.line = line;
	}

	@Override
	public void processTransaction() {
		line = line.trim();
		String[] parts = line.split(" is ");
		galactic = parts[0];
		roman = parts[1].charAt(0);
		ConversionTool.galacticToRomanDictionary.put(galactic, roman);
	}
	
	public String getGalactic(){
		return galactic;
	}
	
	public char getRoman(){
		return roman;
	}

}
