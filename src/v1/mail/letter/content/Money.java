package v1.mail.letter.content;

import v1.mail.letter.Content;

/**
 * An amount of Money we can send in a Letter.
 */
public class Money implements Content {

	protected double amount;
	
	public Money(double amount){
		this.amount = amount;
	}
	
	public String getDescription() {
		return "a money content ("+this.getAmount()+")";
	}
	
	public double getAmount(){
		return this.amount;
	}
}
