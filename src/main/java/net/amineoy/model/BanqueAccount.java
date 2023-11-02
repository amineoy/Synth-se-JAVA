package net.amineoy.model;

import java.util.Objects;
import java.util.UUID;

public abstract class BanqueAccount {
private String accountId;
private double balance;
private String currency;
private AccountStatusEnam status;



    public BanqueAccount(String currency,double initialBalance) {

        this.currency = currency;
        this.balance = initialBalance;
    }

    public BanqueAccount() {
        this.accountId = UUID.randomUUID().toString();

        this.status = AccountStatusEnam.CREATED;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatusEnam getStatus() {
        return status;
    }

    public void setStatus(AccountStatusEnam status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BanqueAccount{" +
                " accountId ='" + accountId +
                ", balance ='" + balance +
                ", currency ='" + currency +
                ", status ='" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BanqueAccount))
            return false;
        BanqueAccount that = (BanqueAccount) o;
        return accountId.equals(that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, balance, currency, status);
    }

    public abstract String getType();

}
