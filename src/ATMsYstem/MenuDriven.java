package ATMsYstem;


import java.sql.*;
import java.util.Scanner;

public class MenuDriven {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Customer customer = new Customer();
        BankAccount customerBankDetails=new BankAccount();
        UpdateCustomer update=new UpdateCustomer();
        Scanner scanner = new Scanner(System.in);

        
           int choice;
            do {
            	System.out.println("\n\n-------------------------------------------");
                System.out.println("1. To Create A new  Customer  Account");
                System.out.println("2. To Check Account Balance ");
                System.out.println("3. To Deposit  Amount ");
                System.out.println("4. To WithDraw Amount ");
                System.out.println("5. To Update Account Customer Details  ");
                System.out.println("6. To Create Mini StateMent");
                System.out.println("7. Exit");
                System.out.println("-------------------------------------------");
                System.out.print("Enter your Choice (1-6): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    	customer.CreateCustomer();
                        break;
                    case 2:
                    	customerBankDetails.checkBalance(customerBankDetails.getBankBalance());
                        break;
                    case 3:
                    	customerBankDetails.depositAmount(customerBankDetails.getBankBalance());
                        break;
                    case 4:
                    	customerBankDetails.withdrawAmount(customerBankDetails.getBankBalance());
                        break;
                    case 5:
                    	update.updateCustomerDetails();
                        break;
                    case 6:
                        customerBankDetails.displayMiniStatement();
                        break;
                    case 7:
                    	System.out.println("Exiting the program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } while (choice != 7);
    }
}
