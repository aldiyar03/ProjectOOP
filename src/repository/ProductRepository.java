package repository;

import models.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Laptop", 1000));
        products.add(new Product(2, "Smartphone", 700));
        products.add(new Product(3, "Headphones", 150));
    }

    public List<Product> getProducts() { return products; }
    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
