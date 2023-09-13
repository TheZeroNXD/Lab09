package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditAccountTest {
    private CreditAccount creditAccount;

    @BeforeEach
    public void setUp() {
        creditAccount = new CreditAccount("12345", "John Doe", 10000);
    }

    @Test
    @DisplayName("Test cashback when deposit")
    public void testDeposit() {
        // Arrange
        CreditAccount c = new CreditAccount("1", "John", 0);

        // Act
        c.deposit(60000);
        double actual = c.getCashBack();
        double expected = 60000.0 * 2 / 100;

        // Assert
        assertEquals(expected, actual, 0.001); // Use a delta to account for potential floating-point precision issues
    }

//    @Test
//    @DisplayName("Test withdraw method with cash back calculation")
//    public void testWithdraw() {
//        assertTrue(creditAccount.withdraw(25000)); // Should withdraw successfully and calculate cash back
//        assertEquals(250.0, creditAccount.getCashBack(), 0.001); // Cash back should be 1% of 25000
//    }

//    @Test
//    @DisplayName("Test transferCashback method")
//    public void testTransferCashback() {
//        creditAccount.deposit(500); // Deposit some amount to have cash back
//        assertTrue(creditAccount.transferCashback(200)); // Should transfer cash back successfully
//        assertEquals(300, creditAccount.getCashBack(), 0.001); // Remaining cash back after transfer
//    }

    @Test
    @DisplayName("Test transferCashback method with invalid amount")
    public void testInvalidTransferCashback() {
        assertFalse(creditAccount.transferCashback(-200)); // Should fail due to negative amount
        assertFalse(creditAccount.transferCashback(20000)); // Should fail due to insufficient cash back
    }
}
