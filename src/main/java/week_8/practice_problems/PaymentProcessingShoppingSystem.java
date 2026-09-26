package week_8.practice_problems;

import java.util.ArrayList;

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Payment processed through Credit Card.");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Payment processed through PayPal.");
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        System.out.println("Payment processed through Bank Transfer.");
        return true;
    }
}

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    Product product;
    int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double total() {
        return product.price * quantity;
    }
}

class OrderCustomer {
    String name;

    public OrderCustomer(String name) {
        this.name = name;
    }
}

class Order {
    private OrderCustomer customer;
    private ArrayList<OrderItem> items = new ArrayList<>();
    private String status = "Pending";

    public Order(OrderCustomer customer) {
        this.customer = customer;
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public void pay(PaymentMethod method) {

        if (items.isEmpty()) {
            System.out.println(
                    "Cannot process payment for an empty order.");
            return;
        }

        double amount = 0;

        for (OrderItem item : items)
            amount += item.total();

        System.out.println("Payment initiated via "
                + method.getClass().getSimpleName()
                + " for Order " + customer.name + ".");

        if (method.processPayment(amount)) {
            status = "Paid";
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class PaymentProcessingShoppingSystem {
    public static void main(String[] args) {

        OrderCustomer x = new OrderCustomer("Customer X");
        Order orderX = new Order(x);

        orderX.addItem(new Product("Product A", 100), 2);
        orderX.addItem(new Product("Product B", 50), 1);

        System.out.println("Order created for Customer X.");
        orderX.pay(new CreditCardPayment());

        OrderCustomer y = new OrderCustomer("Customer Y");
        Order orderY = new Order(y);

        System.out.println("Order created for Customer Y.");
        orderY.pay(new CreditCardPayment());

        OrderCustomer z = new OrderCustomer("Customer Z");
        Order orderZ = new Order(z);

        orderZ.addItem(new Product("Product C", 200), 1);

        System.out.println("Order created for Customer Z.");
        orderZ.pay(new PayPalPayment());
    }
}
