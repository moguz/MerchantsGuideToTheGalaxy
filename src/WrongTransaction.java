/**
 * WrongTransaction : Any query apart from these 4 categories and ends with a '?' (question mark).
 * This class sets the appropriate result to the query.
 * @author Mert
 *
 */
public class WrongTransaction extends QuestionTransaction implements Transaction {

	public WrongTransaction(String line) {
		super(line);
	}

	@Override
	public void processTransaction() {
		result = "I have no idea what you are talking about";
	}

}
