package com.techelevator;

public class CheckingAccount extends BankAccount{
    public CheckingAccount() {
    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int postWithdrawl = (getBalance() - amountToWithdraw);
//postwith is > -100 && balance is less than 0
        if(postWithdrawl > -100 && getBalance() < 0){
            //then withdraw $10 and the amount
            super.withdraw(amountToWithdraw + (10));
            //and return balance
            return getBalance();
        }
        //check if balance is <= -100
        else if(getBalance() <= -100){
        return getBalance();
        }
        //otherwise withdraw the amount
        return super.withdraw(amountToWithdraw);

    }

}
