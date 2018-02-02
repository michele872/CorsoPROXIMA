package testJSP;

public class Topic {
	
	
	private String question;			//mappa la singola riga della tab
	private String[] availableReplies;
	private String[] rightReplies;
	
	public Topic (String question, String[] avalaibleReplies, String[] rightReplies) {
		this.question = question;
		this.availableReplies = avalaibleReplies;
		this.rightReplies = rightReplies;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getAvailableReplies() {
		return availableReplies;
	}

	public void setAvailableReplies(String[] availableReplies) {
		this.availableReplies = availableReplies;
	}

	public String[] getRightReplies() {
		return rightReplies;
	}

	public void setRightReplies(String[] rightReplies) {
		this.rightReplies = rightReplies;
	}

	

}
