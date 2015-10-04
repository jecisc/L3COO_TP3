package v3.mail.city.inhabitant;

import v3.mail.city.City;
import v3.mail.city.inhabitant.bankaccount.BankAccount;
import v3.mail.letter.Content;
import v3.mail.letter.Letter;

/**
 * An Inhabitant of a City {@link v3.mail.city}
 */
public class Inhabitant {

	/**
	 * name of the <code>Inhabitant</code>.
	 */
	protected final String name;
	
	/**
	 * The actual city of an <code>Inhabitant</code>.
	 */
	protected City city; //Not final because an Inhabitant will maybe change of city later.
	
	/**
	 * The <code>BankAccount</code> of the Inhabitant. 
	 */
	protected BankAccount bank;
	
	/**
	 * Constructor of an <code>Inhabitant</code>.
	 * @param name the name of the Inhabitant.
	 * @param account the <code>BankAccount</code> of the <code>Inhabitant</code>.
	 */
	public Inhabitant(String name, BankAccount account){
		this.name = name; 
		this.bank = account;
		//The city is initialize in the "addInhabitant" of City.
	}

	/**
	 * Return the city of an <code>Inhabitant</code>
	 * @return the city of the Inhabitant.
	 */
	public City getCity() {
		return city;
	}

	/**
	 * Allow to change the city of the <code>Inhabitant</code>.
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * Return the name of the citizen.
	 * @return the name of the Inhabitant.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the Bank Account of the <code>Inhabitant</code>.
	 * @return the bank account 
	 */
	public BankAccount getBankAccount() {
		return bank;
	}

	/**
	 * The inhabitant receive the letter and execute the action of the letter.
	 * @param letter : the letter we receive.
	 */
	public void receiveLetter(Letter<Content> letter) {
		System.out.println("<- inhabitant-"+letter.getReceiver().getName()+" receives "+letter.getDescription()+" from inhabitant-"+letter.getSender().getName());
		letter.action();
	}

	/**
	 * SendLetter will send a <code>Letter</code> and debit our account for the amount of money the letter cost.
	 * @param letter the letter we send.
	 */
	public void sendLetter(Letter<Content> letter) {
		System.out.println("-> inhabitant-"+letter.getSender().getName()+" mails "+letter.getDescription()+" to inhabitant-" + letter.getReceiver().getName() +" for a cost of "+ letter.getCost() +" euros");
		letter.getSender().getBankAccount().debit(letter.getCost());
		System.out.println("	- "+letter.getCost()+" euros are debited from inhabitant-"+letter.getSender().getName()+" account whose balance is now "+letter.getSender().getBankAccount().getMoney()+" euros");
		this.city.sendLetter(letter);
	}
	
	//We don't have a set name because a name is final.
	//We'll need a setBankAccount if we choose to let the citizen change of bank account. Now we don't need it.
}
