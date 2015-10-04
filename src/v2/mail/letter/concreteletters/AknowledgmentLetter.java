package v2.mail.letter.concreteletters;

import v2.mail.letter.content.Text;
import v2.mail.letter.decoratedletters.RegisteredLetter;

/**
 * An AknoledgmentLetter is a simple letter which aknoledge the fact than a receiver get his letter.
 */
public class AknowledgmentLetter extends SimpleLetter{

	public AknowledgmentLetter(RegisteredLetter letter) {
		super(letter.getReceiver(), letter.getSender(), new Text ("aknowledgment of receipt for a "+letter.getDescription()));
	}

	public String getType() {
		return "an aknowledgment of receipt which is a simple letter";
	}
}
