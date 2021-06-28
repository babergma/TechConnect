package com.techelevator;

public class SavingsAccount extends BankAccount{
    public SavingsAccount() {
    }

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw){
        int postWithdrawl = (getBalance() - amountToWithdraw);
    // If the current balance is less than $150 when a withdrawal is made,
        // an additional $2 service charge is withdrawn from the account.
        if(postWithdrawl < 150 && getBalance() >=amountToWithdraw){
            super.withdraw(amountToWithdraw+ (2));
            return getBalance();
        }
        //else if, amount is more than current balance
        else if(getBalance() < amountToWithdraw){
            return getBalance();
        }
        //then withdrawl fails
        return super.withdraw(amountToWithdraw);
    }
}
