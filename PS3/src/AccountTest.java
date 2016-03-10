import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {
	public static Account a;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		a = new Account(1122, 20000);
		a.setAnnualInterestRate(.045);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		a = new Account(1122, 20000);
		a.setAnnualInterestRate(.045);
		a.accountInfo();
		a = null;
	}

	@Before
	public void setUp() throws Exception {
		a = new Account(1122, 20000);
		a.setAnnualInterestRate(.045);
	}

	@After
	public void tearDown() throws Exception {
		a = new Account(1122, 20000);
		a.setAnnualInterestRate(.045);
	}

	@Test
	public void testDeposit() {
		a.deposit(3000);
		assertTrue("New Balance: 23000", a.getBalance() == 23000);
		assertFalse("You are short $2000", a.getBalance() == 25000);
	}

	@Test(expected = InsufficientFundsException.class)
	public void testWithdrawl() throws InsufficientFundsException {
		a.withdraw(2500);
		assertTrue("Balance: 17500 ", a.getBalance() == 17500);
		assertFalse("Insufficient Funds ", a.getBalance() == 18000);
		a.withdraw(21000); // Tests the Exception
	}
}
