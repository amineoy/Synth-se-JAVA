package net.marouane;

import net.marouane.model.BanqueAccount;
import net.marouane.model.CurrentAcount;
import net.marouane.model.SavingAccounts;

public class Main {
    public static void main(String[] args) {


BanqueAccount account1=new CurrentAcount("zero",876,24455);

BanqueAccount account2=new SavingAccounts("zero",90,2456);
        System.out.println("account1 ="+account1);
        System.out.println("account1 ="+account1.getAccountId());
        System.out.println("account1 ="+account2);
        System.out.println("account2 ="+account2.getAccountId());
        System.out.println("-----------------------------------------------------");
account1.setAccountId(account2.getAccountId());
System.out.println("account ="+account1.getAccountId());
System.out.println(account1.equals(account2));

}}