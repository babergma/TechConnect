package com.techelevator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] myArray = new Accountable[this.accounts.size()];
        myArray = accounts.toArray(myArray);
        return myArray;
    }

    public void addAccount(Accountable newAccount) {
        this.accounts.add(newAccount);
    }

    public boolean isVip(){
        int sum = 0;
        for(Accountable acct : accounts){
            sum+= acct.getBalance();
        }
        return sum>=25000;
    }
}
