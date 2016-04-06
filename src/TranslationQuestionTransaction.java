/**
 * TranslationQuestionTransaction: "how much is pish tegj glob glob ?". This class processes the transaction 
 * and generates the result.
 * @author Mert
 *
 */
public class TranslationQuestionTransaction extends QuestionTransaction implements Transaction {

	private String galactic;
	
	public TranslationQuestionTransaction(String line) {
		super(line);
		galactic = "";
	}

	@Override
	public void processTransaction() {
		galactic = line.substring(12,line.length()-2);
		calculateResult();
	}
	
	private void calculateResult() {
		String roman = Converter.convertGalacticToRoman(galactic);
		if(Converter.isValidRoman(roman)){
			int decimal = Converter.convertRomanToDecimal(roman);
			result = galactic + " is " + decimal;
		}
		else{
			result = "I have no idea what you are talking about";
		}
	}

	public String getGalactic(){
		return galactic;
	}

}
