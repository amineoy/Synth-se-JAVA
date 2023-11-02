package net.ziad.busness;

import java.util.List;

import net.ziad.exeception.AccountNotFoundException;
import net.ziad.exeception.BalanceNotSufficientException;
import net.ziad.model.BanqueAccount;

public interface BankAccountService {

    BanqueAccount addBankAccount(BanqueAccount account);
    List<BanqueAccount> getListBank();
    BanqueAccount getBankAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void credit(String accountId,double account) throws BalanceNotSufficientException, AccountNotFoundException;

    void debit(String accountId,double account) throws AccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountSource,String accountDestination,double account) throws AccountNotFoundException,BalanceNotSufficientException;

    List<BanqueAccount> getSavaingAccounts();
    List<BanqueAccount>  getCurrenceAccounts();
    double getTotalBalance();
    List<BanqueAccount>searchAccounts(Condition<BanqueAccount> condition);


}
