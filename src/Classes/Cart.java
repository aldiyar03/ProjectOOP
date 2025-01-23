package Classes;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public void showCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            double total = 0;
            System.out.println("ID | Name        | Category   | Price (KZT) | Quantity | Total (KZT)");
            System.out.println("--------------------------------------------------------------");
            for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                double cost = product.getPrice() * quantity;
                total += cost;
                System.out.printf("%-3d| %-11s| %-11s| %-12.2f KZT| %-9d| %.2f KZT%n",
                        product.getId(), product.getName(), product.getCategory(), product.getPrice(), quantity, cost);
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("Total Price: " + total + " KZT");
        }
    }
}
