package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal Java functions
        greetCustomer(new Customer("Andre", "99999-1234"));
        greetCustomer2(new Customer("Andre", "99999-1234"), Boolean.FALSE);
        // Consumer Functional interface
        greetCustomerConsumer.accept(new Customer("Andre", "99999-1234"));
        // Bi-Consumer Functional interface
        greetCustomerBiConsumer.accept(new Customer("Andre", "99999-1234"), Boolean.FALSE);
    }

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer =
            (customer, showPhoneNumber) -> System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*****-****"));

    static void greetCustomer2(Customer customer, Boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "*****-****"));
    }

    static Consumer<Customer> greetCustomerConsumer =
            customer -> System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number " + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " + customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                    '}';
        }
    }
}
