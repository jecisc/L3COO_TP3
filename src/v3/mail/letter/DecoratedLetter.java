package v3.mail.letter;

import v3.mail.letter.Content;
import v3.mail.letter.Letter;


/**
 * A DecoratedLetter allow to use the design pattern Decarator on some letters. 
 */
public abstract class DecoratedLetter extends BasicLetter<Letter<Content>> implements Letter<Content>{
	
	protected final Letter<Content> letter;
	
	public DecoratedLetter(Letter<Content> letter){
		super(letter.getSender(), letter.getReceiver(), letter);
		this.letter = letter;
	}
	
	public Letter<Content> getContent(){
		return this.content;
	}
	
	public abstract double getCost();
	
	public abstract void action();
	
	public abstract String getType();
}
