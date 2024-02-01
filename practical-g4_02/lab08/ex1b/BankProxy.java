public class BankProxy extends BankAccountImpl {

    public BankProxy(String bank, double initialDeposit) {
        super(bank, initialDeposit);
    }

    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return super.withdraw(amount);
        } else {
            throw new SecurityException("Access denied - withdraw");
        }
    }

    @Override
    public double balance() {
        if (Company.user == User.OWNER)
            return super.balance();
        else
            throw new SecurityException("Access denied - balance");
    }

}
