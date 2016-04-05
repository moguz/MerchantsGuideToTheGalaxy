
public class WrongTransaction extends QuestionTransaction implements Transaction {

	public WrongTransaction(String line) {
		super(line);
	}

	@Override
	public void processTransaction() {
		result = "I have no idea what you are talking about";
	}

}
