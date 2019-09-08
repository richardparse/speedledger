package com.bankaccount.com.bankaccount.speedledger;

import java.math.BigDecimal;

import org.bson.types.ObjectId;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity
public class BankAccount {

    @Id
    private ObjectId id;
    private String number;
    private String name;
    public BigDecimal balance;
    private Boolean creditCard;
    public Boolean synthetic;

    public BankAccount() {

    }

    public BankAccount(String number, String name, BigDecimal balance, Boolean creditCard, Boolean synthetic) {
        
        this.number = number;
        this.name = name;
        this.balance = balance;
        this.creditCard = creditCard;
        this.synthetic = synthetic;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
      
        return balance;
    }

    public boolean isSynthetic() {
      
        return synthetic;
    }
}
