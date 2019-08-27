package service;

import com.google.gson.Gson;
import com.bankaccount.*;
import com.bankaccount.com.bankaccount.speedledger.BankAccount;

import static spark.Spark.get;
import static spark.Spark.post;

public class Api {

    public static AccountService accountservice = new AccountService();

    public static void main(String[] args) {
        final Gson gson = new Gson();

        post("/add-account", (req, res) -> {
            res.type("application/json");
            BankAccount bankAccount = gson.fromJson(req.body(), BankAccount.class);
            return accountservice.addaccount(bankAccount);
        }, gson::toJson);

        get("/bankaccounts", (req, res) -> {
            res.type("application/json");
            return accountservice.getAllAccounts();
        }, gson::toJson);
        
        get("/bankaccounts/default", (req, res) -> {
            res.type("application/json");
            return accountservice.getDefaultAccounts();
        }, gson::toJson);
    }
}