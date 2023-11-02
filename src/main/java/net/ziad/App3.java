package net.ziad;

import java.util.List;
import java.util.function.Consumer;

import net.ziad.busness.BankAccountService;
import net.ziad.busness.BankAccountServiceImpl;
import net.ziad.exeception.AccountNotFoundException;
import net.ziad.exeception.BalanceNotSufficientException;
import net.ziad.model.BanqueAccount;
import net.ziad.model.CurrentAcount;
import net.ziad.model.SavingAccounts;
import net.ziad.utils.ConvertionJson;

public class App3 {
    public static void main(String[] args){
        BankAccountService bankAccountService=new BankAccountServiceImpl() ;
        bankAccountService.addBankAccount(new CurrentAcount("gss",666,456));
        bankAccountService.addBankAccount(new CurrentAcount("gss",99,666));
        bankAccountService.addBankAccount(new CurrentAcount("gss",00,999));

        BanqueAccount acc3=new CurrentAcount("I",70,890);
        acc3.setAccountId("CC3");
        bankAccountService.addBankAccount(acc3);


        BanqueAccount acc4=new SavingAccounts("Y",702,700);
        acc4.setAccountId("CC4");
        bankAccountService.addBankAccount(acc4);

        BanqueAccount acc5=new CurrentAcount("K",700,89);
        acc5.setAccountId("CC5");
        bankAccountService.addBankAccount(acc5);

        List<BanqueAccount>allAccount =bankAccountService.getListBank();

       /* for(int i=0;i<allAccount.size();i++){
            System.out.println("  "+allAccount.get(i));
        }*/

        /*for(BanqueAccount acc:allAccount){
            System.out.println(acc.toString());
        }*/

      /* allAccount.forEach(new Consumer<BanqueAccount>() {
            @Override
            public void accept(BanqueAccount account) {
                System.out.println(account.toString());
            }
        });*/


        allAccount.forEach((account)->{
            System.out.println(account.toString());
        });
        System.out.println("----============---------");
       allAccount.forEach(account->System.out.println(account.toString()));
        System.out.println("------=============------");
        allAccount.forEach(System.out::println);
        System.out.println("=========================try");
try{
        BanqueAccount accountByID = bankAccountService.getBankAccountById("CC5");
        BanqueAccount accountByID2 = bankAccountService.getBankAccountById("CC4");

        System.out.println(ConvertionJson.convertToJson( accountByID));
        System.out.println(ConvertionJson.convertToJson( accountByID2));
        System.out.println("---------------debit");

        bankAccountService.debit(accountByID.getAccountId(),10);
    System.out.println(ConvertionJson.convertToJson( accountByID));
        System.out.println("---------------transfer");

        bankAccountService.transfer(accountByID2.getAccountId(),accountByID.getAccountId(),3);

        System.out.println(ConvertionJson.convertToJson( accountByID));
        System.out.println("---------------");

}

catch(AccountNotFoundException | BalanceNotSufficientException e){
    System.out.println("Erreur ="+e.getMessage());
    //e.printStackTrace();
}
        System.out.println("=========================");
    }
}
