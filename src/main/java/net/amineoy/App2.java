package net.amineoy;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.amineoy.model.BanqueAccount;
import net.amineoy.model.CurrentAcount;
import net.amineoy.model.SavingAccounts;

public class App2 {
    public static  void main(String []args) throws JsonProcessingException {


        BanqueAccount[]accounts=new BanqueAccount[4];

            accounts[0]=new CurrentAcount("145",29,233);
            accounts[1]=new CurrentAcount("568",29,34);
            accounts[2]=new SavingAccounts("776",23,78);
            accounts[3]=new SavingAccounts("8990",99,12);
            for(BanqueAccount acc:accounts) {
                System.out.println(acc);

            }
        System.out.println("=======================================List");
            List<BanqueAccount> accountList=new ArrayList<BanqueAccount>();
        accountList.add(new CurrentAcount("8909",345,45));
        accountList.add(new CurrentAcount("357",123,678));
        accountList.add(new SavingAccounts("247",789,90));
        accountList.add(new SavingAccounts("2456",87,100));

        for(BanqueAccount acc:accountList) {
            /*if(acc instanceof CurrentAcount){
                System.out.println(      ((CurrentAcount)acc).getType())  ;
            }else if (acc instanceof SavingAccounts){
              System.out.println(  ((SavingAccounts)acc).getType());
            }*/
            System.out.println(acc.getType());

                    }

        System.out.println("=======================================MAP");

        Map<String, BanqueAccount>bankMap=new HashMap<>();
        bankMap.put("cc1",new CurrentAcount());
        bankMap.put("cc2",new CurrentAcount());
        bankMap.put("cc3",new SavingAccounts());

        System.out.println("---------------------------CC1");
        BanqueAccount acc =bankMap.get("cc1");
        System.out.println(acc.toString());

        System.out.println("---------------------------KEY");
        for(String key:bankMap.keySet()){
            System.out.println(bankMap.get(key));
        }

       System.out.println("---------------------------value");
        for(BanqueAccount ba:bankMap.values()){
            System.out.println(toJson(ba));
        }
    }
    public static String toJson(Object o) throws JsonProcessingException {
    ObjectMapper objectMapper=new ObjectMapper();
    return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }


}
