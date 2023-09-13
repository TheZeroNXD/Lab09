package ku.cs.models;

public class CreditAccount extends BankAccount{
    private double cashBack;
    public CreditAccount(String accountNumber, String accountName, double balance){
        super(accountNumber, accountName, balance);
        this.cashBack = 0;
    }
    @Override
    public String toString() {
        return "CreditAccount{" +
                "cashBack=" + cashBack +
                "} " + super.toString();
    }
    public boolean transferCashback(double amount){
        if (amount > 0 && cashBack >= amount && super.deposit(amount)){
            cashBack -= amount;
            return true;
        }
        return false;
    }
}