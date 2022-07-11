package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        // Normal Java Function
        System.out.println("Without Supplier");
        System.out.println(getDbConnectionUrl());
        // Supplier Functional Interface
        System.out.println("With Supplier");
        System.out.println(getDbConnectionUrlSupplier.get());
    }

    static Supplier<List<String>> getDbConnectionUrlSupplier =
            () -> List.of("jdbc://localhost:5432/users",
                          "jdbc://localhost:5432/products");

    static List<String> getDbConnectionUrl() {
        return List.of("jdbc://localhost:5432/users",
                "jdbc://localhost:5432/products");
    }
}
