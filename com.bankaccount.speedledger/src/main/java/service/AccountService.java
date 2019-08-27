package service;

import com.bankaccount.com.bankaccount.speedledger.BankAccount;
import com.mongodb.MongoClient;



import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class AccountService extends BankAccount {

    MongoClient client = new MongoClient("localhost", 27017);
    Datastore datastore = new Morphia().createDatastore(client, "bankAccount");

    public String addaccount(BankAccount account) {
        datastore.save(account);
        return "add account";
    }

    public List<BankAccount> getAllAccounts() {
       List<BankAccount> list = datastore.find(BankAccount.class).asList();
        if (list != null) {
            return list;
        }
        return null;
    }
    
    public List<BankAccount> getDefaultAccounts() {
        List<BankAccount> list = datastore.find(BankAccount.class).asList();
        if (list != null) {
            if (synthetic == false && balance >= 0) {
                return list;
            }
            return null;
        }
        return null;
    }
}
