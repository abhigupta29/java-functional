package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
//        Normal Java Function
        greetCustomer(new Customer("Maria", 99999));
        greetCustomerV2(new Customer("Maria", 99999), false);

//        Consumer Functional Interface
        greetCustomerConsumer.accept(new Customer("Maria", 99999));
        greetCustomerConsumerV2.accept(new Customer("Maria", 99999), false);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello "+ customer.name +
                    ", thanks for registering phone number: " + customer.phone);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 =
            (customer, showPhone) -> System.out.println("Hello "+ customer.name +
                    ", thanks for registering phone number: " +
                    (showPhone ? customer.phone: "*******"));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello "+ customer.name +
                ", thanks for registering phone number: " + customer.phone);
    }

    static void greetCustomerV2(Customer customer, Boolean showPhone) {
        System.out.println("Hello "+ customer.name +
                ", thanks for registering phone number: " +
                (showPhone ? customer.phone: "*******"));
    }

    static class Customer {
        private final String name;
        private final int phone;

        public Customer(String name, int phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
