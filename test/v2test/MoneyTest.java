package v2test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v2.mail.letter.content.Money;

public class MoneyTest {

	Money money;
	
	@Before
	public void setUp(){
		money = new Money(100);
	}

	@After
	public void tearDown(){
		money = null;
	}

	@Test
	public void testGetAmount() {
		assertEquals("Not the good amount ?", money.getAmount(), 100, 0.0001);
	}

}
