package main;

import repository.ProductRepository;
import services.CartService;
import services.FAQService;
import services.AddProductService;
import models.Product;

import java.sql.SQLException;
import java.util.Scanner;
public class OnlineShop {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = new ProductRepository();
        CartService cartService = new CartService();
        FAQService faqService = new FAQService();
        AddProductService addProductService = new AddProductService();  // Создаем сервис для добавления продукта
        while (true) {
            System.out.println("\n===== Online Shop Menu =====");
            System.out.println("1. Show Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Show Cart");
            System.out.println("4. Show FAQs");
            System.out.println("5. Add Product");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (Product p : productRepository.getProducts()) {
                        System.out.println(p.getId() + ". " + p.getName() + " - $" + p.getPrice());
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID to add: ");
                    int productId = scanner.nextInt();
                    Product product = productRepository.getProductById(productId);
                    if (product != null) {
                        cartService.addProductToCart(product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    cartService.showCart();
                    break;
                case 4:
                    faqService.showFAQs();
                    break;
                case 5:
                    // Вызов сервиса для добавления нового продукта
                    addProductService.addProduct();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
