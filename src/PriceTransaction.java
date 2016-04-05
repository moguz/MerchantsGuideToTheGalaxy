
public class PriceTransaction implements Transaction {
	
	private String line;
	private String galactic;
	private double price;
	private String materialName;

	public PriceTransaction(String line) {
		this.line = line;
		this.materialName = "";
		this.galactic = "";
		
	}

	@Override
	public void processTransaction() {
		int cumulativePrice = 0;
		int materialQuantity = 0;
		line = line.trim();
		String[] parts = line.split(" is ");
		String firstPart = parts[0];
		String[] firstPartWords = firstPart.split(" ");
		boolean stillReadingGalactic = true;
		for(int i = 0; i < firstPartWords.length; i++){
			if(ConversionTool.galacticToRomanDictionary.containsKey(firstPartWords[i]) && stillReadingGalactic){
				galactic += firstPartWords[i]+" ";
			}
			else {
				stillReadingGalactic = false;
				materialName += firstPartWords[i]+" ";
			}
		}
		String secondPart = parts[1].substring(0,parts[1].length()-8);
		if(secondPart.matches("\\d+")){
			cumulativePrice = Integer.parseInt(secondPart);
		}
		String roman = Converter.convertGalacticToRoman(galactic);
		if(Converter.isValidRoman(roman)){
			materialQuantity = Converter.convertRomanToDecimal(roman);
		}
		if(materialQuantity > 0){
			price = (double)cumulativePrice / materialQuantity;
		}
		
		ConversionTool.materialPriceDictionary.put(materialName.trim(), price);
	}

}
