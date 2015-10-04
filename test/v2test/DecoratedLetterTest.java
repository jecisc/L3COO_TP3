package v2test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v2.mail.city.City;
import v2.mail.city.inhabitant.Inhabitant;
import v2.mail.city.inhabitant.bankaccount.BankAccount;
import v2.mail.letter.Content;
import v2.mail.letter.DecoratedLetter;
import v2.mail.letter.Letter;
import v2.mail.letter.concreteletters.SimpleLetter;
import v2.mail.letter.content.Text;

public abstract class DecoratedLetterTest extends BasicLetterTest {

	Inhabitant citizen;
	Inhabitant citizen2;
	BankAccount bank;
	City city;
	Letter<Content> letter;
	
	public abstract DecoratedLetter createDeco();
	
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
		letter = null;
	}
	
	public Letter<Content> create(){
		return new SimpleLetter(citizen, citizen2, new Text());
	}

	@Test
	public void testGetInitialLetter() {
		assertEquals("Not the good Letter ?", this.createDeco().getContent(), letter);
	}

}
