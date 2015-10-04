package v2.mail.letter.decoratedletters;

import v2.mail.letter.Content;
import v2.mail.letter.DecoratedLetter;
import v2.mail.letter.Letter;
import v2.mail.letter.concreteletters.AknowledgmentLetter;

/**
 * A registeredLetter is a Letter more expensive. When the receiver will get it he'll send an aknowledgment of receipt.
 */
public class RegisteredLetter extends DecoratedLetter implements Letter<Content> {

	protected static final double OVERCOSTREGISTERED = 15;
	
	/**
	 * Contructor of a RegisteredLetter.
	 * @param letter the letter we want to send as a registeredLetter.
	 * @throws IllegalArgumentException if the content which must be registred is not a good type of content.
	 */
	public RegisteredLetter(Letter<Content> letter) throws IllegalArgumentException {
		super(letter);
		
		if (letter.getType() != "a simple letter" && letter.getType() != "a promissory note letter")
			throw new IllegalArgumentException();
	}

	public double getCost() {
		return this.getContent().getCost() + RegisteredLetter.OVERCOSTREGISTERED;
	}

	public void action() {
		this.getContent().action();
		this.getReceiver().sendLetter(new AknowledgmentLetter(this));
	}

	public String getType() {
		return "a registered letter";
	}

}
