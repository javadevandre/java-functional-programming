package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(() -> "default value");
        System.out.println(value);
        Object value2 = Optional.ofNullable("hello")
                .orElseGet(() -> "default value");
        System.out.println(value2);
        Supplier<IllegalStateException> exceptionSupplier = () -> new IllegalStateException("exception thrown");
        Object value3 = Optional.ofNullable("test")
                .orElseThrow(exceptionSupplier);
        System.out.println(value3);
        Optional.ofNullable("test@test.com")
                .ifPresentOrElse(System.out::println, () -> System.out.println("no email"));
        Optional.ofNullable(null)
                .ifPresentOrElse(System.out::println, () -> System.out.println("no email"));
    }
}
