package net.ziad;

import static net.ziad.utils.ConvertionJson.convertToJson;

import java.util.List;

import net.ziad.busness.BankAccountService;
import net.ziad.busness.BankAccountServiceImpl;
import net.ziad.busness.Condition;
import net.ziad.model.AccountStatusEnam;
import net.ziad.model.BanqueAccount;
import net.ziad.model.CurrentAcount;
import net.ziad.model.SavingAccounts;
import net.ziad.utils.ConvertionJson;

public class App4 {
    public static void main(String[] args) throws Exception {
BankAccountService bankAccountService=new BankAccountServiceImpl();
        bankAccountService.addRandomData(5);
        BanqueAccount banqueAccount1=new CurrentAcount("MAD",600,999);
        banqueAccount1.setAccountId("CC12");
        BanqueAccount banqueAccount2=new SavingAccounts("TD",300,9.99);
        banqueAccount2.setAccountId("CC1");
        bankAccountService.addBankAccount(banqueAccount1);
        bankAccountService.addBankAccount(banqueAccount2);

bankAccountService.getListBank().forEach(acc->System.out.println(convertToJson(acc)));
        System.out.println("------------------");
/*
bankAccountService.getListBank()
        .stream() //suite de donnee qui contient account
        .map(acc ->convertToJson(acc) )
        .forEach(System.out::println);*/

        try {
            BanqueAccount cc1=bankAccountService.getBankAccountById("CC12");
            System.out.println(ConvertionJson.convertToJson(cc1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println(" //declarative approche SavingAccount =");

        bankAccountService.getSavaingAccounts()
                .stream()
                .map(ConvertionJson::convertToJson).forEach(acc->System.out.println(acc));
        System.out.println(" //declarative approche CuurentAccount =");
        bankAccountService.getCurrenceAccounts()
                .stream()
                .map(ConvertionJson::convertToJson).forEach(acc->System.out.println(acc));

        System.out.println(" //balance======================================= =");
        System.out.println("totalBalance "+bankAccountService.getTotalBalance());


        System.out.println(" //SerchAccount======================================= =");

        List<BanqueAccount> banqueAccounts = bankAccountService.searchAccounts(banqueAccount->(banqueAccount.getStatus() == AccountStatusEnam.BLOKCED));

        banqueAccounts.stream()
                .map(ConvertionJson::convertToJson).forEach(System.out::println);
    }}
