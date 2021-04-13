package bank;

import java.util.Scanner;

import java.io.*;
import java.util.Random;
public class bank
public static int NewRandom(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
}
public static void main(String args[])throws IOException, InterruptedException {
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);
    Bank myBank = new Bank();
    int Option = 1, Account_Number, Account_Password, atempts = 0, Pass;
    String Name;
    double Balance, Money;
    System.out.println("Please wait, the system is starting...");
    while(Option !=5) {
        Thread.sleep(4000);
        System.out.println("1) Open a new bank account");
        Thread.sleep(250);
        System.out.println("2) Deposit to a bank account");
        Thread.sleep(250);
        System.out.println("3) Withdraw to bank account");
        Thread.sleep(250);
        System.out.println("4) Print the detailed account information including last transactions");
        Thread.sleep(250);
        System.out.println("5) Quit");       
        System.out.println();      
        System.out.print("                       Enter Option [1-5]: ");
        Option = Integer.parseInt(br.readLine());
        switch(Option) {
            case 1 : System.out.println("Enter a customer name :");
                     Name = br.readLine();
                     System.out.println("Enter a opening balance :");
                     Balance = Double.parseDouble(br.readLine());
                     Thread.sleep(250);
                     System.out.println("Creating your account....");
                     Thread.sleep(500);
                     int[] arrDetails= myBank.AddNewAccount(Name, Balance);                     
                     System.out.println("Account Has been created\n Account number: " + arrDetails[0]+"\nYour password : "+ arrDetails[1]);
                     break;
            case 2 : System.out.println("Enter a account number :");
                     Account_Number = Integer.parseInt(br.readLine());
                     System.out.println("Enter a account password :");
                     Account_Password = Integer.parseInt(br.readLine());
                     System.out.println("Enter a deposit amount :");
                     Money = Double.parseDouble(br.readLine());
                     myBank.Deposit(Account_Number, Account_Password, Money);
                     break;
            case 3 : System.out.println("Enter a account number :");
                     Account_Number = Integer.parseInt(br.readLine());
                     System.out.println("Enter a account password :");
                     Account_Password = Integer.parseInt(br.readLine());
                     System.out.println("Enter a deposit amount :");
                     Money = Double.parseDouble(br.readLine());
                     myBank.Withdraw(Account_Number, Account_Password, Money);
                     break;
            case 4 : System.out.println("Enter a account number :");
                     Account_Number = Integer.parseInt(br.readLine());
                     System.out.println("Enter a account password :");
                     Account_Password = Integer.parseInt(br.readLine());
                     myBank.Transactions(Account_Number, Account_Password);
                     break;
            case 5 : System.out.println("Please Enter your password :");
            Pass = Integer.parseInt(br.readLine());
            if(Pass == myBank.Password) {
                System.out.println("                       System shutting down.....");
                Option = 5;
                break;
            } 
            else {
                Thread.sleep(250);
                System.out.println("You have enter a wrong password. Please try again");
                Option = 0;
            }
   default: System.out.println("Invalid option. Please try again.");
}
}
}
static class Bank {
private int Password=2684;
private BankAccount[] accounts;
private int numOfAccounts;
public Bank() {
accounts = new BankAccount[100];
numOfAccounts = 0;
}
public int [] AddNewAccount(String Name, Double Balance) {
    BankAccount b = new BankAccount(Name, Balance);
    accounts[numOfAccounts] = b;
    numOfAccounts++;
    int Acc = b.getAccountNum()[0];
    int Pass = b.getAccountNum()[1];
    int[]details = {Acc, Pass};
    return details;
}
public void Withdraw(int Account_Number, int pass, double Money) {
    for (int i =0; i<numOfAccounts; i++) {     
        int a = accounts[i].getAccountNum()[0];
        if (Account_Number == a) {
            int p = accounts[i].getAccountNum()[1];
            if( pass == p) {
                accounts[i].withdraw(Money);
                return;
            }
        }   
    }  
    System.out.println("                       You have entered a wrong Account number or Password.");
}
System.out.println("                       You have entered a wrong Account number or Password.");
}
public void Deposit(int Account_Number, int pass, double Money) {  
    for (int i =0; i<numOfAccounts; i++) {     
        int a = accounts[i].getAccountNum()[0];
        if (Account_Number == a) {
            int p = accounts[i].getAccountNum()[1];
            if( pass == p) {
                accounts[i].deposit(Money);
                return;   
            }
        }   
    }  
    System.out.println("                       You have entered a wrong Account number or Password.");
}
public void Transactions(int Account_Number, int pass) {
    for(int i = 0;i<numOfAccounts; i++) {
        int a = accounts[i].getAccountNum()[0];
        if (Account_Number ==  a ) {
            int p = accounts[i].getAccountNum()[1];
            if( pass == p) {
                System.out.println(accounts[i].getAccountInfo());
                System.out.println("                        Last transaction: " + accounts[i].getTransactionInfo(accounts[i].getNumberOfTransactions()-1));
                return;
            }
        }
    }
    System.out.println("                       You have entered a wrong Account number or Password.");
}
}
}