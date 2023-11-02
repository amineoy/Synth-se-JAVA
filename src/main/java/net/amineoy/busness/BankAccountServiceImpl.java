package net.amineoy.busness;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import net.amineoy.exeception.AccountNotFoundException;
import net.amineoy.exeception.BalanceNotSufficientException;
import net.amineoy.model.AccountStatusEnam;
import net.amineoy.model.BanqueAccount;
import net.amineoy.model.CurrentAcount;
import net.amineoy.model.SavingAccounts;

public class BankAccountServiceImpl implements BankAccountService{
    List<BanqueAccount>listAccount=new ArrayList<>();
    @Override
    public BanqueAccount addBankAccount(BanqueAccount account) {
        listAccount.add(account);
        return account;
    }

    @Override
    public List<BanqueAccount> getListBank() {

        return listAccount;
    }

    @Override
    public BanqueAccount getBankAccountById(String id) throws AccountNotFoundException {
    return listAccount
            .stream()
            .filter(acc -> id.equals(acc.getAccountId()))
            .findFirst()
            .orElseThrow(()-> new AccountNotFoundException(String.format("BankAccount %s not found",id)));

/*
        for(BanqueAccount cp:listAccount){
            if(cp.getAccountId().equals(id)){
                return cp;
            }
        }throw new Exception("BankAccount not found");*/
    }

    @Override
    public void addRandomData(int size) {  //permet de generee des données aleatoire
        AccountStatusEnam[] values=AccountStatusEnam.values();
        Random random=new Random();

        for(int i=0;i<size;i++){
            BanqueAccount banqueAccount;
            if(Math.random()>0.5){
                //Expression ternaire   test if
                 banqueAccount=new CurrentAcount(Math.random()>0.5?"MAD":"USD",Math.random()*1000000,Math.random()*5000);
                 banqueAccount.setStatus(values[random.nextInt(values.length)]);
            } else {
               banqueAccount=new SavingAccounts(Math.random()>0.5?"MAD":"USD",Math.random()*1000000,3+Math.random()*7);
               banqueAccount.setStatus(values[random.nextInt(values.length)]);
            }
            listAccount.add(banqueAccount);
    }}

    @Override
    public void credit(String accountId, double amount) throws AccountNotFoundException {
        BanqueAccount banqueAccount=getBankAccountById(accountId);
        banqueAccount.setBalance(banqueAccount.getBalance()+amount);

    }

    @Override
    public void debit(String accountId, double amount) throws AccountNotFoundException,BalanceNotSufficientException {
        BanqueAccount banqueAccount=getBankAccountById(accountId);
        if(amount>banqueAccount.getBalance())throw new BalanceNotSufficientException("not suffisant");
        banqueAccount.setBalance(banqueAccount.getBalance()-amount);

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException,BalanceNotSufficientException {
        debit(accountSource,amount);
        credit(accountDestination,amount);
    }

    @Override
    public List<BanqueAccount> getSavaingAccounts() {
        //declarative approche
        List<BanqueAccount> collect = listAccount.stream()
                .filter(acc -> acc instanceof SavingAccounts)
                .collect(Collectors.toList());
        return collect;
        //Imperative approche
      /* List<BanqueAccount> result=new ArrayList<>();
       for(BanqueAccount banque:listAccount){
         if (banque.instanceof SavingAccounts){
             ((SavingAccounts) banque).getType();
             result.add(banque);
         }
       }
        return result;*/
    }

    @Override
    public List<BanqueAccount> getCurrenceAccounts() {
        List<BanqueAccount> collect = listAccount.stream()
                .filter(acc -> acc.getType().equals("Current-Account"))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public double getTotalBalance() {
       /*double total=0;
        for(BanqueAccount acc:listAccount){
            total=total+acc.getBalance();
        }
        return total;*/

       return listAccount.stream()
                .map(account -> account.getBalance())
                .reduce(0.0,(a,v)->a+v);
    }

    @Override
    public List<BanqueAccount> searchAccounts(Condition<BanqueAccount> condition) {
        List<BanqueAccount>result=new ArrayList<>();
        for(BanqueAccount acc:listAccount){
            if (condition.test(acc)){
                result.add(acc);
            }
        }
  return result;

    }
}
