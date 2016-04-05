
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
