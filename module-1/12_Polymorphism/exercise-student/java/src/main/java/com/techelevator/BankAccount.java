package com.techelevator;


public class BankAccount implements Accountable{

    private String accountHolderName;
    private String accountNumber;
    private int balance;

    public BankAccount(String accountHolder, String accountNumber) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public BankAccount(String accountHolder, String accountNumber, int balance) {
        this.accountHolderName = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public int getBalance() {
        return balance;
    }

    public int deposit(int amountToDeposit) {
        balance = balance + amountToDeposit;
        return balance;
    }

    public int withdraw(int amountToWithdraw) {
        balance = balance - amountToWithdraw;
        return balance;
    }
    //Add the following method to allow BankAccounts to transfer money to another BankAccount
    public int transferTo(BankAccount destinationAccount, int transferAmount){
     // reduces balance by the transferAmount
        this.balance -= transferAmount;

        //calls deposit on destinationAccount object
        //deposits transfer amount using deposit method
        destinationAccount.deposit(transferAmount);

        //returns the balance
        return balance;
    }
}
