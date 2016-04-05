import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConversionTool {
	private String filename;
	
	private ArrayList<TranslationTransaction> translationTransactionList;
	private ArrayList<PriceTransaction> priceTransactionList;
	private ArrayList<TranslationQuestionTransaction> translationQuestionTransactionList;
	private ArrayList<PriceQuestionTransaction> priceQuestionTransactionList;
	private ArrayList<WrongTransaction> wrongTransactionList;
	private ArrayList<QuestionTransaction> questionTransactionList;
	
	public static HashMap<String, Character> galacticToRomanDictionary;
	public static HashMap<Character, Integer> romanToDecimalDictionary;
	public static HashMap<String, Double> materialPriceDictionary;
	public static int questionOrderId = 0;
	
	public ConversionTool(String filename){
		this.filename = filename;
		translationTransactionList = new ArrayList<TranslationTransaction>();
		priceTransactionList = new ArrayList<PriceTransaction>();
		translationQuestionTransactionList = new ArrayList<TranslationQuestionTransaction>();
		priceQuestionTransactionList = new ArrayList<PriceQuestionTransaction>();
		wrongTransactionList = new ArrayList<WrongTransaction>();
		questionTransactionList = new ArrayList<QuestionTransaction>();
		
		galacticToRomanDictionary = new HashMap<String, Character>();
		romanToDecimalDictionary = new HashMap<Character, Integer>();
		populateRomanToDecimalDictionary();
		materialPriceDictionary = new HashMap<String, Double>();
		
	}
	
		public void convert(){
		readFromInputFile();
		processTransactions();
		outputQuestionResults();
	}

	private void outputQuestionResults() {
			for (QuestionTransaction questionTransaction : questionTransactionList){
				System.out.println(questionTransaction.result);
			}
		}

	private void processTransactions() {
		for (TranslationTransaction translationTransaction : translationTransactionList){
			translationTransaction.processTransaction();
		}
		for (TranslationQuestionTransaction translationQuestionTransaction : translationQuestionTransactionList){
			translationQuestionTransaction.processTransaction();
		}
		for (PriceTransaction priceTransaction : priceTransactionList){
			priceTransaction.processTransaction();
		}
		for (PriceQuestionTransaction priceQuestionTransaction : priceQuestionTransactionList){
			priceQuestionTransaction.processTransaction();
		}
		for (WrongTransaction wrongTransaction : wrongTransactionList){
			wrongTransaction.processTransaction();
		}
	}

	private void readFromInputFile() {
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				classifyTransaction(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void classifyTransaction(String line) {
		if(line.matches("^\\w+ is [I,V,X,L,C,D,M]$")){
			TranslationTransaction newTransaction = new TranslationTransaction(line);
			translationTransactionList.add(newTransaction);
		}
		else if(line.matches("^.+is \\d+ Credits$")){
			PriceTransaction newTransaction = new PriceTransaction(line);
			priceTransactionList.add(newTransaction);
		}
		else if(line.matches("^how much is .+ \\?$")){
			TranslationQuestionTransaction newTransaction = new TranslationQuestionTransaction(line);
			questionTransactionList.add(newTransaction);
			translationQuestionTransactionList.add(newTransaction);
		}
		else if(line.matches("^how many Credits is .+ \\?$")){
			PriceQuestionTransaction newTransaction = new PriceQuestionTransaction(line);
			questionTransactionList.add(newTransaction);
			priceQuestionTransactionList.add(newTransaction);
		}
		else if(line.matches("^.*\\?$")){
			WrongTransaction newTransaction = new WrongTransaction(line);
			questionTransactionList.add(newTransaction);
			wrongTransactionList.add(newTransaction);
		}
	}
	
	private void populateRomanToDecimalDictionary() {
		romanToDecimalDictionary.put('I', 1);
		romanToDecimalDictionary.put('V', 5);
		romanToDecimalDictionary.put('X', 10);
		romanToDecimalDictionary.put('L', 50);
		romanToDecimalDictionary.put('C', 100);
		romanToDecimalDictionary.put('D', 500);
		romanToDecimalDictionary.put('M', 1000);
	}

}
