
public class PriceQuestionTransaction extends QuestionTransaction implements Transaction {

	private String galactic;
	private String materialName;
	
	public PriceQuestionTransaction(String line) {
		super(line);
		galactic="";
		materialName="";
	}

	@Override
	public void processTransaction() {
		int materialQuantity = 0;
		line = line.substring(20,line.length()-2);
		String[] parts = line.split(" ");
		boolean stillReadingGalactic = true;
		for(int i = 0; i < parts.length; i++){
			if(ConversionTool.galacticToRomanDictionary.containsKey(parts[i]) && stillReadingGalactic){
				galactic += parts[i]+" ";
			}
			else {
				stillReadingGalactic = false;
				materialName += parts[i]+" ";
			}
		}
		materialName = materialName.trim();
		galactic = galactic.trim();
		String roman = Converter.convertGalacticToRoman(galactic);
		if(Converter.isValidRoman(roman)){
			materialQuantity = Converter.convertRomanToDecimal(roman);
		}
		if(isValid()){
			result = galactic + " " + materialName + " is " +
					(int)(materialQuantity*ConversionTool.materialPriceDictionary.get(materialName)) + " Credits";
		}
		else{
			result = "I have no idea what you are talking about";
		}
		
	}

	private boolean isValid() {
		if(materialName.isEmpty() || materialName == null){
			return false;
		}
		if(!ConversionTool.materialPriceDictionary.containsKey(materialName)){
			return false;
		}
		return true;
	}

}
