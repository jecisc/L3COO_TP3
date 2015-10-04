package v3test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v3.mail.city.City;
import v3.mail.city.inhabitant.Inhabitant;
import v3.mail.city.inhabitant.bankaccount.BankAccount;
import v3.mail.letter.Content;
import v3.mail.letter.DecoratedLetter;
import v3.mail.letter.Letter;
import v3.mail.letter.concreteletters.SimpleLetter;
import v3.mail.letter.content.Text;

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
		System.out.println(letter+" : " + letter.getContent().getDescription());
		DecoratedLetter deco = this.createDeco();
		System.out.println(deco.getContent());
		assertEquals("Not the good Letter ?", deco.getContent(), letter);
	}

}
