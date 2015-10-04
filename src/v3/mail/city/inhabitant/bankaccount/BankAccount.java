package v3.mail.city.inhabitant.bankaccount;

/**
 * A BankAccount allow to manage the money of an {@link v3.mail.city.inhabitant.Inhabitant}.
 */
public class BankAccount {

	/**
	 * The amount of money on the <code>BankAccount</code>.
	 */
	protected double money;
	
	/**
	 *  Constructor of a BankAccount. Initialize the <code>BankAccount</code> with a sold of 0.
	 */
	public BankAccount() {
		this.money = 0;
	}
	
	/**
	 *  Constructor of a BankAccount. Initialize the <code>BankAccount</code> with a sold of <code>BasicMoney</code>.
	 *  @param basicMoney the money we have at the begining.
	 */
	public BankAccount(double basicMoney) {
		this.money = basicMoney;
	}
	
	/**
	 * Allow to get the amount of money on the BankAccount.
	 * @return the money on the bank account.
	 */
	public double getMoney() { //Not useful for the project but used on the test.
		return money;
	}

	/**
	 * credit(amountCredit) add <code>amountCredit</code> to the total of money in the <code>BankAccount</code>
	 * @param amountCredit the amount of money we want to add.
	 * @exception IllegalArgumentException if the amount of money isn't positive.
	 */
	public void credit(double amountCredit)throws IllegalArgumentException{
		if(amountCredit < 0)
			throw new IllegalArgumentException();
		this.money+=amountCredit;
	}
	
	/**
	 * debit(amountDebit) remove <code>amountDebit</code> to the total of money in the <code>BankAccount</code>
	 * @param amountDebit the amount of money we want to remove.
	 * @exception IllegalArgumentException if the amount of money isn't positive.
	 */
	public void debit(double amountDebit){
		if(amountDebit < 0)
			throw new IllegalArgumentException();
		//Think about throw an exception if you don't allow the inhabitant to have an overdraft ! Here we allow it. 
		this.money= this.money - amountDebit;
	}

}
