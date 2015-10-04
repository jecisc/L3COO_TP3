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
import v3.mail.letter.concreteletters.AknowledgmentLetter;
import v3.mail.letter.concreteletters.SimpleLetter;
import v3.mail.letter.content.Text;
import v3.mail.letter.decoratedletters.RegisteredLetter;

public class AknolegmentLetterTest extends BasicLetterTest {
	
	Inhabitant citizen;
	Inhabitant citizen2;
	BankAccount bank;
	City city;
	Letter<Content> letter, decoLetter;
	
	@Before
	public void setUp(){
		bank = new BankAccount();
		citizen = new Inhabitant("Testeur", bank);
		citizen2 = new Inhabitant("Testeur2", bank);
		city = new City("TestCity");
		city.addInhabitant(citizen);
		city.addInhabitant(citizen2);
		letter = new SimpleLetter(citizen, citizen2, new Text());
		decoLetter = this.create();
	}

	@After
	public void tearDown(){
		bank = null;
		citizen = null;
		citizen2 = null;
		city = null;
		letter = null;
		decoLetter = null;
	}
	
	public Letter<Content> create(){
		return new AknowledgmentLetter(new RegisteredLetter(letter));
	}

	@Test
	public void testGetType() {
		assertEquals("Not the good type ?", decoLetter.getType(), "an aknowledgment of receipt which is a simple letter");
	}

	@Test
	public void testGetCost() {
		assertEquals("Not a basic cost ?", decoLetter.getCost(), 1, 0.0001);
	}
}
