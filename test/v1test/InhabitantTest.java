package v1test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v1.mail.city.City;
import v1.mail.city.inhabitant.Inhabitant;
import v1.mail.city.inhabitant.bankaccount.BankAccount;
import v1.mail.letter.content.Text;

public class InhabitantTest {

	Inhabitant citizen, citizen2;
	BankAccount bank;
	MockLetter letter;
	
	@Before
	public void setUp(){
		bank = new BankAccount(5000);
		citizen = new Inhabitant("Testeur", bank);
		citizen2 = new Inhabitant("Testeur2", bank);
		letter = new MockLetter(citizen, citizen2, new Text());
	}

	@After
	public void tearDown(){
		bank = null;
		citizen = null;
		citizen2= null;
		letter = null;
		
	}

	@Test
	public void testReceiveLetterWithMockLetter(){
		assertFalse("The letter has the action already did ?", letter.getState());
		citizen.receiveLetter(letter);
		assertTrue("The letter did nothing ?", letter.getState());
	}
	
	@Test
	public void testSendLetterAndNameCity(){
		City city = new City("test");
		city.addInhabitant(citizen);
		assertEquals("Not 5000€ on the account ?", citizen.getBankAccount().getMoney(), 5000, 0.0001);
		citizen.sendLetter(letter);
		assertEquals("Not 4999€ on the account ?", citizen.getBankAccount().getMoney(), 4999, 0.0001);
		assertEquals("Not the good name of city ?", citizen.getCity().getName(), "test");
	}

}
