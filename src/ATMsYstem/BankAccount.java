package ATMsYstem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankAccount {

	private long accountNo = generateAccountNumber();
	private double bankBalance = 0.0;
	private String accountType;

	// default Constructor
	public BankAccount() {

	}

	// parameterized constructor
	
	public BankAccount(long accountNo, double bankBalance, String accountType, ArrayList<String> transactionHistory) {
		super();
		this.accountNo = accountNo;
		this.bankBalance = bankBalance;
		this.accountType = accountType;
		this.transactionHistory = transactionHistory;
	}

	// crating getters and setters
	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public double getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	ArrayList<String> transactionHistory = new ArrayList<>();

	public ArrayList<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setTransactionHistory(ArrayList<String> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}

	

	// to store all the transaction in an array

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", bankBalance=" + bankBalance + ", accountType=" + accountType
				+ ", transactionHistory=" + transactionHistory + "]";
	}

	// create a function for it
	public void recordFunction(String transactionType, double amount,double yourAmount) {
		String transaction = String.format("%s: Rs. %.2f || Current Balance: Rs. %.2f", transactionType, amount,yourAmount);
		transactionHistory.add(transaction);
	}

	// to generate an Customer account
	public void accountGenerator() {
		Scanner inputAc = new Scanner(System.in);
		System.out.println("Account Number generated sucessfully.\n\nHere is you Account Number: " + accountNo);
		System.out.println("Enter your Account Type(SavingsAc.,FixedAc.,SalaryAc.): ");
		accountType = inputAc.nextLine();
		System.out.println("You need to deposit Minimum of Rs.500.00 to Create an Account");
		double minAmount = 0;
		// deposit minimum of Rs.500 amount
		do {
			System.out.println("\n\nEnter the Amount You Want to deposit(Minimum Should be Rs.500): ");
			minAmount = inputAc.nextDouble();
			if (minAmount < 500) {
				System.out.println("Please Enter Minimum of Rs.500.");
			} else {
				this.bankBalance = minAmount;
				recordFunction("Deposited", minAmount, this.bankBalance);
				System.out.println("Sucessfully Created your Account. \n\nThe current Balance is: " + this.bankBalance
						+ " \n\n    Thank you ");
			}
		} while (minAmount < 500);
	}

	private static long generateAccountNumber() {
		Random random = new Random();
		long lowerBound = 10000000000L;
		long upperBound = 99999999999L;

		return Math.abs(lowerBound + random.nextLong() % (upperBound - lowerBound + 1));
	}

	public void checkBalance(double bankBalance) {
		if (bankBalance == 0) {
			System.out.println("you have zero Account balance: " + bankBalance);
		}
		if (bankBalance < 500) {
			System.out.println("you have insufficient Account balance: " + bankBalance);

		} else {
			System.out.println("your Account balance is:" + bankBalance);

		}
	}

	public void depositAmount(double bankBalance) {
		Scanner inputAmount = new Scanner(System.in);
		System.out.println("Enter Amount you want to deposit: ");
		double depositedAmount = inputAmount.nextDouble();
		System.out.println("\n\n you want to deposit Rs." + depositedAmount);
		this.bankBalance = depositedAmount + bankBalance;
		recordFunction("Deposited",depositedAmount,this.bankBalance);
		// accountdata.setBankBalance(updateBalance);
		System.out.println("\nSucessfully deposited to your Account. and the current balance is: " + this.bankBalance);

	}

	public void withdrawAmount(double bankBalance) {
		Scanner inputAmount = new Scanner(System.in);
		System.out.println("Enter Amount you want to withdraw: ");
		double withdrawAmount = inputAmount.nextDouble();
		System.out.println("\n\n you want to withdraw Rs." + withdrawAmount);
		// updateBalance=accountdata.getBankBalance();
		if (withdrawAmount <= this.bankBalance) {
			this.bankBalance -= withdrawAmount;
			recordFunction("withdrawn", withdrawAmount,this.bankBalance);
			// accountdata.setBankBalance(updateBalance);
			System.out
					.println("\nSuccessfully withdrawn from your Account. The current balance is: " + this.bankBalance);
		} else {
			System.out.println("You have insufficient Balance " + this.bankBalance + " can't be withdrawn");
		}

	}
	
	// Method to display mini statement
    public void displayMiniStatement() {
        System.out.println("\nMini Statement:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }


	/*
	 * public static void main(String[] args) { BankAccount objj=new
	 * BankAccount(); objj.accountGenerator();
	 * 
	 * }
	 */

}

/*
 * // creating an object of BankTransactions BankAccount transactionObj=new
 * BankTransactions();
 * 
 * //creating methods for deposit public void DepositAmount(int
 * depositAmount,int bankBalance){ depositAmount=((BankTransactions)
 * transactionObj).getDepositAmount();//downcasting if(depositAmount==0){
 * System.out.println("bankBalance not changed: "+bankBalance); } else{
 * bankBalance+=depositAmount;
 * System.out.println("updated bankBalance is"+bankBalance); }
 * 
 * }
 * 
 * public void WithdrawAmount(int withDrawAmount){
 * withDrawAmount=((BankTransactions) transactionObj).getWithDrawAmount();
 * if(withDrawAmount==0){
 * System.out.println("bankBalance not changed: "+bankBalance); } else{
 * bankBalance-=withDrawAmount;
 * System.out.println("updated bankBalance is"+bankBalance); }
 * 
 * }
 */
