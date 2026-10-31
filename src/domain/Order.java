/**
 * MANWEDI CLAUDE
 * URBAN HATCH FARMS ONLINE STORE
 */

package domain;

import java.time.LocalDateTime;

public class Order {
    private final String orderId;
    private final String customerName;
    private final String batchId;
    private final int quantity;
    private final double totalPrice;
    private final LocalDateTime orderDate;
    private OrderStatus status;

    public Order(String orderId, String customerName, String batchId, int quantity, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.batchId = batchId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBatchId() {
        return batchId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return " Order { " +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", batchId='" + batchId + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}


