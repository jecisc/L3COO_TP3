package v1.mail.letter.concreteletters;

import v1.mail.city.inhabitant.Inhabitant;
import v1.mail.letter.BasicLetter;
import v1.mail.letter.content.Money;

/**
 * This letter contains an amount of money from the sender's account. This money will go on the receiver's account. The receiver will send a ThanksLetter.
 */
public class PromissoryNote extends BasicLetter<Money>{
	
	/**
	 * Letter constructor
	 * 
	 * Construct a letter, with an sender, a receiver, and an amount of money.
	 * 
	 * @param sender The <code>Inhabitant</code> who sends the <code>Letter</code>(this)
	 * @param receiver The <code>Inhabitant</code> who receives the <code>Letter</code>(this)
	 * @param money The <code>Money</code> of the <code>Letter</code>(this)
	 */
	public PromissoryNote(Inhabitant sender, Inhabitant receiver, Money money){
		super(sender, receiver, money);
	}
	
	/**
	 * A PromissoryNote will cost 1+1% of the amount send to the sender and will credit the amount to the receiver. The receiver will send a ThnksLetter the next day.
	 */
	public void action() {
		this.getSender().getBankAccount().debit(this.content.getAmount());
		this.getReceiver().getBankAccount().credit(this.content.getAmount());
		System.out.println("	- "+ this.content.getAmount()+" euros are debited from inhabitant-"+this.getSender().getName()+" account whose balance is now " + this.getSender().getBankAccount().getMoney()+" euros");
		System.out.println("	+ inhabitant-"+ this.receiver.getName()+" account is credited with "+ this.content.getAmount()+" euros; its balance is now "+this.receiver.getBankAccount().getMoney()+" euros");
		this.getReceiver().sendLetter(new ThanksLetter(this));
	}
	
	public double getCost() {
		return (BasicLetter.BASICCOST + (this.content.getAmount()/100));
	}
	
	public String getType() {
		return "a promissory note letter";
	}

}
