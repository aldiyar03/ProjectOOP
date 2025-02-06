package models;

public class OrderDetails {
    private int orderId;
    private int productId;
    private int quantity;

    public OrderDetails(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() { return orderId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
}
