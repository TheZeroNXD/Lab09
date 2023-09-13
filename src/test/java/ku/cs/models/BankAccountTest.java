package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        // Initialize a new BankAccount instance before each test
        account = new BankAccount("123456", "John Doe", 1000.0);
    }

    @Test
    @DisplayName("Test deposit method with a positive amount")
    public void testDepositPositiveAmount() {
        assertTrue(account.deposit(500.0));
        assertEquals(1500.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("Test deposit method with a negative amount")
    public void testDepositNegativeAmount() {
        assertFalse(account.deposit(-100.0));
        assertEquals(1000.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("Test withdraw method with a valid amount")
    public void testWithdrawValidAmount() {
        assertTrue(account.withdraw(500.0));
        assertEquals(500.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("Test withdraw method with an amount exceeding the balance")
    public void testWithdrawExceedingBalance() {
        assertFalse(account.withdraw(1500.0));
        assertEquals(1000.0, account.getBalance(), 0.01);
    }

    @Test
    @DisplayName("Test setAccountName method")
    public void testSetAccountName() {
        account.setAccountName("Jane Doe");
        assertEquals("Jane Doe", account.getAccountName());
    }
}
