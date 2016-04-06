/**
 * Main class of the application. Please set the correct filename as input file.
 * @author Mert
 *
 */
public class MerchantsMain {

	public static void main(String[] args) {
		String filename = "input.txt";
		ConversionTool conversionTool = new ConversionTool(filename);
		conversionTool.convert();
	}

}
