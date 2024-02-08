package ATMsYstem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class ATMCard {
    private static long ATMcardNumber = generateATMnumber();
    private static String expiryDateOfCard = generateATMcardExpiryDate();
    private static int ATMpin;

    /*public static void main(String[] args) {
        ATMpinGenerator();
        ATMcardGenerator();
    }*/

    private static long generateATMnumber() {
        Random random = new Random();
        long lowerBound = 10000000000000L;
        long upperBound = 9999999999999999L;

        return Math.abs(lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound + 1)));
    }

    private static String generateATMcardExpiryDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDate = generateExpiryDate(currentDate, 2);

        // Format the expiry date using a DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return expiryDate.format(formatter);
    }

    private static LocalDate generateExpiryDate(LocalDate currentDate, int yearsToAdd) {
        Random random = new Random();

        // Add random months (between 1 and 12) to the current date
        int randomMonths = random.nextInt(12) + 1;
        LocalDate expiryDate = currentDate.plusMonths(randomMonths);

        // Add the specified number of years to the expiry date
        expiryDate = expiryDate.plusYears(yearsToAdd);

        return expiryDate;
    }

    public void ATMpinGenerator() {
        Scanner inputATM = new Scanner(System.in);

        do {
            System.out.println("Generate 4-digit ATM pin Here..\n ");
            System.out.print("Enter your New 4 digit ATM pin..");

            // Mask the PIN entry
            ATMpin = getMaskedInput(inputATM);

            System.out.println("ReEnter your 4 digit ATM pin..");

            // Mask the PIN entry
            int tempATMpin = getMaskedInput(inputATM);

            // checking tempAtm Pin and Original Entered Atm pin
            if (ATMpin == tempATMpin) {
                System.out.println("\nATM pin Generated Successfully");
                break; // Exit the loop if the pins match
            } else {
                System.out.println("\nPin doesnot Match..ReEnter ATM pin Correctly");
            }
        } while (true);
    }

    private static int getMaskedInput(Scanner scanner) {
        System.out.print("\nEnter pin: ");
        String input = scanner.next();
        return Integer.parseInt(input);
    }

    public void ATMcardGenerator() {
        // to generate ATMcard Number
        System.out.println("\nYour ATMcard Number generated Successfully.\n\nHere is your ATM Number: " + ATMcardNumber);
        // to generate expiry date
        System.out.println("\nYour ATM Card Expiry Date is : " + expiryDateOfCard);
        // ATM Pin (masked when displayed)
        System.out.println("\nYour ATM Card Pin is: " + getMaskedString(Integer.toString(ATMpin)));
    }

    private static String getMaskedString(String input) {
        return new String(new char[input.length()]).replace('\0', '*');
    }
}
