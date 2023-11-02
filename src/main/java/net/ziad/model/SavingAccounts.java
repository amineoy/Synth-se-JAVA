package net.ziad.model;

public class SavingAccounts extends BanqueAccount{
private double interestRate;

    public SavingAccounts() {
        super();
        this.interestRate = interestRate;
    }

    public SavingAccounts(String balance, double currency,  double interestRate) {
        super( balance, currency);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    @Override
    public String getType() {
        return "SAVING-Account";
    }

    @Override
    public String toString() {
        return "SavingAccounts{" +
                "interestRate=" + interestRate + super.toString()+
                '}';
    }
}
