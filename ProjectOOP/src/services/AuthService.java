package services;

import java.util.Scanner;

public class AuthService {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}
