package util;

import java.util.Scanner;


import bank.Account;
import service.AccountService;

public class Menu {

	private static final Scanner scan = new Scanner(System.in);
	AccountService accountServ = new AccountService();

	public void accountMenu() {
		System.out.println("Welcome to the account menu. What would you like to do? \n" + "1. See an account. \n"
				+ "2. Deposit into an account. \n" + "0. Exit");

		String answer = scan.nextLine();
		try {
			switch (answer) {
			case "0":
				System.out.println("Thank you for using the banking application. Goodbye.");
				return;
			case "1":
				System.out.println("What is the account number?");
				int response = scan.nextInt();
				scan.nextLine();
				Account account = accountServ.getAccountById(response);
				System.out.println("Here is your account: " + account.toString());
				break;
			case "2":
				System.out.println("What is the account number of the account you wish to make a deposit to?");
				int depositResponse = scan.nextInt();
				scan.nextLine();
				Account depositAccount = accountServ.getAccountById(depositResponse);
				System.out
						.println("How much do you wish to deposit into account number " + depositAccount.getId() + "?");
				double deposit = scan.nextDouble();
				scan.nextLine();
				if (accountServ.depositIntoAccount(deposit, depositAccount)) {
					System.out.println("Your deposit was successful!");
				} else {
					System.out.println(
							"Something went wrong. Please varify you are making a positive deposit and try again.");
				}
				break;
			default:
				System.out.println("That is not a valid menu option. Please try again.");
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something went wrong, please check your inputs and try again.");
		}
		accountMenu();
	}

}