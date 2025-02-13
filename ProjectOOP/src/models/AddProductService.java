package services;

import repository.ProductRepository;

import java.util.Scanner;

public class AddProductService {

    private ProductRepository productRepository;

    public AddProductService() {
        this.productRepository = new ProductRepository();
    }


    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product description: ");
        scanner.nextLine();
        String description = scanner.nextLine();


        productRepository.addProduct(name, price, description);
        System.out.println("Product added successfully.");
    }
}
