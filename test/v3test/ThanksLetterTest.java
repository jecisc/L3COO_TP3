package v3test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v3.mail.city.City;
import v3.mail.city.inhabitant.Inhabitant;
import v3.mail.city.inhabitant.bankaccount.BankAccount;
import v3.mail.letter.Content;
import v3.mail.letter.Letter;
import v3.mail.letter.concreteletters.PromissoryNote;
import v3.mail.letter.concreteletters.ThanksLetter;
import v3.mail.letter.content.Money;

public class ThanksLetterTest extends SimpleLetterTest {

	Inhabitant citizen;
	Inhabitant citizen2;
	BankAccount bank;
	City city;
	Letter<Content> letter;
	
	@Before
	public void setUp(){
		bank = new BankAccount();
		citizen = new Inhabitant("Testeur", bank);
		citizen2 = new Inhabitant("Testeur2", bank);
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
	
	public Letter<Content> create(){
		return new ThanksLetter(new PromissoryNote(citizen, citizen2, new Money(100)));
	}

	@Test
	public void testGetType() {
		assertEquals("Not the good type ?", letter.getType(), "a thanks letter which is a simple letter");
	}

	@Test
	public void testGetCost() {
		assertEquals("Not a basic cost ?", letter.getCost(), 1, 0.0001);
	}
}
