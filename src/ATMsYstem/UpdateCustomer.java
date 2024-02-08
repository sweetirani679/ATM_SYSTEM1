package ATMsYstem;

import java.util.Scanner;

public class UpdateCustomer {
	
	BankAccount accountdata;
	Customer customerData;
	ATMCard ATMData;
	public void updateCustomer(){}

    public UpdateCustomer() {
        // Initialize the BankAccount object
        accountdata = new BankAccount();
        customerData = new Customer();
        ATMData = new ATMCard();
    }
	public void updateCustomerDetails(){
		Scanner inputUpdate = new Scanner(System.in);
		System.out.println("Enter your Account number to update: ");
		long AccountNumToUpdate=inputUpdate.nextLong();
		
		if(AccountNumToUpdate!=accountdata.getAccountNo()){
			System.out.println("You Didn't have Any Account,Please Create an Account.");
		}else{
			System.out.println("Welcome "+customerData.getCustomerName());
			System.out.println("Enter Name of the Field name you want to Update (Name,Aadhar Number,Address or ATMpin) ");
			String updateField=inputUpdate.nextLine();
			if(updateField=="Name"){
				System.out.println("Enter your New name : ");
				String newCustomerName=inputUpdate.nextLine();
				customerData.setCustomerName(newCustomerName);
				System.out.println("data updated Sucessfully..Here is your New name"+customerData.getCustomerName());
			}
			
			if(updateField=="Aadhar Number"){
				System.out.println("Enter your New Aadhar Number : ");
				long newCustomerAadharNumber=inputUpdate.nextLong();
				customerData.setCustomerAadharNumber(newCustomerAadharNumber);
				System.out.println("data updated Sucessfully..Here is your New name"+customerData.getCustomerAadharNumber());
			}
			if(updateField=="Address"){
				System.out.println("Enter your New Address : ");
				String newCustomerAddress=inputUpdate.nextLine();
				customerData.setCustomerAddrress(newCustomerAddress);;
				System.out.println("data updated Sucessfully..Here is your New name"+customerData.getCustomerAddrress());
			}
			if(updateField=="ATMpin"){
			
				ATMData.ATMpinGenerator();
				
			}
			else{
				System.out.println("Field Name Does not match..Reenter Field Name");
			}
			//database code
		}
		
	}
	/*public static void main(String[] args) {
		
		UpdateCustomer objjj = new UpdateCustomer();
		
		objjj.updateCustomerDetails();
		
	}*/
}
