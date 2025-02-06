package services;

import models.Cart;
import models.Product;

public class CartService {
    private Cart cart = new Cart();

    public void addProductToCart(Product product) {
        cart.addProduct(product);
        System.out.println("Added to cart: " + product.getName());
    }

    public void showCart() {
        cart.showCart();
    }
}
