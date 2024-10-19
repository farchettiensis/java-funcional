package main.java.pedidos;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Pedaço de pizza frita", 3, 1.0);
        Item item2 = new Item("Abacate com cimento", 1, 1.0);
        Item item3 = new Item("Açaízinho", 10, 1.0);
        Item item4 = new Item("Troncho", 1, 1);
        Item item5 = new Item("Tronchinho", 1, 1);

        Order pedido1 = new Order(1, List.of(item1, item2, item3, item4, item5));

        Item item6 = new Item("Troncho", 1, 1.0);
        Item item7 = new Item("Troncho", 1, 1.0);
        Item item8 = new Item("Troncho", 1, 1.0);
        Item item9 = new Item("Troncho", 1, 1.0);
        Item item10 = new Item("Troncho", 1, 1.0);
        Item item11 = new Item("Troncho", 1, 1.0);

        Order pedido2 = new Order(2, List.of(item6, item7, item8, item9, item10, item11));

        Item item12 = new Item("Tilápia", 1, 1.0);
        Item item13 = new Item("Tilápia", 1, 1.0);
        Order pedido3 = new Order(3, List.of(item12, item13));

        Item item14 = new Item("Tilápia grelhada", 1, 1.0);
        Order pedido4 = new Order(4, List.of(item14));

        List<Order> pedidos = List.of(pedido1, pedido2, pedido3, pedido4);

//        Comparator<Order> comparadorDeValorDePedidos = Comparator.comparing(Order::getTotalOrderPrice).reversed();
//        Comparator<Order> comparadorDeValorDePedidos = (p1, p2) -> Double.compare(pedido2.getTotalOrderPrice(), pedido1.getTotalOrderPrice());
//        List<Order> pedidosOrdenados = main.java.pedidos.stream()
//                .filter(pedido -> pedido.getTotalItemsQuantity() >= 5)
//                .sorted(comparadorDeValorDePedidos)
//                .limit(3)
//                .toList();

        //        pedidosOrdenados.forEach(pedido -> {
//            System.out.printf("Id do pedido: %d%n", pedido.orderId);
//            System.out.printf("Total de itens: %d%n", pedido.getTotalItemsQuantity());
//            System.out.printf("Preço total: %.2f%n", pedido.getTotalOrderPrice());
//            System.out.println();
//        });

//        System.out.println("Id do pedido: " + pedido1.orderId);
//        System.out.println("Itens:");
//        pedido1.items.forEach(item -> System.out.println(item));
//
//        System.out.println("Total: $" + pedido1.getTotalOrderPrice());
//
//        int quantidadeTotalItens = pedido1.getTotalItemsQuantity();
//        System.out.println(quantidadeTotalItens);

        Comparator<Order> comparadorDeValorDePedidos = (p1, p2) -> Double.compare(p2.getTotalOrderPrice(), p1.getTotalOrderPrice());
        pedidos.stream()
                .filter(pedido -> pedido.getTotalItemsQuantity() >= 5)
                .sorted(comparadorDeValorDePedidos)
                .limit(3)
                .map(pedido -> String.format("Id do pedido: %d\nTotal de itens: %d\nPreço total: %.2f\n",
                        pedido.orderId, pedido.getTotalItemsQuantity(), pedido.getTotalOrderPrice()))
                .forEach(p -> System.out.println(p));

//        pedidosOrdenados.forEach(pedido -> System.out.println(pedido));
    }
}
