package v2.mail.letter;


/**
 * A DecoratedLetter allow to use the design pattern Decarator on some letters. 
 */
public abstract class DecoratedLetter extends BasicLetter<Letter<Content>> implements Letter<Content>{
	
	protected final Letter<Content> letter;
	
	public DecoratedLetter(Letter<Content> letter){
		super(letter.getSender(), letter.getReceiver(), letter);
		this.letter = letter;
	}
	
	public abstract double getCost();
	
	public abstract void action();
	
	public abstract String getType();
	
	public Letter<Content> getContent(){
		return this.content;
	}
}
