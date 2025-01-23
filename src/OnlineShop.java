package Classes;
import java.sql.*;
import java.util.Scanner;

public class OnlineShop {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/OOPEN";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "0000";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            ProductRepository productRepository = new ProductRepository(connection);
            Cart cart = new Cart();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Add Product");
                System.out.println("2. Show Products");
                System.out.println("3. Add to Cart");
                System.out.println("4. Show Cart");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        System.out.print("Product Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Price (in KZT): ");
                        double price = scanner.nextDouble();
                        productRepository.addProduct(new Product(0, name, category, price));
                        System.out.println("Product added successfully.");
                    }
                    case 2 -> {
                        System.out.println("Available Products:");
                        for (Product product : productRepository.getAllProducts()) {
                            System.out.println(product);
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter Product ID to add to cart: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        Product product = productRepository.getProductById(productId);
                        if (product != null) {
                            cart.addProduct(product, quantity);
                            System.out.println("Product added to cart.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Cart Items:");
                        cart.showCart();
                    }
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
