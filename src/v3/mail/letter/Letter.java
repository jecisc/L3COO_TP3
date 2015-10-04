package v3.mail.letter;

import v3.mail.city.inhabitant.Inhabitant;

/**
 * An interface for represent a letter.
 *
 * @param <C> The content of the <code>Letter</code>
 */
public interface Letter<C extends Content> extends Content{
		
	/**
	 * action() method
	 * 
	 * Execute an action associate at the <code>Letter</code>
	 * 
	 */
	public void action();
	
	/**
	 * getCost() method 
	 * 
	 * Return the cost of the <code>Letter</code>(this)
	 * 
	 * @return The cost of the <code>Letter</code>(this)
	 */
	public double getCost();
	
	/**
	 * Return the type of letter. (Example : for a normal letter return <code>a simple letter</code>)
	 * @return the type of letter.
	 */
	public String getType();
	
	/**
	 * Return the total description of a letter with his type and his content.
	 * @return the description of a letter.
	 */
	public String getDescription();
	
	/**
	 * Return the sender of the letter.
	 * @return the sender of the letter.
	 */
	public Inhabitant getSender();
	
	/**
	 * Return the receiver of the letter.
	 * @return the receiver of the letter.
	 */
	public Inhabitant getReceiver();
	
	/**
	 * return the content of the letter.
	 * @return the content of the letter.
	 */
	public C getContent();
}
