package v3.mail.letter.decoratedletters;

import v3.mail.letter.Content;
import v3.mail.letter.DecoratedLetter;
import v3.mail.letter.Letter;

/**
 *
 */
public class UrgentLetter extends DecoratedLetter{

	public UrgentLetter(Letter<Content> letter) throws IllegalArgumentException{
		super(letter);
		if(this.getContent().getType() == "an urgent letter")
				throw new IllegalArgumentException();
	}

	public double getCost() {
		return (this.getContent().getCost() * 2);
	}

	public void action() {
		this.getContent().action();
	}

	public String getType() {
		return "an urgent letter";
	}

}
