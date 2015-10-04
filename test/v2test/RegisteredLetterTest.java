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
import v2.mail.letter.concreteletters.AknowledgmentLetter;
import v2.mail.letter.concreteletters.SimpleLetter;
import v2.mail.letter.content.Text;
import v2.mail.letter.decoratedletters.RegisteredLetter;

public class RegisteredLetterTest extends DecoratedLetterTest {

	Inhabitant citizen;
	Inhabitant citizen2;
	BankAccount bank;
	City city;
	Letter<Content> decoLetter;
	int letterSend = 0;

	@Before
	public void setUp(){
		bank = new BankAccount();
		citizen = new Inhab("Testeur", bank);
		citizen2 = new Inhab("Testeur2", bank);
		city = new City("TestCity");
		city.addInhabitant(citizen);
		city.addInhabitant(citizen2);
		letter = this.create();
		decoLetter = this.createDeco();
	}

	@After
	public void tearDown(){
		bank = null;
		citizen = null;
		citizen2 = null;
		city = null;
		decoLetter = null;
	}

	public Letter<Content> create(){
		return new SimpleLetter(citizen, citizen2, new Text());
	}
	
	public DecoratedLetter createDeco(){
		return new RegisteredLetter(letter);
	}
	
	class Inhab extends Inhabitant{

		public Inhab(String name, BankAccount account) {
			super(name, account);
		}
		
		public void sendLetter(Letter<Content> letter){
			super.sendLetter(letter);
			letterSend++;
		}
		
	}
	
	@Test
	public void testAction() {
		assertEquals("Letter send ?",0 , letterSend);
		decoLetter.action();
		assertEquals("Letter not send ?",1 , letterSend);
	}

	@Test
	public void testGetCost() {
		assertEquals("Not a good cost ?", decoLetter.getCost(), 16, 0.0001);
	}

	@Test
	public void testGetType() {
		assertEquals("Not the good type ?", decoLetter.getType(), "a registered letter");
	}

	@Test (expected = IllegalArgumentException.class)
	public void testWrongTypeOfLetter(){
		@SuppressWarnings("unused")
		RegisteredLetter test = new RegisteredLetter(new AknowledgmentLetter(new RegisteredLetter(letter)));
	}

}
