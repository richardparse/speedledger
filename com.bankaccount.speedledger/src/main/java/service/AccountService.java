package service;

import com.bankaccount.com.bankaccount.speedledger.BankAccount;
import com.mongodb.MongoClient;

import java.math.BigDecimal;
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
        this.getBankAccount(list);
        return list;

    }

    public BankAccount getBankAccount(List<BankAccount> bankAccounts) {
        int counter = 0;
        BankAccount highestBalanceBankAccount = null;
        // checks account balance
        for (BankAccount bankAccount : bankAccounts) {
            // If there is only one bank account, the id of the account will be returned.
            // Synthetic accounts can never be chosen as
            // default accounts.
            if (bankAccounts.size() == 1 && !bankAccount.isSynthetic()
                    && bankAccount.getBalance().compareTo(BigDecimal.ZERO) > 0) {

                return bankAccount;
            }
            
            if (counter == 0) {
                highestBalanceBankAccount = bankAccount;

            }
            
            if (counter != 0 && highestBalanceBankAccount.getBalance().compareTo(bankAccount.getBalance()) == 1) {
                
            } else {
                // If it executes this statement means that we have a creater balance
                highestBalanceBankAccount = bankAccount;

            }

            counter++;

        }

        BigDecimal two = new BigDecimal("2");
        // half of the highest value
        BigDecimal metadeValorMaior = highestBalanceBankAccount.getBalance().divide(two);
        return highestBalanceBankAccount;
    }
}