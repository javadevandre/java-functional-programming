package combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "André",
                "andre@test.com",
                "+55 (41) 99999-1234",
                LocalDate.of(1986,3, 8)
        );
        // Without Combinator Pattern
        System.out.println(new CustomerValidatorService().isCustomerValid(customer));
        // Combinator Pattern
        CustomerRegistrationValidator.ValidationResult result = CustomerRegistrationValidator
                .isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
                .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);
        System.out.println(result);
        if (result != CustomerRegistrationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
