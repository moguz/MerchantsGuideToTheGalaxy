/**
 * Class for the transactions which need to be answered. This class is the superclass of
 * TranslationQuestionTransaction, PriceQuestionTransaction and WrongTransaction.
 * @author Mert
 *
 */
public class QuestionTransaction {
	
	protected String line;
	protected String result;
	
	public QuestionTransaction(String line){
		this.line = line;
		result = "";
	}
	
	public String getResult(){
		return result;
	}
	
	public void setResult(String result){
		this.result = result;
	}
	
}
