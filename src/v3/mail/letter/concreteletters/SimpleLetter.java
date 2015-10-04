package v3.mail.letter.concreteletters;

import v3.mail.city.inhabitant.Inhabitant;
import v3.mail.letter.BasicLetter;
import v3.mail.letter.content.Text;

/**
 *	A simpleLetter is a Letter which contains a Text.
 */
public class SimpleLetter extends BasicLetter<Text>{

	/**
	 * Letter constructor
	 * 
	 * Construct a letter, with an sender, a receiver, and a text
	 * 
	 * @param sender The <code>Inhabitant</code> who sends the <code>Letter</code>(this)
	 * @param receiver The <code>Inhabitant</code> who receives the <code>Letter</code>(this)
	 * @param text The <code>Text</code> of the <code>Letter</code>(this)
	 */
	public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text text){
		super(sender, receiver, text);
	}

	/**
	 * A simpleLetter's action.
	 */
	public void action() {
	}

	public double getCost() {
		return BasicLetter.BASICCOST;
	}


	public String getType() {
		return "a simple letter";
	}

}
