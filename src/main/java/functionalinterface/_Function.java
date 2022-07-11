package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Normal Java functions
        int increment = incrementByOne(0);
        System.out.println(increment);
        // Function Functional interface
        System.out.println(incrementByOneFunction.apply(0));
        // Function chaining
        Function<Integer, Integer> incrementBy1ThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyByTen);
        System.out.println(incrementBy1ThenMultiplyBy10.apply(0));
        // Bi-Function Functional interface
        System.out.println(incrementBy1AndMultiply(1,10));
        System.out.println(incrementBy1AndMultiplyBiFunction.apply(1, 10));
    }

    static BiFunction<Integer, Integer, Integer> incrementBy1AndMultiplyBiFunction =
            (num, numToMultiplyBy) -> (num + 1) * numToMultiplyBy;

    static int incrementBy1AndMultiply(int num, int numToMultiplyBy) {
        return (num + 1) * numToMultiplyBy;
    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyByTen =
            number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }
}
