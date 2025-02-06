package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Your cart:");
        for (Product p : items) {
            System.out.println(p.getId() + ". " + p.getName() + " - $" + p.getPrice());
        }
    }
}
