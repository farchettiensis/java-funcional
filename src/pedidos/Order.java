package pedidos;

import java.util.List;

class Order {
    int orderId;
    List<Item> items;

    public Order(int orderId, List<Item> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public double getTotalOrderPrice() {
        return items.stream()
                .map(item -> item.getTotalPrice())
                .reduce(0.0, (subtotal, preco) -> subtotal + preco);
    }

    public int getTotalItemsQuantity() {
        return items.stream()
                .mapToInt(item -> item.quantity)
                .sum();
    }

}
