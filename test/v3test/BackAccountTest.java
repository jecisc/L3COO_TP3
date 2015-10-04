package v3test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import v3.mail.city.inhabitant.bankaccount.BankAccount;

public class BackAccountTest {
	
	BankAccount account;
	
	@Before
	public void setUp(){
		account= new BankAccount();
	}
	
	@After
	public void tearDown(){
		account = null;
	}

	@Test
	public void testCredit() {
		assertEquals("Not 0 at the beginning ?", account.getMoney(),  0, 0.0001);
		account.credit(10);
		assertEquals("Not 10 on the account ?", account.getMoney(), 10, 0.0001);
		account.credit(30);
		assertEquals("Not 40 on the account ?", account.getMoney(), 40, 0.0001);
	}

	@Test
	public void testDebit() {
		account.credit(30);
		assertEquals("Not 30 at the beginning ?", account.getMoney(), 30, 0.0001);
		account.debit(10);
		assertEquals("Not 20 on the account ?", account.getMoney(), 20, 0.0001);
		account.debit(5);
		assertEquals("Not 15 on the account ?", account.getMoney(), 15, 0.0001);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testWrongCredit(){
		account.credit(-10);
	}
	
	@Test (expected= IllegalArgumentException.class)
	public void testWrongDebit(){
		account.debit(-10);
	}
	
	@Test
	public void testConstructorWithAmountInside(){
		BankAccount bank2 = new BankAccount(20);
		assertEquals("Not the good account ?", bank2.getMoney(), 20, 0.0001);
	}

}
