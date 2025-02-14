package services;

import java.util.Scanner;

public class PaymentService {

    public void processPayment() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your card number: ");
        String cardNumber = scanner.nextLine();

        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            System.out.println("Invalid card number. Please try again.");
            return;
        }

        System.out.print("Enter the amount to pay: ");
        double amount = scanner.nextDouble();


        System.out.println("Processing payment of $" + amount + " using card: " + cardNumber);


        System.out.println("Payment successful! Thank you for your purchase.");
    }
}
