package callback;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        hello("André", null, value -> {
            System.out.println("Last name not provided for " + value);
        });
        hello2("André", null, () -> {
            System.out.println("Last name not provided");
        });
    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }

    // JS callback function example
//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName) {
//            console.log(lastName);
//        } else {
//            callback();
//        }
//    }
//    hello("firstName", null, function() {console.log("no lastName provided")})
}
