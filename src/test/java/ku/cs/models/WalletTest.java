package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    private Wallet wallet;
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
        bankAccount = new BankAccount("123456789", "John Doe", 1000.0);
    }

    @Test
    @DisplayName("Test addMoneyToWallet with a valid amount")
    public void testAddMoneyToWalletValidAmount() {
        double amountToAdd = 500.0;
        assertTrue(wallet.addMoneyToWallet(bankAccount, amountToAdd));
        assertEquals(500.0, wallet.getBalance(), 0.01); // Ensure balance is updated correctly
    }

    @Test
    @DisplayName("Test addMoneyToWallet with an invalid amount")
    public void testAddMoneyToWalletInvalidAmount() {
        double amountToAdd = -100.0; // Negative amount
        assertFalse(wallet.addMoneyToWallet(bankAccount, amountToAdd));
        assertEquals(0.0, wallet.getBalance(), 0.01); // Ensure balance remains unchanged
    }

    @Test
    @DisplayName("Test addMoneyToWallet with insufficient balance in BankAccount")
    public void testAddMoneyToWalletInsufficientBalance() {
        double amountToAdd = 1500.0; // More than the BankAccount balance
        assertFalse(wallet.addMoneyToWallet(bankAccount, amountToAdd));
        assertEquals(0.0, wallet.getBalance(), 0.01); // Ensure balance remains unchanged
    }

    @Test
    @DisplayName("Test takeMoneyOutOfWallet with a valid amount")
    public void testTakeMoneyOutOfWalletValidAmount() {
        wallet.addMoneyToWallet(bankAccount, 500.0);
        double amountToTake = 300.0;
        assertTrue(wallet.takeMoneyOutOfWallet(amountToTake));
        assertEquals(200.0, wallet.getBalance(), 0.01); // Ensure balance is updated correctly
    }

//    @Test
//    @DisplayName("Test takeMoneyOutOfWallet with an invalid amount")
//    public void testTakeMoneyOutOfWalletInvalidAmount() {
//        double initialBalance = wallet.getBalance();
//        double amountToTake = -50.0; // Negative amount
//        assertFalse(wallet.takeMoneyOutOfWallet(amountToTake));
//        assertEquals(initialBalance, wallet.getBalance(), 0.01); // Ensure balance remains unchanged
//    }

    @Test
    @DisplayName("Test takeMoneyOutOfWallet with insufficient balance")
    public void testTakeMoneyOutOfWalletInsufficientBalance() {
        double amountToTake = 500.0; // More than the Wallet balance
        assertFalse(wallet.takeMoneyOutOfWallet(amountToTake));
        assertEquals(0.0, wallet.getBalance(), 0.01); // Ensure balance remains unchanged
    }
}
