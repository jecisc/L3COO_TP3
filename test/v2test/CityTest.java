package v2test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v2.mail.city.City;
import v2.mail.city.inhabitant.Inhabitant;
import v2.mail.city.inhabitant.bankaccount.BankAccount;
import v2.mail.letter.Content;
import v2.mail.letter.Letter;
import v2.mail.letter.concreteletters.SimpleLetter;
import v2.mail.letter.content.Text;

public class CityTest {

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
		letter = new SimpleLetter(citizen, citizen2, new Text());
	}

	@After
	public void tearDown(){
		bank = null;
		citizen = null;
		citizen2 = null;
		city = null;
		letter = null;
	}

	@Test (expected= IndexOutOfBoundsException.class)
	public void testCityWithoutInhabitantAndName() {
		assertEquals("The name is not good ?", city.getName(), "TestCity");
		assertEquals("The list of inhabitant is not null ?", city.getListInhabitant().get(0), null);
	}
	
	@Test (expected= IndexOutOfBoundsException.class)
	public void testCityWithOneInhabitant() {
		city.addInhabitant(citizen);
		assertEquals("The list of inhabitant is null ?", city.getListInhabitant().get(0), citizen);
		assertEquals("The list of inhabitant have more than 1 inhabitant ?", city.getListInhabitant().get(1), null);
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void testCityWithTwoInhabitant() {
		city.addInhabitant(citizen);
		city.addInhabitant(citizen2);
		assertEquals("The list of inhabitant is null?", city.getListInhabitant().get(0), citizen);
		assertEquals("The list of inhabitant have no more than 1 inhabitant ?", city.getListInhabitant().get(1), citizen2);
		assertEquals("The list of inhabitant have more than 2 inhabitant ?", city.getListInhabitant().get(2), null);
	}
	
	@Test
	public void testSendLetter(){
		City city2 = new City("Test", citizen, citizen2);
		assertTrue("The postBox is not empty ?", city2.getPostBox().isEmpty());
		city2.sendLetter(letter);
		assertTrue("The postBox is empty ?", city2.getPostBox().contains(letter));
		
	}
	
	@Test
	public void testDistributeLetterCleanThePostBox(){
		city.sendLetter(letter);
		assertTrue("No letter at the beginning ?", city.getPostBox().contains(letter));
		city.distributeLetters();
		assertFalse("We have a letter after ?", city.getPostBox().contains(letter));
	}

}
