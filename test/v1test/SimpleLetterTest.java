package v1test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v1.mail.city.City;
import v1.mail.city.inhabitant.Inhabitant;
import v1.mail.city.inhabitant.bankaccount.BankAccount;
import v1.mail.letter.Content;
import v1.mail.letter.Letter;
import v1.mail.letter.concreteletters.SimpleLetter;
import v1.mail.letter.content.Text;

public class SimpleLetterTest extends BasicLetterTest{
	
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
		return new SimpleLetter(citizen, citizen2, new Text());
	}

	@Test
	public void testGetCost() {
		assertEquals("Not a basic cost ?", letter.getCost(), 1, 0.0001);
	}

	@Test
	public void testGetType() {
		assertEquals("Not the good type ?", letter.getType(), "a simple letter");
	}

}
