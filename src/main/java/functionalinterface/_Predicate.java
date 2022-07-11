package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // Normal Java Function
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("+55 (41)99999-1234"));
        System.out.println(isPhoneNumberValid("+52 (41)99999-1234"));
        System.out.println(isPhoneNumberValid("+55 (41)99999-12342"));
        // Predicate Functional Interface
        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("+55 (41)99999-1234"));
        System.out.println(isPhoneNumberValidPredicate.test("+52 (41)99999-1234"));
        System.out.println(isPhoneNumberValidPredicate.test("+55 (41)99999-12342"));
        // Predicate chaining
        System.out.println("Predicate chaining");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber6).test("+55 (41)99999-1234"));
    }

    static Predicate<String> containsNumber6 =
            phoneNumber -> phoneNumber.contains("6");

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("+55 (41)") && phoneNumber.length() == 18;

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+55 (41)") && phoneNumber.length() == 18;
    }
}
