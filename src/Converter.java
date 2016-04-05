
public class Converter {
	
	public static String convertGalacticToRoman(String galactic){
		for (String key : ConversionTool.galacticToRomanDictionary.keySet()){
			galactic = galactic.replaceAll(key, ""+ConversionTool.galacticToRomanDictionary.get(key));
		}
		galactic = galactic.replaceAll(" ", "");
		return galactic;
	}
	
	public static int convertRomanToDecimal(String roman){
		roman = roman.toUpperCase();
		int curr=0;
	    int prev = 0;
	    for(int i = roman.length()-1; i>=0 ; i--)
	    {
	            int temp = ConversionTool.romanToDecimalDictionary.get(roman.charAt(i));
	            if(temp < prev)
	                curr-=temp;
	            else
	                curr+=temp;
	            prev = temp;
	    }
	    return curr;
	}
	
	public static boolean isValidRoman(String roman){
		if(roman.isEmpty() || roman == null){
			return false;
		}
		roman = roman.toUpperCase();
		if(roman.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})")){
			return true;
		}
		return false;
	}
}
