package net.amineoy;

import static net.amineoy.utils.ConvertionJson.convertToJson;

import java.util.List;

import net.amineoy.busness.BankAccountService;
import net.amineoy.busness.BankAccountServiceImpl;
import net.amineoy.busness.Condition;
import net.amineoy.model.AccountStatusEnam;
import net.amineoy.model.BanqueAccount;
import net.amineoy.model.CurrentAcount;
import net.amineoy.model.SavingAccounts;
import net.amineoy.utils.ConvertionJson;

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
