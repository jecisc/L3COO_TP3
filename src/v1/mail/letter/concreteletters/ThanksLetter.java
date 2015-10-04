package v1.mail.letter.concreteletters;

import v1.mail.letter.content.Text;

/**
 * A ThanksLetter that the receiver send after he receive a PromissoryNote.
 */
public class ThanksLetter extends SimpleLetter{

	public ThanksLetter(PromissoryNote letter){
		super(letter.getReceiver(), letter.getSender(), new Text ("thanks for "+letter.getDescription()));
	}
	
	public String getType(){
		return "a thanks letter which is a simple letter";
	}
}
