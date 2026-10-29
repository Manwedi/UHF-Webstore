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
}
