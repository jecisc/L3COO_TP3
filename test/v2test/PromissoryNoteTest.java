package v2test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v2.mail.city.City;
import v2.mail.city.inhabitant.Inhabitant;
import v2.mail.city.inhabitant.bankaccount.BankAccount;
import v2.mail.letter.Content;
import v2.mail.letter.Letter;
import v2.mail.letter.concreteletters.PromissoryNote;
import v2.mail.letter.content.Money;

public class PromissoryNoteTest extends BasicLetterTest {
	
	Inhabitant citizen;
	Inhabitant citizen2;
	BankAccount bank, bank2;
	City city;
	Letter<Content> letter;
	
	@Before
	public void setUp(){
		bank = new BankAccount(5000);
		bank2 = new BankAccount(5000);
		citizen = new Inhabitant("Testeur", bank);
		citizen2 = new Inhabitant("Testeur2", bank2);
		city = new City("TestCity");
		city.addInhabitant(citizen);
		city.addInhabitant(citizen2);
		letter = this.create();
	}

	@After
	public void tearDown(){
		bank = null;
		citizen = null;
		citizen2 = null;
		city = null;
	}
	
	public Letter<Content> create() {
		return new PromissoryNote(citizen, citizen2, new Money(100));
	}

	@Test
	public void testAction() {
		letter.action();
		assertEquals("Not the good BankAccount for the sender ?", letter.getSender().getBankAccount().getMoney(), 4900, 0.0001);
		assertEquals("Not the good BankAccount for the receiver ? We expect : 5000 + 100 - 1 (for thanks letter) = 5099", letter.getReceiver().getBankAccount().getMoney(), 5099, 0.0001);
	}

	@Test
	public void testGetCost() {
		assertEquals("Not the good cost ?", letter.getCost(), 2, 0.0001 );
	}

	@Test
	public void testGetType() {
		assertEquals("Not the good type ?", letter.getType(), "a promissory note letter");
	}


}
