package v1.mail.letter;

import v1.mail.city.inhabitant.Inhabitant;

/**
 * A abstract class for represent a letter, send by 
 * an <code>Inhabitant</code>(sender) and receive by an other (receiver).
 * A letter has a <code>Content</code>, i.e. any object
 */
public abstract class BasicLetter<C extends Content> implements Letter<Content>{
	
	protected final Inhabitant sender;
	protected final Inhabitant  receiver;
	protected final C content;
	protected final static double BASICCOST = 1;
	
	/**
	 * Letter constructor
	 * 
	 * Construct a letter, with an sender, a receiver, and a content
	 * 
	 * @param sender The <code>Inhabitant</code> who sends the <code>Letter</code>(this)
	 * @param receiver The <code>Inhabitant</code> who receives the <code>Letter</code>(this)
	 * @param content The <code>Content</code> of the <code>Letter</code>(this)
	 */
	public BasicLetter(Inhabitant sender, Inhabitant receiver, C content)
	{
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}
		
	/**
	 * action() method
	 * 
	 * Execute an action associate at the <code>Letter</code>
	 * 
	 */
	public abstract void action();
	
	/**
	 * getCost() method 
	 * 
	 * Return the cost of the <code>Letter</code>(this)
	 * 
	 * @return The cost of the <code>Letter</code>(this)
	 */
	public abstract double getCost();
	
	/**
	 * Return the type of letter. (Example : for a normal letter return <code>a simple letter</code>)
	 * @return the type of letter.
	 */
	public abstract String getType();
	
	/**
	 * Return the total description of a letter with his type and his content.
	 * @return the description of a letter.
	 */
	public String getDescription(){
		return this.getType()+" whose content is " +this.getContent().getDescription();
	}
	
	/**
	 * Return the sender of the letter.
	 * @return the sender of the letter.
	 */
	public Inhabitant getSender() {
		return this.sender;
	}
	
	/**
	 * Return the receiver of the letter.
	 * @return the receiver of the letter.
	 */
	public Inhabitant getReceiver() {
		return this.receiver;
	}
	
	/**
	 * return the content of the letter.
	 * @return the content of the letter.
	 */
	public C getContent() {
		return this.content;
	}
}